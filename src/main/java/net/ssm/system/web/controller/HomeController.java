package net.ssm.system.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ssm.system.web.service.SysUserService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("index")
	public void index(){}
	
	@RequestMapping("getUserName")
	@ResponseBody
	public Map<String,Object> getUserName()
	{
		Map<String,Object> result = new HashMap<>();
		String userName = sysUserService.GetUserName(Long.parseLong("1"));
		
		result.put("success",true);
		result.put("username",userName);
		
		return result;
	}
}
