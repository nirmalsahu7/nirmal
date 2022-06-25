package company.selenium_easy_site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) {
        System.out.println("hello...");
        //WebsiteDetails wd=new WebsiteDetails();
        //Page pg= new Page();
        System.setProperty("webdriver.chrome.driver", "/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        WebDriver driver = new ChromeDriver();

        boolean isLaunched = launchWebsite(driver);
        if (isLaunched) {
            System.out.println("Website launched successfully - " + isLaunched);
            isLaunched = true;
        } else {
            System.out.println("Website Not launched successfully - " + isLaunched);
            isLaunched = false;
        }
        //driver.quit();
        driver.close();
    }

    public static boolean launchWebsite(WebDriver driver) {
        //boolean isSuccess;
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
        boolean isLaunched = driver.findElement(By.xpath("//a[normalize-space()='Demo Home']")).isDisplayed();
        WebElement loginPopUp=driver.findElement(By.xpath("//a[normalize-space()='×']"));
        boolean isLoginPopUp=loginPopUp.isEnabled();

        if(isLoginPopUp){
            System.out.println("isLoginPopUp - " + isLoginPopUp);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("implicitlyWait executed - " );
            loginPopUp.click();
        } else{
            System.out.println("isLoginPopUp - " + isLoginPopUp);
            System.out.println("implicitlyWait NOT executed - " );
        }

        return isLaunched;

    }

}
