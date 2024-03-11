package es.ubu.lsi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * Servidor remoto.
 *
 */
public class Servidor implements HolaMundo {

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public String decirHola() {
		return "Hola mundo!";
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public int obtenerEnteroAleatorio() throws RemoteException {
		Random random = new Random();
		return random.nextInt();
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public String decirHastaLuego() throws RemoteException {
		return "Hasta luego!";
	}

	/**
	 * Método raíz.
	 *
	 * @param args argumentos
	 */
	public static void main(String args[]) {

		try {
			Servidor obj = new Servidor();

			// si no hereda de UnicastRemoteObject es necesario exportar
			HolaMundo stub = (HolaMundo) UnicastRemoteObject.exportObject(obj, 0);

			// Liga el resguardo de objeto remoto en el registro
			Registry registro = LocateRegistry.getRegistry();
			registro.bind("Hola", stub);

			System.out.println("Servidor preparado");
		} catch (Exception e) {
			System.err.println("Excepción de servidor: " + e.toString());
		}
	} // main

} // Servidor