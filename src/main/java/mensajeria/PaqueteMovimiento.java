package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase que define el paquete con los movimientos de los personajes
* </p>
*
*/
public class PaqueteMovimiento extends Paquete implements Serializable, Cloneable {

	private int id;
	private float posX;
	private float posY;
	private int direccion;
	private int frame;

	/**
	 * <h3>Contructor de PaqueteMovimiento</h3>
	 */
	public PaqueteMovimiento() {
		setComando(Comando.MOVIMIENTO);
	}

	/**
	 * <h3>Contructor de PaqueteMovimiento</h3>
	 * @param idPersonaje id del personaje
	 */
	public PaqueteMovimiento(final int idPersonaje) {
		id = idPersonaje;
		setComando(Comando.MOVIMIENTO);
	}

	/**
	 * <h3>Contructor de PaqueteMovimiento</h3>
	 * @param idPersonaje id del personaje
	 * @param posX posicion en x
	 * @param posY posicion en y
	 */
	public PaqueteMovimiento(final int idPersonaje, final float posX, final float posY) {
		this.id = idPersonaje;
		this.posX = posX;
		this.posY = posY;
		setComando(Comando.MOVIMIENTO);
	}

	/**
	 * <h3>Metodo getIdPersonaje</h3>
	 *
	 * @return id
	 */
	public int getIdPersonaje() {
		return id;
	}

	/**
	 * <h3>Metodo setIdPersonaje</h3>
	 *
	 * @param idPersonaje del personaje
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.id = idPersonaje;
	}

	/**
	 * <h3>Metodo getPosX</h3>
	 *
	 * @return posX
	 */
	public float getPosX() {
		return posX;
	}

	/**
	 * <h3>Metodo setPosX</h3>
	 *
	 * @param posX del personaje
	 */
	public void setPosX(final float posX) {
		this.posX = posX;
	}

	/**
	 * <h3>Metodo getPosY</h3>
	 *
	 * @return posY
	 */
	public float getPosY() {
		return posY;
	}

	/**
	 * <h3>Metodo setPosY</h3>
	 *
	 * @param posY del personaje
	 */
	public void setPosY(final float posY) {
		this.posY = posY;
	}

	/**
	 * <h3>Metodo getDireccion</h3>
	 *
	 * @return direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * <h3>Metodo setDireccion</h3>
	 *
	 * @param direccion del personaje
	 */
	public void setDireccion(final int direccion) {
		this.direccion = direccion;
	}

	/**
	 * <h3>Metodo getFrame</h3>
	 *
	 * @return frame
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * <h3>Metodo setFrame</h3>
	 *
	 * @param frame movimiento
	 */
	public void setFrame(final int frame) {
		this.frame = frame;
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