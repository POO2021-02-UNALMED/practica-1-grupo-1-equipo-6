package gestorAplicacion.persona;
import gestorAplicacion.utileria.*;

public class Mesero extends Persona {
	//Agregado Caja caja;
	public static int numeroMeseros;
	public Mesero(String nombre, int documento) {
		super(nombre,documento);
		Mesero.numeroMeseros++;
	}
	public void cobrar(Cliente cliente, Pedido pedido) 
	{
		cliente.setPedido(pedido);
		Caja.agregarPedidos(cliente.getPedido());
		
	}
	public void irse() 
	{
		
	}
}
