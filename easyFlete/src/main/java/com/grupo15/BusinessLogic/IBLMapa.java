package com.grupo15.BusinessLogic;

import com.grupo15.easyflete.Zona;
import java.util.List;

public abstract interface IBLMapa {
    public String getPunto(String nombre, String numero);
    public List<String> getCallesNum(String calleNum);
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes);
    public boolean addZona(String email, double precio, String nombre, String geom);
    public List<Zona> getZonasByFletero(String email);
    public String getZonasById(int id);
}
