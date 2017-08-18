package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysUser;

public interface SysUserMapper {
	/**
	 * 通过ID获取用户
	 * @param id
	 * @return
	 */
	SysUser selectByPrimaryKey(Long id);
}
