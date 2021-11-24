package gestorAplicacion.utileria;
import java.util.*;
public class Pedido {
	//private Cliente cliente;
	//private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	//private Mesero mesero;
	private boolean estado;
	private float precio;
	private Caja caja;
	//Gets y sets
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	//Finalizacion sets y gets.
	public void borrarPedido() {
		estado = false;
		caja.agregarPedidos(this);
	}
	
}
