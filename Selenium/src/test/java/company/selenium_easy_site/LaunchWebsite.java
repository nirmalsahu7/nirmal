package company.selenium_easy_site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LaunchWebsite {
    public static void main(String[] args) {
        System.out.println("hello...");
        //WebsiteDetails wd=new WebsiteDetails();
        //Page pg= new Page();
        System.setProperty("webdriver.chrome.driver", "/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        WebDriver driver = new ChromeDriver();
        //String url= wd.getUrl();
        //String eMail= wd.getUserName();
        //String pwd=wd.getPassword();
        boolean isLaunched = launchWebsite(driver);
        if (isLaunched) {
            System.out.println("Website launched successfully - " + isLaunched);
            isLaunched = true;
        } else {
            System.out.println("Website Not launched successfully - " + isLaunched);
            isLaunched = false;
        }
        Actions act = new Actions(driver);
        WebElement loginPopUp=driver.findElement(By.xpath("//a[normalize-space()='×']"));
       // WebElement loginPopUp=driver.findElement(By.xpath("//div[@id='at-cv-lightbox-header']"));

        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopUp));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='×']")));
        boolean status = element.isDisplayed();
        // if else condition
        if (status) {
            System.out.println("===== WebDriver is visible======");
            loginPopUp.click();
        } else {
            System.out.println("===== WebDriver is not visible======");
        }

/*        boolean isLoginPopUp=loginPopUp.isEnabled();

        if(isLoginPopUp){
            System.out.println("isLoginPopUp - " + isLoginPopUp);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //act.click(loginPopUp).build().perform();


        } else{
            System.out.println("isLoginPopUp - " + isLoginPopUp);
        }*/


        //driver.quit();
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
