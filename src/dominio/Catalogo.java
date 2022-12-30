package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Catalogo implements Serializable{
	private ArrayList<Articulo> lista;
	public Catalogo(){
		lista=new ArrayList<Articulo>();
	}
	public Catalogo add(Articulo c){
		this.lista.add(c);
		return this;
	}
	
	public void remove(String n) {
		this.lista.remove(new Articulo(n,"0",new String [1]));
	}
	public void remove(int n) {
		this.lista.remove(n);
	}

	public int size() {
		return lista.size();
	}
	
	public ArrayList<Articulo> getLista() {
		return this.lista;
	}

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
