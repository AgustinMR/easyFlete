package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLMapa;
import com.grupo15.BusinessLogic.IBLMapa;
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
    public boolean addZona(@RequestParam(name = "email") String email,@RequestParam(name = "precio") double precio, @RequestParam(name = "geom") String geom) {
        IBLMapa mapa = new BLMapa();
        //System.out.println(email + " " + precio + " " + geom);
        return mapa.addZona(email, precio, geom);
    }
}
