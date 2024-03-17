package es.ubu.lsi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Servidor remoto.
 *
 */
public class Servidor {

	/**
	 * Método raíz.
	 *
	 * @param args argumentos
	 */
	public static void main(String args[]) {

		try {
			HolaMundo holaMundo = new HolaMundo();
			QueTalMundo queTalMundo = new QueTalMundo();
			AdiosMundo adiosMundo = new AdiosMundo();

			// si no hereda de UnicastRemoteObject es necesario exportar
			IHolaMundo stub = (IHolaMundo) UnicastRemoteObject.exportObject(holaMundo, 0);

			// si no hereda de UnicastRemoteObject es necesario exportar
			IQueTalMundo stub2 = (IQueTalMundo) UnicastRemoteObject.exportObject(queTalMundo, 0);

			// si no hereda de UnicastRemoteObject es necesario exportar
			IAdiosMundo stub3 = (IAdiosMundo) UnicastRemoteObject.exportObject(adiosMundo, 0);

			// Liga el resguardo de objeto remoto en el registro
			Registry registro = LocateRegistry.getRegistry();

			registro.rebind("Hola", stub);
			registro.rebind("QueTal", stub2);
			registro.rebind("Adios", stub3);

			System.out.println("Servidor preparado");
		} catch (Exception e) {
			System.err.println("Excepción de servidor: " + e.toString());
		}
	} // main

} // Servidor