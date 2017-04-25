package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLSolicitud;
import com.grupo15.BusinessLogic.BLUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class easyFlete {
    
    public static void main(String args[]){
        SpringApplication.run(easyFlete.class, args);

        //new BLUsuario().addCliente("nombre", "pass", "email", "145");
        //new BLSolicitud().updateSolicitud(13,-34.917822, -56.166215,-34.920267, -56.150364, 500, 50, "assafsaff", "14/1/2008", 5000);
        //new BLSolicitud().deleteSolicitud(7);
        new BLUsuario().updateCliente("nombre2", "password2", "email", "telefono2");
    }

}
