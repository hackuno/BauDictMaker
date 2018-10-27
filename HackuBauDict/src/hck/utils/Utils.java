package hck.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	private static SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss:sss");

	public static void printTitle() {
		System.out.println("BAU DICT MAKER V-0.1bau");
	}

	public static void pl(String s) {
		System.out.println(s);
	}

	public static void p(String s) {
		System.out.print(s);
	}

	public static void plTs(String s) {
		p(s);
		pl(sdfTime.format(new Date()));
	}

}
