package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

public class Articulo implements Serializable {
	private String nombre;						// nombre del articulo
	private BigDecimal precio;					// precio del articulo
	private ArrayList<String> tags;					// informacion adicional del articulo, usado para facilitar la busqueda
	public Articulo(String n, String p, String[] t) {		// Constructor de Articulo
		this.nombre = n;
		this.precio = new BigDecimal(p);
		this.tags = new ArrayList<String>(Arrays.asList(t));	// Se toma un String array al crearse, aportado por la interfaz.
	}

	public String getNombre() {					// get nombre de Articulo
		return this.nombre;
	}

	public void setNombre(String n) {				// Sobreescribir nombre de Articulo
		this.nombre = n;
	}

	public BigDecimal getPrecio() {					// get precio de Articulo en BigDecimal
		return this.precio;
	}

	public void setPrecio(String p) {				// set precio, recibe un string que se convierte a BigDecimal
		this.precio = new BigDecimal(p);
	}

	public ArrayList getTags() {					// Get tags del Articulo
		return this.tags;
	}

	public void setTags(String[] t) {				// Soobrescribe tags con nuevas tags.
		this.tags = new ArrayList<String>(Arrays.asList(t));
	}

	public boolean equals(Object o) { 				// Overwrite de funcion equals
									// para remover por nombre
		if(o == null) {
			return false;
		}
		else if (!o.getClass().equals(this.getClass())) {
			return false;
		}
		else {
			return ((Articulo) o).nombre.equals(this.nombre);
		}
	}
	public String toString(){					// usado para generar la tabla
		String t = "";
		for(String tag:this.tags) t+=tag + " "; 
		return String.format("%-10s | %-10.2f | %s",this.nombre,this.precio,t);
		// return "Articulo: " + this.nombre + " | Precio: " + this.precio + " | Tags: " + t;
	}
}
