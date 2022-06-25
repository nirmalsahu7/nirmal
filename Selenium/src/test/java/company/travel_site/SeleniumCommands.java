package company.travel_site;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class SeleniumCommands {
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

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        int tagCount=elements.size();
        System.out.println("tagCount..." +tagCount);

        String text = driver.findElement(pg.btnLogin).getText();
        System.out.println("getText()..." +text);

        String tag = driver.findElement(pg.btnLogin).getTagName();
        System.out.println("getTagName()..." +tag);

        WebElement element = driver.findElement(pg.btnLogin);
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + "Y cordinate: " + point.y);

        String handle = driver.getWindowHandle();
        System.out.println("getWindowHandle()..." +handle);

        Set<String> handles = driver.getWindowHandles();

       // driver.manage().window().fullscreen();

/*        List<WebElement> elements = driver.findElements(By.tagName("a"));
        int tagCount=elements.size();
        System.out.println("tagCount..." +tagCount);*/
/*           driver.findElement(pg.btnLogin).click();
           
           driver.findElement(pg.txtEmail).sendKeys(eMail);
           driver.findElement(pg.txtPwd).sendKeys(pwd);
           driver.findElement(pg.btnLogin2).click();*/
    }
}
