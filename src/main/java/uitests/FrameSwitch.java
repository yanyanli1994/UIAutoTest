package uitests;

import Utils.WaitTimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lixx on 2018-10-08.
 * 多表单切换
 */
public class FrameSwitch {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\uitests\\html\\FrameSwitch.html");
        driver.manage().window().maximize();

        // 利用id来切换
        WaitTimeUtil.sleep(2000);
        driver.switchTo().frame("if");
        WaitTimeUtil.sleep(2000);
        if (driver.findElement(By.xpath("//*[@id='kw']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("switch successfully");
            // 切换到父frame
            driver.switchTo().parentFrame();
            try {
                driver.findElement(By.xpath("//*[@id='kw']"));
            } catch (NoSuchElementException e) {
                String js = "alert(\"switch to parent\")";
                ((JavascriptExecutor) driver).executeScript(js);
                WaitTimeUtil.sleep(3000);
                driver.switchTo().alert().dismiss();
            }
        }

        // 利用name来切换
        WaitTimeUtil.sleep(2000);
        driver.switchTo().frame("nf");

        WaitTimeUtil.sleep(2000);
        if (driver.findElement(By.xpath("//*[@id='kw']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("switch successfully");
            driver.switchTo().parentFrame();
            try {
                driver.findElement(By.xpath("//*[@id='kw']"));
            } catch (NoSuchElementException e) {
                String js = "alert(\"switch to parent\")";
                ((JavascriptExecutor) driver).executeScript(js);
                WaitTimeUtil.sleep(3000);
                driver.switchTo().alert().dismiss();
            }
        }

        // 利用定位元素来切换-xpath
        WaitTimeUtil.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='if']")));

        WaitTimeUtil.sleep(2000);
        if (driver.findElement(By.xpath("//*[@id='kw']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("switch successfully");
            driver.switchTo().parentFrame();
            try {
                driver.findElement(By.xpath("//*[@id='kw']"));
            } catch (NoSuchElementException e) {
                String js = "alert(\"switch to parent\")";
                ((JavascriptExecutor) driver).executeScript(js);
                WaitTimeUtil.sleep(3000);
                driver.switchTo().alert().dismiss();
            }
        }

        // 利用定位元素来切换-css
        WaitTimeUtil.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("#if")));

        WaitTimeUtil.sleep(2000);
        if (driver.findElement(By.xpath("//*[@id='kw']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("switch successfully");
            driver.switchTo().parentFrame();
            try {
                driver.findElement(By.xpath("//*[@id='kw']"));
            } catch (NoSuchElementException e) {
                String js = "alert(\"switch to parent\")";
                ((JavascriptExecutor) driver).executeScript(js);
                WaitTimeUtil.sleep(3000);
                driver.switchTo().alert().dismiss();
                driver.quit();
            }
        }

    }
    }
