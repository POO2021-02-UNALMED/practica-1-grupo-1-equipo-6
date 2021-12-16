// Clase Persona
// Autor: Jane G.
// Clase abstracta, padre de las clases de Mesero y Cliente, para implementar atributos compartidos en las clases hija

package gestorAplicacion.persona;
import java.io.Serializable;

//Clase abstracta Persona, padre de Mesero y Cliente
public abstract class Persona implements Serializable{
	
	private static final long serialVersionUID = 4L;
	protected String nombre;
	protected int documento;
	
	//Metodo para regresar atributos identificadores de un modo especifico
	public String entregarDatos() {
		return "Nombre: " + nombre + "\n" + 
				"Documento: " + documento;
	}
	
	//Constructor
	public Persona(String nombre, int documento) {
		this.nombre = nombre;
		this.documento = documento;
	}
	
	//Metodo abstracto para irse
	public abstract void irse(); 
	
	//Metodos get y set de Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Metodos get y set de Documento
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}

	
}
