package es.ubu.lsi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface remota.
 */
public interface IQueTalMundo extends Remote {

	/**
	 * Devuelve un texto con un que tal
	 *
	 * @return texto de que tal
	 * @throws RemoteException problema en acceso remoto
	 */
	String decirQueTal() throws RemoteException;

} // AdiosMundo