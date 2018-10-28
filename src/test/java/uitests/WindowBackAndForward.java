package uitests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.WaitTimeUtil.sleep;


/**
 * Created by lixx on 2018-09-15.
 * 控制浏览器前进和后退
 */
public class WindowBackAndForward{
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //进入百度首页
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        sleep(3000);
        //进入百度新闻
        driver.get("http://news.baidu.com");
        sleep(3000);
        //回到百度首页
        driver.navigate().back();
        sleep(3000);
        //前进到百度新闻
        driver.navigate().forward();
        sleep(3000);
        driver.quit();
    }
}
