package n2Exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class listarDirectoriosFicheros {
	
	public static Visitor fileListRecorridoAtoZ() {
			
		Visitor visitor = new Visitor();

		try {
			Files.walkFileTree(Paths.get(Config.leer("rutaInicio")), EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return visitor;

	}
	
	public static void escribirRecorridoTxtAtoZ(Visitor visitor) {
				
		File fileTxt = new File(Config.leer("rutaTxt"));

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
	


