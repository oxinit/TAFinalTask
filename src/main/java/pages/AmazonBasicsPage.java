package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonBasicsPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-section a-spacing-medium']")
    private List<WebElement> ProductsElementsList;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement AddToCartButton;
    @FindBy(xpath = "//h1[contains(text(),'Added to')]")
    private WebElement ProductAddedToCartInscription;
    public AmazonBasicsPage(WebDriver driver) {
        super(driver);
    }

    public void waiterForFirstElementProduct() {
        this.waitVisibilityOfElement(30, ProductsElementsList.get(0));
    }

    public void clickFirstElementProduct() {
        ProductsElementsList.get(0).click();
    }

    public void clickAddToCartButton() {
        AddToCartButton.click();
    }
    public void waiterProductAddedToCartInscription() {
        this.waitVisibilityOfElement(30, ProductAddedToCartInscription);
    }
    public boolean isVisibleProductAddedToCartInscription(){
        return ProductAddedToCartInscription.isDisplayed();
    }
    public String getTextProductAddedToCartInscription(){
        return ProductAddedToCartInscription.getText();
    }
    public void clickSecondElementProduct() {
        ProductsElementsList.get(1).click();
    }
}
