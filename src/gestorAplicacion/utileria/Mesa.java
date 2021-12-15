//Clase Mesa, importante en la funcionalidad de administrar y verificar el estado del restaurante.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;
import gestorAplicacion.persona.*;
import java.io.Serializable;

//Clase Mesa, desde est� se define y cambia el estado de disponibilidad de las mesas presentes en el restaurante.
public class Mesa implements Serializable{
	
	private static final long serialVersionUID = 7L;
	private boolean disponibilidad; //este atributo no solo es cambiado seg�n reserva sino tambi�n cuando un cliente que no ha reservado ocupa una mesa.
	private int numero;
	private int sillas;
	private Cliente cliente;
	
	//constructor que considera si la mesa fue reservada o no y la agrega a la lista correspondiente
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

	//meptodos get y set de los atributos
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}