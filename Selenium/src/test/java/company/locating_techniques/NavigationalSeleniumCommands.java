package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Objects;

public class NavigationalSeleniumCommands {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello...");
       // System.setProperty("webdriver.chrome.driver","\\Users\\nirmalsahu\\Documents\\Selenium Set Up\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        //System.setProperty("webdriver.chrome.driver","//Users//nirmalsahu//Documents//Selenium Set Up//chromedriver//chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        /*
         tries to open chercher.tech page
        driver.get("chercher.tech");
        */
        //driver.get("https://www.phptravels.net/");
        driver.get("http://demo.guru99.com/test/selenium-xpath.html");
        System.out.println("url launch successfully...");
        String firstString=driver.findElement(By.xpath("//b[normalize-space()='SAP']")).getText();
        System.out.println("FirstString - " + firstString);
        String currURL=driver.getCurrentUrl();
        System.out.println("currURL - " + currURL);
        String title=driver.getTitle();
        System.out.println("getTitle - " + title);
        String pgSrc=driver.getPageSource();
        //System.out.println("getPageSource - " + pgSrc);
        //driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.browserstack.com/selenium");

        driver.navigate().forward();
        String titleFwd=driver.getTitle();
        System.out.println("titleFwd after forward- " + titleFwd);
        driver.navigate().back();
        String titleBack=driver.getTitle();
        System.out.println("titleBack after back- " + titleBack);
        driver.navigate().refresh();
        driver.get("https://www.facebook.com");
        driver.quit();

    }
}
