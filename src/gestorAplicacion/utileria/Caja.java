package gestorAplicacion.utileria;
import java.util.*;
public class Caja {
	private static  float ingresos;
	private static  float gastos;
	private static  ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static String crearEstadisticas() {
		String mensaje = "Las estadísticas de nuestro restaurante son:";
		int posicion = 0;
		Hashtable <Integer,String> menuOrdenado = new Hashtable<Integer,String>();
		ArrayList<Integer> cantidadPlatillosMenu = new ArrayList<Integer>();
		for(int i = 0; i<Restaurante.getMenu().size();i++) {
			cantidadPlatillosMenu.add(0);
		}
		
		for(int i = 0;i< pedidos.size();i++) {
			for(int j = 0;j < pedidos.get(i).getPlatillos().size();j++) {
				posicion = Restaurante.getMenu().indexOf(pedidos.get(i).getPlatillos().get(j));
				cantidadPlatillosMenu.set(posicion, cantidadPlatillosMenu.get(posicion) + 1);
				
			}
		}
		for(int i = 0; i<Restaurante.getMenu().size();i++) {
			menuOrdenado.put(cantidadPlatillosMenu.get(i),Restaurante.getMenu().get(i).getNombre());
		}
		
		Enumeration<Integer> e = menuOrdenado.keys();
		while(e.hasMoreElements()) {
			int key = e.nextElement();
			mensaje = mensaje + "\n" + "Cantidad: " + key + "\t Platillo: " + menuOrdenado.get(key);
		}
		//Versión desordenada
		/*
		for(int i = 0; i<Restaurante.getMenu().size();i++) {
			mensaje = mensaje + "\n" + Restaurante.getMenu().get(i).getNombre() + ": " + cantidadPlatillosMenu.get(i);
		}
		*/
		
		return mensaje;
	}
	
	public static  void agregarPedidos(Pedido pedidox) {
		Caja.pedidos.add(pedidox);
	}
	//Agregamos una función que coja todos los precios del pedido, 
	//para poder obtener los ingresos.
	public static void retornarPrecioPedidos() {
		float suma = 0;
		for(int i = 0;i<Caja.pedidos.size();i++) {
			suma = suma + Caja.pedidos.get(i).getPrecio();
		}
		Caja.ingresos = suma;
	}
	public static float cuadrarCaja(){
		return Caja.ingresos;
	}
	//Get y sets:
	public static float getIngresos() {
		return Caja.ingresos;
	}
	public static void setIngresos(float ingresos) {
		Caja.ingresos = ingresos;
	}
	public static float getGastos() {
		return Caja.gastos;
	}
	public static void setGastos(float gastos) {
		Caja.gastos = gastos;
	}
	public static ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	public static void setPedidos(ArrayList<Pedido> pedidos) {
		Caja.pedidos = pedidos;
	}
	//Finalizacion set y get
}
