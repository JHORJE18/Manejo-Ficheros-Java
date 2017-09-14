package model;

import java.io.FileReader;
import java.io.IOException;

public class GestionDatos {
	
	private String FICHERO_ENTRADA="entrada.txt";
	private FileReader fr=null;
	
	public GestionDatos() {	
		
	}
	
	public void openFile() throws IOException {	
		
		System.out.println("Entro en open");
		fr = new FileReader(FICHERO_ENTRADA);
	
	}
	
	public void closeFile() throws IOException {
		
		fr.close();
		
	}
	
	public String prueba_funcion() {

		System.out.println("entramos en prueba");
		
		try {
			openFile();
		} catch (IOException e) {
			System.err.println("Sale un error al abrir");
			//e.printStackTrace();
			return "ERROR";
		}

		String ret="";
		int c;
		System.out.print("He leído ");
		try {
			while ((c = fr.read()) != -1) {
				ret=ret+(char) c;
				//System.out.print((char) c);
			}
		} catch (IOException e) {
			System.err.println("Sale un error al leer");
			//e.printStackTrace();
		}
		
		try {
			closeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
				
		return ret;		

	}

}
