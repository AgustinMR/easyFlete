package com.grupo15.DataAccessLayer;

import java.util.List;
import org.bson.Document;

public abstract interface IMapa {
    public Document getPunto(String nombre, String numero);
    public List<Document> getCallesNum (String nombre);
}
