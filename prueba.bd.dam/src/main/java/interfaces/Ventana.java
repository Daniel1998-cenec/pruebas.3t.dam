package interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Usuario;

public class Ventana extends JFrame {

	protected Usuario usuarioLogado;
	
	public Ventana() {
		this.setSize(600,500);
		this.setTitle("Programa de prueba de clase");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
		this.setIconImage(new ImageIcon("./fotoclase.jpg").getImage());
	}
	
	public void cambiarPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if(clase.equals(PantallaListado.class)) {
			this.setContentPane(new PantallaListado(this));
		}
		this.getContentPane().setVisible(true);
	}
	
}
