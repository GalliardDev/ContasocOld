package dev.galliard.contasoc.test;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

public class ReciboPersonalizado {

    public static void main(String[] args) {
    	String dia = "14";
        String mes = "agosto";
        String anyo = "2023";
        String ciudad = "Sevilla";
        String nombre = "Pepito Grillo";
        String cantidad = "60";
        String numero = "1";
        String concept = "Este es un concepto muy muy muy muy muy largo, tan tan tan tan tan tan tan largo que hay que exagerar muchichichichichichichichichichísimo para que lo sea.";
        String numSocio = "24";
        Document document = new Document(new Rectangle(453.0f, 283.5f)); // Tamaño en puntos (1 cm = 28.35 puntos)
        
        
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Recibo_Personalizado.pdf"));
            document.open();

            // Configurar fuente y tamaño
            float fontSize = 12;
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA, fontSize + 8, Font.BOLD);

            // Agregar imagen de marca de agua
            PdfContentByte content = writer.getDirectContentUnder();
            Image img = Image.getInstance("C:/Users/jomaa/Desktop/logohuerto_sinletras.png"); // Cambia la ruta a la ubicación de tu imagen
            img.scaleAbsolute(353.0f, 133.5f);
            img.setAbsolutePosition((document.getPageSize().getWidth() - img.getScaledWidth()) / 2, (document.getPageSize().getHeight() - img.getScaledHeight()) / 2); // Centrar la imagen
            // Configurar la transparencia de la imagen de marca de agua
            PdfGState gs1 = new PdfGState();
            gs1.setFillOpacity(0.3f); // Cambia la transparencia (0.0f a 1.0f)
            content.setGState(gs1);
            content.addImage(img);

            // Crear bordes
            Rectangle rect = new Rectangle(20, 20, 433.0f, 263.5f);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            document.add(rect);

            // Encabezado del recibo
            Paragraph encabezado = new Paragraph();
            encabezado.setFont(tituloFont);
            encabezado.add("RECIBO ");
            encabezado.add(new Paragraph("Nº" + numero, FontFactory.getFont(FontFactory.HELVETICA, fontSize))); // Agregar el número de recibo en la misma línea
            encabezado.setAlignment(Paragraph.ALIGN_LEFT);
            encabezado.setSpacingBefore(10);
            document.add(encabezado);

            // Fecha
            Paragraph fecha = new Paragraph("En " + ciudad + " a " + dia + " de " + mes + " de " + anyo, FontFactory.getFont(FontFactory.HELVETICA, fontSize)); // Poner la fecha en negrita
            fecha.setAlignment(Paragraph.ALIGN_LEFT);
            fecha.setSpacingBefore(10);
            document.add(fecha);

            // Recibido de
            Paragraph recibidoDe = new Paragraph("Recibí de " + nombre + " con Nº de Socio " + numSocio + " la cantidad de " + cantidad +" euros (€)", FontFactory.getFont(FontFactory.HELVETICA, fontSize)); // Poner los valores en negrita
            recibidoDe.setSpacingBefore(10);
            document.add(recibidoDe);

            // Concepto
            Paragraph conceptoParrafo = new Paragraph("Por concepto de " + concept, FontFactory.getFont(FontFactory.HELVETICA, fontSize)); // Poner el concepto en negrita y cursiva
            conceptoParrafo.setSpacingBefore(10);
            document.add(conceptoParrafo);

            document.close();
            System.out.println("Recibo personalizado creado exitosamente.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}