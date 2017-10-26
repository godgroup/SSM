package net.ssm.system.web.service;

import java.util.List;

import net.ssm.system.web.pojo.SysMenu;


public interface SysMenuService {
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<SysMenu> GetMenuList();
}
