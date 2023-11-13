package n1Exercici4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsoDirectorio {

	public static void leerArchivoTxt() {

		String ruta = null;
		ruta = Entrada.llegirString("Dama le ruta del archivo a leer");

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

			String linea = null;
			linea = br.readLine();

			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("No se encuentra el archivo");

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	}
