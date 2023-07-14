package es.yoshibv.contasoc.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import es.yoshibv.contasoc.ContasocDAO;

import es.yoshibv.contasoc.util.BufferedFileWriter;

import java.io.File;

public class CodePlayground {

	public static void main(String[] args) {
		try {
			for(String s:Files.readAllLines(Path.of("./data/test.csv"))) {
				String[] t = s.split(";");
				String socio = ContasocDAO.getValorPorPropiedad("hortelanos", "nombre", t[0], "numSocio");
				BufferedFileWriter bf = new BufferedFileWriter(new File("./data/test2.csv"));
				bf.write(socio+"\n");
				print("A");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void print(Object o) {
		System.out.println(o);
	}
}
