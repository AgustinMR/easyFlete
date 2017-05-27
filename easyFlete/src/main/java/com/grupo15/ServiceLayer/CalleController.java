package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLMapa;
import com.grupo15.BusinessLogic.IBLMapa;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
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
        IBLMapa DLmapa = new BLMapa();
        return DLmapa.getPunto(nombre, numero);
    }

    @RequestMapping(value = "/calleNum/{calleNum}", method = RequestMethod.GET)
    public List<String> getCallesNum(@PathVariable(name = "calleNum") String calleNum) {
        IBLMapa DLmapa = new BLMapa();
        return DLmapa.getCallesNum(calleNum);
    }    

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean guardarSolicitud(@RequestParam(name = "latlonOri") String latlonOri, @RequestParam(name = "latlonDes") String latlonDes, @RequestParam(name = "idSol") String idSol) {
      
        return true;
    }
}
