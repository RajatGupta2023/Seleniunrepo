package com.nopecommerce.demo.AutomationFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopecommerce.demo.AutomationFramework.base.TestBase;



public class NopCommerceDemoStoreTest extends TestBase {
	
	@BeforeMethod
	public void setUp() {
		insilisation();
		
	}
	
	@Test
	public void rendomTest() {
		
		
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
