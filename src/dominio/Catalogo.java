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
	
	public int size() {
		return lista.size();
	}
	
	public String toString(){
		String cadena="";
		for(Articulo c:lista)
			cadena+=c+"\n";
		return cadena;
	}
}
