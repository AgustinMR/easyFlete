package com.grupo15.BusinessLogic;

import java.util.List;

public abstract interface IBLMapa {
    public String getPunto(String nombre, String numero);
    public List<String> getCallesNum(String calleNum);
}
