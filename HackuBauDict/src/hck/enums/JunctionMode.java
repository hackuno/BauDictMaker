package hck.enums;

public enum JunctionMode {

	NONE(0, "Symbols will not be tested", "Nessun simbolo verrà testato"), ALL_JUNCTION(1,
			"Symbols will be tested between all words and at the corner of the final result",
			"I simboli verranno messi come giunzione fra tutte le parole ed ai limiti della parola finale"), ALL_JUNCTION_2XCORNERS(
					2, "As ALL_JUNCTION but the corners will be 2x",
					"Come per ALL_JUNCTIONS ma con i simboli ai limiti doppi"), ALL_JUNCTION_1X2XCORNERS(3,
							"As ALL_JUNCTION + ALL_JUNCTION_2XCORNERS",
							"Come ALL_JUNCTIONS + ALL_JUNCTIONS_2XCORNERS"), ONLY_INSIDE(4,
									"Symbols will be tested only as junction between words",
									"I simboli verrano utilizzati solamente per unire le parole"), ONLY_CORNERS(5,
											"Symbols will be tested only at the corners of the final result",
											"I simboli verranno messi solamente ai limiti della parola finale"), ONLY_CORNERS2X(
													6, "As ONLY_CORNERS but 2X",
													"Come per ONLY_CORNERS ma con i simboli ai limiti doppi");

	private int value;
	private String descr;
	private String itaDescr;

	JunctionMode(int value, String descr, String itaDescr) {
		this.setValue(value);
		this.setDescr(descr);
		this.setItaDescr(itaDescr);
	}

	public static JunctionMode getFromValue(int value) {
		for (JunctionMode mode : values()) {
			if (mode.getValue() == value) {
				return mode;
			}
		}
		return null;
	}

	public static JunctionMode getFromValue(String val) {
		try {
			int value = Integer.valueOf(val);
			for (JunctionMode mode : values()) {
				if (mode.getValue() == value) {
					return mode;
				}
			}
		} catch (Exception e) {

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
