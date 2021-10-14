//import Infra.DevToolsFunctions;
import Infra.DevToolsFunctions;
import Infra.FactoryDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import pages.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class loginTest {

    private static final String CONFIG_PATH = "src/test/resources/testconfig.properties";
    public static final String BROWSER_PATH = "driver/chromedriver.exe";
    public static final String HOME_URL = "home.url";
    public static WebDriver driver;
    private static DevTools devTools;
    LoginPage loginPage;
    DevToolsFunctions devToolsFunctions;

    @BeforeAll
    static void setUpAll() {
        try {

            System.out.println("loading configuration");
            String path = new File(CONFIG_PATH).getAbsolutePath();
            InputStream input = new FileInputStream(path);
            // load a properties file
            Properties prop = new Properties();
            prop.load(input);
            FactoryDriver factoryDriver = new FactoryDriver(prop);
            driver = factoryDriver.getWebDriverInstance();
            driver.get(prop.getProperty("home.url"));
        } catch (Exception exception) {
            System.out.println("Error");
        }

    }

    @Test
    @DisplayName("login in to live map")
    void testLoginInData() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver);
        loginPage.pressLiveMapButton();
        loginPage.insertLocationsData("Kiryat ATA" , "Kiryat Yam");

        String current_title = driver.getTitle();
        System.out.println(current_title);

    }
    @Test
    @Description("Check the routs ")
    public void routsTest(){
        loginPage = new LoginPage(driver);
        List routeList = new ArrayList();
//        routeList = loginPage.getRouts();

    }
    @Test
    public void location(){
        devToolsFunctions = new DevToolsFunctions();
        devToolsFunctions.getMatrix(driver);
        System.out.println("hii");

    }

    @AfterAll
    static void teardown(){
        driver.close();
    }
}
