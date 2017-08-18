package net.ssm.system.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ssm.system.web.dao.SysUserMapper;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	@Resource
	private SysUserMapper sysUserMapper;
	
	@Override
	public String GetUserName(Long id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		
		return sysUser.getUsername();
	}

}
