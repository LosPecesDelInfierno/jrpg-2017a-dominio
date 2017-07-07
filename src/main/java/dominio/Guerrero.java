package dominio;

/**
 *
 * Clase que define a un tipo Guerrero, la misma hereda de la clase abstracta
 * Casta por lo que se definen los métodos abstractos declarados en Casta y se
 * define al nombreCasta como "Guerrero".
 *
 */
public class Guerrero extends Casta {

	/**
	 * <h3>Constructor parametrizado de Guerrero</h3>
	 * 
	 * @param proCrit
	 *            probabilidad de hacer danio critico
	 * @param evasion
	 *            capacidad de evadir
	 * @param danioCrit
	 *            danio critico que realiza
	 */
	public Guerrero(final double proCrit, final double evasion, final double danioCrit) {
		super(proCrit, evasion, danioCrit);
		this.nombreCasta = "Guerrero";
	}

	/**
	 * <h3>Constructor por defecto de Guerrero</h3>
	 */
	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[CANT_HABILIDADES];
		habilidadesCasta[HABILIDAD_1] = "Ataque Doble";
		habilidadesCasta[HABILIDAD_2] = "Aumentar Defensa";
		habilidadesCasta[HABILIDAD_3] = "Ignorar Defensa";
	}

	// Ataque Doble
	/**
	 * <h3><u>Ataque Doble</u></h3> Implementacion del método abstracto
	 * habilidad1 declarado en la clase abstracta Casta.
	 * <p>
	 * En este caso el método es el encargado de producir un Ataque Doble por
	 * parte de un guerrero hacia un objeto Peleable.<br>
	 * Nótese que en este caso el Personaje (Guerrero) que ataca es parámetro.
	 * 
	 * @param caster
	 *            Objeto de tipo Personaje encargado del ataque.
	 * @param atacado
	 *            Objeto de tipo Peleable a ser atacado.
	 * @return Si el caster tiene suficiente energia para realizar el ataque
	 *         devuelve un boolean true, caso contrario devuelve false.
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			if (atacado.serAtacado(caster.ataque * 2) > 0) {
				return true;
			}
		}
		return false;
	}

	// Aumentar Defensa
	/**
	 * <h3><u>Aumentar Defensa</u></h3> Implementacion del método abstracto
	 * habilidad2 declarado en la clase abstracta Casta.
	 * <p>
	 * En este caso este método es el encargado de aumentar la defensa de un
	 * caster de tipo Personaje (Guerrero).<br>
	 * Nótese que el Personaje (Guerrero) es parámetro.
	 * 
	 * @param caster
	 *            Personaje (Guerrero) a recibir el aumento de defensa.
	 * @param atacado
	 *            No se utiliza pero debe incluirse como parámetro ya que la
	 *            declaración del metodo en la clase padre lo contiene.
	 * @return Si el caster tiene suficiente energia para realizar aumento
	 *         devuelve un boolean true, caso contrario devuelve false.
	 */
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			caster.mejorarDefensa(caster.magia);
			return true;
		}
		return false;
	}

	// Ignorar Defensa
	/**
	 * <h3>Ignorar defensa</h3> Implementacion del método abstracto habilidad2
	 * declarado en la clase abstracta Casta
	 * 
	 * @param caster
	 *            De tipo Personaje encargado de obtener y setear energías.
	 * @param atacado
	 *            De tipo Peleable (no se utiliza)
	 * @return boolean
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			if (atacado.sufreDanioExtra()) {
				int defensaOriginal = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).perderDefensa();
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).mejorarDefensa(defensaOriginal);
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public int getBonusFuerza() {
		return 5;
	}

	@Override
	public int getBonusInteligencia() {
		return 0;
	}

	@Override
	public int getBonusDestreza() {
		return 0;
	}
}
