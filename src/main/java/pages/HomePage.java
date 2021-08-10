package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@id='nav-main']//div[@class='nav-left']")
    private WebElement AllListPopupOpener;

    @FindBy(xpath = "//li//a[@class=\"hmenu-item\"][contains(text(),'Sign In')]")
    private WebElement SignInFromPopupAllOpenerButton;

    @FindBy(xpath = "//a[@class=\"a-carousel-goto-prevpage\"]")
    private WebElement CarouselWidgetButtonLeft;

    //img[contains(@alt,'Gamer')]/parent::a
    @FindBy(xpath = "//div[contains(@class,'controls')]")
    private WebElement CarouselWidgetForGamers;
    @FindBy(xpath = "//img[contains(@alt,'Gamer')]")
    private WebElement CarouselWidgetImg;
    @FindBy(xpath = "//img[contains(@alt,'Shop C')]")
    private List<WebElement> CarouselWidgetImg2;
    @FindBy(xpath = "//a[@class=\"a-carousel-goto-nextpage\"]")
    private WebElement CarouselWidgetButtonRight;
    @FindBy(xpath = "//img[@alt='Products for every room in your home']")
    private WebElement ImgCategoryForHomeButton;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement SearchField;
    @FindBy(xpath = "//input[contains(@id,'nav')]")
    private WebElement SearchFieldFindButton;
    @FindBy(xpath = "//li[@class='nav_last ']//a[contains(text(),'Help')]")
    private WebElement helpButton;

    @FindBy(xpath = "//div[contains(@class,'a-span9')]/parent::div")
    private List<WebElement> HelpCategoryBox;
    @FindBy(xpath = "//a[@id='icp-touch-link-language']")
    private WebElement languageButton;
    //span[contains(text(),'English')][@class='icp-color-base']
    @FindBy(xpath = "//span[contains(text(),'English')][@class='icp-color-base']")
    private WebElement languageButtonInscription;
    @FindBy(xpath = "//div[@aria-busy='false']")
    private WebElement LanguageChangeBox;

    @FindBy(xpath = "//i[@class='a-icon a-icon-radio']")
    private List<WebElement> LanguageCheckRadioBox;

    @FindBy(xpath = "//span[@class='a-text-bold']")
    private List<WebElement> InscriptionsForLanguageChangeBox;

    @FindBy(xpath = "//input[contains(@aria-labelledby,'save-ann')]")
    private WebElement SaveChangesForLanguageBox ;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickAllListPopupOpener(){
        AllListPopupOpener.click();
    }
    public void clickSignInFromPopupAllOpenerButton(){
        SignInFromPopupAllOpenerButton.click();
    }
    public void waiterForPopUpPanel(){
        this.waitVisibilityOfElement(30,SignInFromPopupAllOpenerButton);
    }
    public void clickCarouselWidgetButtonLeft(){
        CarouselWidgetButtonLeft.click();
    }

    public boolean isVisibleCarouselWidgetImg() {
        return  CarouselWidgetImg.isDisplayed()&&CarouselWidgetImg.isEnabled();
    }
    public WebElement getCarouselWidgetImg2(){return CarouselWidgetImg2.get(0);}
    public void clickCarouselWidgetButtonRight(){
        CarouselWidgetButtonRight.click();
    }
    public WebElement getCarouselWidgetImg(){return CarouselWidgetImg;}
    public void waiterForCategoryImgButtonHome(){
        this.waitVisibilityOfElement(30,ImgCategoryForHomeButton);
    }
    public void clickImgCategoryForHomeButton(){
        ImgCategoryForHomeButton.click();
    }
    public void fillSearchField(String searchText) {
        SearchField.isEnabled();
        SearchField.isDisplayed();
        SearchField.clear();
        SearchField.sendKeys(searchText);
    }
    public void clickSearchFieldFindButton(){
        SearchFieldFindButton.click();
    }
    public void clickCarouselWidgetForGamers(){
        CarouselWidgetForGamers.click();
    }
    public Boolean isQueryContainSearchKeyWords(final String query){return driver.getCurrentUrl().contains(query.replace(' ','+'));}

    public void isVisibleHelpButtonOnBottomOfHomePage() {
          helpButton.isDisplayed();
          helpButton.isEnabled();
    }
    public void clickHelpButton(){
        helpButton.click();
    }
    public void isVisibleHelpCategoryBox() {
        for (int i = 0; i < HelpCategoryBox.size(); i++) {
            HelpCategoryBox.get(i).isDisplayed();
            HelpCategoryBox.get(i).isEnabled();
        }
    }
    public void clickHelpCategoryBoxFirstElement(){
        HelpCategoryBox.get(1).click();
    }
    public void clickLanguageButton(){
        languageButton.click();
    }
    public void waiterForLanguageChangeBox(){
        this.waitVisibilityOfElement(30,LanguageChangeBox);
    }

    public void clickEspanolLanguageCheckBox(){
        LanguageCheckRadioBox.get(1).click();
    }
    public Boolean doesInscriptionMatchLanguage(){
        return InscriptionsForLanguageChangeBox.get(1).getText().contains("Traducción");
    }
    public void clickDeutschlLanguageCheckBox(){
        LanguageCheckRadioBox.get(3).click();
    }
    public Boolean doesInscriptionMatchLanguageDeutsch(){
        return InscriptionsForLanguageChangeBox.get(1).getText().contains("Übersetzung");
    }
    public void clickEnglishLanguageCheckBox(){
        LanguageCheckRadioBox.get(0).click();
    }
    public void clickSaveChangesForLanguageBox(){
        SaveChangesForLanguageBox.click();
    }
    public Boolean doesLanguageButtonInscriptionEnglish(){
        this.waitVisibilityOfElement(30,languageButtonInscription);
        return languageButtonInscription.getText().contains("Eng");
    }
}


