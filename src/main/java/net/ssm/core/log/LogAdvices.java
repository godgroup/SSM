package net.ssm.core.log;

import com.alibaba.fastjson.JSON;
import net.ssm.core.UserManager;
import net.ssm.system.web.pojo.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 通知类，横切逻辑
 */

@Aspect
public class LogAdvices {
    private final static Logger logger = LoggerFactory.getLogger(LogAdvices.class);
    //切点
    @Pointcut("execution(* net.ssm.system.web.controller.*.*(..))")
    public void pointcut() {
    }

    //前置通知
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws  Throwable {

        SysUser user= UserManager.getCurrentSysUser();
        String longName="";
        if(user!=null){
            longName =user.getLogin_name();
        }
        //获取目标类的类名
        String clazzSimpleName = joinPoint.getTarget().getClass().getSimpleName();
        //获取目标方法名
        String methodName = joinPoint.getSignature().getName();
        //获取方法的参数名
        String[] paramNames = getFieldsName(joinPoint);
        //获取参数及参数值
        String logContent = writeLogInfo(paramNames, joinPoint);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String url= clazzSimpleName.replace("Controller","")+"/"+methodName;
        String info=String.format("管理员 %s 于%s访问了%s，请求数据%s",longName, df.format(new Date()),url,logContent);
        logger.info(info);


    }
    //返回结果通知
    @AfterReturning(pointcut = "pointcut()" ,returning="result")
    public void afterReturning(JoinPoint jp,Object result){
        String res= JSON.toJSONString(result);
        logger.info( "返回结果："  +res);
    }

    /**
     * 获取方法的参数列表
     * @param joinPoint
     * @return
     */
    private static String[] getFieldsName(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] paramNames = methodSignature.getParameterNames();
        return paramNames;
    }
    private static String[] types = { "java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float" };

    /**
     * 返回 方法参数及对应的 参数值
     * @param paramNames
     * @param joinPoint
     * @return
     */
    private static String writeLogInfo(String[] paramNames, JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        boolean clazzFlag = true;
        for(int k=0; k<args.length; k++){
            Object arg = args[k];
            sb.append(paramNames[k]+" ");
            if(arg==null){
                sb.append("=" + null+"; ");
                continue;
            }
            clazzFlag = true;
            // 获取对象类型
            String typeName = arg.getClass().getName();

            for (String t : types) {
                if (t.equals(typeName)) {
                    sb.append("=" + arg+"; ");
                    clazzFlag=false;
                    break;
                }
            }
            if (clazzFlag) {
                sb.append(JSON.toJSONString(arg));
            }
        }
        return sb.toString();
    }






}