package model;

import java.io.*;

public class GestionDatos {
		
	public GestionDatos() {
		
	}

	//TODO: Implementa una funci�n para abrir ficheros
	public BufferedReader abrirFichero(String fichero) {
		try {
			FileReader fileR = new FileReader(fichero);
			BufferedReader fileBR = new BufferedReader(fileR);
			return fileBR;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al abrir el archivo " + fichero);
			return null;
		}
	}
	
	//TODO: Implementa una funci�n para cerrar ficheros
	public void cerrarFichero(BufferedReader fichero) {
		try {
			fichero.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha podido cerrar el fichero");
		}
	}
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException{
		//TODO: Implementa la funci�n
		BufferedReader archivo1 = abrirFichero(fichero1);
		BufferedReader archivo2 = abrirFichero(fichero2);
		
		String cadena1, cadena2;
		
		while ((cadena1 = archivo1.readLine()) != null && (cadena2 = archivo2.readLine()) != null){
			if (!cadena1.equals(cadena2)){
				cerrarFichero(archivo1);
				cerrarFichero(archivo2);
				return false;
			}
		}
		return true;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion){
		//TODO: Implementa la funci�n
		return 1;
	}	

}
