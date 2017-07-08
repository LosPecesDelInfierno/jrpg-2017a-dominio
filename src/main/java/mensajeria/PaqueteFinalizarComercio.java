package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase con el paquete para finalizar un comercio
* </p>
*
*/
public class PaqueteFinalizarComercio extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private boolean aceptado;

	/**
	 * <h3>Contructor de PaqueteFinalizarBatalla</h3>
	 */
	public PaqueteFinalizarComercio() {
		setComando(Comando.FINALIZARCOMERCIO);
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
	
	/**
	 * <h3>Metodo aceptaIntercambio</h3>
	 *
	 * @return aceptado
	 */
	public boolean aceptaIntercambio() {
		return this.aceptado;
	}

	/**
	 * <h3>Metodo aceptaIntercambio</h3>
	 *
	 * @param aceptado
	 * 				el intercambio
	 */
	public void aceptaIntercambio(final boolean aceptado) {
		this.aceptado = aceptado;
	}
}
