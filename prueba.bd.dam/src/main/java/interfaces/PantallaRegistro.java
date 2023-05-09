package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaRegistro extends JPanel {
	
	private Ventana ventana;
	
	private JTextField textInicio;
	public PantallaRegistro(Ventana v) {
		setBackground(new Color(147, 112, 219));
		this.ventana=v;
		setLayout(null);
		
		JButton NombreRegistro = new JButton("Nombre");
		NombreRegistro.setBackground(new Color(255, 215, 0));
		NombreRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NombreRegistro.setBounds(154, 130, 114, 30);
		add(NombreRegistro);
		
		textInicio = new JTextField();
		textInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textInicio.setBackground(Color.PINK);
		textInicio.setText("Bienvenido, a la pagina de registro, por favor, introduce los datos obligatoriamente.");
		textInicio.setBounds(91, 33, 517, 46);
		add(textInicio);
		textInicio.setColumns(10);
		
		JTextPane nombreRegistroText = new JTextPane();
		nombreRegistroText.setBackground(Color.LIGHT_GRAY);
		nombreRegistroText.setBounds(335, 130, 164, 30);
		add(nombreRegistroText);
		
		JTextPane numeroRegistroText = new JTextPane();
		numeroRegistroText.setBackground(Color.LIGHT_GRAY);
		numeroRegistroText.setBounds(335, 280, 164, 30);
		add(numeroRegistroText);
		
		JTextPane registroApellidoText = new JTextPane();
		registroApellidoText.setBackground(Color.LIGHT_GRAY);
		registroApellidoText.setBounds(335, 206, 164, 30);
		add(registroApellidoText);
		
		JButton apellidoRegistro = new JButton("Apellido");
		apellidoRegistro.setBackground(new Color(255, 215, 0));
		apellidoRegistro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		apellidoRegistro.setBounds(154, 206, 114, 29);
		add(apellidoRegistro);
		
		JButton botonNumeroRegistro = new JButton("Numero");
		botonNumeroRegistro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonNumeroRegistro.setBackground(new Color(255, 215, 0));
		botonNumeroRegistro.setBounds(154, 280, 114, 30);
		add(botonNumeroRegistro);
		
		JComboBox comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Malaga", "Granada", "Sevilla", "Huelva", "Cadiz", "Almeria", "Jaen", "Cordoba"}));
		comboBoxProvincia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxProvincia.setBackground(new Color(255, 215, 0));
		comboBoxProvincia.setBounds(335, 348, 164, 35);
		add(comboBoxProvincia);
		
		JButton Provincia = new JButton("Provincia");
		Provincia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Provincia.setBackground(new Color(255, 215, 0));
		Provincia.setBounds(154, 352, 114, 35);
		add(Provincia);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla(PantallaLogin.class);
			}
		});
		botonRegistro.setBackground(new Color(255, 215, 0));
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		botonRegistro.setBounds(260, 428, 138, 40);
		add(botonRegistro);
	}
}
