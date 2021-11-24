package gestorAplicacion.utileria;
import java.util.*;
public class Caja {
	private float ingresos;
	private float gastos;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void agregarPedidos(Pedido pedidox) {
		pedidos.add(pedidox);
	}
	//Agregamos una función que coja todos los precios del pedido, 
	//para poder obtener los ingresos.
	public void retornarPrecioPedidos() {
		float suma = 0;
		for(int i = 0;i<pedidos.size();i++) {
			suma = suma + pedidos.get(i).getPrecio();
		}
		this.ingresos = suma;
	}
	public float cuadrarCaja(){
		return ingresos;
	}
}
