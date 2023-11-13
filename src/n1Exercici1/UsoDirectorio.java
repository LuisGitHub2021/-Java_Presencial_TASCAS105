package n1Exercici1;

import java.io.File;
import java.util.Arrays;

public class UsoDirectorio {

	public static void mostrarDirectorioAtoZ() {

		File ruta = null;
		ruta = new File(
				Entrada.llegirString("Introduce una ruta\n" + "Ejemplo 1: c:\\...\\...\n" + "Ejemplo 2: .../.../"));
		
		// Podriamos hacer un archio indicando ubicacion e imprimir pero no garantizamos
		// el orden
		/*
		 * File carpeta = new File("C:\\Users\\luiss\\eclipse-workspace\\TestGit4"); for
		 * (File string : carpeta.listFiles()) { System.out.println(string); }
		 */

		String[] lista = ruta.list();
		// Asi garantizamos el orden natural
		// El orden natural de los String en Java es ascendente, alfanumérico, con las
		// siguientes prioridades:
		// 1º blancos, 2º números (Ejemplo: «2»), 3º mayúsculas de A-Z, 4º minúsculas de
		// a-z.
		Arrays.sort(lista);
		for (String dir : lista) {
			System.out.println(dir);

		}
	}
}
