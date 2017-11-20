package net.ssm.system.web.controller;

import net.ssm.system.web.pojo.*;
import net.ssm.system.web.service.SysRoleService;
import net.ssm.system.web.service.SysUserRoleService;
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

/**
 * 用户角色
 */
@Controller
@RequestMapping("userRole")
public class AdminRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 展示用户的角色列表
     * @param uid
     * @return
     */
    @RequestMapping(value="setUserRole",method = RequestMethod.GET)
    public ModelAndView setRoleMenu(Long uid) {
        ModelAndView modelAndView = new ModelAndView();
        //获取用户对应的角色列表
        UserRoleVo userRoleVo = sysUserRoleService.selectSysRoleByuid(uid);
        List<SysRole> itemsList = sysRoleService.GetRoleList();
        List<SysRoleVo> itemsListVo=new ArrayList<SysRoleVo>();

        for(SysRole item :itemsList)
        {
            SysRoleVo one=new SysRoleVo();
            one.setId(item.getId());
            one.setName(item.getName());
            one.setChecked(0);
            if(userRoleVo!=null&&userRoleVo.getRoleList()!=null)
            {
                for (SysRole role : userRoleVo.getRoleList())
                {
                    if(item.getId()==role.getId())
                    {
                        one.setChecked(1);
                        break;
                    }
                }
            }

            itemsListVo.add(one);
        }
        modelAndView.addObject("userRoleVo", userRoleVo);
        modelAndView.addObject("itemsListVo", itemsListVo);
        modelAndView.setViewName("role/userRole");

        return modelAndView;
    }

    /**
     * 设置用户的角色
     * @param roleId
     * @param roleName
     * @param menus
     * @return
     */
    @ResponseBody
    @RequestMapping(value="doSetUserRole",method = RequestMethod.POST)
    public Map<String,Object> doSetRoleMenu(Long uid,String roles) {
        Map<String,Object>resultmap=new HashMap<String,Object>();
        if(uid==null|| roles=="")
        {
            resultmap.put("result", false);
            resultmap.put("msg", "参数有误");
            return resultmap;
        }
        List<SysUserRole> list= new ArrayList<>();
        String[] rolesArray = roles.split(",");
        for (int i = 0; i <rolesArray.length ; i++) {
            SysUserRole userRole=new SysUserRole();
            userRole.setSys_user_id(uid);
            userRole.setSys_role_id(Long.parseLong(rolesArray[i]));
            list.add(userRole);
        }
        //删除已经设置的角色
        sysUserRoleService.deleteByuid(uid);
        int IsSucess=  sysUserRoleService.insertBatch(list);
        if(IsSucess>0) {
            resultmap.put("result", true);
            resultmap.put("msg", "设置角色成功");
        }
        else {
            resultmap.put("result", false);
            resultmap.put("msg", "设置角色失败");

        }
        return resultmap;
    }
}
