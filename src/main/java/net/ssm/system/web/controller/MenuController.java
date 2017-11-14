package net.ssm.system.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import net.ssm.config.SysConfig;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		List<Node> nodelist = new ArrayList<Node>();//转换为node
		for (SysMenu menu : itemsList) {
			if(id!=null&& menu.getId()==id)
			{
				continue;//编辑菜单时，菜单树里过滤掉自己的id(自己不能设置父菜单为自己)
			}
			Node node=new Node();
			node.setTitle(menu.getName());
			node.setId(menu.getId());
			node.setName(menu.getName());
			node.setParentid(menu.getParent_id());
			if(type!=null&&type==1)//加载左侧菜单列表时需要设置href,添加菜单时的tres不需要设置href
			{
				if(SysConfig.getContextPath()!=null)
				  node.setHref(SysConfig.getContextPath()+menu.getHref());
				else
					node.setHref(SysConfig.getContextPath() + menu.getHref());
				node.setIcon(menu.getIcon());
			}
			
			nodelist.add(node);
		}
		List<Node> list = new ArrayList<Node>();//递归好的菜单列表
		for (Node item : nodelist) {
			if (item.getParentid() == 0) {
				item.setChildren(addchild(item.getId(),nodelist));
				list.add(item);
			}
		}
		return list;
	}
	/**
	 * 递归查出指定Parentid的子菜单
	 * @param parentId
	 * @param nodelist
	 * @return
	 */
	private List<Node> addchild(Long parentId,List<Node>  nodelist) {
		List<Node> childList = new ArrayList<Node>();//子菜单列表
		for (Node node : nodelist) {
			if (node.getParentid() == parentId) {
			    node.setChildren(addchild(node.getId(), nodelist));
				childList.add(node);
			}
		}
		return childList;
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
