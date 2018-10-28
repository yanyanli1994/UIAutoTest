package uitests;

import utils.WaitTimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by lixx on 2018-10-08.
 * 关闭窗口
 * quit方法：退出相关的驱动程序和关闭所有窗口
 * close方法：关闭当前窗口
 */
public class WindowsClose {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        String searchHandle = driver.getWindowHandle();
        String newsHandle = null;
        System.out.println("baidu search handle : " + searchHandle);
        // 获取百度新闻的连接，然后利用js打开一个新的窗口
        WaitTimeUtil.sleep(3000);
        String href = driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
        System.out.println("the link of news is : " + href);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('"+ href +"')");
        WaitTimeUtil.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        Iterator iterator = handles.iterator();
        Iterator iterator2 = handles.iterator();
        //进入百度新闻窗口，并获取title验证
        WaitTimeUtil.sleep(3000);
        while (iterator.hasNext()){
            String h = (String)iterator.next();
            if (h != searchHandle){
                driver.switchTo().window(h);
                if (driver.getTitle().contains("百度新闻")){
                    System.out.println("switch to news page successfully");
                    newsHandle = driver.getWindowHandle();
                    break;
                }else
                {
                    continue;
                }
            }
        }
        //返回百度首页
        WaitTimeUtil.sleep(3000);
          /*
         * 可以直接使用searchHandle来切换，也可以利用遍历来切换
         * driver.switchTo().window(searchHandle);
         * if(driver.getTitle().contains("百度一下")){
         * System.out.println("switch to search page successfully");
         * driver.findElement(By.cssSelector("#kw")).sendKeys(
         * "switch successfully"); }
         */
        while (iterator2.hasNext()){
            String h = (String) iterator2.next();
            if (searchHandle.equals(h)){
                driver.switchTo().window(h);
                if (driver.getTitle().contains("百度一下"))
                {
                    System.out.println("switch to search page successfully");
                    driver.findElement(By.cssSelector("#kw")).sendKeys("switch successfully");
                    driver.close();//只关闭百度首页
                    System.out.println("close search page successfully");
                    driver.switchTo().window(newsHandle);//切换到百度新闻
                    System.out.println("当前的title是："+ driver.getTitle());
                    WaitTimeUtil.sleep(3000);
                    break;
                }else
                {
                    continue;
                }
            }
        }
    }

}
