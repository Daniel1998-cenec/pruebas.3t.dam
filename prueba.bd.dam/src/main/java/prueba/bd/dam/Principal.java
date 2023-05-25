package prueba.bd.dam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import javax.imageio.ImageIO;

import interfaces.Ventana;
import utils.DAO;

public class Principal {

	public static void main(String[] args) throws SQLException {
		/*
		 * Scanner sc = new Scanner(System.in); // Pon en el menu una opcion 5 - borrar
		 * mascota, y usa la funcion dlete de DAO // que ya tenemos hecha para, pidiendo
		 * por teclado el nombre de la mascota // y el email del dueño, te borre a la
		 * mascota de la tabla pets. // Probadlo de forma que logreis dspues borrar a
		 * pueba@prueba.es´
		 * 
		 * byte opcion = 0; do {
		 * System.out.println("¿Qué quieres hacer en la bd?\n\t0- Salir" +
		 * "\n\t1- Insertar usuario" + "\n\t2- Borrar usuario" +
		 * "\n\t3- Modificar usuario" + "\n\t4- Consultar usuarios"); opcion =
		 * Byte.parseByte(sc.nextLine()); switch (opcion) { case 1: try {
		 * System.out.println("Dime email"); String email = sc.nextLine();
		 * System.out.println("Dime contraseña"); String pass = sc.nextLine();
		 * System.out.println("Dime nick"); String nick = sc.nextLine();
		 * 
		 * HashMap<String, Object> columnas = new HashMap<String, Object>();
		 * columnas.put("email", email); columnas.put("pass", pass);
		 * columnas.put("nick", nick); DAO.insert("user ", columnas);
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } break; case 2: try {
		 * System.out.println("Dime el email del usuario que quieres borrar"); String
		 * email = sc.nextLine();
		 * 
		 * HashMap<String, Object> campos = new HashMap<String, Object>();
		 * campos.put("email", email); int filasBorradas = DAO.delete("user", campos);
		 * 
		 * System.out.println("Se han borrado " + filasBorradas + " filas."); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * break; case 3: System.out.println("dime el email del cliente modificar");
		 * String emailMod=sc.nextLine(); HashMap<String,Object>valoresNuevos=new
		 * HashMap<String,Object>(); System.out.println("¿Que quieres cambiar?" +
		 * "\n\t1-email" + "\n\t2-pass" + "\n\t3-nick");
		 * switch(Byte.parseByte(sc.nextLine())) { case 1:
		 * System.out.println("Dime el nuevo email"); valoresNuevos.put("email",
		 * sc.nextLine()); break; case 2: System.out.println("Dime el nuevo pass");
		 * valoresNuevos.put("pass", sc.nextLine()); break; case 3:
		 * System.out.println("Dime el nuevo nick"); valoresNuevos.put("nick",
		 * sc.nextLine()); break; } HashMap<String,Object> restriccionesMod=new
		 * HashMap<String,Object>(); restriccionesMod.put("email", emailMod);
		 * DAO.actualizar("user", valoresNuevos, restriccionesMod); break; case 4:
		 * LinkedHashSet columnasSacar=new LinkedHashSet<String>();
		 * columnasSacar.add("email"); columnasSacar.add("pass");
		 * columnasSacar.add("nick"); HashMap<String,Object> restricciones= new
		 * HashMap<String,Object>(); ArrayList<Object> cliente= DAO.consultar("user",
		 * columnasSacar, restricciones); for(byte i=0;i<cliente.size();i++) {
		 * System.out.println(cliente.get(i)+" : "); } System.out.println(); break;
		 * 
		 * case 5: try {
		 * System.out.println("Dime el nombre de la mascota que quieres borrar"); String
		 * nMascota = sc.nextLine();
		 * System.out.println("Dime el email del dueño de la mascota que quieres borrar"
		 * ); String email = sc.nextLine(); HashMap<String, Object> campos = new
		 * HashMap<String, Object>(); campos.put("name", nMascota);
		 * campos.put("ownerEmail", email); int filasBorradas = DAO.delete("pet",
		 * campos);
		 * 
		 * System.out.println("Se han borrado " + filasBorradas + " filas."); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * break; } } while (opcion != 0);
		 */

		

		// 23/05/2023

		/*
		 * BufferedImage imagen=new BufferedImage (800,600, BufferedImage.TYPE_INT_RGB);
		 * //int contadorColor=0; float contadorRojo=0; float contadorVerde=0; float
		 * contadorAzul=0; try { for(short i=0;i<imagen.getWidth();i++) { for (short
		 * j=0;j<imagen.getHeight();j++) { String colorEscogido=String.format("%02X",
		 * (int) contadorRojo); colorEscogido+=String.format("%02X", (int)
		 * contadorVerde); colorEscogido+=String.format("%02X", (int) contadorAzul);
		 * imagen.setRGB(i, j, Integer.parseInt(colorEscogido,16)); //contadorColor++;
		 * //contadorColor=contadorColor%16777215;
		 * contadorRojo=(contadorRojo+(255f/imagen.getHeight()))%255; }
		 * contadorVerde=(contadorVerde+(255f/imagen.getHeight()))%255; }
		 * ImageIO.write(imagen, "JPG", new File("./imagene.jpg")); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*try {
			BufferedImage imagen = ImageIO.read(new File("./fotoclase.jpg"));
			for (short i = 0; i < imagen.getWidth(); i++) {
				for (short j = 0; j < imagen.getHeight(); j++) {
					if(i<imagen.getWidth()/2) {
						imagen.setRGB(i, j, imagen.getRGB(i, j)&Integer.parseInt("FFFF00",16));
					}
					imagen.setRGB(i,j, ~imagen.getRGB(i, j)&Integer.parseInt("FFFF00",16));
				}
			}
			ImageIO.write(imagen, "jpg", new File("./imagene.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Ventana v=new Ventana();
		
		
	}

}
