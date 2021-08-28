

package bo.edu.ucb.est;

import java.util.ArrayList;
import java.util.Scanner;


public class Cuenta {
    private String codCliente;
	private long cuenta;
	private String moneda;
	private String tipo;
	private double saldo;
	static ArrayList<Cuenta> cuentasCom = new ArrayList<Cuenta>();
	
	public Cuenta(String codCliente, long cuenta, String moneda, String tipo, double saldo) {
		super();
		this.codCliente = codCliente;
		this.cuenta = cuenta;
		this.moneda = moneda;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public long getCuenta() {
		return cuenta;
	}
	public void setCuenta(long cuenta) {
		this.cuenta = cuenta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static Cuenta[] cuentas = {new Cuenta("jperez", 111122, "Bolivianos", "Caja de Ahorros", 12000),
										   new Cuenta("jperez", 112211, "USD", "Cuenta Corriente",100),
										   new Cuenta("mgomez", 221122, "Bolivianos", "Caja de Ahorros", 0),
										   new Cuenta("jperez2", 331122,"Bolivianos", "Caja de Ahorros", 100),
										   new Cuenta("jperez2", 332211, "USD", "Cuenta Corriente", 1000),
										   new Cuenta("jperez2", 332233, "Bolivianos", "Caja de Ahorros", 100000) };
	public void verSaldo(int opcionSe) {
		Cuenta n1 = cuentasCom.get(opcionSe-1);
		System.out.println("-------------Cta. "+n1.getCuenta()+"-------------------\nEl saldo actual es: "+ n1.getSaldo()+""
				+ "\nMoneda: "+n1.getMoneda()+"\tTipo Cta. "+n1.getTipo()+"\n----------------------------------------");
	}
	public boolean retirar(int opcionSe) {
		boolean flag2 = false;
		Cuenta n1 = cuentasCom.get(opcionSe-1);
		verSaldo(opcionSe);
		if(n1.getSaldo()==0) {
			System.err.print("USTED NO PUEDE REALIZAR RETIROS");
			flag2=true;
		}else {
			System.out.println("Cuanto desea Retirar?");
			Scanner sc2= new Scanner(System.in);
			try {
				long i=sc2.nextLong();
				if(i>0 && i<=n1.getSaldo()) {
					n1.setSaldo(n1.getSaldo()-i);
					flag2=true;
					System.out.println(ANSI_GREEN+"Retiro exitoso\n"+ANSI_RESET);
					System.out.println("Saldo Actual: \t"+n1.getSaldo()+"\n---------------------------------------------");
				}else {
					System.err.print("Monto NO permitido !!");
				}
			}catch(Exception e) {
				System.out.println(ANSI_YELLOW+"Por favor introduzca un valor permitido"+ANSI_RESET);
			}
		}
		
		
		return flag2;
	}
	public boolean depositar(int opcionSe) {
		boolean flag2=false;
		Cuenta n1 = cuentasCom.get(opcionSe-1);
		verSaldo(opcionSe);
		System.out.println("Cuanto desea Depositar?");
		
		Scanner sc2= new Scanner(System.in);
		try {
			long i=sc2.nextLong();
			if(i>0) {
				n1.setSaldo(n1.getSaldo()+i);
				flag2=true;
				System.out.println(ANSI_GREEN+"Deposito exitoso :)"+ANSI_RESET);
				System.out.println("\nSaldo Actual: \t"+n1.getSaldo()+"\n---------------------------------------------");
			}else {
				System.err.print("Monto NO permitido !!");
			}
		}catch(Exception e) {
			System.out.println(ANSI_YELLOW+"Por favor introduzca un valor permitido"+ANSI_RESET);
		}
		
		return flag2;
	}
	public void mostrarCuentas() {
		cuentasCom.clear();
		System.out.println("Elige una cuenta");
		
		for(int x=0 ; x<cuentas.length; x++) {
			
			if(this.getCodCliente().equals(cuentas[x].getCodCliente())) {
				cuentasCom.add(cuentas[x]);
				System.out.println((cuentasCom.size())+".\t"+cuentas[x].getCuenta());
				
			}
		}
		System.out.println((cuentasCom.size()+1)+".\tVolver\n-----------------------------------------\n");		
	}
	
	public void eleccionOperacion(int elecion) {
		boolean flag1 =false;
		do {
			mostrarCuentas();
			Scanner sc = new Scanner(System.in);
			try {
				int opcionSe = sc.nextInt();
				if(opcionSe>0 && opcionSe < cuentasCom.size()+2) {
					if(opcionSe == cuentasCom.size()+1) {
						flag1=true;
					}else {
						boolean flag2=false;
						do {
							
							switch (elecion) {
								case 1:
									verSaldo(opcionSe);
									flag2=true;
									flag1=true;
									break;
								case 2:
									flag2=retirar(opcionSe);
									if(flag2) flag1=true;
									break;
								case 3:
									flag2=depositar(opcionSe);
									if(flag2) flag1=true;
									break;
							}
						}while(!flag2);
						
						
					}
				}else {
					System.out.println("Por favor introduzca una opción válida");
				}
			}catch(Exception e) {
				System.out.println("Por favor introduzca una opción válida");
			}
		}while(!flag1);
	}
}
