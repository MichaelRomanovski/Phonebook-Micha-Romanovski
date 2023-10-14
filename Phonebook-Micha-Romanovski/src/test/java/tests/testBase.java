package tests;

import Manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class testBase
{

   static ApplicationManager app=new ApplicationManager(
           System.getProperty("browser", BrowserType.FIREFOX)
   );
    Logger logger= LoggerFactory.getLogger(testBase.class);
    @BeforeMethod(alwaysRun = true)
    public void logoBeFOREmETHOD(Method method){


        logger.info("Test is started: " + method.getName() );
    }

@AfterMethod(alwaysRun = true)
public void logoAfterMethod(Method method){

        logger.info("test is finished " + method.getName());
logger.info("============================================================================");
}

    @BeforeSuite(alwaysRun = true)

public void setup()
    {

      app.init();

    }

@AfterSuite(alwaysRun = true)
public void stop(){

        app.tearDown();


}









}
