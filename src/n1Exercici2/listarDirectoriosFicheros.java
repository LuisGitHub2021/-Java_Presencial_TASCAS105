package n1Exercici2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

public class listarDirectoriosFicheros {
	
	public static void mostrarAtoZ() {
		
		System.out.println("Para listar de forma natural el recorrido de directorios y archivos,\n"
				+ "precisamos nos indiques la ruta donde donde empezar el recorrido. Gracias!");
		
		String ruta = Entrada
				.llegirString("Introduce la ruta desde donde inicaremos el recorrido\n" + "Ejemplo: /.../...");
		
		Visitor visitor=new Visitor();
		
		try {
				Files.walkFileTree(Paths.get(ruta), EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);
			
		} catch (IOException e) {
			
				e.printStackTrace();
			}
		
		for (String string : visitor.fileList) {
			System.out.println(string);
			
		}
	
	}
}	


