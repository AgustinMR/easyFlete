package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.Zona;
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
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

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
    public String getZonasById(int id) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");

        Document doc = collection.find(eq("zonaId", id)).first();
        //System.out.println(doc.toJson());
        return doc.toJson();
    }

    @Override
    public boolean updateZona(int id, String geom) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");

        collection.deleteOne(eq("zonaId", id));

        return guardarZonas(id, geom);
    }

    @Override
    public boolean deleteZona(int id) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("zonasGeo");

        collection.deleteOne(eq("zonaId", id));

        return true;
    }

    public String precioZona(int solId, String email) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("solicitudesGeo");
        collection.createIndex(Indexes.geo2dsphere("destino"));
        collection.createIndex(Indexes.geo2dsphere("origen"));

        DALSolicitud dalSol = new DALSolicitud();
        List<Zona> z = dalSol.getZonasByFletero(email);
        boolean o = false;
        boolean d = false;
        double precio = 0;
        //para cada una de las zonas del fletero
        for (int i = 0; i < z.size(); i++) {
            //obtengo los datos de la zona
            String zonaFlet = getZonasById(z.get(i).getId());

            String[] tmp = zonaFlet.split("\\]\\]");
            String[] tmp1 = tmp[0].split("\\[\\[");
            String[] tmp2 = tmp1[1].split("\\], \\[");

            //creo el poligono de la zona
            List<List<Double>> polygons = new ArrayList<>();
            for (int j = 0; j < tmp2.length; j++) {
                String[] coo = tmp2[j].split(",");
                polygons.add(Arrays.asList(Double.parseDouble(coo[0]), Double.parseDouble(coo[1])));
            }
            //realizo la consulta de los puntos de destino que esten dentro de la zona actual en la iteracion
            Bson query = Filters.geoWithinPolygon("destino", polygons);
            collection.find(query).forEach(printBlock);;

            for (int g = 0; g < lista.size(); g++) {
                if (lista.get(g).trim().equals(String.valueOf(solId))) {
                    d = true;
                }
            }

            lista.clear();

            Bson query2 = Filters.geoWithinPolygon("origen", polygons);
            collection.find(query2).forEach(printBlock);;

            for (int g = 0; g < lista.size(); g++) {
                if (lista.get(g).trim().equals(String.valueOf(solId))) {
                    o = true;
                }
            }
            lista.clear();

            if (o && d) {
                Solicitud sol = dalSol.getSolicitud(solId);
                if (precio != 0) {
                    if (precio > z.get(i).getPrecio() * sol.getDistancia()) {
                        precio = z.get(i).getPrecio() * sol.getDistancia();
                    }
                } else {
                    precio = z.get(i).getPrecio() * sol.getDistancia();
                }
            } else {
                o = false;
                d = false;
            }

        }
        if (precio == 0) {
            return "false";
        } else {
            return String.valueOf(precio);
        }
    }

    private List<String> lista = new ArrayList<String>();

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            //System.out.println(document.toJson());
            lista.add(document.toJson().split(":")[3].split(",")[0]);
        }
    };
    
    @Override
    public String getSolicitudGEO(int id) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("easyFleteGEO");
        MongoCollection<Document> collection = database.getCollection("solicitudesGeo");

        Document doc = collection.find(eq("solicitudId", id)).first();
        String[] tmp = doc.toJson().split("\\[");
        String[] tmp2 = tmp[1].split("\\]");
        String[] tmp3 = tmp[2].split("\\]");
        
        return tmp2[0] + "|" + tmp3[0];
    }
}
