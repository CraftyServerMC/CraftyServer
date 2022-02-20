package org.craftyserver.general.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Represents a section of a config file. 
 * <br> A {@link ConfigEntry} is part of a {@code ConfigSection} which 
 * is part of a {@link ConfigFile}. {@code ConfigSection} extends {@link HashMap},
 * for the {@link ConfigEntry ConfigEntrys} to be stored. The name of the 
 * {@link ConfigEntry} as a {@link String} is used as the Key.
 * <p> Currently, the config API does not support the creation of a default 
 * config, as with the current structure, there is no way to write the entries 
 * in some order or to insert comments in the config. This will require a
 * rewrite of the config API, so <b>be prepared for major changes of the API.</b>
 * <p> <b>Syntax of the {@code ConfigSection}:</b> 
 * <br>{@code [entry1]}
 * <br>{@code [entry2]}
 * <br>{@code ...}
 * <p>e.g. 
 * <br>{@code foo=bar}
 * <br>{@code next=entry}
 * <br>{@code ...}
 * 
 * @author PentagonLP
 * 
 */
public class ConfigSection extends HashMap<String, ConfigEntry> {
	
	/**
	 * The {@code serialVersionUID}, required as {@code ConfigSection} extends {@link HashMap}
	 */
	private static final long serialVersionUID = -5045093688122350206L;
	
	/**
	 * Character limit for names for the {@code ConfigSection}. Used for the {@code BufferedReader.mark()} character limit.
	 */
	public static final int CONFIGSECTION_NAME_CHARLIMIT = 255;
	
	/**
	 * Creates an empty {@code ConfigSection}, without any {@link ConfigEntry ConfigEntries}.
	 */
	public ConfigSection() {}
	
	/**
	 * Creates a {@code ConfigSection}, which parses its {@link ConfigEntry ConfigEntries} from a given {@link BufferedReader}.
	 * 
	 * @param	reader		the reader to read and parse {@link ConfigEntry ConfigEntries} from
	 * @throws	IOException	if an error is encountered while reading from the {@link BufferedReader}
	 */
	public ConfigSection(BufferedReader reader) throws IOException {
		while (true) {
			// Set mark, in case this line marks the beginning of a new ConfigSection
			reader.mark(CONFIGSECTION_NAME_CHARLIMIT + 2);
			String line = reader.readLine();
			if (line==null) return;
			// Ignore comments
			if (line.isEmpty()||line.startsWith("##")) continue;
			// Single # marks the beginning of a new ConfigSection
			if (line.startsWith("#")) {
				// Go back to the mark, for the ConfigFile to read the name of the next ConfigSection
				reader.reset();
				return;
			}
			put(line.substring(0, line.indexOf("=")), new ConfigEntry(line.substring(line.indexOf("=")+1), line.substring(line.indexOf("=")+1)));
		}
	}
	
	/**
	 * Get a {@link ConfigEntry} from the {@code ConfigSection}, specified by its name as a {@link String}.
	 * <br> If the section does not exist, a new, empty {@link ConfigEntry} with the requested name is 
	 * added to the config. This allows the setting of default values.
	 * 
	 * @param	key	the {@link ConfigEntry ConfigEntrys}' name, as a String
	 * @return	the requested {@link ConfigEntry} or empty {@link ConfigEntry} if it doesn't exist yet.
	 */
	@Override
	public ConfigEntry get(Object key) {
		ConfigEntry result = super.get(key);
		if (result != null) return result;
		result = new ConfigEntry(null,null);
		put((String) key, result);
		return result;
	}

}
