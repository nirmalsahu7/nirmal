package company.locating_techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleWebTable {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.out.println("hello...");
       // System.setProperty("webdriver.chrome.driver","\\Users\\nirmalsahu\\Documents\\Selenium Set Up\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","/Users/nirmalsahu/Documents/Selenium Set Up/chromedriver");
        //System.setProperty("webdriver.chrome.driver","//Users//nirmalsahu//Documents//Selenium Set Up//chromedriver//chromedriver.exe");

        WebDriver driver=new ChromeDriver();


        driver.get("https://www.w3schools.com/html/html_tables.asp");


        //*[@id="customers"]/tbody/tr[2]/td[1]
        List<WebElement> tableRow = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
        List<WebElement> tableCol = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
        int rowCount=tableRow.size();
        int colCount=tableCol.size();
        // Find the radio button for “No” using its ID and click on it
        String xpathBefore="//*[@id='customers']/tbody/tr[";
        String xpathAfter="]/td[";
        String xpathLast="]";

        System.out.println("Number of rows:" +rowCount);
        System.out.println("Number of cols:" +colCount);
        for (int i=2; i<rowCount;i++){
            for (int j=1;j<=colCount;j++){
                WebElement table = driver.findElement(By.xpath(xpathBefore+i+xpathAfter+j+xpathLast));
                System.out.println("Table data:" +" row - " +i+ " col - " +j +" "+ table.getText());

            }

        }

        driver.quit();

    }
}
