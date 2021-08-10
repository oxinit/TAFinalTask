package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EssentialsForGamersPage extends BasePage{
    @FindBy(xpath = "//h1[contains(text(),'Feature')]")
    private WebElement InscriptionFeaturedCategories;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement AddToCartButton;
    @FindBy(xpath = "//div//img[contains(@alt,'Chairs')]/parent::div")
    private WebElement ChairsCategory;
    //div[@class='a-section a-spacing-medium']

    @FindBy(xpath = "//img[@class='s-image']/parent::div")
    private List<WebElement> ProductsElementsList;

    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    private WebElement CartIconWithQuantity;
    public EssentialsForGamersPage(WebDriver driver) {
        super(driver);
    }

    public void openChairsForGamersPage(String url) {
        driver.get(url);
    }
    public Boolean isInscriptionContainsFeaturedCategories(){
        return InscriptionFeaturedCategories.getText().contains("Featured Categories");
    }
    public void clickChairsCategory(){
        ChairsCategory.click();
    }
    public void clickAddToCartButton() {
        AddToCartButton.click();
    }
    public void clickProductElement(final int i ){
        ProductsElementsList.get(i).click();
    }
    public String getQuantityFromCartIconWith(){
        return CartIconWithQuantity.getText();
    }

}
