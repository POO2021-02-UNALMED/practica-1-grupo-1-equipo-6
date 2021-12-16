//Clase restaurante
//Autores: Michael Moreno Valoyes
//Guarda informacion del restaurante, contiene informaciï¿½n del mismo, importante en la funcionalidad del estado del restaurante.

package gestorAplicacion.utileria;
import java.util.ArrayList;
import gestorAplicacion.persona.*;
import java.io.Serializable;

//Clase Restarurante en la que se guarda informacion pertinente del restaurante
public class Restaurante implements Serializable{
	
	//Jornada es un atributo del tipo enumerado
	public enum Jornada 
	{
		TARDE, NOCHE
	}
	private static final long serialVersionUID = 1L;
	private final static String LUGAR = "Carrera 39 numero 56-22";
	//Hora: Tarde y Noche
	private static Jornada hora = Jornada.TARDE;
	//El atrubuto menu tiene los platillos disponibles en el dia
	private static ArrayList<Platillo> menu = new ArrayList<Platillo>(); 
	private static ArrayList<Mesa> mesasReservadas = new ArrayList<Mesa>();
	private static ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();
	private static String fecha = "17 de Diciembre";
	// Los meseros de los horarios tarde y noche se guardan en su correspondiente lista
	private static ArrayList<Mesero> meserosHorarioTarde = new ArrayList<Mesero>();
	private static ArrayList<Mesero> meserosHorarioNoche = new ArrayList<Mesero>();
	//
	private static ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	
	
	//Metodos get y set para poder modificar los atributos necesarios
	
	//Metodos get y set para el atributo menu
	public static ArrayList<Platillo> getMenu() {
		return Restaurante.menu;
	}
	
	public static void setMenu(ArrayList<Platillo> menu) {
		Restaurante.menu = menu;
	}

	//Metodos get y set para el atributo platillos
	public static ArrayList<Platillo> getPlatillos() {
		return platillos;
	}

	public static void setPlatillos(ArrayList<Platillo> platillos) {
		Restaurante.platillos = platillos;
	}

	//Metodos get y set para el atributo meserosHorarioTarde
	public static ArrayList<Mesero> getMeserosHorarioTarde() {
		return meserosHorarioTarde;
	}

	public static void setMeserosHorarioTarde(ArrayList<Mesero> meserosHorarioTarde) {
		Restaurante.meserosHorarioTarde = meserosHorarioTarde;
	}

	//Metodos get y set para el atributo meserosHorarioNoche
	public static ArrayList<Mesero> getMeserosHorarioNoche() {
		return meserosHorarioNoche;
	}

	public static void setMeserosHorarioNoche(ArrayList<Mesero> meserosHorarioNoche) {
		Restaurante.meserosHorarioNoche = meserosHorarioNoche;
	}
	
	//Metodos get y set para el atributo de las mesas reservadas
	public static ArrayList<Mesa> getMesasReservadas() {
		return Restaurante.mesasReservadas;
	}
	
	public static void setMesasReservadas(ArrayList<Mesa> mesasReservadas) {
		Restaurante.mesasReservadas = mesasReservadas;
	}
	
	//Metodos get y set para el atributo de las mesas disponibles
	public static ArrayList<Mesa> getMesasDisponibles() {
		return Restaurante.mesasDisponibles;
	}
	
	public static void setMesasDisponibles(ArrayList<Mesa> mesasDisponibles) {
		Restaurante.mesasDisponibles = mesasDisponibles;
	}

	//Metodos get y set para el atributo hora
	public static Jornada getHora() {
		return Restaurante.hora;
	}

	public static void setHora(Jornada hora) {
		Restaurante.hora = hora;
	}

	//Metodos get para el atributo del lugar
	public static String getLugar() {
		return Restaurante.LUGAR;
	}
	
	//Metodos get y set para el atributo fecha
	public static void setFecha(String fecha) {
		Restaurante.fecha = fecha;
	}
	
	public static String getFecha() {
		return Restaurante.fecha;
	}
	
	//Estado del restaurante:
	// un string que contiene el estado del restaurante, los clientes actuales, meseros, y mesas disponibles, recorriendo cada uno y añadiendolos al string
	public static String estadoRestaurante() {
		String mensajeClientes = "Los clientes actuales son: ";
		String mensajeMeseros = "Los meseros actuales son: ";
		String mensajeMesasDisponibles = "Las mesas disponibles son: ";
		String nombreCliente;
		for(int i = 0; i<Restaurante.mesasReservadas.size();i++) {
			nombreCliente = Restaurante.mesasReservadas.get(i).getCliente().getNombre();
			mensajeClientes = mensajeClientes + "\n" + nombreCliente;
			
		}
		if(Restaurante.hora == Jornada.TARDE) {
			for(int i = 0; i<Restaurante.meserosHorarioTarde.size();i++) {
				mensajeMeseros = mensajeMeseros + "\n" + Restaurante.meserosHorarioTarde.get(i).getNombre();
			}
		}
		else {
				for(int i = 0; i< Restaurante.meserosHorarioNoche.size();i++) {
					mensajeMeseros = mensajeMeseros + "\n" + Restaurante.meserosHorarioNoche.get(i).getNombre();
				}
			}
		for(int i = 0; i<Restaurante.mesasDisponibles.size();i++) {
			mensajeMesasDisponibles = mensajeMesasDisponibles + "\n" + Restaurante.mesasDisponibles.get(i).getNumero();
		}
		return mensajeClientes + "\n" + mensajeMeseros + "\n" + mensajeMesasDisponibles;
	}
}