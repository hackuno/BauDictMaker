package hck.enums;

public enum LOC {

	IT(1, "Italiano"), EN(2, "English");

	private int value;
	private String descr;

	LOC(int value, String descr) {
		this.value = value;
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static LOC getFromValue(int value) {
		for (LOC mode : values()) {
			if (mode.getValue() == value) {
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
