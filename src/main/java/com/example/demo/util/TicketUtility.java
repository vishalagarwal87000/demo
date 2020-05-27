/**
 * 
 */
package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author prajw
 *
 */
public class TicketUtility {

	public static String readProperties(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		String value = null;

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("DB.properties");
			prop.load(input);
			value = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return value;
	}

}
