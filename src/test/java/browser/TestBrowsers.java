package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lixx on 2018-09-10.
 * 多个浏览器调用方式
 */
public class TestBrowsers {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        Browsers browsers=new Browsers(BrowsersType.chrome);
        driver=browsers.driver;
    }
    
    @Test
    public void start(){
        driver.get("http:www.126.com");
        driver.findElement(By.name("email")).clear();
        driver.findElements(By.xpath(".//*[@name='email']")).clear();
        driver.findElement(By.xpath(".//*[@name='email']")).sendKeys("FireflyAutomation");
        driver.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
        driver.findElement(By.xpath("//input[@id='pwdInput']")).submit();
        Assert.assertEquals(true,true);
    }

}
