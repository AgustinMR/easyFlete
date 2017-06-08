package com.grupo15.easyflete.datosdeprueba;

import com.grupo15.BusinessLogic.BLMapa;
import com.grupo15.BusinessLogic.BLSolicitud;
import com.grupo15.BusinessLogic.BLUsuario;

public class Main {

    public static void main(String args[]) {
        BLUsuario usuarios = new BLUsuario();
        BLSolicitud solicitudes = new BLSolicitud();
        BLMapa mapas = new BLMapa();
        
        /********************  USUARIOS  *********************/
        
        usuarios.addCliente("Pink", "pink1234", "pink@gmail.com", "099 456 789");
        usuarios.addCliente("John Snow", "john1234", "johnsnow@gmail.com", "099 132 456");
        usuarios.addCliente("Cercei Lannister", "cercei1234", "cerceilannister@gmail.com", "099 456 789");
        usuarios.addCliente("Bran Stark", "bran1234", "branstark@gmail.com", "098 753 159");
        usuarios.addCliente("Hodor.", "hodor", "hodor@gmail.com", "099 666 666");
        usuarios.addCliente("Agustin Maidana", "1324", "agustinmr1995@gmail.com", "099 501 719");
        usuarios.addCliente("Bruno Carballido", "1234", "bruno.carballido@gmail.com", "098 481 401");
        
        /********************  FLETEROS  *********************/
        
        usuarios.addFletero("Robert Beratheon", "robert1324", "robert@gmail.com", "091 445 556", "Camion Grande", 1000);
        usuarios.addFletero("Ethan Forrester", "ethan1234", "ethanTheBrave@gmail.com", "098 123 321", "Camion Mediano", 500);
        usuarios.addFletero("Sara Flowers", "sara1324", "sara@gmail.com", "098 658 794", "Tremendo camion", 1500);
        usuarios.addFletero("Pedro Moretto", "1234", "pedro.moretto@psico.edu.uy", "095 620 491", "volkswagen gol :D", 752);
        usuarios.addFletero("Enzo Drago", "1234", "enzodrg@gmail.com", "098 909 829", "Batimovil", 753);
        
        /********************  SOLICITUDES  *********************/
        
        solicitudes.addSolicitud("", "", "Transporte de ladrillos", 340, "Necesito transportar los ladrillos necesarios para poder construir mi muro.", "16/6/2017", 1600, "pink@gmail.com", 0, "12:00");
        solicitudes.addSolicitud("", "", "Translado del trono real", 150, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 800, "cerceilannister@gmail.com", 0, "13:00");
        solicitudes.addSolicitud("", "", "Winter is coming.", 50, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 400, "johnsnow@gmail.com", 0, "14:00");
        solicitudes.addSolicitud("", "", "Necesito un flete!", 123, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 550, "pink@gmail.com", 0, "14:30");
        solicitudes.addSolicitud("", "", "Necesito un flete! 2", 1140, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1500, "branstark@gmail.com", 0, "15:00");
        solicitudes.addSolicitud("", "", "Necesito un flete! 3", 140, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1600, "hodor@gmail.com", 0, "15:20"); 
        
        solicitudes.addSolicitud("", "", "Mudanza urgente", 321, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 750, "agustinmr1995@gmail.com", 0, "15:30");
        solicitudes.addSolicitud("", "", "Mudanza urgente 2", 250, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 600, "agustinmr1995@gmail.com", 0, "15:40");
        solicitudes.addSolicitud("", "", "Mudanza urgente 3", 500, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1000, "agustinmr1995@gmail.com", 0, "15:50");
        
        solicitudes.addSolicitud("", "", "Trasporte de cosas xD", 600, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1000, "bruno.carballido@gmail.com", 0, "12:30");
        solicitudes.addSolicitud("", "", "Trasporte de cosas 2", 120, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 600, "bruno.carballido@gmail.com", 0, "14:30");
        solicitudes.addSolicitud("", "", "Trasporte de cosas 3", 50, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 350, "bruno.carballido@gmail.com", 0, "15:00");
        
        /********************  MAPAS  *********************/
        
        mapas.addZona("robert@gmail.com", 200, "Que zona?", "");
        mapas.addZona("ethanTheBrave@gmail.com", 500, "Zona de trabajo", "");
        mapas.addZona("pedro.moretto@psico.edu.uy", 150, "Zona 1", "");
        mapas.addZona("pedro.moretto@psico.edu.uy", 350, "Zona 2", "");
        mapas.addZona("enzodrg@gmail.com", 500, "Zona 3", "");
        mapas.addZona("enzodrg@gmail.com", 200, "Zona 3", "");
        
    }
}
