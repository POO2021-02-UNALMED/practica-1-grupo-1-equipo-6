package uiMain;
import java.util.*;
import gestorAplicacion.utileria.*;
import gestorAplicacion.persona.*;

public class UI {
	public static void main(String[] args)
	{
		switchInicial();
	}
	
	public static int menuInicial() {
		int selection;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nia learned to cook!");
		System.out.println(Restaurante.getFecha());
		System.out.println("Jornada: " + Restaurante.getHora() + "\n");
		System.out.println("Seleccione su usuario:");
		System.out.println("----------------------\n");
		System.out.println("1.Administrador");
		System.out.println("2.Mesero");
		System.out.println("3.Apagar programa");
		System.out.println("La opcion seleccionada es: ");
		selection = sc.nextInt();
		return selection;
	}
	
	public static void switchInicial() {
		int seleccion = menuInicial();
		switch(seleccion) {
			case 1: //Administrador
				switchLogAdministrador();
				
				break;
			case 2: //Mesero
				switchMenuMesero();
				break;
			case 3:
				System.out.println("Hasta luego!");
				System.exit(0);
				break;
		}
	}
	
	public static int logAdministrador() {
		String usuario;
		int contrasena;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su usuario:");
		usuario = sc.nextLine();
		System.out.println("Ingrese su contrasena");
		contrasena = sc.nextInt();
		if(usuario.equals("admin") && contrasena == 1918 ) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public static void switchLogAdministrador() {
		int inicioSesionAdministrador = logAdministrador();
		switch(inicioSesionAdministrador) {
			case 1:
				System.out.println("\nInicio de sesion correcto \n");
				switchMenuAdministrador();
				break;
			case 2:
				System.out.println("Inicio de sesion incorrecto \n");
				switchInicial();
				break;
		}
	}
	
	public static int menuAdministrador() {
		int seleccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione lo deseado:");
		System.out.println("----------------------\n");
		System.out.println("1.Estado del restaurante");
		System.out.println("2.Caja del dia");
		System.out.println("3.Estadisticas de los pedidos");
		System.out.println("4.Cambiar jornada del restaurante");
		System.out.println("5.Editar meseros");
		System.out.println("6.Reiniciar caja");
		System.out.println("7.Agregar platillos al menu");
		System.out.println("8.Editar mesa");
		System.out.println("9.Editar platillo");
		System.out.println("10.Ver menu");
		System.out.println("11.Retornar al inicio");
		System.out.println("La opcion seleccionada es: ");
		seleccion = sc.nextInt();
		return seleccion;
	}
	
	public static void switchMenuAdministrador() {
		int menuAdministrador;
		menuAdministrador = menuAdministrador();
		switch(menuAdministrador) {
			case 1: //Estado del restaurante
				System.out.println("");
				System.out.println(Restaurante.estadoRestaurante());
				System.out.println("------------------------------ \n");
				switchMenuAdministrador();
				break;
			case 2: //Caja del dia
				Caja.cuadrarCaja();
				System.out.println("");
				System.out.println("Las ganancias de hoy fueron: $" + Caja.getIngresos() + "\n");
				switchMenuAdministrador();
				break;
			case 3: //Estadisticas de los pedidos
				System.out.println("");
				System.out.println(Caja.crearEstadisticas());
				switchMenuAdministrador();
				break;
			case 4: //Cambiar jornada
				String seleccion;
				Scanner sc = new Scanner(System.in);
				System.out.println("");
				System.out.println("Escriba la jornada actual(Tarde, Noche):");
				seleccion = sc.nextLine();
				Restaurante.setHora(seleccion);
				System.out.println("Jornada cambiada a: " + Restaurante.getHora() + "\n");
				switchMenuAdministrador();
				break;
			case 5: //Editar mesero
				switchEditarMeseros();
				break;
			case 6: //Reiniciar caja
				Caja.reiniciarCaja();
				System.out.println("Caja reiniciada");
				switchMenuAdministrador();
				break;
			case 7: //Crear menu
				crearMenu(); //se asume que ya hay platillos creados
				switchMenuAdministrador();
				break;
			case 8: //Editar mesa
				switchEditarMesa();
				break;
			case 9: //Editar platillo
				switchEditarPlatillo();
				break;
			case 10: 
				visualizarMenu();
				switchMenuAdministrador();
				break;
			case 11: //Retornar al inicio
				switchInicial();
				break;
		}
	}
	
	public static void switchEditarMeseros() {
		int menuEditarMeseros;
		menuEditarMeseros = editarMeseros();
		switch(menuEditarMeseros) {
			case 1:
				crearMeseros();
				switchEditarMeseros();
				break;
			case 2:
				eliminarMeseros();
				System.out.println("");
				System.out.println("Mesero eliminado \n");
				switchEditarMeseros();
				break;
			case 3:
				visualizarMeseros();
				switchEditarMeseros();
				break;
			case 4:
				switchMenuAdministrador();
				break;
		}
	}
	
	public static int editarMeseros() {
		int seleccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione lo deseado:");
		System.out.println("-----------------------");
		System.out.println("1.Crear mesero");
		System.out.println("2.Eliminar mesero");
		System.out.println("3.Ver meseros");
		System.out.println("4.Volver a menu administrador");
		seleccion = sc.nextInt();
		return seleccion;
	}
	
	public static void crearMeseros() {
		int jornada;
		String nombre;
		int documento;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos");
		System.out.println("Introduzca el nombre:");
		nombre = sc.nextLine();
		System.out.println("Introduzca documento:");
		documento = sc.nextInt();
		System.out.println("Introduzca la jornada (1:Tarde, 2:Noche)");
		jornada = sc.nextInt();
		if(jornada == 1) {
			Mesero mesero = new Mesero(nombre,documento);
			Restaurante.getMeserosHorarioTarde().add(mesero);
		}
		else if(jornada == 2) {
			Mesero mesero = new Mesero(nombre,documento);
			Restaurante.getMeserosHorarioNoche().add(mesero);
		}
	}
	
	public static void eliminarMeseros() {
		int documento;
		int posicion = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el documento de la persona que quiere eliminar:");
		documento = sc.nextInt();
		for(int i = 0; i< Restaurante.getMeserosHorarioTarde().size();i++) 
		{
			if(documento == Restaurante.getMeserosHorarioTarde().get(i).getDocumento()) {
				posicion = i;
			}
		}
		if(posicion > -1) 
		{
			Restaurante.getMeserosHorarioTarde().remove(posicion);
		}
		else 
		{
			for(int i = 0; i < Restaurante.getMeserosHorarioNoche().size();i++) 
			{
				if(documento == Restaurante.getMeserosHorarioTarde().get(i).getDocumento()) 
				{
					posicion = i;
				}
			}
			if(posicion > -1) 
			{
				Restaurante.getMeserosHorarioNoche().remove(posicion);
			}
		}
	}
	
	public static void visualizarMeseros() {
		String Mensaje = "Meseros presentes por la tarde:";
		for(int i = 0; i< Restaurante.getMeserosHorarioTarde().size();i++) 
		{
			Mensaje = Mensaje + "\n" + Restaurante.getMeserosHorarioTarde().get(i).getNombre();
		}
		Mensaje = Mensaje + "\n" + "Mesero presentes por la noche:";
		for(int i = 0; i<Restaurante.getMeserosHorarioNoche().size();i++) 
		{
			Mensaje = Mensaje + "\n" + Restaurante.getMeserosHorarioNoche().get(i).getNombre();
		}
		System.out.println(Mensaje);
	}
	
	public static int editarPlatillo() {
		int seleccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione lo deseado:");
		System.out.println("----------------------");
		System.out.println("1.Crear platillo");
		System.out.println("2.Eliminar platillo");
		System.out.println("3.Ver platillos");
		System.out.println("4.Volver a menu administrador");
		seleccion = sc.nextInt();
		return seleccion;
	}
	
	public static void switchEditarPlatillo() {
		int menuEditarPlatillo;
		menuEditarPlatillo = editarPlatillo();
		switch(menuEditarPlatillo) {
		case 1: //Crear platillo
			crearPlatillo();
			switchEditarPlatillo();
			break;
		case 2: //Eliminar platillo
			eliminarPlatillo();
			System.out.println("Platillo eliminado \n");
			switchEditarPlatillo();
			break;
		case 3: //Ver platillo
			visualizarPlatillos();
			switchEditarPlatillo();
			break;
		case 4: //Volver a menu administrador
			switchMenuAdministrador();
			break;
		}
	}
	
	public static void crearPlatillo() {
		int tiempo; 
		String nombre;
		String tipo; 
		String ingredientes;
		int precio;
		String identificador;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos:\n");
		System.out.println("Introduzca el nombre del platillo");
		nombre = sc.nextLine();
		System.out.println("Introduzca el tipo de platillo");
		tipo = sc.nextLine();
		System.out.println("Introduzca los ingredientes del platillo");
		ingredientes = sc.nextLine();
		System.out.println("Introduzca el identificador");
		identificador = sc.nextLine();
		System.out.println("Introduzca el precio del platillo");
		precio = sc.nextInt();
		System.out.println("Introduzca el tiempo de preparacion");
		tiempo = sc.nextInt();
		
		Platillo platillo = new Platillo(tiempo,nombre,tipo,ingredientes, precio, identificador);
		Restaurante.getPlatillos().add(platillo);
	}
	
	public static void eliminarPlatillo() {
		String identificador;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el identificador del platillo que quiere eliminar");
		identificador = sc.nextLine();
		
		for(int i = 0; i< Restaurante.getPlatillos().size();i++) {
			if(Restaurante.getPlatillos().get(i).getIdentificador().equals(identificador)) 
			{
				Restaurante.getPlatillos().remove(i);
			}
		}
		
		for(int i = 0; i< Restaurante.getMenu().size();i++) 
		{
			if(Restaurante.getMenu().get(i).getIdentificador().equals(identificador))
			{
				Restaurante.getMenu().remove(i);
			}
		}
		
	}
	
	public static void visualizarPlatillos() {
		String mensaje = "Los platillos del restaurante son:";
		for(int i = 0; i < Restaurante.getPlatillos().size();i++) 
		{
			mensaje = mensaje + "\n" + Restaurante.getPlatillos().get(i).getNombre() + " : " + Restaurante.getPlatillos().get(i).getIdentificador();
		}
		System.out.println(mensaje + "\n");
	}
	
	public static void crearMenu() {
		String menuCrear;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los platillos para el menu de hoy");
		menuCrear = sc.nextLine();
		String[] dividido = menuCrear.split(";");
		for(int i = 0; i < dividido.length;i++) 
		{
			int posicion = -2;
			for(int j = 0; j < Restaurante.getPlatillos().size();j++) 
			{
				if(dividido[i].equals(Restaurante.getPlatillos().get(j).getIdentificador())) 
				{
					Restaurante.getMenu().add(Restaurante.getPlatillos().get(j));
				}
			}
		}
	}
	
	public static void visualizarMenu() {
		String mensaje = "Los platillos del menu son:";
		for(int i = 0; i < Restaurante.getMenu().size();i++) {
			mensaje = mensaje + "\n" + Restaurante.getMenu().get(i).getNombre();
		}
		System.out.println(mensaje + "\n");
	}
	
	public static int editarMesa() {
		int seleccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione lo deseado");
		System.out.println("----------------------");
		System.out.println("1.Crear mesa");
		System.out.println("2.Eliminar mesa");
		System.out.println("3.Ver mesas");
		System.out.println("4.Volver a menu administrador");
		seleccion = sc.nextInt();
		return seleccion;
	}
	
	public static void switchEditarMesa() {
		int menuEditarMesa;
		menuEditarMesa = editarMesa();
		switch(menuEditarMesa) {
		case 1: //Crear mesa
			crearMesa();
			switchEditarMesa();
			break;
		case 2: //Eliminar mesa
			eliminarMesa();
			System.out.println("Mesa eliminada \n");
			switchEditarMesa();
			break;
		case 3:
//Faltantes: 3.

/*
public static void clearScreen() {
	System.out.println("\033[H\033[2J");
	System.out.flush();
}
*/
