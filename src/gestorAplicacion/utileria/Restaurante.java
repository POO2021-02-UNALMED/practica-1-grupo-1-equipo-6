//Clase restaurante, guarda información del restaurante, contiene información del mismo, importante en la funcionalidad del estado del restaurante.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;
import java.util.ArrayList;

//Clase Restarurante en la que se guarda información pertinente del restaurante
public class Restaurante {
	
	private final static String LUGAR = "";
	private static String hora;
	private ArrayList<Platillo> menu = new ArrayList<Platillo>();
	private static ArrayList<Mesa> mesasReservadas = new ArrayList<Mesa>();
	private static ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();
	
	//Métodos get y set para poder modificar los atributos necesarios
	public ArrayList<Platillo> getMenu() {
		return menu;
	}
	
	public void setMenu(ArrayList<Platillo> menu) {
		this.menu = menu;
	}
	
	public static ArrayList<Mesa> getMesasReservadas() {
		return mesasReservadas;
	}
	
	public static void setMesasReservadas(ArrayList<Mesa> mesasReservadas) {
		Restaurante.mesasReservadas = mesasReservadas;
	}
	
	public static ArrayList<Mesa> getMesasDisponibles() {
		return mesasDisponibles;
	}
	
	public static void setMesasDisponibles(ArrayList<Mesa> mesasDisponibles) {
		Restaurante.mesasDisponibles = mesasDisponibles;
	}

	public static String getHora() {
		return hora;
	}

	public static void setHora(String hora) {
		Restaurante.hora = hora;
	}

	public static String getLugar() {
		return LUGAR;
	}
	
	public void abrir() {
		
	}
	
	public void cerrar() {
		
	}
}
