package bo.edu.ucb.est;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       inicioSesion();
    }
    public static void inicioSesion() {
		
		boolean flag = false;
		int pin2 = 0;
		do {
			Scanner sc = new Scanner(System.in);
			String codClie;
			
			boolean flag2 =false, flag3 = false;
			System.out.println("Por favor ingrese su código de cliente: ");
			
			do {
				codClie = sc.nextLine();
				if(codClie.equals("")) {
					System.out.println("Por favor verifique que haya ingresado algo\n ----------------------------------");
				}else {
					flag2 = true;
				}
			}while(!flag2);
			
			System.out.println("Por favor ingrese su pin se seguridad: ");
			do {
				try {
					Scanner sc2 = new Scanner(System.in);
					int pin = sc2.nextInt();
					if(pin>0 && pin <9999 ) {
						flag3 = true;
						pin2=pin;
					}else {
						System.out.println("Por favor verique su pin");
					}
				}catch(Exception e) {
					System.out.println("Por favor ingrese un pin válido");
				}
			}while(!flag3);
			
			try {
				if(Cliente.isCorrect(codClie, pin2)) {
					//flag = true;
				}else {
					System.err.print("Datos incorrectos\n");
					System.out.println("---------------------------------");
				}
			}catch(Exception e2) {
				System.err.print("Ocurrió un problema al iniciar sesión");
			}
		}while(!flag);
		
		
	}
}
