//Clase Mesa
//Autores: Michael Moreno Valoyes
//importante en la funcionalidad de administrar y verificar el estado del restaurante.


package gestorAplicacion.utileria;
import gestorAplicacion.persona.*;
import java.io.Serializable;

//Clase Mesa, desde este se define y cambia el estado de disponibilidad de las mesas presentes en el restaurante.
public class Mesa implements Serializable{
	
	private static final long serialVersionUID = 7L;
	private boolean disponibilidad; //este atributo no solo es cambiado segun reserva sino tambien cuando un cliente que no ha reservado ocupa una mesa.
	private int numero; // Es un atributo identificador
	private int sillas;
	private Cliente cliente;
	
	//constructor
	//considera si la mesa fue reservada o no y la agrega a la lista correspondiente
	public Mesa(boolean disponibilidad, int numero, int sillas) {
		this.disponibilidad = disponibilidad;
		this.numero = numero;
		this.sillas = sillas;
		
		if(disponibilidad) {
			Restaurante.getMesasDisponibles().add(this);
		} else {
			Restaurante.getMesasReservadas().add(this);
		}
	}

	//Metodos get y set para el atributo disponibilidad
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	//Metodos get y set para el atributo numero (que tambien es un identificador)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//Metodos get y set para el atributo sillas
	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}
	
	//Metodos get y set para el atributo cliente
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}