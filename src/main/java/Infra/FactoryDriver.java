package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class FactoryDriver {

    private final String CHROMEDRIVER_EXE_PATH;
    private final String browser;
    public WebDriver driver;
    public WebDriverManager wdm;
    DesiredCapabilities desiredCapabilities;

    public FactoryDriver(Properties prop) {
        this.browser = prop.getProperty("browser.type");
        this.CHROMEDRIVER_EXE_PATH = prop.getProperty("chrome.driver.path");


    }

    public WebDriver getWebDriverInstance() throws MalformedURLException {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }
        if (browser.equals("remote")) {
//            ChromeOptions options = new ChromeOptions();
//            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),options);
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setBrowserName("chrome");
            driver = WebDriverManager.chromedriver()
                    .remoteAddress("http://localhost:4445/wd/hub").create();
//            driver = new RemoteWebDriver(
//                    new URL("http://localhost:4444/wd/hub"), caps);
            return driver;
        }

        return driver;
    }
}

//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.operadriver().setup();
//        WebDriverManager.phantomjs().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.iedriver().setup();
