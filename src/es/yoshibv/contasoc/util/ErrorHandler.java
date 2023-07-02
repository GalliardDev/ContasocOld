package es.yoshibv.contasoc.util;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import es.yoshibv.contasoc.gui.MainWindow;

public class ErrorHandler {
	private static MainWindow main = new MainWindow();
	JOptionPane jop = new JOptionPane();
	public static void camposObligatoriosVacios() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay campos obligatorios vacíos", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void socioNoExiste() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "No existe un socio con ese número de socio", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void socioYaExiste() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Ya existe un socio con ese número de socio", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void tipoSocioNoAdecuado() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "El tipo de socio no es el adecuado", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void numeroHuertoVacio() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Introducir número de huerto", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void ingresoNoExiste() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "No hay ingresos registrados de ese socio o ese socio no existe", "Error", JOptionPane.ERROR_MESSAGE);		
	}
	public static void errorAlCrearDirectorio() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hubo un error al crear una carpeta necesaria para la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlCrearBDD() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hubo un error al crear la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void BDDCreada() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha creado la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void errorAlLeerBDD(String bdd) throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hubo un error al leer la BDD de " + bdd, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlEscribirBDD(String bdd) throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hubo un error al escribir en la BDD de " + bdd, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerFecha(String fecha) throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato de la fecha de " + fecha, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerTlf() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato del número de teléfono", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerDNI() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato del DNI", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerCorreo() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato del correo", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerTipoSocio() throws HeadlessException {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato del tipo de socio", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerCantidadNumerica(String cantidad) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato de " + cantidad, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void errorAlLeerTipoRetr() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Hay un error en el formato del tipo de ingreso/pago", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
