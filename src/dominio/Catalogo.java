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
	 *Crea un catalogo con una lista vacia de articulos
	 */

	public Catalogo(){
		lista=new ArrayList<Articulo>();
	}
	/**
	 *Añade un articulo al catalogo
	 *@param a Articulo articulo a añadir
	 *@return la propia libreta para encadenar operaciones
	 */

	public Catalogo add(Articulo c){
		this.lista.add(c);
		return this;
	}
	/**
	 *Sreializa el catalogo a una cadena de caracteres
	 */

	public void remove(String n) {
		this.lista.remove(new Articulo(n,"0",new String [1]));
	}
	/**
	 * Elimina del catalogo el nombre de los articulos anteriores
	 */

	public void remove(int n) {
		this.lista.remove(n);
	}
	/**
	 * Elimina del catalogo el precio de los articulos anteriores
	 */

	public int size() {
		return lista.size();
	}
	/**
	 * Indica cuantos articulos hay en el catalogo
	 */

	public ArrayList<Articulo> getLista() {
		return this.lista;
	}
	/**
	 * Devuelve el catalogo
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
	
	public String toString(){
		String cadena="";
		for(Articulo c:lista)
			cadena+=c+"\n";
		return cadena;
	}
}
