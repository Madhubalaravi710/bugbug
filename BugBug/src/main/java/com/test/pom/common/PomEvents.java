package com.test.pom.common;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.test.common.exception.POMEventException;

public interface PomEvents 
{	
	public void ClickElement(WebElement element) throws POMEventException;
	public void Dropdown(WebElement element, String value) throws POMEventException;
	public void EnterTextWithoutEnter(WebElement element, String value) throws POMEventException;
	public void takeScreenShot() throws IOException, POMEventException;
	public void takeScreenshot() throws POMEventException;
	public void SyncWait(int time) throws POMEventException;
	public void ThreadWait(int time) throws POMEventException;
	public void switchBetweenTabs(String Tab) throws POMEventException;
	public void JSToggleBox(WebElement incognitoToggle, WebDriver Driver1) throws POMEventException;
}
