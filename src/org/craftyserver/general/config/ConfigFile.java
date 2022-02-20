package org.craftyserver.general.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Represents a file, parsed as a config. 
 * <br> A {@link ConfigEntry} is part of a {@link ConfigSection} which 
 * is part of a {@code ConfigFile}. {@code ConfigFile} extends {@link HashMap},
 * for the {@link ConfigSection ConfigSections} to be stored. The name of the 
 * {@link ConfigSection} as a {@link String} is used as the Key.
 * <p> Currently, the config API does not support the creation of a default 
 * config, as with the current structure, there is no way to write the entries 
 * in some order or to insert comments in the config. This will require a
 * rewrite of the config API, so <b>be prepared for major changes of the API.</b>
 * <p> <b>Syntax of the {@code ConfigFile}:</b> 
 * <br>{@code # [sectionname1]}
 * <br>{@code ...}
 * <br>{@code # [sectionname2]}
 * <br>{@code ...}
 * <p>e.g. 
 * <br>{@code # foo}
 * <br>{@code ...}
 * <br>{@code # bar}
 * <br>{@code ...}
 * 
 * @author PentagonLP
 * 
 */
// TODO create default config, with entries in a specified order and with support of comments
public class ConfigFile extends HashMap<String, ConfigSection> {
	
	/**
	 * The {@code serialVersionUID}, required as {@code ConfigFile} extends {@link HashMap}
	 */
	private static final long serialVersionUID = -1635417566681091252L;
	
	/**
	 * Creates a {@code ConfigFile} by parsing a {@link File}, specified by its path in the file system.
	 * 
	 * @param	path		the path to the {@link File} to be parsed
	 * 
	 * @throws	IOException	if an error is encountered while reading from the file
	 */
	public ConfigFile(String path) throws IOException {
		this(new File(path));
	}
	
	/**
	 * Creates a {@code ConfigFile} by parsing a given {@link File}.
	 * 
	 * @param	file		the {@link File} object to be parsed
	 * 
	 * @throws	IOException	if an error is encountered while reading from the file
	 */
	public ConfigFile(File file) throws IOException {
		if (file.exists()) {
			InputStream fileinputstream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileinputstream));
			while (true) {
				String line = reader.readLine();
				if (line==null) break;
				// Ignore comments and empty lines
				if (line.isEmpty()||line.startsWith("##")) continue;
				if (line.startsWith("#")) {
					put(line.substring(2),new ConfigSection(reader));
				}
			}
		}
	}
	
	/**
	 * Get a {@link ConfigSection} from the {@code ConfigFile}, specified by its name as a {@link String}.
	 * <br> If the section does not exist, a new, empty {@link ConfigSection} with the requested name is 
	 * added to the config. This allows the setting of default values.
	 * 
	 * @param	key	the {@link ConfigSection ConfigSections}' name, as a String
	 * @return	the requested {@link ConfigSection} or empty {@link ConfigSection} if it doesn't exist yet.
	 */
	@Override
	public ConfigSection get(Object key) {
		ConfigSection result = super.get(key);
		if (result != null) return result;
		result = new ConfigSection();
		put((String) key, result);
		return result;
	}

}
