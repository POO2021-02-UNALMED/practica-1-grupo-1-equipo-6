//Clase platillo para tener informaciï¿½n especifica de los platillos presentes en el menu y poder agregarlos a las ordenes,
//parte importante de la funcionalidad de facturaciï¿½n.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;

public class Platillo {
	
	private int tiempo; //Tiempo estimado que tarda el platillo en estar listo.
	private String nombre;
	private String tipo; //Especifica si el platillo es desayuno, almuerzo o cena
	private String ingredientes;
	private int precio;
	private String identificador; //id númerico de 3 cifras
	private int frecuencia; //cantidad de veces que el platillo fue pedido
	
	
	
	public Platillo(int tiempo, String nombre, String tipo, String ingredientes, int precio, String identificador) {
		this.tiempo = tiempo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ingredientes = ingredientes;
		this.precio = precio;
		this.setIdentificador(identificador);
	}

	//mï¿½todos get y set de los atributos
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
}
