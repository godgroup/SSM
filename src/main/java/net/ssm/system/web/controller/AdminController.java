package net.ssm.system.web.controller;

import java.util.List;

import javax.annotation.Resource;

import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("userlist")
	public ModelAndView index(){
		 List<SysUser> itemsList = sysUserService.GetUser();
		

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("admin/userlist");

        return modelAndView;
		
	} 
	
}
