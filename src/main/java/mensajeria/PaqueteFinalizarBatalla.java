package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase con el paquete para finalizar una batalla
* </p>
*
*/
public class PaqueteFinalizarBatalla extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;

	/**
	 * <h3>Contructor de PaqueteFinalizarBatalla</h3>
	 */
	public PaqueteFinalizarBatalla() {
		setComando(Comando.FINALIZARBATALLA);
	}

	/**
	 * <h3>Metodo getId</h3>
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * <h3>Metodo setId</h3>
	 *
	 * @param id
	 * 			del paquete
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * <h3>Metodo getIdEnemigo</h3>
	 *
	 * @return idEnemigo
	 */
	public int getIdEnemigo() {
		return idEnemigo;
	}

	/**
	 * <h3>Metodo setIdEnemigo</h3>
	 *
	 * @param idEnemigo
	 * 			del paquete
	 */
	public void setIdEnemigo(final int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
}
