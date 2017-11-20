package net.ssm.system.web.service.impl;

import net.ssm.system.web.dao.SysRoleMenuMapper;
import net.ssm.system.web.pojo.RoleMenuVo;
import net.ssm.system.web.pojo.SysRoleMenu;
import net.ssm.system.web.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
	public int deleteByRoleId(Long roleId) {
		return sysRoleMenuMapper.deleteByRoleId(roleId);
	}

	@Override
	public int insert(SysRoleMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<SysRoleMenu> record) {
		return sysRoleMenuMapper.insertBatch(record);
	}

	@Override
	public int insertSelective(SysRoleMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleMenuVo selectSysMenuByRoleId(Long roleId) {
		
		return sysRoleMenuMapper.selectSysMenuByRoleId(roleId);
	}
	
}
