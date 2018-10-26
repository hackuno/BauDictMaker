package hck.enums;

public enum UI {

	ASK_4LANGUAGE, ASK_CARDINALITY, ASK_4BLOCKS_NUMBER, ASK_4BLOCK_WORDS, ASK_4SYMBOLS, ASK_4UPLOW, ASK_4JUNCTION, ASK_4TEST, INVALID_INPUT;

	UI() {
	}

	public void print(LOC loc, String... params) {
		switch (this) {
		case ASK_4LANGUAGE: {
			pl("Choose your language:");
			for (LOC lang : LOC.values()) {
				pl("\t" + lang.getValue() + " = " + lang.toString() + "\t" + lang.getDescr());
			}
			break;
		}
		case INVALID_INPUT: {
			if (loc == LOC.IT) {
				pl("Parametro digitato non valido.");
			} else {

			}
			break;
		}
		case ASK_4BLOCKS_NUMBER: {
			if (loc == LOC.IT) {
				pl("Inserisci il numero di blocchi di parole che vuoi inserire (min:" + params[0] + ")");
			} else {
				pl("Insert the number of word blocks you want to insert (min:" + params[0] + ")");
			}
			break;
		}

		case ASK_4BLOCK_WORDS: {
			if (loc == LOC.IT) {
				pl("Inserisci le parole del " + params[0] + "^ blocco separando le parole col punto e virgola (;)");
			} else {
				pl("Insert the " + params[0] + "st block words, using brackets to separate each one(;)");
			}
			break;
		}
		case ASK_4UPLOW: {
			if (loc == LOC.IT) {
				pl("Inserisci la modalita' di metamorfosi maiuscole/minuscole desiderata");

				for (UpLowMode mode : UpLowMode.values()) {
					pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
			} else {
				pl("Insert the Metamorph mode about UpperCase/Lower you want to test");
				for (UpLowMode mode : UpLowMode.values()) {
					pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getDescr());
				}

			}
			break;

		}
		case ASK_4JUNCTION: {
			if (loc == LOC.IT) {
				pl("Inserisci la modalita' di giunzione/simboli desiderata");
				for (JunctionMode mode : JunctionMode.values()) {
					pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
			} else {
				pl("Inser the Junction/Symbols mode that you want to use");
				for (JunctionMode mode : JunctionMode.values()) {
					pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getDescr());
				}

			}
			break;
		}
		case ASK_4SYMBOLS: {
			if (loc == LOC.IT) {
				pl("Inserisci i simboli che desideri considerare per il test (tutti consecutivi, non preoccuparti dei caratteri speciali, ad esempio *-.\\,?/! è un input valido)");
			} else {
				pl("Insert the symbols that you want to use for the selected Junction Mode (don't worry about special chars, you can insert them as-is - for.example *-.\\,?/! is a good input)");
			}
			break;
		}
		case ASK_4TEST: {
			if (loc == LOC.IT) {
				pl("Se desideri effettuare un test di ricerca, inserisci la parola che ti aspetti di ottenere fra i risultati, altrimenti lascia vuoto.");
			} else {
				pl("If you want to make a test about this software, insert the word that you know it must to return belong your input, otherwise leave it blank and go on.");
			}
			break;
		}

		case ASK_CARDINALITY: {
			if (loc == LOC.IT) {
				pl("Inserisci la cardinalità desiderata");
				pl("\t1 = la parola in output sarà composta da 1 parola");
				pl("\t2 = la parola in output sarà composta dall'unione di 2 parole");
				pl("\t3 = la parola in output sarà composta dall'unione di 3 parole");
				pl("\t4 = la parola in output sarà composta dall'unione di 4 parole");
				pl("\t5 = la parola in output sarà composta dall'unione di 5 parole");
			} else {
				pl("Insert the desired cardinality");
				pl("\t1 = The output word will be composed by 1 word");
				pl("\t2 = The output word will be composed by the union of 2 words");
				pl("\t3 = The output word will be composed by the union of 3 words");
				pl("\t4 = The output word will be composed by the union of 4 words");
				pl("\t5 = The output word will be composed by the union of 5 words");
			}
			break;

		}
		}

	}

	private static void pl(String s) {
		System.out.println(s);
	}

}
