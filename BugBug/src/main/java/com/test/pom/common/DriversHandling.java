package com.test.pom.common;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.test.common.exception.POMEventException;



public class DriversHandling
{
	
	protected static int PAGE_LOAD_TIMEOUT = 50;
	protected static int IMPLICIT_WAIT = 10;	
	public static RemoteWebDriver driver;
	
	public static final String chromedriverpath;
    public static final String firefoxdriverpath;
    public static final String iedriverpath;
    

    public static Logger errorlog = Logger.getLogger("ErrorLog");
    
    
    static 
    {
    	chromedriverpath = "src//main//resources//chromedriver.exe";
    	firefoxdriverpath = "src//main//resources//geckodriver.exe";
    	iedriverpath = "src//main//resources//IEDriverServer.exe";
    }
    
    public static void initialization(String browser, String URL) throws POMEventException
	{ 	
    	
    	try
    	{    			
    
    	System.setProperty("webdriver.chrome.driver",chromedriverpath);
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-popup-blocking");
    	options.addArguments("--disable-gpu");
    	driver = new ChromeDriver(options);
		
	  	driver.manage().window().maximize();
	  	driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	  	driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,  TimeUnit.SECONDS);
	  	driver.get(URL);
    	}
    	catch (Exception e) 
    	{
    		errorlog.info("ERROR IN OPENING BROWSER", e);
    		throw new POMEventException("ERROR IN OPENING BROWSER", e);
		}
		
    }
    	
	public static void deinitialization()
	{
		System.out.println("BROWSER CLOSE");
    	driver.quit();
	}

		
}
