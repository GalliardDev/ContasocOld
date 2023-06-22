package es.yoshibv.contasoc.test;

import java.time.LocalDate;

import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.Persona;
import es.yoshibv.contasoc.common.Cuota;
import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.Tipo;
import es.yoshibv.contasoc.ingreso.Ingreso;

public class TestHortelano {
	public static void main(String[] args) {
		Persona p = new Persona("John","Doe","12345678A","Calle Falsa 123",600700800,"jdoe@mail.com");
		Ingreso i = new Ingreso(LocalDate.now(),"Insertar_concepto",60.0,Cuota.ANUAL);
		Hortelano h = new Hortelano(p,1,1,LocalDate.now(),null,Estado.ACTIVO,Tipo.HORTELANO);
		h.añadirIngreso(i);
		System.out.println(h.toString());
		
	}
	
			
}
