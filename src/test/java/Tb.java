import browser.Browsers;
import browser.BrowsersType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Tb {
    private WebDriver driver;






    @Test
    public void login(String username,String password){
        //获取Driver
        Browsers browsers=new Browsers(BrowsersType.chrome);
        driver=browsers.driver;
        driver.get("http://www.taobao.com/");
        //将屏幕最大化
        driver.manage().window().maximize();
        driver.findElement(By.linkText("密码登录")).click();
        driver.findElement(By.name("TPL_username")).sendKeys(username);
        driver.findElement(By.name("TPL_password")).sendKeys(password);
    }
}
