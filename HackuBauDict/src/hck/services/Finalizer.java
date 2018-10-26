package hck.services;

import java.util.Set;

public class Finalizer {

	public Set<String> ctrl = null;

	public Finalizer() {
	}

	public Finalizer(Set<String> ctrl) {
		this.ctrl = ctrl;
	}

	public synchronized void finalize(String s) {
		
		if (ctrl != null) {
			ctrl.remove(s);
		}
		else
		{
			System.out.println(s);
		}

	}

}
