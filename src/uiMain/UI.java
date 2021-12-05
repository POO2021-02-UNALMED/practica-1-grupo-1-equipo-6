package uiMain;
import java.util.*;
import gestorAplicacion.*;
public class UI {
	public static void main(String[] args) {
		int seleccionMenuInicial;
		seleccionMenuInicial = menuInicial();
		switch(seleccionMenuInicial) {
		case 1:
			//clearScreen();
			int inicioSesionAdministrador;
			inicioSesionAdministrador = logAdministrador();
			switch(inicioSesionAdministrador) {
			case 1:
				System.out.println("Inicio de sesión correcto");
				int menuAdministrador;
				menuAdministrador = menuAdministrador();
				switch(menuAdministrador) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					break;
				case 5:
					seleccionMenuInicial = menuInicial();
				}
				break;
				
				
			case 2:
				System.out.println("Inicio de sesión incorrecto");
				seleccionMenuInicial = menuInicial();
				break;
			default:
				break;
			}
			
			break;
		case 2:
			//clearScreen();
			System.out.println("2");
			break;
		default:
			break;
		}
	}
	public static int menuInicial() {
		int selection;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione su usuario:");
		System.out.println("----------------------\n");
		System.out.println("1.Administrador");
		System.out.println("2.Mesero");
		System.out.println("La opción seleccionada es: ");
		selection = sc.nextInt();
		return selection;
	}
	public static int logAdministrador() {
		int usuario;
		int contrasena;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su usuario:");
		usuario = sc.nextInt();
		System.out.println("Ingrese su contrasena");
		contrasena = sc.nextInt();
		System.out.println(usuario);
		System.out.println(contrasena);
		if(usuario == 2021 && contrasena == 1918 ) {
			return 1;
		}
		else {
			return 2;
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
		System.out.println("4.Cambiar la jornada");
		System.out.println("5.Retornar al inicio");
		System.out.println("La opcion seleccionada es: ");
		seleccion = sc.nextInt();
		return seleccion;
	}
	/*
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	*/
}
