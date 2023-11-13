package n2Exercici1;

public class App {

	public static void main(String[] args) {
		
		// configuramos propiedades archivo config
		Propiedades p= new Propiedades();
		p.escribirPropiedades();
		
		listarDirectoriosFicheros.escribirRecorridoTxtAtoZ(listarDirectoriosFicheros.fileListRecorridoAtoZ());
		//  "C:\\Users\\luiss\\eclipse-workspace\\TestGit4\\src"
		//  /Users/luiss/eclipse-workspace/TestGit4/src
		// /Users/Public/Downloads/recorridoDirFilesAtoZ.txt
	}

}
