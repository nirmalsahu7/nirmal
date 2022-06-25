package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsWorking {

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

        driver.get("http://demo.guru99.com/test/ajax.html");
        // Find the radio button for “No” using its ID and click on it
        driver.findElement(By.id("no")).click();
        //Click on Check Button
        driver.findElement(By.id("buttoncheck")).click();
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/ajax.html");
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements:" +elements.size());

        for (int i=0; i<elements.size();i++){
            System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
        }

        driver.quit();

    }
}
