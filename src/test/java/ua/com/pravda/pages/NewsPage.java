package ua.com.pravda.pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class NewsPage {
	 WebDriver driver;

	    By NewsPageTitle = By.className("post_title");
	    
	    public NewsPage(WebDriver driver){

	        this.driver = driver;

	    }
	    public String getNewPageTitle(){

	         return    driver.findElement(NewsPageTitle).getText();

	        }
}
