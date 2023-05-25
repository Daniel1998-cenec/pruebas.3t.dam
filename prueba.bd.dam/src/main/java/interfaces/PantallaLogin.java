package interfaces;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Button;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel extends PanelMadre {
	private JTextField textBienvenido;
	private JTextField textLogin;
	private JPasswordField passwordField;
	private Ventana ventana;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		setBackground(new Color(245, 245, 220));
		setForeground(new Color(216, 191, 216));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);

		JCheckBox CheckBox = new JCheckBox("Check");
		CheckBox.setBounds(325, 325, 82, 25);
		CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(CheckBox);

		textBienvenido = new JTextField();
		textBienvenido.setEnabled(false);
		textBienvenido.setBounds(196, 62, 197, 43);
		textBienvenido.setText("¡¡Bienvenido!!");
		textBienvenido.setForeground(Color.RED);
		textBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 30));

		textBienvenido.setColumns(10);
		add(textBienvenido);

		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario=textLogin.getText();
				String contraseña=new String(passwordField.getPassword());
				System.out.println(usuario+ " : "+contraseña);
				try {
					ventana.usuarioLogado=new Usuario(usuario, contraseña);
					JOptionPane.showMessageDialog(ventana,"Bienvenid@, "
							+ventana.usuarioLogado.getNick(), "Inicio de sesión exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarPantalla(PantallaListado.class);
				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(), "Login fallido",
					JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,"El cliente no existe","Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContraseñaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana,"La contraseña no es correcta", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		ButtonAceptar.setBounds(174, 320, 105, 31);
		ButtonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(ButtonAceptar);

		textLogin = new JTextField();
		textLogin.setBounds(311, 159, 141, 35);
		add(textLogin);
		textLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(311, 230, 141, 30);
		add(passwordField);

		JButton Registro = new JButton("Registro");
		Registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla(PantallaRegistro.class);
			}
		});
		Registro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Registro.setBounds(245, 389, 117, 51);
		add(Registro);
		
		JLabel BotonLogin = new JLabel("Email");
		BotonLogin.setBackground(new Color(255, 128, 128));
		BotonLogin.setForeground(Color.MAGENTA);
		BotonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonLogin.setBounds(50, 158, 182, 29);
		add(BotonLogin);
		
		JLabel BotonPass = new JLabel("Pass");
		BotonPass.setBackground(Color.PINK);
		BotonPass.setForeground(Color.MAGENTA);
		BotonPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BotonPass.setBounds(50, 229, 169, 25);
		add(BotonPass);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(90, 224, 747, 159);
		try {
			BufferedImage imagen=ImageIO.read(new File(".\\imagenes\\fotoclase.jpg"));
			Image enIcono=imagen.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
			labelImagen.setIcon(new ImageIcon(enIcono));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		add(labelImagen);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
