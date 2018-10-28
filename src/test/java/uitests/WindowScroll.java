package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.WaitTimeUtil;


/**
 * Created by lixx on 2018-10-07.
 * 滚动条滚动
 */
public class WindowScroll {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().setSize(new Dimension(600,600));
        WaitTimeUtil.sleep(3000);
        driver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#su")).click();
        WaitTimeUtil.sleep(3000);
        String js =  "window.scrollTo(100,450);";
        ((JavascriptExecutor)driver).executeScript(js);
        WaitTimeUtil.sleep(5000);
        driver.quit();
    }
}
