package com.grupo15.DataAccessLayer;

import java.util.List;
import org.bson.Document;

public abstract interface IMapa {
    public Document getPunto(String nombre, String numero);
    public List<Document> getCallesNum (String nombre);
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes);
    public boolean guardarZonas(Integer zonaId, String geoZona);
    public int getDistance();
}
