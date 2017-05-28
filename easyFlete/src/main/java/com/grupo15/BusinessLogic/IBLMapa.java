package com.grupo15.BusinessLogic;

import java.util.List;

public abstract interface IBLMapa {
    public String getPunto(String nombre, String numero);
    public List<String> getCallesNum(String calleNum);
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes);
    public boolean addZona(String email, double precio, String geom);
}
