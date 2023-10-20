package Manager;


import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager
{


Logger logger=LoggerFactory.getLogger(ApplicationManager.class);
  //  WebDriver wd;
    EventFiringWebDriver wd;
    @Getter
    HelperUser user;

  @Getter
  HelperContact helperContact;


    Properties properties;

String browser;
    public ApplicationManager(String browser)


    {

        this.browser = browser;
        properties=new Properties();
    }


    public void init() throws IOException {
        String target=System.getProperty("target","preproduction");
        properties.load(new FileReader(new File("src/test/resources/production.properties")));

         String link=properties.getProperty("web.baseUrl");


if(browser.equals(BrowserType.CHROME)) {
    wd = new EventFiringWebDriver(new ChromeDriver());
    logger.info("Test started on Chrome");
}
else if(browser.equals(BrowserType.FIREFOX)) {
    wd = new EventFiringWebDriver(new FirefoxDriver());
    logger.info("Test started on Firefox");
}
        wd.register(new WdListener());
        wd.navigate().to(link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user=new HelperUser(wd);
helperContact =new HelperContact(wd);

    }


public String getEmail(){

        return properties.getProperty("web.email");
}
public String getPassword(){

        return properties.getProperty("web.password");
}


    public void tearDown()
    {

        wd.quit();

    }













}





