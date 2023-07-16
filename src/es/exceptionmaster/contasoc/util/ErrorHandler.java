package es.exceptionmaster.contasoc.util;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import es.exceptionmaster.contasoc.gui.NewMainWindow;

public class ErrorHandler {
	private static NewMainWindow main = new NewMainWindow();
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
	public static void socioAgregado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha agregado el socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void socioModificado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha modificado el socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void socioEliminado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha eliminado el socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
	public static void ingresoAgregado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha agregado el ingreso al socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void ingresoModificado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha modificado el ingreso al socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void ingresoEliminado(Integer num) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha eliminado el ingreso del socio nº " + num, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void pagoAgregado(String fac) {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha agregado el pago con factura: " + fac, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void pagoModificado() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha modificado el pago", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void pagoEliminado() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha eliminado el pago", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
	public static void pdfCreado() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha generado el PDF y se ha guardado en el Escritorio", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void errorNumeroColumnas() {
		JOptionPane.showMessageDialog(main.getContentPane(), "El número de columnas no coincide con el número de nuevos valores", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public static void mailEnviado() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha enviado el email al/los destinatario/s especificado/s", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void borradorGuardado() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha guardado el borrador en el Escritorio", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void error() {
		JOptionPane.showMessageDialog(main.getContentPane(), "Se ha producido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
