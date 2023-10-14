package Manager;

import Models.Contact;
import Models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{
                User.builder()
                        .email("michat@def.com").password("$Romanovski123454")
                        .build()
        });

        list.add(new Object[]{
                User.builder()
                        .email("michat@def.com").password("$Romanovski123454")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("michat@def.com").password("$Romanovski123454")
                        .build()
        });


        list.add(new Object[]{
                Contact.builder()
                        .name("Petr")
                        .lastName("Gavrilov")
                        .phone("1231231232")
                        .address("Hezlas")
                        .description("asdasdasd")
                        .email("petr@gmail.com").build()

        });




        return list.iterator();
    }








}









