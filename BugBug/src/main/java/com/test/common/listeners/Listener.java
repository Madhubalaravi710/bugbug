package com.test.common.listeners;

import org.openqa.selenium.WebElement;

public interface Listener 
{
	 public void beforeClickElement(WebElement element);
	 public void afterClickElement();
	 public void beforeDropdown();
	 public void afterDropdown();
	 public void beforeEnterTextWithoutEnter();
	 public void afterEnterTextWithoutEnter();
	 public void beforeTakeScreenShot();
	 public void afterTakeScreenShot();
	 public void beforeScreenShot();
	 public void afterScreenShot();
	 public void afterThreadWait();
	 public void beforeThreadWait();
	 public void beforeSyncWait();
	 public void afterSyncWait();
	 public void onError(Exception e);
	 public void onException(Throwable throwable);
}
