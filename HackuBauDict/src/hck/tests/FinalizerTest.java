package hck.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.services.Finalizer;
import hck.services.Junction;

@RunWith(JUnitPlatform.class)
class FinalizerTest {

	public static Junction j;
	public static Set<String> sym;

	@Test
	void finalizer_t1() {
		System.out.println("Finalizer test - init");
		Set<String> ctrl = new HashSet<String>();
		ctrl.add("test");
		Finalizer f = new Finalizer(ctrl);
		f.finalize("test");
		assertTrue(ctrl.size() == 0);
		System.out.println("Finalizer test - succeeded");

	}
}
