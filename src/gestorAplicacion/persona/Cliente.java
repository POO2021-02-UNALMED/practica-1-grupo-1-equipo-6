// Clase Cliente
// Autor: Jane G.
// Los objetos de esta clase son los clientes del restaurante, ellos son quienes reservan, hacen pedidos, y pagan

package gestorAplicacion.persona;
import java.util.*;
import gestorAplicacion.utileria.*;

// Los clientes reservan y ocupan mesas, en las que hacen pedidos y despues pagan
// Cada cliente tiene una mesa, hace un pedido que contiene platillos
public class Cliente extends Persona {
	
	private static final long serialVersionUID = 5L;
	private Mesa mesa;
	//Agregado Pedido de la persona;
	private Pedido pedido;
	private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	
	//Construcctor
	public Cliente(String nombre, int documento) {
		super(nombre,documento);
	}
	
	//Metodo para pedir orden, agregamos los platillos al cliente, pueden pedir más platillos más tarde
	//Se ingresa un ArrayList de los objetos de clase Platillo que ordena el cliente, puede pedir multiples veces
	public void pedirOrden(ArrayList<Platillo> platillosPedir) {
		platillos.addAll(platillosPedir);
		
	}
	
	//El metodo reservar recive el identificador (int) de la mesa a reservar
	//luego verifica las mesas del restaurante y le asigna la mesa al cliente correspondiente
	public void reservar(int Mesa) {
		for(int i = 0; i< Restaurante.getMesasDisponibles().size();i++) {
			if(Restaurante.getMesasDisponibles().get(i).getNumero() == Mesa) {
				mesa = Restaurante.getMesasDisponibles().get(i);
				mesa.setCliente(this);
				Restaurante.getMesasDisponibles().remove(mesa);
				Restaurante.getMesasReservadas().add(mesa);
				mesa.setDisponibilidad(false);
			}
		}
	}

	//El metodo pagar regresa el valor a pagar, sumando el precio de la lista de platillos del cliente
	public int pagar() {
		int valorPagar = 0;
		for(int i = 0; i<platillos.size();i++) {
			valorPagar = valorPagar +platillos.get(i).getPrecio();
		}
		return valorPagar;
	}
	
	//El metodo irse regresa a la mesa a ser disponible, actualiza el numero de mesas reservadas y disponibles
	// y en el objeto mesa elimina el cliente y quita la mesa del cliente
	public void irse() {
		mesa.setDisponibilidad(true);
		Restaurante.getMesasReservadas().remove(mesa);
		Restaurante.getMesasDisponibles().add(mesa);
		this.mesa.setCliente(null);
		mesa = null;
	}
	
	//metodos get y set del atributo mesa
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	//metodos get y set del atributo platillos
	public ArrayList<Platillo> getPlatillos() {
		return platillos;
	}
	public void setPlatillos(ArrayList<Platillo> platillos) {
		this.platillos = platillos;
	}
	
	//metodos get y set del atributo pedido
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}	
