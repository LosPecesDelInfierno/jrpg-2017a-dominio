package dominio;

/**
 *
 *
 * Interfaz Peleable con la declaracion de los metodos a definirse en la clases
 * que la implementen.
 *
 */
public interface Peleable {
	/**
	 * <h3>Metodo ser atacado</h3>
	 *
	 * @param danio
	 *            personaje
	 * @return int danio
	 */
	int serAtacado(int danio);

	/**
	 * <h3>Metodo get Salud</h3>
	 *
	 * @return int salud
	 */
	int getSalud();

	/**
	 * <h3>Metodo despues de turno</h3>
	 */
	void despuesDeTurno();

	/**
	 * <h3>Metodo atacar</h3> Ataca a otro personaje
	 *
	 * @param atacado
	 *            personaje atacado
	 * @return int
	 */
	int atacar(Peleable atacado);

	/**
	 * <h3>Metodo otorgarExp</h3>
	 *
	 * @return int experiencia
	 */
	int otorgarExp();

	/**
	 * <h3>Metodo getAtaque</h3>
	 *
	 * @return int ataque
	 */
	int getAtaque();

	/**
	 * <h3>Metodo set Ataque</h3> Seteo el ataque del pesonaje
	 *
	 * @param ataque Ataque del pj.
	 */
	void setAtaque(int ataque);

	/**
	 * <h3>Metodo estaVivo</h3>
	 *
	 * @return boolean true/false
	 */
	boolean estaVivo();

	/**
	 * <h3>Metodo getNombre</h3>
	 *
	 * @return String nombre peleable
	 */
	String getNombre();

	/**
	 * <h3>Sufre Danio Extra</h3> Se utiliza para determinar si una instancia de
	 * clase (que implementa a Peleable), debe sufrir un ataque extra cuando es
	 * víctima de alguna habilidad propia de una determinada Casta.
	 * <p>
	 *
	 * @return boolean
	 */
	boolean sufreDanioExtra();

	/**
	 * <h3>Metodo serCurado</h3>
	 *
	 * @param int danioCausado
	 * 					del personaje
	 */
	void serCurado(int danioCausado);
}
