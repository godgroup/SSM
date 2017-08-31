package net.ssm.system.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;

import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysUserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping("userlist2")
	public ModelAndView index2(){
		 List<SysUser> itemsList = sysUserService.GetUser();
		

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("admin/userlist");

        return modelAndView;
		
	} @RequestMapping("userlist3")
	public ModelAndView index3(){
		 List<SysUser> itemsList = sysUserService.GetUser();
		

       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("itemsList",itemsList);
       //指定逻辑视图名itemsList.jsp
       modelAndView.setViewName("admin/userlist");

       return modelAndView;
		
	} 
	/**
	 * 登录页面
	 */
	@RequestMapping("login")
	public void login(){}
	
	/**
	 * 登录验证
	 * @param loginName 登录名
	 * @param pswd 密码
	 * @return
	 */
	@RequestMapping("loginValidate")
	@ResponseBody
	public Map<String,Object> loginValidate(String loginName,String pswd){
		Map<String,Object> result = new HashMap<String,Object>();
		
		if (StringUtils.isBlank(loginName)) {
			result.put("success",false);
			result.put("data","登录名为空");
			return result;
		}
		if (StringUtils.isBlank(pswd)) {
			result.put("success",false);
			result.put("data","密码为空");
			return result;
		}
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginName,pswd,false);
		
		try{
			subject.login(token);
			result.put("success",true);
		}catch(UnknownAccountException e){
			result.put("data",e.getMessage());
			result.put("success",false);
		}
		return result;
	}
}
