
import javax.swing.*;

/**
 * 
 */

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 * @author Juan Álvarez
 */
public class Calculadora {
	//Input 

	
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
	static int selector = 0; //Selector para las opciones de JOptionPanel
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		/*
		 * Ejecutamos el programa en bucle, para que el usuario pueda meter otra 
		 * operacion sin tener que volver a ejecutar el programa
		 */
		do {
			firstDialog();
		} while(ejec); // si "ejec" es True, sigue ejecutando.
	}
	
	public static void firstDialog() {
		selector = JOptionPane.showOptionDialog( null,"Seleccione opcion",  "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
			null,new Object[] { "Operar", "Operaciones Disponibles", "Salir" }, null);
		switch(selector){
		case 0:
			escritorOperacion();
			break;
		case 1:
			listaOperaciones();
			break;
		case 2:
			ejec = false; // inicializamos ejec a False para salir de la ejecución
			break;
	}
	}
	

	
	public static void listaOperaciones() { //menú de operaciones	
		selector = JOptionPane.showOptionDialog( null,"Las operaciónes disponibles son:\n"+
				"---------------------------------\n"+
				">Suma (+)\n"+
				">Resta (-)\n"+
				">Multiplicación (*)\n"+
				">División (/)\n"+
				">Módulo (%)\n"+
				">Raiz Cuadrada (sqr)\n"+
				">Factorial (!)\n"+
				">Potencia (^)\n"+
				">Seno (SEN)\n"+
				">Coseno (COS)\n"+
				">Tangente (TAN)\n"+
				">Arcoseno (ARCSEN)\n"+
				">Arcocoseno (ARCOS)\n"+
				">Mayor número (>)\n"+
				">Menor número (<)\n",  "Lista de Operaciones",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,new Object[] { "Operar","Volver al menú","Más ayuda" }, null);
		switch(selector){
		case 0:
			escritorOperacion();
			break;
		case 1:
			firstDialog();
			break;
		case 2:
			Ayuda();
			break;
	}
		
	}
	
	public static void Ayuda() {	//menú de ayuda	
		selector = JOptionPane.showOptionDialog( null,"Ayuda sobre el uso de las operaciónes:\n"+
				"---------------------------------------\n"+
				"*Suma (A+B= Suma A más B)\n"+
				"*Resta (A-B= Resta A menos B)\n"+
				"*Multiplicación (A*B= Multiplicación A por B)\n"+
				"*División (A/B= División A entre B)\n"+
				"*Módulo (A%B= Módulo de A sobre B)\n"+
				"*Raiz Cuadrada (A sqr= raiz cuadrada de A)\n"+
				"*Factorial (!A = Multiplicación de todos los números hasta A)\n"+
				"*Potencia (A^B = Resultado de A elevado a B)\n"+
				"*Seno (A SEN = Seno de A  )\n"+
				"*Coseno (A COS = Coseno de A)\n"+
				"*Tangente (A TAN = Tangente de A)\n"+
				"*Arcoseno (A ARCSEN = Arcseno de A)\n"+
				"*Arcocoseno (A ARCOS = Arcoseno de A)\n"+
				"*Mayor número (A>B = mayor número entre A y B)\n"+
				"*Menor número (A<B = menor número entre A y B)",  "Uso de Operaciones",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,new Object[] { "Operar","Volver al menú"}, null);
		switch(selector){
		case 0:
			escritorOperacion();
			break;
		case 1:
			firstDialog();
			break;
	}


	}
	public static void escritorOperacion() {
		op = JOptionPane.showInputDialog(null,"Introduce una operación", JOptionPane.QUESTION_MESSAGE); 
				      
		op = op.split("\r")[0];
		Operaciones();
		
		
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
			selector = JOptionPane.showOptionDialog( null,op2 +" es menor que "+op1,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
			
			
			switch(selector){
				case 0:
					escritorOperacion();
					break;
				case 1:
					escritorOperacion();
					break;
				case 2:
					firstDialog();
					break;
			}
		
			
		} else { // sino
			selector = JOptionPane.showOptionDialog( null,op1 +" es menor que "+op2,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
				
				
				switch(selector){
					case 0:
						escritorOperacion();
						break;
					case 1:
						escritorOperacion();
						break;
					case 2:
						firstDialog();
						break;
				}
			
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
			selector = JOptionPane.showOptionDialog( null,op1 +" es mayor que "+op2,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
				
				
				switch(selector){
					case 0:
						escritorOperacion();
						break;
					case 1:
						escritorOperacion();
						break;
					case 2:
						firstDialog();
						break;
				}
			
			 //en el caso de que op1 sea mayor que op2
		} else { // sino
			selector = JOptionPane.showOptionDialog( null,op2 +" es mayor que "+op1,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
				
				
				switch(selector){
					case 0:
						escritorOperacion();
						break;
					case 1:
						escritorOperacion();
						break;
					case 2:
						firstDialog();
						break;
				}
			
			 //en el caso de que op2 sea mayor que op1
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
			res = Math.acos(op2); 
			respuesta();// Realizamos le ArcCoseno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			op2 = op1;
			op1 = 0;	
			res = Math.acos(op2); 
			respuesta();// Realizamos le ArcCoseno sobre op1
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
			res = Math.asin(op2); 
			respuesta();// Realizamos le ArcSeno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			op2 = op1;
			op1 = 0;		
			res = Math.asin(op2);
			respuesta();// Realizamos le ArcSeno sobre op1
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
			res = Math.tan(op2); // realizamos la operación sobre el segundo operando
			respuesta();
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			op2 = op1;
			op1 = 0;
			res = Math.tan(op2); // realizamos la operacion sobre el primer operando
			respuesta();
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
			res = Math.cos(op2); // realizamos la operación sobre el segundo operando
			respuesta();
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			op2 = op1;
			op1 = 0;
			res = Math.cos(op2);
			respuesta();// realizamos la operacion sobre el primer operando
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
			res = Math.sin(op2);
			respuesta();// realizamos la operación sobre el segundo operando
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			op2 = op1;
			op1 = 0;
			res = Math.sin(op2);
			respuesta();// realizamos la operacion sobre el primer operando
		}
	}
	
	public static void potencia() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		res =(float)Math.pow(op1,op2);
		respuesta();
		
		
	}
	
	public static void factorial() {
		op2 = suspc(Double.toString(op2)); // sustituimos la coma por punto en el decimal si este existiera
		op1 = suspc(Double.toString(op1)); // sustituimos la coma por punto en el decimal si este existiera
		for(int a = 1 ; a<op2 ; a++) {
			if(a ==1) {
			res = op2 * (op2-1);
			op2--;
			}
			else {
			res =res*(op2-1);
			}
		}
		op2++;
		respuesta();
		
	}
	
	public static void raiz() {
		res =(float) Math.sqrt(op2);
		respuesta();
		
	}
	
	public static void modulo() {
		res = op1%op2;
		respuesta();
		
	}
	
	public static void división() {
		if(op2!=0) {
			res = op1/op2;
			respuesta();
		}
		
		else {
			selector = JOptionPane.showOptionDialog( null,"No se puede dividir entre 0",  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
					null,new Object[] {"Salir al menú" }, null);
			switch(selector){
				case 0:
					firstDialog();
					break;
			}
		
		}
	}
		
	
	
	public static void multiplicacion() {
		res = op1*op2;
		respuesta();
		
	}
	
	public static void resta() {
		res = op1-op2;
		respuesta();
	}
		
	
	public static void suma() {
		res = op1+op2;
		respuesta();
	}
		
		
	
	public static void respuesta() {
		if(op1 != 0) {
			selector = JOptionPane.showOptionDialog( null,op1+opr+op2 +"="+ res,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
		}
		else {
			selector = JOptionPane.showOptionDialog( null,opr+op2 +"="+ res,  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Operar manteniendo valor", "Salir al menú" }, null);
		}
		switch(selector){
			case 0:
				escritorOperacion();
				break;
			case 1:
				escritorOperacion();
				break;
			case 2:
				firstDialog();
				break;
		}
	
	

	}
}
