package tests;

import Manager.NGListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class RegistrationTests extends testBase {
    @Test
    public void testPositiveRegistration(){

String email="usot@def.com";
String password="$Rtyui@1234";
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[.='CONTACTS']")));

//logger.info("======================================================================================");
        //logger.info("registration possitive tests started with"+email+"&"+password);
        app.getUser().logout();
    }


    @Test(groups = {"negative"})
    public void testNegativeRegistrationEmail(){


        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("user@def.","$Rtyui@1234");
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
  //      logger.info("==========================================================================");
        //logger.info("registration negative test starts with " +"email:user@def." + "&" + "password:$Rtyui@1234");
        Assert.assertTrue(app.getUser().isAlertPresent());

    }







    }








