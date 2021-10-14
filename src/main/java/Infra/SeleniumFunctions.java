package Infra;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

public class SeleniumFunctions {

    public void clickOnButton(WebDriver driver , String locator)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(41))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                WebElement timer = driver.findElement(By.cssSelector(locator));
                String messageTimer = timer.getText();

                if (messageTimer.equals("Buzz Buzz"))
                {
                    System.out.println("The Sound Of An Opportunity Clock Is " + messageTimer);
                    return timer;
                }
                else
                {
                    timer.click();
                    return null;
                }

            }
        });
    }
}
