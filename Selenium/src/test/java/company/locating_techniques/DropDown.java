package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.out.println("hello...");
        // System.setProperty("webdriver.chrome.driver","\\Users\\nirmalsahu\\Documents\\Selenium Set Up\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        //System.setProperty("webdriver.chrome.driver","//Users//nirmalsahu//Documents//Selenium Set Up//chromedriver//chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.facebook.com/");

        WebElement signUp = driver.findElement(By.xpath("//*[text()='Create new account']"));
        signUp.click();
        Thread.sleep(5000);
        WebElement mm  = driver.findElement(By.id("month"));
        WebElement dd  = driver.findElement(By.id("day"));
        WebElement yy  = driver.findElement(By.id("year"));

        Select selectMM= new Select(mm);
        selectMM.selectByVisibleText("Jul");
        Thread.sleep(5000);
        selectMM.selectByValue("3");
        Thread.sleep(5000);
        selectMM.selectByIndex(3);
        System.out.println("selectMM - "+ selectMM);
        System.out.println("isMultiple - "+selectMM.isMultiple());
        List<WebElement> listMM = selectMM.getOptions();
        System.out.println("list size - "+listMM.size());

/*        Select selectDD= new Select(dd);
        selectMM.selectByVisibleText("2");

        Select selectYY= new Select(yy);
        selectMM.selectByVisibleText("2017");*/

    }
}
