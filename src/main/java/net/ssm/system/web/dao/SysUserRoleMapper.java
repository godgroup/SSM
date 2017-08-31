package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRole key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}