package org.pm.springwebmvc2.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/welcome2")
    public ModelAndView home(Model model) {
       ModelAndView mav = new ModelAndView();
       mav.addObject("message ", "Hello the Fucking World leader");
       mav.setViewName("index");
       return mav;
    }
}
