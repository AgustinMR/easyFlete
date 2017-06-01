package com.grupo15.DataAccessLayer;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
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

        String json = "{ 'solicitudId' : " + solId + " , 'origen' : { 'type': 'Point', 'coordinates': [ " + latlonOri + " ] } , 'destino' : { 'type': 'Point', 'coordinates': [ " + latlonDes + " ] }}";

        Document doc = Document.parse(json);
        collection.insertOne(doc);
        return true;
    }

    @Override
    public boolean guardarZonas(Integer zonaId, String geoZona) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");

        String[] tmp = geoZona.split(",");
        String resultado = "";
        for (int i = 0; i < tmp.length; i++) {
            if (i % 2 == 0) {
                resultado += "[" + tmp[i] + ",";
            } else {
                int u = i;
                if (u + 1 < tmp.length) {
                    resultado += tmp[i] + "],";
                } else {
                    resultado += tmp[i] + "]";
                }
            }
        }
        String json = "{ 'zonaId' : " + zonaId + " , 'geometry' : { 'type': 'Polygon', 'coordinates': [" + resultado + "] }}";

        Document doc = Document.parse(json);
        collection.insertOne(doc);
        return true;
    }

    @Override
    public int getDistance() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("solicitudesGeo");
        collection.createIndex(Indexes.geo2dsphere("destino"));
        
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        
        Point refPoint = new Point(new Position(-56.2269777330595, -34.8585389298685));
        collection.find(Filters.near("destino", refPoint, 10000.0, 0.0)).forEach(printBlock);
        
        return 0;
    }
    
    @Override
    public String getZonasById(int id){
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");
        
        Document doc = collection.find(eq("zonaId", id)).first();
        
        return doc.toJson();
    }
    
    @Override
    public boolean updateZona(int id, String geom){
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");
          
        collection.deleteOne(eq("zonaId", id));
      
        return guardarZonas(id, geom);
    }
    
    @Override
    public boolean deleteZona(int id){
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");
          
        collection.deleteOne(eq("zonaId", id));
      
        return true;
    }
}
