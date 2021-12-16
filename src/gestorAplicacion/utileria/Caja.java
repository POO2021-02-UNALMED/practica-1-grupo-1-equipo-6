// Clase Caja
// Autor: Santiago 
// La clase caja es util a la hora de cuadrar caja, generar estadisticas de cierto dia, y eliminar los datos de un dia para iniciar al siguiente en 0

package gestorAplicacion.utileria;
import java.util.*;
import java.io.Serializable;


// Clase Caja
// Guarda ingresos, gastos, y los pedidos para la creación de estadistica
public class Caja implements Serializable{
	
	private static final long serialVersionUID = 2L;
	private static  float ingresos;
	private static  float gastos;
	private static  ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	//Metodo reiniciarCaja
	//Al final del dia despues de cuadrar la caja, todos los valores se regresan a 0, se vacia la lista de pedidos y las frecuencias de los platillos se regresan a 0
	public static void reiniciarCaja() {
		Caja.ingresos = 0;
		Caja.gastos = 0;
		pedidos = new ArrayList<Pedido>();
		for(int i = 0;i<Restaurante.getPlatillos().size();i++)
		{
			Restaurante.getPlatillos().get(i).setFrecuencia(0);
		}
	}
	
	//Metodo crearEstadisticas
	//Crea las estadisticas de la caja del restaurante, retornando un mensaje con las cantidad de cada platillo pedido
	public static String crearEstadisticas() {
		String mensaje = "Las estadisticas de nuestro restaurante son: \n";
		for(int i = 0; i<Restaurante.getMenu().size(); i++)
		{
			mensaje += "Cantidad: " + Restaurante.getMenu().get(i).getFrecuencia()+" Platillo: " + Restaurante.getMenu().get(i).getNombre() + "\n";
		}
		return mensaje;
	}
	
	//Metodo agregarPedidos 
	//recibe un pedido y los recibe a la lista de pedidos de la caja
	public static  void agregarPedidos(Pedido pedidox) {
		Caja.pedidos.add(pedidox);
	}
	
	//Metodo cuadrarCaja
	//Agregamos una funcion que coja todos los precios del pedido, 
	//para poder obtener los ingresos.
	public static float cuadrarCaja(){
		float suma = 0;
		for(int i = 0;i<Caja.pedidos.size();i++) {
			suma = suma + Caja.pedidos.get(i).getPrecio();
		}
		Caja.ingresos = suma;
		return Caja.ingresos;
	}
	
	//Get y sets para el atributo ingresos:
	public static float getIngresos() {
		return Caja.ingresos;
	}
	public static void setIngresos(float ingresos) {
		Caja.ingresos = ingresos;
	}
	
	//Get y sets para el atributo gastos:
	public static float getGastos() {
		return Caja.gastos;
	}
	public static void setGastos(float gastos) {
		Caja.gastos = gastos;
	}
	
	//Get y sets para el atributo pedidos:
	public static ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	public static void setPedidos(ArrayList<Pedido> pedidos) {
		Caja.pedidos = pedidos;
	}
}