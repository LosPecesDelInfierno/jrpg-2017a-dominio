package dominio;

public class Item {
	private int id;
	private String nombre;
	private int idTipoItem;
	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciaRequerida;
//	private List<ModificadorItem> modificadores; TODO
	private String foto;

	public Item(int id, String nombre, int idTipoItem, int fuerzaRequerida, int destrezaRequerida,
			int inteligenciaRequerida, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.idTipoItem = idTipoItem;
		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdTipoItem() {
		return idTipoItem;
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

	public String getFoto() {
		return foto;
	}
}
