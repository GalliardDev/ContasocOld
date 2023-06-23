package es.yoshibv.contasoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.UIManager;

import es.yoshibv.contasoc.util.Fichero;
import es.yoshibv.contasoc.ventanas.Inicio;

public class Main {
	
	public static final String HORTELANOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/hortelanos.csv";
	public static final String INGRESOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/ingresos.csv";
	public static final String PAGOS = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/pagos.csv";
	public static final String LISTA_ESPERA = "C:/Users/" + System.getenv("USERNAME") + "/Documents/Contasoc/lista_espera.csv";
	
	public static void main(String[] args) {
		
		createFolder();
		initFiles();
		initFileValues();

        try {
        	javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
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
					e.printStackTrace();
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
		
    	if(!(hortelanos.exists() && pagos.exists() && lista_espera.exists())) {
    		try {
    	        hortelanos.createNewFile();
    	        ingresos.createNewFile();
    	        pagos.createNewFile();
    	        lista_espera.createNewFile();
    	        System.out.println("Archivos creados correctamente.");
    	    } catch (IOException e) {
    	        System.out.println("Error al crear los archivos.");
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
