package net.ssm.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

public class MyExceptionHandler implements HandlerExceptionResolver {
	private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String requestType = request.getHeader("X-Requested-With");
		
		String error = ex.toString().trim();
		
		ModelAndView model = new ModelAndView();
		
		FastJsonJsonView view = new FastJsonJsonView();
		
		StringBuilder errorMess = new StringBuilder(7);
		
		if (requestType!=null) {
			//AJAX请求
			errorMess.append("\r\nAJAX请求：");
			
			Map<String, Object> result = new HashMap<String,Object>();
		
			result.put("msg", false);
			
			result.put("data","请求出现错误");
			
			view.setAttributesMap(result);
			
			model.setView(view);
		}
		else
		{
			errorMess.append("\r\n请求：");
			
			model.setViewName("500");
		}
		
		errorMess.append(request.getRequestURI());
		errorMess.append("\r\n出现异常：");
		errorMess.append(ex.toString().trim());
		errorMess.append("\r\n详细信息：");
		errorMess.append(getExceptionAllinformation(ex).trim());
		
		log.error(errorMess.toString());
		
		return model;
	}
	
	/**
	 * 获取异常详细的信息
	 * @param ex
	 * @return
	 */
	public static String getExceptionAllinformation(Exception ex){
        String sOut = "";
        
        StackTraceElement[] trace = ex.getStackTrace();
        
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        
        return sOut;
	}
}
