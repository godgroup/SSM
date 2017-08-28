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
	
	/**
	 * 登录验证
	 * @param loginName 登录名
	 * @param pswd 密码，加密后的密文
	 * @return
	 */
	SysUser LogonValidate(String loginName,String pswd);
}
