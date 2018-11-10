package obj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import hck.utils.Utils;

public class Leet {

	HashMap<String, List<String>> leetDict = new HashMap<>();

	public HashMap<String, List<String>> getLeetDict() {
		return leetDict;
	}

	public void setLeetDict(HashMap<String, List<String>> leetDict) {
		this.leetDict = leetDict;
	}

	public Leet() {
	}

	public Leet(HashMap<String, List<String>> leetDict) {
		this.leetDict = leetDict;
	}

	public Leet(File f) {
		try {
			if (f != null && f.isFile()) {
				String dict = "";
				BufferedReader bf = new BufferedReader(new FileReader(f));
				try {
					String lin = null;
					while ((lin = bf.readLine()) != null) {
						dict += lin;
					}
				} catch (Exception ee) {
					Utils.pl("Impossibile leggere il dizionario.");
				} finally {
					bf.close();
				}
				this.leetDict = Leet.buildHash(dict);
				return;
			}
		} catch (Exception e) {
		}
		Utils.pl("File not found - leet: "+f.getAbsolutePath());
	}

	public Leet(String leetRows) {
		this.leetDict = Leet.buildHash(leetRows);
	}

	public List<String> getLeet(String s) {
		return leetDict.get(s.toLowerCase());
	}

	public static HashMap<String, List<String>> buildHash(String rows) {

		HashMap<String, List<String>> dict = new HashMap<>();
		String[] line = rows.toLowerCase().split(";");
		for (String couple : line) {
			String[] leet = couple.split("=");
			if (leet.length == 2) {
				String index = leet[0];
				String[] vals = leet[1].split(",");
				if (vals.length > 0) {
					dict.put(index, Arrays.asList(vals));
				}

			}
		}
		return dict;

	}

	public boolean isValid() {
		return leetDict != null && !leetDict.isEmpty();
	}

}
