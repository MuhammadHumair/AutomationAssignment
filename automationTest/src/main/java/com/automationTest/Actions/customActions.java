package com.automationTest.Actions;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationTest.baseClass.BaseClass;

public class customActions extends BaseClass {
	
	@SuppressWarnings("deprecation")
	public static void ImplicitWait(int second, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(second, unit);
	}
	
	@SuppressWarnings("deprecation")
	public static void PageLoadTimeOut(int seconds, TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(seconds, unit);
	}
	
	public static void Sleep(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}
	
	public static void MaximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void DeleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public static void Screenshot(String file_name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/"+file_name));
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public static void ExplicitWait_ElementClickable(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void ExplicitWait_PresenceOfElement(By loc, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}
	
	public static void ScrollPage(int x_axis, int y_axis) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x_axis+","+y_axis+")");
	}
	
	public static void SwitchWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow=iterator.next();
		driver.switchTo().window(childWindow);
	}

}