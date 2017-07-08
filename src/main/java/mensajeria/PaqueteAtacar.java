package mensajeria;

import java.io.Serializable;

/**
 * Paquete enviado y recibido a la hora de atacar.
 *
 *
 */
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int nuevaSaludPersonaje;
	private int nuevaEnergiaPersonaje;
	private int nuevaSaludEnemigo;
	private int nuevaEnergiaEnemigo;

	/**
	 *
	 * @param id int
	 * @param idEnemigo int
	 * @param nuevaSalud int
	 * @param nuevaEnergia int
	 * @param nuevaSaludEnemigo int
	 * @param nuevaEnergiaEnemigo int
	 */

	public PaqueteAtacar(final int id, final int idEnemigo, final int nuevaSalud, final int nuevaEnergia,
			final int nuevaSaludEnemigo, final int nuevaEnergiaEnemigo) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		this.nuevaSaludPersonaje = nuevaSalud;
		this.nuevaEnergiaPersonaje = nuevaEnergia;
		this.nuevaSaludEnemigo = nuevaSaludEnemigo;
		this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
	}

	/**
	 *
	 * @return id int
	 */
	public int getId() {
		return id;
	}

	/**
	 *
	 * @param id int
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 *
	 * @return idenemigo
	 */
	public int getIdEnemigo() {
		return idEnemigo;
	}

	/**
	 *
	 * @param idEnemigo int
	 */
	public void setIdEnemigo(final int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}

	/**
	 *
	 * @return nuevaSalud int
	 */
	public int getNuevaSaludPersonaje() {
		return nuevaSaludPersonaje;
	}

	/**
	 *
	 * @param nuevaSaludPersonaje int
	 */
	public void setNuevaSaludPersonaje(final int nuevaSaludPersonaje) {
		this.nuevaSaludPersonaje = nuevaSaludPersonaje;
	}

	/**
	 *
	 * @return nuevaEnergia int
	 */
	public int getNuevaEnergiaPersonaje() {
		return nuevaEnergiaPersonaje;
	}

	/**
	 *
	 * @param nuevaEnergiaPersonaje int
	 */
	public void setNuevaEnergiaPersonaje(final int nuevaEnergiaPersonaje) {
		this.nuevaEnergiaPersonaje = nuevaEnergiaPersonaje;
	}

	/**
	 *
	 * @return nuevaSaludEnemigo int
	 */
	public int getNuevaSaludEnemigo() {
		return nuevaSaludEnemigo;
	}

	/**
	 *
	 * @param nuevaSaludEnemigo int
	 */
	public void setNuevaSaludEnemigo(final int nuevaSaludEnemigo) {
		this.nuevaSaludEnemigo = nuevaSaludEnemigo;
	}

	/**
	 *
	 * @return nuevaEnergiaEnemigo int
	 */
	public int getNuevaEnergiaEnemigo() {
		return nuevaEnergiaEnemigo;
	}

	/**
	 *
	 * @param nuevaEnergiaEnemigo int
	 */
	public void setNuevaEnergiaEnemigo(final int nuevaEnergiaEnemigo) {
		this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
	}

}
