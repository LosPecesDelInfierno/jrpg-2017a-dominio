package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
*
* <p>
* Clase que define el paquete de movimientos de los personajes
* </p>
*
*/
public class PaqueteDeMovimientos extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaqueteMovimiento> personajes;

	/**
	 * <h3>Contructor de PaqueteDeMovimientos</h3>
	 */
	public PaqueteDeMovimientos() {
	}

	/**
	 * <h3>Contructor de PaqueteDeMovimientos</h3>
	 *
	 * @param personajes
	 * 					mapa con los personajes
	 */
	public PaqueteDeMovimientos(final Map<Integer, PaqueteMovimiento> personajes) {
		this.personajes = personajes;
	}

	/**
	 * <h3>Metodo getPersonajes</h3>
	 *
	 * @return personajes
	 */
	public Map<Integer, PaqueteMovimiento> getPersonajes() {
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
