package net.ssm.core;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/11/25.
 */
public class LogAllWeb implements WebRequestInterceptor {


    @Override
    public void preHandle(WebRequest request) throws Exception {

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {




    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

        Iterator<String> iterators= request.getParameterNames();

        while (iterators.hasNext())
        {
            String name=iterators.next();
            System.out.println(name);
            System.out.println(request.getParameter(name));
        }
    }
}
