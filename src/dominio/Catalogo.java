package dominio;
import java.util.ArrayList;
import java.io.Serializable;
/**
 * Clase Catalogo
 * Coleccion de articulos
 *
 * @author Santiago Vidal/Maria Sanchez
 * @version 1.0
 */
public class Catalogo implements Serializable{
	private ArrayList<Articulo> lista;
	/**
	 * Constructor de Catalogo
	 * Crea un catalogo con una lista vacia de articulos
	 */

	public Catalogo(){
		lista=new ArrayList<Articulo>();
	}
	/**
	 * Añade un articulo al catalogo
	 * @param c Articulo a añadir
	 * @return this
	 */

	public Catalogo add(Articulo c){
		this.lista.add(c);
		return this;
	}
	/**
	 * Remueve de la lista un articulo por su nombre
	 * @param n String nombre a remover
	 */

	public void remove(String n) {
		this.lista.remove(new Articulo(n,"0",new String [1]));
	}
	/**
	 * Remueve del catalogo a partir de su indice en el ArrayList.
	 * @param n int, indice
	 */

	public void remove(int n) {
		this.lista.remove(n);
	}
	/**
	 * Por conveniencia, devuelve el numero de elementos de la lista
	 * @return int, size
	 */

	public int size() {
		return lista.size();
	}
	/**
	 * Devuelve el mismo catalogo en ArrayList
	 * @return ArrayList, la lista.
	 */

	public ArrayList<Articulo> getLista() {
		return this.lista;
	}
	/**
	 * Genera una representacion visual del catalogo que incluye
	 * el indice de cada articulo, que le annade al
	 * return del toString de Articulo.
	 * @return String
	 */

	public String listaId() {
		String cadena="";
		int i = 0;
		for(Articulo a:lista) {
			cadena+=String.format("%-2d | %s%n",i,a);
			i++;
		}
		return cadena;
	}
	/**
	 * Simplemente enlaza todos los pedazos de tabla obtenidos
	 * del toString de cada Articulo.
	 */
	public String toString(){
		String cadena="";
		for(Articulo c:lista)
			cadena+=c+"\n";
		return cadena;
	}
}
