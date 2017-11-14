package net.ssm.system.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("menu")
public class RoleMenuController {
    @RequestMapping("roleMenu")
    public ModelAndView setRoleMenu() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("role/roleMenu");

        return modelAndView;
    }
}
