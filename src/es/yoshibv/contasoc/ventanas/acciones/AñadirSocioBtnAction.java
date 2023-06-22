package es.yoshibv.contasoc.ventanas.acciones;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JTextPane;

import es.yoshibv.contasoc.FactoriaHortelano;


public class AñadirSocioBtnAction {
	public static void añadirSocio(List<JTextPane> lista) {
		List<String> aux = new ArrayList<String>();
		for(JTextPane tp:lista) {
			aux.add(tp.getText());
		}
		String nombre = lista.get(0).getText();
		String apellidos = lista.get(1).getText();
		String dni = lista.get(2).getText();
		String direccion = lista.get(3).getText();
		String telefono = lista.get(4).getText();
		String correo = lista.get(5).getText();
		String socio = lista.get(6).getText();
		String huerto = lista.get(7).getText();
		String alta = lista.get(8).getText();
		String baja = "null";
		String estado = "ACTIVO";
		String tipo = lista.get(10).getText();
		
		String hortelano = String.join(";", List.of(nombre,apellidos,dni,direccion,telefono,correo,socio,huerto,alta,baja,estado,tipo))+";";
		FactoriaHortelano.añadeHortelano(hortelano, "./data/hortelanos.csv");
	}
}
