package com.nopecommerce.demo.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	private FileInputStream fileInputStream;

	private Properties prop;

	public static Logger logger;
	private WebDriver events;
	private EventFiringWebDriver eDriver;

	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\16477\\eclipse-workspace\\PAutomationFramework\\src\\main\\java\\configration\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void insilisation() {
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "FireFox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		}

		driver.get(prop.getProperty("URL"));

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.quit();
	}

}
