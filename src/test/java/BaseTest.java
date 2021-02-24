import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.MainPage;

public class BaseTest {
    private MainPage mainPage;
    private WebDriver driver;

    protected MainPage getMainPage() { return mainPage; }

    @BeforeTest
    @Parameters({"URL", "timeOutSeconds"})
    public void setUp(String url, int seconds){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver, url, seconds);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        mainPage.dispose();
    }
}
