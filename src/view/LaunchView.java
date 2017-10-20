package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window.Type;

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
	private JMenuItem mntmRotar, mntmEspejo;
	private JPanel panelCrearLibro;
	private JLabel lblIdentificador;
	private JTextField txtID;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JLabel lblAoPublicacin;
	private JTextField txtAno;
	private JLabel lblEditor;
	private JTextField txtEditor;
	private JLabel lblNmeroDePginas;
	private JTextField txtPag;
	private JPanel panelButtons;
	private JButton btnGuardar;
	private JMenu mnLibro;
	private JMenuItem mntmGuardarLibro;
	private JMenuItem mntmRecuperarLibro;
	private JButton btnRecuperar;
	private JMenuItem mntmListarLibros;
	
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
		
		setBounds(200,200,1150,350);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		primera = new JCheckBox("Primera aparición");
		panel.add(primera);

		textArea = new JTextArea(10, 80);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(50,50,50,50);
		panel.add(scroll);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel, BorderLayout.CENTER);		
        
        panelCrearLibro = new JPanel();
        panelCrearLibro.setVisible(false);
        getContentPane().add(panelCrearLibro, BorderLayout.SOUTH);
        
        lblIdentificador = new JLabel("ID");
        panelCrearLibro.add(lblIdentificador);
        
        txtID = new JTextField();
        panelCrearLibro.add(txtID);
        txtID.setColumns(10);
        
        lblTitulo = new JLabel("Titulo");
        panelCrearLibro.add(lblTitulo);
        
        txtTitulo = new JTextField();
        panelCrearLibro.add(txtTitulo);
        txtTitulo.setColumns(10);
        
        lblAutor = new JLabel("Autor");
        panelCrearLibro.add(lblAutor);
        
        txtAutor = new JTextField();
        panelCrearLibro.add(txtAutor);
        txtAutor.setColumns(10);
        
        lblAoPublicacin = new JLabel("Año");
        panelCrearLibro.add(lblAoPublicacin);
        
        txtAno = new JTextField();
        panelCrearLibro.add(txtAno);
        txtAno.setColumns(10);
        
        lblEditor = new JLabel("Editor");
        panelCrearLibro.add(lblEditor);
        
        txtEditor = new JTextField();
        panelCrearLibro.add(txtEditor);
        txtEditor.setColumns(10);
        
        lblNmeroDePginas = new JLabel("Pag");
        panelCrearLibro.add(lblNmeroDePginas);
        
        txtPag = new JTextField();
        panelCrearLibro.add(txtPag);
        txtPag.setColumns(10);
        
        btnGuardar = new JButton("Guardar");
        panelCrearLibro.add(btnGuardar);
        
        btnRecuperar = new JButton("Recuperar");
        panelCrearLibro.add(btnRecuperar);
        
        panelButtons = new JPanel();
        getContentPane().add(panelButtons, BorderLayout.NORTH);
        
        comparar = new JButton("Comparar");
        panelButtons.add(comparar);
        comparar.setPreferredSize(new Dimension(150, 26));
        buscar = new JButton("Buscar palabra");
        panelButtons.add(buscar);
        buscar.setPreferredSize(new Dimension(150, 26));
        copiar = new JButton("Copiar fichero");
        panelButtons.add(copiar);
        copiar.setPreferredSize(new Dimension(150, 26));
        
        label_f1 = new JLabel("Fichero 1:");
        panelButtons.add(label_f1);
        
		fichero1 = new JTextField("",10);
		panelButtons.add(fichero1);
		label_f2 = new JLabel("Fichero 2:");
		panelButtons.add(label_f2);
		fichero2 = new JTextField("",10);
		panelButtons.add(fichero2);
		label_pal = new JLabel("Palabra:");
		panelButtons.add(label_pal);
		palabra = new JTextField("",10);
		panelButtons.add(palabra);
        
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
	
	public JMenuItem getMntmListarLibros() {
		return mntmListarLibros;
	}

	public void setMntmListarLibros(JMenuItem mntmListarLibros) {
		this.mntmListarLibros = mntmListarLibros;
	}

	public JButton getBtnRecuperar() {
		return btnRecuperar;
	}

	public void setBtnRecuperar(JButton btnRecuperar) {
		this.btnRecuperar = btnRecuperar;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(JTextField txtAno) {
		this.txtAno = txtAno;
	}

	public JTextField getTxtEditor() {
		return txtEditor;
	}

	public void setTxtEditor(JTextField txtEditor) {
		this.txtEditor = txtEditor;
	}

	public JTextField getTxtPag() {
		return txtPag;
	}

	public void setTxtPag(JTextField txtPag) {
		this.txtPag = txtPag;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JPanel getPanelCrearLibro() {
		return panelCrearLibro;
	}

	public void setPanelCrearLibro(JPanel panelCrearLibro) {
		this.panelCrearLibro = panelCrearLibro;
	}
	
	public void visiblidadPanel (Boolean valor) {
		this.panelCrearLibro.setVisible(valor);
	}

	public JMenuItem getMntmGuardarLibro() {
		return mntmGuardarLibro;
	}

	public void setMntmGuardarLibro(JMenuItem mntmGuardarLibro) {
		this.mntmGuardarLibro = mntmGuardarLibro;
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
	
	public void addTextArea(String txt) {
		String antes = this.textArea.getText();
		this.textArea.setText(antes + "\n" + txt);
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
	
	public void mostrarSoloID(Boolean valor) {
		this.lblTitulo.setVisible(!valor);
		this.txtTitulo.setVisible(!valor);
		this.lblAutor.setVisible(!valor);
		this.txtAutor.setVisible(!valor);
		this.lblAoPublicacin.setVisible(!valor);
		this.txtAno.setVisible(!valor);
		this.lblEditor.setVisible(!valor);
		this.txtEditor.setVisible(!valor);
		this.lblNmeroDePginas.setVisible(!valor);
		this.txtPag.setVisible(!valor);
		this.btnGuardar.setVisible(!valor);
	}

	public JMenuItem getMntmRecuperarLibro() {
		return mntmRecuperarLibro;
	}

	public void setMntmRecuperarLibro(JMenuItem mntmRecuperarLibro) {
		this.mntmRecuperarLibro = mntmRecuperarLibro;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}


}