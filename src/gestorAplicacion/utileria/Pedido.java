package gestorAplicacion.utileria;
import java.util.*;
import gestorAplicacion.persona.*;
public class Pedido {
	private Cliente cliente;
	private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	private Mesero mesero;
	private boolean estado;
	private float precio;
	private Caja caja;
	
	public Pedido(Cliente cliente,Mesero mesero, boolean estado, float precio, Caja caja) {
		this.cliente = cliente;
		this.mesero = mesero;
		this.estado = estado;
		this.precio = precio;
		this.caja = caja;
	}
	
	
	
	//Gets y sets
	public ArrayList<Platillo> getPlatillos(){
		return platillos;
	}
	public void setPlatillos() {
		platillos = cliente.getPlatillos();
	}
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
	
	
	public Mesero getMesero() {
		return mesero;
	}
	
}
