package uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.WaitTimeUtil.sleep;


/**
 * Created by lixx on 2018-09-15.
 * 模拟浏览器刷新
 */
public class WindowRefresh {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://news.baidu.com");
        driver.manage().window().maximize();
        sleep(3000);
        //刷新
        driver.navigate().refresh();
        sleep(3000);
        driver.quit();
    }
}
