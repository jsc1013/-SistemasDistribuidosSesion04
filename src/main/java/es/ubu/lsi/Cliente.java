package es.ubu.lsi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Cliente remoto.
 */
public class Cliente {

	/**
	 * Constructor oculto,
	 */
	private Cliente() {
	}

	/**
	 * Método raíz.
	 *
	 * @param args host con el registro
	 */
	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {

			Registry registry = LocateRegistry.getRegistry(host);

			// Obtiene los nombres de los objetos registrados en el registro
			String[] bindings = registry.list();

			for (String bind : bindings) {
				System.out.println("Binding: " + bind);
			}

			// Resuelve el objeto remoto (la referencia a...)
			IHolaMundo stub = (IHolaMundo) registry.lookup("Hola");
			String respuesta = stub.decirHola();
			System.out.println("Respuesta del servidor remoto: " + respuesta);

			// Resuelve el objeto remoto (la referencia a...)
			IQueTalMundo stub2 = (IQueTalMundo) registry.lookup("QueTal");
			respuesta = stub2.decirQueTal();
			System.out.println("Respuesta del servidor remoto: " + respuesta);

			// Resuelve el objeto remoto (la referencia a...)
			IAdiosMundo stub3 = (IAdiosMundo) registry.lookup("Adios");
			respuesta = stub3.decirAdios();
			System.out.println("Respuesta del servidor remoto: " + respuesta);

		} catch (Exception e) {
			System.err.println("Excepción en cliente: " + e.toString());
		} // try

	} // main

} // Cliente