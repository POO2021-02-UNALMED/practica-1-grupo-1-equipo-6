//Clase platillo 
//Autores: Michael Moreno Valoyes
//para tener informacion especifica de los platillos presentes en el menu y poder agregarlos a las ordenes,
//parte importante de la funcionalidad de facturacion.

package gestorAplicacion.utileria;
import java.io.Serializable;

// La clase Platillo contiene los datos del platillo como el tiempo de preparación, su nombre, tipo, ingredientes, precio, identificador, frecuencia que es la cantidad de veces que se ha pedido
public class Platillo implements Serializable{
	
	private static final long serialVersionUID = 9L;
	private int tiempo; //Tiempo estimado que tarda el platillo en estar listo.
	private String nombre;
	private String tipo; //Especifica si el platillo es desayuno, almuerzo o cena
	private String ingredientes;
	private int precio;
	private String identificador; //id númerico de 3 cifras
	private int frecuencia; //cantidad de veces que el platillo fue pedido
	
	
	//Constructor
	public Platillo(int tiempo, String nombre, String tipo, String ingredientes, int precio, String identificador) {
		this.tiempo = tiempo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ingredientes = ingredientes;
		this.precio = precio;
		this.setIdentificador(identificador);
	}

	//metodos get y set del atributo tiempo
	public int getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	//metodos get y set del atributo nombre
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//metodos get y set del atributo tipo
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//metodos get y set del atributo ingredientes
	public String getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	//metodos get y set del atributo precio
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	//metodos get y set del atributo identificador
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	//metodos get y set del atributo frecuencia
	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
}
