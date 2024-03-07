package com.test.pom.pages.input;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.common.exception.POMEventException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;

public class Pg03_NewTestCreationPage extends PomEventsMethodDefinition 
{

		@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/form/div[1]/div[1]/div/div[1]/input")
		public WebElement testNameBox;                                     
		@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/form/div[1]/div[2]/div/button")
		public WebElement screenSizeDRP;
		@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/form/div[2]/button[2]/div/div[3]")
	    public WebElement createTestButton;
		
		FireEvent FireEventobject = new FireEvent();
		
		
		public Pg03_NewTestCreationPage()
		{
	    	   PageFactory.initElements(driver, this);
		}		
		
		public void enterTestName(String TestNameValue) throws POMEventException, InterruptedException
		{
				Thread.sleep(1000);
			    FireEventobject.EnterTextWithoutEnter(testNameBox, TestNameValue);
		}
		

		public void selectScreenSize(String ScreenSizeValue) throws POMEventException
		{
			    FireEventobject.Dropdown(screenSizeDRP, ScreenSizeValue);
		}
		
		public void clickCreateTestButton() throws POMEventException 
		{            
            	FireEventobject.ClickElement(createTestButton);
		}	

		
		public Pg04_StartRecordingPage Agency() 
		{
				return new Pg04_StartRecordingPage();
		}

}
