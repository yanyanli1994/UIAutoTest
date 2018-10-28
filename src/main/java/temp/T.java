package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Administrator on 2018-10-07.
 */
public class T
{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.jeecms.com/jeeadmin/jeecms/index.do#/role/list");//访问jeecms网站
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/input")).clear();//清除用户名输入框
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/input")).sendKeys("test");//输入用户名
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/input")).clear();//清除秘密输入框
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/input")).sendKeys("test");//输入密码
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();//点击“登录”
        driver.manage().window().maximize();//放大页面
//        WaitTimeUtil.sleep(3000);//睡眠3s
        driver.findElement(By.xpath("//*[@id=\"aside\"]/ul/li[5]/div/span")).click();//点击"用户管理"
//        WaitTimeUtil.sleep(3000);//睡眠3s
        driver.findElement(By.xpath("//*[@id=\"aside\"]/ul/li[5]/ul/li[2]")).click();//点击"角色管理"
        List<WebElement> webElements = driver.findElements(By.cssSelector("a[class='cms-table-button iconfont edit']"));//获取3条数据的修改按钮，通过css
        for (int i=0;i<webElements.size();i++){
            //取出原管理员(第三列的文本信息)
            List<WebElement>  roleName=driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/section/div[2]/div[3]/table/tbody/tr/td[3]/div"));
            String oldRoleName=roleName.get(i).getText();
            //管理员修改
            webElements = driver.findElements(By.cssSelector("a[class='cms-table-button iconfont edit']"));
            webElements.get(i).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/section/a")).click();
            //修改后的管理员
            roleName = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/section/div[2]/div[3]/table/tbody/tr/td[3]/div"));
            String newRoleName=roleName.get(i).getText();
            //比较管理员值是否相等
            if (oldRoleName.equals(newRoleName)){
                System.out.println("成功啦，哈哈哈哈哈哈");
            }

        }

    }
}
