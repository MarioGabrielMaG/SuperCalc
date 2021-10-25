import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 * @author Juan �lvarez
 */
public class Calculadora {
	//Input 
	static Scanner inp = new Scanner(System.in);
	
	//Variables globales.
	static String op; //Operaci�n 
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
		System.out.println("*    -Introduce una operaci�n-    *");
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
	
	public static void ListaOperaciones() { //men� de operaciones	
		System.out.println("");
		System.out.println("");
		System.out.println("Las operaci�nes disponibles son:");
		System.out.println("---------------------------------");
		System.out.println("*Suma (+)");
		System.out.println("*Resta (-)");
		System.out.println("*Multiplicaci�n (*)");
		System.out.println("*Divisi�n (/)");
		System.out.println("*M�dulo (%)");
		System.out.println("*Raiz Cuadrada (sqr)");
		System.out.println("*Factorial (!)");
		System.out.println("*Potencia (^)");
		System.out.println("*Seno (SEN)");
		System.out.println("*Coseno (COS)");
		System.out.println("*Tangente (TAN)");
		System.out.println("*Arcoseno (ARCSEN)");
		System.out.println("*Arcocoseno (ARCOS)");
		System.out.println("*Mayor n�mero (>)");
		System.out.println("*Menor n�mero (<)");
		System.out.println("");
		System.out.println("");
		System.out.println("*Para m�s informaci�n sobre la sintaxis y uso de las operaci�nes dirijas� al men� de ayuda*");	
	}
	
	public static void Ayuda() {	//men� de ayuda	
		System.out.println("");
		System.out.println("");
		System.out.println("Ayuda sobre el uso de las operaci�nes:");
		System.out.println("---------------------------------------");
		System.out.println("*Suma (A+B= Suma A m�s B)");
		System.out.println("*Resta (A-B= Resta A menos B)");
		System.out.println("*Multiplicaci�n (A*B= Multiplicaci�n A por B)");
		System.out.println("*Divisi�n (A/B= Divisi�n A entre B)");
		System.out.println("*M�dulo (A%B= M�dulo de A sobre B)");
		System.out.println("*Raiz Cuadrada (A sqr= raiz cuadrada de A)");
		System.out.println("*Factorial (!A = Multiplicaci�n de todos los n�meros hasta A)");
		System.out.println("*Potencia (A^B = Resultado de A elevado a B)");
		System.out.println("*Seno (A SEN = Seno de A  )");
		System.out.println("*Coseno (A COS = Coseno de A)");
		System.out.println("*Tangente (A TAN = Tangente de A)");
		System.out.println("*Arcoseno (A ARCSEN = Arcseno de A)");
		System.out.println("*Arcocoseno (A ARCOS = Arcoseno de A)");
		System.out.println("*Mayor n�mero (A>B = mayor n�mero entre A y B)");
		System.out.println("*Menor n�mero (A<B = menor n�mero entre A y B)");
		System.out.println("");
		System.out.println("");
		System.out.println("*Vuelva al men� para operar*");	
	}
	
	public static void Operaciones(String op) {	//filtramos la operaci�n recibida por el usuario
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
				divisi�n();
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
				System.out.println("Operaci�n " + opr + " no soportada");
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
	
	public static void divisi�n() {
		
		
	}
	
	public static void multiplicacion() {
		
		
	}
	
	public static void resta() {
		
		
	}
	public static void suma() {
		
		
		
	}
	

}
