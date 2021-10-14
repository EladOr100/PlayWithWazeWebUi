package pages;

import Infra.SeleniumFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginPage {
    WebDriver driver;
    String LIVE_MAP = "a[href=\"/livemap?utm_source=waze_website&utm_campaign=waze_website&utm_medium=website_menu\"]";
    String CARPOOL_BUTTON = "a[href=\"/carpool\"]";
    String GOT_IT_ACKNOWLEDGE_BUTTON = ".waze-tour-tooltip__acknowledge";
    String SEARCH_FROM_BUTTON = ".wz-search-container.is-origin> div >div >input";
    String SEARCH_TO_BUTTON = ".wz-search-container.is-destination> div >div >input";
    String FROM_TO_ARRAY = ".wm-marker-label__text";
    String ROUTS = ".wm-routes__list";
    int TTW = 3000;
    WebDriverWait wait;
    SeleniumFunctions seleniumFunctions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        this.seleniumFunctions = new SeleniumFunctions();
    }

    public void pressLiveMapButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(LIVE_MAP)).click();
        //seleniumFunctions.clickOnButton(driver , GOT_IT_ACKNOWLEDGE_BUTTON);
       // Thread.sleep(TTW);
        wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(GOT_IT_ACKNOWLEDGE_BUTTON)));
        driver.findElement(By.cssSelector(GOT_IT_ACKNOWLEDGE_BUTTON)).click();
    }

    public void insertLocationsData(String from, String to) throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(TTW);

        WebElement s_frontButton = driver.findElement(By.cssSelector(SEARCH_FROM_BUTTON));
        s_frontButton.sendKeys(from);
        Thread.sleep(TTW);
        s_frontButton.sendKeys(Keys.ENTER);
        Thread.sleep(TTW);

//        WebElement s_totButton = driver.findElement(with(By.tagName("input")).below(s_frontButton));
//        s_totButton.sendKeys(to);
      //


        Thread.sleep(TTW);

        driver.findElement(By.cssSelector(SEARCH_TO_BUTTON)).sendKeys(to);
        Thread.sleep(TTW);

        driver.findElement(By.cssSelector(SEARCH_TO_BUTTON)).sendKeys(Keys.ENTER);

        Thread.sleep(TTW);


        driver.findElement(By.cssSelector(GOT_IT_ACKNOWLEDGE_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(FROM_TO_ARRAY)));

        Thread.sleep(TTW);


        List<WebElement> element = driver.findElements(By.cssSelector(FROM_TO_ARRAY));

        driver.findElement(By.cssSelector(ROUTS));

        for (int i = 0; i < element.size(); i++) {
            File file = element.get(i).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("logo" + i + ".png"));
            System.out.println(element.get(i).getText());
        }
    }

//    public List getRouts() {
//        List routesList = new ArrayList();
//        driver.findElement(By.cssSelector(ROUTS));
//        return routesList;
//    }
}
