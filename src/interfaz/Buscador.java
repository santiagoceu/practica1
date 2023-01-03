package interfaz;

import dominio.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Busca a traves de todas las tags de los objetos del catalogo
 * Puede hacer busquedas de tipo AND introduciendo '&' al principio, que
 * asegura que los resultados de busqueda contenga todas las tags,
 * Busquedas tipo OR que devuelve resultados con al menos una de las tags,
 * y un operador NOT ! para usar en cualquier modo, en OR el orden importa,
 * pero en AND se asegura que no aparezcan todas las tags excepto las !not.
*/


public class Buscador extends Interfaz {
	
	private ArrayList<Articulo> catalogo;
	/**
	 * Constructor de Buscador
	 * @param c Catalogo
	 */
	public Buscador(Catalogo c) {
		this.catalogo = c.getLista();
	}
	/**
	 * El entorno de busqueda completo
	 * Toma control de la entrada de texto, no se aplican los comandos normales
	 * Permite buscar por tags
	 */
	public void start() {

		System.out.println("Bienvenido al entorno de busqueda. La busquda por defecto es un OR: \nEjemplo: > tag1 tag2 tag3 (Busca articulo que tenga al menos una)\nPuede ser AND indicando con & al comienzo\nEjemplo: > & tag1 tag2 tag3 (Busca articulo que tenga las tres.)\nAdemas, antes de cualquier tag puede colocar un signo de exclamacion para hacer NOT, y funciona ligeramente distinto en modo OR o AND.\nEjemplo: & tag1! !tag2 (Estrictamente sin tag1 y tag2.)\n\nPara salir, introduzca !!end.");
		String [] p;
		while (true) {

			p = leerPeticion().split(" ");
			LinkedHashSet<Articulo> output = new LinkedHashSet<Articulo>(); // LinkedHashSet no permite repeticiones, pero mantiene un orden para luego iterar
			
			// Busqueda AND
			
			if (p[0].equals("&")) { 
				
				ArrayList<String> t = new ArrayList<String>(Arrays.asList(p));
				t.remove(0); //quita el ampersand de delante

				ArrayList<Articulo> lista = catalogo;
				
				for (Articulo a : lista) { 
					boolean b=true;
					boolean d;
					for (String s : t) {
						boolean not=false; 	// Logica para el NOT
						if (s.charAt(0) == '!') {
							not = true;
							s = s.substring(1);
						}	
						d=not ? !a.getTags().contains(s) : a.getTags().contains(s);
						if (d==false) {
							b=false;
							break;
						}
					}
					if (b) output.add(a);

				}


			} else if (p[0].equals("!!end")) { // end
				System.out.println("Ha salido del entorno de busqueda");
				break;
			} else if (p[0].equals("")) continue;
			else { 
				// Busqueda OR
				ArrayList<Articulo> lista = catalogo;
				
				for (int i=0;i<p.length;i++) {
					//System.out.println("tags loop " + i);
					boolean not = p[i].charAt(0) == '!';
					if (not) {
						p[i] = p[i].substring(1);
					}
					//System.out.println("p[i]=" +  p[i]);
					//System.out.println("starts with ! " + not);
					for (Articulo a:lista) {
						//System.out.println("articulo loop, tag="+i);
						boolean contains = a.getTags().contains(p[i]);
						//System.out.println("tags a" + a.getTags()+ p[i]);
						//System.out.println("Contains: " + contains);
						if (not ? !contains : contains) {
							//System.out.println("if ejecutado");
							//lista.remove(a.getNombre());
							output.add(a);
						}
					}
				}
			}				

			String cadena="";
			for(Object a:output)
				cadena+=a+"\n";
			System.out.print(cadena);
		}
	}	
}
