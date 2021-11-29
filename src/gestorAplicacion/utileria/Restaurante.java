//Clase restaurante, guarda informaci�n del restaurante, contiene informaci�n del mismo, importante en la funcionalidad del estado del restaurante.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;
import java.util.ArrayList;

//Clase Restarurante en la que se guarda informaci�n pertinente del restaurante
public class Restaurante {
	
	private final static String LUGAR = "";
	private static String hora;
	private static ArrayList<Platillo> menu = new ArrayList<Platillo>();
	private static ArrayList<Mesa> mesasReservadas = new ArrayList<Mesa>();
	private static ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();
	
	//M�todos get y set para poder modificar los atributos necesarios
	
	public static ArrayList<Platillo> getMenu() {
		return Restaurante.menu;
	}
	
	public static void setMenu(ArrayList<Platillo> menu) {
		Restaurante.menu = menu;
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
		//mostrar mensaje de bienvenida en la interfaz.
	}
	
	public void cerrar() {
		//mostrar mensaje de despedida y salir de la aplicaci�n.
	}
}
