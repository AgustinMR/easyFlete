package com.grupo15.DataAccessLayer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class DALMapa implements IMapa {

    public Document getPunto(String nombre, String numero) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        return collection.find(and(eq("properties.NOM_CALLE", nombre.toUpperCase()), (eq("properties.NUM_PUERTA", Integer.parseInt(numero))))).first();
    }

    public List<Document> getCallesNum(String nombre) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        List<Document> docList = new ArrayList<>();
        collection.find(eq("properties.NOM_CALLE", java.util.regex.Pattern.compile(nombre.trim().toUpperCase()))).into(docList);
        return docList;
    }

    /*public boolean guardarSolicitud() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("solicitudesGeo");
    }*/
}
