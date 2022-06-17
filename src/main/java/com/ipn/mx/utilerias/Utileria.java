/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.utilerias;

/**
 *
 * @author escom
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utileria {

    public void enviarMail(String correoDestinatario, String asunto, String textoCorreo) {
        try {
            //Propiedades de la conexion
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");

            //Inicializar la sesion 
            Session session = Session.getDefaultInstance(props);

            //El mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress(correoDestinatario));

            //CC A quien se le envia una copia Oculta
            //BCC A quien se le envia una copia Oculta
            message.setSubject(asunto);
            message.setText(textoCorreo);

            //Enviar mensaje
            Transport transporte = session.getTransport("smtp");
            transporte.connect("cuenta@gmail.com", "contraseña");
            transporte.sendMessage(message, message.getAllRecipients());

            //Cierre
            transporte.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Activar en la cuenta el conectarse a aplicaciones no seguras
    public void main() {
        Utileria u = new Utileria();
        String correoDestinatario = "destinatario@ipn.mx";
        String asunto = "Registro";
        String textoCorreo = "Hemos recibido satisfactoriamente su solicitud de registro ...";
        u.enviarMail(correoDestinatario, asunto, textoCorreo);
        //u.enviarMail(dto.getEntidad(), "asunto", "textoCorreo");
    }

/*
metodo en el DAO de articulo 
pide la categoria y cuenta cuantos articulos existen en la categoria
regresa el nombre de la categoria y la cantidad de articulos por categoria

public class DatosGrafica {
private String nombre;
private int cantidad;
public DatosGrafica () {
//Metodos gets y sets
//Metodo toString
}
}
*/

}
