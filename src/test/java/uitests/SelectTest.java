package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lixx on 2018-10-08.
 * 下拉框
 */
public class SelectTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("F:\\MaYiUIAutoTest\\src\\main\\java\\uitests\\html\\SelectTest.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("id1")).sendKeys("4");
        Select sel = new Select(driver.findElement(By.name("calc")));
        sel.selectByValue("/");
        driver.findElement(By.id("id3")).sendKeys("2");
        driver.findElement(By.id("id4")).click();
        System.out.println(driver.findElement(By.id("id5")).getAttribute("value"));
        ////////////////////////////////////////////////////////////////////
        driver.findElement(By.id("id1")).clear();
        driver.findElement(By.id("id1")).sendKeys("3");
        Select sel2  = new Select(driver.findElement(By.name("calc")));
        sel2.selectByValue("+");
        driver.findElement(By.id("id3")).clear();
        driver.findElement(By.id("id3")).sendKeys("1");
        driver.findElement(By.id("id4")).click();
        System.out.println(driver.findElement(By.id("id5")).getAttribute("value"));
        ////////////////////////////////////////////////////////////////
        driver.findElement(By.id("id1")).clear();
        driver.findElement(By.id("id1")).sendKeys("5");
        Select sel3 = new Select(driver.findElement(By.name("calc")));
        sel3.selectByValue("*");
        driver.findElement(By.id("id3")).clear();
        driver.findElement(By.id("id3")).sendKeys("6");
        driver.findElement(By.id("id4")).click();
        System.out.println(driver.findElement(By.id("id5")).getAttribute("value"));
        ////////////////////////////////////////////////////////////////
        driver.findElement(By.id("id1")).clear();
        driver.findElement(By.id("id1")).sendKeys("100");
        Select sel4 = new Select(driver.findElement(By.name("calc")));
        sel4.selectByValue("-");
        driver.findElement(By.id("id3")).clear();
        driver.findElement(By.id("id3")).sendKeys("1");
        driver.findElement(By.id("id4")).click();
        System.out.println(driver.findElement(By.id("id5")).getAttribute("value"));

        Select selall = new Select(driver.findElement(By.name("calc")));
        List<WebElement> lw = selall.getOptions();
        Iterator<WebElement> iterator = lw.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getAttribute("value"));
        }
    }
}
