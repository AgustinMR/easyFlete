package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.DALMapa;
import com.grupo15.DataAccessLayer.DALSolicitud;
import com.grupo15.DataAccessLayer.DALUsuario;
import com.grupo15.DataAccessLayer.IMapa;
import com.grupo15.DataAccessLayer.ISolicitud;
import com.grupo15.DataAccessLayer.IUsuario;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.Zona;
import com.grupo15.easyflete.ZonaFletero;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class BLMapa implements IBLMapa {

    private static IMapa DLMapa = null;

    public BLMapa() {
        DLMapa = new DALMapa();
    }

    @Override
    public String getPunto(String nombre, String numero) {
        Document doc = DLMapa.getPunto(nombre, numero);
        if (doc != null) {
            String prop = doc.get("geometry").toString();
            return prop.split("\\[")[1].split("\\]")[0];
        }
        return "";
    }
    
    @Override
    public boolean guardarSolicitud(Integer solId, String latlonOri, String latlonDes) {
        return DLMapa.guardarSolicitud(solId, latlonOri, latlonDes);
    }

    @Override
    public List<String> getCallesNum(String calleNum) {
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
        docList = DLMapa.getCallesNum(nombre);

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
    
    @Override
    public boolean addZona(String email, double precio, String geom) {
        ISolicitud sol = new DALSolicitud();
        IUsuario usu = new DALUsuario();
        Zona z = new Zona(precio);
        Fletero f = usu.getFletero(email);
        if (sol.addZona(z)){
            ZonaFletero zf = new ZonaFletero(z.getId(),f);
            sol.addZonaFletero(zf);
            return DLMapa.guardarZonas(z.getId(), geom);
        }
        return false;
    }

}
