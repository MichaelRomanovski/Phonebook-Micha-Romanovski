package tests;

import Manager.NGListener;
import Manager.ProviderData;
import Models.Contact;
import Models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class addNewContact extends testBase
{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getUser().isLogged()){

            app.getUser().login(User.builder()
                            .email("michat@def.com")
                            .password("$Romanovski123454").
                    build());

        }

    }

@Test(invocationCount = 5,groups = {"positive","smoke"})

    public void possitiveAddnewContact() {
    int i=(int)(System.currentTimeMillis()/1000)&3600;
    Contact contact=Contact.builder().
            name("Vasia").
            lastName("Popov").
            phone("1231232312332").
            email("ticsat@def.com")
            .address("Tel Aviv")
            .description("asdasd").
            build();

app.getHelperContact()
        .openAddContactItem();
app.getHelperContact().fillContactsFields(contact);
app.getHelperContact().clickOn_Save_Button();
app.getHelperContact().pause(3000);


}@Test(invocationCount = 5,groups = {"positive","smoke"},
        dataProvider = "userDTO",dataProviderClass = ProviderData.class)

    public void possitiveAddnewContactUserDTO(Contact contact)
{
    //int i=(int)(System.currentTimeMillis()/1000)&3600;

app.getHelperContact()
        .openAddContactItem();
app.getHelperContact().fillContactsFields(contact);
app.getHelperContact().clickOn_Save_Button();
app.getHelperContact().pause(3000);


}

}
