package interfaz;
import dominio.*;
import java.util.Scanner;
import java.util.Arrays;

public class Interfaz {
	public boolean procesarPeticion (String peticion, Catalogo l){
		String [] p=peticion.split(" ");
		if (p[0].equals("add") && (p.length>2)) {
			try {
				l.add(new Articulo(p[1],p[2],Arrays.copyOfRange(p,3,p.length)));
			} catch (NumberFormatException e) {
				System.out.println("Precio no es valido.");
			}
		}	
		else if (p[0].equals("list"))
			System.out.print(l);
		else if (p[0].equals("help"))
			System.out.print("Introduzca una de las siguientes peticiones: \n add <nombre> <precio> [tags]\nlist \nexit");
		else if (p[0].equals("remove") && (p.length>1))
			l.remove(p[1]);
		else if (p[0].equals("exit"))
			return false;
		return true;
	}
	public String leerPeticion(){
		Scanner sc =  new Scanner(System.in);
		System.out.print("> ");
		String cadena = sc.nextLine();
		return cadena;
	}
}
