package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.utileria.Restaurante;
import gestorAplicacion.utileria.Caja;

public class Serializador {
	private static File ruta = new File("src\\baseDatos\\temp");
	
	public static void serializar()
	{
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = ruta.listFiles();
		PrintWriter pw;
		
		for (File file: docs)
		{
			try
			{
				pw = new PrintWriter(file);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
		for(File file: docs)
		{
			if (file.getAbsolutePath().contains("Menu"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Restaurante.getMenu());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("Mesas"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Restaurante.getMesasDisponibles());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("Pedidos"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Caja.getPedidos());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("Platillos"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Restaurante.getPlatillos());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("MeserosTarde"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Restaurante.getMeserosHorarioTarde());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("MeserosNoche"))
			{
				try
				{
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(Restaurante.getMeserosHorarioNoche());
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
