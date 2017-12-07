package net.ssm.system.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ssm.system.web.dao.SysUserMapper;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.pojo.common.SearchVo;
import net.ssm.system.web.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
	@Resource
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(SysUser user) {
		return sysUserMapper.insert(user);
	}

	@Override
	public int updateByPrimaryKey(SysUser user) {
		return sysUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public String GetUserName(Long id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		
		return sysUser.getName();
	}

	@Override
	public List<SysUser> GetUser() {
		SearchVo searchVo=new SearchVo();
		List<SysUser>  userList = sysUserMapper.selectSysUser(searchVo);
		
		return userList;
	}
	@Override
	public PageInfo<SysUser> GetPageUser(SearchVo searchVo ) {
		Integer pageNo=searchVo.getPageNo();
		Integer pageSize=searchVo.getPageSize();
		//获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(pageNo, pageSize);
		List<SysUser>  userList = sysUserMapper.selectSysUser(searchVo);
		//将查询结果使用pageInfo包装
		PageInfo<SysUser> page = new  PageInfo<SysUser>(userList);
		return page;
	}
	@Override
	public SysUser LogonValidate(String loginName, String pswd) {
		return sysUserMapper.selectByNameAndPswd(loginName, pswd);
	}

}
