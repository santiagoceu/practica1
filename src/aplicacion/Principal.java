package aplicacion;
import java.io.*;
import dominio.*;
import interfaz.*;
/**
 * Aplicacion de manejo del catalogo
 *
 * @author Santiago Vidal/Maria Sanchez
 * @version 1.0
 */


/**
 * La clase Principal del programa.\
 * Se encarga de instanciar las clases, pero ademas de cargar y guardar el catalogo.
 */

public class Principal{
	public static void main(String [] args) {
		ObjectInputStream fi; // Fichero para leer
		ObjectOutputStream fo; // Fichero para escribir
		Catalogo l;
		try {
			fi = new ObjectInputStream(new FileInputStream("catalogo.txt"));
			l = (Catalogo) fi.readObject();
			fi.close();
		} catch (Exception e) {
			l=new Catalogo ();
		} 
		
		Interfaz IU=new Interfaz();
		String peticion;
		do {
			peticion=IU.leerPeticion();
		} while (IU.procesarPeticion(peticion,l));
		try {
			fo=new ObjectOutputStream(new FileOutputStream("catalogo.txt"));
			fo.writeObject(l);
			fo.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.print("Error al crear el fichero");
		}
	}
}
