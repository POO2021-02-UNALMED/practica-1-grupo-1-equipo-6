// Clase Mesero
// Autor: Jane G.
// Esta clase se utiliza a la hora de hacer un pedido y es quien cobra al cliente

package gestorAplicacion.persona;
import gestorAplicacion.utileria.*;


// La clase Mesero hereda de persona y es utilizada para cobrar y como parametro para pedir pedidos
public class Mesero extends Persona {
	
	private static final long serialVersionUID = 6L;
	//Agregado Caja caja;
	public static int numeroMeseros;
	
	//Constructor 
	//Pide nombre y documento
	public Mesero(String nombre, int documento) {
		super(nombre,documento);
		Mesero.numeroMeseros++;
	}
	
	//Metodo cobrar
	//El metodo cobrar es usado para agregar a la caja el pedido para poder utilizarlo en los metodos de caja
	//los parametros de entrada son cliente y pedido
	//Le asigna al cliente el pedido y el pedido a la caja
	public void cobrar(Cliente cliente, Pedido pedido) 
	{
		cliente.setPedido(pedido);
		Caja.agregarPedidos(cliente.getPedido());
		
	}
	
	//El metodo irse esta vacio
	public void irse() 
	{
		
	}
}
