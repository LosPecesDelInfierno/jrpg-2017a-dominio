package dominio;

public class Item {
	private int id;
	private int bonoAtaque;
	private int bonoDefensa;
	private int bonoMagia;
	private int bonoSalud;
	private int bonoEnergia;
	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciaRequerida;
	private String nombre;
	private String foto;
	
	public Item(int id, int bonoAtaque, int bonoDefensa, int bonoMagia, int bonoSalud, int bonoEnergia,
			int fuerzaRequerida, int destrezaRequerida, int inteligenciaRequerida, String nombre, String foto) {
		this.id = id;
		this.bonoAtaque = bonoAtaque;
		this.bonoDefensa = bonoDefensa;
		this.bonoMagia = bonoMagia;
		this.bonoSalud = bonoSalud;
		this.bonoEnergia = bonoEnergia;
		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
		this.nombre = nombre;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public int getBonoAtaque() {
		return bonoAtaque;
	}

	public int getBonoDefensa() {
		return bonoDefensa;
	}

	public int getBonoMagia() {
		return bonoMagia;
	}

	public int getBonoSalud() {
		return bonoSalud;
	}

	public int getBonoEnergia() {
		return bonoEnergia;
	}

	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}

	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFoto() {
		return foto;
	}
}
