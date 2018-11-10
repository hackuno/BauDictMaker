package hck.enums;

public enum PreprocessorAdds {

	CURR_YEAR(1,1,"Add current year as 2018 and 18","Aggiunge l'anno corrente come 2018 e 18"),
	PREV_YEAR(1,1,"Add previous year as 2017 and 17","Aggiunge l'anno precedente come 2017 e 17"),
	MONTH_SINGLE_ZERO(3,2,"Add month like 1,2,3...","Aggiungi i mesi come 1,2,3..."),
	MONTH_DOUBLE_ZERO(4,2,"Add month as 01,02,03 ...","Aggiungi i mesi come 01,02,03 ..."),
	MONTH_TXT_3_IT(5,2,"Add month as Gen Feb ...","Aggiungi i mesi come Gen Feb ..."),
	MONTH_TXT_3_EN(6,2,"Add month as Jan Feb ...","Aggiungi i mesi come Jan Feb ..."),
	MONTH_TXT_4_IT(7,2,"Add month as Genn Febb ...","Aggiungi i mesi come Genn Febb ..."),
	MONTH_TXT_4_EN(8,2,"Add month as Janu Febr ...","Aggiungi i mesi come Janu Febr ..."),
	NUMBERS0_9(9,4,"Add numbers from 0 to 9 as 0,1,2,...","Aggiunge i numeri 0 a 9 come 0,1,2,..."),
	NUMBERS0_9_DOUBLE(10,4,"Add numbers from 0 to 9 as 00,01,02,...","Aggiunge i numeri 0 a 9 come 00,01,02,..."),
	NUMBERS1_31(11,4,"Add numbers from 0 to 31 as 0,1,2,...","Aggiunge i numeri 0 a 31 come 0,1,2,..."),
	NUMBERS1_31_DOUBLE(12,4,"Add numbers from 0 to 31 as 00,01,02,...","Aggiunge i numeri 0 a 31 come 00,01,02,...");

	private int value;
	private int group;
	private String descr;
	private String itaDescr;

	PreprocessorAdds(int value, int group,String descr, String itaDescr) {
		this.setValue(value);
		this.setGroup(group);
		this.setDescr(descr);
		this.setItaDescr(itaDescr);
	}

	public static PreprocessorAdds getFromValue(int value) {
		for (PreprocessorAdds mode : values()) {
			if (mode.getValue() == value) {
				return mode;
			}
		}
		return null;
	}

	public static PreprocessorAdds getFromValue(String val) {
		try {
			int value = Integer.valueOf(val);
			for (PreprocessorAdds mode : values()) {
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	@Override
	public String toString()
	{
		return this.name();
	}
}
