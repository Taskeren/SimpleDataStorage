package ren.taske.data.util;

public class ObjectUtil {

	public static <T> T defaultIfNull(T t, T defaultValue) {
		return t == null ? defaultValue : t;
	}
	
}
