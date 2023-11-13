package n1Exercici5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Jugador implements Serializable{

	private String name;
	private int puntuacion;

	public Jugador() {

		try {
			this.name = Entrada.llegirString("Nombre del jugador: ");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// getters & setters
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public static Jugador iniciar() {

		Jugador jugador = new Jugador();

		// instanciar archivo a escribir y el escritor del archivo
		File clasificacion = null;
		FileWriter clasificacionWriter = null;
		PrintWriter escribirClasificacion = null;

		// instanciar archivo a leer, su lector, almacen de toda la lectura del archivo
		File countries = null;
		FileReader lectorCountries = null;
		BufferedReader almacenCountries = null;

		// asignacion archivo a leer como el lector del archivo
		try {
			clasificacion = new File("src/n1Exercici5/clasificacion.txt");
			countries = new File("src/n1Exercici5/countries.txt");
			lectorCountries = new FileReader(countries);
		} catch (FileNotFoundException e) {
			System.out.println("No podemos acceder al archivo de paises y capitales, dirección incorrecta");
		}

		// crear HashMap donde guardar pais y capital
		// HashMap como tabla de dos columnas, de cualquier elemento u objeto,
		// los relaciona como key y value
		// key unica e irrrepetible. Potente en almacenar y obtener informacion
		HashMap<String, String> listadoPaisCapitales = new HashMap<String, String>();

		int num = 0;
		List<Integer> list = new ArrayList<Integer>();

		// crear archivo donde escirbir
		try {
			// para poder escribir sin borrar lo anterior
			clasificacionWriter = new FileWriter(clasificacion.getAbsoluteFile(), true);

			// instanciar, asignar en BufferedReader más eficiente y mejor gestion contenido
			almacenCountries = new BufferedReader(lectorCountries);

			// string donde poner la lectura y asignamos lectural primera linea
			String todoCountriesString = almacenCountries.readLine();

			while (todoCountriesString != null) {
				// creo listado enteros para posteriormente hacer un random que no se repita
				list.add(num);
				// array donde poner las diferentes subcadenas del String principal
				String[] paisCapital = todoCountriesString.split(" ");

				// añadir al HashMap los elementos
				listadoPaisCapitales.put(paisCapital[0], paisCapital[1]);
				todoCountriesString = almacenCountries.readLine();
				num++;
			}
		} catch (IOException e) {
			System.out.println("No se ha podido crear archivo para recoger puntuaciones, dirección incorrecta");
		}

		int numero;
		Object pais = null;
		String candidatoRespuesta = null;
		int punts = 0;

		try {
			for (int i = 0; i < 10; i++) {

				Collections.shuffle(list);
				numero = list.get(0);
				list.remove(0);
				Collections.sort(list);

				pais = listadoPaisCapitales.keySet().toArray()[numero];
				System.out.println(pais);

				// solicitar respuesta OK
				try {
					candidatoRespuesta = Entrada.llegirString("Capital:");
				} catch (Exception e) {

					e.printStackTrace();
				}

				// valorar repuesta
				if (listadoPaisCapitales.get(pais).equalsIgnoreCase(candidatoRespuesta)) {
					punts++;

					// añadimos puntos al usuario
					jugador.setPuntuacion(punts);
					System.out.println(jugador.name + " " + jugador.puntuacion + "pt");

				} else {
					System.out.println("La respuesta correcta es: " + listadoPaisCapitales.get(pais));

				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {

			e.printStackTrace();

		}

		escribirClasificacion = new PrintWriter(clasificacionWriter);
		//Esta es la linea que escribe en el archivo
		escribirClasificacion.println(jugador.name + " " + jugador.puntuacion + "pt");

		try {
			// cerramos el archivo una vez escrito
			// en caso contrario no queda escrito
			if (null != clasificacionWriter && null != lectorCountries)
				clasificacionWriter.close();
			lectorCountries.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (lectorCountries != null && clasificacion != null) {
			System.out.println("Total: " + jugador.name + " " + jugador.puntuacion + "pt");
		}
		return jugador;

	}

	@Override
	public String toString() {
		return "Jugador [name=" + name + ", puntuacion=" + puntuacion + "]";
	}
	
	
}