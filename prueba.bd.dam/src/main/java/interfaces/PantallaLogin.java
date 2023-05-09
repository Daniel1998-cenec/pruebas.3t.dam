package interfaces;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Button;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;

public class PantallaLogin extends JPanel {
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

		JButton BotonPass = new JButton("Contraseña");
		BotonPass.setBackground(new Color(0, 128, 128));
		BotonPass.setBounds(50, 230, 169, 35);
		BotonPass.setForeground(Color.MAGENTA);
		BotonPass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(BotonPass);

		JButton BotonLogin = new JButton("Iniciar sesion");
		BotonLogin.setBounds(50, 151, 169, 43);
		BotonLogin.setHorizontalAlignment(SwingConstants.LEADING);
		BotonLogin.setForeground(Color.MAGENTA);
		BotonLogin.setFont(new Font("Sitka Text", Font.ITALIC, 20));
		BotonLogin.setBackground(new Color(102, 0, 102));
		add(BotonLogin);

		textBienvenido = new JTextField();
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
