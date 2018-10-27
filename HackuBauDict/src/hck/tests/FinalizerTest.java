package hck.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.services.Finalizer;
import hck.services.Junction;
import hck.utils.Utils;

@RunWith(JUnitPlatform.class)
class FinalizerTest {

	public static Junction j;
	public static Set<String> sym;

	@Test
	void finalizer_t1() {
		Utils.plTs("Finalizer test - init");
		ConcurrentSkipListSet<String> ctrl = new ConcurrentSkipListSet<String>();
		ctrl.add("test");
		Finalizer f = new Finalizer(ctrl);
		f.finalize("test");
		assertTrue(ctrl.size() == 0);
		Utils.plTs("Finalizer test - Succeeded ");
	}

}
