package net.ssm.system.web.dao;

import java.util.List;

import net.ssm.system.web.pojo.RoleMenuVo;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    RoleMenuVo selectSysMenuByRoleId(Long roleId);
}