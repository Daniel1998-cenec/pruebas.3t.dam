package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class PantallaListado extends JPanel {

	private Ventana ventana;
	
	public PantallaListado(Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel claveBienvenido = new JLabel("Bienvenido@, "+ventana.usuarioLogado.getNick());
		claveBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		claveBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(claveBienvenido, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElemento = new JPanel();
		lista.setViewportView(contenedorElemento);
		contenedorElemento.setLayout(new BoxLayout(contenedorElemento, BoxLayout.Y_AXIS));
		
		for(byte i=0;i<100;i++) {
			contenedorElemento.add(new ElementoListaUsuario(ventana, ventana.usuarioLogado));
		}
	}
}
