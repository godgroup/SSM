package net.ssm.system.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ssm.system.web.dao.SysRoleMenuMapper;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.SysRoleMenu;
import net.ssm.system.web.service.SysRoleMenuService;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Override
	public int deleteByPrimaryKey(SysRoleMenu key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysRoleMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysRoleMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysMenu> selectSysMenuByRoleId(Long roleId) {
		
		return sysRoleMenuMapper.selectSysMenuByRoleId(roleId);
	}
	
}
