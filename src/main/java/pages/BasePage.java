package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, String url, int seconds){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, seconds);
        driver.get(url);
    }

    public WebDriver getDriver(){ return driver; }

    public WebDriverWait getWait(){ return wait;}

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    protected void clickElement(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected boolean elementExist(WebElement element){
        try {
            getWait().until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
