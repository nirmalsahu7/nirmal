package company.travel_site;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static <Dimensions> void main(String[] args) {
         System.out.println("hello...");
         WebsiteDetails wd=new WebsiteDetails();
         Page pg= new Page();
         System.setProperty("webdriver.chrome.driver","/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
         WebDriver driver=new ChromeDriver();
         String url= wd.getUrl();
         String eMail= wd.getUserName();
         String pwd=wd.getPassword();
           driver.get(url);
           driver.manage().window().maximize();
           //driver.findElement(By.xpath("//a[@class='theme-btn theme-btn-small waves-effect']"));
        String title = driver.getTitle();
        System.out.println("title..." +title);
        String urlCurrent = driver.getCurrentUrl();
        System.out.println("urlCurrent..." +urlCurrent);
        String source = driver.getPageSource();
        //System.out.println("pgSource..." +source);

        String text = driver.findElement(pg.btnLogin).getText();
        System.out.println("getText()..." +text);

        String tag = driver.findElement(pg.btnLogin).getTagName();
        System.out.println("getTagName()..." +tag);

        WebElement element = driver.findElement(pg.btnLogin);
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + "Y cordinate: " + point.y);

        driver.manage().window().fullscreen();

/*           driver.findElement(pg.btnLogin).click();
           
           driver.findElement(pg.txtEmail).sendKeys(eMail);
           driver.findElement(pg.txtPwd).sendKeys(pwd);
           driver.findElement(pg.btnLogin2).click();*/
    }
}
