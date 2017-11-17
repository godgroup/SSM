package net.ssm.system.web.controller;


import java.util.List;

import javax.annotation.Resource;

import net.ssm.system.web.pojo.RoleMenuVo;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;
import net.ssm.system.web.service.SysRoleMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("roleMenu")
public class RoleMenuController {
	@Resource
	private SysRoleMenuService sysRoleMenuService;
	@Resource
	private SysMenuService sysMenuService;
    @RequestMapping("setRoleMenu")
    public ModelAndView setRoleMenu(Long roleId) {
        ModelAndView modelAndView = new ModelAndView();

         RoleMenuVo role=sysRoleMenuService.selectSysMenuByRoleId(roleId);
         List<SysMenu> roleMenuList= role.getRoleMenuList();
        List<Node> nodelist=   sysMenuService.getNodeList(null, null,  sysMenuService.GetMenuList(),roleMenuList);
        String nodeJsonString=  JSON.toJSONString(nodelist);
        modelAndView.addObject("rolename",role.getRoleName() );
        modelAndView.addObject("nodelist", nodeJsonString);
        modelAndView.setViewName("role/roleMenu");

        return modelAndView;
    }
}
