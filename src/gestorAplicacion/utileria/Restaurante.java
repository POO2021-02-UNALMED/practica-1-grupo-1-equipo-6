//Clase restaurante, guarda informaci�n del restaurante, contiene informaci�n del mismo, importante en la funcionalidad del estado del restaurante.
//Autores: Michael Moreno Valoyes
package gestorAplicacion.utileria;
import java.util.ArrayList;
import gestorAplicacion.persona.*;
import java.io.Serializable;

//Clase Restarurante en la que se guarda informaci�n pertinente del restaurante
public class Restaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final static String LUGAR = "Carrera ni idea numero 69-69 al frente de no se";
	//Hora: Tarde y Noche
	private static String hora = "Tarde";
	private static ArrayList<Platillo> menu = new ArrayList<Platillo>();
	private static ArrayList<Mesa> mesasReservadas = new ArrayList<Mesa>();
	private static ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();
	private static String fecha = "17 de Diciembre";
	private static ArrayList<Mesero> meserosHorarioTarde = new ArrayList<Mesero>();
	private static ArrayList<Mesero> meserosHorarioNoche = new ArrayList<Mesero>();
	private static ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	//Metodos get y set para poder modificar los atributos necesarios
	
	
	
	public static ArrayList<Platillo> getMenu() {
		return Restaurante.menu;
	}

	public static ArrayList<Platillo> getPlatillos() {
		return platillos;
	}

	public static void setPlatillos(ArrayList<Platillo> platillos) {
		Restaurante.platillos = platillos;
	}

	public static ArrayList<Mesero> getMeserosHorarioTarde() {
		return meserosHorarioTarde;
	}

	public static void setMeserosHorarioTarde(ArrayList<Mesero> meserosHorarioTarde) {
		Restaurante.meserosHorarioTarde = meserosHorarioTarde;
	}

	public static ArrayList<Mesero> getMeserosHorarioNoche() {
		return meserosHorarioNoche;
	}

	public static void setMeserosHorarioNoche(ArrayList<Mesero> meserosHorarioNoche) {
		Restaurante.meserosHorarioNoche = meserosHorarioNoche;
	}

	public static void setMenu(ArrayList<Platillo> menu) {
		Restaurante.menu = menu;
	}
	
	public static ArrayList<Mesa> getMesasReservadas() {
		return Restaurante.mesasReservadas;
	}
	
	public static void setMesasReservadas(ArrayList<Mesa> mesasReservadas) {
		Restaurante.mesasReservadas = mesasReservadas;
	}
	
	public static ArrayList<Mesa> getMesasDisponibles() {
		return Restaurante.mesasDisponibles;
	}
	
	public static void setMesasDisponibles(ArrayList<Mesa> mesasDisponibles) {
		Restaurante.mesasDisponibles = mesasDisponibles;
	}

	public static String getHora() {
		return Restaurante.hora;
	}

	public static void setHora(String hora) {
		Restaurante.hora = hora;
	}

	public static String getLugar() {
		return Restaurante.LUGAR;
	}
	
	public static void setFecha(String fecha) {
		Restaurante.fecha = fecha;
	}
	
	public static String getFecha() {
		return Restaurante.fecha;
	}
	
	public void abrir() {
		//mostrar mensaje de bienvenida en la interfaz.
	}
	
	public void cerrar() {
		//mostrar mensaje de despedida y salir de la aplicacion.
	}
	
	//Estado del restaurante:
	public static String estadoRestaurante() {
		String mensajeClientes = "Los clientes actuales son: ";
		String mensajeMeseros = "Los meseros actuales son: ";
		String mensajeMesasDisponibles = "Las mesas disponibles son: ";
		String nombreCliente;
		for(int i = 0; i<Restaurante.mesasReservadas.size();i++) {
			nombreCliente = Restaurante.mesasReservadas.get(i).getCliente().getNombre();
			mensajeClientes = mensajeClientes + "\n" + nombreCliente;
			
		}
		if(Restaurante.hora == "Tarde") {
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