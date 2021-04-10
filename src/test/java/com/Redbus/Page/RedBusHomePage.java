package com.Redbus.Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Redbus.utilities.ExcelReaderUtility;

public class RedBusHomePage {

	WebDriver driver;

	public RedBusHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	ExcelReaderUtility e = new ExcelReaderUtility();

	String sheetName = "Savaari";

	@FindBy(xpath = "//input[@id='src']")
	WebElement FromCity;

	@FindBy(xpath = "//input[@id='dest']")
	WebElement toCity;

	@FindBy(xpath = "//*[contains(text(),'Search Buses')]")
	WebElement searchBtn;

	public void fromStation(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValue = e.getCellValue(sheetName, rowNum, cellNum);

		FromCity.clear();
		Thread.sleep(1000);

		FromCity.sendKeys(fromValue);
		Thread.sleep(1000);

		FromCity.sendKeys(Keys.ENTER);
	}

	public void toStation(int rowNum, int cellNum) throws IOException, InterruptedException {

		String toValue = e.getCellValue(sheetName, rowNum, cellNum);

		toCity.clear();
		Thread.sleep(1000);

		toCity.sendKeys(toValue);
		Thread.sleep(1000);
		FromCity.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	public void selectDate(String date) throws InterruptedException {

		driver.findElement(By.xpath(
				"//div[@class='fl search-box date-box gtm-onwardCalendar']/span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[5]/td[5]")).click();

	}

	public void search() throws InterruptedException {
		searchBtn.click();
		Thread.sleep(2000);
	}

	public void nonAC() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='list-chkbox']/li[3]/label[2]")).click();
	}
	
	public void AC() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='list-chkbox']/li[3]/label[2]")).click();
	}

	public void details() throws InterruptedException {
		
		Thread.sleep(2000);
		String name1 = driver.findElement(By.xpath("//li[@id='14166241']//div[@class='travels lh-24 f-bold d-color']")).getText();
		String name2 = driver.findElement(By.xpath("//li[@id='14166241']//div[@class='bus-type f-12 m-top-16 l-color']")).getText();
		String nameOfBus = name1 + " " + name2;
		System.out.println("name of the second AC bus :::::::" + nameOfBus);

		Thread.sleep(2000);
		String cost = driver.findElement(By.xpath("//*[@id=\"14166241\"]/div/div[1]/div[1]/div[6]/div/div[2]/span")).getText();
		System.out.println("cost of the one seat in the bus :" + cost);
		Thread.sleep(2000);
		
		WebElement Element = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		WebElement element= driver.findElement(By.xpath("//li[@id='14166241']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript("arguments[0].scrollIntoView();", Element);
		   js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	
	}

}
