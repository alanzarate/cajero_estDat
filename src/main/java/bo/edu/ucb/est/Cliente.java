
package bo.edu.ucb.est;

import java.util.Scanner;

public class Cliente {
    private String nombre;
	private String codCliente;
	private int pinSeg;
	
	public Cliente(String name, String cod, int pin) {
		this.nombre = name;
		this.codCliente = cod;
		this.pinSeg = pin;
	}
	public void setPin(int pin) {
		this.pinSeg = pin;
	}
	public void setcodClie(String cod) {
		this.codCliente = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCodClie() {
		return codCliente;
	}
	public int getPinSeg() {
		return pinSeg;
	}
	public void searchName() {
		
	}
	private static Cliente[] cl = {new Cliente("Juan Perez","jperez",3333), new Cliente("Maria Gomez","mgomez",4444), 
			new Cliente("Juan Perez","jperez2", 5555)};
	
	public static boolean isCorrect(String cod1, int pin1) {
		boolean f=false;
		for(int i = 0; i<cl.length;i++) {
			if(cl[i].getCodClie().equals(cod1) && cl[i].getPinSeg() == pin1) {
				f=true;
				iniciarMenu(cl[i]);
			}
		}
		return f;
	}
	public static void iniciarMenu(Cliente cc) {
		boolean flag= false;
		
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Ver saldo\n2. Retirar dinero\n3. Depositar dinero\n4. Salir\n--------------------------------\n");
			
			int op=0;
			try {
				op=sc.nextInt();
				if( op>=1 && op<=4 ) {
					Cuenta cuenta = new Cuenta(cc.getCodClie(), 0, null, null, 0);
					if(op==4) {
						flag=true;
					}else{
						cuenta.eleccionOperacion(op);
					}
					
				}else {
					System.out.println("Por favor introduzca un valor permitido\n");
				}
			}catch(Exception e) {
				System.out.println("Por favor introduzca un número valido");
			}
			
		}while(!flag);
	}
}
