package hck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import hck.enums.JunctionMode;
import hck.enums.LANG;
import hck.enums.UI;
import hck.enums.UpLowMode;
import hck.services.Shuffler;

public class BauDictMaker {

	public static Shuffler shuffler = null;

	public static LANG loc = LANG.IT;

	public static void main(String[] args) {

		if (args.length == 0) {
			UI.MANUAL.print(loc);
			System.exit(0);
		} else {

			if (args[0].equals("start")) {
				newbyMode();
			} else if (args[0].equals("bau")) {
				cmd(args);
			}
		}

	}

	private static void cmd(String[] args) {

		UpLowMode ul = UpLowMode.NONE;
		JunctionMode j = JunctionMode.NONE;
		File symbols = null;
		File blocks = null;
		int cardinality = 1;
		String test = null;

		for (String a : args) {
			try {
				String[] cmd = a.split("=");
				if (cmd.length == 2) {
					switch (cmd[0]) {
					case "uplow": {
						ul=UpLowMode.getFromValue(cmd[1]);
						break;
					}
					case "junct": {
						j=JunctionMode.getFromValue(cmd[1]);
						break;
					}
					case "card": {
						cardinality = Integer.valueOf(cmd[1]);
						break;
					}
					case "sym-file": {
						symbols = new File(cmd[1]);
						break;
					}
					case "blocks-dir": {
						blocks = new File(cmd[1]);
						break;
					}
					case "test-word": {
						test = cmd[1];
						break;
					}
					}
				}
			} catch (Exception e) {
				pl("Parametro non riconosciuto: " + a);
			}
		}
		pl("UplowMode: " + ul.toString());
		pl("JunctionMode: " + j.toString());
		pl("Symbols File: " + symbols.getAbsolutePath());
		pl("Blocks Directory: " + blocks.getAbsolutePath());
		pl("Cardinality: " + cardinality);
		pl("Test: " + test);

		Set<String> sym = new HashSet<String>();
		List<List<String>> lista = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(symbols));
			String st;
			while ((st = br.readLine()) != null) {
				sym.add(st);
			}
			br.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

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
				e.printStackTrace();
			}
		}

		launch(cardinality, ul, j, test, sym, lista);
	}

	private static void newbyMode() {
		printTitle();
		Scanner in = new Scanner(System.in);
		try {

			List<List<String>> lista = new ArrayList<>();

			loc = ask4Language(in);
			int cardinality = askCardinality(in);
			int blocks = ask4BlockNumbers(in, cardinality);
			UpLowMode ulMode = askUpLowMode(in);
			JunctionMode jMode = askJunctionMode(in);
			Set<String> sym = new HashSet<String>();

			if (jMode != JunctionMode.NONE) {
				sym = ask4Symbols(in);
			}

			for (int i = 0; i < blocks; i++) {
				lista.add(ask4Block(in, i));
			}

			String test = ask4Test(in);
			in.close();

			launch(cardinality, ulMode, jMode, test, sym, lista);
		} catch (Exception e) {
			e.printStackTrace();
			if (in != null) {
				in.close();
			}
		}

	}

	private static void launch(int cardinality, UpLowMode ulMode, JunctionMode jMode, String test, Set<String> sym,
			List<List<String>> lista) {

		shuffler = new Shuffler(sym);

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

	private static Set<String> ask4Symbols(Scanner in) {
		UI.ASK_4SYMBOLS.print(loc);

		Set<String> sym = new HashSet<String>();
		String array = in.next();
		in.nextLine();
		for (String s : array.split("")) {
			sym.add(s);
		}
		return sym;
	}

	private static LANG ask4Language(Scanner in) {
		UI.ASK_4LANGUAGE.print(loc);

		int lang = in.nextInt();
		in.nextLine();
		LANG language = LANG.getFromValue(lang);
		if (language == null) {
			UI.INVALID_INPUT.print(loc);
			return ask4Language(in);
		} else {
			return language;
		}
	}

	private static List<String> ask4Block(Scanner in, int i) {
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

	private static String ask4Test(Scanner in) {
		UI.ASK_4TEST.print(loc);

		String test = in.nextLine();
		if (test.equals("")) {
			return null;
		}
		return test;
	}

	private static UpLowMode askUpLowMode(Scanner in) {
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

	private static JunctionMode askJunctionMode(Scanner in) {
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

	private static int ask4BlockNumbers(Scanner in, int min) {
		UI.ASK_4BLOCKS_NUMBER.print(loc, min + "");
		int blocks = in.nextInt();
		if (blocks < min) {
			UI.INVALID_INPUT.print(loc);
			return ask4BlockNumbers(in, min);
		}
		return blocks;
	}

	private static int askCardinality(Scanner in) {
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

	private static void printManual() {
		pl("Manual");
	}

	private static void printTitle() {
		System.out.println("BAU DICT MAKER V-0.1bau");
	}

	private static void pl(String s) {
		System.out.println(s);
	}

}
