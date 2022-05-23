package com.automationTest.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.Actions.customActions;
import com.automationTest.baseClass.BaseClass;
import com.automationTest.pageObjects.AmazonObjects;

public class TC_Amazon_001 extends BaseClass {
	
//	@Test
//	public void AmazonTC()
//	{
//		customActions.PageLoadTimeOut(10, TimeUnit.SECONDS);
//		logger.info("Page timeout is set in seconds.");
//		
//		customActions.ImplicitWait(20, TimeUnit.SECONDS);
//		logger.info("Implicit wait is set in seconds for all web elements.");
//		
//		if(driver.getTitle().equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
//		{
//			customActions.Screenshot("Amazon_Test.png");
//			Assert.assertTrue(true);
//			logger.info("Test case passed.");
//		} else {
//			Assert.assertTrue(false);
//			logger.info("Test case failed.");
//		}
//	}
	
	@Test
	public void AmazonAutomationTest() throws InterruptedException {
		
		AmazonObjects obj = new AmazonObjects(driver);
		
		customActions.PageLoadTimeOut(10, TimeUnit.SECONDS);
		customActions.ImplicitWait(20, TimeUnit.SECONDS);
		
		customActions.Sleep(1000);
		logger.info("Launch the browser.");
		customActions.Screenshot("Step_01.png");
		
		obj.HamBurgerMenuClick();
		logger.info("HamBurger Menu clicked.");
		customActions.Sleep(1000);
		customActions.Screenshot("Step_02.png");
		
		obj.MoveToElectornics();
		logger.info("Moved to electronics.");
		customActions.Sleep(1000);
		customActions.Screenshot("Step_03.png");
		
		obj.TelevisionClick();
		logger.info("Clicked on television.");
		customActions.Sleep(1000);
		customActions.Screenshot("Step_04.png");
		
		obj.CheckBrand();
		logger.info("Brand checkbox checked.");
		customActions.Sleep(1500);
		customActions.Screenshot("Step_05.png");
		
		obj.SelectValueFromDropDown();
		logger.info("Sort by price high to low.");
		customActions.Sleep(1000);
		customActions.Screenshot("Step_06.png");
		
		obj.SecondProduct();
		logger.info("Second highly product clicked.");
		customActions.Screenshot("Step_07.png");
		customActions.SwitchWindow();
		logger.info("Window switched to child.");
		customActions.Sleep(1000);
		
		if(obj.GetLabelText().equalsIgnoreCase("About this item")) {
			customActions.Screenshot("Step_08.png");
			Assert.assertTrue(true);
			logger.info(obj.GetLabelText());
			logger.info("Test Case Passed.");
		} else {
			Assert.assertTrue(false);
			logger.info("Test Case Failed.");
		}
		
	}

}
