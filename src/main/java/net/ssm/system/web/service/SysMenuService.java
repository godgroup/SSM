package net.ssm.system.web.service;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;

import java.util.List;


public interface SysMenuService {
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<SysMenu> GetMenuList();

	/**
	 * 根据uid获取用户的菜单
	 * @param uid
	 * @return
	 */
	List<SysMenu> selectSysMenuListByuid(Long uid);
	int insert(SysMenu menu);
	
	SysMenu selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SysMenu menu);
	
	List<Node>	getNodeList(Long id,Integer type,List<SysMenu> allMenuList);
	List<Node>	getNodeList(Long id,Integer type,List<SysMenu> allMenuList,List<SysMenu> roleMenuList);
}
