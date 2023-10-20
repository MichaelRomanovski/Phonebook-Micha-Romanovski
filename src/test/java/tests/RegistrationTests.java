package tests;

import Manager.NGListener;
import Manager.ProviderData;
import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class RegistrationTests extends testBase {



    @BeforeMethod(alwaysRun = true)

    public void precondition() {
if(app.getUser().isLogged()){

    app.getUser().logout();

}

    }


    @Test(groups = {"positive"},dataProvider ="registrationDTO",dataProviderClass = ProviderData.class)
    public void testPositiveRegistrationDTO_CSV(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[.='CONTACTS']")));

    }


    @Test(groups = {"negative"})
    public void testNegativeRegistrationEmail(){


        app.getUser().openLoginregistrationForm();
        app.getUser().fillLoginregistrationForm("user@def.","$Rtyui@1234");
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isAlertPresent());

    }



    }











