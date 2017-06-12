package dominio;

import java.util.HashMap;
import java.util.Map;

public abstract class SuperPersonaje {

	protected int salud;
	protected String nombre;
	protected int fuerza;
	protected int defensa;
	protected int nivel;
	protected RandomGenerator randomGenerator;
	protected Map<Integer, Item> inventario;
	protected int bonusFuerza;
	protected int bonusSalud;
	
	/**
	 * <h3>Constructor SuperPersonaje</h3>
	 * 
	 * @param nombre
	 *            personaje
	 * @param nivel
	 *            personaje
	 */
	public SuperPersonaje(final String nombre, final int nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.randomGenerator = new MyRandom();
		this.inventario = new HashMap<Integer, Item>();
	}

	public void setRandomGenerator(RandomGenerator randomGenerator) {
		this.randomGenerator = (RandomGeneratorStub) randomGenerator;
	}

	/**
	 * <h3>Obtener nombre personaje</h3>
	 * 
	 * @return nombre personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <h3>Setear nombre personaje</h3>
	 * 
	 * @param nombre
	 *            personaje
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <h3>Método getSalud</h3>
	 * 
	 * @return int salud
	 */
	public int getSalud() {
		return salud + bonusSalud;
	}

	/**
	 * <h3>Método despuesDeTurno</h3>
	 */
	public void despuesDeTurno() {
	}

	/**
	 * <h3>Método getFuerza</h3>
	 * 
	 * @return int fuerza
	 */
	public int getFuerza() {
		return fuerza + bonusFuerza;
	}

	/**
	 * <h3>Método getDefensa</h3>
	 * 
	 * @return int defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * <h3>Método mejorarDefensa</h3>
	 * <p>
	 * Aumenta el nivel de defensa del personaje
	 * </p>
	 * 
	 * @param aumento
	 *            de nivel de defensa del personaje
	 */
	public void mejorarDefensa(final int defensa) {
		this.defensa += defensa;
	}

	/**
	 * <h3>Método perderDefensa</h3>
	 * <p>
	 * Deja al personaje sin defensas
	 */
	public void perderDefensa() {
		this.defensa = 0;
	}

	/**
	 * <h3>Método estaVivo</h3>
	 * 
	 * @return boolean
	 */
	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * <h3>Método getNivel</h3>
	 * 
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * <h3>metodo addItemInventario</h3>
	 * <p> Metodo para agregar un item a un personaje</p>
	 * @param paquete
	 */
	public void addItemInventario(Item item) {
		this.inventario.put(item.getIdTipoItem(), item);
		if(this.puedeUsarItem(item))
			recalcularBonusItems();
	}
	
	public boolean puedeUsarItem(Item item) {
		if(item.getFuerzaRequerida() <= this.getFuerza())
			return true;
		return false;
	}
	
	/**
	 * <h3>metodo recalcularBonusItems</h3>
	 * 
	 * @param paquete
	 */
	private void recalcularBonusItems() {
		reiniciarBonus();
		for (Item item : inventario.values()) {
			this.incrementarAtributos(item);
		}
	}
	
	/**
	 * <h3>metodo reiniciarBonus</h3>
	 * 
	 * @param paquete
	 */
	protected void reiniciarBonus() {
		this.bonusFuerza = 0;
		this.bonusSalud = 0;
	}
	
	/**
	 * <h3>metodo incrementarAtributos</h3>
	 * <p> Metodo para incrementar los atributos de un personaje
	 * segun los efectos de los Items que este posea</p>
	 * @param paquete
	 */
	public void incrementarAtributos(Item item) {
		this.bonusFuerza += item.incrementar(getFuerza(), AtributoModificable.FUERZA);
		this.bonusSalud += item.incrementar(getSalud(), AtributoModificable.SALUD);
	}

}
