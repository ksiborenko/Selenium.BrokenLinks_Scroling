import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class Main {

    private WebDriver driver;
    private Scroller scroller;
    private BrokenLink brokenLink;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.scroller = new Scroller(this.driver);
        this.brokenLink = new BrokenLink(this.driver);
    }

    @Test
    public void scroller() {
        this.scroller.scroll();
    }

    @Test
    public void brokenLink() throws IOException {
        this.brokenLink.test();
    }
}
