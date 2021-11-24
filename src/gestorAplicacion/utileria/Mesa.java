//Clase Mesa, importante en la funcionalidad de administrar y verificar el estado del restaurante.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;

//Clase Mesa, desde está se define y cambia el estado de disponibilidad de las mesas presentes en el restaurante.
public class Mesa {
	
	private boolean disponibilidad; //este atributo no solo es cambiado según reserva sino también cuando un cliente que no ha reservado ocupa una mesa.
	private int numero;
	private int sillas;
	
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
}