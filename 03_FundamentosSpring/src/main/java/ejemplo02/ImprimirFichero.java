package ejemplo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ImprimirFichero implements Imprimible{

	public void imprimir(String cadena) {
		File file = new File("fichero.txt");
		try(PrintWriter pw = new PrintWriter(file)){
			pw.print(cadena);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//PrintWriter pw = new PrintWriter(out)
	}
}
