package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.utilsxinxin.WaitTimeUtil;


/**
 * Created by lixx on 2018-10-07.
 * 向textarea文本框输入内容
 */
public class TextareaInput {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\html\\textarea.html");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#id")).sendKeys("input text----");

        //利用JS来输入内容
        WaitTimeUtil.sleep(5000);
        String text = "input by js";
        String js = "var sum = document.getElementById('id'); sum.value='" + text + "';";
        System.out.println(js);
        ((JavascriptExecutor) driver).executeScript(js);
    }
}
