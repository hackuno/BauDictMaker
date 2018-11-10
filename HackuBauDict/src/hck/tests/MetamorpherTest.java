package hck.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.enums.UpLowMode;
import hck.services.Metamorpher;
import hck.utils.Utils;
import obj.Leet;

@RunWith(JUnitPlatform.class)
class MetamorpherTest {

	public static Metamorpher m;
	public static Leet leetDict = null;

	@BeforeAll
	public static void setup() {
		leetDict = new Leet("a=4;b=3,8;");
		m = new Metamorpher(leetDict);
	}

	@Test
	void leet() {
		Utils.pl("ATTENTION: LEET TEST NEED TO BE WRITE CORRECTLY");
		m.upperLower("bau", UpLowMode.ALL_COMBO).forEach(Utils::pl);
		Utils.pl("ATTENTION: LEET TEST NEED TO BE WRITE CORRECTLY");
	}

	@Test
	void upperLower() {
		Utils.plTs("UpperLower test - init ");
		ConcurrentSkipListSet<String> out = new ConcurrentSkipListSet<>();
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
		Utils.plTs("UpperLower test - Succeeded ");
	}

}
