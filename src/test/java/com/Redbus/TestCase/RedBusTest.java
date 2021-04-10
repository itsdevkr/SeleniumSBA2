package com.Redbus.TestCase;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Redbus.Page.RedBusHomePage;
import com.Redbus.utilities.WrapperClass;

public class RedBusTest extends WrapperClass {

	@Test
	public void f() throws IOException, InterruptedException {
		launchBrowser("chrome", "https://www.redbus.in/");
		RedBusHomePage rbp = new RedBusHomePage(driver);
		rbp.fromStation(0, 0);
		rbp.toStation(0, 1);
		rbp.selectDate("Oct-16-2021");
		rbp.search();
		rbp.AC();
		rbp.details();
		screenshot();
		driver.close();
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
}
