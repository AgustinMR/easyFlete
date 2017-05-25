package com.grupo15.ServiceLayer;

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

    private List<String> agregarSinRepeticion(List<String> list, String ele) {
        boolean a = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(ele.toLowerCase())) {
                a = false;
            }
        }
        if (a) {
            list.add(ele.toLowerCase());
        }
        return list;
    }

    private List<Integer> agregarNumPuerta(List<Integer> list, String ele) {
        boolean a = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == Integer.parseInt(ele)) {
                a = false;
            }
        }
        if (a) {
            list.add(Integer.parseInt(ele));
        }
        return list;
    }

    @RequestMapping(value = "/geo", method = RequestMethod.POST)
    public String getPunto(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "numero") String numero) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        Document doc = collection.find(and(eq("properties.NOM_CALLE", nombre.toUpperCase()), (eq("properties.NUM_PUERTA", Integer.parseInt(numero))))).first();
        if (doc != null) {
            String prop = doc.get("geometry").toString();
            return prop.split("\\[")[1].split("\\]")[0];
        }
        return null;
    }

    @RequestMapping(value = "/calleNum/{calleNum}", method = RequestMethod.GET)
    public List<String> getCallesNum(@PathVariable(name = "calleNum") String calleNum) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        String[] part = calleNum.split("(?<=\\D)(?=\\d)");
        String nombre = part[0];
        String numero;
        if (part.length == 2) {
            numero = part[1];
        } else {
            numero = null;
        }
        List<String> returnList = new ArrayList<>();
        List<Document> docList = new ArrayList<>();
        collection.find(eq("properties.NOM_CALLE", java.util.regex.Pattern.compile(nombre.trim().toUpperCase()))).into(docList);

        if (!docList.isEmpty()) {
            if (numero == null) {
                String prop = docList.get(0).get("properties").toString();
                returnList.add(prop.split("=")[4].split(",")[0].toLowerCase());
                for (int i = 1; i < docList.size(); i++) {
                    String prop2 = docList.get(i).get("properties").toString();
                    returnList = agregarSinRepeticion(returnList, prop2.split("=")[4].split(",")[0]);
                }
            } else {
                for (int i = 0; i < docList.size(); i++) {
                    String prop2 = docList.get(i).get("properties").toString();
                    returnList = agregarSinRepeticionConNumero(returnList, prop2, numero);
                }
            }
        }
        return returnList;

    }

    private List<String> agregarSinRepeticionConNumero(List<String> list, String prop2, String numero) {
        String nomProp = prop2.split("=")[4].split(",")[0];
        String numProp = prop2.split("=")[5].split(",")[0];
        if (list.isEmpty() && numProp.equals(numero)) {
            list.add(nomProp.toLowerCase() + ", " + numProp);
        } else if (!list.isEmpty() && numProp.equals(numero)) {
            list.add(nomProp.toLowerCase() + ", " + numProp);
        }
        return list;
    }
}
