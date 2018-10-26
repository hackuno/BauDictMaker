package hck.enums;

public enum LANG {

	IT(1, "Italiano"), EN(2, "English");

	private int value;
	private String descr;

	LANG(int value, String descr) {
		this.value = value;
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static LANG getFromValue(int value) {
		for (LANG mode : values()) {
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
