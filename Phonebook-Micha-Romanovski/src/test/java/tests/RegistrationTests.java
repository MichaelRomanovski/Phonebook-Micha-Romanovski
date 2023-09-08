package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends testBase {
    @Test
    public void testPositiveRegistration(){
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("myamail@def.com","$Romanovski123454");
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[.='CONTACTS']")));
        app.getUser().logout();

    }


    @Test
    public void testNegativeRegistrationEmail(){
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("michasdef.com","$Romanovski123454");
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isAlertPresent());


    }







    }








