package net.ssm.system.web.controller;

import com.github.pagehelper.PageInfo;
import net.ssm.system.web.pojo.SysUser;
import net.ssm.system.web.pojo.common.SearchVo;
import net.ssm.system.web.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("userlist")
	public ModelAndView userlist(SearchVo searchVo){
		PageInfo<SysUser> items = sysUserService.GetPageUser(searchVo);
		ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("items",items);
		modelAndView.addObject("keyWords", searchVo.getKeyWords());
		modelAndView.setViewName("admin/userlist");
		return modelAndView;
		
	}
	@RequestMapping("addUser")
	public ModelAndView addUser(Long id){
	    SysUser item=new SysUser();
		if(id!=null){
			item = sysUserService.selectByPrimaryKey(id);
		}

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("item",item);
		modelAndView.setViewName("admin/addUser");
		return modelAndView;

	}
	@ResponseBody
	@RequestMapping(value = "addAdminUser", method = RequestMethod.POST)
	public Map<String, Object> addUser(SysUser user) {
		Map<String, Object> resultmap = new HashMap<String, Object>();

		int ret=-1;
		boolean result=false;
		String msg="操作失败";

		if(user.getId()==null)
		{
			//插入
			ret = sysUserService.insert(user);
		}
		else
		{
			ret=sysUserService.updateByPrimaryKey(user);
		}
		if (ret > 0)
		{
			msg="修改成功";
			result=true;
		}

		resultmap.put("result", result);
		resultmap.put("msg", msg);

		return resultmap;
	}
	/**
	 * 登录页面
	 */
	@RequestMapping("login")
	public void login(){}
	
	/**
	 * 登录验证
	 * @param loginName 登录名
	 * @param pswd 密码
	 * @return
	 */
	@RequestMapping("loginValidate")
	@ResponseBody
	public Map<String,Object> loginValidate(String loginName,String pswd){
		Map<String,Object> result = new HashMap<String,Object>();
		
		if (StringUtils.isBlank(loginName)) {
			result.put("result",false);
			result.put("msg","登录名为空");
			return result;
		}
		if (StringUtils.isBlank(pswd)) {
			result.put("result",false);
			result.put("msg","密码为空");
			return result;
		}
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginName,pswd,false);
		
		try{
			subject.login(token);
			result.put("result",true);
		}catch(UnknownAccountException e){
			result.put("msg",e.getMessage());
			result.put("result",false);
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value="logout")
	public Map<String,Object> logout() {
		Map<String,Object> resultmap = new HashMap<String,Object>();

		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存

		}
		resultmap.put("result", true);
		resultmap.put("msg", "退出成功");

		return resultmap;
	}
}
