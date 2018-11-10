package hck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import hck.enums.JunctionMode;
import hck.enums.Lang;
import hck.enums.PreprocessorAdds;
import hck.enums.UI;
import hck.enums.UpLowMode;
import hck.io.PropertiesLoader;
import hck.services.Preprocessor;
import hck.services.Shuffler;
import hck.utils.Utils;
import obj.Leet;

public class Launcher {

	private Shuffler shuffler = null;
	private Lang loc = Lang.IT;
	private Properties props = null;
	private Set<String> sym = new HashSet<String>();
	private List<List<String>> lista = new ArrayList<>();
	private UpLowMode ul = UpLowMode.NONE;
	private JunctionMode j = JunctionMode.NONE;
	private File symbols = null;
	private File blocks = null;
	private Leet leetDict = null;
	private int cardinality = 1;
	private String test = null;
	private List<PreprocessorAdds> preprocessors = null;

	public void launch(String[] args) {

		loadDefaultProperties();

		if (args.length == 0) {
			UI.MANUAL.print(loc);
			System.exit(0);
		} else {

			List<String> listaCmd = new ArrayList<>();
			listaCmd.add("manual");
			listaCmd.add("man");
			listaCmd.add("help");
			listaCmd.add("h");
			listaCmd.add("m");

			if (listaCmd.contains(args[0].toLowerCase())) {
				UI.MANUAL.print(loc);
			}
			if (args[0].equals("guided")) {
				newbyMode();
			} else if (args[0].equals("bau")) {
				cmd(args);
			}
		}

	}

	private void cmd(String[] args) {

		initArgs(args);

		if (lista.isEmpty()) {
			Utils.pl("No words block founded in: " + blocks);
			Utils.pl("Exit program");
			System.exit(0);
		}
		launch(cardinality, ul, j, test, sym, leetDict, lista);
	}

	private void loadDefaultProperties() {
		props = PropertiesLoader.load();
		lista = new ArrayList<>();
		ul = UpLowMode.NONE;
		j = JunctionMode.NONE;
		symbols = null;
		blocks = null;
		leetDict = null;
		cardinality = 1;
		test = null;
		loc = Lang.IT;
		preprocessors = null;

		if (props != null) {

			Object ln = props.get("lang");
			if (ln != null && StringUtils.isNotBlank(ln.toString())) {

				Lang lng = Lang.getFromValue(ln.toString());
				if (lng != null) {
					loc = lng;
				}
			}

			Object ulw = props.get("uplow");
			if (ulw != null && StringUtils.isNotBlank(ulw.toString())) {

				UpLowMode ulProp = UpLowMode.getFromValue(ulw.toString());
				if (ulProp != null) {
					ul = ulProp;
				}
			}

			Object preproc = props.get("preprocessors");
			if (preproc != null && StringUtils.isNotBlank(preproc.toString())) {
				preprocessors = new ArrayList<>();
				String[] list = preproc.toString().split("#");
				if (list.length > 0) {
					for (String s : list) {
						PreprocessorAdds pre = PreprocessorAdds.getFromValue(s.toString());
						if (pre != null) {
							preprocessors.add(pre);
						}
					}
				}

			}

			Object crd = props.get("card");

			if (crd != null && StringUtils.isNotBlank(crd.toString())) {

				try {
					Integer cardProp = Integer.valueOf(crd.toString());
					if (cardProp != null) {
						cardinality = cardProp;
					}
				} catch (Exception e) {
					Utils.pl("Errore nella lettura del default della property \"card\" dal file.");
				}
			}

			Object jnc = props.get("junct");
			if (jnc != null) {
				if (StringUtils.isNotBlank(jnc.toString())) {

					JunctionMode jProp = JunctionMode.getFromValue(jnc.toString());
					if (jProp != null) {
						j = jProp;
					}
				}
			}

			Object symF = props.get("sym-file");
			if (symF != null && StringUtils.isNotBlank(symF.toString())) {
				try {
					File f = new File(symF.toString());
					if (f != null && f.isFile()) {
						symbols = f;
					}
				} catch (Exception e) {
					Utils.pl("File dei simboli non trovato.");
				}
			}

			Object leetF = props.get("leet-dict");
			if (leetF != null && StringUtils.isNotBlank(leetF.toString())) {
				try {
					File f = new File(leetF.toString());
					leetDict = new Leet(f);
				} catch (Exception e) {
					Utils.pl("File dizionario leet non trovato.");
				}

			}

			Object blkF = props.get("blocks-dir");

			if (blkF != null && StringUtils.isNotBlank(blkF.toString())) {
				try {
					File f = new File(blkF.toString());
					if (f != null && f.isDirectory()) {
						blocks = f;
					}
				} catch (Exception e) {
					Utils.pl("Errore nella lettura del default della property \"blocks-dir\" dal file.");
				}
			}
		}

	}

	private void initArgs(String[] args) {

		Utils.pl("\nParsing args:");

		for (String a : args) {
			Utils.pl(a);
			try {
				String[] cmd = a.split("=");
				if (cmd.length > 0) {
					try {
						switch (cmd[0]) {
						case "uplow": {
							ul = null;
							ul = UpLowMode.getFromValue(cmd[1]);
							break;
						}
						case "junct": {
							j = null;
							j = JunctionMode.getFromValue(cmd[1]);
							break;
						}
						case "card": {
							cardinality = -1;
							cardinality = Integer.valueOf(cmd[1]);
							break;
						}
						case "preproc": {
							preprocessors = new ArrayList<>();
							String[] list = cmd[1].split("#");
							if (list.length > 0) {
								for (String s : list) {
									PreprocessorAdds pre = PreprocessorAdds.getFromValue(s.toString());
									if (pre != null) {
										preprocessors.add(pre);
									}
								}
							}
						}
						case "sym-file": {
							symbols = null;
							symbols = new File(cmd[1]);
							break;
						}
						case "blocks-dir": {
							blocks = null;
							blocks = new File(cmd[1]);
							break;
						}
						case "leet-dict": {
							leetDict = null;
							File fl = new File(cmd[1]);
							leetDict = new Leet(fl);
							break;
						}

						case "test-word": {
							test = null;
							test = cmd[1];
							break;
						}
						default:break;
						}
					} catch (Exception ee) {

					}

				}
			} catch (Exception e) {
				Utils.pl("Parametro non riconosciuto: " + a);
			}
		}
		if (symbols != null) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(symbols));
				String st;
				while ((st = br.readLine()) != null) {
					sym.add(st);
				}
				br.close();
			}

			catch (Exception e) {
				Utils.pl("Non sono riuscito a trovare il file di input dei simboli");
			}
		}

		if (blocks != null) {
			try {
				for (File f : blocks.listFiles()) {
					try {
						List<String> block = new ArrayList<>();
						BufferedReader br = new BufferedReader(new FileReader(f));
						String st;
						while ((st = br.readLine()) != null) {
							block.add(st);
						}
						br.close();
						lista.add(block);
					}

					catch (Exception e) {
						Utils.pl("Non sono riuscito a leggere il file di input dei blocchi:" + f.getName());
					}
				}
			} catch (Exception e1) {
				Utils.pl("Non sono riuscito a trovare il file di input dei blocchi:");
			}
		}

		if (leetDict != null && !leetDict.isValid()) {
			Utils.pl("Leet dictionary not builded");
			leetDict = null;
		}

		Utils.pl("\n");
		Utils.pl("Lang: " + loc != null ? loc.toString() : "");
		Utils.pl("UplowMode: " + ul != null ? ul.toString() : "");
		// Utils.pl("Preprocessors: " + preprocessors != null ? preprocessors.toString()
		// : "");
		Utils.pl("Leet: " );
		// Utils.pl("LeetDcit: " + leetDict != null && leetDict.isValid() ?
		// leetDict.getLeetDict().keySet().toString()
		// : "");
		Utils.pl("JunctionMode: " + j != null ? j.toString() : "");
		Utils.pl("Symbols File: " + (symbols != null ? symbols.getAbsolutePath() : ""));
		Utils.pl("Blocks Directory: " + (blocks != null ? blocks.getAbsolutePath() : ""));
		Utils.pl("Cardinality: " + cardinality);
		Utils.pl("Test: " + test);
	}

	private void newbyMode() {
		printTitle();
		Scanner in = new Scanner(System.in);
		try {

			List<List<String>> lista = new ArrayList<>();

			loc = ask4Language(in);
			cardinality = askCardinality(in);
			int blocks = ask4BlockNumbers(in, cardinality);
			ul = askUpLowMode(in);
			j = askJunctionMode(in);
			sym = new HashSet<String>();

			if (j != JunctionMode.NONE) {
				sym = ask4Symbols(in);
			}

			for (int i = 0; i < blocks; i++) {
				lista.add(ask4Block(in, i));
			}

			test = ask4Test(in);
			in.close();

			launch(cardinality, ul, j, test, sym, leetDict, lista);
		} catch (Exception e) {
			e.printStackTrace();
			if (in != null) {
				in.close();
			}
		}

	}

	private void launch(int cardinality, UpLowMode ulMode, JunctionMode jMode, String test, Set<String> sym,
			Leet leetDict, List<List<String>> lista) {

		if (leetDict != null && !leetDict.isValid()) {
			leetDict = null;
		}

		shuffler = new Shuffler(sym, leetDict);
		if (preprocessors != null && !preprocessors.isEmpty()) {
			Preprocessor preproc = new Preprocessor(preprocessors);
			lista.addAll(preproc.getExtraLists());
		}

		switch (cardinality) {
		case 1: {
			shuffler.cardinality1(lista, ulMode, jMode, test, null);
			break;
		}
		case 2: {
			shuffler.cardinality2(lista, ulMode, jMode, test, null);
			break;
		}
		case 3: {
			shuffler.cardinality3(lista, ulMode, jMode, test, null);
			break;
		}
		case 4: {
			shuffler.cardinality4(lista, ulMode, jMode, test, null);
			break;
		}
		case 5: {
			shuffler.cardinality5(lista, ulMode, jMode, test, null);
			break;
		}
		}

	}

	private Set<String> ask4Symbols(Scanner in) {
		UI.ASK_4SYMBOLS.print(loc);

		Set<String> sym = new HashSet<String>();
		String array = in.next();
		in.nextLine();
		for (String s : array.split("")) {
			sym.add(s);
		}
		return sym;
	}

	private Lang ask4Language(Scanner in) {
		UI.ASK_4LANGUAGE.print(loc);

		int lang = in.nextInt();
		in.nextLine();
		Lang language = Lang.getFromValue(lang);
		if (language == null) {
			UI.INVALID_INPUT.print(loc);
			return ask4Language(in);
		} else {
			return language;
		}
	}

	private List<String> ask4Block(Scanner in, int i) {
		UI.ASK_4BLOCK_WORDS.print(loc, i + 1 + "");

		String array = in.nextLine();
		in.nextLine();
		Set<String> blocco = new HashSet<String>();
		for (String s : array.split(";")) {
			blocco.add(s);
		}
		List<String> block = new ArrayList<>();
		block.addAll(blocco);
		return block;
	}

	private String ask4Test(Scanner in) {
		UI.ASK_4TEST.print(loc);

		String test = in.nextLine();
		if (test.equals("")) {
			return null;
		}
		return test;
	}

	private UpLowMode askUpLowMode(Scanner in) {
		UI.ASK_4UPLOW.print(loc);

		int ulMode = in.nextInt();
		switch (ulMode) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4: {
			return UpLowMode.getFromValue(ulMode);
		}
		default: {
			UI.INVALID_INPUT.print(loc);
			return askUpLowMode(in);
		}
		}
	}

	private JunctionMode askJunctionMode(Scanner in) {
		UI.ASK_4JUNCTION.print(loc);

		int jMode = in.nextInt();
		switch (jMode) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: {
			return JunctionMode.getFromValue(jMode);
		}
		default: {
			UI.INVALID_INPUT.print(loc);
			return askJunctionMode(in);
		}
		}
	}

	private int ask4BlockNumbers(Scanner in, int min) {
		UI.ASK_4BLOCKS_NUMBER.print(loc, min + "");
		int blocks = in.nextInt();
		if (blocks < min) {
			UI.INVALID_INPUT.print(loc);
			return ask4BlockNumbers(in, min);
		}
		return blocks;
	}

	private int askCardinality(Scanner in) {
		UI.ASK_CARDINALITY.print(loc);
		int cardinalita = in.nextInt();
		in.nextLine();
		switch (cardinalita) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5: {
			return cardinalita;
		}
		default: {
			UI.INVALID_INPUT.print(loc);
			return askCardinality(in);
		}
		}
	}

	private void printTitle() {
		Utils.pl("BAU DICT MAKER V-0.1bau");
	}

}
