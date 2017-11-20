package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
    List<SysMenu> selectSysMenuList();

    /**
     * 根据登录uid获取用户的菜单
     * @param uid
     * @return
     */
    List<SysMenu> selectSysMenuListByuid(Long uid);

}