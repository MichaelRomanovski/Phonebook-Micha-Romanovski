import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogintTests
{
    WebDriver wd;
    @BeforeMethod

    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @Test
    public void loginPositiveTest(){
        //open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();


        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("michas@def.com");
        WebElement PasswordInput = wd.findElement(By.xpath("//input[2]"));
        PasswordInput.click();
        PasswordInput.clear();
        PasswordInput.sendKeys("$Romanovski123456");


                //click on login button
        wd.findElement(By.xpath("//button[1]")).click();
     //assert
        pause(3000);
        Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0);

    }
    @Test
    public void loginNegativeTestWrongEmail() {
        //open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();



        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("michasdef.com");
        WebElement PasswordInput = wd.findElement(By.xpath("//input[2]"));
        PasswordInput.click();
        PasswordInput.clear();
        PasswordInput.sendKeys("$Romanovski123456");



        //click on login button
        wd.findElement(By.xpath("//button[1]")).click();
        //assert

        pause(3000);


    }
@Test
public void invalidpassword(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    WebElement inputEmail = wd.findElement(By.xpath("//input[1]"));
    inputEmail.click();
    inputEmail.clear();
    inputEmail.sendKeys("michas@def.com");
    WebElement password = wd.findElement(By.xpath("//input[2]"));
password.click();
password.clear();
password.sendKeys("Romanovski123456");
wd.findElement(By.xpath("//button[1]")).click();


}



        public void pause(int millis){
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}









}
