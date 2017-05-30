package com.grupo15.easyfleteweb;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ZonaController {
    
    @RequestMapping(value = "zonas", method = RequestMethod.GET)
    public String getInicioCliente(Model m, Authentication a){
        if(a.isAuthenticated() && ((UserDetails)a.getPrincipal()).isEnabled()) {
            UserDetails u = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            m.addAttribute("usuario", u.getUsername());
            if(u.getAuthorities().toString().equals("[FLETERO]")) return "zonas";
            else return "Error";
        } else {
            return "Error";
        }
    }
    
}
