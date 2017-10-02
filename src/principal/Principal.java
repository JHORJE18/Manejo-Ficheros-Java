package principal;

import java.io.IOException;

import javax.swing.JFrame;

import model.*;
import view.*;
import controller.*;

public class Principal {
	
	static String v = "1.C";

	public static void main(String[] args) throws IOException {		
	
		GestionDatos model = new GestionDatos();
		
		LaunchView view = new LaunchView();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
		
		System.out.println("Versión actual: " + v);
		
		GestionEventos controller = new GestionEventos(model,view);
		controller.contol();
		
	}

}
