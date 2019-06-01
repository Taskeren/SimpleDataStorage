/**
 * This class was created by <Taskeren>. It's distributed as
 * part of SimpleDataStorage. Get the Source Code in github:
 * https://github.com/nitu2003/SimpleDataStorage
 *
 * SimpleDataStorage is Open Source and distributed under the
 * Eclipse Public License 1.0
 */
package ren.taske.data;

import static ren.taske.data.util.ObjectUtil.defaultIfNull;
import static ren.taske.data.util.ParseUtil.parseBoolean;
import static ren.taske.data.util.ParseUtil.parseDouble;
import static ren.taske.data.util.ParseUtil.parseFloat;
import static ren.taske.data.util.ParseUtil.parseInteger;
import static ren.taske.data.util.ParseUtil.parseLong;
import static ren.taske.data.util.ParseUtil.parseShort;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleDataStorage {

	public static final String NEW_LINE = System.getProperty("line.separator");
	
	final File datafile;
	
	final Map<String, String> data;
	
	public SimpleDataStorage(File datafile) {
		this.datafile = datafile;
		this.data = new HashMap<String, String>();
		check();
		load();
		save();
	}
	
	void check() {
		
		if(datafile == null) {
			throw new NullPointerException("datafile");
		}
		
		File parent = datafile.getParentFile();
		if(!parent.exists()) {
			parent.mkdirs();
		}
		
		if(!datafile.exists()) {
			try {
				datafile.createNewFile();
			} catch(IOException e) {
				System.err.println("Cannot create "+datafile.toString());
			}
		}
		
	}
	
	void load() {
		try {
			load(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void load(boolean unused) throws Exception {
		
		if(!datafile.isFile()) {
			return;
		}
		
		if(!datafile.exists()) {
			datafile.createNewFile();
		}
		
		List<String> lines = Files.readAllLines(datafile.toPath());
		
		for(String str : lines) {
			
			String[] s = str.split("=");
			if(s.length == 2) {
				data.put(s[0], s[1]);
			}
			
		}
		
	}
	
	public void save() {
		try {
			save(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void save(boolean unused) throws Exception {
		
		String out = "";
		
		for(Entry<String, String> entry : data.entrySet()) {
			out += entry.getKey() + "=" + entry.getValue() + NEW_LINE;
		}
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(datafile), "UTF-8");
		osw.write(out.trim());
		osw.close();
		
	}
	
	/* *********************************************************
	 * 
	 * Basic Data Controllers
	 * 
	 * *********************************************************/
	
	public String get(String name) {
		return data.get(name);
	}
	
	public void set(String name, String value) {
		data.put(name, value);
	}

	public boolean has(String name) {
		return data.containsKey(name);
	}
	
	public void del(String name) {
		set(name, null);
	}
	
	/* *********************************************************
	 * 
	 * Data Getters
	 * 
	 * *********************************************************/
	
	public String getString(String name, String defaultValue) {
		return defaultIfNull(get(name), defaultValue);
	}
	
	public int getInteger(String name, int defaultValue) {
		return defaultIfNull(parseInteger(get(name)), defaultValue);
	}
	
	public double getDouble(String name, double defaultValue) {
		return defaultIfNull(parseDouble(get(name)), defaultValue);
	}
	
	public float getFloat(String name, float defaultValue) {
		return defaultIfNull(parseFloat(get(name)), defaultValue);
	}
	
	public long getLong(String name, long defaultValue) {
		return defaultIfNull(parseLong(get(name)), defaultValue);
	}
	
	public short getShort(String name, short defaultValue) {
		return defaultIfNull(parseShort(get(name)), defaultValue);
	}
	
	public boolean getBoolean(String name, boolean defaultValue) {
		return defaultIfNull(parseBoolean(get(name)), defaultValue);
	}
	
	/* *********************************************************
	 * 
	 * Data Setters
	 * 
	 * *********************************************************/
	
	public void setString(String name, String value) {
		set(name, value);
	}
	
	public void setInteger(String name, int value) {
		set(name, Integer.toString(value));
	}
	
	public void setDouble(String name, double value) {
		set(name, Double.toString(value));
	}
	
	public void setFloat(String name, float value) {
		set(name, Float.toString(value));
	}
	
	public void setLong(String name, long value) {
		set(name, Long.toString(value));
	}
	
	public void setShort(String name, short value) {
		set(name, Short.toString(value));
	}
	
	public void setBoolean(String name, boolean value) {
		set(name, Boolean.toString(value));
	}
	
}
