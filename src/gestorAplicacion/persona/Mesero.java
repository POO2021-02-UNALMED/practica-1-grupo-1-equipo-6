package gestorAplicacion.persona;
import java.util.*;
import gestorAplicacion.utileria.*;

public class Mesero extends Persona {
	//Agregado Caja caja;
	private Caja caja;
	public static int numeroMeseros;
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public Mesero(String nombre, String documento) {
		super(nombre,documento);
		Mesero.numeroMeseros++;
	}
	//tomarOrden:
	public void tomarOrden(Cliente cliente) {
		clientes.add(cliente);
	}
	public void entregarOrden(Cliente cliente) {
		clientes.remove(cliente);
	}
	public void cobrar(Cliente cliente, Pedido pedido) {
		cliente.setPedido(pedido);
		caja.agregarPedidos(cliente.getPedido());
		
	}
	public String irse() {
		return "Ya he acabado mi servicio, ¿puedo retirarme?";
	}
	public String entregarDatos() {
		return "Nombre: " + nombre + "\n" + 
				"Documento: " + documento + "\n" +
				"Caja: " + caja;
	}
}
