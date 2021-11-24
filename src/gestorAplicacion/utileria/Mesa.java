package gestorAplicacion.utileria;
public class Mesa {
	
	private boolean disponibilidad;
	private int numero;
	private int sillas;
	
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