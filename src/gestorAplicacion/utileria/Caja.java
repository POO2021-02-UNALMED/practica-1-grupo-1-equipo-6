package gestorAplicacion.utileria;
import java.util.*;
public class Caja {
	private static  float ingresos;
	private static  float gastos;
	private static  ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public static void reiniciarCaja() {
		Caja.ingresos = 0;
		Caja.gastos = 0;
		pedidos = new ArrayList<Pedido>();
		for(int i = 0;i<Restaurante.getPlatillos().size();i++)
		{
			Restaurante.getPlatillos().get(i).setFrecuencia(0);
		}
	}
	public static String crearEstadisticas() {
		String mensaje = "Las estadisticas de nuestro restaurante son: \n";
		for(int i = 0; i<Restaurante.getMenu().size(); i++)
		{
			mensaje += "Cantidad: " + Restaurante.getMenu().get(i).getFrecuencia()+" Platillo: " + Restaurante.getMenu().get(i).getNombre() + "\n";
		}
		return mensaje;
	}
	
	public static  void agregarPedidos(Pedido pedidox) {
		Caja.pedidos.add(pedidox);
	}
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