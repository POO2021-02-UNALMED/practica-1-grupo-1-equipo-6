package gestorAplicacion.utileria;
import java.util.*;
public class Pedido {
	//private Cliente cliente;
	//private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	//private Mesero mesero;
	private boolean estado;
	private float precio;
	private Caja caja;
	public float getPrecio() {
		return precio;
	}
	public void borrarPedido() {
		estado = false;
		caja.agregarPedidos(this);
	}
	
}
