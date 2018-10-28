package uitests;

import Utils.WaitTimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

/**
 * Created by lixx on 2018-10-03.
 * 鼠标事件
 * 1）右击
 * 2）鼠标悬停
 * 3）双击
 * 4）拖放
 */
public class MouseOperation {
    public static void main(String[] args) {
        FirefoxProfile profile=new FirefoxProfile
                (new File("C:\\Users\\Administrator\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\a64sns0i.default"));
        WebDriver driver=new FirefoxDriver(profile);
        driver.get("https://www.imooc.com/");//访问慕课网
        //左击实现（和元素的click类似）
        Actions action=new Actions(driver);
        WebElement test1item = driver.findElement(By.id("js-signin-btn"));//左击登录
        action.click(test1item).perform();
        System.out.println("鼠标左击实现——成功");
        //右击实现
        driver.navigate().refresh();//刷新页面
        action.contextClick(driver.findElement(By.id("js-signin-btn"))).perform();//右击登录
        System.out.println("鼠标右击实现——成功");
        WaitTimeUtil.sleep(5000);
        //双击实现
        action.doubleClick(driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"))).perform();//双击“免费课程”
        System.out.println("鼠标双击实现——成功");
        //鼠标悬停
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[7]/a"))).perform();//悬停“找工作”
        System.out.println("鼠标悬停实现——成功");
        //拖动实现
        driver.get("http://www.w3school.com.cn/tiy/t.asp?f=html5_draganddrop");
        driver.navigate().refresh();//刷新页面
        WebElement begin=driver.findElement(By.id("drag1"));
        WaitTimeUtil.sleep(3000);
        WebElement end=driver.findElement(By.id("div1"));
        action.dragAndDrop(begin,end).perform();
        System.out.println("鼠标拖动实现——成功");



    }

}
