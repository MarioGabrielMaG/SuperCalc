import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 * @author Juan Álvarez
 */
public class Calculadora {
	//Input 
	static Scanner inp = new Scanner(System.in);
	
	//Variables globales.
	static String op; //Operación 
	static float res; //resultado
	static float op1; //Primer Operando
	static float op2; //Segundo Operando
	static String opr;//Operador
	static char crctr; //Caracter cualquiera
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println("***********************************");
		System.out.println("* A -Lista Operaciones  B - Ayuda *");
		System.out.println("*                o                *");
		System.out.println("*    -Introduce una operación-    *");
		System.out.println("***********************************");
		op = inp.next();
		
		switch (op.toUpperCase()){
		case "A":
			ListaOperaciones();
			break;
		case "B": 
			Ayuda();
			break;
		default:
			Operaciones(op);
		}
		
	}
	
	public static void ListaOperaciones() { //menú de operaciones	
		System.out.println("");
		System.out.println("");
		System.out.println("Las operaciónes disponibles son:");
		System.out.println("---------------------------------");
		System.out.println("*Suma (+)");
		System.out.println("*Resta (-)");
		System.out.println("*Multiplicación (*)");
		System.out.println("*División (/)");
		System.out.println("*Módulo (%)");
		System.out.println("*Raiz Cuadrada (sqr)");
		System.out.println("*Factorial (!)");
		System.out.println("*Potencia (^)");
		System.out.println("*Seno (SEN)");
		System.out.println("*Coseno (COS)");
		System.out.println("*Tangente (TAN)");
		System.out.println("*Arcoseno (ARCSEN)");
		System.out.println("*Arcocoseno (ARCOS)");
		System.out.println("*Mayor número (>)");
		System.out.println("*Menor número (<)");
		System.out.println("");
		System.out.println("");
		System.out.println("*Para más información sobre la sintaxis y uso de las operaciónes dirijasé al menú de ayuda*");	
	}
	
	public static void Ayuda() {	//menú de ayuda	
		System.out.println("");
		System.out.println("");
		System.out.println("Ayuda sobre el uso de las operaciónes:");
		System.out.println("---------------------------------------");
		System.out.println("*Suma (A+B= Suma A más B)");
		System.out.println("*Resta (A-B= Resta A menos B)");
		System.out.println("*Multiplicación (A*B= Multiplicación A por B)");
		System.out.println("*División (A/B= División A entre B)");
		System.out.println("*Módulo (A%B= Módulo de A sobre B)");
		System.out.println("*Raiz Cuadrada (A sqr= raiz cuadrada de A)");
		System.out.println("*Factorial (!A = Multiplicación de todos los números hasta A)");
		System.out.println("*Potencia (A^B = Resultado de A elevado a B)");
		System.out.println("*Seno (A SEN = Seno de A  )");
		System.out.println("*Coseno (A COS = Coseno de A)");
		System.out.println("*Tangente (A TAN = Tangente de A)");
		System.out.println("*Arcoseno (A ARCSEN = Arcseno de A)");
		System.out.println("*Arcocoseno (A ARCOS = Arcoseno de A)");
		System.out.println("*Mayor número (A>B = mayor número entre A y B)");
		System.out.println("*Menor número (A<B = menor número entre A y B)");
		System.out.println("");
		System.out.println("");
		System.out.println("*Vuelva al menú para operar*");	
	}
	
	public static void Operaciones(String op) {	//filtramos la operación recibida por el usuario
		identif(op);
		
		switch (opr) {
			case "+":
				suma();
				break;
			case "-":
				resta();
				break;
			case "*":
				multiplicacion();
				break;
			case "/":
				división();
				break;
			case "%":
			case "mod":
			case "||":
				modulo();
				break;
			case "sqrt":
				raiz();
				break;
			case "!":
				factorial();
				break;
			case "^":
				potencia();
				break;
			case "SEN":
				seno();
				break;
			case "COS":
				coseno();
				break;
			case "TAN":
				tangente();
				break;
			case "ARCSEN":
				arcseno();
				break;
			case "ARCOS":
				arcos();
				break;
			case ">":
				mayornum();
				break;
			case "<":
				menornum();
				break;
			default:
				System.out.println("Operación " + opr + " no soportada");
		}
		
	}
	
	/*
	 * Identificamos el tipo de operacion solicitada
	 */
	public static String identif(String op){ 
		for(int x = 0;x <= op.length();x++) {
			crctr  = op.charAt(x);	
			if(crctr == '+' || crctr == '-' || crctr == '*' || crctr == '/' || crctr == '>' || crctr == '<' || crctr == '^' || crctr == '%' || crctr == '!') {
				opr = String.valueOf(crctr);
			} else {
				for (byte i = 0;i < 10;i++) {
					if (crctr != i) {
						
					}
				}
			}
		}
		return opr;
	}
	
	public static void menornum() {
		
		
	}
	
	public static void mayornum() {
		
		
	}
	
	public static void arcos() {
		
		
	}
	
	public static void arcseno() {
		
		
	}
	
	public static void tangente() {
		
		
	}
	
	public static void coseno() {
		
		
	}
	
	public static void seno() {
		
		
	}
	
	public static void potencia() {
		
		
	}
	
	public static void factorial() {
		
		
	}
	
	public static void raiz() {
		
		
	}
	
	public static void modulo() {
		
		
	}
	
	public static void división() {
		
		
	}
	
	public static void multiplicacion() {
		
		
	}
	
	public static void resta() {
		
		
	}
	public static void suma() {
		
		
		
	}
	

}
