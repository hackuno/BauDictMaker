package hck.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import hck.enums.UpLowMode;
import obj.Leet;

public class Metamorpher {

	private Leet leetDict = null;

	public Metamorpher(Leet leetDict) {
		this.leetDict = leetDict;
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

			if (leetDict!=null) {
				List<String> variants = leetDict.getLeet(s.substring(cycle, cycle + 1));
				if (variants != null && variants.size() > 0) {
					for (String v : variants) {
						String strLeet = s.substring(0, cycle) + v + s.substring(cycle + 1, s.length());
						upperLower_ALL_COMBO(strLeet, cycle, rez);
					}
				}
			}

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

		if (leetDict!=null) {
			List<String> variants = leetDict.getLeet(s.substring(0, 1));
			if (variants != null && variants.size() > 0) {
				for (String v : variants) {
					String strLeet = s.substring(0, 0) + v + s.substring(1, s.length());
					rez.add(strLeet.toString());
				}
			}
		}

	}

	public void upperLower_LAST(String s, Set<String> rez) {

		StringBuilder str = new StringBuilder(s);
		rez.add(str.toString());

		str.setCharAt(s.length() - 1, Character.toUpperCase(str.charAt(s.length() - 1)));
		rez.add(str.toString());

		if (leetDict!=null) {
			List<String> variants = leetDict.getLeet(s.substring(s.length() - 1, s.length()));
			if (variants != null && variants.size() > 0) {
				for (String v : variants) {
					String strLeet = s.substring(s.length() - 1, s.length()) + v;
					rez.add(strLeet.toString());
				}
			}
		}
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

		if (leetDict!=null) {
			List<String> variants = leetDict.getLeet(s.substring(0, 1));
			if (variants != null && variants.size() > 0) {
				for (String v : variants) {
					String strLeet = s.substring(0, 0) + v + s.substring(1, s.length());
					rez.add(strLeet.toString());
				}
			}
			variants = leetDict.getLeet(s.substring(s.length() - 1, s.length()));
			if (variants != null && variants.size() > 0) {
				for (String v : variants) {
					String strLeet = s.substring(s.length() - 1, s.length()) + v;
					rez.add(strLeet.toString());
				}
			}
		}

	}
}
