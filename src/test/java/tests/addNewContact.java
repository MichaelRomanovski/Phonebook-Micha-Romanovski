package tests;

import Manager.NGListener;
import Manager.ProviderData;
import Models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class addNewContact extends testBase
{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getUser().isLogged()){

            app.getUser().login(

                    app.getEmail(), app.getPassword()
            );
        }
    }



@Test(groups = {"positive","smoke"},
        dataProvider = "userDTO1",dataProviderClass = ProviderData.class)

    public void possitiveAddnewContactUserDTO(Contact contact)
{
    //int i=(int)(System.currentTimeMillis()/1000)&3600;

app.getHelperContact().openAddContactItem();
app.getHelperContact().fillContactsFields(contact);
app.getHelperContact().clickOn_Save_Button();
app.getUser().logout();
}

}
