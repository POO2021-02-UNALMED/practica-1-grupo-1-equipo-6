package gestorAplicacion.utileria;
import java.util.*;
public class Caja {
	private float ingresos;
	private float gastos;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Caja(float ingresos, float gastos) {
		this.ingresos = ingresos;
		this.gastos = gastos;
	}
	
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
	//Get y sets:
	public float getIngresos() {
		return ingresos;
	}
	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}
	public float getGastos() {
		return gastos;
	}
	public void setGastos(float gastos) {
		this.gastos = gastos;
	}
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	//Finalizacion set y get
}
