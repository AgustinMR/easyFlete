package com.grupo15.easyfleteweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrarseController {
    
    @RequestMapping(value = "registrarse", method = RequestMethod.GET)
    public String getRegistrarse(Model m){
        return "registrarse";
    }
    
}
