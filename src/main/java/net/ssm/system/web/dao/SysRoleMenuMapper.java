package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenu key);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);
}