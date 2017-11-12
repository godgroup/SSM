package net.ssm.system.web.service;

import net.ssm.system.web.pojo.SysRoleMenu;

public interface SysRoleMenuService {
	  int deleteByPrimaryKey(SysRoleMenu key);

	  int insert(SysRoleMenu record);

	  int insertSelective(SysRoleMenu record);
	  
	  
}
