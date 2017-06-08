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
//        
//        usuarios.addCliente("Pink", "pink1234", "pink@gmail.com", "099 456 789");
//        usuarios.addCliente("John Snow", "john1234", "johnsnow@gmail.com", "099 132 456");
//        usuarios.addCliente("Cercei Lannister", "cercei1234", "cerceilannister@gmail.com", "099 456 789");
//        usuarios.addCliente("Bran Stark", "bran1234", "branstark@gmail.com", "098 753 159");
//        usuarios.addCliente("Hodor.", "hodor", "hodor@gmail.com", "099 666 666");
//        usuarios.addCliente("Agustin Maidana", "1324", "agustinmr1995@gmail.com", "099 501 719");
//        usuarios.addCliente("Bruno Carballido", "1234", "bruno.carballido@gmail.com", "098 481 401");
//        
//        /********************  FLETEROS  *********************/
//        
//        usuarios.addFletero("Robert Beratheon", "robert1324", "robert@gmail.com", "091 445 556", "Camion Grande", 1000);
//        usuarios.addFletero("Ethan Forrester", "ethan1234", "ethanTheBrave@gmail.com", "098 123 321", "Camion Mediano", 500);
//        usuarios.addFletero("Sara Flowers", "sara1324", "sara@gmail.com", "098 658 794", "Tremendo camion", 1500);
//        usuarios.addFletero("Pedro Moretto", "1234", "pedro.moretto@psico.edu.uy", "095 620 491", "volkswagen gol :D", 752);
//        usuarios.addFletero("Enzo Drago", "1234", "enzodrg@gmail.com", "098 909 829", "Batimovil", 753);
//        
//        /********************  SOLICITUDES  *********************/
//        
//        solicitudes.addSolicitud("", "", "Transporte de ladrillos", 340, "Necesito transportar los ladrillos necesarios para poder construir mi muro.", "16/6/2017", 1600, "pink@gmail.com", 0, "12:00");
//        solicitudes.addSolicitud("", "", "Translado del trono real", 150, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 800, "cerceilannister@gmail.com", 0, "13:00");
//        solicitudes.addSolicitud("", "", "Winter is coming.", 50, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 400, "johnsnow@gmail.com", 0, "14:00");
//        solicitudes.addSolicitud("", "", "Necesito un flete!", 123, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 550, "pink@gmail.com", 0, "14:30");
//        solicitudes.addSolicitud("", "", "Necesito un flete! 2", 1140, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1500, "branstark@gmail.com", 0, "15:00");
//        solicitudes.addSolicitud("", "", "Necesito un flete! 3", 140, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1600, "hodor@gmail.com", 0, "15:20"); 
//        
//        solicitudes.addSolicitud("", "", "Mudanza urgente", 321, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 750, "agustinmr1995@gmail.com", 0, "15:30");
//        solicitudes.addSolicitud("", "", "Mudanza urgente 2", 250, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 600, "agustinmr1995@gmail.com", 0, "15:40");
//        solicitudes.addSolicitud("", "", "Mudanza urgente 3", 500, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1000, "agustinmr1995@gmail.com", 0, "15:50");
//        
//        solicitudes.addSolicitud("", "", "Trasporte de cosas xD", 600, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 1000, "bruno.carballido@gmail.com", 0, "12:30");
//        solicitudes.addSolicitud("", "", "Trasporte de cosas 2", 120, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 600, "bruno.carballido@gmail.com", 0, "14:30");
//        solicitudes.addSolicitud("", "", "Trasporte de cosas 3", 50, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "16/6/2017", 350, "bruno.carballido@gmail.com", 0, "15:00");
//        
        /********************  MAPAS  *********************/
        
//        mapas.addZona("robert@gmail.com", 100, "Que zona?", "-56.195840341725535,-34.889492533923935,-56.194638712086864,-34.89884807896788,-56.21498058525581,-34.90631534886534,-56.21395061699409,-34.91000606846983,-56.20974491325874,-34.911980174304794,-56.20373676506538,-34.91017772984679,-56.20038936821479,-34.910435221912216,-56.18622730461616,-34.91567089390929,-56.176871759572215,-34.91429760289366,-56.171378595509715,-34.91455509495909,-56.17017696587104,-34.91549923253233,-56.16279552666206,-34.914898417713,-56.16757895729164,-34.87017710412754,-56.174445412369764,-34.87043459619297,-56.17959525367836,-34.87652857507481,-56.18697669288734,-34.89017565454258,-56.195840341725535,-34.889492533923935");
//        mapas.addZona("ethanTheBrave@gmail.com", 260, "Zona de trabajo", "-56.16104249282458,-34.92854636747441,-56.163102429348015,-34.91103690702519,-56.14902619643786,-34.914985118695114,-56.148597042995476,-34.918675838299606,-56.149112027126336,-34.9209074362,-56.16104249282458,-34.92854636747441");
//        mapas.addZona("pedro.moretto@psico.edu.uy", 150, "Zona 1", "-56.17101863191854,-34.865953752445634,-56.179430039389246,-34.87608177368587,-56.187154801352136,-34.89118797485774,-56.174966843588464,-34.901659318851884,-56.13720134065878,-34.886381456303056,-56.16827204988729,-34.86286384766048,-56.17101863191854,-34.865953752445634");
//        mapas.addZona("pedro.moretto@psico.edu.uy", 200, "Zona 2", "-56.24137352196235,-34.87055201729185,-56.22163246361274,-34.854930831989115,-56.21339271751899,-34.86111064155943,-56.21150444237251,-34.85527415474302,-56.208071214833446,-34.852699234088725,-56.19845817772407,-34.848922683795756,-56.19571159569282,-34.85750575264341,-56.19639824120063,-34.877933456500834,-56.20000313011665,-34.88222499092466,-56.22266243187446,-34.86849208076841,-56.23347709862251,-34.87278361519224,-56.24137352196235,-34.87055201729185");
//        mapas.addZona("enzodrg@gmail.com", 170, "Zona 3", "-56.14136382757049,-34.85764764356341,-56.106516568049,-34.895241485116145,-56.11424133001189,-34.89712976026263,-56.118189541681815,-34.89661477613177,-56.123167721613456,-34.9009063105556,-56.12385436712127,-34.903996215340754,-56.1310641449533,-34.90468286084857,-56.13775893865447,-34.90983270215716,-56.141878811701346,-34.90863107251849,-56.14823028264861,-34.914982543465754,-56.150118557795096,-34.92253564405169,-56.16058990178924,-34.928715453622004,-56.16797134099822,-34.870007262704036,-56.14136382757049,-34.85764764356341");
//        mapas.addZona("enzodrg@gmail.com", 130, "Zona 3", "-56.14136382757049,-34.85764764356341,-56.106516568049,-34.895241485116145,-56.11424133001189,-34.89712976026263,-56.118189541681815,-34.89661477613177,-56.123167721613456,-34.9009063105556,-56.12385436712127,-34.903996215340754,-56.1310641449533,-34.90468286084857,-56.13775893865447,-34.90983270215716,-56.141878811701346,-34.90863107251849,-56.14823028264861,-34.914982543465754,-56.150118557795096,-34.92253564405169,-56.16058990178924,-34.928715453622004,-56.16797134099822,-34.870007262704036,-56.14136382757049,-34.85764764356341");
        
    }
}
