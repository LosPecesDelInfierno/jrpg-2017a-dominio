package dominio;

public class AtributoModificable {
	public static final int FUERZA = 1;
	public static final int INTELIGENCIA = 2;
	public static final int DESTREZA = 3;
	public static final int SALUD = 4;
	public static final int ENERGIA = 5;
	
	public AtributoModificable() { }

	public static String getNombre(final int value) {
		switch (value) {
		case FUERZA:
			return "Fuerza";
		case INTELIGENCIA:
			return "Inteligencia";
		case DESTREZA:
			return "Destreza";
		case SALUD:
			return "Salud";
		case ENERGIA:
			return "Energía";
		default:
			return "Desconocido";
		}
	}
}
