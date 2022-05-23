package com.automationTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationTest.Actions.customActions;

public class AmazonObjects {
	
	WebDriver ldriver;
	
	public AmazonObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//*[@id='nav-hamburger-menu']/i")
	WebElement hamBurgerMenu;
	
	@FindBy(linkText = "TV, Appliances, Electronics")
	WebElement electornics;
	
	@FindBy(linkText = "Televisions")
	WebElement televisions;
	
	@FindBy(xpath = "//*[@id='s-refinements']/div[18]/ul/li[4]/span/a/div/label/i")
	WebElement brandCheckBox;
	
	@FindBy(id = "s-result-sort-select")
	WebElement sortDropDownMenu;
	
	@FindBy(partialLinkText = "Samsung 163 cm (65 inches) 4K Ultra HD Smart QLED TV")
	WebElement secondProduct;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[44]/div/h1")
	WebElement lbl_expected;
	
	public void HamBurgerMenuClick() {
		hamBurgerMenu.click();
	}
	
	public void MoveToElectornics() {
		Actions action = new Actions(ldriver);
		action.moveToElement(electornics).click().perform();
	}
	
	public void TelevisionClick() {
		televisions.click();
	}
	
	public void CheckBrand() {
		customActions.ExplicitWait_ElementClickable(brandCheckBox, 30);
		customActions.ScrollPage(0, 2500);
		brandCheckBox.click();
	}
	
	public void SelectValueFromDropDown() {
		Select sortBy = new Select(sortDropDownMenu);
		sortBy.selectByVisibleText("Price: High to Low");
	}
	
	public void SecondProduct() {
		secondProduct.click();
	}
	
	public String GetLabelText() {
		customActions.ScrollPage(0, 1000);
		return lbl_expected.getText();
	}

}
