package net.ssm.system.web.dao;

import java.util.List;

import net.ssm.system.web.pojo.SysRole;

public interface SysRoleMapper {
	List<SysRole> selectSysRoleList();
	
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}