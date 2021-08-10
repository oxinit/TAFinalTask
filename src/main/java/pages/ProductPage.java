package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@id='imgTagWrapperId']")
    private WebElement ProductImage;

    //div[@class]//span[@id='price_inside_buybox']
    @FindBy(xpath = "//div[@class]//span[@id='price_inside_buybox']")
    private WebElement ProductBaseCurrentPrice;
    //span[contains(@class,'a-color-price hlb-')]
    @FindBy(xpath = "//span[contains(@class,'a-color-price hlb-')]")
    private List<WebElement> CartCurrentPrice;

    @FindBy(xpath = "//div[@id='availability']//span[contains(@class,'success')]")
    private WebElement inStockInscription;
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void isVisibleProductImage() {
        ProductImage.isDisplayed();
    ProductImage.isEnabled();
    }
    public void isVisibleProductBaseCurrentPrice() {
        ProductBaseCurrentPrice.isDisplayed();
        ProductBaseCurrentPrice.isEnabled();
    }
    public String getTextCartCurrentPrice(){
        return CartCurrentPrice.get(1).getText();
    }
    public String getTextProductBaseCurrentPrice(){
        return ProductBaseCurrentPrice.getText();
    }
    public void isVisibleinStockInscription() {
        inStockInscription.isDisplayed();
        inStockInscription.isEnabled();
    }
}
