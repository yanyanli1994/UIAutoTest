package uitests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lixx on 2018-09-15.
 * 控制浏览器窗口大小
 */
public class WindowSize {
    public static void main(String[] args) {
        WebDriver driver;
        //获取Driver
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        //将屏幕最大化
        driver.manage().window().maximize();
        waitTime(3000);
        //将浏览器大小设置成宽800,高480
        Dimension arg0 = new Dimension(800,480);
        driver.manage().window().setSize(arg0);
    }
    static public void waitTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
