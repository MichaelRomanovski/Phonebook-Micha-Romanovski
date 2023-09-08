package tests;

import Manager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class testBase
{

   static ApplicationManager app=new ApplicationManager();

    @BeforeSuite

public void setup(){
      app.init();

    }

@AfterSuite
public void stop(){

        app.tearDown();


}









}
