package dominio;
/**
 * 
 * 
 * Interfaz Peleable con la declaracion de los metodos a definirse en la clases que la implementen.
 *
 */
public interface Peleable {
	public int serAtacado(int danio);
	public int getSalud();
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
