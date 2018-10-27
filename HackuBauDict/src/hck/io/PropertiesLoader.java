package hck.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import hck.HackuBauDict;

public class PropertiesLoader {

	private static final String CFG_PATH = "\\cfg\\hck_default.properties";
	private static final String CFG_PATH_PRIMARY = "cfg\\hck_default.properties";

	public static Properties load() {
		Properties prop = null;
		InputStream input = null;
		Path path = getInstallationPath();
		if (path != null) {
			try {

				System.out.print("Serching default properties in: " + CFG_PATH_PRIMARY);
				File f = new File(CFG_PATH_PRIMARY);
				System.out.println(" ("+f.getAbsolutePath()+")");
				if (f.exists()) {
					System.out.println("Loading default properties from: " +f.getAbsolutePath());
					prop = new Properties();
					input = new FileInputStream(f);
					prop.load(input);
					System.out.println("loaded");
				} else {
					System.out.println("Not found");
					System.out.println("Serching default properties in: " + path + CFG_PATH);
					f = new File(path + CFG_PATH);
					if (f.exists()) {
						System.out.println("Loading default properties from:" + path + CFG_PATH);
						prop = new Properties();
						input = new FileInputStream(f);
						prop.load(input);
						System.out.println("completed");
					} else {
						System.out.println("loaded");
					}
				}

			} catch (IOException ex) {
				System.out.println("Non ho trovato il file di configurazioni iniziali: " + path + CFG_PATH + " o "
						+ CFG_PATH_PRIMARY);
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();

					}
				}
			}
		}
		return prop;

	}

	private static Path getInstallationPath() {
		Path path = null;
		try {
			path = Paths.get(HackuBauDict.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			path = path.getParent().getParent();
		} catch (URISyntaxException e) {
			System.out.println("Can't find properties path.");
		}
		return path;
	}

}
