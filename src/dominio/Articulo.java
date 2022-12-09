package dominio

import java.util.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

public class Articulo implements Serializable {
	private String nombre;
	private BigDecimal precio;
	private ArrayList<String> tags;
	public Articulo(String n, String p, String[] t) {
		this.nombre = n;
		this.precio = new BigDecimal(p);
		this.tags = new ArrayList<String>(Arrays.asList(t));
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(String p) {
		this.precio = new BigDecimal(p);
	}

	public ArrayList getTags() {
		return this.tags();
	}

	public void setTags(String[] t) {
		this.tags = new ArrayList<String>(Arrays.asList(t));
	}
}
