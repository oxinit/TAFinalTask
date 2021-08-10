package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }
    public LoginRegistrationPage getLoginRegistrationPage(){return  new LoginRegistrationPage(driver);}
    public AmazonBasicsPage getAmazonBasicsPage(){return  new AmazonBasicsPage(driver);}
    public EssentialsForGamersPage getEssentialsForGamersPage(){return new EssentialsForGamersPage(driver);}
    public ProductPage getProductPage(){return new ProductPage(driver);}

}
