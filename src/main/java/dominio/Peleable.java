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
   * @param danio
   * @return int danio
   */
	public int serAtacado(int danio);

	/**
	 * <h3>Metodo get Salud</h3>
	 * @return int salud
	 */
	public int getSalud();

	public void despuesDeTurno();

	/**
	 * <h3>Metodo atacar</h3>
	 * Ataca a otro personaje
	 * @param atacado
	 * @return int 
	 */
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();

	/**
	 * <h3>Metodo set Ataque</h3>
	 * Seteo el ataque del pesonaje
	 * @param ataque
	 */
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
