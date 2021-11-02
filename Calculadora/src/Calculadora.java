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
	static Scanner inp = new Scanner(System.in).useDelimiter("\n");
	
	//Variables globales.
	static String op; //Operaci�n 
	static float res; //resultado
	static float op1; //Primer Operando
	static float op2; //Segundo Operando
	static String opr;//Operador
	static char crctr; //Caracter cualquiera
	static String num; //N�mero cualquiera
	static String opArr[]; //Almacena un array con la operacion dividida en operandos
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		menu();
	}
	
	public static void menu() {
		System.out.println("***********************************");
		System.out.println("* A -Lista Operaciones  B - Ayuda *");
		System.out.println("*                o                *");
		System.out.println("*    -Introduce una operaci�n-    *");
		System.out.println("***********************************");
		System.out.print("> ");
		op = inp.next().toUpperCase();
		
		switch (op){
		case "A":
			ListaOperaciones();
			break;
		case "B": 
			Ayuda();
			break;
		default:
			Operaciones();
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
	
	public static void Operaciones() {	//filtramos la operaci�n recibida por el usuario
		opr = identif();
		opArr = new String[0];
		
		op = op.split("\r")[0];
		
		switch(opr){
		case "+": 
			opArr = op.split("\\+");
			break;
		case "*": 
			opArr = op.split("\\*");
			break;
		case "^": 
			opArr = op.split("\\^");
			break;
		default:
			opArr = op.split(opr);
			break;
		}
		
		if (opArr.length > 1) {
			if (opArr[1] == "") {
				op2 = 0;
			} else {
				op2 = Integer.parseInt(opArr[1]);
			}
		}
		
		if (opArr[0] == "") {
			op1 = 0;
		} else {
			op1 = Integer.parseInt(opArr[0]);
		}
		
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
			case "MOD":
				modulo();
				break;
			case "SQRT":
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
	
	
	/**
	 * Identificar el tipo de operacion solicitada
	 * @return String opr
	 */
	public static String identif(){ 
		opr = null;
		for(int x = 0;x <= (op.length() - 1);x++) {
			crctr  = op.charAt(x);
			
			if (crctr == ' ') {
				opArr = op.split(Character.toString(crctr));
				op = null;
				for(int n = 0;n <= (opArr.length - 1);n++) {
					if (op == null) {
						op = opArr[n];
					} else {
						op = op + opArr[n];
					}
				}
				x = -1;
				opr = null;
			} else if(crctr == '+' || crctr == '-' || crctr == '*' || crctr == '/' || crctr == '>' || crctr == '<' || crctr == '^' || crctr == '%' || crctr == '!') {
				opr = String.valueOf(crctr);
			} else {
				for (byte i = 65;i <= 90;i++) {
					if (i == (int) crctr) {
						if (opr != null) {
							opr = opr + crctr;
						} else {
							opr = Character.toString(crctr);
						}
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
	
	/**
	 * Calculo del arcoseno del �ngulo especificado.
	 * @param
	 */
	public static void arcseno() {
		
		
	}
	
	/**
	 * Calculo de la tangente del �ngulo especificado.
	 * @param
	 */
	public static void tangente() {
		if (op2 != 0) {
			System.out.printf("%.2f %n", Math.tan(op2));
		} else if (op1 != 0) {
			System.out.printf("%.2f %n", Math.tan(op1));
		}
	}
	
	/**
	 * Calculo del Coseno del �ngulo especificado en radianes.
	 * @param
	 */
	public static void coseno() {
		if (op2 != 0) {
			System.out.printf("%.2f %n", Math.cos(op2));
		} else if (op1 != 0) {
			System.out.printf("%.2f %n", Math.cos(op1));
		}
	}
	
	/**
	 * Calculo del Seno del �ngulo especificado en radianes.
	 * @param
	 */
	public static void seno() {
		if (op2 != 0) {
			System.out.printf("%.2f %n", Math.sin(op2));
		} else if (op1 != 0) {
			System.out.printf("%.2f %n", Math.sin(op1));
		}
		menu();
	}
	
	public static void potencia() {
		res =(float)Math.pow(op1,op2);
		System.out.print(res+" ");
		menu();
		
	}
	
	public static void factorial() {
	
		for(int a = 1 ; a<op2 ; a++) {
			if(a ==1) {
			res = op2 * (op2-1);
			op2--;
			}
			else {
			res =res*(op2-1);
			}
		}
		System.out.print(res+" ");
		menu();
		
	}
	
	public static void raiz() {
		res =(float) Math.sqrt(op2);
		System.out.print(res+" ");
		menu();
		
	}
	
	public static void modulo() {
		res = op1%op2;
		System.out.print(res+" ");
		menu();
		
	}
	
	public static void divisi�n() {
		if(op2!=0) {
			res = op1/op2;
			System.out.print(res+" ");
		}
		else {
			System.out.println("Error, el divisor no puede ser 0");
		}
		menu();
	}
		
	
	
	public static void multiplicacion() {
		res = op1*op2;
		System.out.print(res+" ");
		menu();
		
	}
	
	public static void resta() {
		res = op1-op2;
		System.out.print(res+" ");
		menu();
		
	}
	public static void suma() {
		res = op1+op2;
		System.out.print(res+" ");
		menu();
		
		
		
	}
	

}
