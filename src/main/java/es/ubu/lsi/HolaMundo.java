package es.ubu.lsi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota.
 */
public interface HolaMundo extends Remote {

	/**
	 * Devuelve un texto con un saludo.
	 *
	 * @return texto de saludo
	 * @throws RemoteException problema en acceso remoto
	 */
	String decirHola() throws RemoteException;

	
	/**
	 * Devuelve un entero aleatorio.
	 *
	 * @return  entero aleatorio
	 * @throws RemoteException problema en acceso remoto
	 */
	int obtenerEnteroAleatorio() throws RemoteException;
	
	
	/**
	 * Devuelve un texto con un hasta luego.
	 *
	 * @return texto de despedida
	 * @throws RemoteException problema en acceso remoto
	 */
	String decirHastaLuego() throws RemoteException;
	
	

} // HolaMundo