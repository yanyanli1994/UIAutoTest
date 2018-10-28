package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lixx on 2018-10-06.
 * 显示等待
 */
public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        //标题是不是"百度一下，你就知道"
        new WebDriverWait(driver,5).until(ExpectedConditions.titleIs("百度一下，你就知道"));
        //标题是不是包含"百度一下"
        new WebDriverWait(driver,5).until(ExpectedConditions.titleContains("百度一下"));
        //判断该元素是否被加载DOM中，并不代表该元素一定可见
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='kw']")));
        //判断元素(定位后)是否可见
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='kw']"))));
        //判断元素是否可见（非隐藏，并且元素的宽和高都不等以0）
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='kw']")));
        //只要存在一个就是true
        ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='kw']"));
        //元素中的text是否包含语气的字符串
        ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='kw']"), "百度一下");
        //元素的value属性中是否包含语气的字符串
        ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id='kw']"), "***");
        //判断该表单是否可以切过去，可以就切过去并返回true，否则放回false
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("**"));
        //判断某个元素是否不存在于DOM或不可见
        ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='kw']"));
        //判断元素是否可以点击
        ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='kw']"));
        //等到一个元素从DOM中移除
        ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[@id='kw']")));
        //判断某个元素是否被选中，一般用在下拉列表
        ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='kw']"));
        //判断某个元素的选中状态是否符合预期
        ExpectedConditions.elementSelectionStateToBe(By.xpath("//*[@id='kw']"), true);
        //判断某个元素(已定位)的选中状态是否符合预期
        ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.xpath("//*[@id='kw']")), false);
        //判断页面中是否存在alert
        new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
        //--------------------自定义判断条件-----------------------------
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !driver.findElement(By.xpath("//*[@id='kw']")).getAttribute("class").contains("x-form-invalid-field");
            }
        });

    }
}
