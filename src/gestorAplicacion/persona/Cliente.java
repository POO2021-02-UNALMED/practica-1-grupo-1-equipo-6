package gestorAplicacion.persona;
import java.util.*;
import gestorAplicacion.utileria.*;
public class Cliente extends Persona {
	private Mesa mesa;
	//Agregado Pedido de la persona;
	private Pedido pedido;
	private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	public Cliente(String nombre, int documento) {
		super(nombre,documento);
	}
	public void pedirOrden(ArrayList<Platillo> platillosPedir) {
		platillos.addAll(platillosPedir);
		
		
	}
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

	public int pagar() {
		int valorPagar = 0;
		for(int i = 0; i<platillos.size();i++) {
			valorPagar = valorPagar +platillos.get(i).getPrecio();
		}
		return valorPagar;
	}
	public void irse() {
		mesa.setDisponibilidad(true);
		Restaurante.getMesasReservadas().remove(mesa);
		Restaurante.getMesasDisponibles().add(mesa);
		this.mesa.setCliente(null);
		mesa = null;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public ArrayList<Platillo> getPlatillos() {
		return platillos;
	}
	public void setPlatillos(ArrayList<Platillo> platillos) {
		this.platillos = platillos;
	}
	//De Pedido:
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}	
