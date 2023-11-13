package n1Exercici5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializar {
	
	
	public static <T> void serializa(T t) {
		
		String rutaSer = Entrada.llegirString("Introduce la ruta donde guardar el archivo serializado y su nombre sin extension\n"
				+ "Ejemplo: /Users/Public/Downloads/nombreArchivo")+".ser";
		
		final String FILE_NAME = rutaSer;
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			try {
				oos.writeObject(t);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public static <T> void deSerializa(T t) {
		
		String rutaSer = Entrada.llegirString("\"Introduce la ruta donde ir abuscar el archivo con y extension para deserializar\n"
				+ "Ejemplo: /Users/Public/Downloads/nombreArchivo.ser");
		
		final String FILE_NAME = rutaSer;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			
				try {
					T t1= (T) ois.readObject();
					System.out.println(t1.toString());
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}

}	
}	

	

