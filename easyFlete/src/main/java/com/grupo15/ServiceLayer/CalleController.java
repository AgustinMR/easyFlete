package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLMapa;
import com.grupo15.BusinessLogic.IBLMapa;
import com.grupo15.easyflete.Zona;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("calles")
public class CalleController {

    @RequestMapping(value = "/geo", method = RequestMethod.POST)
    public String getPunto(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "numero") String numero) {
        IBLMapa mapa = new BLMapa();
        return mapa.getPunto(nombre, numero);
    }

    @RequestMapping(value = "/calleNum/{calleNum}", method = RequestMethod.GET)
    public List<String> getCallesNum(@PathVariable(name = "calleNum") String calleNum) {
        IBLMapa mapa = new BLMapa();
        return mapa.getCallesNum(calleNum);
    }
    
    @RequestMapping(value = "/zona", method = RequestMethod.POST)
    public boolean addZona(@RequestParam(name = "email") String email,@RequestParam(name = "precio") double precio, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "geom") String geom) {
        IBLMapa mapa = new BLMapa();
        //System.out.println(email + " " + precio + " " + geom);
        return mapa.addZona(email, precio, nombre, geom);
    }
    
    @RequestMapping(value = "/zona", method = RequestMethod.PUT)
    public boolean updateZona(@RequestParam(name = "id") int id,@RequestParam(name = "precio") double precio, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "geom") String geom) {
        IBLMapa mapa = new BLMapa();
        return mapa.updateZona(id, precio, nombre, geom);
    }
    
    @RequestMapping(value = "/zona", method = RequestMethod.DELETE)
    public boolean borrarZona(@RequestParam(name = "id") int id) {
        IBLMapa mapa = new BLMapa();
        return mapa.deleteZona(id);
    }
    
    @RequestMapping(value = "/zonas", method = RequestMethod.GET)
    public List<Zona> getZonasByFletero(@RequestParam(name = "email") String email) {
        IBLMapa mapa = new BLMapa();
        return mapa.getZonasByFletero(email);
    }
    
    @RequestMapping(value = "/zonasGEO", method = RequestMethod.GET)
    public String getZonasById(@RequestParam(name = "id") int id) {
        IBLMapa mapa = new BLMapa();
        return mapa.getZonasById(id);
    }
}
