package com.grupo15.ServiceLayer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calles")
@CrossOrigin
public class CalleController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCoordinates(String nombre){
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("calles");
        Document doc = collection.find().first();
        return doc.get("features").toString();
    }
}
