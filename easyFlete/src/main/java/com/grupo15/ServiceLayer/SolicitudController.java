
package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLSolicitud;
import com.grupo15.easyflete.Solicitud;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("solicitudes")
public class SolicitudController implements ISLSolicitud {

    @Override
    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean addSolicitud(@RequestParam(name = "origen") String jsonOrigen,@RequestParam(name = "destino") String jsonDestino, @RequestParam(name = "peso") int peso,@RequestParam(name = "descripcion") String descripcion,@RequestParam(name = "fecha") String fecha,@RequestParam(name = "precioMax") double precioMax, @RequestParam(name = "email") String email) {
        BLSolicitud bl = new BLSolicitud();
        return bl.addSolicitud(jsonOrigen, jsonDestino, peso, descripcion, fecha, precioMax, email);
    }

    @Override
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean updateSolicitud(@RequestParam(name = "id")int id, @RequestParam(name = "origen") String jsonOrigen, @RequestParam(name = "destino") String jsonDestino ,@RequestParam(name = "peso") int peso, @RequestParam(name = "descripcion") String descripcion,@RequestParam(name = "fecha") String fecha,@RequestParam(name = "precioMax") double precioMax) {
        BLSolicitud bl = new BLSolicitud();
        return bl.updateSolicitud(id, jsonOrigen, jsonDestino, peso, descripcion, fecha, precioMax);
    }

    @Override
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public boolean deleteSolicitud(@PathVariable(name="id")int id ) {
        BLSolicitud bl = new BLSolicitud();
        return bl.deleteSolicitud(id);
    }

    @Override
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Solicitud getSolicitud(@PathVariable(name="id")int id) {
        BLSolicitud bl = new BLSolicitud();
        return bl.getSolicitud(id);
    }
    
    @Override
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Solicitud> getAllSolicitudes() {
        BLSolicitud bl = new BLSolicitud();
        return bl.getAllSolicitudes();
    }
    
}
