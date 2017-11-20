package net.ssm.core;
import net.ssm.config.SysConfig;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 
 * <p>
 * 权限校验 Filter
 * <p>
 *
 * 
 */
public class PermissionFilter extends AccessControlFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		
		//先判断带参数的权限判断
		Subject subject = getSubject(request, response);
		if(null != mappedValue){
			String[] arra = (String[])mappedValue;
			for (String permission : arra) {
				if(subject.isPermitted(permission)){
					return Boolean.TRUE;
				}
			}
		}
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		String uri = httpRequest.getRequestURI();//获取URI
		String basePath = httpRequest.getContextPath();//获取basePath
		if(null != uri && uri.startsWith(basePath)){
			uri = uri.replaceFirst(basePath, "");
		}
		System.out.println("请求的url"+uri);
		if(SysConfig.getContextPath()==null&&basePath!=null)
			SysConfig.setContextPath(basePath);
		return Boolean.TRUE;
//		if(subject.isPermitted(uri)){
//			return Boolean.TRUE;
//		}
//
//		return Boolean.FALSE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		
			Subject subject = getSubject(request, response);  
	        if (null == subject.getPrincipal()) {//表示没有登录，重定向到登录页面  
	            saveRequest(request);  
	            WebUtils.issueRedirect(request, response, "/admin/login");  
	        } else {  
	           
	                WebUtils.issueRedirect(request, response, "/common/unauthorize");  
	            
	        }  
		return Boolean.FALSE;
	}

}

