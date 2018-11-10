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

	private static final String slash = System.getProperties().get("file.separator").toString();
	private static final String CFG_PATH = slash + "cfg" + slash + "hck_default.properties";
	private static final String CFG_PATH_PRIMARY = "cfg" + slash + "hck_default.properties";
	private static final String CFG_FROM_HERE_PATH_NO_SLASH = "cfg" + slash + "hck_default.properties";
	private static final String CFG_FROM_HERE_PATH = "." + slash + "cfg" + slash + "hck_default.properties";
	private static final String NIX_ETC = slash + "etc" + slash + "hck_default.properties";
	private static final String NIX_USR_ETC = slash + "usr" + slash + "etc" + slash + "hck_default.properties";

	private File loaded = null;

	public Properties load() {
		Properties prop = null;
		InputStream input = null;
		Path path = getInstallationPath();

		String[] others = new String[] { CFG_FROM_HERE_PATH, CFG_FROM_HERE_PATH_NO_SLASH, NIX_ETC, NIX_USR_ETC };

		if (path != null) {
			try {

				System.out.print("Serching default properties in: " + CFG_PATH_PRIMARY);
				loaded = new File(CFG_PATH_PRIMARY);
				System.out.println(" (" + loaded.getAbsolutePath() + ")");
				if (loaded.exists()) {
					System.out.println("Loading default properties from: " + loaded.getAbsolutePath());
					prop = new Properties();
					input = new FileInputStream(loaded);
					prop.load(input);
					System.out.println("loaded");
				} else {
					System.out.println("Not found");
					System.out.println("Serching default properties in: " + path + CFG_PATH);
					loaded = new File(path + CFG_PATH);
					if (loaded.exists()) {
						System.out.println("Loading default properties from:" + path + CFG_PATH);
						prop = new Properties();
						input = new FileInputStream(loaded);
						prop.load(input);
						System.out.println("loaded");
					} else {
						System.out.println("Not found");
						for (String p : others) {
							System.out.println("Serching default properties in: " + p);
							loaded = new File(p);
							if (loaded.exists()) {
								System.out.println("Loading default properties from:" + p);
								prop = new Properties();
								input = new FileInputStream(loaded);
								prop.load(input);
								System.out.println("loaded");
							} else {
								System.out.println("Not Found");
							}

						}
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

	public File getLoaded() {
		return loaded;
	}

	public void setLoaded(File loaded) {
		this.loaded = loaded;
	}

}
