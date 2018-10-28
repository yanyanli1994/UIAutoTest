package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixx on 2018-10-06.
 * 隐式等待
 */
public class ImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss-SSS");
            String time = format.format(Calendar.getInstance().getTime());
            System.out.println("开始的时间： " + time);
            driver.findElement(By.id("kw22")).sendKeys("selenium");

        } catch (NoSuchElementException e) {
            System.out.println("没有找到元素");
            e.printStackTrace();
        } finally {
            SimpleDateFormat format2 = new SimpleDateFormat("HH-mm-ss-SSS");
            String time2 = format2.format(Calendar.getInstance().getTime());
            System.out.println("结束的时间： " + time2);
            driver.quit();
        }
    }

}
