package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.Usuario;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHandler {

    public MailHandler() {
    }

    private void SendEmail(String email, String subject, Object mensaje) throws MessagingException {
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage mail = new MimeMessage(getMailSession);
        try {
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mail.setSubject(subject);
            mail.setContent(mensaje, "text/html");
            Transport t = getMailSession.getTransport("smtp");
            t.connect("smtp.gmail.com", "info.easyflete", "tsig2017gr15");
            t.sendMessage(mail, mail.getAllRecipients());
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendSolicitudCreadaMail(Cliente c, Solicitud s, String fecha, String hora) {
        String f = (Calendar.getInstance().get(Calendar.YEAR) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.DATE));
        String h = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));
        String texto = "Estimado " + c.getNombre() + ",<br>"
                + "Le informamos que su solicitud: <strong>" + s.getTitulo() + "</strong> ha sido creada correctamente!.<br>"
                + "<hr><br><br>"
                + "<strong>Detalles del flete:</strong><br>"
                + "Titulo: " + s.getTitulo() + "<br>"
                + "Fecha: " + fecha + "<br>"
                + "Hora: " + hora + "<br>"
                + "Peso: " + s.getPeso() + "<br>"
                + "<br><hr><hr>"
                + "easyFlete - Grupo 15 - Tsig"
                + "<br><hr>"
                + f + " | " + h;
        try {
            SendEmail(c.getUsername(), "Solicitud Creada | easyFlete", texto);
        } catch (MessagingException ex) {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendSolicitudAceptadaToCliente(Fletero f, Solicitud s, Cliente c, double precio) {
        String fecha = (Calendar.getInstance().get(Calendar.YEAR) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.DATE));
        String hora = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));
        String texto = "Estimado " + c.getNombre() + ",<br>"
                + "Le informamos que su solicitud: <strong>" + s.getTitulo() + "</strong> ha sido aceptada por un fletero.<br>"
                + "<hr><br><br>"
                + "<strong>Detalles del Fletero:</strong><br>"
                + "Nombre: " + f.getNombre() + "<br>"
                + "Email: " + f.getUsername() + "<br>"
                + "Telefono: " + f.getTelefono() + "<br>"
                + "<br><hr><br>"
                + "Costo calculado para los <strong>" + s.getDistancia() + "km</strong> de distancia del flete:"
                + " <strong>$" + precio + "</strong><br>"
                + "Ponte en contacto con el fletero para coordinar a&uacute;n m&aacute;s el flete."
                + "<br><hr><br>"
                + "easyFlete - Grupo 15 - Tsig"
                + "<br><hr>"
                + fecha + " | " + hora;
        try {
            SendEmail(c.getUsername(), "Solicitud Aceptada | easyFlete", texto);
        } catch (MessagingException ex) {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendSolicitudAceptadaToFletero(Fletero f, Solicitud s, Cliente c, double precio) {
        String fecha = (Calendar.getInstance().get(Calendar.YEAR) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.DATE));
        String hora = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));
        String texto = "Estimado " + f.getNombre() + ",<br>"
                + "Le informamos que has aceptado la solicitud: <strong>" + s.getTitulo() + "</strong><br>"
                + "<hr><br><br>"
                + "<strong>Detalles del Cliente:</strong><br>"
                + "Nombre: " + c.getNombre() + "<br>"
                + "Email: " + c.getUsername() + "<br>"
                + "Telefono: " + c.getTelefono() + "<br>"
                + "<br><hr><br>"
                + "Costo calculado para los <strong>" + s.getDistancia() + "km</strong> de distancia del flete:"
                + " <strong>$" + precio + "</strong><br>"
                + "Ponte en contacto con el fletero para coordinar a&uacute;n m&aacute;s el flete."
                + "<br><hr><br>"
                + "easyFlete - Grupo 15 - Tsig"
                + "<br><hr>"
                + fecha + " | " + hora;
        try {
            SendEmail(c.getUsername(), "Solicitud Aceptada | easyFlete", texto);
        } catch (MessagingException ex) {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendUsuarioRegistradoMail(Usuario c) {
        String fecha = (Calendar.getInstance().get(Calendar.YEAR) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.DATE));
        String hora = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));
        String texto = "Estimado " + c.getNombre() + ",<br>"
                + "Tu Registro en easyFlete se ha completado.<br>"
                + "<hr><br><br>"
                + "<strong>Informaci&oacute;n:<strong><br>"
                + "Email: " + c.getUsername() + "<br>"
                + "Telefono: " + c.getTelefono() + "<br>"
                + "<br><hr><hr>"
                + "easyFlete - Grupo 15 - Tsig"
                + "<br><hr>"
                + fecha + " | " + hora;
        try {
            SendEmail(c.getUsername(), "Registro completado | easyFlete", texto);
        } catch (MessagingException ex) {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
