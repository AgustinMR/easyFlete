package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.easyflete.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
@CrossOrigin
public class ClienteController implements ISLCliente {

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addCliente(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email,@RequestParam(name = "password", required = false) String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().addCliente(nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean updateCliente(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "email") String email,@RequestParam(name = "password") String password,@RequestParam(name = "telefono") String telefono) {
        return new BLUsuario().updateCliente(nombre, password, email, telefono);
    }

    @Override
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public boolean deleteCliente(@PathVariable(name = "email") String email) {
        return new BLUsuario().deleteCliente(email);
    }

    @Override
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public Cliente getCliente(@RequestParam(name = "email") String email) {
        return new BLUsuario().getCliente(email);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Cliente> getAllClientes() {
        return new BLUsuario().getAllClientes();
    }

    @Override
    @RequestMapping(value = "/solicitudes", method = RequestMethod.GET)
    public List<Object[]> getSolicitudesByCliente(@RequestParam(name = "email")String email, @RequestParam(name = "desde", required = false) String fechaDesde, @RequestParam(name = "hasta", required = false) String fechaHasta, @RequestParam(name = "titulo", required = false) String titulo) {
        return new BLUsuario().getSolicitudesByCliente(email, fechaDesde, fechaHasta, titulo);
    }
    
}
