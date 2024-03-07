package com.test.pom.common;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.common.exception.POMEventException;
import com.test.pom.common.PomEventsMethodDefinition;


public class PomEventsMethodDefinition extends DriversHandling implements PomEvents
{	
	protected WebDriverWait wait=null; 
	public static final String screenshotpath;
	public static final String RESET = "\033[0m";
	public static final String RED_BOLD_BRIGHT = "\033[1;91m"; 
	public static final String PURPLE_BOLD = "\033[1;35m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String BLUE_BOLD = "\033[1;34m";
	
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	    
    static 
	{
    	screenshotpath = "target//";
	}
    
		public void ClickElement(WebElement element) throws POMEventException
		{
		try 
		{
				element.click();
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR IN CLICK OPERATION : " + element);
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR IN CLICK OPERATION : " + PURPLE_BOLD + element + RESET);
		}
		}
		
		
		  public void JSToggleBox(WebElement element, WebDriver driver1) throws POMEventException 
		  { try 
		  {
			  System.out.println("Elemnt in toogle");
			  JavascriptExecutor js = (JavascriptExecutor) driver1;
	            //js.executeScript("document.querySelector('extension-details').shadowRoot.querySelector('#allow-incognito-toggle').click();");
			  js.executeScript("document.getElementByXpath('" + element + "').checked = true;");
		  } 
		  catch (Exception e) 
		  {
			  errorlog.info("ERROR IN JSEXECUTOR TEXTBOX : " + element); throw new
			  POMEventException(RED_BOLD_BRIGHT + "ERROR IN JSEXECUTOR TEXTBOX : " +
			  PURPLE_BOLD + element + RESET); 
		  }
		  }
		 
		public void switchBetweenTabs(String TabNumber) throws POMEventException
		{
		try 
		{
			System.out.println("Before" + driver.getCurrentUrl());
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + TabNumber);
			System.out.println(driver.getCurrentUrl());
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR IN Switching OPERATION : ");
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR IN Switching OPERATION : " + RESET);
		}
		}

	
		public void Dropdown(WebElement element, String value) throws POMEventException
		{
		try 
		{
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(value);
		}
		catch (Exception e)
		{
			errorlog.info("ERROR IN DROPDOWN OPERATION : "+ element);
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR IN DROPDOWN OPERATION : " + PURPLE_BOLD + element + RESET);
		}
		}
	
		public void EnterTextWithoutEnter(WebElement element, String value) throws POMEventException 
		{
		try 
		{
				element.sendKeys(value);
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR WHILE ENTERING TEXT OPERATION WITHOUT ENTER : "+ element);
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR WHILE ENTERING TEXT OPERATION WITHOUT ENTER : " + PURPLE_BOLD + element + RESET);
		}
		}
	
		
	public void SyncWait(int time) throws POMEventException
	{
		try 
		{
			synchronized (driver)
			{
			   driver.wait(time);		
			}
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR WHILE PERFORMING SYNC WAIT : ");
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR WHILE PERFORMING SYNC WAIT : " + RESET);
		}
	}


	public void ThreadWait(int time) throws POMEventException
	{
		try 
		{
			Thread.sleep(time);
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR WHILE PERFORMING THREAD WAIT : ");
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR WHILE PERFORMING THREAD WAIT : " + RESET);
		}
	}
	

		public void takeScreenShot() throws IOException, POMEventException
		{
		try 
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	FileUtils.copyFile(scrFile, new File("D:\\Exception\\screenshots\\"+".png"));	
		}
		catch (Exception e) 
		{
			errorlog.info("ERROR WHILE TAKING SCREENSHOTS : ");
			throw new POMEventException(RED_BOLD_BRIGHT + "ERROR WHILE TAKING SCREENSHOTS : " + RESET);
		}
		}
	

	    public void takeScreenshot() throws POMEventException
		{
		    try
		    {		    	
		        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	    	
		        String screenPath = screenshotpath.toString()+"Testdata.png";
		        FileUtils.copyFile(screenshot, new File(screenPath));
		        driver.quit();
		    }
		    catch (IOException e) 
		    {
		    	errorlog.info("ERROR WHILE TAKING SCREENSHOT.");
		    	throw new POMEventException(RED_BOLD_BRIGHT + "ERROR WHILE TAKING SCREENSHOT." + RESET);
			}
	    }


	
	
}

