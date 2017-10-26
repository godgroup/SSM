package net.ssm.core;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.service.SysUserService;

public class ShiroRealm extends AuthorizingRealm{
	
	private final static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Resource
	private SysUserService sysUserService;
	
	public ShiroRealm()
	{
		setName("SSMRealm");
	}
	
	/**
	 * 从数据库中查询当前用户的权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前用户
		SysUser sysUser  = (SysUser)SecurityUtils.getSubject().getSession().getAttribute("user");
		Set<String> menuSet=new HashSet<String>();
		menuSet.add("/home/index");
		menuSet.add("/admin/userlist");
		menuSet.add("/admin/userlist2");
		menuSet.add("/menu/menulist");
		//根据用户获取角色对应的权限添加进去，由于还没有数据所以直接返回一个空的
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(menuSet);
		return authorizationInfo;
	}
	
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userNameToken = (UsernamePasswordToken)token;
		
		String loginName = userNameToken.getUsername();
		String pswd = new String(userNameToken.getPassword());
		
		if (StringUtils.isBlank(loginName)) {
			throw new AuthenticationException("登录名为空");
		}
		if (StringUtils.isBlank(pswd)) {
			throw new AuthenticationException("密码为空");
		}
		
		//验证- 由于数据库是明文，现在密码没有加密
		SysUser sysUser = sysUserService.LogonValidate(loginName, pswd);
		if (sysUser==null) {
			throw new UnknownAccountException("未找到匹配的用户");
		}
		
		SecurityUtils.getSubject().getSession().setAttribute("user",sysUser);
		return new SimpleAuthenticationInfo(loginName,pswd,getName());
	}
}
