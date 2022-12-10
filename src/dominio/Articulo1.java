package dominio;
import java.io.Serializable;
public class Articulo implements Serializable {
        private String nombre;
        private long precio;
        int id;
        public Articulo(String n, long p, int i) {
                this.nombre = n;
                this.precio = p;
                this.id = i;
        }

        public String getNombre() {
                return this.nombre;
        }

        public void setNombre(String n) {
                this.nombre = n;
        }

        public long getPrecio() {
                return this.precio;
	}

	public void setPrecio(long p){
		this.precio = p;
        }

        public int getId() {
                return this.id;
        }

        public void setId (int i) {
                this.id = i;
        }

        public String displayPrecio() {

                return this.precio/100 + "," + this.precio%100<10 ? "0" : "" + this.precio%100;
        }

        public String toString() {
                return "ID: " + this.id + " | Nombre: " + this.nombre + " | Precio: "+ this.precio;
        }
}
