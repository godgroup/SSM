package net.ssm.core;

import net.ssm.common.MyWebUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


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

		//return Boolean.TRUE;
		if(subject.isPermitted(uri)){
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
		ServletResponse response) throws Exception {
		if (net.ssm.common.MyWebUtils.isAjax(request)) {// ajax请求
			Map<String,Object> resultMap = new HashMap<String, Object>();

			resultMap.put("result",false);
			resultMap.put("msg","您没有该权限");
			MyWebUtils.out(response, resultMap);
		}
		else{
			WebUtils.issueRedirect(request, response, "/common/unauthorize");
		}
		return Boolean.FALSE;
	}

}

