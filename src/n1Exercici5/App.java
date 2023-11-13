package n1Exercici5;

public class App {

	public static void main(String[] args) {
		
					
			Jugador jugador=Jugador.iniciar();
			
			Serializar.serializa(jugador);
			
			Serializar.deSerializa(jugador);
			
	     
	    System.out.println("Adios");
	    
	    			
	}

}
