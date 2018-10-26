package hck.services;

import java.util.Set;
import java.util.stream.Stream;

import hck.enums.JunctionMode;

public class Junction {

	public Junction() {
	}

	public static Stream<String> junction(JunctionMode jmode, Set<String> sym, String p1) {
		if (sym == null || sym.isEmpty()) {
			jmode = JunctionMode.NONE;
		}
		switch (jmode) {
		case ALL_JUNCTION: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + s2));
		}
		case ALL_JUNCTION_2XCORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + s2 + s2));
		}
		case ALL_JUNCTION_1X2XCORNERS: {
			Stream<String> str1 = junction(JunctionMode.ALL_JUNCTION, sym, p1);
			Stream<String> str2 = junction(JunctionMode.ALL_JUNCTION_2XCORNERS, sym, p1);
			return Stream.concat(str1, str2);
		}
		case ONLY_CORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + s2));
		}
		case ONLY_CORNERS2X: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + s2 + s2));
		}
		case ONLY_INSIDE: {
			return sym.parallelStream().map(s1 -> p1 + s1);
		}
		case NONE: {
			return Stream.of(p1);
		}
		default:
			return Stream.of(p1);

		}

	}

	public static Stream<String> junction(JunctionMode jmode, Set<String> sym, String p1, String p2) {
		if (sym == null || sym.isEmpty()) {
			jmode = JunctionMode.NONE;
		}
		switch (jmode) {
		case ALL_JUNCTION: {
			return sym.parallelStream().flatMap(
					s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream().map(s3 -> s1 + p1 + s2 + p2 + s3)));
		}
		case ALL_JUNCTION_2XCORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream()
					.flatMap(s2 -> sym.parallelStream().map(s3 -> s1 + s1 + p1 + s1 + p2 + s3 + s3)));
		}
		case ALL_JUNCTION_1X2XCORNERS: {
			Stream<String> str1 = junction(JunctionMode.ALL_JUNCTION, sym, p1, p2);
			Stream<String> str2 = junction(JunctionMode.ALL_JUNCTION_2XCORNERS, sym, p1, p2);
			return Stream.concat(str1, str2);
		}
		case ONLY_CORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + p2 + s2));
		}
		case ONLY_CORNERS2X: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + p2 + s2 + s2));
		}
		case ONLY_INSIDE: {
			return sym.parallelStream().map(s1 -> p1 + s1 + p2);
		}
		case NONE: {
			return Stream.of(p1 + p2);
		}
		default:
			return Stream.of(p1 + p2);

		}

	}

	public static Stream<String> junction(JunctionMode jmode, Set<String> sym, String p1, String p2, String p3) {
		if (sym == null || sym.isEmpty()) {
			jmode = JunctionMode.NONE;
		}
		switch (jmode) {
		case ALL_JUNCTION: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream()
					.flatMap(s3 -> sym.parallelStream().map(s4 -> s1 + p1 + s2 + p2 + s3 + p3 + s4))));
		}
		case ALL_JUNCTION_2XCORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream()
					.flatMap(s3 -> sym.parallelStream().map(s4 -> s1 + s1 + p1 + s1 + p2 + s3 + p3 + s4 + s4))));
		}
		case ALL_JUNCTION_1X2XCORNERS: {
			Stream<String> str1 = junction(JunctionMode.ALL_JUNCTION, sym, p1, p2, p3);
			Stream<String> str2 = junction(JunctionMode.ALL_JUNCTION_2XCORNERS, sym, p1, p2, p3);
			return Stream.concat(str1, str2);
		}
		case ONLY_CORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + p2 + p3 + s2));
		}
		case ONLY_CORNERS2X: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + p2 + p3 + s2 + s2));
		}
		case ONLY_INSIDE: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> p1 + s1 + p2 + s2 + p3));
		}
		case NONE: {
			return Stream.of(p1 + p2 + p3);
		}
		default:
			return Stream.of(p1 + p2 + p3);

		}

	}

	public static Stream<String> junction(JunctionMode jmode, Set<String> sym, String p1, String p2, String p3,
			String p4) {
		if (sym == null || sym.isEmpty()) {
			jmode = JunctionMode.NONE;
		}
		switch (jmode) {
		case ALL_JUNCTION: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream()
					.flatMap(s2 -> sym.parallelStream().flatMap(s3 -> sym.parallelStream().flatMap(
							s4 -> sym.parallelStream().map(s5 -> s1 + p1 + s2 + p2 + s3 + p3 + s4 + p4 + s5)))));
		}
		case ALL_JUNCTION_2XCORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream()
					.flatMap(s2 -> sym.parallelStream().flatMap(s3 -> sym.parallelStream().flatMap(s4 -> sym
							.parallelStream().map(s5 -> s1 + s1 + p1 + s1 + p2 + s3 + p3 + s4 + p4 + s5 + s5)))));
		}
		case ALL_JUNCTION_1X2XCORNERS: {
			Stream<String> str1 = junction(JunctionMode.ALL_JUNCTION, sym, p1, p2, p3, p4);
			Stream<String> str2 = junction(JunctionMode.ALL_JUNCTION_2XCORNERS, sym, p1, p2, p3, p4);
			return Stream.concat(str1, str2);
		}
		case ONLY_CORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + p2 + p3 + p4 + s2));
		}
		case ONLY_CORNERS2X: {
			return sym.parallelStream()
					.flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + p2 + p3 + p4 + s2 + s2));
		}
		case ONLY_INSIDE: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream()
					.flatMap(s2 -> sym.parallelStream().map(s3 -> p1 + s1 + p2 + s2 + p3 + s3 + p4)));
		}
		case NONE: {
			return Stream.of(p1 + p2 + p3 + p4);
		}
		default:
			return Stream.of(p1 + p2 + p3 + p4);

		}

	}

	public static Stream<String> junction(JunctionMode jmode, Set<String> sym, String p1, String p2, String p3,
			String p4, String p5) {
		if (sym == null || sym.isEmpty()) {
			jmode = JunctionMode.NONE;
		}
		switch (jmode) {
		case ALL_JUNCTION: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream()
					.flatMap(s3 -> sym.parallelStream().flatMap(s4 -> sym.parallelStream().flatMap(s5 -> sym
							.parallelStream().map(s6 -> s1 + p1 + s2 + p2 + s3 + p3 + s4 + p4 + s5 + p5 + s6))))));
		}
		case ALL_JUNCTION_2XCORNERS: {
			return sym.parallelStream()
					.flatMap(s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream().flatMap(s3 -> sym
							.parallelStream().flatMap(s4 -> sym.parallelStream().flatMap(s5 -> sym.parallelStream()
									.map(s6 -> s1 + s1 + p1 + s1 + p2 + s3 + p3 + s4 + p4 + s5 + p5 + s6 + s6))))));
		}
		case ALL_JUNCTION_1X2XCORNERS: {
			Stream<String> str1 = junction(JunctionMode.ALL_JUNCTION, sym, p1, p2, p3, p4, p5);
			Stream<String> str2 = junction(JunctionMode.ALL_JUNCTION_2XCORNERS, sym, p1, p2, p3, p4, p5);
			return Stream.concat(str1, str2);
		}
		case ONLY_CORNERS: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + p1 + p2 + p3 + p4 + p5 + s2));
		}
		case ONLY_CORNERS2X: {
			return sym.parallelStream()
					.flatMap(s1 -> sym.parallelStream().map(s2 -> s1 + s1 + p1 + p2 + p3 + p4 + p5 + s2 + s2));
		}
		case ONLY_INSIDE: {
			return sym.parallelStream().flatMap(s1 -> sym.parallelStream().flatMap(s2 -> sym.parallelStream()
					.flatMap(s3 -> sym.parallelStream().map(s4 -> p1 + s1 + p2 + s2 + p3 + s3 + p4 + s4 + p5))));
		}
		case NONE: {
			return Stream.of(p1 + p2 + p3 + p4 + p5);
		}
		default:
			return Stream.of(p1 + p2 + p3 + p4 + p5);

		}

	}

}
