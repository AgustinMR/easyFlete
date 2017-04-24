package com.grupo15.ServiceLayer;

//import com.grupo15.BusinessLogic.BLUsuario;
import com.grupo15.BusinessLogic.BLSolicitud;
import com.grupo15.BusinessLogic.BLUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class easyFlete {

    public static void main(String args[]) {
        SpringApplication.run(easyFlete.class, args);

        BLUsuario BLusu = new BLUsuario();
        BLusu.addCliente("Bruno", "bruno.carballido@gmail.com","hola","23085099");
        
        //BLSolicitud BLsol = new BLSolicitud();
        //BLsol.addSolicitud(-34.917822, -56.166215,-34.920267, -56.150364, 500, 50, "assafsaff", "safsafsa", 5000, 1);
    }

}
