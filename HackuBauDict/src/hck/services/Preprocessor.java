package hck.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hck.enums.Lang;
import hck.enums.Months;
import hck.enums.PreprocessorAdds;

public class Preprocessor {

	List<PreprocessorAdds> preproc = new ArrayList<PreprocessorAdds>();
	HashMap<Integer, Set<String>> hash = new HashMap<>();

	public Preprocessor(PreprocessorAdds... preproc) {
		this.preproc = Arrays.asList(preproc);
	}

	public Preprocessor(List<PreprocessorAdds> preproc) {
		this.preproc = preproc;
	}

	public List<List<String>> getExtraLists() {
		List<List<String>> result = new ArrayList<>();
		for (PreprocessorAdds pre : preproc) {
			switch (pre) {
			case MONTH_DOUBLE_ZERO:
				addNumbers(true, 1, 12, pre);
				break;
			case MONTH_SINGLE_ZERO:
				addNumbers(false, 1, 12, pre);
				break;
			case MONTH_TXT_3_EN:
				addMonthsTxt(3, Lang.EN, pre);
				break;
			case MONTH_TXT_3_IT:
				addMonthsTxt(3, Lang.IT, pre);
				break;
			case MONTH_TXT_4_EN:
				addMonthsTxt(4, Lang.EN, pre);
				break;
			case MONTH_TXT_4_IT:
				addMonthsTxt(4, Lang.IT, pre);
				break;
			case PREV_YEAR:
				addPrevYear(Calendar.getInstance(), pre);
				break;
			case CURR_YEAR:
				addCurrYear(Calendar.getInstance(), pre);
				break;
			case NUMBERS1_31:
				addNumbers(false, 1, 31, pre);
				break;
			case NUMBERS1_31_DOUBLE:
				addNumbers(true, 1, 31, pre);
				break;
			case NUMBERS0_9:
				addNumbers(false, 0, 9, pre);
				break;
			case NUMBERS0_9_DOUBLE:
				addNumbers(false, 0, 9, pre);
				break;
			default:
				break;
			}

		}

		for (Set<String> list : hash.values()) {
			List<String> lista = new ArrayList<>();
			lista.addAll(list);
			result.add(lista);
		}

		return result;

	}

	private void addCurrYear(Calendar cal, PreprocessorAdds pre) {
		Set<String> lista = new HashSet<>();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		lista.add(year);
		lista.add(year.substring(2, year.length()));
		addToHash(lista, pre.getGroup());

	}

	private void addPrevYear(Calendar cal, PreprocessorAdds pre) {
		Set<String> lista = new HashSet<>();
		String year = String.valueOf(cal.get(Calendar.YEAR) - 1);
		lista.add(year);
		lista.add(year.substring(2, year.length()));
		addToHash(lista, pre.getGroup());

	}

	private void addNumbers(boolean doubleZero, Integer from, Integer to, PreprocessorAdds pre) {
		Set<String> lista = new HashSet<>();
		if (doubleZero) {
			for (int i = from; i <= to; i++)
				lista.add(String.format("%02d", i));
		} else {
			for (int i = from; i <= to; i++)
				lista.add(i + "");
		}
		addToHash(lista, pre.getGroup());
	}

	private void addMonthsTxt(int i, Lang ln, PreprocessorAdds pre) {
		Set<String> lista = new HashSet<>();
		for (Months m : Months.values()) {
			lista.add(m.getAndSubstring(ln, i));
		}
		addToHash(lista, pre.getGroup());

	}

	private void addToHash(Set<String> val, Integer key) {
		Set<String> temp = hash.get(key);
		if (temp == null) {
			hash.put(key, val);
		} else {
			temp.addAll(val);
			hash.put(key, temp);
		}
	}

}
