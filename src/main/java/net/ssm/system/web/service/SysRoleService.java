package net.ssm.system.web.service;

import net.ssm.system.web.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<SysRole> GetRoleList();

	int insert(SysRole Role);
	
	SysRole selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SysRole role);

	int updateByPrimaryKey(SysRole record);
}
