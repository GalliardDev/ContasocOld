package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.util.DNIValidator;

public class TestHortelano {
	public static void main(String[] args) {
		//Persona p = new Persona("John","Doe","12345678A","Calle Falsa 123","600700800","jdoe@mail.com");
		//Hortelano h = new Hortelano(p,1,"1",LocalDate.now(),null,Estado.ACTIVO,Tipo.HORTELANO);
		//System.out.println(h.toString());
		
		//Hortelano h = FactoriaHortelano.parseaHortelanoCsv("5;BENITO;PAREDES PAREDES;8670506W;CALLE ENAMORADOS  87 CASA 41014 SEVILLA;671776543;;46;22/06/2010;null;ACTIVO;HORTELANO_INVERNADERO");
		System.out.println(DNIValidator.validarNIE("Y6690864V"));	
	}
	
			
}
