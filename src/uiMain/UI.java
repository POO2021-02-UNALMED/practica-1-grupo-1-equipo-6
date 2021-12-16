// Clase UI
// Autores: Santiago Salazar, Michael Moreno, Jane Gutierrez
// Esta clase corresponde a la interfaz de usuario, es la cual imprime los menus y procesa los input


package uiMain;
import java.util.*;
import gestorAplicacion.utileria.*;
import gestorAplicacion.utileria.Restaurante.Jornada;
import gestorAplicacion.persona.*;
import baseDatos.*;

public class UI {

	public static void main(String[] args)
	{
		//Al ejecutar el programa se deserializa los objetos.
		Deserializador.deserializar();
		//Se ejecuta la interfaz. Se realizaron como métodos para poder volver a un menú
		//inferior al anterior.
		switchInicial();
	}
	//El menú inicial para imprimir y seleccionar la opción (Estas opciones ya aparecen
	//en la parte escrita con su debida explicacion).
	public static int menuInicial() {
		//int para seleccionar
		int selection;
		//Creamos el scanner
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
		//El input del usuario
		selection = sc.nextInt();
		return selection;
	}
	//Ya aqui se ve que dependiendo de la opcion seleccionada se movera a otra parte de la interfaz.
	//Las opciones que tiene el usuario son: administrador, mesero y apagar el programa.
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
				Serializador.serializar();
				System.exit(0);
				break;
			//En caso de que el usuario haya cometido un error pues se le dira que eligio una erronea.
			//Luego de que se imprima eso se reiniciará desde la parte de la inferfaz en donde estaba.
			default:
				System.out.println("Eliga otra opcion por favor\n");
				switchInicial();
				break;
		}
	}
	//Inicio de sesion del administrador
	public static int logAdministrador() {
		//Usuario del administrador
		String usuario;
		//Contrasena del administrador
		int contrasena;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su usuario:");
		usuario = sc.nextLine();
		System.out.println("Ingrese su contrasena");
		contrasena = sc.nextInt();
		//Para que funcione el programa debe de tener el usuario admin y contrasena 1918.
		if(usuario.equals("admin") && contrasena == 1918 ) {
			return 1;
		}
		else {
			return 2;
		}
	}
	//Lo mismo que el anterior switch: aqui es donde ya se eligen las opciones en sí.
	//Segun lo digitado puede enviarlo al menu del administrador o devolverlo a la interfaz inicial.
	public static void switchLogAdministrador() {
		int inicioSesionAdministrador = logAdministrador();
		switch(inicioSesionAdministrador) {
			case 1:
				System.out.println("\nInicio de sesion correcto \n");
				switchMenuAdministrador();
				break;
			case 2:
				System.out.println("Inicio de sesion incorrecto \n");
				//Este switchs y los demas es para el cambio de menu, es por esto que se invoca.
				switchInicial();
				break;
		}
	}
	//El menu del administrador, ya aqui podra seleccionar la opcion deseada.
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
	//Segun la opcion seleccionada realiza cierta accion
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
				Jornada j = null;
				Scanner sc = new Scanner(System.in);
				System.out.println("");
				//El usuario digita la jornada deseada
				System.out.println("Escriba la jornada actual(Tarde, Noche):");
				seleccion = sc.nextLine();
				//En caso de que sea Tarde
				if(seleccion.equals("Tarde"))
				{
					j = Jornada.TARDE;
				}
				//En caso de que sea Noche
				else if(seleccion.equals("Noche"))
				{
					j = Jornada.NOCHE;
				}
				//En caso de que haya digitado una opcion que no era
				if(j == null) {
					System.out.println("Opcion no valida, por favor introducir otra\n");
				}
				//En caso de que haya digitado las dos opciones disponibles
				else {
				Restaurante.setHora(j);
				System.out.println("Jornada cambiada a: " + Restaurante.getHora() + "\n");
				}
				switchMenuAdministrador();
				break;
			case 5: //Editar mesero
				switchEditarMeseros();
				break;
			case 6: //Reiniciar caja
				//Como ya se dijo en la memoria escrita: se puede reiniciar los valores de la caja.
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
			default:
				System.out.println("Eliga otra opcion por favor\n");
				switchMenuAdministrador();
				break;
			
		}
	}
	//El switch para editar los meseros (puede crear, eliminar y visualizar meseros)
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
				switchEditarMeseros();
				break;
			case 3:
				visualizarMeseros();
				switchEditarMeseros();
				break;
			case 4:
				switchMenuAdministrador();
				break;
			default:
				System.out.println("Eliga otra opcion por favor\n");
				switchEditarMeseros();
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
	//Crear meseros
	public static void crearMeseros() {
		//El funcional es para que en caso de que se haya repetido el documento
		//O se haya introducido una jornada erronea no se introduzca el mesero
		int funcional = 1;
		int jornada;
		String nombre;
		int documento;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos");
		System.out.println("Introduzca el nombre:");
		nombre = sc.nextLine();
		System.out.println("Introduzca documento:");
		documento = sc.nextInt();
		//Se hace la busqueda del documento en la lista de los dos meseros. En caso de que este pues se pone funcional como 0.
		for(int i =0; i<Restaurante.getMeserosHorarioNoche().size();i++) {
			if(Restaurante.getMeserosHorarioNoche().get(i).getDocumento() == documento) {
				funcional = 0;
			}
		}
		for(int i = 0; i<Restaurante.getMeserosHorarioTarde().size();i++) {
			if(Restaurante.getMeserosHorarioTarde().get(i).getDocumento() == documento) {
				funcional = 0;
			}
		}
		System.out.println("Introduzca la jornada (1:Tarde, 2:Noche)");
		jornada = sc.nextInt();
		//Si el documento no esta repetido
		if(funcional == 1) {
			if(jornada == 1) {
				Mesero mesero = new Mesero(nombre,documento);
				Restaurante.getMeserosHorarioTarde().add(mesero);
			}
			else if(jornada == 2) {
				Mesero mesero = new Mesero(nombre,documento);
				Restaurante.getMeserosHorarioNoche().add(mesero);
			}
			//Si introdujo una jornada erronea
			else {
				System.out.println("Error en la introduccion de datos, por favor repita el procedimiento");
			}
		}
		else {
			System.out.println("Error en la introduccion de datos, por favor repita el procedimiento");
		}
	}
	//Con el posicion > -1 se verifica que el documento debe estar en alguna de las dos listas.
	//Este metodo elimina al mesero.
	
	public static void eliminarMeseros() {
		int documento;
		int posicion = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el documento de la persona que quiere eliminar:");
		documento = sc.nextInt();
		//Busca por los de la tarde
		for(int i = 0; i< Restaurante.getMeserosHorarioTarde().size();i++) 
		{
			//Si esta en los de la tarde
			if(documento == Restaurante.getMeserosHorarioTarde().get(i).getDocumento()) {
				posicion = i;
			}
		}
		//Se elimina
		if(posicion > -1) {
			Restaurante.getMeserosHorarioTarde().remove(posicion);
		}
		//Si no esta en la tarde
		else {
			for(int i = 0; i < Restaurante.getMeserosHorarioNoche().size();i++) 
			{
				//Si esta en noche
				if(documento == Restaurante.getMeserosHorarioNoche().get(i).getDocumento()) 
				{
					posicion = i;
				}
				}
			if(posicion > -1) 
			{
				Restaurante.getMeserosHorarioNoche().remove(posicion);
			}
		}
		//Si no se encontro al mesero
		if(posicion == -1) {
			System.out.println("No se encontro al mesero");
		}
		//Si se encontro al mesero
		else {
			System.out.println("Mesero eliminado \n");
		}
		
	}
	//Visualiza los meseros segun lo horario
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
	//Se imprimen las opciones para editar los platillos
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
	//La eleccion segun la edicion de los platillos
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
		default:
			System.out.println("Eliga otra opcion por favor\n");
			switchEditarPlatillo();
			break;
		}
	}
	//Creacion del platillo con sus atributos
	public static void crearPlatillo() {
		int tiempo; 
		String nombre;
		String tipo; 
		String ingredientes;
		int precio;
		String identificador;
		//La misma idea del funcional
		int funcional = 1;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos:\n");
		System.out.println("Introduzca el nombre del platillo");
		nombre = sc.nextLine();
		System.out.println("Introduzca el tipo de platillo");
		tipo = sc.nextLine();
		System.out.println("Introduzca los ingredientes del platillo");
		ingredientes = sc.nextLine();
		//El identificador es lo que identifica al platillo de los demas
		System.out.println("Introduzca el identificador");
		identificador = sc.nextLine();
		System.out.println("Introduzca el precio del platillo");
		precio = sc.nextInt();
		System.out.println("Introduzca el tiempo de preparacion");
		tiempo = sc.nextInt();
		//Recorro toda la lista de platillos para verificar si el identificador esta repetido
		for(int i = 0; i < Restaurante.getPlatillos().size();i++) {
			if(Restaurante.getPlatillos().get(i).getIdentificador().equals(identificador)) {
				funcional = 0;
			}
		}
		//Si el platillo no esta repetido añada este a la lista de platillos
		if(funcional == 1) {
			Platillo platillo = new Platillo(tiempo,nombre,tipo,ingredientes, precio, identificador);
			Restaurante.getPlatillos().add(platillo);
		}
		//Si el platillo esta repetido:
		else {
			System.out.println("Introdujo un identificador repetido, por favor introducir otro");
		}
	}
	//Para eliminar el platillo
	public static void eliminarPlatillo() {
		//La misma forma de verificar, pero ahora suponiendo que no esta
		int funcional = 0;
		String identificador;
		Scanner sc = new Scanner(System.in);
		//Introduce el identificador del platillo
		System.out.println("Introduzca el identificador del platillo que quiere eliminar");
		identificador = sc.nextLine();
		//Lo busca y elimina de la lista de platillos (si esta)
		for(int i = 0; i< Restaurante.getPlatillos().size();i++) {
			if(Restaurante.getPlatillos().get(i).getIdentificador().equals(identificador)) 
			{
				funcional = 1;
				Restaurante.getPlatillos().remove(i);
			}
		}
		//Lo busca y elimina de la lista de platillos (si esta)
		for(int i = 0; i< Restaurante.getMenu().size();i++) 
		{
			if(Restaurante.getMenu().get(i).getIdentificador().equals(identificador))
			{
				Restaurante.getMenu().remove(i);
			}
		}
		if(funcional == 0) {
			System.out.println("No existe ese platillo, por favor introduzca otro identificador");
		}
		
	}
	//Visualizar todos los platillos con su identificador unico
	public static void visualizarPlatillos() {
		String mensaje = "Los platillos del restaurante son:";
		for(int i = 0; i < Restaurante.getPlatillos().size();i++) 
		{
			mensaje = mensaje + "\n" + Restaurante.getPlatillos().get(i).getNombre() + " : " + Restaurante.getPlatillos().get(i).getIdentificador();
		}
		System.out.println(mensaje + "\n");
	}
	//Para agregar los platillos al menu
	public static void crearMenu() {
		//El mensaje inicial para decir que identificadores no estan
		String mensaje = "Algunos identificadores no se encuentran en los platillos:";
		String menuCrear;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los platillos para el menu de hoy");
		menuCrear = sc.nextLine();
		String[] dividido = menuCrear.split(";");
		for(int i = 0; i < dividido.length;i++) 
		{
			//Suponemos primero que el platillo no esta en menu
			int verdad = 0;
			for(int j = 0; j < Restaurante.getPlatillos().size();j++) 
			{
				if(dividido[i].equals(Restaurante.getPlatillos().get(j).getIdentificador())) 
				{
					//Si no estaba antes en el menu
					if(Restaurante.getMenu().contains(Restaurante.getPlatillos().get(j)) == false) {
						Restaurante.getMenu().add(Restaurante.getPlatillos().get(j));
					}
					//Ahi significa que esta en el menu
					verdad = 1;
				}
			}
			if(verdad == 0) {
				mensaje = mensaje + "\n" + dividido[i];
				
			}
		}
		if(mensaje.equals("Algunos identificadores no se encuentran en los platillos:") == false) {
			System.out.println(mensaje);
		}
		

	}
	//Para visualizar menu (recorre todo el menu y va sumando al mensaje)
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
	//Las opciones para editar una mesa
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
			switchEditarMesa();
			break;
		case 3:
			visualizarMesas();
			switchEditarMesa();
			break;
		case 4: //Volver a menu administrador
			switchMenuAdministrador();
			break;
		default:
			System.out.println("Eliga otra opcion por favor\n");
			switchEditarMesa();
			break;
		}
	}
	//Metodo para crear mesas
	public static void crearMesa() {
		//Suponemos que la mesa no esta repetida
		int funcional = 1;
		int numero;
		int sillas;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos:");
		System.out.println("Introduzca el numero de la mesa");
		numero = sc.nextInt();
		System.out.println("Introduzca el numero de sillas");
		sillas = sc.nextInt();
		//Recorremos las mesas disponibles y ocupadas, para ver si ya el numero anda ocupado
		for(int i = 0;i<Restaurante.getMesasDisponibles().size();i++) {
			if(Restaurante.getMesasDisponibles().get(i).getNumero() == numero) {
				funcional = 0;
			}
		}
		for(int i = 0;i <Restaurante.getMesasReservadas().size();i++) {
			if(Restaurante.getMesasReservadas().get(i).getNumero() == numero) {
				funcional = 0;
			}
		//Si la mesa ya existia
		}
		if(funcional == 0) {
			System.out.println("Ese numero ya existe, por favor introduzca otro");
		}
		// Si no existia
		else {
			Mesa mesa = new Mesa(true,numero,sillas);
		}
		
	}
	//metodo para eliminar la mesa
	public static void eliminarMesa() {
		//La misma variable para verificar
		int funcional = 0;
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numero de la mesa que quiere eliminar");
		numero = sc.nextInt();
		//Busca por las mesas disponibles para eliminarla
		//Se preguntara, ¿por que no en las ocupadas? Le respondo sencillo: ¿usted
		//se pondria a eliminar mesas cuando esta una ocupada?
		for(int i = 0; i< Restaurante.getMesasDisponibles().size(); i++) 
		{
			if(numero == Restaurante.getMesasDisponibles().get(i).getNumero()) 
			{
				//Se elimina la mesa
				Restaurante.getMesasDisponibles().remove(i);
				funcional = 1;
			}
		}
		if(funcional == 0) {
			System.out.println("Esa mesa no existe, por favor introducir otra\n");
		}
		else {
			System.out.println("Mesa eliminada \n");
		}
	}
	
	public static void visualizarMesas()
	{
		String mesasDisponibles = "Las mesas disponibles ahora mismo son:";
		for(int i = 0; i< Restaurante.getMesasDisponibles().size();i++) {
			mesasDisponibles = mesasDisponibles + "\n" + Restaurante.getMesasDisponibles().get(i).getNumero() + "\n";
		}
		System.out.println(mesasDisponibles);
	}
	
	public static int menuMesero() {
		int seleccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione lo deseado:");
		System.out.println("-----------------------");
		System.out.println("1.Asignar mesa y hacer el pedido");
		System.out.println("2.Ver pedido");
		System.out.println("3.Crear factura a una mesa ");
		System.out.println("4.Agregar platillos a un pedido ");
		System.out.println("5.Retornar al inicio");
		System.out.println("La opcion seleccionada es: ");
		seleccion = sc.nextInt();
		return seleccion;
	}
	
	public static void switchMenuMesero() {
		int seleccionMenuMesero;
		seleccionMenuMesero = menuMesero();
		switch(seleccionMenuMesero) {
		case 1: //Pedir pedido + asignar mesa
			crearPedido();
			switchMenuMesero();
			break;
		case 2: //Visualizar pedido de una mesa
			verPedido();
			switchMenuMesero();
			break;
		case 3: //Crear factura a una mesa
			crearFactura();
			switchMenuMesero();
			break;
		case 4: //Agregar platillos a un pedido
			agregarPlatillo();
			switchMenuMesero();
			break;
		case 5: //Retornar al inicio
			switchInicial();
			break;
		default:
			System.out.println("Eliga otra opcion por favor\n");
			switchMenuMesero();
			break;
		}
	}
	//Agregar platillos a un pedido.
	public static void agregarPlatillo() {
		Mesa mesa1 = null;
		String mensaje = "Estos platillos no estan presentes en el menu:";
		int mesa;
		int frecuencia;
		int totalPlatillos;
		Scanner sc = new Scanner(System.in);
		//La mesa donde esta el cliente
		System.out.println("Mesa a la cual quiere agregar platillos:");
		mesa = sc.nextInt();
		for(int i =0;i<Restaurante.getMesasReservadas().size();i++) {
			if(mesa == Restaurante.getMesasReservadas().get(i).getNumero()) {
				mesa1 = Restaurante.getMesasReservadas().get(i);
			}
		}
		while(mesa1 == null) {
			System.out.println("No se asigno la mesa indicada, vuelva a intentar");
			System.out.println("Introduzca la mesa");
			mesa = sc.nextInt();
			for(int i =0;i<Restaurante.getMesasReservadas().size();i++) {
				if(mesa == Restaurante.getMesasReservadas().get(i).getNumero()) {
					mesa1 = Restaurante.getMesasReservadas().get(i);
				}
			}
		}
		//Los platillos que quiere agregar
		System.out.println("Digite la cantidad de platillos que desea:");
		totalPlatillos = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < totalPlatillos; i++)
		{
			//Suponemos con esta verdad de que el platillo no esta en el menu
			int verdad = 0;
			//El identificador del platillo
			String identificador;
			//La frecuencia de veces que se quiere
			int veces;
			System.out.println("Introduzca el identificador del platillo:");
			identificador = sc.nextLine();
			//Buscar por todos los platillos si esta o no en el menu
			for(int l = 0;l<Restaurante.getMenu().size();l++) {
				if(Restaurante.getMenu().get(l).getIdentificador().equals(identificador)) {
					//El platillo estaba en el menu
					verdad = 1;
				}
			}
			//Si el platillo no esta
			if(verdad == 0) {
				mensaje = mensaje + "\n" + identificador;
			}
			System.out.println("Cuantos?");
			veces = sc.nextInt();
			sc.nextLine();
			for(int j = 0; j < veces; j++)
			{
				
				Platillo platillo = null;
				for(int k = 0; k < Restaurante.getMenu().size(); k++)
				{
					if(Restaurante.getMenu().get(k).getIdentificador().equals(identificador))
					{
						platillo = Restaurante.getMenu().get(k);
						break;
					}
				}
				//Si encontro el platillo
				if (platillo != null){
					mesa1.getCliente().getPedido().getPlatillos().add(platillo);
					platillo.setFrecuencia(platillo.getFrecuencia() + 1);
				}
			}
		}
		if(mensaje.equals("Estos platillos no estan presentes en el menu:") == false) {
			System.out.println(mensaje);
		}
		
	}
	//El metodo para asignar un pedido con su debido cliente
	public static void crearPedido() {
		int documentoM;
		String nombre;
		int documento;
		int mesa;
		int totalPlatillos;
		//El mensaje de los platillos que no estaban en el menu
		String mensaje = "Estos platillos no estan presentes en el menu:";
		//Los platillos del pedido
		ArrayList<Platillo> platillos = new ArrayList<Platillo>();
		Pedido pedido = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos del cliente");
		System.out.println("Nombre");
		nombre = sc.nextLine();
		System.out.println("Documento");
		documento = sc.nextInt();
		System.out.println("Mesa");
		mesa = sc.nextInt();
		Cliente cliente = new Cliente(nombre,documento);
		cliente.reservar(mesa);
		//En caso de que la mesa que haya asignado no exista pues sigue pidiendo la mesa
		while(cliente.getMesa() == null) {
			System.out.println("No se asigno la mesa indicada, vuelva a intentar");
			System.out.println("Introduzca la mesa");
			mesa = sc.nextInt();
			cliente.reservar(mesa);
		}
		//La cantidad de platillos diferentes
		System.out.println("Cuantos platillos tiene el pedido?");
		totalPlatillos = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < totalPlatillos; i++)
		{
			//Suponemos con esta verdad de que el platillo no esta en el menu
			int verdad = 0;
			//El identificador del platillo
			String identificador;
			//La frecuencia de veces que se quiere
			int frecuencia;
			System.out.println("Introduzca el identificador del platillo:");
			identificador = sc.nextLine();
			//Buscar por todos los platillos si esta o no en el menu
			for(int l = 0;l<Restaurante.getMenu().size();l++) {
				if(Restaurante.getMenu().get(l).getIdentificador().equals(identificador)) {
					//El platillo estaba en el menu
					verdad = 1;
				}
			}
			//Si el platillo no esta
			if(verdad == 0) {
				mensaje = mensaje + "\n" + identificador;
			}
			System.out.println("Cuantos?");
			frecuencia = sc.nextInt();
			sc.nextLine();
			for(int j = 0; j < frecuencia; j++)
			{
				
				Platillo platillo = null;
				for(int k = 0; k < Restaurante.getMenu().size(); k++)
				{
					if(Restaurante.getMenu().get(k).getIdentificador().equals(identificador))
					{
						platillo = Restaurante.getMenu().get(k);
						break;
					}
				}
				//Si encontro el platillo
				if (platillo != null){
					platillos.add(platillo);
					platillo.setFrecuencia(platillo.getFrecuencia() + 1);
				}
			}
		}
		//El documento del mesero
		System.out.println("Introduzca su documento:");
		documentoM = sc.nextInt();
		//Para revisar si el mesero existe
		int verdadMesero = 0;
		//Buscamos por los dos horarios al mesero
		if(Restaurante.getHora() == Jornada.TARDE)
		{
			for(int i = 0; i < Restaurante.getMeserosHorarioTarde().size(); i++)
			{
				if(Restaurante.getMeserosHorarioTarde().get(i).getDocumento() == documentoM)
				{
					//Se crea el pedido con este
					pedido = new Pedido(cliente, Restaurante.getMeserosHorarioTarde().get(i),0);
					verdadMesero = 1;
					break;
				}
			}
		}
		if(Restaurante.getHora() == Jornada.NOCHE)
		{
			for(int i = 0; i < Restaurante.getMeserosHorarioNoche().size(); i++)
			{
				if(Restaurante.getMeserosHorarioNoche().get(i).getDocumento() == documentoM)
				{
					verdadMesero = 1;
					pedido = new Pedido(cliente, Restaurante.getMeserosHorarioNoche().get(i),0);
					break;
				}
			}
		}
		//Tiene que introducir correctamente su documento, hasta que no lo haga seguira en el while
		while(verdadMesero == 0) {
			System.out.println("Introduzca nuevamente su documento por favor (se introdujo mal su documento)");
			documentoM = sc.nextInt();
			if(Restaurante.getHora() == Jornada.TARDE)
			{
				for(int i = 0; i < Restaurante.getMeserosHorarioTarde().size(); i++)
				{
					if(Restaurante.getMeserosHorarioTarde().get(i).getDocumento() == documentoM)
					{
						//Se crea el pedido con este
						pedido = new Pedido(cliente, Restaurante.getMeserosHorarioTarde().get(i),0);
						verdadMesero = 1;
						break;
					}
				}
			}
			if(Restaurante.getHora() == Jornada.NOCHE)
			{
				for(int i = 0; i < Restaurante.getMeserosHorarioNoche().size(); i++)
				{
					if(Restaurante.getMeserosHorarioNoche().get(i).getDocumento() == documentoM)
					{
						verdadMesero = 1;
						pedido = new Pedido(cliente, Restaurante.getMeserosHorarioNoche().get(i),0);
						break;
					}
				}
			}
		}
		//Se crea el pedido con su debidos atributos
		if(verdadMesero == 1) {
			pedido.setPlatillos(platillos);
			cliente.setPedido(pedido);
			System.out.println("Pedido creado");
		}

		//Imprimir los platillos que no andaban en el menu
		if(mensaje.equals("Estos platillos no estan presentes en el menu:") == false) {
			System.out.println(mensaje);
		}
	}
	//Ver pedido segun la mesa seleccionada
	public static void verPedido() {
		//Numero de la mesa a seleccionar
		int numeroMesa;
		Mesa mesa = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite la mesa del pedido que quiere consultar");
		numeroMesa = sc.nextInt();
		//Buscar ese numero por todas las mesas reservadas
		for(int i = 0; i < Restaurante.getMesasReservadas().size();i++) {
			if(numeroMesa == Restaurante.getMesasReservadas().get(i).getNumero()) {
				mesa = Restaurante.getMesasReservadas().get(i);
			}
		}
		if(mesa != null) {
			String info = "Cliente: " + mesa.getCliente().getNombre() + "       " + "Mesero: " + mesa.getCliente().getPedido().getMesero().getNombre() + "\n"
					 + " \n" + " \n"
					 + "Platillos\n";
			ArrayList<String> repetidos = new ArrayList<>();
			for (int i = 0; i < mesa.getCliente().getPedido().getPlatillos().size(); i++) {
				int ocurrences = Collections.frequency(mesa.getCliente().getPedido().getPlatillos(), mesa.getCliente().getPedido().getPlatillos().get(i));
				if (ocurrences > 1 && !(repetidos.contains(mesa.getCliente().getPedido().getPlatillos().get(i).getNombre()))) {
					info += mesa.getCliente().getPedido().getPlatillos().get(i).getNombre() + " * " + ocurrences + "\n";
					repetidos.add(mesa.getCliente().getPedido().getPlatillos().get(i).getNombre());
				} 
				else if (ocurrences == 1)
				{
					info += mesa.getCliente().getPedido().getPlatillos().get(i).getNombre() + " * " + ocurrences + "\n";
				}
			}
			System.out.println(info);
		}
		else {
			System.out.println("La mesa seleccionada no existe o no esta reservada");
		}
	}
	//Crear factura
	public static void crearFactura() {
		//Suponemos que no funciona el programa
		int funciona = 0;
		int numeroMesa;
		Mesa mesa;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite la mesa con el pedido a facturar:");
		numeroMesa = sc.nextInt();
		//Busca la mesa y segun la mesa crea la factura
		for(int i = 0; i < Restaurante.getMesasReservadas().size();i++) 
		{
			if(numeroMesa == Restaurante.getMesasReservadas().get(i).getNumero()) 
			{
				funciona = 1;
				mesa = Restaurante.getMesasReservadas().get(i);
				System.out.println(mesa.getCliente().getPedido().facturar());
				mesa.getCliente().irse();
			}
		}
		if(funciona == 0) {
			System.out.println("Dicha mesa no existe entre las mesas reservadas, por favor editar los valores");
		}
	}
}

