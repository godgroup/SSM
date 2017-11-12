package net.ssm.system.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ssm.system.web.dao.SysRoleMapper;
import net.ssm.system.web.pojo.SysRole;
import net.ssm.system.web.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleMapper sysRoleMapper;
	@Override
	public List<SysRole> GetRoleList() {
		return sysRoleMapper.selectSysRoleList();
		 
	}

	@Override
	public int insert(SysRole Role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysRole selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole role) {
		// TODO Auto-generated method stub
		return 0;
	}

}
