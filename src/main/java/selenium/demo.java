package selenium;

import com.sikulix.api.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;
import org.sikuli.script.Screen;

/**
 * Created by zhongxiaotian on 2018/3/4.
 */
public class demo {

    public static void main(String[] args) throws Exception{

        //车牌地址
//        String url = "http://paimai.alltobid.com";
        String url = "http://www.baidu.com";


        WebDriver dr =  new SafariDriver();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        dr.get(url);
//        WebElement element = dr.findElement(By.id("kw"));
//        element.sendKeys("selenuim");

//        WebElement searchClick = dr.findElement(By.id("su"));
//        searchClick.click();

        Thread.sleep(1000);
        WebElement logo = dr.findElement(By.xpath("//img[@src='//www.baidu.com/img/bd_logo1.png']"));
        Thread.sleep(1000);
        logo.click();
        System.out.println(logo.getLocation().x);


        //sikuliX
        String path = "/Users/zhongxiaotian/Desktop/pic";
        Screen screen = new Screen();

        try{

        }catch (Exception var){
            var.printStackTrace();
        }
//        Window.openURL(url);

        Thread.sleep(100000L);
        dr.quit();
    }
}
