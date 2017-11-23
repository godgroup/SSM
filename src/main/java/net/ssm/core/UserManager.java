package net.ssm.core;

import net.ssm.system.web.pojo.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * 用户session管理类
 */
public class UserManager {
    public static SysUser getCurrentSysUser(){
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("user");

        return sysUser ;
    }
}
