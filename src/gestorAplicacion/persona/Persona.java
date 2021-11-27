package gestorAplicacion.persona;

public class Persona {
	protected String nombre;
	protected String documento;
	public String entregarDatos() {
		return "Nombre: " + nombre + "\n" + 
				"Documento: " + documento;
	}
	public Persona(String nombre, String documento) {
		this.nombre = nombre;
		this.documento = nombre;
	}
	public String irse() {
		return "Hasta luego.";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	
}
