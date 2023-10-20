package Manager;

import Models.Contact;
import Models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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
        return list.iterator();
    }

        @DataProvider
        public Iterator<Object[]> userDTO1 () {
            List<Object[]> list = new ArrayList();

            list.add(new Object[]{
                    Contact.builder()
                            .name("Petr")
                            .lastName("Gavrilov")
                            .phone("1231231232")
                            .address("Hezlas")
                            .description("asdasdasd")
                            .email("petr@gmail.com").build()

            });
            list.add(new Object[]{
                    Contact.builder()
                            .name("Petr")
                            .lastName("Gavrilov")
                            .phone("1231231232")
                            .address("Hezlas")
                            .description("asdasdasd")
                            .email("oetr@gmail.com").build()

            });
            list.add(new Object[]{
                    Contact.builder()
                            .name("Petr")
                            .lastName("Gavrilov")
                            .phone("1231231232")
                            .address("Hezlas")
                            .description("asdasdasd")
                            .email("letr@gmail.com").build()

            });

            return list.iterator();
        }

    @DataProvider
    public Iterator<Object[]> registrationDTO() throws IOException {
        List<Object[]> list = new ArrayList();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/reg_data_set.csv")));
String line = reader.readLine();
while(line != null){
    String[]split=line.split(",");
    list.add(new Object[]{
            User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()
    });
    line=reader.readLine();
}

reader.close();
return list.iterator();
    }


}



