package net.ssm.system.web.controller;


import java.util.List;

import javax.annotation.Resource;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;
import net.ssm.system.web.service.SysRoleMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("menu")
public class RoleMenuController {
	@Resource
	private SysRoleMenuService sysRoleMenuService;
	@Resource
	private SysMenuService sysMenuService;
    @RequestMapping("roleMenu")
    public ModelAndView setRoleMenu(Long roleId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", "shenxy");
        List<SysMenu> menuList=sysRoleMenuService.selectSysMenuByRoleId(1l);
        List<Node> nodelist=   sysMenuService.getNodeList(null, null, menuList);
        String nodeJsonString=  JSON.toJSONString(nodelist);
        modelAndView.addObject("nodelist", nodeJsonString);
        modelAndView.setViewName("role/roleMenu");

        return modelAndView;
    }
}
