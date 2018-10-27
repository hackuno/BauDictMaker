package hck.enums;

public enum Lang {

	IT(1, "Italiano"), EN(2, "English");

	private int value;
	private String descr;

	Lang(int value, String descr) {
		this.value = value;
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Lang getFromValue(int value) {
		for (Lang mode : values()) {
			if (mode.getValue() == value) {
				return mode;
			}
		}
		return null;
	}

	public static Lang getFromValue(String val) {
		for (Lang mode : values()) {
			if (mode.getDescr().equals(val) || mode.toString().equals(val)) {
				return mode;
			}
		}
		return null;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
