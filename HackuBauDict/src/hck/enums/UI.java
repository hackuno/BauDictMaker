package hck.enums;

public enum UI {

	MANUAL, COMANDI, M_CARDINALITY, M_UPLOW, M_JUNCTIONS, M_BLOCKS, M_PURPOSE, ASK_4LANGUAGE, ASK_CARDINALITY, ASK_4BLOCKS_NUMBER, ASK_4BLOCK_WORDS, ASK_4SYMBOLS, ASK_4UPLOW, ASK_4JUNCTION, ASK_4TEST, INVALID_INPUT;

	UI() {
	}

	public void print(LANG loc, String... params) {
		switch (this) {
		case ASK_4LANGUAGE: {
			pl("Choose your language:");
			for (LANG lang : LANG.values()) {
				pl("\t" + lang.getValue() + " = " + lang.toString() + "\t" + lang.getDescr());
			}
			break;
		}
		case INVALID_INPUT: {
			if (loc == LANG.IT) {
				pl("Parametro digitato non valido.");
			} else {

			}
			break;
		}
		case ASK_4BLOCKS_NUMBER: {
			if (loc == LANG.IT) {
				pl("Inserisci il numero di blocchi di parole che vuoi inserire (min:" + params[0] + ")");
			} else {
				pl("Insert the number of word blocks you want to insert (min:" + params[0] + ")");
			}
			break;
		}

		case ASK_4BLOCK_WORDS: {
			if (loc == LANG.IT) {
				pl("Inserisci le parole del " + params[0] + "^ blocco separando le parole col punto e virgola (;)");
			} else {
				pl("Insert the " + params[0] + "st block words, using brackets to separate each one(;)");
			}
			break;
		}
		case ASK_4UPLOW: {
			if (loc == LANG.IT) {
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
			if (loc == LANG.IT) {
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
			if (loc == LANG.IT) {
				pl("Inserisci i simboli che desideri considerare per il test (tutti consecutivi, non preoccuparti dei caratteri speciali, ad esempio *-.\\,?/! è un input valido)");
			} else {
				pl("Insert the symbols that you want to use for the selected Junction Mode (don't worry about special chars, you can insert them as-is - for.example *-.\\,?/! is a good input)");
			}
			break;
		}
		case ASK_4TEST: {
			if (loc == LANG.IT) {
				pl("Se desideri effettuare un test di ricerca, inserisci la parola che ti aspetti di ottenere fra i risultati, altrimenti lascia vuoto.");
			} else {
				pl("If you want to make a test about this software, insert the word that you know it must to return belong your input, otherwise leave it blank and go on.");
			}
			break;
		}

		case ASK_CARDINALITY: {
			if (loc == LANG.IT) {
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
		case MANUAL: {
			M_PURPOSE.print(loc);
			M_BLOCKS.print(loc);
			M_CARDINALITY.print(loc);
			M_JUNCTIONS.print(loc);
			M_UPLOW.print(loc);
			COMANDI.print(loc);

			break;
		}

		case M_BLOCKS: {
			if (loc == LANG.IT) {
				pl("");
				pl("COSA VUOL DIRE \"BLOCCHI\" DI PAROLE?");
				pl("\tUn blocco di parole rappresenta una lista di parole equivalenti tra loro.");
				pl("\tUn esempio puo' essere il seguente input:");
				pl("\t\t BLOCCO 1:\tvichingo viking vikings");
				pl("\t\t BLOCCO 2:\tmarco mark zemy zemyno");
				pl("\t\t BLOCCO 3:\t1 9 90 1990");
				pl("\tDato questo input, il software, a seconda delle opzioni e della cardinalita impostata, tirera' fuori tutte le possibili combinazioni SENZA COMBINARE FRA LORO le parole di un singolo blocco.");
				pl("\tDunque, se consideriamo CARDINALITA 2 otterai parole come: vikingMark Mark90 zemy1 ma non otterai mai parole come: MarcoMark o 199090");
				pl("");

			} else {

			}
			break;
		}

		case M_PURPOSE: {
			if (loc == LANG.IT) {
				pl("Questo software ti permette di creare tutte le possibili combinazioni di n.blocchi di parole che fornirai come input (in base alle configurazioni fornite).");
				pl("Nel dettaglio si può agire sulle Maiuscole/Minuscole, Simboli e unione di piu' parole.");
				pl("");

			} else {

				pl("Sorry, the english version of the manual will be soon aviable.");

			}
			break;
		}

		case M_CARDINALITY: {
			if (loc == LANG.IT) {
				pl("COSA SI INTENDE PER CARDINALITA?");
				pl("\tPer cardinalita' si intende l'insieme il numero di parole di cui sara' composto l'output finale.");
				pl("\tAd esempio, con il seguente input:");
				pl("\t\t BLOCCO 1:\tvichingo viking vikings");
				pl("\t\t BLOCCO 2:\tmarco mark zemy zemyno");
				pl("\t\t BLOCCO 3:\t1 9 90 1990");
				pl("\t\t BLOCCO 4:\tsasso telecinesi piccione");
				pl("\tpotremo ottenere i seguenti risultati");
				pl("\tCARDINALITA 2");
				pl("\t\tvikingMark");
				pl("\t\tviking90");
				pl("\tCARDINALITA 3");
				pl("\t\tvikingMark90");
				pl("\t\tpiccioneVikingmark");
				pl("\t\ttelecinesizemy9");
				pl("\t\t1990MarkViking");
				pl("\tCARDINALITA 4");
				pl("\t\t1990MarkVikingSasso");
				pl("\t\t1990VichingoMarkSasso");
				pl("");
			} else {

			}
			break;
		}

		case M_JUNCTIONS: {
			if (loc == LANG.IT) {
				pl("COME FUNZIONA LA \"giunzione\" Junction/symbols?");
				pl("\tSemplicemente, dato un elenco di simboli, il software non solo combinera' tutte le parole fra loro, ma aggiungera'");
				pl("\tfra le parole che sta andando ad unire tutti i simboli forniti in input, inserendoli in ogni combinazione possibile (in base alla modalita richiesta)");
				pl("\tQuando si parla di \"bordi\" o \"limiti\" della parola si intende alle estremita' di essa.");
				pl("");
			} else {

			}
			break;
		}

		case M_UPLOW: {
			if (loc == LANG.IT) {
				pl("COME FUNZIONA LA METAMORFOSI Maiuscole/Minuscole?");
				pl("\tSignifica che ogni parola in input verra' \"esplosa\" in tutte le sue versioni possibili di MaiUSCOle e MiNuSCOle.");
				pl("");
			} else {

			}
			break;
		}

		case COMANDI: {
			if (loc == LANG.IT) {
				pl("COMANDI");
				pl("\tstart > procedura guidata, il software ti guidera per imparare piu facilmente'.");
				
				pl("\t-upLow #: tipo di modalita' maiuscole/minuscole - default: NONE");
				for (UpLowMode mode : UpLowMode.values()) {
					pl("\t\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
				pl("\t-junct #: tipo di modalita' giunzione/simboli - default: NONE");
				for (JunctionMode mode : JunctionMode.values()) {
					pl("\t\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
				pl("\t-card #: cardinalità desiderata - default: 1");
				pl("\t\t1 = la parola in output sarà composta da 1 parola");
				pl("\t\t2 = la parola in output sarà composta dall'unione di 2 parole");
				pl("\t\t3 = la parola in output sarà composta dall'unione di 3 parole");
				pl("\t\t4 = la parola in output sarà composta dall'unione di 4 parole");
				pl("\t\t5 = la parola in output sarà composta dall'unione di 5 parole");
				pl("\t-sp PATH: path al file contenente i simboli da utilizzare");
				pl("\t-bp PATH: path alla cartella contenente i file che verranno presi come input di blocchi di parole (ogni file e' considerato un blocco a se stante)");
				pl("");
				pl("\tExample");
				pl("\t\tbau -upLow 1 -junct 3 -card 3 -sp /path/to/symbols/file.txt -bp /path/to/blocks/files/folder/");
				pl("");
			} else {
				pl("COMANDI");
				pl("\tstart > guided mode, the software will show you how to deal with him, so you will learn easly :)'.");
				pl("");
			}
			break;
		}

		}

	}

	private static void pl(String s) {
		System.out.println(s);
	}

}
