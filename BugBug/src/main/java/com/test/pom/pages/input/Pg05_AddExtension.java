package com.test.pom.pages.input;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.common.exception.POMEventException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;

public class Pg05_AddExtension extends PomEventsMethodDefinition
{
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div/button/div")
	public WebElement goToChromeWebStoreButton;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div/main/div/section[1]/section/div[2]/div/button")
	public WebElement addToChromeButton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div/button/div")
	public WebElement goToExtensionSettingButton;
	
	@FindBy(xpath = "//*[@id=\"crToggle\"]")
	public WebElement incognitoToggle;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div/button/div")
	public WebElement continueButton;
	
	FireEvent FireEventobject = new FireEvent();
	public String oldTab;
		
	public Pg05_AddExtension() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickgoToChromeWebStoreButton() throws POMEventException 
	{       
		    oldTab = driver.getWindowHandle();
        	FireEventobject.ClickElement(goToChromeWebStoreButton);
	}	
	
	public void switchBWtabsAndClickaddToChromeButton() throws POMEventException, InterruptedException, AWTException 
	{            
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    driver.switchTo().window(newTab.get(0));

	    Thread.sleep(17000);
    	FireEventobject.ClickElement(addToChromeButton);
    	Thread.sleep(10000);
    	
    	Robot robot = new Robot();
    	robot.keyPress(KeyEvent.VK_LEFT);
    	robot.keyRelease(KeyEvent.VK_LEFT);
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	
    	Thread.sleep(40000);
    	driver.close();
    	
	    driver.switchTo().window(oldTab);
    	robot.keyPress(KeyEvent.VK_F5);
    	robot.keyRelease(KeyEvent.VK_F5);
	    Thread.sleep(1000);
		
	}	
	public void clickgoToExtensionSettingButton() throws POMEventException, InterruptedException 
	{            
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    Thread.sleep(1500);
        FireEventobject.ClickElement(goToExtensionSettingButton);
	    driver.switchTo().window(newTab.get(0));
	}	
	public void clickincognitoToggle() throws POMEventException, InterruptedException, AWTException 
	{            
		    Thread.sleep(45000);
		    System.out.println("incognito");
		  
		    List<WebElement> toggleBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));

            for (WebElement checkbox : toggleBoxes) 
            {
                if (!checkbox.isSelected())
                {
                    checkbox.click(); 
                }
            }
        	
        	driver.close();
    	    driver.switchTo().window(oldTab);    	  
    	    driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
    	    Thread.sleep(1000);
	}	
	public void clickcontinueButton() throws POMEventException 
	{            
		  System.out.println("Continue button is clicked");
        	FireEventobject.ClickElement(continueButton);
	}	
		
}