package mensajeria;

import java.io.Serializable;

/**
*
* <p>
* Clase que define el paquete con los mensajes que se envian los personajes por el chat
* </p>
*
*/
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {

	private int idDestinatario;
	private int idEmisor;
	private String contenido;

	/**
	 * <h3>Contructor de PaqueteMensaje</h3>
	 * @param emisor del mensaje
	 * @param destinatario del mensaje
	 * @param contenido del mensaje
	 */
	public PaqueteMensaje(final int emisor, final int destinatario, final String contenido) {
		setComando(Comando.MENSAJE);
		this.idEmisor = emisor;
		this.idDestinatario = destinatario;
		this.contenido = contenido;
	}

	/**
	 * <h3>Contructor de PaqueteMensaje</h3>
	 * @param emisor del mensaje
	 * @param contenido del mensaje
	 */
	public PaqueteMensaje(final int emisor, final String contenido) {
		this(emisor, -1, contenido);
	}

	/**
	 * <h3>Metodo esDifusion</h3>
	 *
	 * @return boolean
	 */
	public boolean esDifusion() {
		return idDestinatario == -1;
	}

	/**
	 * <h3>Metodo getIdDestinatario</h3>
	 *
	 * @return idDestinatario
	 */
	public int getIdDestinatario() {
		return idDestinatario;
	}

	/**
	 * <h3>Metodo getIdEmisor</h3>
	 *
	 * @return idEmisor
	 */
	public int getIdEmisor() {
		return idEmisor;
	}

	/**
	 * <h3>Metodo getContenido</h3>
	 *
	 * @return contenido
	 */
	public String getContenido() {
		return contenido;
	}
}
