package company.selenium_easy_site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
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





        //driver.quit();
    }

    public static boolean launchWebsite(WebDriver driver) {
        //boolean isSuccess;
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
        boolean isLaunched = driver.findElement(By.xpath("//a[normalize-space()='Demo Home']")).isDisplayed();
        WebElement loginPopUp=driver.findElement(By.xpath("//a[normalize-space()='×']"));


        WebDriverWait wait = new WebDriverWait(driver,30);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='×']")));
        boolean status = element.isDisplayed();

        if (status) {
            System.out.println("===== WebDriver is visible======");
            loginPopUp.click();
            System.out.println("===== ExplicitWait executed ======");
        } else {
            System.out.println("===== WebDriver is not visible======");
            System.out.println("===== ExplicitWait NOT executed ======");
        }
        return isLaunched;

    }

}
