package hck.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.enums.UpLowMode;
import hck.services.Metamorpher;

@RunWith(JUnitPlatform.class)
class MetamorpherTest {

	public static Metamorpher m;

	@BeforeAll
	public static void setup() {
		System.out.println("Metamorpher Tests");
		m = new Metamorpher();
	}

	@Test
	void upperLower() {
		Set<String> out = new HashSet<String>();
		out.add("abcd");
		out.add("abcD");
		out.add("abCd");
		out.add("abCD");
		out.add("aBcd");
		out.add("aBcD");
		out.add("aBCd");
		out.add("aBCD");
		out.add("ABcd");
		out.add("ABcD");
		out.add("ABCd");
		out.add("ABCD");
		out.add("Abcd");
		out.add("AbcD");
		out.add("AbCd");
		out.add("AbCD");

		m.upperLower("abcd", UpLowMode.ALL_COMBO).forEach(x -> out.remove(x));
		assertTrue(out.size() == 0);
	}

}
