package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.WaitTimeUtil;


import java.util.Iterator;
import java.util.Set;

/**
 * Created by lixx on 2018-10-06.
 * 多窗口切换
 * 如果遇到点击按钮或链接后出现新窗口的情况，就需要使用窗口切换的方法。
 *本例中就是先打开百度搜索界面，然后利用js打开一个百度新闻界面，然后通过selenium提供的窗口切换方法切换窗口
 */
public class WindowsSwitch {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        String searchHandle = driver.getWindowHandle();
        System.out.println("baidu search handle :" + searchHandle);

        //获取百度新闻的链接，然后利用js打开一个新的窗口
        WaitTimeUtil.sleep(3000);
        String href = driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
        System.out.println("the link of news is : " + href);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('" + href + "')");
        WaitTimeUtil.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        Iterator iterator = handles.iterator();
        Iterator iterator2 = handles.iterator();

        //进入百度新闻窗口,并获取title验证
        WaitTimeUtil.sleep(3000);
        while (iterator.hasNext()) {
            String h = (String) iterator.next();
            if (h != searchHandle) {
                driver.switchTo().window(h);
                if (driver.getTitle().contains("百度新闻")) {
                    System.out.println("switch to news page successfully");
                    break;
                } else {
                    continue;
                }
            }

        }
        // 返回百度首页
        WaitTimeUtil.sleep(3000);
        /*
         * 可以直接使用searchHandle来切换，也可以利用遍历来切换
         * driver.switchTo().window(searchHandle);
         * if(driver.getTitle().contains("百度一下")){
         * System.out.println("switch to search page successfully");
         * driver.findElement(By.cssSelector("#kw")).sendKeys(
         * "switch successfully"); }
         */
        while (iterator2.hasNext()) {
            String h = (String) iterator2.next();
            if (searchHandle.equals(h)) {
                driver.switchTo().window(h);
                if (driver.getTitle().contains("百度一下")) {
                    System.out.println("switch to search page successfully");
                    driver.findElement(By.cssSelector("#kw")).sendKeys("switch successfully");
                    break;
                } else {
                    continue;
                }
            }

        }

        WaitTimeUtil.sleep(3000);
        driver.quit();


    }
}
