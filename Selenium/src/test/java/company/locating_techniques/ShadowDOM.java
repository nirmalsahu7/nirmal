package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShadowDOM {

    public static void main(String[] args) throws InterruptedException {
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
        //driver.get("http://demo.guru99.com/test/selenium-xpath.html");
       // System.out.println("url launch successfully...");
        //String firstString=driver.findElement(By.xpath("//b[normalize-space()='SAP']")).getText();
       // System.out.println("FirstString - " + firstString);

        driver.get("https://books-pwakit.appspot.com/");
        // Find the radio button for “No” using its ID and click on it
        //driver.findElement(By.id("no")).click();
        System.out.println("before - " + "Nirmal");
        //driver.findElement(By.cssSelector("input[aria-label='Search Books']")).sendKeys("nirmal");
        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        Thread.sleep(1000);
        WebElement shadowDomHostElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        WebElement last = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
        Thread.sleep(1000);
        last.findElement(By.cssSelector("input[aria-label='Search Books']")).sendKeys("nirmal");

        System.out.println("after - " + "Nirmal");


        //driver.quit();

    }
}
