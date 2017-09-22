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
	
	/*
	 * public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    	}
	 */
	
	public boolean compararContenido (String fichero1, String fichero2){
		//TODO: Implementa la funci�n
		
		return true;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion){
		//TODO: Implementa la funci�n
		return 1;
	}	

}
