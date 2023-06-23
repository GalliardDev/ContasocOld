package es.yoshibv.contasoc.test;

import java.time.LocalDate;

import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.Persona;
import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.Tipo;

public class TestHortelano {
	public static void main(String[] args) {
		Persona p = new Persona("John","Doe","12345678A","Calle Falsa 123","600700800","jdoe@mail.com");
		Hortelano h = new Hortelano(p,1,1,LocalDate.now(),null,Estado.ACTIVO,Tipo.HORTELANO);
		System.out.println(h.toString());
		
	}
	
			
}
