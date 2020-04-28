/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosockets01;

import java.io.*;
import java.net.*;

public class Cliente0{

	private static String HOST = "localhost";
	private static int PUERTO = 2020;

	public static void main(String args[]) {
		
		Socket socket;
		DataOutputStream mensaje;
		
		try {
			//Creamos nuestro socket
			socket = new Socket(HOST, PUERTO);
	
			mensaje = new DataOutputStream(socket.getOutputStream());

			//Enviamos un mensaje
			mensaje.writeUTF("Hola soy un cliente!!");

			//Cerramos la conexión
			socket.close();

		} catch (UnknownHostException e) {
			System.out.println("El host no existe o no está activo.");
		} catch (IOException e) {
			System.out.println("Error de entrada/salida.");
		}
        
	}
}