package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import model.*;
import objects.Libro;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_rotar, actionListener_espejo, actionListener_panelLibro, actionListener_guardarLibro;

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
		
		actionListener_rotar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				try {
					System.out.println("Llamo al metodo");
					call_Rotar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.print(e);
					view.showError("Error al intentar rotar");
				}
			}
		};
		view.getMntmRotar().addActionListener(actionListener_rotar);
		
		actionListener_espejo = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				try {
					System.out.println("Llamo al metodo");
					call_Espejo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.print(e);
					view.showError("Error al intentar aplicar el modo Espejo");
				}
			}
		};
		view.getMntmEspejo().addActionListener(actionListener_espejo);
		
		actionListener_panelLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//Mostrar panel guardar libro
				if (view.getPanelCrearLibro().isVisible()) {
					view.visiblidadPanel(false);
					view.getMntmGuardarLibro().setText("Guardar libro");
				} else {
					view.visiblidadPanel(true);
					view.getMntmGuardarLibro().setText("Cancelar");
				}
			}
		};
		view.getMntmGuardarLibro().addActionListener(actionListener_panelLibro);
		
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
	
	private int call_Rotar() throws IOException {
		view.showError("La función de rotar imagen, aún no esta desarrollada");
		
		return 1;		
	}
	
	private int call_Espejo() throws IOException{
		view.showError("La función de aplicar modo espejo a la imagen, aún no esta desarrollada");

		return 1;
	}
	
	private int call_GuardarLibro() throws IOException {
		//Creamos objeto libro
		Libro lb = new Libro(view.getTxtID().getText(), view.getTxtTitulo().getText(), view.getTxtAutor().getText(), view.getTxtAno().getText(), view.getTxtEditor().getText(), view.getTxtPag().getText());
		view.setTextArea("Generando libro... \n" + lb.mostrarDatos());
		
		//Enviamos objeto al controlador
		int estado = 1;
		
		return 1;
	}

}
