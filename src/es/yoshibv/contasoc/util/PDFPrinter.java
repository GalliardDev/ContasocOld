package es.yoshibv.contasoc.util;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import es.yoshibv.contasoc.Main;

public class PDFPrinter {
    public static void printFromString(String content, String filename) {
        // Crear el documento PDF
        Document document = new Document(PageSize.A4);

        try {
            // Crear un escritor de PDF para guardar el documento en un archivo
            PdfWriter.getInstance(document, new FileOutputStream(filename));

            // Abrir el documento para agregar contenido
            document.open();

            // Agregar el contenido al documento
            Font font = new Font(Font.FontFamily.HELVETICA, 12);
            Paragraph paragraph = new Paragraph(content, font);
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }
    
    public static void printFromPrintable(Printable printable) {
        // Crear el documento PDF
        Document document = new Document(PageSize.A4);

        try {
            // Crear un escritor de PDF para guardar el documento en un archivo
            PdfWriter.getInstance(document, new FileOutputStream(Main.ESCRITORIO+"/output.pdf"));

            // Abrir el documento para agregar contenido
            document.open();

            // Crear un objeto PrinterJob
            PrinterJob printerJob = PrinterJob.getPrinterJob();

            // Asignar el objeto Printable al PrinterJob
            printerJob.setPrintable(printable);

            // Imprimir en el documento PDF
            printerJob.print();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (PrinterException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }
    
    public static void printTableToPDF(JTable table, String filename) {
        Document document = new Document(new Rectangle(PageSize.A4.getWidth(), PageSize.A4.getHeight()).rotate());
        document.setMargins(0,0,10f,10f);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            float[] columnWidths = {65f,105f,40f,185f,35f,90f,15f,15f,35f,35f,35f,90f};
            pdfTable.setWidths(columnWidths);
            pdfTable.setTotalWidth(745f);
            pdfTable.setLockedWidth(true);
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    PdfPCell cell = new PdfPCell(new Paragraph(value.toString(), getFont()));
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
    
    private static Font getFont() {
        Font font = new Font(Font.FontFamily.HELVETICA, 6);
        return font;
    }
}