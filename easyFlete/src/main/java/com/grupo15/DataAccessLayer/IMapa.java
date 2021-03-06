package com.grupo15.DataAccessLayer;

import java.util.List;
import org.bson.Document;

public abstract interface IMapa {
    public Document getPunto(String nombre, String numero);
    public List<Document> getCallesNum (String nombre);
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes);
    public boolean guardarZonas(Integer zonaId, String geoZona);
    public int getDistance();
    public String getZonasById(int id);
    public boolean updateZona(int id, String geom);
    public boolean deleteZona(int id);
    public String precioZona(int solId, String email);
    public String getSolicitudGEO(int id);
    public List<Integer> getSugerencias(String email, int idSol);
    public List<Integer> getSolCercanas(String point, int distance);
}
