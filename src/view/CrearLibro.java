package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class CrearLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtAño;
	private JTextField txtEditor;
	private JTextField txtNumPag;


	/**
	 * Create the frame.
	 */
	public CrearLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblGuardarLibro = new JLabel("Guardar libro");
		lblGuardarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarLibro.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		contentPane.add(lblGuardarLibro, BorderLayout.NORTH);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.X_AXIS));
		
		JPanel panelIzquierdo = new JPanel();
		panelCentral.add(panelIzquierdo);
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		
		JLabel lblIdentificador = new JLabel("Identificador");
		panelIzquierdo.add(lblIdentificador);
		
		txtID = new JTextField();
		lblIdentificador.setLabelFor(txtID);
		panelIzquierdo.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		panelIzquierdo.add(lblAutor);
		
		txtAutor = new JTextField();
		lblAutor.setLabelFor(txtAutor);
		panelIzquierdo.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lbEditor = new JLabel("Editor");
		panelIzquierdo.add(lbEditor);
		
		txtEditor = new JTextField();
		panelIzquierdo.add(txtEditor);
		txtEditor.setColumns(10);
		
		JPanel panelDerecho = new JPanel();
		panelCentral.add(panelDerecho);
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		
		JLabel lblTitulo = new JLabel("Titulo");
		panelDerecho.add(lblTitulo);
		
		txtTitulo = new JTextField();
		lblTitulo.setLabelFor(txtTitulo);
		panelDerecho.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAñoPubli = new JLabel("Año publicación");
		panelDerecho.add(lblAñoPubli);
		
		txtAño = new JTextField();
		panelDerecho.add(txtAño);
		txtAño.setColumns(10);
		
		JLabel lblNmeroDePginas = new JLabel("Número de páginas");
		panelDerecho.add(lblNmeroDePginas);
		
		txtNumPag = new JTextField();
		panelDerecho.add(txtNumPag);
		txtNumPag.setColumns(10);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		panelInferior.add(btnGuardar);
	}

}
