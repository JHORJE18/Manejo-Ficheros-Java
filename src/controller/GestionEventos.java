package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		return 1;
	}

	private int call_buscarPalabra() {

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		return 1;
	}

}
