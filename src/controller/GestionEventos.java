package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import model.*;
import objects.Libro;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_rotar, actionListener_espejo, actionListener_panelLibro, actionListener_guardarLibro, actionListener_panelRecuLibro, actionListener_listarLibros, actionListener_recuperarLibro, actionListener_cambiarAnyo, actionListener_panelCambiarAno;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() throws IOException {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_compararContenido
				try {
					call_compararContenido();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al proceder a comparar los ficheros");
				}
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);
		view.getMntmCompararContenido().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				try {
					call_buscarPalabra();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					view.showError("Error al buscar la palabra");
				}
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		view.getMntmBuscarPalabra().addActionListener(actionListener_buscar);
		
		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				try {
					System.out.println("Llamo al metodo");
					call_Copiar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.print(e);
					view.showError("Error al intentar copiar");
				}
			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);
		view.getMntmCopiarArchivo().addActionListener(actionListener_copiar);
				
		actionListener_panelLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.mostrarSoloID(false);
				//Mostrar panel guardar libro
				if (view.getPanelCrearLibro().isVisible()) {
					view.visiblidadPanel(false);
					view.getMntmGuardarLibro().setText("Guardar libro");
				} else {
					view.visiblidadPanel(true);
					view.getMntmGuardarLibro().setText("Cancelar nuevo libro");
				}
			}
		};
		view.getMntmGuardarLibro().addActionListener(actionListener_panelLibro);
		
		actionListener_panelRecuLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.mostrarSoloID(true);
				//Mostrar panel guardar libro
				if (view.getPanelCrearLibro().isVisible()) {
					view.visiblidadPanel(false);
					view.getMntmRecuperarLibro().setText("Recuperar libro");
				} else {
					view.visiblidadPanel(true);
					view.getMntmRecuperarLibro().setText("Cancelar recuperación");
				}
			}
		};
		view.getMntmRecuperarLibro().addActionListener(actionListener_panelRecuLibro);

		//Panel cambiar año
		actionListener_panelCambiarAno = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.mostrarIDAno(true);
				//Mostrar panel guardar libro
				if (view.getPanelCrearLibro().isVisible()) {
					view.visiblidadPanel(false);
					view.getMntmCambiarAoLibro().setText("Cambiar año del libro");
				} else {
					view.visiblidadPanel(true);
					view.getMntmCambiarAoLibro().setText("Cancelar cambio de año");
				}
			}
		};
		view.getMntmCambiarAoLibro().addActionListener(actionListener_panelCambiarAno);

		actionListener_guardarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//Mostrar panel guardar libro
				System.out.println("Se procede a guardar datos del libro");
				
				try {
					call_GuardarLibro();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al intentar guardar el libro");
				}
			}
		};
		view.getBtnGuardar().addActionListener(actionListener_guardarLibro);
		
		actionListener_recuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//Mostrar panel guardar libro
				System.out.println("Se procede a recuperar un libro");
				
				try {
					call_recuperarLibro();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al intentar guardar el libro");
				}
			}
		};
		view.getBtnRecuperar().addActionListener(actionListener_recuperarLibro);
		
		actionListener_listarLibros = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//Mostrar panel guardar libro
				System.out.println("Se procede a listar el libro");
				
				try {
					call_listarLibro();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al intentar listar los libros");
				}
			}
		};
		view.getMntmListarLibros().addActionListener(actionListener_listarLibros);
		
		actionListener_cambiarAnyo = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//Mostrar panel guardar libro
				System.out.println("Se procede a cambiar el año del libro");
				
				try {
					call_cambiarAnyo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					view.showError("Error al intentar cambiar el año");
				}
			}
		};
		view.getBtnCambiarAno().addActionListener(actionListener_cambiarAnyo);
	}

	private int call_compararContenido() throws IOException {

		// TODO: Llamar a la funci�n compararContenido de GestionDatos
		Boolean coinciden = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());

		if (coinciden){
			view.setTextArea("Los archivos coinciden");
		} else {
			view.setTextArea("Los archivos son diferentes");
		}

		// TODO: Gestionar excepciones
		return 1;
	}

	private int call_buscarPalabra() throws IOException {

		// TODO: Llamar a la funci�n buscarPalabra de GestionDatos
		int linea = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
		
		//Numero de la palabra que imprime
		String posicion = "";
		if (view.getPrimera().isSelected()){
			posicion = "primera";
		} else {
			posicion = "última";
		}
		
		if (linea != -1){
			view.setTextArea("Se ha encontrado la " + posicion + " palabra " + view.getPalabra().getText() + " en la línea " + linea + " dentro del fichero " + view.getFichero1().getText());
		} else {
			view.setTextArea("No se ha encontrao la palabra " + view.getPalabra().getText() + " en el fichero " + view.getFichero1().getText());
		}
		
		return 1;
	}
	
	private int call_Copiar() throws IOException {
		
		//LLamar funcion copiar ficheros
		int status_copia = model.copiarFicehro(view.getFichero1().getText(), view.getFichero2().getText());
		
		if (status_copia != -1){
			view.setTextArea("Se ha copiado correctametnte con un peso de " + status_copia + " bytes");
		}
		return status_copia;
		
	}
	
	private int call_GuardarLibro() throws IOException {
		//Creamos objeto libro
		Libro lb = new Libro(view.getTxtID().getText(), view.getTxtTitulo().getText(), view.getTxtAutor().getText(), view.getTxtAno().getText(), view.getTxtEditor().getText(), view.getTxtPag().getText());
		
		//Enviamos objeto al controlador
		int estado = model.guardar_libro(lb);
		
		view.setTextArea("Generando libro...");
		view.addTextArea(limpiarln(30));
		view.addTextArea(lb.mostrarDatos());
		view.addTextArea(limpiarln(30));
		
		if (estado != 1) {
			//Se ha producido algun error
			switch (estado) {
			case -1:
				view.showError("Se ha producido un error desconocido");
				break;
			case -2:
				view.showError("Ya existe un libro con el mismo ID");
				break;
			}
		} else {
			view.addTextArea("El libro " + "LibroJava" + lb.getId() + ".lbj" + ", se ha creado correctamente");
		}
		
		return 1;
	}
	
	private int call_recuperarLibro() throws IOException {
		//Solicitamos el libro
		Libro bookRecup = model.recuperar_libro(view.getTxtID().getText());
		
		if (bookRecup != null) {
			//Se ha recibido correctamente
			view.setTextArea("Se ha recuperado el libro: ");
			view.addTextArea(limpiarln(30));
			view.addTextArea(bookRecup.mostrarDatos());
		} else {
			view.showError("Error: Comprueba que existe el libro y que no esta dañado");
		}
		return 1;
	}
	
	private int call_listarLibro() throws IOException {
		//Recibe ArrayList
		ArrayList <Libro> biblio = model.recuperar_todos();
		
		//Muestra datos
		if (biblio.size() != 0) {
			view.setTextArea("Se ha encontrado " + biblio.size() + " libros");
			for (int i=0; i<biblio.size(); i++) {
				view.addTextArea(limpiarln(30));
				view.addTextArea(biblio.get(i).mostrarDatos());
				view.addTextArea(limpiarln(30));
			}
		} else {
			view.showError("No se encuentran libros creados anteriormente, crea un nuevo libro");
		}
		return 1;
	}
	
	// #EJ1 Metodo Controlador del cambio de año del libro
	private int call_cambiarAnyo() throws IOException {
		//Preparamos textArea
		view.setTextArea("");
		
		//Recuperamos el libro
		Libro bookRecup = null;
		String antiguoAño = null;
		boolean recuperado = false;
		try {
			//Obten el libro del fichero
			bookRecup = model.recuperar_libro(view.getTxtID().getText());
			//Obten el año al que estaba anteriormente
			antiguoAño = bookRecup.getAnoPubli();
			//Establece la recuperacion como conseguida
			recuperado = true;
		} catch (Exception e) {
			//Si no se ha podido recuperar, marcalo como false y muestra el error
			view.showError("Error al intentar recuperar el libro con ID " + view.getTxtID().getText());
			recuperado = false;
		}
		
		//Si no se ha podido recuperar el libro, saltate esto ya que no sirve ¬¬
		if (recuperado) {
			//Comprobamos que el libro se ha recuperado
			if (bookRecup != null) {
				//Se ha recuperado el libro
				view.setTextArea("Libro recuperado...");
				view.addTextArea(limpiarln(30));
				view.addTextArea(bookRecup.mostrarDatos());
				view.addTextArea(limpiarln(30));
	
					//Procedemos a eliminar el anterior libro
					int estado = model.eliminarLibro(bookRecup);
					
					switch (estado) {
					case -3:
						view.showError("Error ya que no existe el libro");
						break;
					case -2:
						view.showError("Error al intentar eliminar el fichero anterior");
						break;
					}
					
			} else {
				view.showError("Se ha producido un error al intentar recuperar el libro con el ID: " + view.getTxtID().getText());
			}
			
			//Cambiamos al nuevo año
			bookRecup.setAnoPubli(view.getTxtAno().getText());
			
			//Procedemos a escribir nuevo libro
			int estado = model.guardar_libro(bookRecup);
			
			//Mostramos datos nuevo libro
			view.setTextArea("Cambiando año...");
			view.addTextArea(limpiarln(30));
			view.addTextArea(bookRecup.mostrarDatos());
			view.addTextArea(limpiarln(30));
			
			//Errores
			if (estado != 1) {
				//Se ha producido algun error
				switch (estado) {
				case -1:
					view.showError("Se ha producido un error desconocido");
					break;
				case -2:
					view.showError("Ya existe un libro con el mismo ID");
					break;
				}
			} else {
				view.addTextArea("Se ha cambiado el año " + antiguoAño + " al año " + bookRecup.getAnoPubli());
			}
		
		}
		
		return 1;
	}
	
	public String limpiarln(int cantidad) {
		String linea = "";
		
		for (int i=0; i<cantidad; i++) {
			linea += "-";
		}
		
		return linea;
	}
	
}
