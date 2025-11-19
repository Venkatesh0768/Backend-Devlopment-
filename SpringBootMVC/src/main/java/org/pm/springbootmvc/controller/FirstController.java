package org.pm.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/showmessage")
    public String showMessage(Model model){
        String msg = "Hello fucking MVC";
        model.addAttribute("message" , msg);
        return "success";
    }
}
