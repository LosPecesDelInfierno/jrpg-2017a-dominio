package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
*
* <p>
* Clase que tiene paquetes de los personajes
* </p>
*
*/
public class PaqueteDePersonajes extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaquetePersonaje> personajes;

	/**
	 * <h3>Contructor de PaqueteDePersonajes</h3>
	 */
	public PaqueteDePersonajes() {
	}

	/**
	 * <h3>Contructor de PaqueteDePersonajes</h3>
	 *
	 * @param personajes
	 * 					mapa con los personajes
	 */
	public PaqueteDePersonajes(final Map<Integer, PaquetePersonaje> personajes) {
		this.personajes = personajes;
	}

	/**
	 * <h3>Metodo getPersonajes</h3>
	 *
	 * @return personajes
	 */
	public Map<Integer, PaquetePersonaje> getPersonajes() {
		return personajes;
	}

	/**
	 * <h3>Metodo clone</h3>
	 *
	 * @return Object
	 */
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}