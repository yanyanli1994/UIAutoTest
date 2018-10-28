package uitests;

import Utils.WaitTimeUtil;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lixx on 2018-10-07.
 * 操作Cookie
 */
public class CookieOperation {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        //获取所有cookie个数
        System.out.println(driver.manage().getCookies().size());
        //增加cookie
        Cookie cookie = new Cookie("username","name","/",null);
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(new Cookie("password","ppppwwww","/",null));

        //以name获取cookie
        String name = driver.manage().getCookieNamed("username").getValue();
        String info = "用户名是：" + name;
        String js = "alert(\"" + info + "\" )";
        System.out.println(js);
        ((JavascriptExecutor)driver).executeScript(js);
        WaitTimeUtil.sleep(5000);
        driver.switchTo().alert().dismiss();

        //以name删除cookie
        driver.manage().deleteCookieNamed("password");
        //再次获取所有cookie个数，应该比之前多一个
        System.out.println(driver.manage().getCookies().size());
        driver.quit();
    }
}
