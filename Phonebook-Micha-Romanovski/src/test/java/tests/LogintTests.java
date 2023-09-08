package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

public class LogintTests extends testBase {

    @Test
    public void loginPositiveTest()
    {

        //open login form

        app.getUser().openLoginregistrationForm();
//fill loginFOrm
        app.getUser().fillLoginregistrationForm("michat@def.com", "$Romanovski123454");

        // click on login button
        app.getUser().submitLogin();

        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isElementPresent(
                By.tagName("button")));
        app.getUser().logout();


    }


    @Test
    public void login_Negative_Test_WrongEmail() {

        //open login form


app.getUser().openLoginregistrationForm();

        app.getUser().fillLoginregistrationForm("michatdef.com", "$Romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isAlertPresent());





        app.getUser().fillLoginregistrationForm("michat@def.", "$Romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isAlertPresent());






        app.getUser().fillLoginregistrationForm("12345@def.com", "$Romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isAlertPresent());






    }






































    @Test
public void WrongPassword_Login_Tests(){


                            //test 1(without symbols)
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("michat@def.com","Romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(4000);
        Assert.assertTrue(app.getUser().isAlertPresent());



                                                     //test 2(low case characters)
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("michat@def.com","$romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(4000);
        Assert.assertTrue(app.getUser().isAlertPresent());






    }







}