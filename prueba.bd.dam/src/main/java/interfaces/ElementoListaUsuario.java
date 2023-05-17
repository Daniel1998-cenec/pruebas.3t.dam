package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;

public class ElementoListaUsuario extends JPanel{
	
	Ventana ventana;
	Usuario usuarioActual;
	
	public ElementoListaUsuario(Ventana v, Usuario u) {
		this.ventana=v;
		this.usuarioActual=u;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelEmail = new JLabel(usuarioActual.getEmail());
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 0;
		add(labelEmail, gbc_labelEmail);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel labelNick = new JLabel(usuarioActual.getNick());
		labelNick.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_labelNick = new GridBagConstraints();
		gbc_labelNick.insets = new Insets(0, 0, 0, 5);
		gbc_labelNick.gridx = 0;
		gbc_labelNick.gridy = 1;
		add(labelNick, gbc_labelNick);
		ventana=v;
		usuarioActual=u;
	}
	
}
