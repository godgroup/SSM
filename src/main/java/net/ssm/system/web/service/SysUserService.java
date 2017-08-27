package net.ssm.system.web.service;

import java.util.List;

import net.ssm.system.web.pojo.SysUser;

public interface SysUserService {
	/**
	 * 获取用户名称
	 * @param id 用户ID
	 * @return
	 */
	String GetUserName(Long id);
	
	

	List<SysUser> GetUser();
}
