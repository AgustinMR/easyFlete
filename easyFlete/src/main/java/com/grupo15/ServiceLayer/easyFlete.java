package com.grupo15.ServiceLayer;

import com.grupo15.BusinessLogic.BLUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class easyFlete {
    
    public static void main(String args[]){
        SpringApplication.run(easyFlete.class, args);
        new BLUsuario().addCliente("nombre", "pass", "email", "145");
    }

}
