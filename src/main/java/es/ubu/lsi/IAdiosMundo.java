package es.ubu.lsi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota.
 */
public interface IAdiosMundo extends Remote {

	/**
	 * Devuelve un texto con una despedida.
	 *
	 * @return texto de despedida
	 * @throws RemoteException problema en acceso remoto
	 */
	String decirAdios() throws RemoteException;
	

} // AdiosMundo