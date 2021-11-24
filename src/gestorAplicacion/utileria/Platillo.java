package gestorAplicacion.utileria;

public class Platillo {
	
	private int tiempo;
	private String nombre;
	//private String imagen = "PlaceHolder";
	private String tipo;
	private String restricciones = "?";
	private String ingredientes;
	
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
}
