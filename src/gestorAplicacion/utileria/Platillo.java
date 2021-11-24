//Clase platillo para tener información especifica de los platillos presentes en el menu y poder agregarlos a las ordenes,
//parte importante de la funcionalidad de facturación.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;

public class Platillo {
	
	private int tiempo; //Tiempo estimado que tarda el platillo en estar listo.
	private String nombre;
	private String tipo; //Especifica si el platillo es desayuno, almuerzo o cena
	private String restricciones = "?";
	private String ingredientes;
	private int precio;
	
	//métodos get y set de los atributos
	public int getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getRestricciones() {
		return restricciones;
	}
	
	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}
	
	public String getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
