package ren.taske.data.util;

public class ParseUtil {

	/**
	 * Safely parse string into integer.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Integer parseInteger(String str) {
		try {
			return Integer.parseInt(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Safely parse string into double.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Double parseDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Safely parse string into float.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Float parseFloat(String str) {
		try {
			return Float.parseFloat(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Safely parse string into long.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Long parseLong(String str) {
		try {
			return Long.parseLong(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Safely parse string into short.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Short parseShort(String str) {
		try {
			return Short.parseShort(str);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Safely parse string into boolean.<br>
	 * However, Boolean.parseBoolean won't throw anything.
	 * @param str the string to parse
	 * @return the result or null
	 */
	public static Boolean parseBoolean(String str) {
		try {
			return Boolean.parseBoolean(str);
		} catch(Exception e) {
			return null;
		}
	}
	
}
