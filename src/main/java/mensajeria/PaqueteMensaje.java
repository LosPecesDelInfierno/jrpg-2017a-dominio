package mensajeria;

import java.io.Serializable;

public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {
	
	private int idDestinatario;
	private int idEmisor;
	private String contenido;
	
	public PaqueteMensaje(int emisor, int destinatario, String contenido) {
		setComando(Comando.MENSAJE);
		this.idEmisor = emisor;
		this.idDestinatario = destinatario;
		this.contenido = contenido;
	}
	
	public PaqueteMensaje(int emisor, String contenido) {
		this(emisor, -1, contenido);
	}
	
	public boolean esDifusion() {
		return idDestinatario == -1;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}

	public int getIdEmisor() {
		return idEmisor;
	}

	public String getContenido() {
		return contenido;
	}
}
