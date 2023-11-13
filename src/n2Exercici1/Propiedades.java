package n2Exercici1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Propiedades {
	
	private static final String ARCHIVO = "C:\\Users\\Public\\Downloads\\config.properties";
	
	String rutaTxt = Entrada.llegirString("Introduza el nombre y la ruta donde guardar el archivo\n"
				+ "Ejemplo: /Users/Public/Downloads/nombreArchivo.txt");

	String rutaInicio = Entrada.llegirString("Introduce la ruta desde donde inicaremos el recorrido\n"
				+ "Ejemplo: /Users/GeneralmenteEsSuUsuario/Documents");
	
	public Propiedades () {
	}
		
	public void escribirPropiedades () {
				
		try (OutputStream ops = new FileOutputStream(ARCHIVO)) {

			Properties properties = new Properties();

			properties.setProperty("rutaInicio", rutaInicio);
			properties.setProperty("rutaTxt", rutaTxt);

			properties.store(ops, "inicio config");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
}
