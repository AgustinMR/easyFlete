package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.easyflete.TipoUsuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class UsuarioController {
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public TipoUsuario autenticarUsuario(@RequestParam(name = "email")String email, @RequestParam(name = "pass")String pass){
        return new BLUsuario().login(email, pass);
    }
}
