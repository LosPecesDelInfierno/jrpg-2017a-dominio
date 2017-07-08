package mensajeria;

import java.io.Serializable;
/**
 * Paquete Para logueo de usuario.
 *
 */
public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

	private String username;
	private String password;
	private boolean inicioSesion;
	/**
	 *
	 */
	public PaqueteUsuario() {

	}
	/**
	 * Constructor parametrizado
	 * @param user String
	 * @param pw String
	 */
	public PaqueteUsuario(final String user, final String pw) {
		username = user;
		password = pw;
		inicioSesion = false;
	}
	/**
	 *
	 * @return username String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 *
	 * @param username String
	 */
	public void setUsername(final String username) {
		this.username = username;
	}
	/**
	 *
	 * @return password (String)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password String
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	/**
	 *
	 * @return inicioSesion (boolean)
	 */
	public boolean isInicioSesion() {
		return inicioSesion;
	}
	/**
	 *
	 * @param inicioSesion boolean
	 */
	public void setInicioSesion(final boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	/**
	 * Override de clone()
	 * @return Objeto clonado
	 */
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}
