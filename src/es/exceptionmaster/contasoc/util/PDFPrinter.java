package es.exceptionmaster.contasoc.util;

import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JTable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFPrinter {


    public static void printStringToPDF(
        List<String> inputs, 
        int numColumns,
        float[] columnWidths, 
        String logoPath, 
        String tituloTabla, 
        boolean mostrarTitulos, 
        String[] columnTitles, 
        boolean rotar,
        int tamañoFuente, 
        String outFile) {
    Document document = null;
    if(rotar){
        document = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 10f);
    } else{
        document = new Document(PageSize.A4, 10f, 10f, 10f, 10f);
    }
    try {
        PdfWriter.getInstance(document, new FileOutputStream(outFile));
        document.open();

        // Encabezado
        Paragraph header = new Paragraph();
        header.add(new Phrase("Asociación Huertos la Salud Bellavista\nC/ Cronos SN, Bellavista, 41014 Sevilla\nhuertoslasaludbellavista@gmail.com"));
        header.setAlignment(Element.ALIGN_RIGHT);
        document.add(header);

        // Logo
        Image logo = Image.getInstance(PDFPrinter.class.getClassLoader().getResource("imagenes/"+logoPath));
        logo.setAbsolutePosition(0, document.getPageSize().getHeight()-87f);
        document.add(logo);

        // Título de la tabla
        Paragraph title = new Paragraph(tituloTabla);
        title.setFont(new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Tabla
        PdfPTable table = new PdfPTable(numColumns);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        if(mostrarTitulos){
            // Títulos de las columnas
            for (String columnTitle : columnTitles) {
                PdfPCell cell = new PdfPCell(new Phrase(columnTitle,new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setBorderWidthTop(1f);
                cell.setBorderWidthBottom(1f);
                cell.setBorderWidthLeft(0f);
                cell.setBorderWidthRight(0f);
                table.addCell(cell);
            }
        }

        // Datos
        for (String input : inputs) {
            String[] fields = input.split(";");
            if (fields.length != numColumns) {
                System.out.println("La cadena de entrada debe tener " + numColumns + " campos separados por ';'");
                return;
            }
            for (String field : fields) {
                PdfPCell cell = new PdfPCell(new Phrase(field,getFont(tamañoFuente)));
                cell.setBorderWidthTop(0f);
                cell.setBorderWidthBottom(0.5f);
                cell.setBorderWidthLeft(0f);
                cell.setBorderWidthRight(0f);
                table.addCell(cell);
            }
        }

        table.setWidths(columnWidths);

        document.add(table);

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        document.close();
    }
}


    public static void printTableToPDF(JTable table, String filename, int tamañoFuente) {
        Document document = new Document(new Rectangle(PageSize.A4.getWidth(), PageSize.A4.getHeight()).rotate());
        document.setMargins(0, 0, 10f, 10f);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            float[] columnWidths = { 65f, 105f, 40f, 185f, 35f, 90f, 15f, 15f, 35f, 35f, 35f, 90f };
            pdfTable.setWidths(columnWidths);
            pdfTable.setTotalWidth(745f);
            pdfTable.setLockedWidth(true);
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    PdfPCell cell = new PdfPCell(new Paragraph(value.toString(), getFont(tamañoFuente)));
                    pdfTable.addCell(cell);
                }
            }
            document.add(pdfTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }

    private static Font getFont(int tamaño) {
        Font font = new Font(Font.FontFamily.HELVETICA, tamaño);
        return font;
    }
}