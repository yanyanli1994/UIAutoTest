package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.utilsxinxin.WaitTimeUtil;


/**
 * Created by lixx on 2018-10-06.
 * 警告框处理
 */
public class AlterHandle {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\html\\AlterHandle.html");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#altertest")).click();

        //先等待prompt框的出现，然后输入内容
        try{
            new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().sendKeys("处理告警框的例子");
            //确认输入内容
            WaitTimeUtil.sleep(3000);
            driver.switchTo().alert().accept();
            //获取Alert框内text内容
            WaitTimeUtil.sleep(2000);
            new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
            String inputInfo = driver.switchTo().alert().getText();
            System.out.println(inputInfo);
            // 关闭Alert框
            WaitTimeUtil.sleep(3000);
            driver.switchTo().alert().accept();

            // 利用js构造一个confirm框
            WaitTimeUtil.sleep(3000);
            String js = "confirm(\"这就是一个告警框的例子\")";
            ((JavascriptExecutor) driver).executeScript(js);

            // 取消confirm框
            WaitTimeUtil.sleep(3000);
            driver.switchTo().alert().dismiss();

            WaitTimeUtil.sleep(3000);
            driver.quit();

        } catch (TimeoutException e) {
            driver.quit();
        }
    }
}
