package uitests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by lixx on 2018-10-07.
 * 窗口截图
 */
public class ScreenShotTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");

        //截图到output
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String savePath = "F:\\MaYiUIAutoTest\\src\\main\\java\\uitests\\screenshot\\screenshot.png";
            //复制内容到指定文件中
            FileUtils.copyFile(srcFile, new File(savePath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
