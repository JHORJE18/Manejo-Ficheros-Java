package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton comparar,buscar,copiar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnImagen;
	private JMenuItem mntmCompararContenido, mntmBuscarPalabra, mntmCopiarArchivo;
	public JMenuItem getMntmGuardarLibro() {
		return mntmGuardarLibro;
	}

	public void setMntmGuardarLibro(JMenuItem mntmGuardarLibro) {
		this.mntmGuardarLibro = mntmGuardarLibro;
	}

	public JMenuItem getMntmRecuperarLibro() {
		return mntmRecuperarLibro;
	}

	public void setMntmRecuperarLibro(JMenuItem mntmRecuperarLibro) {
		this.mntmRecuperarLibro = mntmRecuperarLibro;
	}

	public JMenuItem getMntmListarLibros() {
		return mntmListarLibros;
	}

	public void setMntmListarLibros(JMenuItem mntmListarLibros) {
		this.mntmListarLibros = mntmListarLibros;
	}

	private JMenuItem mntmRotar, mntmEspejo;
	private JMenu mnLibro;
	private JMenuItem mntmGuardarLibro, mntmRecuperarLibro, mntmListarLibros;
	
	public JMenuItem getMntmCompararContenido() {
		return mntmCompararContenido;
	}

	public void setMntmCompararContenido(JMenuItem mntmCompararContenido) {
		this.mntmCompararContenido = mntmCompararContenido;
	}

	public JMenuItem getMntmBuscarPalabra() {
		return mntmBuscarPalabra;
	}

	public void setMntmBuscarPalabra(JMenuItem mntmBuscarPalabra) {
		this.mntmBuscarPalabra = mntmBuscarPalabra;
	}

	public JMenuItem getMntmCopiarArchivo() {
		return mntmCopiarArchivo;
	}

	public void setMntmCopiarArchivo(JMenuItem mntmCopiarArchivo) {
		this.mntmCopiarArchivo = mntmCopiarArchivo;
	}

	public JMenuItem getMntmRotar() {
		return mntmRotar;
	}

	public void setMntmRotar(JMenuItem mntmRotar) {
		this.mntmRotar = mntmRotar;
	}

	public JMenuItem getMntmEspejo() {
		return mntmEspejo;
	}

	public void setMntmEspejo(JMenuItem mntmEspejo) {
		this.mntmEspejo = mntmEspejo;
	}

	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		copiar = new JButton("Copiar fichero");
		copiar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(copiar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnArchivo = new JMenu("Archivo");
        menuBar.add(mnArchivo);
        
        mntmCompararContenido = new JMenuItem("Comparar contenido");
        mnArchivo.add(mntmCompararContenido);
        
        mntmBuscarPalabra = new JMenuItem("Buscar palabra");
        mnArchivo.add(mntmBuscarPalabra);
        
        mntmCopiarArchivo = new JMenuItem("Copiar archivo");
        mnArchivo.add(mntmCopiarArchivo);
        
        mnImagen = new JMenu("Imagen");
        menuBar.add(mnImagen);
        
        mntmRotar = new JMenuItem("Rotar 90º");
        mnImagen.add(mntmRotar);
        
        mntmEspejo = new JMenuItem("Espejo");
        mnImagen.add(mntmEspejo);
        
        mnLibro = new JMenu("Libro");
        menuBar.add(mnLibro);
        
        mntmGuardarLibro = new JMenuItem("Guardar libro");
        mnLibro.add(mntmGuardarLibro);
        
        mntmRecuperarLibro = new JMenuItem("Recuperar libro");
        mnLibro.add(mntmRecuperarLibro);
        
        mntmListarLibros = new JMenuItem("Listar libros");
        mnLibro.add(mntmListarLibros);
	}	
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}
	
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton comparar) {
		this.copiar = copiar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String txt) {
		this.textArea.setText(txt);
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JCheckBox getPrimera(){
		return primera;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}


}