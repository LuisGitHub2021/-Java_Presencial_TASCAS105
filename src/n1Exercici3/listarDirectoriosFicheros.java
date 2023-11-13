package n1Exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import n2Exercici1.Entrada;

public class listarDirectoriosFicheros {
	
	public static Visitor fileListRecorridoAtoZ() {

		String rutaInicio = Entrada
				.llegirString("Para escribir en un archivo txt un recorrido ordenado por directorios y archivos,\n"
						+ "Introduce la ruta desde donde inicaremos el recorrido\n" + "Ejemplo: /.../...");

		Visitor visitor = new Visitor();

		try {
			Files.walkFileTree(Paths.get(rutaInicio), EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return visitor;

	}
	
	public static void escribirRecorridoTxtAtoZ(Visitor visitor) {

		String rutaTxt = Entrada
				.llegirString("Para escribir en un archivo txt el recorrido ordenado AtoZ por directorios y archivos,\n"
						+ "Introduce la ruta y nombre del archivo que quieres crear\n" + "Ejemplo: /.../...");

		File fileTxt = new File(rutaTxt);

		FileWriter fw = null;
		BufferedWriter bw;

		try {
			fw = new FileWriter(fileTxt);

			bw = new BufferedWriter(fw);

			for (Path path : visitor.fileList) {

				if (path.toFile().isDirectory()) {

					bw.write("D " + path.getFileName() + "\n");

				} else {

					bw.write("F " + path.getFileName() + " " + visitor.attrsMap.get(path.getFileName().toString()) + "\n");

				}

			}

			bw.close();
			fw.close();
			System.out.println("Ya lo tienes, Gracias!");
		} catch (IOException e) {

		}

	}

}
	


