package hck.services;

import java.util.concurrent.ConcurrentSkipListSet;

import hck.utils.Utils;

public class Finalizer {

	public ConcurrentSkipListSet<String> ctrl = null;

	public Finalizer() {
	}

	public Finalizer(ConcurrentSkipListSet<String> ctrl) {
		this.ctrl = ctrl;
	}

	public void finalize(String s) {

		if (ctrl != null) {
			ctrl.remove(s);
		} else {
			Utils.pl(s);
		}

	}

}
