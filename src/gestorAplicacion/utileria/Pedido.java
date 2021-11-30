package gestorAplicacion.utileria;
import java.util.*;
import gestorAplicacion.persona.*;
import java.util.Collections;

public class Pedido {
	private Cliente cliente;
	private ArrayList<Platillo> platillos = new ArrayList<Platillo>();
	private Mesero mesero;
	private boolean estado;
	private float precio;
	private Caja caja;
	
	public Pedido(Cliente cliente,Mesero mesero, boolean estado, float precio, Caja caja) {
		this.cliente = cliente;
		this.mesero = mesero;
		this.estado = estado;
		this.precio = precio;
		this.caja = caja;
	}
	
	//Gets y sets
	public ArrayList<Platillo> getPlatillos(){
		return platillos;
	}
	
	public void setPlatillos(ArrayList<Platillo> platillos) {
		this.platillos = platillos;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Caja getCaja() {
		return caja;
	}
	
	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	
	//Finalizacion sets y gets.
	public void borrarPedido() {
		estado = false;
		caja.agregarPedidos(this);
	}
	
	public Mesero getMesero() {
		return mesero;
	}
	
	//metodo que genera la string de la factura
	public String facturar () {
		
		//variables útiles para el proceso de crear la factura, la variable factura se inicializa con elencabezado de todas las facturas
		ArrayList<String> repetidos = new ArrayList<>();		
		String factura = "Restaurante Mira tu que curioso no lo hemos nombrado\n" + 
						 Restaurante.getFecha() + " " + Restaurante.getHora() + "\n" 
						 + "Cliente: " + this.cliente.getNombre() + "       " + "Mesero: " + this.mesero.getNombre() + "\n"
						 + " \n" + " \n"
						 + "Platillos\n";
		
		//se checa la cantidad de veces que está un platillo y se agrega el platillo, su frecuencia y el precio de todas las unidades juntas
		for (int i = 0; i < this.platillos.size(); i++) {
			int ocurrences = Collections.frequency(this.platillos, this.platillos.get(i));
			if (ocurrences > 1 && !(repetidos.contains(this.platillos.get(i).getNombre()))) {
				factura += this.platillos.get(i).getNombre() + " * " + ocurrences + "    $" + (this.platillos.get(i).getPrecio()*ocurrences) + "\n";
				repetidos.add(this.platillos.get(i).getNombre());
				this.precio += (this.platillos.get(i).getPrecio()*ocurrences);
			} else if (ocurrences == 1){
				factura += this.platillos.get(i).getNombre() + " * " + ocurrences + "    $" + (this.platillos.get(i).getPrecio()*ocurrences) + "\n";
				this.precio += (this.platillos.get(i).getPrecio()*ocurrences);
			}
		}
		
		//por ultimo se agrega el total, final de todas las facturas y se devuelve la string factura ya completa
		factura += " \n" + "Total: $" + this.precio + "\n"
				   + " \n"
				   + "Gracias por visitarnos! \n"
				   + Restaurante.getLugar() + " \n"
				   + "315 525 6969";
		return factura;
	}
}
