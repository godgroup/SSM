package net.ssm.system.web.service;

import java.util.List;


import net.ssm.system.web.pojo.SysRole;

public interface SysRoleService {
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<SysRole> GetRoleList();
	
	int insert(SysRole Role);
	
	SysRole selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SysRole role);
}
