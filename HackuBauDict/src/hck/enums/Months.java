package hck.enums;

public enum Months {

	GENNAIO("january", "gennaio"), FEBBRAIO("february", "febbraio"), MARZO("march", "marzo"), APRILE("april",
			"aprile"), MAGGIO("may", "maggio"), GIUGNO("june", "giugno"), LUGLIO("july", "luglio"), AGOSTO("august",
					"agosto"), SETTEMBRE("September", "Settembre"), OTTOBRE("October",
							"ottobre"), NOVEMBRE("november", "novembre"), DICEMBRE("december", "dicembre");

	private String en;
	private String it;

	Months(String en, String it) {
		this.en = en;
		this.it = it;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getIt() {
		return it;
	}

	public void setIt(String it) {
		this.it = it;
	}

	public String getStr(Lang ln) {
		switch (ln) {
		case EN: {
			return getEn();
		}
		case IT: {
			return getIt();
		}
		default:
			return null;
		}
	}

	public String getAndSubstring(Lang ln, int sub) {
		String str = getStr(ln);
		if (str.length() < sub) {
			return str;
		} else {
			return str.substring(0, sub);
		}
	}
}
