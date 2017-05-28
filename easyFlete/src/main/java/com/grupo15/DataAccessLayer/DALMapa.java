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

    @Override
    public Document getPunto(String nombre, String numero) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        return collection.find(and(eq("properties.NOM_CALLE", nombre.toUpperCase()), (eq("properties.NUM_PUERTA", Integer.parseInt(numero))))).first();
    }

    @Override
    public List<Document> getCallesNum(String nombre) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("puertas");

        List<Document> docList = new ArrayList<>();
        collection.find(eq("properties.NOM_CALLE", java.util.regex.Pattern.compile(nombre.trim().toUpperCase()))).into(docList);
        return docList;
    }

    @Override
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes) {
        MongoClient mongoClient = new MongoClient();
       MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
       MongoCollection<Document> collection = database.getCollection("solicitudesGeo");
      
       String json = "{ 'solicitudId' : "+ solId +" , 'origen' : { 'type': 'Point', 'coordinates': [ "+ latlonOri +" ] } , 'destino' : { 'type': 'Point', 'coordinates': [ "+ latlonDes +" ] }}";
     
       Document doc = Document.parse(json);
       collection.insertOne(doc);
        return true;
    }
}
