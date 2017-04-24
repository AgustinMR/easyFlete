package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.easyflete.Fletero;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fleteros")
public class FleteroController implements ISLFletero {
    
    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addFletero(@RequestParam(name = "nombre") String nombre,@RequestParam(name = "email") String email,@RequestParam(name = "password") String password, @RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().addFletero(nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateFletero(@RequestParam(name = "id")int id,@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().updateFletero(id, nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public boolean deleteFletero(@PathVariable(name = "id")int id) {
        return new BLUsuario().deleteFletero(id);// corregir lpm
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Fletero getFletero(@PathVariable(name = "id") int id) {
        return new BLUsuario().getFletero(id);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Fletero> getAllFleteros() {
        return new BLUsuario().getAllFleteros();
    }
    
}
