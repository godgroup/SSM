package net.ssm.system.web.service;

import java.util.List;

import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;


public interface SysMenuService {
	/**
	 * 获取菜单列表
	 * @return
	 */
	List<SysMenu> GetMenuList();
	
	int insert(SysMenu menu);
	
	SysMenu selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SysMenu menu);
	
	List<Node>	getNodeList(Long id,Integer type,List<SysMenu> itemsList);
}
