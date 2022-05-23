package com.automationTest.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/Config.properties");
		
		try 
		{
			FileInputStream file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);
		} 
		catch(Exception e) 
		{
			System.out.println("Exception is " + e);
		}
	}
	
	public String GetApplicationURL()
	{
		String url = prop.getProperty("URL");
		return url;
	}
	
	public String Browser_Name()
	{
		String browser = prop.getProperty("BROWSER_NAME");
		return browser;
	}
	
	public String CHROME_URL()
	{
		String chromeURL = prop.getProperty("CHROME_URL");
		return chromeURL;
	}
	
	public String EDGE_URL()
	{
		String edgeURL = prop.getProperty("EDGE_URL");
		return edgeURL;
	}
	
	public String IE_URL()
	{
		String ieURL = prop.getProperty("ie_URL");
		return ieURL;
	}

}
