import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLink {

    private final WebDriver driver;
    private SoftAssert softAssert;

    public BrokenLink(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }

    public void test() throws IOException {
        this.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> urls = this.driver.findElements(By.cssSelector("#gf-BIG a"));
        HttpURLConnection connection;
        String url;
        int respCode;
        for (WebElement webElement : urls) {
            url = webElement.getAttribute("href");
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            respCode = connection.getResponseCode();
            this.softAssert.assertTrue(respCode < 400, "Broken url: " + url + ", with server response code: " + respCode + ',');
        }
        this.softAssert.assertAll();
    }
}
