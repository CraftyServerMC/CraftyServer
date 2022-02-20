package org.craftyserver.craftyserver.connectionhandler.packageparser;

import java.io.IOException;

import org.craftyserver.craftyserver.connectionhandler.PackageParser;
import org.craftyserver.craftyserver.connectionhandler.BacklogInputStream;
import org.craftyserver.craftyserver.connectionhandler.Package;
import org.craftyserver.general.packageparser.DataTypeParser;

/**
 * Parser for packages of default format. At the moment the only working Parser and the only one in use.
 * <p>
 * Used by {@link org.craftyserver.craftyserver.connectionhandler.Connection Connection}
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public class DefaultPackageParser implements PackageParser {
	
	/**
	 * Parse a package in default format read from the next Bytes read from {@link BacklogInputStream}
	 * 
	 * @param	input		the {@link BacklogInputStream} to read from
	 * @throws	IOException	if reading from {@link BacklogInputStream} fails
	 */
	@Override
	public Package parseNextPackage(BacklogInputStream input) throws IOException {
		// Package format: VarInt(3) length ; VarInt id ; ByteArray data
		int length = DataTypeParser.readVarInt(input, (byte) 3);
		int id = DataTypeParser.readVarInt(input);
		int lengthofid = DataTypeParser.toVarInt(id).length;
		byte[] data = input.readNBytes(length-lengthofid);
		return new Package(id, length, data);
	}

}
