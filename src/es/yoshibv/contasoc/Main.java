package es.yoshibv.contasoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;

import es.yoshibv.contasoc.gui.MainWindow;
import es.yoshibv.contasoc.util.ErrorHandler;
import es.yoshibv.contasoc.util.Fichero;

public class Main {
	public static final String VERSION_APP = "Contasoc v2.4.1";
	public static final String ESCRITORIO = "C:/Users/" + System.getenv("USERNAME") + "/Desktop";
	public static final String HORTELANOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/hortelanos.csv";
	public static final String INGRESOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/ingresos.csv";
	public static final String PAGOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/pagos.csv";
	public static final String LISTA_ESPERA = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/lista_espera.csv";
	public static final String SALDO = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/saldo.csv";
	
	public static void main(String[] args) {

		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
        
        createFolder();
		initFiles();
		initFileValues();
	}
	
	private static void createFolder() {
		String folderPath = System.getProperty("user.home") + "\\Documents\\Contasoc";
		File[] documents = new File(System.getProperty("user.home") + "\\Documents").listFiles();
		
		for(File f:documents) {
			if(!(f.getName().equals("Contasoc"))) {
				try {
					Files.createDirectories(Paths.get(folderPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					ErrorHandler.errorAlCrearDirectorio();
				}	
			}
		}
	}
	
	private static void initFiles() {
		String contasocFolderPath = System.getProperty("user.home") + "/Documents/Contasoc";
		
		File hortelanos = new File(contasocFolderPath, "hortelanos.csv");
		File ingresos = new File(contasocFolderPath, "ingresos.csv");
		File pagos = new File(contasocFolderPath, "pagos.csv");
		File lista_espera = new File(contasocFolderPath, "lista_espera.csv");
		File saldo = new File(contasocFolderPath, "saldo.csv");
		
    	if(!(hortelanos.exists() && pagos.exists() && lista_espera.exists() && ingresos.exists() && saldo.exists())) {
    		try {
    	        hortelanos.createNewFile();
    	        ingresos.createNewFile();
    	        pagos.createNewFile();
    	        lista_espera.createNewFile();
    	        saldo.createNewFile();
    	        System.out.println("Archivos creados correctamente.");
    	        ErrorHandler.BDDCreada();
    	    } catch (IOException e) {
    	        System.out.println("Error al crear los archivos.");
    	        ErrorHandler.errorAlCrearBDD();
    	    }
    	} else {
    	    System.out.println("Los archivos ya existen.");
    	}
	}
	
	private static void initFileValues() {
		File hortelanos = new File(HORTELANOS);
		if(hortelanos.length()==0L) {
			Fichero.escribeFichero("nombre;apellidos;dni;direccion;000000000;correo;0;0;1/1/1901;2/1/1901;INACTIVO;HORTELANO", HORTELANOS);
		}
	}
	
}
