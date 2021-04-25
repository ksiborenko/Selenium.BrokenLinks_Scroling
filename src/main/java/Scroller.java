import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroller {

    private WebDriver driver;

    public Scroller(WebDriver driver) {
        this.driver = driver;
    }

    public void scroll() {
        this.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        this.driver.manage().window().fullscreen();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.scrollBy(0,650)");
    }

}
