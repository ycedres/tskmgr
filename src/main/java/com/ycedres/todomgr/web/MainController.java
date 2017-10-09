package com.ycedres.todomgr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Overwritten by VaadinUI
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "hello.html";
    }
}
