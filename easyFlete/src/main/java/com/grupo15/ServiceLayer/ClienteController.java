package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.easyflete.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("clientes")
public class ClienteController implements ISLCliente {

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addCliente(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email,@RequestParam(name = "password") String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().addCliente(nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateCliente(@RequestParam(name = "id") int id, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email,@RequestParam(name = "password") String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().updateCliente(id, nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public boolean deleteCliente(@PathVariable(name = "id") int id) {
        return new BLUsuario().deleteCliente(id);
    }

    @Override
    @RequestMapping(name = "{id}", method = RequestMethod.GET)
    public Cliente getCliente(@PathVariable(name = "id") int id) {
        return new BLUsuario().getCliente(id);
    }

    @Override
    @RequestMapping(name = "", method = RequestMethod.GET)
    public List<Cliente> getAllSolicitudes() {
        return new BLUsuario().getAllClientes();
    }
    
}
