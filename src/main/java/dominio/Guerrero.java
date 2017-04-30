package dominio;

/**
 * 
 * Clase que define a un tipo Guerrero, la misma hereda de la clase 
 * abstracta Casta por lo que se definen los métodos abstractos declarados en Casta y 
 * se define al nombreCasta como "Guerrero".
 *
 */
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double danio_crit) {
		super(prob_crit, evasion, danio_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	// Ataque Doble
	/**
	 * <h3><u>Ataque Doble</u></h3>
	 * Implementacion del método abstracto habilidad1 declarado en la clase abstracta Casta.<p>
	 * En este caso el método es el encargado de producir un Ataque Doble 
	 * por parte de un guerrero hacia un objeto Peleable.<br>
	 * Nótese que en este caso el Personaje (Guerrero) que ataca es parámetro.
	 * @param caster Objeto de tipo Personaje encargado del ataque.
	 * @param atacado Objeto de tipo Peleable a ser atacado.
	 * @return Si el caster tiene suficiente energia para realizar el ataque devuelve un boolean true, caso 
	 * contrario devuelve false.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	// Aumentar Defensa
	/**
	 * <h3><u>Aumentar Defensa</u></h3>
	 * Implementacion del método abstracto habilidad2 declarado en la clase abstracta Casta.<p>
	 * En este caso este método es el encargado de aumentar la defensa de un caster de tipo Personaje (Guerrero).<br>
	 * Nótese que el Personaje (Guerrero) es parámetro.
	 * @param caster Personaje (Guerrero) a recibir el aumento de defensa.
	 * @param atacado No se utiliza pero debe incluirse como parámetro ya que la declaración del metodo en la clase padre lo contiene.
	 * @return Si el caster tiene suficiente energia para realizar aumento devuelve un boolean true, caso 
	 * contrario devuelve false.
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	// Ignorar Defensa
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
