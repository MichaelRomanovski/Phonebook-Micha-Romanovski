package tests;

import Manager.NGListener;
import Manager.ProviderData;
import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LogintTests extends testBase {

    @Test(groups={"positive"})
    public void loginPositiveTest()
    {

        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("michat@def.com","$Romanovski123454");
        app.getUser().submitLogin();
        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isElementPresent(
                By.tagName("button")));
        app.getUser().logout();


    }


@Test(groups = {"positive"},dataProvider = "userDTO",dataProviderClass = ProviderData.class)

    public void loginPositiveUserDTO(User user)
    {

        app.getUser().openLoginregistrationForm();

        app.getUser().fillLoginregistrationForm(user.getEmail(),user.getPassword());

        app.getUser().submitLogin();

        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isElementPresent(
                By.tagName("button")));
        app.getUser().logout();

    }





    @Test(groups ={"negative","smoke"})
    public void login_Negative_Test_WrongEmail() {

app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("michatdef.com","$Romanovski123454");
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


    @Test(groups = {"Negative","smoke"})
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