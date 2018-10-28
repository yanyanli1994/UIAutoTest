package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by lixx on 2018-10-06.
 * 上传文件
 */
public class UploadTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\html\\UploadTest.html");
        driver.manage().window().maximize();

        String path = System.getProperty("user.dir") + "\\src\\main\\java\\html\\UploadTest.html";
        File file = new File(path);
        if (file.exists()){
            //找到input，然后利用sendKeys来上传文件
            driver.findElement(By.name("file")).sendKeys(file.getPath());
            System.out.println(file.getPath());
        }
        driver.quit();
    }
}
