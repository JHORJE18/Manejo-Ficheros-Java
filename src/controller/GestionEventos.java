package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

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

}
