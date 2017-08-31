package net.ssm.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("common")
public class CommonController {
	@RequestMapping("unauthorize")
	public void unauthorize(){}
}
