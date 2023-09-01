import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {
    WebDriver wd;

    @BeforeMethod

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }



    @Test
    public void registrationPositiveTest() {

        //open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();


        //fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("michag_" + i + "@def.com");
        WebElement PasswordInput = wd.findElement(By.xpath("//input[2]"));
        PasswordInput.click();
        PasswordInput.clear();
        PasswordInput.sendKeys("$Romanovsli123456");




        //click on registartion button
        wd.findElement(By.xpath("//button[2]")).click();
        //assert
        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
    }

    @Test
    public void negativeRegistrationLogin(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        WebElement emailInput = wd.findElement((By.xpath("//input[1]")));
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("michadef"+i+".com");
        WebElement PasswordInput = wd.findElement(By.xpath("//input[2]"));
PasswordInput.click();
PasswordInput.clear();
PasswordInput.sendKeys("$Romanovsli123457");


wd.findElement(By.xpath("//button[2]")).click();


    }

    @AfterMethod
    public void close() {


}





}


