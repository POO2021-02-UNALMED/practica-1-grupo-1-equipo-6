package gestorAplicacion.persona;

public abstract class Persona {
	protected String nombre;
	protected int documento;
	public String entregarDatos() {
		return "Nombre: " + nombre + "\n" + 
				"Documento: " + documento;
	}
	public Persona(String nombre, int documento) {
		this.nombre = nombre;
		this.documento = documento;
	}
	public abstract void irse(); 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}

	
}
