package com.test.pom.pages.input;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.common.exception.POMEventException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;


public class Pg01_LoginPage extends PomEventsMethodDefinition 
{

	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div[1]/form/div[1]/div/div[1]/input")
	public WebElement txtusername;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div[1]/form/div[2]/div/div[1]/input")
	public WebElement txtpassword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div[1]/form/button")
	public WebElement btnlogin;
	
	FireEvent FireEventobject = new FireEvent();
	
	public Pg01_LoginPage()
	{
		    PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String uname) throws POMEventException
	{
		    FireEventobject.EnterTextWithoutEnter(txtusername, uname);
	}	

	public void enterPwd(String pwd) throws POMEventException 
	{
		    FireEventobject.EnterTextWithoutEnter(txtpassword, pwd);
	}
	
	public void clickLoginbtn() throws POMEventException 
	{		
			FireEventobject.ClickElement(btnlogin);
	}
	
	public Pg02_NewProjectPage Login()
	{
			return new Pg02_NewProjectPage();
	}
	
}
