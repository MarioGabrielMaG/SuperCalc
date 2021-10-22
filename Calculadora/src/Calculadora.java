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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println("");
		System.out.println(" 1 - Operaciones  2 - Ayuda ");
		System.out.println("");
		op = inp.next();
		System.out.print(op);
	}

}
