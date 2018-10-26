package hck.enums;

public enum UpLowMode {

	NONE(0,"No word modification will be tested","Nessun carattere delle parole verrà modificato rispetto all'input"),
	ALL_COMBO(1, "All possible combination of upper/lower letters","Tutte le possibili combinazioni fra maiuscole e minuscole"), 
	FIRST_LAST(2,"First and Last character of any words will be tested as upper and lower in any possible combination","Il primo e l'ultimo carattere di ogni parola verrà testato sia come maiuscolo che come minuscolo"), 
	FIRST(3, "First character of any words will be tested as upper and lower","Il primo carattere di ogni parola verrà testato come maiuscolo e minuscolo"), 
	LAST(4, "Last character of any words will be tested as upper and lower","L'ultimo carattere di ogni parola verrà testato come maiuscolo e minuscolo"); 
	
	
	private int value;
	private String descr;
	private String itaDescr;

	UpLowMode(int value, String descr, String itaDescr) {
		this.setValue(value);
		this.setDescr(descr);
		this.setItaDescr(itaDescr);
	}

	public static UpLowMode getFromValue(int value) {
		for (UpLowMode mode : values()) {
			if (mode.getValue() == value) {
				return mode;
			}
		}
		return null;
	}
	
	public static UpLowMode getFromValue(String val) {
		int value = Integer.valueOf(val);
		for (UpLowMode mode : values()) {
			if (mode.getValue() == value) {
				return mode;
			}
		}
		return null;
	}

	public String getDescr() {
		return descr;
	}

	private void setDescr(String descr) {
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getItaDescr() {
		return itaDescr;
	}

	public void setItaDescr(String itaDescr) {
		this.itaDescr = itaDescr;
	}
}
