package ua.com.pravda.pages;


import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	String news_url = "";
	String news_title = "";
	By NewsBox = By.className("container_sub_news_wrapper");

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	public void GetRandomLink(String HomePage) {
		WebElement NewsList = driver.findElement(NewsBox);
		List<WebElement> links = NewsList.findElements(By.tagName("a"));

		Iterator<WebElement> it =  links.iterator();
		System.out.println();
		while (it.hasNext()) {
			news_url = it.next().getAttribute("href");
			System.out.println("Cheking domain: " + news_url);
			
			if (news_url == null || news_url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				it.remove();
			}

			if (!news_url.startsWith(HomePage)) {
				System.out.println("URL belongs to another domain, removing it from Randomlist: " + news_url);
				it.remove();
			}
		}
		WebElement randomNews = links.get(new Random().nextInt(links.size()));
		news_url = randomNews.getAttribute("href");
		news_title = randomNews.getText();

		System.out.println("Random url/article is: " + news_url + " " + news_title);

	}

	public void RandomNewsLink(String HomePage) {
		this.GetRandomLink(HomePage);
//		System.out.println("RandomNewsLink is " + news_url);
		driver.get(news_url);

	}

	public String RandomNewsTitle() {
//		System.out.println("RandomNewsTitle is " + news_title);
		return news_title;
	}
}