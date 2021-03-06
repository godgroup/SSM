package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysUserRole;
import net.ssm.system.web.pojo.UserRoleVo;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRole key);
    int deleteByuid(Long uid);
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
    int insertBatch(List<SysUserRole> record);
    UserRoleVo selectSysRoleByuid(Long uid);
}