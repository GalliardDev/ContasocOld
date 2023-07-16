package es.exceptionmaster.contasoc.util;

import javax.mail.*;
import javax.mail.internet.*;

import es.exceptionmaster.contasoc.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class EmailSender {
	public static String MSG_BEFORE = "<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "\r\n"
			+ "<head>\r\n"
			+ "    <style>\r\n"
			+ "        /* Inline CSS */\r\n"
			+ "        .container {\r\n"
			+ "            border: 1px solid #dddddd;\r\n"
			+ "            border-radius: 5px;\r\n"
			+ "            padding: 20px;\r\n"
			+ "            max-width: 400px;\r\n"
			+ "            margin: 0 auto;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        .logo {\r\n"
			+ "            display: block;\r\n"
			+ "            margin: 0 auto;\r\n"
			+ "            max-width: 200px;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        .title {\r\n"
			+ "            text-align: center;\r\n"
			+ "            font-size: 24px;\r\n"
			+ "            color: #333333;\r\n"
			+ "            margin-top: 20px;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        .body {\r\n"
			+ "            margin-top: 20px;\r\n"
			+ "            color: #555555;\r\n"
			+ "            font-size: 16px;\r\n"
			+ "        }\r\n"
			+ "\r\n"
			+ "        .contact-info {\r\n"
			+ "            margin-top: 20px;\r\n"
			+ "            font-size: 14px;\r\n"
			+ "            color: #777777;\r\n"
			+ "            text-align: center;\r\n"
			+ "        }\r\n"
			+ "    </style>\r\n"
			+ "</head>\r\n"
			+ "\r\n"
			+ "<body>\r\n"
			+ "    <div class=\"container\">\r\n"
			+ "        <img src=\"https://png2.cleanpng.com/sh/d21d05f943124a9e8bd369f2a6fc7b46/L0KzQYm3UsE4N5DBj5H0aYP2gLBuTgNmdqR0ius2Z3H1dLb1TfNwdZ56htt9eT3qccPrhf5qdpgye95ycD3kgsW0hwJ2caUyf9N7ZHXxPbTzigBieqV4RadqOEjmSYPsUfUyPJU5RqQ6N0KzRYO4UcUyQGo2S6o8OEG1Q4O1kP5o/kisspng-sensory-garden-community-gardening-clip-art-fruit-garden-cliparts-5a88c92e1e14d4.2172052115189138381232.png\" class=\"logo\">\r\n"
			+ "        <h4 class=\"title\">Huertos la Salud Bellavista</h4>\r\n"
			+ "        <p class=\"body\">Estimado/s socio/s,</p>\r\n"
			+ "        <p class=\"body\">";
	public static String MSG_AFTER = "</p>\r\n"
			+ "        <p class=\"body\">Atte. La Directiva</p>\r\n"
			+ "        <div class=\"contact-info\">\r\n"
			+ "            <p>Direccion: C/ Cronos SN, Bellavista, Sevilla, 41014</p>\r\n"
			+ "            <p>Email: huertoslasaludbellavista@gmail.com</p>\r\n"
			+ "        </div>\r\n"
			+ "    </div>\r\n"
			+ "</body>\r\n"
			+ "\r\n"
			+ "</html>";
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String SMTP_USERNAME = "huertoslasaludbellavista@gmail.com";
    private static final String SMTP_PASSWORD = "ixdmevohktgjkoau";
    private static final String SENDER_EMAIL = "huertoslasaludbellavista@gmail.com";

    public static void sendEmail(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_SERVER);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html");

            Transport.send(message);
            System.out.println("Correo enviado");
        } catch (Exception e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
    
    public static void crearBorrador(String destinatario, String asunto, String cuerpo) {
    	String path = Main.ESCRITORIO+"/borrador.html";
    	File borrador = new File(path);
    	try {
			borrador.createNewFile();
			ErrorHandler.borradorGuardado();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ErrorHandler.error();
		}
    	String msg = "<center><p>para: "+ destinatario +"</p></center>" +
    			"<center><p>asunto: "+ asunto +"</p></center>"+
    			MSG_BEFORE+cuerpo+MSG_AFTER;
    	try {
			Files.writeString(Path.of(path), msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ErrorHandler.error();
		}
    }
}

