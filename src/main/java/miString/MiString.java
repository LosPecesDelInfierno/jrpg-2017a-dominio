package miString;
public class MiString {

	public static String join(String delimitador, Iterable<String> objetosIterable) {
		String str = "";
		for(String obj : objetosIterable) {
			str += (obj + delimitador);
		}
		return str;
	}
}