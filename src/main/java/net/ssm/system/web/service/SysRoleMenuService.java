package net.ssm.system.web.service;

import java.util.List;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysRoleMenu;

public interface SysRoleMenuService {
	  int deleteByPrimaryKey(SysRoleMenu key);

	  int insert(SysRoleMenu record);

	  int insertSelective(SysRoleMenu record);
	  
	  List<SysMenu>  selectSysMenuByRoleId(Long roleId);
	  
}
