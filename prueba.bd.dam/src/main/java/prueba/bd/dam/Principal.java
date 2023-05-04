package prueba.bd.dam;

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

import utils.DAO;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		// Pon en el menu una opcion 5 - borrar mascota, y usa la funcion dlete de DAO
		// que ya tenemos hecha para, pidiendo por teclado el nombre de la mascota
		// y el email del dueño, te borre a la mascota de la tabla pets.
		// Probadlo de forma que logreis dspues borrar a pueba@prueba.es
		byte opcion = 0;
		do {
			System.out.println("¿Qué quieres hacer en la bd?\n\t0- Salir" + "\n\t1- Insertar usuario"
					+ "\n\t2- Borrar usuario" + "\n\t3- Modificar usuario" + "\n\t4- Consultar usuarios");
			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			case 1:
				try {
					System.out.println("Dime email");
					String email = sc.nextLine();
					System.out.println("Dime contraseña");
					String pass = sc.nextLine();
					System.out.println("Dime nick");
					String nick = sc.nextLine();

					HashMap<String, String> columnas = new HashMap<String, String>();
					columnas.put("email", email);
					columnas.put("pass", pass);
					columnas.put("nick", nick);
					DAO.insert("user ", columnas);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Dime el email del usuario que quieres borrar");
					String email = sc.nextLine();

					HashMap<String, String> campos = new HashMap<String, String>();
					campos.put("email", email);
					int filasBorradas = DAO.delete("user", campos);

					System.out.println("Se han borrado " + filasBorradas + " filas.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:

				break;
			case 4:
				LinkedHashSet columnasSacar=new LinkedHashSet<String>();
				columnasSacar.add("email");
				columnasSacar.add("pass");
				columnasSacar.add("nick");
				HashMap<String,String> restricciones= new HashMap<String,String>();
				ArrayList<Object> cliente=
						DAO.consultar("user", columnasSacar, restricciones);
				for(byte i=0;i<cliente.size();i++) {
					System.out.println(cliente.get(i)+" : ");
				}
				System.out.println();
				break;

			case 5:
				try {
					System.out.println("Dime el nombre de la mascota que quieres borrar");
					String nMascota = sc.nextLine();
					System.out.println("Dime el email del dueño de la mascota que quieres borrar");
					String email = sc.nextLine();
					HashMap<String, String> campos = new HashMap<String, String>();
					campos.put("name", nMascota);
					campos.put("ownerEmail", email);
					int filasBorradas = DAO.delete("pet", campos);

					System.out.println("Se han borrado " + filasBorradas + " filas.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		} while (opcion != 0);

	}

}
