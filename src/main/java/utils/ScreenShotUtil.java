package utils;

import constants.SysConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {

    WebDriver driver ;

    public ScreenShotUtil() {
        this.driver = new FirefoxDriver();
    }

    //调用屏幕截图方法
    public static void getSaveImg(String url ,String imgName){
        ScreenShotUtil screenShotUtil = new ScreenShotUtil();
        //断言
        screenShotUtil.getSaveImg1(url,imgName);
    }
    private void getSaveImg1(String url ,String imgName){
        //打开浏览器
        driver.get(url);
        //   截图到output
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String savePath = SysConfig.caseImgPath;
            imgName = System.currentTimeMillis()+imgName;
            //复制内容到指定文件中
            FileUtils.copyFile(srcFile, new File(savePath+File.separator+imgName));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }




}
