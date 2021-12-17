//Clase Deserializador
//Autores: Michael Moreno Valoyes, Santiago Salazar Ramirez
//En esta clase se define el metodo para deserializar los objetos desde los archivos
package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import gestorAplicacion.utileria.*;
import gestorAplicacion.persona.*;
import java.util.ArrayList;

public class Deserializador {
	private static File ruta = new File("src\\baseDatos\\temp"); //definimos la ruta de los archivos desde la cual se deserializaran los objetos
	
	@SuppressWarnings("unchecked") //esta linea solo la puse por recomendacion de eclipse para evadir un warning un poco molesta
	public static void deserializar() //metodo para deserializar las listas de objetos en los archivos
	{
		FileInputStream fis;
		ObjectInputStream ois;
		File[] docs = ruta.listFiles();
		
		for(File file: docs) //iteramos en todos los arhchivos revisando su nombre, segun el nombre del archivo utilizamos objetos FileInputStream
			 //y ObjectInputStream para deserializar cada lista de el archivo respectivo
		{
			if (file.getAbsolutePath().contains("Menu"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Restaurante.setMenu((ArrayList<Platillo>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("Mesas"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Restaurante.setMesasDisponibles((ArrayList<Mesa>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("MeserosTarde"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Restaurante.setMeserosHorarioTarde((ArrayList<Mesero>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("MeserosNoche"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Restaurante.setMeserosHorarioNoche((ArrayList<Mesero>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("Pedidos"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Caja.setPedidos((ArrayList<Pedido>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			
			else if (file.getAbsolutePath().contains("Platillos"))
			{
				try
				{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					Restaurante.setPlatillos((ArrayList<Platillo>) ois.readObject());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
