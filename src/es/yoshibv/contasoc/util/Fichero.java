package es.yoshibv.contasoc.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Fichero {
	public static List<String> leerFichero(String nomfich){
		/* Método que recibe un String que es la ruta del fichero a leer
		 * para luego intentar leer el fichero por línea y asignarlo en l.
		 * Lanza una IOException si hay algún error al leer el fichero. 
		 * Devuelve la lista de Strings de haber leído el fichero. */
		List<String> l=null;
		try {
			l = Files.lines(Paths.get(nomfich),StandardCharsets.UTF_8).toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static void escribeFichero(String cadena, String nombreFichero) {
		/* Método que recibe como parámetro una string a escribir y una string que 
		 * es la ruta del fichero donde se va a escribir dicha string.
		 * Lanza una IOException si hay algún error al escribir en el fichero. */
		 try {
			BufferedFileWriter writer = new BufferedFileWriter(nombreFichero,"UTF-8",false);
			writer.flush();
			writer.write(cadena);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void añadirAlFichero(String cadena, String nombreFichero) {
		/* Método que recibe como parámetro una string a escribir y una string que 
		 * es la ruta del fichero donde se va a añadir dicha string.
		 * Lanza una IOException si hay algún error al añadir la string en el fichero. */
		 try {
			 BufferedFileWriter writer = new BufferedFileWriter(nombreFichero,"UTF-8",true);
			 writer.append('\n');
			 writer.append(cadena);
			 writer.close();
		 } catch(IOException e) {
			 e.printStackTrace();
		 }
	}
}
