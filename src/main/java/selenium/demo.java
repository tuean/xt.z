package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by zhongxiaotian on 2018/3/4.
 */
public class demo {

    public static void main(String[] args) {

//        System.setProperty("webdriver.safari.driver", "/Users/zhongxiaotian/Library/Safari/Extensions");
//        System.setProperty("webdriver.safari.noinstall", "true");

        WebDriver dr =  new SafariDriver();

        dr.get("http://www.baidu.com");

        WebElement element = dr.findElement(By.id("kw"));
        element.sendKeys("selenuim");

        WebElement searchClick = dr.findElement(By.id("su"));
        searchClick.click();


//        dr.findElement(By.id("kw")).sendKeys("hello Selenium");
//
//        dr.findElement(By.id("su")).click();

//        try {
//
//            Thread.sleep(3000);
//
//        } catch (InterruptedException e) {
//
//            // TODO Auto-generated catch block
//
//            e.printStackTrace();
//
//        }



//        dr.quit();

    }
}
