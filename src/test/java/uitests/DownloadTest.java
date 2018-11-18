package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.utilsxinxin.WaitTimeUtil;


import java.io.File;

/**
 * Created by lixx on 2018-10-07.
 * 下载文件
 */
public class DownloadTest {
    public static void main(String[] args) {
        FirefoxProfile profile = new FirefoxProfile();
        //可以在Firefox浏览器地址中输入about:config来查看属性
        //设置下载文件放置路径，注意如果是windows环境一定要用\\，用/不行
        String path = "D:\\dowload";
        String downloadFilePath = path + "\\w3school_logo_white.gif";
        File file = new File(downloadFilePath);
        if (file.exists()){
            file.delete();
        }
        //配置响应下载参数
        profile.setPreference("browser.download.dir",path);//下载路径
        profile.setPreference("browser.download.folderList",2);//2为保存到指定路径，0代表默认路径
        profile.setPreference("browser.download.manager.showWhenStarting",false);//是否显示开始
        //禁止弹出保存框，value是文件格式，如zip文件
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/zip,text/plain,application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        //关于类型：可以参考http://www.w3school.com.cn/media/media_mimeref.asp
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\html\\Download.html");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("下载")).click();
        WaitTimeUtil.sleep(3000);
        String js_exist = "alert(\"download successfully\")";
        String js_not_exist = "alert(\"download unsuccessfully\")";
        if (file.exists()){
            ((JavascriptExecutor) driver).executeScript(js_exist);
        }else
        {
            ((JavascriptExecutor) driver).executeScript(js_not_exist);

        }

    }
}
