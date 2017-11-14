package net.ssm.config;

/**
 * Created by user on 2017/11/14.
 */
public  class SysConfig {
    private   static  String contextPath;
    public  static void  setContextPath(String contextPath)
    {
        SysConfig.contextPath=contextPath;
    }
    public  static String getContextPath()
    {
        return  contextPath;

    }
}
