package es.exmaster.contasoc;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import es.exmaster.contasoc.gui.NewMainWindow;
import es.exmaster.contasoc.util.ErrorHandler;

public class Main {
	public static final String VERSION_APP = "Contasoc v5.1.0";
	public static final String ESCRITORIO = "C:/Users/" + System.getenv("USERNAME") + "/Desktop";
	public static final String BDD = "C:/Contasoc/contasoc.db";
	
	public static void main(String[] args) {

		try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new NewMainWindow().setVisible(true);
        });
        
        initFolder();
        initBDD();
		
	}
	
	private static void initFolder() {
		String folderPath = "C:/Contasoc";
		File[] documents = new File("C:/").listFiles();
		
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
	
	private static void initBDD() {
		String contasocFolderPath = "C:/Contasoc";
		
		File db = new File(contasocFolderPath, "contasoc.db");
		
    	if(!(db.exists())) {
    		try {
    	        db.createNewFile();
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
}
