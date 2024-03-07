package com.test.pom.pages.input;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.common.exception.POMEventException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;

public class Pg04_StartRecordingPage extends PomEventsMethodDefinition
{
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/form/div/div[2]/div[1]/input")
	public WebElement URLTextBox;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/form/button")
	public WebElement startRecordingButton;
	
	FireEvent FireEventobject = new FireEvent();
		
	public Pg04_StartRecordingPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterURL(String URLValue) throws POMEventException, InterruptedException
	{
		    FireEventobject.EnterTextWithoutEnter(URLTextBox, URLValue);
	}

	
	public void clickStartRecordingButton() throws POMEventException 
	{            
        	FireEventobject.ClickElement(startRecordingButton);
	}	
		
	public Pg05_AddExtension Insured()
	{		
			return new Pg05_AddExtension();
	}
	
}