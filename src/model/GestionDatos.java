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
	
	//Abrir ficheros binarios
	public void abrirFicheroBin (String fichero){
		
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
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la funci�n
		
		BufferedReader archivo1 = abrirFichero(fichero1);
		String cadena1;
		
		if (primera_aparicion){
			//Primera aparicion
			int i=0;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					cerrarFichero(archivo1);
					return i;
				}
			}
		} else {
			//Ultima palabra encontrada
			int i=0, line = -1;
			while ((cadena1 = archivo1.readLine()) != null){
				i++;
				if (cadena1.equals(palabra)){
					line = i;
				}
			}
			
			//Devuelve ultima line encontrada o ninguna
			return line;
		}
		
		return -1;
	}	

	
	//Funcion copiar ficheros
	public int copiarFicehro(String fichero1, String fichero2) throws IOException{
		
		if (fichero2 == "") {
			System.out.println("Esta vacio");
			throw new IOException("El destino esta vacio");
		} else {
			System.out.println("Copiar a " + fichero2);
		}
		
        File origen = new File(fichero1);
        File destino = new File(fichero2);
        
        if (destino.exists()){
        		//TODO: Error no puedo crear
        		throw new IOException("El archivo destino ya existe");
        }
        destino.createNewFile();
        
        DataInputStream din = new DataInputStream(new FileInputStream(origen));
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(destino));

        int c = -1; 
        int bites = 0;
        while((c =  din.read()) !=-1)
        {
        	bites++;
        	dout.write((byte)c);
        }
        
		return bites;
	}
}
