package ua.com.pravda.newstitletest;
import java.util.concurrent.TimeUnit;
import ua.com.pravda.pages.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


public class NewsTitleTest {
	    String driverPath = "c:\\Users\\evgen\\Downloads\\geckodriver\\geckodriver.exe";  
	    WebDriver driver;
	    HomePage objHomePage;
	    NewsPage objNewsPage; 
        String HomePage = "https://www.pravda.com.ua/";
	   
        @BeforeTest

	    public void setup(){
	    	
		System.setProperty("webdriver.gecko.driver", driverPath);       
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	        driver.get(HomePage);
	    }
  @Test
	    public void test_news_page_title(){
	  	objHomePage = new HomePage(driver);
	  	objHomePage.RandomNewsLink(HomePage);
	  	objNewsPage = new NewsPage(driver);
	  	String NewsTitle = objNewsPage.getNewPageTitle();
	  	System.out.println(NewsTitle);
	    Assert.assertTrue(NewsTitle.contains(objHomePage.RandomNewsTitle()));

	    driver.close();
  }
}
