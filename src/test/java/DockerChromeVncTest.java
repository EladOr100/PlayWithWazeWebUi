//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v85.performance.Performance;
//import org.openqa.selenium.devtools.v85.performance.model.Metric;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//class GetMetrics {
//
//    final static String PROJECT_PATH = System.getProperty("user.dir");
//
//    public static void main(String[] args){
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//        devTools.send(Performance.enable(Optional.empty()));
//        List<Metric> metricList = devTools.send(Performance.getMetrics());
//
//        driver.get("https://google.com");
//        driver.quit();
//
//        for(Metric m : metricList) {
//            System.out.println(m.getName() + " = " + m.getValue());
//        }
//    }
//}