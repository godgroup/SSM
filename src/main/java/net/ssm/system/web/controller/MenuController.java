package net.ssm.system.web.controller;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Resource
	private SysMenuService sysMenuService;

	/**
	 * 返回菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "menulist", method = RequestMethod.GET)
	public ModelAndView index() {
		List<SysMenu> itemsList = sysMenuService.GetMenuList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名itemsList.jsp
		modelAndView.setViewName("menu/menulist");

		return modelAndView;

	}
    
	@RequestMapping("addMenu")
	public ModelAndView addMenu(Long id) {
		ModelAndView modelAndView = new ModelAndView();
		SysMenu menu=new SysMenu();
		if(id!=null)
		{
			menu=sysMenuService.selectByPrimaryKey(id);
			System.out.println(menu.getParent_id());
		}
		modelAndView.addObject("item", menu);
		modelAndView.setViewName("menu/addMenu");

		return modelAndView;
	}

	/**
	 * 获取菜单树
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getNodes", method = RequestMethod.GET)
	public List<Node> getNodes(Long id,Integer type) {

		List<SysMenu> itemsList = sysMenuService.GetMenuList();//菜单列表
		SysUser sysUser=(SysUser) SecurityUtils.getSubject().getSession().getAttribute("user");
		if(type!=null&&type==1)
		{
			itemsList=sysMenuService.selectSysMenuListByuid(sysUser.getId());
		}
		List<Node> list = new ArrayList<Node>();//递归好的菜单列表
		list=sysMenuService.getNodeList(id,type,itemsList);
		
		return list;
	}


	@ResponseBody
	@RequestMapping(value = "addSysMenu", method = RequestMethod.POST)
	public Map<String, Object> addSysMenu(@RequestBody SysMenu menu) {
		Map<String, Object> resultmap = new HashMap<String, Object>();

		int ret=-1;
		boolean result=false;
		String msg="操作失败";
		if(menu.getParent_id()==null)
			menu.setParent_id((long) 0);
		if(menu.getId()==null)
		{
			//插入
			ret = sysMenuService.insert(menu);	
			if (ret > 0)
			{
				msg="添加成功";
				result=true;
			}
			
		}
		else {
			//修改
			ret = sysMenuService.updateByPrimaryKeySelective(menu);	
			if (ret > 0)
			{
				msg="修改成功";
				result=true;
			}
				
		}
		 
		resultmap.put("result", result);
		resultmap.put("msg", msg);
		 
		return resultmap;
	}
}
