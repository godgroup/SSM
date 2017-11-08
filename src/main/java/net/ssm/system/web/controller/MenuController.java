package net.ssm.system.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysUser;
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
	 * @return
	 */
	@RequestMapping(value="menulist",method=RequestMethod.GET)
	public ModelAndView index(){
		 List<SysMenu> itemsList = sysMenuService.GetMenuList();
		 ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("menu/menulist");

        return modelAndView;
		
	} 
	@RequestMapping("addMenu")
	public void addMenu(){
		
	
	}
	@ResponseBody
	@RequestMapping(value="getNodes",method=RequestMethod.GET)
	public Node getNodes(){
		Node node=new Node();
		node.setName("用户管理");
		node.setId(1);
	
		Node node1=new Node();
		
		node1.setName("用户列表");
		node1.setId(2);
		node.setChildren(node1);
		return node;
	}
	
	
	@ResponseBody
	@RequestMapping(value="addSysMenu",method=RequestMethod.POST)
	public Map<String,Object> addSysMenu(@RequestBody SysMenu menu){
		Map<String,Object> result = new HashMap<String,Object>();
		
		System.out.println(menu.getIcon());
		int ret=sysMenuService.insert(menu);
		if(ret>0)
		{
			result.put("result", true);
			result.put("msg", "添加成功");
		}
		else {
			result.put("result", false);
			result.put("msg", "添加失败");
		}
		return result;
	}
}
