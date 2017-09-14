package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class GestionEventos {
	
	private GestionDatos model;
    private LaunchView view;
    private ActionListener actionListener;
    
    public GestionEventos(GestionDatos model, LaunchView view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void contol(){  
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {       
            	  call_actividad1();
              }
        };                
        view.getActividad1c().addActionListener(actionListener);   
    }
    
    private void call_actividad1() {
        String resultat=model.prueba_funcion();
        if(resultat.compareTo("ERROR")!=0) {
        	System.out.println("después, ret vale "+resultat);
        	view.getTextArea().append(resultat);
        }
        else {
        	System.err.println("Se ha producido un error");
        }
    }  

}
