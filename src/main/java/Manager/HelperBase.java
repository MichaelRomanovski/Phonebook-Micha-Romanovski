package Manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase
{
    WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 8)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return false;
        wd.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }




        public void pause (int millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public boolean isElementPresent (By locator)
        {
            return wd.findElements(locator).size() > 0;
        }
        public void type (By locator, String text)
        {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
        public void click (By locator)
        {
            wd.findElement(locator).click();
        }

        public void takeScreenshot(String link)  {
    File file=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
    File screenshot=new File(link);
    try {
        Files.copy(file, screenshot);
    }catch (IOException e) {
        e.printStackTrace();
    }


        }




    }

