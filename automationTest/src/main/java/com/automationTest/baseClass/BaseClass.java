package com.automationTest.baseClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.automationTest.Actions.customActions;
import com.automationTest.utilities.ReadConfig;

public class BaseClass {
	
	public static ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		logger = Logger.getLogger("Amazon_Automation_Test");
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.info("Configuration file is loaded.");
		
		if(br.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", readconfig.CHROME_URL());
			driver = new ChromeDriver();
			logger.info("Chrome driver is selected.");
		} 
		else if (br.contains("Edge")){
			System.setProperty("webdriver.edge.driver", readconfig.EDGE_URL());
			driver = new EdgeDriver();
			logger.info("Edge driver is selected.");
		} 
		else if (br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", readconfig.IE_URL());
			driver = new InternetExplorerDriver();
			logger.info("Internet Explorer driver is selected.");
		} 
		else {
			logger.error("No driver found.");
		}
		
		driver.get(readconfig.GetApplicationURL());
		logger.info("Browser launched.");
		
		customActions.MaximizeWindow();
		logger.info("Window Maximized.");
		
		customActions.DeleteAllCookies();
		logger.info("All cookies deleted.");
				
	}
	
	@AfterClass
	public void Tear_Down()
	{
		driver.quit();
		logger.info("Driver instance quited.");
	}

}
