package utils;

public class PostUtils {
	public static String urlFriendler4Titles(String title) {
		title = title.toLowerCase();
		title = title.replace(" ", "_");
		return title;
	}
	public static String titleFriendler4Titles(String title) {
		title = title.substring(0, 1).toUpperCase()+title.substring(1);
		title = title.replace("_", " ");
		return title;
	}
}
