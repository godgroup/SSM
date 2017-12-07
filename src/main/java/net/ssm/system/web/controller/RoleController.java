package net.ssm.system.web.controller;

import net.ssm.core.UserManager;
import net.ssm.system.web.pojo.SysRole;
import net.ssm.system.web.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 返回菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "rolelist", method = RequestMethod.GET)
	public ModelAndView index() {
		List<SysRole> itemsList = sysRoleService.GetRoleList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名itemsList.jsp
		modelAndView.setViewName("role/rolelist");

		return modelAndView;

	}
	@RequestMapping("addRole")
	 public ModelAndView addRole(Long id) {
		ModelAndView modelAndView = new ModelAndView();
		SysRole role=new SysRole();
		if(id!=null)
		{
			role=sysRoleService.selectByPrimaryKey(id);
		}
		modelAndView.addObject("item", role);
		modelAndView.setViewName("role/addRole");
		return modelAndView;
	}
	@RequestMapping("addSysRole")
	@ResponseBody
	public Map<String, Object> addSysRole(SysRole role) {
		Map<String, Object> resultmap = new HashMap<String, Object>();
		int ret=-1;
		boolean result=false;
		String msg="操作失败";

		if(role.getId()==null)
		{
			role.setCreate_by(UserManager.getCurrentSysUser().getLogin_name());
			//插入
			ret = sysRoleService.insert(role);
			if (ret > 0)
			{
				msg="添加成功";
				result=true;
			}

		}
		else {
			//修改
			ret = sysRoleService.updateByPrimaryKey(role);
			if (ret > 0)
			{
				msg="修改成功";
				result=true;
			}
		}
		resultmap.put("result", result);
		resultmap.put("msg", msg);

		return resultmap;
	}
}
