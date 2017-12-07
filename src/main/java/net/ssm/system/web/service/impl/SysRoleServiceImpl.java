package net.ssm.system.web.service.impl;

import net.ssm.system.web.dao.SysRoleMapper;
import net.ssm.system.web.pojo.SysRole;
import net.ssm.system.web.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
		return sysRoleMapper.insert(Role);
	}

	@Override
	public SysRole selectByPrimaryKey(Long id) {
		return  sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		return sysRoleMapper.updateByPrimaryKey(record);
	}
}
