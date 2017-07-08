package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase que define el paquete usado en la batalla
* </p>
*
*/
public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private boolean miTurno;

	/**
	 * <h3>Contructor de PaqueteBatalla</h3>
	 */
	public PaqueteBatalla() {
		setComando(Comando.BATALLA);
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
	 * <h3>Metodo isMiTurno</h3>
	 *
	 * @return miTurno
	 */
	public boolean isMiTurno() {
		return miTurno;
	}

	/**
	 * <h3>Metodo setMiTurno</h3>
	 *
	 * @param miTurno del personaje
	 */
	public void setMiTurno(final boolean miTurno) {
		this.miTurno = miTurno;
	}
}
