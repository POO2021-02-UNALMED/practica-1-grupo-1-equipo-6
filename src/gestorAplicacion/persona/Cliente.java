package gestorAplicacion.persona;
import java.util.*;
import gestorAplicacion.utileria.*;
public class Cliente extends Persona {
	private Mesa mesa;
	//Agregado Pedido de la persona;
	private Pedido pedido;
	private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	public Cliente(String nombre, String documento,Mesa mesa) {
		super(nombre,documento);
		this.mesa = mesa;
	}
	public void pedirOrden(ArrayList<Platillo> platillosPedir) {
		platillos.addAll(platillosPedir);
		
		
	}
	public void reservar(Mesa mesa) {
		if(mesa.isDisponibilidad() == true && Restaurante.getMesasDisponibles().contains(mesa)) {
			this.mesa = mesa;
			this.mesa.setCliente(this);
			Restaurante.getMesasDisponibles().remove(mesa);
			Restaurante.getMesasReservadas().add(mesa);
			mesa.setDisponibilidad(false);
		}
		else {
			//Decir que elija otra.
		}	
	}
	public int pagar() {
		int valorPagar = 0;
		for(int i = 0; i<platillos.size();i++) {
			valorPagar = valorPagar +platillos.get(i).getPrecio();
		}
		return valorPagar;
	}
	public String irse() {
		mesa.setDisponibilidad(true);
		Restaurante.getMesasReservadas().remove(mesa);
		Restaurante.getMesasDisponibles().add(mesa);
		this.mesa.setCliente(null);
		mesa = null;
		return "Muchas gracias por el servicio, hasta luego";
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
	
	public String entregarDatos() {
		return "Nombre: " + nombre + "\n" + 
				"Documento: " + documento + "\n"+
				"Mesa: " + mesa;
	}
	
	
	
}	
