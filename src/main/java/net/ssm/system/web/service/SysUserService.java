package net.ssm.system.web.service;

import net.ssm.system.web.pojo.SysUser;

import java.util.List;

public interface SysUserService {
	/**
	 * 获取用户名称
	 * @param id 用户ID
	 * @return
	 */
	String GetUserName(Long id);
	SysUser selectByPrimaryKey(Long id);
	

	List<SysUser> GetUser();
	
	/**
	 * 登录验证
	 * @param loginName 登录名
	 * @param pswd 密码，加密后的密文
	 * @return
	 */
	SysUser LogonValidate(String loginName,String pswd);
}
