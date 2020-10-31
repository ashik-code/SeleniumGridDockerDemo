package com.guru99.demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadData {
	public static String getValue(String key) {
		String value = null;

		FileInputStream fis;
		Properties prop = null;
		try {
			fis = new FileInputStream("guru99data.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if(prop.containsKey(key)) {
			value = prop.getProperty(key);
		}
		return value;

	}


}
