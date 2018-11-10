package hck.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.enums.JunctionMode;
import hck.services.Junction;
import hck.utils.Utils;

@RunWith(JUnitPlatform.class)
class JunctionTest {

	public static Junction j;
	public static Set<String> sym;

	@BeforeAll
	public static void setup() {
		j = new Junction();
		sym = new HashSet<String>();
		sym.add("%");
		sym.add("_");

	}

	@Test
	void ALL_JUNCTION__2w() {
		Utils.plTs("Junction test ALL_JUNCTION 2W - init ");
		ConcurrentSkipListSet<String> out = new ConcurrentSkipListSet<>();
		out.add("%casa%bau%");
		out.add("%casa%bau_");
		out.add("_casa%bau%");
		out.add("_casa%bau_");
		out.add("%casa_bau%");
		out.add("%casa_bau_");
		out.add("_casa_bau%");
		out.add("_casa_bau_");
		Junction.junction(JunctionMode.ALL_JUNCTION, sym, "casa", "bau").forEach(out::remove);
		assertTrue(out.size() == 0);
		Utils.plTs("Junction test ALL_JUNCTION 2W - Succeeded ");
	}

	@Test
	void ALL_JUNCTION__3w() {
		Utils.plTs("Junction test ALL_JUNCTION 3W - init ");
		ConcurrentSkipListSet<String> out = new ConcurrentSkipListSet<>();
		out.add("_casa%bau%miao%");
		out.add("_casa%bau%miao_");
		out.add("%casa%bau%miao%");
		out.add("%casa%bau%miao_");
		out.add("_casa%bau_miao%");
		out.add("_casa%bau_miao_");
		out.add("%casa%bau_miao%");
		out.add("_casa_bau%miao%");
		out.add("%casa%bau_miao_");
		out.add("_casa_bau%miao_");
		out.add("%casa_bau%miao%");
		out.add("_casa_bau_miao%");
		out.add("%casa_bau%miao_");
		out.add("_casa_bau_miao_");
		out.add("%casa_bau_miao%");
		out.add("%casa_bau_miao_");

		Junction.junction(JunctionMode.ALL_JUNCTION, sym, "casa", "bau", "miao").forEach(out::remove);
		assertTrue(out.size() == 0);
		Utils.plTs("Junction test ALL_JUNCTION 3W - Succeeded ");
	}

}
