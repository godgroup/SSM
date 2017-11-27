package net.ssm.system.web.service.impl;

import net.ssm.system.web.dao.SysRoleMenuMapper;
import net.ssm.system.web.pojo.RoleMenuVo;
import net.ssm.system.web.pojo.SysRoleMenu;
import net.ssm.system.web.service.SysMenuService;
import net.ssm.system.web.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Resource
	private SysRoleMenuService sysRoleMenuService;
	@Resource
	private SysMenuService sysMenuService;
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

	@Override
	public int setRoleMenu(Long roleId, String menus) {
		List<SysRoleMenu> list= new ArrayList<>();
		String[] mensArray = menus.split(",");
		for (int i = 0; i <mensArray.length ; i++) {
			SysRoleMenu roleMenu=new SysRoleMenu();
			roleMenu.setSys_role_id(roleId);
			roleMenu.setSys_menu_id(Long.parseLong( mensArray[i]));
			list.add(roleMenu);
		}
		sysRoleMenuService.deleteByRoleId(roleId);
	    int IsSucess=  sysRoleMenuService.insertBatch(list);
		return IsSucess;
	}
}
