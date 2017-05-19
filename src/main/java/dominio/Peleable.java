package dominio;
/**
 *
 *
 * Interfaz Peleable con la declaracion de los metodos a definirse en la clases que la implementen.
 *
 */
public interface Peleable {
  /**
   * <h3>Metodo ser atacado</h3>
   * @param danio personaje
   * @return int danio
   */
	public int serAtacado(int danio);

	/**
	 * <h3>Metodo get Salud</h3>
	 * @return int salud
	 */
	public int getSalud();

	/**
	 * <h3>Metodo despues de turno</h3>
	 */
	public void despuesDeTurno();

	/**
	 * <h3>Metodo atacar</h3>
	 * Ataca a otro personaje
	 * @param atacado personaje atacado
	 * @return int
	 */
	public int atacar(Peleable atacado);

	/**
	 * <h3>Metodo otorgarExp</h3>
	 * @return int experiencia
	 */
	public int otorgarExp();

	/**
	 * <h3>Metodo getAtaque</h3>
	 * @return int ataque
	 */
	public int getAtaque();

	/**
	 * <h3>Metodo set Ataque</h3>
	 * Seteo el ataque del pesonaje
	 * @param ataque
	 */
	public void setAtaque(int ataque);

	/**
	 * <h3>Metodo estaVivo</h3>
	 * @return boolean true/false
	 */
	public boolean estaVivo();

	/**
	 * <h3>Metodo getNombre</h3>
	 * @return String nombre peleable
	 */
	public String getNombre();
	
	/**
	 * <h3>Sufre Danio Extra</h3>
	 * Se utiliza para determinar si una instancia de clase (que
	 * implementa a Peleable), debe sufrir un ataque extra cuando 
	 * es víctima de alguna habilidad propia de una determinada
	 * Casta.<p>
	 * @return boolean 
	 */
	public boolean sufreDanioExtra();
	//public void serCurado();
}
