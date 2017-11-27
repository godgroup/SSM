package net.ssm.core;

import net.ssm.common.MyWebUtils;
import net.ssm.system.web.pojo.SysUser;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义登录过滤
 */
public class LoginFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        SysUser token = UserManager.getCurrentSysUser();
        if(null != token || isLoginRequest(request, response)){// && isEnabled()
            return Boolean.TRUE;
        }

        return Boolean.FALSE ;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (MyWebUtils.isAjax(request)) {// ajax请求
            Map<String,Object> resultMap = new HashMap<String, Object>();

            resultMap.put("result",false);
            resultMap.put("msg","请您先登录");
            MyWebUtils.out(response, resultMap);
        }
        else {
            //保存Request和Response 到登录后的链接
            saveRequestAndRedirectToLogin(request, response);
        }

        return Boolean.FALSE ;
    }
}
