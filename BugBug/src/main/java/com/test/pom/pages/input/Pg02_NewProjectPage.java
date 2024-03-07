package com.test.pom.pages.input;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.common.exception.POMEventException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;

public class Pg02_NewProjectPage extends PomEventsMethodDefinition 
{
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div/button/div")
	protected WebElement clickNewProject;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/form/div[1]/div[1]/div/div[1]/input")
	protected WebElement projectName;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div[1]/input")
	public WebElement homePageURL;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/form/div[2]/button[2]/div/div[3]")
	public WebElement clickCreateProject;
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	FireEvent FireEventobject = new FireEvent();
	
	
	public Pg02_NewProjectPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewProjectButton() throws POMEventException, InterruptedException
	{
		Thread.sleep(300);
		FireEventobject.ClickElement(clickNewProject);
	}
	
	public void enterProjectName(String ProjectNameValue) throws POMEventException 
	{
	    FireEventobject.EnterTextWithoutEnter(projectName, ProjectNameValue);
	}
	
	public void enterHomeURL(String homePageURLValue) throws POMEventException
	{
		FireEventobject.EnterTextWithoutEnter(homePageURL, homePageURLValue);
	}
		
	public void clickCreateProjectButton() throws POMEventException, InterruptedException
	{
		FireEventobject.ClickElement(clickCreateProject);
		Thread.sleep(1000);
	}
	
	  public Pg03_NewTestCreationPage Home() { return new Pg03_NewTestCreationPage(); }
	 
}
