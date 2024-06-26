package es.ifp.programación.uf3.ejercicio;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class programaPrincipal {
	
	/**
	 * Programa que gestiona cualquier tipo de información en un fichero de texto. 
	 * @author David Rueda
	 */

	/**
	 * Función de arranca de mi programa donde se empieza a ejecutar el código.
	 * @param argumentos que recibe el programa.
	 * @return Esta función no retorna nada.
	 */
	public static void main(String[] args) {
		
		/**
		 * Declaración de variables
		 */
		
		Scanner sc = new Scanner (System.in);
		String opcion;
		
		/**
		 *Inicio del Bucle do-while para mostrar el menu constantemente
		 */
		
		do {
		muestraMenu();
		opcion = sc.nextLine();
		
		if(opcion.equals("A")) {
			crearFichero();
		}
		else
			if(opcion.equals("B")) {
				escribirFichero();	
			}
			else
				if(opcion.equals("C")) {
					leerFichero();
				}
				else
					if(opcion.equals("D")) {
						eliminarFichero();
					
						
					} else 
						if(opcion.equals("S") || opcion.equals("E")) {
							
						}
						else {
						System.out.println("Opción incorrecta");
						System.out.println("====================");
						}
						
					
	/**
	 * Condicional de salida del bucle
	 */
		
		}while(!opcion.equals("S") && !opcion.equals("E"));
		
		
		
		System.out.println("Fin de la ejecución del programa");
		

	}
	/**
	 * Procedimiento que crea un Fichero, en caso de estar creado se indica en consola.
	 */
	
	public static void crearFichero() {
		
		Scanner sc = new Scanner(System.in);
		File f = null;
		String ruta;
		boolean result=false;
		
		
		System.out.println("Introduzca aquí el nombre del fichero que desea crear: ");
		ruta = sc.nextLine();
		
		f = new File(ruta);
		
		try {
			result = f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("El fichero no ha podido ser creado");
		}
		
		if(result) {
			System.out.println("El fichero se ha creado correctamente");
		}
		else {
			 System.out.println("=====================");
			 System.out.println("El archivo ya existe");
			 System.out.println("=====================");
		}
		
	}
	
	/**
	 * Procedimiento que escribe en un fichero indicándole la ruta del mismo.
	 * En caso de no exisitir se pregunta si desea crearlo, al elegir la opción S o N se crea o no.
	 */
	public static void escribirFichero() {
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		String cadena;
		String ruta;
		BufferedWriter bw = null;
		String opc;
		
		
		System.out.println("Introduzca la ruta del fichero sobre el que desea escribir: ");
		ruta = sc.nextLine();
		
		File fichero = new File(ruta);
		
		if(fichero.exists()) {//Si el fichero existe entra por if y escribe la información del usuario.
			
			System.out.println("Introduzca el texto que desea escribir en el fichero: ");
			cadena = sc.nextLine();
			
			try {
			fw = new FileWriter(ruta);
			bw = new BufferedWriter(fw);
			
			bw.write(cadena);
			
			
			bw.close();
			fw.close();
			
			System.out.println("El texto ha sido escrito en el fichero indicado.");
			return;
			
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
				System.out.println("Error al escribir el fichero.");
				
			}
			
			
		}
		else//En caso de que el fichero no exista se demanda al usuario si quiere crearlo en caso positivo se crea y se escribe lo que el usuario demande.
			System.out.println("El fichero indicado no existe, ¿Desea crearlo?. Indique S o N: ");
			opc = sc.nextLine();
			
			
			if(opc.equals("S")) {
				
				try {
					fichero.createNewFile();
					System.out.println("El fichero se ha creado correctamente.");
					System.out.println("Introduzca el texto que desea escribir en el fichero: ");
					cadena = sc.nextLine();
				
					
					try {
					fw = new FileWriter(ruta);
					bw = new BufferedWriter(fw);
					
					bw.write(cadena);
					
					
					bw.close();
					fw.close();
					
					System.out.println("El texto ha sido escrito en el fichero creado.");
					
					
					}
					catch (IOException ioe) {
						ioe.printStackTrace();
						System.out.println("Error al escribir el fichero");
						
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error al crear el fichero");
				}
				
			}
			else {
				System.out.println("El fichero no se ha creado");
			}
	}
	/**
	 * Procedimiento que lee un fichero y muestra en consola el contenido del mismo.
	 * En caso de que no exista se indica en consola.
	 */
	
	public static void leerFichero() {
		
		
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		String totalLineas = "";
		Scanner sc = new Scanner(System.in);
		String ruta;
		File f;
		
		System.out.println("Introduzca el fichero a leer: ");
		ruta = sc.nextLine();
			
		try {
			
		f = new File(ruta);
		
		if (f.exists()) {
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);
			
			linea = br.readLine();
			while (linea !=null) {
				totalLineas += "\n"+linea;
				linea = br.readLine();
			}
			
			fr.close();
			br.close();
			
			System.out.println("El contenido del fichero es: "+totalLineas);
		}else
			System.out.println("El fichero no se puede leer ya que no existe.");
		
		
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("El fichero no existe.");
			return;
			
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Error al leer el fichero");
		}
		
		
		
		
	}
	/**
	 * Procedimiento que elimina un fichero creado.
	 * En caso de que no exista se indicca en consola.
	 */
	
	public static void eliminarFichero() {
		
		Scanner sc = new Scanner(System.in);
		File f = null;
		String ruta;
		boolean result;
		String opcion;
		
		System.out.println("Introduzca la ruta del fichero que desea borrar: ");
		ruta = sc.nextLine();
		
		f = new File(ruta);
		
		if (f.exists()) {
		
		System.out.println("¿Estás seguro? Indique S o N: ");
		opcion = sc.nextLine();
		
			if(opcion.equals("S")) {
				result = f.delete();
				System.out.println("El fichero se ha borrado correctamente");
			
			} else 
				System.out.println("El fichero no se ha borrado");
	
	} else 
		System.out.println("El fichero que desea borrar no existe.");
	}
		
	
	
	/**
	 * Procedimeinto que muestra un menú en consola
	 */
	public static void muestraMenu() {
		
		System.out.println("===============================");
		System.out.println("            MENÚ               ");
		System.out.println("===============================");
		System.out.println("A) Crear fichero de texto. ");
		System.out.println("B) Introducir información en el fichero. ");
		System.out.println("C) Leer el fichero de texto. ");
		System.out.println("D) Eliminar el fichero de texto. ");
		System.out.println("E) Salir (S) ");
		System.out.println("===============================");
		System.out.println("Introduzca una opción ");
	
	}
	
	
	
	
}
	

	


