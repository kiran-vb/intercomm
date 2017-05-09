package com.javatpoint;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class ConfigFileReader implements ApplicationConstant {

	private static Map<String, String> contextPropertiesMap = new HashMap<String, String>();

	static {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("/MarketplaceUI_context.properties");
		Properties prop = new Properties();
		if (is != null) {
			try {
				prop.load(is);
				Enumeration<?> enumPropNames = prop.propertyNames();
				String keyName = null;

				while (enumPropNames.hasMoreElements()) {
					keyName = (String) enumPropNames.nextElement();
					contextPropertiesMap.put(keyName, prop.getProperty(keyName));
				}
			} catch (IOException ie) {
				Logger1.error(ConfigFileReader.class, "Error occured loading QuoteIds_context.properties file");
			}
		}
	}

	public static String getProperty(String property) {
		if (contextPropertiesMap.containsKey(property)) {
			return contextPropertiesMap.get(property);
		} else {
			return null;
		}
	}

	public static String getConfigDir() {

		String configDir = null;
		try {
			configDir = contextPropertiesMap.get(MARKETPLACE_CONFIG_DIR);
			if (configDir == null) {
				Logger1.debug(ConfigFileReader.class,
						"MARKETPLACE_CONFIG_DIR is null Unable to get system property, using default /opt/sasuapps/corona/shared/corona/mktplc/conf/");
				configDir = "C:/All_WORKSPACES/Elite/Elite_GG_Workspace/intercomm/conf/";
			}
		} catch (Exception e) {
			Logger1.error(ConfigFileReader.class, "MARKETPLACE_CONFIG_DIR is null"
					+ "Unable to get mktplc.config.dir from system property, using default /opt/sasuapps/corona/shared/corona/mktplc/conf/");
			configDir = "/opt/sasuapps/corona/shared/corona/mktplc/conf/";
		}
		return configDir;
	}
}
