package view;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton actividad1c;
	private JTextArea textArea;
	
	public LaunchView() {
		
		setBounds(200,200,800,450);
		setTitle("Proyecto Buffers");	
		JPanel panel = new JPanel();
		
		actividad1c = new JButton("Actividad 1c");		
		JButton actividad1d = new JButton("Actividad 1d");
		JButton actividad1e = new JButton("Actividad 1e");
		JButton actividad1f = new JButton("Actividad 1f");
		JButton actividad1g = new JButton("Actividad 1g");
		JButton actividad1h = new JButton("Actividad 1h");

		textArea = new JTextArea(25, 70);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);
		
		panel.add(actividad1c);
		panel.add(actividad1d);
		panel.add(actividad1e);
		panel.add(actividad1f);
		panel.add(actividad1g);
		panel.add(actividad1h);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}

	public JButton getActividad1c() {
		return actividad1c;
	}

	public void setActividad1c(JButton actividad1c) {
		this.actividad1c = actividad1c;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


}
