package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver, String url, int seconds) {
        super(driver, url, seconds);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//span[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']")
    private WebElement resultInfoBar;

    @FindBy(css = "span.a-size-base-plus.a-color-base.a-text-normal")
    private List<WebElement> resultTitle;

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    @FindBy(css = "li[id='mediaTab_heading_2']>a[aria-selected='true']")
    private WebElement paperBackTabText;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    @FindBy(id = "buy-now-button")
    private WebElement buyNowBtn;

    public MainPage searchItem(String item){
        clickElement(searchBox);
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean validateSearchSucceed() {
        try{
            getWait().until(ExpectedConditions.visibilityOf(resultInfoBar));
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean validatePresenceOfResult(String title){
        return resultTitle.stream().anyMatch(element -> element.getText().contains(title));
    }

    public MainPage selectProductWithTitle(String title){
        WebElement w = resultTitle.stream().parallel().filter(element -> element.getText().contains(title)).findFirst().get();
        clickElement(w);
        return this;
    }

    public boolean validateContentTitleResult(String title){
        getWait().until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText().contains(title);
    }

    public boolean paperBackTabIsDisplayed(){
        return paperBackTabText.isDisplayed();
    }

    public boolean validateAddCartButtonExists(){
        return elementExist(addToCartBtn);
    }

    public boolean validateBuyNowButtonExists(){
        return elementExist(buyNowBtn);
    }

}
