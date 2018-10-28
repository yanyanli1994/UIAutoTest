package uitests;

import Utils.WaitTimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lixx on 2018-10-06.
 * 多选框
 */
public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\html\\CheckBox.html");
        driver.manage().window().maximize();
        List<WebElement> WebElements = driver.findElements(By.cssSelector("[type=checkbox]"));
        Iterator iterator=WebElements.iterator();
        //全部勾选
        while (iterator.hasNext()){
            WebElement wb=(WebElement) iterator.next();
            wb.click();
        }
        //去掉第一个
        WaitTimeUtil.sleep(3000);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        //去掉最后一个
        WaitTimeUtil.sleep(3000);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(WebElements.size()-1).click();
        WaitTimeUtil.sleep(3000);
        driver.quit();

    }
}
