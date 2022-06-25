package company.selenium_easy_site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckboxDemo {
    public static void main(String[] args) {
        System.out.println("hello...");
        //WebsiteDetails wd=new WebsiteDetails();
        //Page pg= new Page();
        System.setProperty("webdriver.chrome.driver", "/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        WebDriver driver = new ChromeDriver();

        LaunchWebsite lw = new LaunchWebsite();
        boolean isLaunched = lw.launchWebsite(driver);
        if (isLaunched) {
            System.out.println("Website launched successfully - " + isLaunched);
            isLaunched = true;
        } else {
            System.out.println("Website Not launched successfully - " + isLaunched);
            isLaunched = false;
        }

        WebElement menuInputForm = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Input Forms']"));
        menuInputForm.click();
        WebElement lblCheckboxDemo = driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[normalize-space()='Checkbox Demo']"));
        lblCheckboxDemo.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement chkCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        chkCheckBox.click();
    }

//p[contains(text(),'The HTML input')]

}
