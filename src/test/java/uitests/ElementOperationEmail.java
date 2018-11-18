package uitests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.utilsxinxin.WaitTimeUtil;


/**
 * Created by lixx on 2018-09-16.
 * 简单元素操作
 *   1）清除文本
 *   2）模拟按键输入
 *   3）单击元素
 *   4）提交表单
 *   5）获取元素尺寸
 *   6）获取元素文本
 *   7）获取属性值
 *   8）获取属性值可见
 */
public class ElementOperationEmail {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mail.sina.com.cn/register/regmail.php");
        driver.manage().window().maximize();
        //获取email名称输入框节点，并输入名称
        WebElement emailName = driver.findElement(By.cssSelector("[name=email]"));
        emailName.clear();
        emailName.click();
        emailName.sendKeys("xinxinmengyu8888");
        // 获取email密码输入框节点，在输入密码之前，先验证一下email名称是否可用，如果可用就继续，如果不可用就退出浏览器
        WebElement emailPassword=driver.findElement(By.cssSelector("[name=psw]"));//输入密码
        WebElement emailTwicePassword=driver.findElement(By.cssSelector("[name=npsw]"));//确认密码
        emailPassword.click();//点击一下密码框，使得email名称验证信息出现
        WaitTimeUtil.sleep(3000);
        //获取email名称验证信息节点，并判断信息是否为"左箭头"
        WebElement checkName = driver
                .findElement(By.xpath("uitests/html/body/div[2]/div/div/div/div/form[1]/div[2]/ul/li[1]/div[3]/i"));
        String checkContent = checkName.getText();//通过getText方法来获取节点文本信息
        System.out.println("验证用户名信息是否存在:"+checkName.isDisplayed() + "比对结果信息是:" + checkContent);
        //获取到信息后开始判断，并进行不同的分支
        if ("左箭头".equals(checkContent)){
            //确认名称无误后输入密码
            emailPassword.sendKeys("emailPassword");
            WaitTimeUtil.sleep(3000);
            // 获取验证码输入框节点，在输入验证码之前，先验证一下密码是否有效和密码强度
            WebElement emailImgvcode = driver.findElement(By.cssSelector("[name=imgvcode]"));
            emailImgvcode.click();
            WaitTimeUtil.sleep(3000);
            // 获取密码校验信息节点，并判断时候存在以及信息是否为"密码强度：高"
            WebElement checkPassword = driver.findElement(By.cssSelector("[class=passWord3]"));
            System.out.println(checkPassword.isDisplayed());
            System.out.println(checkPassword.getText());
            if (checkPassword.isDisplayed() && "密码强度：高".equals(checkPassword.getText())){
                //密码校验通过后，获取验证码验证图片节点，并通过以下节点来获取该节点的信息
                WebElement img = driver.findElement(By.cssSelector("[id=capcha]"));
                System.out.println("验证图片的hight是: " + img.getSize().getHeight());
                System.out.println("验证图片的Width是: " + img.getSize().getWidth());
                System.out.println("验证图片的src属性值是: " + img.getAttribute("src"));
                WaitTimeUtil.sleep(3000);
                // 输入验证码,真实环境中selenium很难获取到正确的验证码，如果在测试环境可以通过访问Cookie的方式实现。
                // 这里随意输入一个验证码
                emailImgvcode.sendKeys("1234567890");
                WaitTimeUtil.sleep(3000);
                // 获取提交按钮信息，并通过一些方法来获取该节点的信息
                WebElement submit = driver.findElement(By.cssSelector("[class=subIco]"));
                System.out.println("提交按钮的文本信息是： " + submit.getText());
                System.out.println("提交按钮的class属性值是： " + submit.getAttribute("class"));
                System.out.println("提交按钮的style属性值是： " + submit.getAttribute("style"));
                System.out.println("提交按钮的css属性值是： " + submit.getCssValue("float"));
                System.out.println("提交按钮的href属性值是： " + submit.getAttribute("href"));
                submit.submit();
                WaitTimeUtil.sleep(5000);
                driver.quit();
            } else {
                System.out.println("密码校验信息没有展示或者密码强度低");
                driver.quit();
            }

        } else {
            System.out.println("用户名不可用");
            driver.quit();
        }

    }
}






