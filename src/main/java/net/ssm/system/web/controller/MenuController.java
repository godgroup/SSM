package net.ssm.system.web.controller;

import java.util.ArrayList;
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
	static List<Node> configlist=new  ArrayList<Node>();
	static{
		
		Node node=new Node();
		node.setName("用户管理");
		node.setId(1);
		node.setParentid(0);
		Node node1=new Node();
		node1.setName("企业用户");
		node1.setId(10);
		node1.setParentid(1);
		Node node2=new Node();
		node2.setName("个人用户");
		node2.setId(11);
		node2.setParentid(1);
		Node node6=new Node();
		node6.setName("三级用户");
		node6.setId(31);
		node6.setParentid(11);
		
		Node node3=new Node();
		node3.setName("借书管理");
		node3.setId(2);
		node3.setParentid(0);
		Node node4=new Node();
		node4.setName("借书列表");
		node4.setId(20);
		node4.setParentid(2);
		Node node5=new Node();
		node5.setName("还书列表");
		node5.setId(21);
		node5.setParentid(2);
		Node node7=new Node();
		node7.setName("菜单管理");
		node7.setId(3233);
		node7.setParentid(0);
		configlist.add(node);
		configlist.add(node1);configlist.add(node2);
		configlist.add(node3);
		configlist.add(node4);configlist.add(node5);
		configlist.add(node6);configlist.add(node7);
	}
	
	@ResponseBody
	@RequestMapping(value="getNodes",method=RequestMethod.GET)
	public List<Node> getNodes(){
		
		
		
		List<Node> list=new ArrayList<Node>();
		for (Node item : configlist) {
			if(item.getParentid()==0)
			{
				item.setChildren(addchild(item.getId()));
				list.add(item);
				
			}
		}
		
		
		
//		
//		Node node=new Node();
//		node.setName("用户管理");
//		node.setId(1);
//	
//		Node node1=new Node();
//		node1.setName("用户列表");
//		node1.setId(2);
//		
//		List<Node> list1=new ArrayList<Node>();
//		list1.add(node1);
//		node.setChildren(list1);
//		list.add(node);
		return list;
	}
	private List<Node> addchild(int id) {
		List<Node> list=new ArrayList<Node>();
		for (Node node : configlist) {
			if(node.getParentid()==id)
			{
				
				node.setChildren(addchild(node.getId()));
				list.add(node);
			}
		} 
		return list;
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
