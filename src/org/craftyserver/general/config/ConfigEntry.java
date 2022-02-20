package org.craftyserver.general.config;

/**
 * Single entry of a {@link ConfigFile}. A default value can be set, 
 * which is returned if not value exixts in the config.
 * <br> A {@code ConfigEntry} is part of a {@link ConfigSection} which 
 * is part of a {@link ConfigFile}.
 * <p> Currently, the config API does not support the creation of a default 
 * config, as with the current structure, there is no way to write the entries 
 * in some order or to insert comments in the config. This will require a
 * rewrite of the config API, so <b>be prepared for major changes of the API.</b>
 * <p> <b>Syntax of a single {@code ConfigEntry}:</b> {@code [name]=[value]}, e.g. {@code foo=bar}
 * 
 * @author PentagonLP
 * 
 */
// TODO create default config, with entries in a specified order and with support of comments
public class ConfigEntry {
	
	/**
	 * Value stored in this entry, always stored as a {@link String} and only parsed to other datatypes when accessed
	 */
	private String value = null;
	/**
	 * Default value of the entry, which will be returned if value is {@code null}
	 */
	private String defaultvalue = null;
	
	/**
	 * Creates a new {@code ConfigEntry}, storing a value and a default value as a {@link String}.
	 * If {@code value} is accessed, but is {@code null}, the {@code defaultvalue} is returned.
	 * Both {@code value} and {@code defautlvalue} are always stored as a {@link String} and only 
	 * parsed to other datatypes when accessed.
	 * 
	 * @param	value			the value set for this {@code ConfigEntry}. Can be {@code null} 
	 * 							if no value is set.
	 * @param	defaultvalue	the value, which is returned if the value of the entry is {@code null}.
	 * 							Can be {@code null} if no default value is set.
	 */
	public ConfigEntry(String value, String defaultvalue) {
		this.value = value;
		this.defaultvalue = defaultvalue;
	}
	
	/**
	 * Get the stored config value, parsed as an {@code int}.
	 * 
	 * @return	the value, as an {@code int}. If value is {@code null}, the default value is returned.
	 */
	public int getInt() {
		return Integer.valueOf(getString());
	}
	
	/**
	 * Get the stored config value, parsed as a {@code long}.
	 * 
	 * @return	the value, as a {@code long}. If value is {@code null}, the default value is returned.
	 */
	public long getLong() {
		return Long.valueOf(getString());
	}
	
	/**
	 * Get the stored config value, parsed as a {@code short}.
	 * 
	 * @return	the value, as a {@code short}. If value is {@code null}, the default value is returned.
	 */
	public short getShort() {
		return Short.valueOf(getString());
	}
	
	/**
	 * Get the stored config value, parsed as a {@code byte}.
	 * 
	 * @return	the value, as a {@code byte}. If value is {@code null}, the default value is returned.
	 */
	public byte getByte() {
		return Byte.valueOf(getString());
	}
	
	/**
	 * Get the stored config value, parsed as a {@code float}.
	 * 
	 * @return	the value, as a {@code float}. If value is {@code null}, the default value is returned.
	 */
	public float getFloat() {
		return Float.valueOf(getString());
	} 
	
	/**
	 * Get the stored config value, parsed as a {@code double}.
	 * 
	 * @return	the value, as a {@code double}. If value is {@code null}, the default value is returned.
	 */
	public double getDouble() {
		return Double.valueOf(getString());
	} 
	
	/**
	 * Get the stored config value, parsed as a {@code boolean}.
	 * 
	 * @return	the value, as a {@code boolean}. If value is {@code null}, the default value is returned.
	 */
	public boolean getBoolean() {
		return Boolean.valueOf(getString());
	}
	
	/**
	 * Get the stored config value, as a {@link String}. No parsing, as the value is internally stored a {@link String}.
	 * 
	 * @return	the value, as a {@link String}. If value is {@code null}, the default value is returned.
	 */
	public String getString() {
		if (value!=null) return value;
		return defaultvalue;
	}
	
	/**
	 * Get the stored config value, as a {@link String}. No parsing, as the value is internally stored a {@link String}.
	 * <p> It is better to call {@link ConfigEntry#getString()}, as they do the same thing and lesser method calls will 
	 * take place. This is method only exists to easily convert the value to a {@link String}, e.g. by using 
	 * <p>{@code System.out.println(myConfigEntry)}
	 * 
	 * @return	the value, as a {@link String}. If value is {@code null}, the default value is returned.
	 */
	@Override
	public String toString() {
		return getString();
	}
	
	/**
	 * Set a {@code long} as the stored config value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the value, as a {@code long}
	 */
	public void setValue(long value) {
		this.value = "" + value;
	}
	
	/**
	 * Set a {@code double} as the stored config value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the value, as a {@code double}
	 */
	public void setValue(double value) {
		this.value = "" + value;
	}
	
	/**
	 * Set a {@code boolean} as the stored config value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the value, as a {@code boolean}
	 */
	public void setValue(boolean value) {
		this.value = "" + value;
	}
	
	/**
	 * Set a {@link String} as the stored config value. No parsing, as the value is internally stored a {@link String}.
	 * 
	 * @param	value	the value, as a {@link String}
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Get the stored default value, parsed as an {@code int}.
	 * 
	 * @return	the default value, as an {@code int}. If value is {@code null}, an exception will be thrown.
	 */
	public int getDefaultValueInt() {
		return Integer.valueOf(defaultvalue);
	}
	
	/**
	 * Get the stored default value, parsed as a {@code long}.
	 * 
	 * @return	the default value, as a {@code long}. If value is {@code null}, an exception will be thrown.
	 */
	public long getDefaultValueLong() {
		return Long.valueOf(defaultvalue);
	}
	
	/**
	 * Get the stored default value, parsed as a {@code short}.
	 * 
	 * @return	the default value, as a {@code short}. If value is {@code null}, an exception will be thrown.
	 */
	public short getDefaultValueShort() {
		return Short.valueOf(defaultvalue);
	}
	
	/**
	 * Get the stored default value, parsed as a {@code byte}.
	 * 
	 * @return	the default value, as a {@code byte}. If value is {@code null}, an exception will be thrown.
	 */
	public byte getDefaultValueByte() {
		return Byte.valueOf(defaultvalue);
	}
	
	/**
	 * Get the stored default value, parsed as a {@code float}.
	 * 
	 * @return	the default value, as a {@code float}. If value is {@code null}, an exception will be thrown.
	 */
	public float getDefaultValueFloat() {
		return Float.valueOf(defaultvalue);
	} 
	
	/**
	 * Get the stored default value, parsed as a {@code double}.
	 * 
	 * @return	the default value, as a {@code double}. If value is {@code null}, an exception will be thrown.
	 */
	public double getDefaultValueDouble() {
		return Double.valueOf(defaultvalue);
	} 
	
	/**
	 * Get the stored default value, parsed as a {@code boolean}.
	 * 
	 * @return	the default value, as a {@code boolean}. If value is {@code null}, an exception will be thrown.
	 */
	public boolean getDefaultValueBoolean() {
		return Boolean.valueOf(defaultvalue);
	}
	
	/**
	 * Get the stored default value, as a {@link String}. No parsing, as the default value is internally stored a {@link String}.
	 * 
	 * @return	the default value, as a {@link String}. Can be {@code null}.
	 */
	public String getDefaultValueString() {
		return defaultvalue;
	}
	
	/**
	 * Set a {@code long} as the stored default value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the default value, as a {@code long}
	 */
	public void setDefaultValue(long value) {
		this.defaultvalue = "" + value;
	}
	
	/**
	 * Set a {@code double} as the stored default value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the default value, as a {@code double}
	 */
	public void setDefaultValue(double value) {
		this.defaultvalue = "" + value;
	}
	
	/**
	 * Set a {@code boolean} as the stored default value. Will be parsed as a {@link String} to be stored internally.
	 * 
	 * @param	value	the default value, as a {@code boolean}
	 */
	public void setDefaultValue(boolean value) {
		this.defaultvalue = "" + value;
	}
	
	/**
	 * Set a {@link String} as the stored default value. No parsing, as the default value is internally stored a {@link String}.
	 * 
	 * @param	value	the default value, as a {@link String}
	 */
	public void setDefaultValue(String value) {
		this.defaultvalue = value;
	}

}
