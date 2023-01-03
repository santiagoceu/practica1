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
	 */
	public boolean procesarPeticion (String peticion, Catalogo l){
		String [] p=peticion.split(" ");
		if (p[0].equals("add") && (p.length>2)) {
			try {
				l.add(new Articulo(p[1],p[2],Arrays.copyOfRange(p,3,p.length)));
			} catch (NumberFormatException e) {
				System.out.println("Precio no es valido.");
			}
		}	
		else if (p[0].equals("list")) {
			System.out.printf("%-10s | %-10s | %s%n","Articulo","Precio","Tags");
			System.out.print(l);
		}
		else if (p[0].equals("help"))
			System.out.print("Introduzca una de las siguientes peticiones: \n add <nombre> <precio> [tags]\nlist \nexit\nidlist \nidremove");
		else if (p[0].equals("remove") && (p.length>1))
			l.remove(p[1]);
		else if (p[0].equals("exit"))
			return false;
		else if (p[0].equals("idlist")) {

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
		else if (p[0].equals("search")) {
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
		Scanner sc =  new Scanner(System.in);
		System.out.print("> ");
		String cadena = sc.nextLine();
		return cadena;
	}
}
