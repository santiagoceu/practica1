package dominio

import java.util.BigDecimal;
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
		return this.tags();
	}

	public void setTags(String[] t) {				// Soobrescribe tags con nuevas tags.
		this.tags = new ArrayList<String>(Arrays.asList(t));
	}
}
