package net.ssm.system.web.controller;

import java.util.List;

import javax.annotation.Resource;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Resource
	private SysMenuService sysMenuService;
	@RequestMapping("menulist")
	public ModelAndView index(){
		 List<SysMenu> itemsList = sysMenuService.GetMenuList();
		

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("menu/menulist");

        return modelAndView;
		
	} 
	@RequestMapping("addMenu")
	public void addMenu(){}
}
