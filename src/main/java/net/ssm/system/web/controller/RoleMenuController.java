package net.ssm.system.web.controller;


import com.alibaba.fastjson.JSON;
import net.ssm.system.web.pojo.RoleMenuVo;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysRoleMenu;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;
import net.ssm.system.web.service.SysRoleMenuService;
import net.ssm.system.web.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("roleMenu")
public class RoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;
    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysRoleService sysRoleService;
    /**
     * 加载设置角色权限页面
     * @param roleId 权限id
     * @return
     */
    @RequestMapping(value="setRoleMenu",method = RequestMethod.GET)
    public ModelAndView setRoleMenu(Long roleId) {
        ModelAndView modelAndView = new ModelAndView();
        //获取角色详情
        // SysRole  role=sysRoleService.selectByPrimaryKey(roleId);
        //获取角色对应的权限列表
        RoleMenuVo rolevo = sysRoleMenuService.selectSysMenuByRoleId(roleId);
        modelAndView.addObject("rolename", rolevo.getRoleName());
        modelAndView.addObject("roleid", rolevo.getRoleId());
        List<SysMenu> roleMenuList=null;
        if(rolevo!=null)//如果设置过权限
        {
            roleMenuList = rolevo.getRoleMenuList();
        }
        //获取全部的权限列表(并将已经设置过的权限复选框打钩)
        List<Node> nodelist = sysMenuService.getNodeList(null, null, sysMenuService.GetMenuList(), roleMenuList);
        String nodeJsonString = JSON.toJSONString(nodelist);

        modelAndView.addObject("nodelist", nodeJsonString);
        modelAndView.setViewName("role/roleMenu");

        return modelAndView;
    }

    /**
     * 设置角色的权限
     * @param roleId
     * @param roleName
     * @param menus
     * @return
     */
    @ResponseBody
    @RequestMapping(value="doSetRoleMenu",method = RequestMethod.POST)
    public Map<String,Object> doSetRoleMenu(Long roleId,String roleName,String menus) {
        Map<String,Object>resultmap=new HashMap<String,Object>();
        List<SysRoleMenu> list= new ArrayList<>();
        String[] mensArray = menus.split(",");
        for (int i = 0; i <mensArray.length ; i++) {
            SysRoleMenu roleMenu=new SysRoleMenu();
            roleMenu.setSys_role_id(roleId);
            roleMenu.setSys_menu_id(Long.parseLong( mensArray[i]));
            list.add(roleMenu);
        }
        sysRoleMenuService.deleteByRoleId(roleId);
        int IsSucess=  sysRoleMenuService.insertBatch(list);
        if(IsSucess>0) {
            resultmap.put("result", true);
            resultmap.put("msg", "设置成功");
        }
        else {
            resultmap.put("result", false);
            resultmap.put("msg", "设置失败");

        }
        return resultmap;
    }
}
