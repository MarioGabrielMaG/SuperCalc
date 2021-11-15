import java.text.DecimalFormat;
import javax.swing.*;

/**
 * 
 */

/**
 * La clase "Calculadora" contiene las funciones necesarias para 
 * el correcto funcionamiento del programa realizado para
 * la práctica por parejas requerida para la evaluación 
 * de la asignatura "Programación" en primer trimestre de Desarrollo de 
 * Aplicaciones Multiplataforma.
 * 
 * Enunciado de la práctica: [https://sway.office.com/MgXv1dUBEET0Vn5z?ref=Link]
 * 
 * Los ficheros del proyecto generados por Eclipse, se encuentran en el 
 * repositorio de GitHub [https://github.com/MarioGabrielMaG/SuperCalc/].
 * 
 * Esta clase está pensada para usarla en su totalidad, las funciones aqui desarrolladas
 * son privadas y no podrán ser llamadas desde otras clases externas.
 * 
 * @author Mario Gabriel Núñez Alcázar de Velasco
 * @author Juan Álvarez
 * 
 */
public class Calculadora {
	/**
	 * Variable Global que contendrá en todo momento, y sobre la que se tratará,
	 * la cadena de caracterés introducida por el usuario correspondiente a la operación
	 * a realizar.
	 * 
	 * La sintaxis de cada operación se puede encontrar en el propio programa a través de
	 * las opciones de menú "Operaciones disponibles" >> "Mas Ayuda".
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} String - Wrapper
	 */
	private static String op;
	
	/**
	 * Resultado de la operación realizada; Inicializada a zeros.
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa.
	 * 
	 * {@systemProperty Type} double - Primitive
	 */
	private static double res = 0.0;
	
	/**
	 * Primer operando introducido por el usuario; inicializada a zeros.
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} double - Primitive
	 */
	private static double op1 = 0.0;
	
	/**
	 * Segundo operando introducido por el usuario; inicializada a zeros
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} double - Primitive
	 */
	private static double op2 = 0.0;
	
	/**
	 * Operador introducido por el usuario.
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} String - Wrapper
	 */
	private static String opr;
	
	/**
	 * Variable destinada a la lectura de los carácteres uno a uno para la identificación del
	 * tipo de operacion solicitada
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} char - Primitive
	 */
	private static char crctr;
	
	/**
	 * Array diseñada para el almacenamiento de la operación divida en operandos.
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} String[] - Wrapper Array
	 */
	private static String opArr[];
	
	/**
	 * Variable booleana diseñada para controlar la ejecución del programa; 
	 * inicializada con valor "True"
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} boolean - Primitive
	 */
	private static boolean ejec = true;
	
	/**
	 * Variable diseñada para funcionar como selector para las opciones de java.swing.JOptionPanel();
	 * inicializado a zeros
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} int - Primitive
	 */
	private static int selector = 0;
	
	/**
	 * Variable diseñada para actuar de Malla para el formateo de los decimales en la impresión
	 * en pantalla con java.swing; incializado con la malla "#.#####", está actuara como malla
	 * por defecto.
	 * 
	 * Esta variable se trata de forma interna por lo que es de caracter privado impidiendo
	 * la llamada a las mismas a través de una clase externa. 
	 * 
	 * {@systemProperty Type} DecimalFormat - Wrapper - java.text.DecimalFormat
	 */
	private static DecimalFormat frmt = new DecimalFormat("#.#####");
	
	/**
	 * Función primaria del programa, este contiene las lineas imprescindibles para
	 * la correcta ejecución del mismo.
	 * 
	 * Esta función es la primera en ejecutarse.
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {	
		/*
		 * Ejecutamos el programa en bucle, para que el usuario pueda meter otra 
		 * operacion sin tener que volver a ejecutar el programa
		 */
		do {
			firstDialog(); // llamamos a la función que mostrará el primer menú
		} while(ejec); // si "ejec" es True, sigue ejecutando.
	}
	
	/**
	 * Menú principal. este mostrará una ventana de tipo input con tres opciones:
	 * 
	 * 	> Operar -> Valor Selector '0' --> llamará a la funcion escritorOperacion();
	 * 	> Operaciones disponibles -> Valor Selector '1' --> llamará a la función listaOperaciones();
	 * 	> Salir -> Valor Selector '2' --> Finalizará la ejecución del programa.
	 */
	private static void firstDialog() {
		/*
		 * Ventana tipo Mensaje que mostrará tres botones, uno para cada seleccion, retornando
		 * su correspondiente selector
		 */
		selector = JOptionPane.showOptionDialog( null,
												"Seleccione opcion", // Mensaje situado en la caja de texto
												"Selector de opciones", // Título de la ventana
												JOptionPane.YES_NO_CANCEL_OPTION, // Tipo de selector 
												JOptionPane.QUESTION_MESSAGE, // Tipo de Mensaje
												null,
												/*
												 * Opciones del menú, el indice del Array Object[] actuará de selector; este es el valor que se retornará a la variable "selector"
												 */
												new Object[] { "Operar", // Boton "Operar" 
															   "Operaciones disponibles", // Boton "Operaciones disponibles" 
															   "Salir" // Botón "Salir"
															 }, 
												null);
		
		/*
		 * Evaluamos el valor retornado "selector"
		 */
		switch(selector){
			case 0: // En el caso de que sea "0", significa que el usuario a pulsado la opcion "Operar"
				escritorOperacion(); // llamamos a la función escritorOperación();
				break;
			case 1: // En el caso de que sea "1", significa que el usuario a pulsado la opcion "Operaciones disponibles" 
				listaOperaciones(); // llamamos a la función listaOperaciones(); 
				break;
			case 2: // En el caso de que sea "0", significa que el usuario a pulsado la opcion Salis
				ejec = false; // Inicializamos "ejec" a "False" para salir de la ejecución
				break;
		}
	}
	
	/**
	 * Lista de Operaciones, sistema de ayuda. este mostrará una ventana de tipo input con una 
	 * lista de las operaciones que realiza el programa y tres opciones de selección:
	 * 
	 * 	> Operar -> Valor Selector '0' --> llamará a la funcion escritorOperacion();
	 * 	> Volver al menú -> Valor Selector '1' --> llamará a la función firstDialog();
	 * 	> Más ayuda -> Valor Selector '2' --> llamará a la funcion ayuda()
	 */
	private static void listaOperaciones() {
		/*
		 * Ventana tipo mensaje que mostrará tres botones, uno para cada seleccion, retornando
		 * su correspondiente selector
		 */
		selector = JOptionPane.showOptionDialog(null,
												"Las operaciónes disponibles son:\n" +  // Cadena de texto con el mensaje que contendra la ventana. 
												"---------------------------------\n"+  // "							"						"
												"> Suma (+)\n"+							// "							"						"				
												"> Resta (-)\n"+						// "							"						"
												"> Multiplicación (*)\n"+				// "							"						"
												"> División (/)\n"+						// "							"						"
												"> Módulo (%)\n"+						// "							"						"
												"> Raiz Cuadrada (sqr)\n"+				// "							"						"
												"> Factorial (!)\n"+					// "							"						"
												"> Potencia (^)\n"+						// "							"						"
												"> Seno (SEN)\n"+						// "							"						"
												"> Coseno (COS)\n"+						// "							"						"
												"> Tangente (TAN)\n"+					// "							"						"
												"> Arcoseno (ARCSEN)\n"+				// "							"						"
												"> Arcocoseno (ARCOS)\n"+				// "							"						"
												"> Mayor número (>)\n"+					// "							"						"
												"> Menor número (<)\n",					// "							"						"
												"Lista de operaciones",	// Título de la ventana
												JOptionPane.YES_NO_CANCEL_OPTION, // Tipo de selector 
												JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje 
												null,
												/*
												 * Opciones del menú, el indice del Array Object[] actuará de selector; este es el valor que se retornará a la variable "selector"
												 */
												new Object[] { "Operar", // Botón "Operar" 
															   "Volver al menú", // Botón "Volver al menú"
															   "Más ayuda" // Botón "Mas Ayuda"
															 }, 
												null);
		/*
		 * Evaluamos el valor retornado "selector"
		 */
		switch(selector){
			case 0: // En el caso de que sea "0", significa que el usuario a pulsado la opcion "Operar"
				escritorOperacion(); // llamamos a la función escritorOperación();
				break;
			case 1: // En el caso de que sea "1", significa que el usuario a pulsado la opcion "Volver al menú"
				firstDialog(); // llamamos a la función firstDialog();
				break;
			case 2: // En el caso de que sea "2", significa que el usuario a pulsado la opcion "Más ayuda"
				ayuda(); // llamamos a la función ayuda();
				break;
		}
		
	}
	
	/**
	 * Sintaxis de las operaciones, sistema de ayuda. este mostrará una ventana de tipo input con una 
	 * lista de la sintaxis correspondiente a laca operación que realiza el programa y dos opciones de selección:
	 * 
	 * 	> Operar -> Valor Selector '0' --> llamará a la funcion escritorOperacion();
	 * 	> Volver al menú -> Valor Selector '1' --> llamará a la función firstDialog();
	 */
	private static void ayuda() {
		selector = JOptionPane.showOptionDialog( null,
												"Ayuda sobre el uso de las operaciones:\n" +								// Cadena de texto con el mensaje que contendra la ventana.
												"---------------------------------------\n" +								// "							"						"
												"> Suma: [A] + [B] = [Suma A más B]\n" +									// "							"						"
												"> Resta: [A] - [B] = [Resta A menos B]\n" +								// "							"						"
												"> Multiplicación: [A] * [B] = [Multiplicación A por B]\n" +				// "							"						"
												"> División: [A] / [B] = [División A entre B]\n" +							// "							"						"
												"> Módulo: [A] [% / MOD] [B] = [Módulo de A sobre B]\n" +					// "							"						"
												"> Raiz Cuadrada: [A] SQR = [raiz cuadrada de A]\n" +						// "							"						"
												"> Factorial: ![A] = [Multiplicación de todos los números hasta A]\n" +		// "							"						"
												"> Potencia: [A] ^ [B] = [Resultado de A elevado a B]\n" +					// "							"						"
												"> Seno: [A] SEN = [Seno de A]\n" +											// "							"						"
												"> Coseno (Radianes): [A] COS = [Coseno de A]\n" +										// "							"						"
												"> Tangente (Radianes): [A] TAN = [Tangente de A]\n" +									// "							"						"
												"> Arcoseno (Radianes): [A] ARCSEN = [Arcseno de A]\n" +								// "							"						"
												"> Arcocoseno (Radianes): [A] ARCOS = [Arcoseno de A]\n" +								// "							"						"
												"> Mayor número: [A] > [B] = [mayor número entre A y B]\n" +				// "							"						"
												"> Menor número [A] < [B] = [menor número entre A y B]", 					// "							"						"
												"Uso de operaciones", // Título de la ventana
												JOptionPane.YES_NO_CANCEL_OPTION, // Tipo de selector
												JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje
												null,
												/*
												 * Opciones del menú, el indice del Array Object[] actuará de selector; este es el valor que se retornará a la variable "selector"
												 */
												new Object[] {"Operar", // Botón "Operar" 
														   	  "Volver al menú", // Botón "Volver al menú"
														     }, 
												null);
		/*
		 * Evaluamos el valor retornado "selector"
		 */
		switch(selector){
			case 0: // En el caso de que sea "0", significa que el usuario a pulsado la opcion "Operar"
				escritorOperacion(); // llamamos a la función escritorOperación();
				break;
			case 1: // En el caso de que sea "1", significa que el usuario a pulsado la opcion "Volver al menú"
				firstDialog(); // llamamos a la función firstDialog();
				break;
		}

	}
	
	/*
	 * función que muestra un input para que el usuario pueda introducir la operación
	 */
	private static void escritorOperacion() {
		op = JOptionPane.showInputDialog(null,"Introduce una operación", JOptionPane.QUESTION_MESSAGE).toUpperCase();       
		operaciones();
	}
	
	/*
	 * Funcion que identifica el tipo de operando introducido por el usuario en la operación 
	 */
	private static void operaciones() {	// filtramos la operación recibida por el usuario
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
		 * si este esta vacío, movemos '0', a su vez, si el operador dos no existe, 
		 * movemos '0' 
		 */
		if (opArr.length > 1) { //Si hay mas de una variable en el array
			if (opArr[1] == "") { // evaluamos si la segunda variable contiene datos
				op2 = 0; //si no contiene datos movemos '0'
			} else { // si contiene datos
				op2 = suspc(opArr[1]); // Movemos el valor del array 
			}
		} else { // Si no
			op2 = 0; // Movemos '0'
		}
		
		/*
		 * Tratamiento del Primer operador
		 *
		 * si el primer operador esta vacío, movemos '0'. 
		 */
		if (opArr[0] == "") {// Si esta vacío
			op1 = 0; // movemos '0'
		} else { // si no
			op1 = suspc(opArr[0]); // Movemos el valor del array
		}
		
		/*
		 * Switch diseñado paera deribar a una operacion u otra dependiendo el operando introducido
		 */
		switch (opr) {
			case "+": // para suma, llamamos a suma();
				suma();
				break;
			case "-": // para resta, llamamos a resta();
				resta();
				break;
			case "*": // para multiplicación, llamamos a multioplicación();
				multiplicacion();
				break;
			case "/": // para división, llamamos a división();
				división();
				break;
			case "%": // para modulo, llamamos a modulo();
			case "MOD": // si el operador es "MOD" significa que quiere calcular el módulo
				modulo();
				break;
			case "SQRT": // para raiz, llamamos a raiz();
				raiz();
				break;
			case "!": // para factorial, llamamos a factorial();
				factorial();
				break;
			case "^": // para potencia, llamamos a potencia();
				potencia();
				break;
			case "SEN":// para seno, llamamos a seno();
				seno();
				break;
			case "COS":// para coseno, llamamos a coseno();
				coseno();
				break;
			case "TAN": // para tangente, llamamos a tangente();
				tangente();
				break;
			case "ARCSEN": // para arcseno, llamamos a arcseno();
				arcseno();
				break;
			case "ARCOS": // para arcoseno, llamamos a arcos();
				arcos();
				break;
			case ">": // para mayor numeración, llamamos a mayornum();
				mayornum();
				break;
			case "<": // para menor numeración, llamamos a menornum();
				menornum();
				break;
			default: // para cualquier otro caso, mostramos error operacion no soportada y volvemos a pedir el dato
				JOptionPane.showMessageDialog(null, "ERROR: Operación " + opr + " no soportada, introduzca otro valor", "Error en ejecución", JOptionPane.ERROR_MESSAGE);
				escritorOperacion();
		}
		
	}
	
	/**
	 * Función que sustituye el formato decimal con el separador ',' (coma), por el formato con el separador '.' (punto)
	 * @param String num //Número real con el separador ',' (coma)
	 * @return Double //Número real con el separador '.' (punto) 
	 */
	private static Double suspc(String num) {
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
	private static String identif(){ 
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
	private static void menornum() {
		if (op1 > op2) { // si op1 es mayor que op2
			/*
			 * ### Caso en el que el segundo operador es menor que el primero
			 * 
			 * Mostramos el resultado en un cuadro de dialogo con los botones:
			 * 
			 * 	> Operar con nuevo valor -> Valor '0'
			 * 	> Salir al menú -> Valor '1'
			 */
			selector = JOptionPane.showOptionDialog(null,
													frmt.format(op2) + " es menor que " + frmt.format(op1), //Resultado de la operación
												    "Resultado de la operación", //Titulo de la ventana
												    JOptionPane.YES_NO_CANCEL_OPTION,//Tipo de opciones a mostrar
												    JOptionPane.QUESTION_MESSAGE,//Tipo de mensaje
												    null,
												    /*
												     * opciones
												     */
												    new Object[] {"Operar con nuevo valor", // Realizar otra operación 
												    			  "Salir al menú" // Salir al menú principal
																 }, 
												    null);
		} else { // sino
			/*
			 * ### Caso en el que el primer operador es menor que el segundo
			 * 
			 * Mostramos el resultado en un cuadro de dialogo con los botones:
			 * 
			 * 	> Operar con nuevo valor -> Valor '0'
			 * 	> Salir al menú -> Valor '1'
			 */
			selector = JOptionPane.showOptionDialog(null,
													frmt.format(op1) + " es menor que " + frmt.format(op2), //Resultado de la operación
												    "Resultado de la operación", //Titulo de la ventana
												    JOptionPane.YES_NO_CANCEL_OPTION,//Tipo de opciones a mostrar
												    JOptionPane.QUESTION_MESSAGE,//Tipo de mensaje
												    null,
												    /*
												     * opciones
												     */
												    new Object[] {"Operar con nuevo valor", // Realizar otra operación 
												    			  "Salir al menú" // Salir al menú principal
																 }, 
												    null);
		}
		
		/*
		 * Evaluamos el valor de la opción seleccionada, teniendo en cuenta que cada botón 
		 * devuelve un valor numerico concreto:
		 * 
		 * 	> Operar con nuevo valor -> Valor '0'
		 * 	> Salir al menú -> Valor '1'
		 */
		switch(selector){
			case 0: // En el caso de haber seleccionado "Operar con nuevo valor"
				escritorOperacion(); // llama a la función "escritorOperacion();"
				break;
			case 1: // En el caso de haber seleccionado "Salir al menú"
				firstDialog(); // llama a la función "firstDialog();"
				break;
		}
	}
	
	/**
	 * Función que indica cual de los dos numeros es mayor.
	 * @param
	 */
	private static void mayornum() {
		if (op1 > op2) { // si op1 es mayor que op2
			/*
			 * ### Caso en el que el primer operador es mayor que el segundo
			 * 
			 * Mostramos el resultado en un cuadro de dialogo con los botones:
			 * 
			 * 	> Operar con nuevo valor -> Valor '0'
			 * 	> Salir al menú -> Valor '1'
			 */
			selector = JOptionPane.showOptionDialog(null,
													frmt.format(op1) + " es mayor que " + frmt.format(op2), //Resultado de la operación
												    "Resultado de la operación", //Titulo de la ventana
												    JOptionPane.YES_NO_CANCEL_OPTION,//Tipo de opciones a mostrar
												    JOptionPane.QUESTION_MESSAGE,//Tipo de mensaje
												    null,
												    /*
												     * opciones
												     */
												    new Object[] {"Operar con nuevo valor", // Realizar otra operación 
												    			  "Salir al menú" // Salir al menú principal
																 }, 
												    null);
			
		} else { // si no
			/*
			 * ### Caso en el que el segundo operador es mayor que el primero
			 * 
			 * Mostramos el resultado en un cuadro de dialogo con los botones:
			 * 
			 * 	> Operar con nuevo valor -> Valor '0'
			 * 	> Salir al menú -> Valor '1'
			 */
			selector = JOptionPane.showOptionDialog(null,
													frmt.format(op2) + " es mayor que " + frmt.format(op1), //Resultado de la operación
												    "Resultado de la operación", //Titulo de la ventana
												    JOptionPane.YES_NO_CANCEL_OPTION,//Tipo de opciones a mostrar
												    JOptionPane.QUESTION_MESSAGE,//Tipo de mensaje
												    null,
												    /*
												     * opciones
												     */
												    new Object[] {"Operar con nuevo valor", // Realizar otra operación 
												    			  "Salir al menú" // Salir al menú principal
																 }, 
												    null);
		}
		
		/*
		 * Evaluamos el valor de la opción seleccionada, teniendo en cuenta que cada botón 
		 * devuelve un valor numerico concreto:
		 * 
		 * 	> Operar con nuevo valor -> Valor '0'
		 * 	> Salir al menú -> Valor '1'
		 */
		switch(selector){
			case 0: // En el caso de haber seleccionado "Operar con nuevo valor"
				escritorOperacion(); // llama a la función "escritorOperacion();"
				break;
			case 1: // En el caso de haber seleccionado "Salir al menú"
				firstDialog(); // llama a la función "firstDialog();"
				break;
		}
	}
	
	/**
	 * Calculo del ArcCoseno del ángulo en radianes especificado.
	 * @param
	 */
	private static void arcos() {
		if (op2 != 0) { // Si el segundo operador no esta vacio, realizamos la operacion sobre el mismo
			res = Math.acos(op2); 
			respuesta();// Realizamos le ArcCoseno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			res = Math.acos(op1); 
			respuesta();// Realizamos le ArcCoseno sobre op1
		} else { // sino
			System.out.println("Error: no se ha encontrado operador"); // De lo contrario, muestra error
		}
	}
	
	/**
	 * Calculo del ArcSeno del ángulo especificado.
	 * @param
	 */
	private static void arcseno() {
		if (op2 != 0) { // Si el segundo operador no esta vacio, realizamos la operacion sobre el mismo
			res = Math.asin(op2); 
			respuesta();// Realizamos le ArcSeno sobre op2
		} else if (op1 != 0) { // De lo contrario si el primer operador no esta vacio, realiza la operación
			res = Math.asin(op1);
			respuesta();// Realizamos le ArcSeno sobre op1
		} else { // sino
			System.out.println("Error: no se ha encontrado operador"); // De lo contrario, muestra error
		}
	}
	
	/**
	 * Calculo de la tangente del ángulo especificado.
	 * @param
	 */
	private static void tangente() {
		if (op2 != 0) { // si el operador 2 es distinto de 0
			res = Math.tan(op2); // realizamos la operación sobre el segundo operando
			respuesta();
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			res = Math.tan(op1); // realizamos la operacion sobre el primer operando
			respuesta();
		}
	}
	
	/**
	 * Calculo del Coseno del ángulo especificado en radianes.
	 * @param
	 */
	private static void coseno() {
		if (op2 != 0) { // si el operador 2 es distinto de 0		
			res = Math.cos(op2); // realizamos la operación sobre el segundo operando
			respuesta();
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			res = Math.cos(op1);
			respuesta();// realizamos la operacion sobre el primer operando
		}
	}
	
	/**
	 * Calculo del Seno del ángulo especificado en radianes.
	 * @param
	 */
	private static void seno() {
		if (op2 != 0) { // si el operador 2 es distinto de 0
			res = Math.sin(op2);
			respuesta();// realizamos la operación sobre el segundo operando
		} else if (op1 != 0) { // sino y si el operador 1 es distinto de 0
			res = Math.sin(op1);
			respuesta();// realizamos la operacion sobre el primer operando
		}
	}
	
	/**
	 * Calculo de la potencia
	 */
	private static void potencia() {
		res = (float) Math.pow(op1, op2);
		respuesta();
	}
	
	/**
	 * Calculo del fasctorial
	 */
	private static void factorial() {
		for(int a = 1 ;a < op2 ;a++) {
			if(a == 1) {
				res = op2 * (op2-1);
				op2--;
			} else {
				res = res * (op2-1);
			}
		}
		op2++;
		respuesta();	
	}
	
	/**
	 * Calculo de la raiz
	 */
	private static void raiz() {
		res = (float) Math.sqrt(op2);
		respuesta();	
	}
	
	/**
	 * calculo del modulo
	 */
	private static void modulo() {
		res = op1 % op2;
		respuesta();	
	}
	
	/**
	 * cálculo de la divion
	 */
	private static void división() {
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
	
	/**
	 * cálculo de la multiplicación
	 */
	private static void multiplicacion() {
		res = op1*op2;
		respuesta();
		
	}
	
	/**
	 * Cálculo de la rest()
	 */
	private static void resta() {
		res = op1-op2;
		respuesta();
	}
	
	/**
	 * cálculo de la suma
	 */
	private static void suma() {
		res = op1+op2;
		respuesta();
	}
	
	/**
	 * imprime la respuesta en una caja mensaje de Swing.
	 */
	private static void respuesta() {
		if(op1 != 0 && op2 != 0) {
			selector = JOptionPane.showOptionDialog( null,frmt.format(op1) + " " + opr + " " + frmt.format(op2) + " = " + frmt.format(res),  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,new Object[] { "Operar con nuevo valor", "Salir al menú" }, null);
		}
		else if (op2 == 0){
			selector = JOptionPane.showOptionDialog( null,frmt.format(op1) + " " + opr + " = " + frmt.format(res),  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Salir al menú" }, null);
		} else {
			selector = JOptionPane.showOptionDialog( null,opr + " " + frmt.format(op2) + " = " + frmt.format(res),  "Resultado de la operación",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null,new Object[] { "Operar con nuevo valor", "Salir al menú" }, null);
		}
		
		switch(selector){
			case 0:
				escritorOperacion();
				break;
			case 1:
				firstDialog();
				break;
		}
	}
}
