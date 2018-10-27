package hck.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import hck.enums.UpLowMode;

public class Metamorpher {

	// private boolean leet = false;

	public Metamorpher(boolean leet) {
		// this.leet = leet;
	}

	public Metamorpher() {
	}

	public Stream<String> upperLower(String s, UpLowMode mode) {
		Set<String> lista = new HashSet<>();
		switch (mode) {
		case ALL_COMBO: {
			s = s.toLowerCase();
			upperLower_ALL_COMBO(s, 0, lista);
			break;
		}
		case FIRST: {
			s = s.toLowerCase();
			upperLower_FIRST(s, lista);
			break;
		}
		case LAST: {
			s = s.toLowerCase();
			upperLower_LAST(s, lista);
			break;
		}
		case FIRST_LAST: {
			s = s.toLowerCase();
			upperLower_FIRST_LAST(s, lista);
			break;
		}
		case NONE: {
			lista.add(s);
			break;
		}
		}
		return lista.parallelStream();
	}

	public void upperLower_ALL_COMBO(String s, Integer cycle, Set<String> rez) {

		StringBuilder str = new StringBuilder(s);

		if (cycle < s.length()) {

			String strNoup = s;
			str.setCharAt(cycle, Character.toUpperCase(str.charAt(cycle)));
			String strUp = str.toString();
			cycle++;
			upperLower_ALL_COMBO(strNoup, cycle, rez);
			upperLower_ALL_COMBO(strUp, cycle, rez);
		} else {
			rez.add(str.toString());
		}
	}

	public void upperLower_FIRST(String s, Set<String> rez) {

		StringBuilder str = new StringBuilder(s);
		rez.add(str.toString());

		str.setCharAt(0, Character.toUpperCase(str.charAt(0)));
		rez.add(str.toString());
	}

	public void upperLower_LAST(String s, Set<String> rez) {

		StringBuilder str = new StringBuilder(s);
		rez.add(str.toString());

		str.setCharAt(s.length() - 1, Character.toUpperCase(str.charAt(s.length() - 1)));
		rez.add(str.toString());
	}

	public void upperLower_FIRST_LAST(String s, Set<String> rez) {

		StringBuilder str = new StringBuilder(s);
		rez.add(str.toString());

		StringBuilder strFirst = new StringBuilder(s);
		strFirst.setCharAt(0, Character.toUpperCase(strFirst.charAt(0)));
		rez.add(strFirst.toString());

		StringBuilder strLast = new StringBuilder(s);
		strLast.setCharAt(s.length() - 1, Character.toUpperCase(strLast.charAt(s.length() - 1)));
		rez.add(strLast.toString());

		strLast.setCharAt(0, Character.toUpperCase(strLast.charAt(0)));
		rez.add(strLast.toString());
	}
}
