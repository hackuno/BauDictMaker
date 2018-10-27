package hck.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import hck.utils.Utils;

public class FileIO {
	private Path path = null;

	public FileIO(File f) {
		path = Paths.get(f.getAbsolutePath());
		try {
			Files.write(path, "".getBytes(), StandardOpenOption.CREATE);
		} catch (Exception e) {
			Utils.pl("Error creating output file!" + path);
		}

	}

	public synchronized void append(String out) {
		try {
			Files.write(path, out.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			Utils.pl("Error writing output file!");
		}

	}

}
