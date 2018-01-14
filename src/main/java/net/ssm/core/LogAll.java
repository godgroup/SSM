package net.ssm.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录用户的操作日志
 */
public class LogAll implements HandlerInterceptor  {
    private final static Logger logger = LoggerFactory.getLogger(LogAll.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion完成这一次请求了" + request.getRequestURI());

//
//        while (iterators.hasMoreElements())
//        {
//            String name=iterators.nextElement();
//            System.out.println(name);
//            System.out.println(request.getParameter(name));
//        }
        //记录用户的所有操作记录
//        Enumeration<String> iterators= request.getParameterNames();
//        SysUser user= UserManager.getCurrentSysUser();
//        String longName="";
//        if(user!=null){
//            longName =user.getLogin_name();
//        }
//        Map<String,String[]> stringMap= request.getParameterMap();
//        String requestParams= JSON.toJSONString(stringMap);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//
//        String info=String.format("管理员%s于%s访问了%s，请求数据%s",longName, df.format(new Date()),request.getRequestURI(),requestParams);
//        logger.info(info);

    }
}
