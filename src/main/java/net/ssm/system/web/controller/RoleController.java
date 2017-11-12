package net.ssm.system.web.controller;

import java.util.List;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysRole;
import net.ssm.system.web.service.SysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 返回菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "rolelist", method = RequestMethod.GET)
	public ModelAndView index() {
		List<SysRole> itemsList = sysRoleService.GetRoleList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名itemsList.jsp
		modelAndView.setViewName("role/rolelist");

		return modelAndView;

	}
}
