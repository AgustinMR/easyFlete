package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.easyflete.Fletero;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("fleteros")
public class FleteroController implements ISLFletero {
    
    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addFletero(@RequestParam(name = "nombre") String nombre,@RequestParam(name = "email") String email,@RequestParam(name = "password") String password, @RequestParam(name = "telefono") String telefono, @RequestParam(name = "vehiculo_nombre") String vehiculoNombre, @RequestParam(name = "vehiculo_carga") String vehiculoCarga ) {
        return new BLUsuario().addFletero(nombre, password, email, telefono, vehiculoNombre, vehiculoCarga);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateFletero(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().updateFletero(nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public boolean deleteFletero(@PathVariable(name = "email")String email) {
        return new BLUsuario().deleteFletero(email);// corregir lpm
    }

    @Override
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Fletero getFletero(@PathVariable(name = "email") String email) {
        return new BLUsuario().getFletero(email);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Fletero> getAllFleteros() {
        return new BLUsuario().getAllFleteros();
    }
    
}
