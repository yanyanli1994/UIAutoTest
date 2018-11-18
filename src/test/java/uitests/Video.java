package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.utilsxinxin.WaitTimeUtil;


/**
 * Created by lixx on 2018-10-08.
 * selenium（java）处理HTML5的视频播放
 */
public class Video {
    public static void main(String[] args) {
        System.out.println("chrome driver");
        WebDriver driver = new ChromeDriver();
        //打开浏览器
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\uitests\\html\\Vedio.html");
        //定位视频播放控件
        WebElement video = driver.findElement(By.xpath("/html/body/video"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //获得视频的URL
        jse.executeScript("return arguments[0].currentSrc",video);
        //播放视频，播放15s
        jse.executeScript("return arguments[0].play()",video);
        WaitTimeUtil.sleep(15000);
        // 暂停视频
        jse.executeScript("arguments[0].pause()", video);
        driver.quit();


    }

}
