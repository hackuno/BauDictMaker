package hck.enums;

import hck.utils.Utils;

public enum UI {

	MANUAL, COMANDI, M_CARDINALITY, M_UPLOW, M_JUNCTIONS, M_BLOCKS, M_PURPOSE, ASK_4LANGUAGE, ASK_CARDINALITY, ASK_4BLOCKS_NUMBER, ASK_4BLOCK_WORDS, ASK_4SYMBOLS, ASK_4UPLOW, ASK_4JUNCTION, ASK_4TEST, INVALID_INPUT;

	UI() {
	}

	public void print(Lang loc, String... params) {
		switch (this) {
		case ASK_4LANGUAGE: {
			Utils.pl("Choose your language:");
			for (Lang lang : Lang.values()) {
				Utils.pl("\t" + lang.getValue() + " = " + lang.toString() + "\t" + lang.getDescr());
			}
			break;
		}
		case INVALID_INPUT: {
			if (loc == Lang.IT) {
				Utils.pl("Parametro digitato non valido.");
			} else {

			}
			break;
		}
		case ASK_4BLOCKS_NUMBER: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci il numero di blocchi di parole che vuoi inserire (min:" + params[0] + ")");
			} else {
				Utils.pl("Insert the number of word blocks you want to insert (min:" + params[0] + ")");
			}
			break;
		}

		case ASK_4BLOCK_WORDS: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci le parole del " + params[0] + "^ blocco separando le parole col punto e virgola (;)");
			} else {
				Utils.pl("Insert the " + params[0] + "st block words, using brackets to separate each one(;)");
			}
			break;
		}
		case ASK_4UPLOW: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci la modalita' di metamorfosi maiuscole/minuscole desiderata");

				for (UpLowMode mode : UpLowMode.values()) {
					Utils.pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
			} else {
				Utils.pl("Insert the Metamorph mode about UpperCase/Lower you want to test");
				for (UpLowMode mode : UpLowMode.values()) {
					Utils.pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getDescr());
				}

			}
			break;

		}
		case ASK_4JUNCTION: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci la modalita' di giunzione/simboli desiderata");
				for (JunctionMode mode : JunctionMode.values()) {
					Utils.pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
			} else {
				Utils.pl("Inser the Junction/Symbols mode that you want to use");
				for (JunctionMode mode : JunctionMode.values()) {
					Utils.pl("\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getDescr());
				}

			}
			break;
		}
		case ASK_4SYMBOLS: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci i simboli che desideri considerare per il test (tutti consecutivi, non preoccuparti dei caratteri speciali, ad esempio *-.\\,?/! è un input valido)");
			} else {
				Utils.pl("Insert the symbols that you want to use for the selected Junction Mode (don't worry about special chars, you can insert them as-is - for.example *-.\\,?/! is a good input)");
			}
			break;
		}
		case ASK_4TEST: {
			if (loc == Lang.IT) {
				Utils.pl("Se desideri effettuare un test di ricerca, inserisci la parola che ti aspetti di ottenere fra i risultati, altrimenti lascia vuoto.");
			} else {
				Utils.pl("If you want to make a test about this software, insert the word that you know it must to return belong your input, otherwise leave it blank and go on.");
			}
			break;
		}

		case ASK_CARDINALITY: {
			if (loc == Lang.IT) {
				Utils.pl("Inserisci la cardinalità desiderata");
				Utils.pl("\t1 = la parola in output sarà composta da 1 parola");
				Utils.pl("\t2 = la parola in output sarà composta dall'unione di 2 parole");
				Utils.pl("\t3 = la parola in output sarà composta dall'unione di 3 parole");
				Utils.pl("\t4 = la parola in output sarà composta dall'unione di 4 parole");
				Utils.pl("\t5 = la parola in output sarà composta dall'unione di 5 parole");
			} else {
				Utils.pl("Insert the desired cardinality");
				Utils.pl("\t1 = The output word will be composed by 1 word");
				Utils.pl("\t2 = The output word will be composed by the union of 2 words");
				Utils.pl("\t3 = The output word will be composed by the union of 3 words");
				Utils.pl("\t4 = The output word will be composed by the union of 4 words");
				Utils.pl("\t5 = The output word will be composed by the union of 5 words");
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
			if (loc == Lang.IT) {
				Utils.pl("");
				Utils.pl("COSA VUOL DIRE \"BLOCCHI\" DI PAROLE?");
				Utils.pl("\tUn blocco di parole rappresenta una lista di parole equivalenti tra loro.");
				Utils.pl("\tUn esempio puo' essere il seguente input:");
				Utils.pl("\t\t BLOCCO 1:\tvichingo viking vikings");
				Utils.pl("\t\t BLOCCO 2:\tmarco mark zemy zemyno");
				Utils.pl("\t\t BLOCCO 3:\t1 9 90 1990");
				Utils.pl("\tDato questo input, il software, a seconda delle opzioni e della cardinalita impostata, tirera' fuori tutte le possibili combinazioni SENZA COMBINARE FRA LORO le parole di un singolo blocco.");
				Utils.pl("\tDunque, se consideriamo CARDINALITA 2 otterai parole come: vikingMark Mark90 zemy1 ma non otterai mai parole come: MarcoMark o 199090");
				Utils.pl("");

			} else {

			}
			break;
		}

		case M_PURPOSE: {
			if (loc == Lang.IT) {
				Utils.pl("Questo software ti permette di creare tutte le possibili combinazioni di n.blocchi di parole che fornirai come input (in base alle configurazioni fornite).");
				Utils.pl("Nel dettaglio si può agire sulle Maiuscole/Minuscole, Simboli e unione di piu' parole.");
				Utils.pl("");

			} else {

				Utils.pl("Sorry, the english version of the manual will be soon aviable.");

			}
			break;
		}

		case M_CARDINALITY: {
			if (loc == Lang.IT) {
				Utils.pl("COSA SI INTENDE PER CARDINALITA?");
				Utils.pl("\tPer cardinalita' si intende l'insieme il numero di parole di cui sara' composto l'output finale.");
				Utils.pl("\tAd esempio, con il seguente input:");
				Utils.pl("\t\t BLOCCO 1:\tvichingo viking vikings");
				Utils.pl("\t\t BLOCCO 2:\tmarco mark zemy zemyno");
				Utils.pl("\t\t BLOCCO 3:\t1 9 90 1990");
				Utils.pl("\t\t BLOCCO 4:\tsasso telecinesi piccione");
				Utils.pl("\tpotremo ottenere i seguenti risultati");
				Utils.pl("\tCARDINALITA 2");
				Utils.pl("\t\tvikingMark");
				Utils.pl("\t\tviking90");
				Utils.pl("\tCARDINALITA 3");
				Utils.pl("\t\tvikingMark90");
				Utils.pl("\t\tpiccioneVikingmark");
				Utils.pl("\t\ttelecinesizemy9");
				Utils.pl("\t\t1990MarkViking");
				Utils.pl("\tCARDINALITA 4");
				Utils.pl("\t\t1990MarkVikingSasso");
				Utils.pl("\t\t1990VichingoMarkSasso");
				Utils.pl("");
			} else {

			}
			break;
		}

		case M_JUNCTIONS: {
			if (loc == Lang.IT) {
				Utils.pl("COME FUNZIONA LA \"giunzione\" Junction/symbols?");
				Utils.pl("\tSemplicemente, dato un elenco di simboli, il software non solo combinera' tutte le parole fra loro, ma aggiungera'");
				Utils.pl("\tfra le parole che sta andando ad unire tutti i simboli forniti in input, inserendoli in ogni combinazione possibile (in base alla modalita richiesta)");
				Utils.pl("\tQuando si parla di \"bordi\" o \"limiti\" della parola si intende alle estremita' di essa.");
				Utils.pl("");
			} else {

			}
			break;
		}

		case M_UPLOW: {
			if (loc == Lang.IT) {
				Utils.pl("COME FUNZIONA LA METAMORFOSI Maiuscole/Minuscole?");
				Utils.pl("\tSignifica che ogni parola in input verra' \"esplosa\" in tutte le sue versioni possibili di MaiUSCOle e MiNuSCOle.");
				Utils.pl("");
			} else {

			}
			break;
		}

		case COMANDI: {
			if (loc == Lang.IT) {
				Utils.pl("COMANDI");
				Utils.pl("\tstart > procedura guidata, il software ti guidera per imparare piu facilmente'.");
				Utils.pl("\tbau > Esegue il software con i comandi seguenti'.");
				Utils.pl("\tuplow=#: tipo di modalita' maiuscole/minuscole - default: NONE");
				for (UpLowMode mode : UpLowMode.values()) {
					Utils.pl("\t\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
				Utils.pl("\tjunct=#: tipo di modalita' giunzione/simboli - default: NONE");
				for (JunctionMode mode : JunctionMode.values()) {
					Utils.pl("\t\t" + mode.getValue() + " = " + mode.toString() + "\t" + mode.getItaDescr());
				}
				Utils.pl("\tcard=#: cardinalità desiderata - default: 1");
				Utils.pl("\tout-file=#: output file - default: null");
				Utils.pl("\tflush=#: numero di elementi dopo i quali scrivere su file");
				Utils.pl("\t\t1 = la parola in output sarà composta da 1 parola");
				Utils.pl("\t\t2 = la parola in output sarà composta dall'unione di 2 parole");
				Utils.pl("\t\t3 = la parola in output sarà composta dall'unione di 3 parole");
				Utils.pl("\t\t4 = la parola in output sarà composta dall'unione di 4 parole");
				Utils.pl("\t\t5 = la parola in output sarà composta dall'unione di 5 parole");
				Utils.pl("\tsym-file=PATH: path al file contenente i simboli da utilizzare");
				Utils.pl("\ttest-word=parola : per testare il software e verificare che trovi una certa parola.");
				Utils.pl("\tblocks-dir=PATH: path alla cartella contenente i file che verranno presi come input di blocchi di parole (ogni file e' considerato un blocco a se stante)");
				Utils.pl("");
				Utils.pl("COMANDI");
				Utils.pl("\tguided > guided mode, the software will show you how to deal with him, so you will learn easly :)'.");
				Utils.pl("\tbau> the real mode'.");
				Utils.pl("");
				Utils.pl("DEFAULTS");
				Utils.pl("\tAt the start of the program, it will try to load defaults from ./cfg/hck_default.properties");
				Utils.pl("");
				Utils.pl("\tExample");
				Utils.pl("\t\tbau uplow=1 junct=3 card=3 sym-file=/path/to/symbols/file.txt blocks-dir=/path/to/blocks/files/folder/ test-word=parolaDaTestare");
				Utils.pl("");
			} else {
				Utils.pl("Manual not ready yet, please Read the content of the default properties to know what you need.");
				Utils.pl("COMANDS");
				Utils.pl("\tguided > guided mode, the software will show you how to deal with him, so you will learn easly :)'.");
				Utils.pl("\tbau> the real mode'.");
				Utils.pl("");
				Utils.pl("DEFAULTS");
				Utils.pl("\tAt the start of the program, it will try to load defaults from ./cfg/hck_default.properties");
				Utils.pl("");
			}
			break;
		}

		}

	}


}
