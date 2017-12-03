package net.ssm.system.web.service.impl;

import net.ssm.system.web.dao.SysUserMapper;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
	@Resource
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public String GetUserName(Long id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		
		return sysUser.getName();
	}

	@Override
	public List<SysUser> GetUser() {
		List<SysUser>  userList = sysUserMapper.selectSysUser();
		
		return userList;
	}

	@Override
	public SysUser LogonValidate(String loginName, String pswd) {
		return sysUserMapper.selectByNameAndPswd(loginName, pswd);
	}

}
