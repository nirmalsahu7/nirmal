package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookLogin {

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

        driver.get("https://newtours.demoaut.com/");
        // Find the radio button for “No” using its ID and click on it
        driver.findElement(By.name("username")).sendKeys("mercury");
        //Click on Check Button
        driver.findElement(By.name("pass")).sendKeys("mercury");
        Thread.sleep(10000);
        driver.findElement(By.name("sign-in")).click();
        //capture the title of the home page
        String acttitle=driver.getTitle();
        String exptitle= "find a flight:Mercury Tours:";
        //verify title of the page
        if(acttitle.equals(exptitle))
        {
            System.out.println("passed");
        }
        else
        {
            System.out.println("failed");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //driver.quit();

    }
}
