package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Created by zhongxiaotian on 2018/3/4.
 */
public class demo {

    public static void main(String[] args) throws Exception{

        //车牌地址
//        String url = "http://paimai.alltobid.com";
//        String url = "http://www.baidu.com";

//        WebDriver dr =  new SafariDriver();
//        dr.manage().window().maximize();
//        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        dr.get(url);

//        Thread.sleep(1000);
//        WebElement logo = dr.findElement(By.xpath("//img[@src='//www.baidu.com/img/bd_logo1.png']"));
//        Thread.sleep(1000);
//        logo.click();
//        System.out.println(logo.getLocation().x);


        //sikuliX
        String path = "/Users/zhongxiaotian/Desktop/pic/";
        String file = path + "test1.png";
        File fileExist = new File(file);
        if(!fileExist.exists()){
            System.out.println(file + "not found");
        }
//        Pattern baidu = new Pattern(baiduLogo);
        Screen screen = new Screen();

//        screen.wait(baiduLogo, 5);
//        screen.click(baiduLogo);
//        screen.doubleClick();

        try{
            screen.wait(file,3).doubleClick();

        }catch (FindFailed var){
            var.printStackTrace();
        }
//        Window.openURL(url);

//        Thread.sleep(100000L);
//        dr.quit();
    }
}
