import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    /**
     *
     * @param productNameTitle: Name of the item to search
     * @param searchText: Text received to start searching the item
     */
    @Test
    @Parameters({"productNameTitle", "searchText"})
    public void searchTest(String productNameTitle, String searchText){
        Assert.assertTrue(getMainPage().searchItem(searchText).validateSearchSucceed());
        Assert.assertTrue(getMainPage().validatePresenceOfResult(productNameTitle));
        getMainPage().selectProductWithTitle(productNameTitle);
        Assert.assertTrue(getMainPage().validateContentTitleResult(productNameTitle));
        Assert.assertTrue(getMainPage().paperBackTabIsDisplayed());
        Assert.assertTrue(getMainPage().validateAddCartButtonExists());
        Assert.assertTrue(getMainPage().validateBuyNowButtonExists());
    }
}
