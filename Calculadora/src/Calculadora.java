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
	static Scanner inp = new Scanner(System.in).useDelimiter("\n");
	
	//Variables globales.
	static String op; //Operación 
	static double res; //resultado
	static double op1; //Primer Operando
	static double op2; //Segundo Operando
	static String opr;//Operador
	static char crctr; //Caracter cualquiera
	static String num; //Número cualquiera
	static String opArr[]; //Almacena un array con la operacion dividida en operandos
	static boolean ejec = true; // Booleano que controla la ejecución del programa
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		/*
		 * Ejecutamos el programa en bucle, para que el usuario pueda meter otra 
		 * operacion sin tener que volver a ejecutar el programa
		 */
		do {
			menu();
		} while(ejec); // si "ejec" es True, sigue ejecutando.
	}
	
	public static void menu() {
		System.out.println("**********************************************");
		System.out.println("* A -Lista Operaciones  B - Ayuda  C - salir *");
		System.out.println("*                     o                      *");
		System.out.println("*         -Introduce una operación-          *");
		System.out.println("**********************************************");
		System.out.print("> ");
		op = inp.next().toUpperCase();
		
		op = op.split("\r")[0];
		
		switch (op){
		case "A":
			ListaOperaciones();
			break;
		case "B": 
			Ayuda();
			break;
		case "C": // En el caso de que el usuario escoja la opcion "C" Salir  
			ejec = false; // inicializamos ejec a False para salir de la ejecución
			break;
		default:
			Operaciones();
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
	
	public static void Operaciones() {	//filtramos la operación recibida por el usuario
		opr = identif(); // Analizamos la operación introducida por el usuario en busca del operador.
		opArr = new String[0]; // inicializamos el Array que contendra los operadores 
		
		/*
		 * En el caso que el operador introducido por el usuario sea uno de 
		 * estos carácteres:
		 * 		('+','*' ó '^')
		 * sustituimos su cadena por su caracter aritmetico correspondiente.
		 * 
		 * De esta manera, podemos dividir la operación desde el operador, obteniendo 
		 * el primer y segundo operando (siempre y cuando se respete la sintaxis 
		 * matematica correspondiente).
		 * 
		 * En el caso de que sea cualquier otro carácter, realizamos el Split con el operador
		 * en su formato String
		 */
		switch(opr){
		case "+": // si el operador es '+'
			opArr = op.split("\\+"); // Lo sustituimos por '\\+' y dividimos la cadena
			break;
		case "*": // Si el operador es '*'
			opArr = op.split("\\*"); // Lo sustituimos por '\\*' y dividimos la cadena
			break;
		case "^": // Si el operador es '^'
			opArr = op.split("\\^"); // Lo sustituimos por '\\^' y dividimos la cadena
			break;
		default: // En cualquier otro caso
			opArr = op.split(opr); // Dividimos la cadena
			break;
		}
		
		/*
		 * Tratamiento del segundo operador
		 * 
		 * Si el Array que contiene los operadores, contiene mas de 1 operador, 
		 * significa que el operador dos existe, por lo que comprobamos su contenido,
		 * si este esta vacío, movemos '0'. 
		 */
		if (opArr.length > 1) { //Si hay mas de una variable en el array
			if (opArr[1] == "") { // evaluamos si la segunda variable contiene datos
				op2 = 0; //si no contiene datos movemos '0'
			} else { // si contiene datos
				op2 = Integer.parseInt(opArr[1]); // Movemos el valor del array 
			}
		}
		
		/*
		 * Tratamiento del Primer operador
		 *
		 * si el primer operador esta vacío, movemos '0'. 
		 */
		if (opArr[0] == "") {// Si esta vacío
			op1 = 0; // movemos '0'
		} else { // si no
			op1 = Integer.parseInt(opArr[0]); // Movemos el valor del array
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
				división();
				break;
			case "%":
			case "MOD": // si el operador es "MOD" significa que quiere calcular el módulo
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
				System.out.println("Operación " + opr + " no soportada");
		}
		
	}
	
	/**
	 * Función que sustituye el formato decimal con el separador ',' (coma), por el formato con el separador '.' (punto)
	 * @param String num //Número real con el separador ',' (coma)
	 * @return Double //Número real con el separador '.' (punto) 
	 */
	public static Double suspc(String num) {
		/*
		 * Realizamos un 'For' para recorrer el número en busca del carácter coma (',')
		 */
		for(int i = 0;i <= (num.length() - 1);i++) { // Contamos desde 0 hasta el número máximo de carácteres que contiene sumando uno cada vez
			char comma = num.charAt(i); // Recogemos el carácter actual del string
			
			if(comma == ',') { // Si el carácter actual es una coma (',')
				num = num.replace(',','.'); // Lo reemplazamos por punto
			}
		}
		return Double.parseDouble(num); // Retornamos como Double el número obtenido con el punto como separador de décimales
	}
	
	/**
	 * Identificar el tipo de operacion solicitada.
	 * @return String opr
	 */
	public static String identif(){ 
		opr = null; // inicializamos el operador a Null ya que introduciremos un dato nuevo en el 
		
		/*
		 * Recorremos la cadena introducida por el usuario caracter a caracter 
		 * en busca del operando. 
		 */
		for(int x = 0;x <= (op.length() - 1);x++) {
			crctr  = op.charAt(x); //movemos el caracter actual a la variable caracter
			
			if (crctr == ' ') { // si el caracter actual es un espacio
				opArr = op.split(Character.toString(crctr)); // hacemos un Split para separar el resto de caracteres de los espacios similares al almacenado en la variable caracter
				op = null; // movemos null a la variable operacion 
				/*
				 * Recorremos el Array resultante de la separacion del String con Split
				 */
				for(int n = 0;n <= (opArr.length - 1);n++) {
					if (op == null) { // si la variable operacion no contiene ningun caracter 
						op = opArr[n]; // movemos el primer caracter del array
					} else { // sino
						op = op + opArr[n]; // movemos el caracter del array concatenado con el intrpducido anteriormente
					}
				}
				x = -1; // inicializamos a -1 la variable contador de la lectura del String introducido por el usuario para que empieze a leer el String desde el principio, ya que esta ha cambiado habiendo quitado los espacios 
				opr = null; // Inicializamos a null la variable operador
			} else if(crctr == '+' || crctr == '-' || crctr == '*' || crctr == '/' || crctr == '>' || crctr == '<' || crctr == '^' || crctr == '%' || crctr == '!') { // Sino, si el caracter leido, corresponde con uno de los operadores matemáticos tradicionales
				opr = String.valueOf(crctr); // movemos el caracter a la variable operador
			} else { // sino
				/*
				 * recorremos los caracteres ASCII del abecedario en Mayusculas en busca de una coincidencia con el caracter encontrado en la operación solicitada por el usuario
				 */
				for (byte i = 65;i <= 90;i++) {  
					if (i == (int) crctr) { // Si Existe coincidencia
						if (opr != null) { // Si el caracter Operador no esta vacío
							opr = opr + crctr; // concatenamos el caracter con el carácter anterior de la cadena operador
						} else { // sino
							opr = Character.toString(crctr); // introducimos el caracter en la variable operador
						}
					}
				}
			}
		}
		return opr; // Retornamos el operador.
	}
	
	/**
	 * Función que indica cual de los dos numeros es menor.
	 * @param
	 */
	public static void menornum() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op1 > op2) { // si op1 es mayor que op2
			System.out.println(op2 + " es Menor que " + op1); //en el caso de que op1 sea mayor que op2
		} else { // sino
			System.out.println(op1 + " es Menor que " + op2); //en el caso de que op2 sea mayor que op1
		}
	}
	
	/**
	 * Función que indica cual de los dos numeros es mayor.
	 * @param
	 */
	public static void mayornum() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op1 > op2) { // si op1 es mayor que op2
			System.out.println(op1 + " es Mayor que " + op2); //en el caso de que op1 sea mayor que op2
		} else { // sino
			System.out.println(op2 + " es Mayor que " + op1); //en el caso de que op2 sea mayor que op1
		}
	}
	
	/**
	 * Calculo del ArcCoseno del ángulo especificado.
	 * @param
	 */
	public static void arcos() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op2 != 0) { // Si el segundo operador no esta vacio, realizamos la operacion sobre el mismo
			System.out.printf("%.2f %n", Math.acos(op2)); // Realizamos le ArcCoseno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			System.out.printf("%.2f %n", Math.acos(op1)); // Realizamos le ArcCoseno sobre op1
		} else { // sino
			System.out.println("Error: no se ha encontrado operador"); // De lo contrario, muestra error
		}
	}
	
	/**
	 * Calculo del ArcSeno del ángulo especificado.
	 * @param
	 */
	public static void arcseno() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op2 != 0) { // Si el segundo operador no esta vacio, realizamos la operacion sobre el mismo
			System.out.printf("%.2f %n", Math.asin(op2)); // Realizamos le ArcSeno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			System.out.printf("%.2f %n", Math.asin(op1)); // Realizamos le ArcSeno sobre op1
		} else { // sino
			System.out.println("Error: no se ha encontrado operador"); // De lo contrario, muestra error
		}
	}
	
	/**
	 * Calculo de la tangente del ángulo especificado.
	 * @param
	 */
	public static void tangente() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op2 != 0) { // si el operador 2 es distinto de 0
			System.out.printf("%.2f %n", Math.tan(op2)); // realizamos la operación sobre el segundo operando
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			System.out.printf("%.2f %n", Math.tan(op1)); // realizamos la operacion sobre el primer operando
		}
	}
	
	/**
	 * Calculo del Coseno del ángulo especificado en radianes.
	 * @param
	 */
	public static void coseno() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op2 != 0) { // si el operador 2 es distinto de 0
			System.out.printf("%.2f %n", Math.cos(op2)); // realizamos la operación sobre el segundo operando
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			System.out.printf("%.2f %n", Math.cos(op1)); // realizamos la operacion sobre el primer operando
		}
	}
	
	/**
	 * Calculo del Seno del ángulo especificado en radianes.
	 * @param
	 */
	public static void seno() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		if (op2 != 0) { // si el operador 2 es distinto de 0
			System.out.printf("%.2f %n", Math.sin(op2)); // realizamos la operación sobre el segundo operando
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			System.out.printf("%.2f %n", Math.sin(op1)); // realizamos la operacion sobre el primer operando
		}
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
	
	public static void división() {
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
