package net.ssm.system.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.ssm.system.web.dao.SysMenuMapper;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.service.SysMenuService;

import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuMapper sysMenuMapper;
	@Override
	public List<SysMenu> GetMenuList() {
		
		return	sysMenuMapper.selectSysMenuList();
	}
	@Override
	public int insert(SysMenu menu) {
		return	sysMenuMapper.insert(menu);
	}

}
