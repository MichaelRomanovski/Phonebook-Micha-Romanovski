package Manager;


import Models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{

WebDriver wd;

  public HelperContact(WebDriver wd) {
        super(wd);
    }

public void openAddContactItem(){

        click(By.cssSelector("a[href='/add']"));

}

public void fillContactsFields(Contact contact) {

        type(By.xpath("//*[@placeholder='Name']"),contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"),contact.getName());
        type(By.xpath("//*[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"),contact.getDescription());

}
public void clickOn_Save_Button(){

        click(By.xpath("//b[.='Save']"));


}


public void deleteContact(){



}


}
