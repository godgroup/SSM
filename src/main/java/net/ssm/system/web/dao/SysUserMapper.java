package net.ssm.system.web.dao;

import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.pojo.common.SearchVo;

import java.util.List;

public interface SysUserMapper {
	/**
	 * 通过ID获取用户
	 * @param id
	 * @return
	 */
	SysUser selectByPrimaryKey(Long id);
	List<SysUser>  selectSysUser(SearchVo vo);
	int insert(SysUser user);
	int updateByPrimaryKey(SysUser user);
	/**
	 * 通过登录名和密码获取用户
	 * @param loginName 登录名
	 * @param loginPswd 密码
	 * @return
	 */
	SysUser selectByNameAndPswd(String loginName,String loginPswd);
}
