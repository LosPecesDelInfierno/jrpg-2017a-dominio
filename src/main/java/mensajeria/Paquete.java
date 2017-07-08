package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase que define los paquetes a enviar entre el servidor y cliente
* </p>
*
*/
public class Paquete implements Serializable, Cloneable {

	public static String msjExito = "1";
	public static String msjFracaso = "0";

	private String mensaje;
	private String ip;
	private int comando;

	/**
	 * <h3>Contructor de Paquete</h3>
	 */
	public Paquete() { }

	/**
	 * <h3>Contructor de Paquete</h3>
	 *
	 * @param mensaje
	 *            del Paquete
	 * @param nick
	 *            del Paquete
	 * @param ip
	 *            del Paquete
	 * @param comando
	 *            del Paquete
	 */
	public Paquete(final String mensaje, final String nick, final String ip, final int comando) {
		this.mensaje = mensaje;
		this.ip = ip;
		this.comando = comando;
	}

	/**
	 * <h3>Contructor de Paquete</h3>
	 *
	 * @param mensaje
	 *            del Paquete
	 * @param comando
	 *            del Paquete
	 */
	public Paquete(final String mensaje, final int comando) {
		this.mensaje = mensaje;
		this.comando = comando;
	}

	/**
	 * <h3>Contructor de Paquete</h3>
	 *
	 * @param comando
	 *            del Paquete
	 */
	public Paquete(final int comando) {
		this.comando = comando;
	}

	/**
	 * <h3>Metodo setMensaje</h3>
	 *
	 * @param mensaje
	 * 				del paquete
	 */
	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * <h3>Metodo setIp</h3>
	 *
	 * @param ip
	 * 			del paquete
	 */
	public void setIp(final String ip) {
		this.ip = ip;
	}

	/**
	 * <h3>Metodo setComando</h3>
	 *
	 * @param comando
	 * 				del paquete
	 */
	public void setComando(final int comando) {
		this.comando = comando;
	}

	/**
	 * <h3>Metodo getMensaje</h3>
	 *
	 * @return mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * <h3>Metodo getIp</h3>
	 *
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * <h3>Metodo getComando</h3>
	 *
	 * @return comando
	 */
	public int getComando() {
		return comando;
	}

	/**
	 * <h3>Metodo clone</h3>
	 *
	 * @return Object
	 *
	 */
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return obj;
	}
}
