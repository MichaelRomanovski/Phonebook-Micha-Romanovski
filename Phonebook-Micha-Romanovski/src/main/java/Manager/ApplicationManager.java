package Manager;

import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{


Logger logger=LoggerFactory.getLogger(ApplicationManager.class);

  //  WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
String browser;
    public ApplicationManager(String browser)


    {
        this.browser = browser;
    }
    @Getter
  HelperContact helperContact;

    public void init(){
        String link=("https://telranedu.web.app/home");
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

    public void tearDown()
    {

        wd.quit();

    }

    public HelperUser getUser()

    {
        return user;
    }
}





