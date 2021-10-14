package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;

import java.util.List;
import java.util.Optional;

public class DevToolsFunctions {
    public void getMatrix(WebDriver driver){
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        for(Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }
}
