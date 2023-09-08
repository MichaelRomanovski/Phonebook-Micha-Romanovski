package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase
{
    public HelperUser(WebDriver wd){

        super(wd);


    }



    public void openLoginregistrationForm(){

        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginregistrationForm(String email,String password){

        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }

    public void submitLogin(){

        wd.findElement(By.xpath("//button[1]")).click();

    }

    public void submitRegistration(){
        wd.findElement(By.xpath("//button[2]")).click();

    }

    public boolean isLogged()
    {
        return isElementPresent(By.xpath("*[.='Sign Out']"));

    }

    public void logout(){
        //  Sign out
        click(By.xpath("//*[.='Sign Out']"));

    }



}
