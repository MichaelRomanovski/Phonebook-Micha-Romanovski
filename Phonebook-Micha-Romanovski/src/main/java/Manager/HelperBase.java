package Manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase
{
    WebDriver wd;

public HelperBase (WebDriver wd){

this.wd=wd;

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


    }

