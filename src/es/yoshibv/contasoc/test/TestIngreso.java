package es.yoshibv.contasoc.test;

import java.time.LocalDate;

import es.yoshibv.contasoc.common.TipoRetribucion;
import es.yoshibv.contasoc.ingreso.Ingreso;

public class TestIngreso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingreso i = new Ingreso(LocalDate.of(2023, 6, 29),"Test",60.0,TipoRetribucion.BANCO);
		System.out.println(i);
	}

}
