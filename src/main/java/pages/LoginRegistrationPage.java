package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends BasePage{
    @FindBy(xpath = "//h1[contains(text(),'Sign')]")
    private WebElement SignInLabel;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement EmailField;
    @FindBy(xpath = "//span[@class='a-button-inner']//input")
    private WebElement ContinueButton;
    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    private WebElement ErrorBox;
    @FindBy(xpath = "//h4[contains(text(),'There')]")
    private WebElement ErrorMassageWithEmailInput;
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void isVisibleSignInLabel() {
        SignInLabel.isDisplayed();
    }
    public Boolean isVisibleSignInLabel2() {
       return SignInLabel.isDisplayed()&&SignInLabel.isEnabled();
    }
    public void fillEmailField(String searchText) {
        EmailField.isEnabled();
        EmailField.isDisplayed();
        EmailField.clear();
        EmailField.sendKeys(searchText);
    }
    public void clickContinueButton(){
        ContinueButton.click();
    }
    public void isVisibleErrorBox() {
        ErrorBox.isDisplayed();
    }
    public String getTextFormErrorMassageWithEmailInput(){
        return ErrorMassageWithEmailInput.getText();
    }
}
