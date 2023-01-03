package interfaz;
import dominio.*;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Clase Interfaz
 * Responsable de leer y procesar las solicitudes de usuario
 *
 * @author Santiago Vidal/Maria Sanchez
 * @version 1.0
 */
public class Interfaz {
	/**
	 * Procesa una peticion
	 * @param peticion String con la peticion a ejecutar
	 * @param l Catalogo sobre la que se realiza la peiticion
	 * @return true: se esperan mas peticiones, false: terminar
	 * Maneja todas las entradas por pantalla
 	 * Contiene todos los comandos
	 */
public class Interfaz {
	/**
	 * Metodo que devuelve un boolean, mantiene el while en Principal ciclando.\
	 *
	 * @param peticion que recibe de leerPeticion()
	 * @param l Catalogo que recibe en Principal
	 * @return false si el comando es exit, true de otra manera.
	 */

	public boolean procesarPeticion (String peticion, Catalogo l){
		String [] p=peticion.split(" "); 	// transforma peticion en un String array para manejo
		if (p[0].equals("add") && (p.length>2)) { // comando add, annade Articulo al Catalogo
			try {
				l.add(new Articulo(p[1],p[2],Arrays.copyOfRange(p,3,p.length))); // tags son annadidas al final
			} catch (NumberFormatException e) {
				System.out.println("Precio no es valido."); // Asegura que el precio sea convertible a BigDecimal
			}
		}	
		else if (p[0].equals("list")) { // invoca al toString de Catalogo
			System.out.printf("%-10s | %-10s | %s%n","Articulo","Precio","Tags");
			System.out.print(l);
		}
		else if (p[0].equals("help")) // Comando help con comandos y sus parametros
			System.out.print("Introduzca una de las siguientes peticiones: \n add <nombre> <precio> [tags]\nlist \nexit\nidlist \nidremove <id>\nsearch");
		else if (p[0].equals("remove") && (p.length>1)) //remueve por nombre
			l.remove(p[1]);
		else if (p[0].equals("exit")) // sale del programa
			return false;
		else if (p[0].equals("idlist")) { // lista con ids de Catalogo, aunque los ids no son constantes.

			System.out.printf("%-1s | %-10s | %-10s | %s%n","ID","Articulo","Precio","Tags");
			System.out.print(l.listaId()); // Lista con ids para editar o remover por id.
		}
		else if (p[0].equals("idremove") && p.length>1) { //remover por indice del array
			try {
				int b = Integer.parseInt(p[1]);
				l.remove(b);
			} catch (Exception e) {
				System.out.println("Id invalido.");
			}
		}
		else if (p[0].equals("search")) { // Abre el entorno de busqueda, Buscador.
			Buscador a = new Buscador(l);
			a.start();
		}
		return true;
	}
	/**
	 * Lee una peticion de usuario
	 * @return un String con la peticion leida
	 */
	public String leerPeticion(){
	 /** 
	 * Se encarga de leer por teclado
	 * @return String con la lectura por teclado
	 */
	public String leerPeticion(){ // leer peticion
		Scanner sc =  new Scanner(System.in);
		System.out.print("> ");
		String cadena = sc.nextLine();
		return cadena;
	}
}
