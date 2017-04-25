package com.grupo15.easyfleteweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Controller
//@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {
    /*  
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/solicitudes").setViewName("solicitudes");
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model m) {
        m.addAttribute("user", "agustin");
        return "index.html";
    }*/
    
    /*
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }*/
}
