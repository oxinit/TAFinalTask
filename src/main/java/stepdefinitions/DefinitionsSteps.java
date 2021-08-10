package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import manager.PageFactoryManager;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;


public class DefinitionsSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    LoginRegistrationPage loginRegistrationPage;
    AmazonBasicsPage amazonBasicsPage;
    EssentialsForGamersPage essentialsForGamersPage;
    ProductPage productPage;
    String dataTransferString;
    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @And("User open {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }
    @When("User click 'All' button popup element")
    public void clickAllListPopupOpener() {
        homePage.clickAllListPopupOpener();
    }
    @And("User click 'Sing in' button from popup panel")
    public void userClicksSingInButtonFromPopupPanel() {
        homePage.waiterForPopUpPanel();
        homePage.clickSignInFromPopupAllOpenerButton();
    }
    @And("User check 'Sign in' label visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginRegistrationPage=pageFactoryManager.getLoginRegistrationPage();
        loginRegistrationPage.isVisibleSignInLabel();
    }
    @Then("User fill email field with {string}")
    public void userFillsEmailFieldWithKeyword(final String email) {
        loginRegistrationPage.fillEmailField(email);
    }
    @And("User click 'Continue' button")
    public void userClicksContinueButton() {
        loginRegistrationPage.clickContinueButton();
    }

    @Then("User must see error box popup")
    public void userMustSeeErrorBoxPopup() {loginRegistrationPage.isVisibleErrorBox();
    }

    @And("User check error Text are {string}")
    public void userCheckErrorTextAreErrorText(final String errorMessage) {
        assertEquals(errorMessage,loginRegistrationPage.getTextFormErrorMassageWithEmailInput());
    }

    @Then("User click left arrow button on widget below search")
    public void userClicksLeftArrowButtonOnWidgetBelowSearch() {
        homePage.clickCarouselWidgetButtonLeft();
    }

    @And("User check does widget changed image")
    public void userCheckDoesWidgetChangedImage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselWidgetImg2());
        assertFalse(homePage.isVisibleCarouselWidgetImg());
    }

    @Then("User click right arrow button")
    public void userClicksRightArrowButton() {
        homePage.clickCarouselWidgetButtonRight();
    }
    @And("User check does widget have original image")
    public void userCheckDoesWidgetSameImage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselWidgetImg());
        assertTrue(homePage.isVisibleCarouselWidgetImg());
    }

    @When("User click on image of for home category")
    public void userClickOnImageOfForHomeCategory() {
        homePage.waiterForCategoryImgButtonHome();
        homePage.clickImgCategoryForHomeButton();
    }

    @And("User click on first from list")
    public void userClickOnFirstFromList() {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.waiterForFirstElementProduct();
        amazonBasicsPage.clickFirstElementProduct();
    }

    @Then("User click add to cart button")
    public void userClickAddToCartButton() {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.clickAddToCartButton();
    }

    @And("User check does product{string}match")
    public void userCheckDoesProductAddedToCart(String label) {
        amazonBasicsPage.waiterProductAddedToCartInscription();
        assertTrue(amazonBasicsPage.isVisibleProductAddedToCartInscription());
        assertEquals(amazonBasicsPage.getTextProductAddedToCartInscription(),label);
    }

    @When("User fill search field with {string}")
    public void userFillSearchFieldWithSearchText(String searchtext) {
        homePage.fillSearchField(searchtext);
    }

    @Then("User click find button")
    public void userClickFindButton() {
        homePage.clickSearchFieldFindButton();
    }

    @And("User click on second element from list")
    public void userClickOnSecondElementFromList() {
        amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
        amazonBasicsPage.waiterForFirstElementProduct();
        amazonBasicsPage.clickSecondElementProduct();
    }

    @When("User click on widget below search")
    public void userClickOnWidgetBelowSearch() {
        homePage.clickCarouselWidgetForGamers();
    }

    @And("user must see inscription Featured Categories")
    public void userMustSeeInscription() {
       essentialsForGamersPage=pageFactoryManager.getEssentialsForGamersPage();
       essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(essentialsForGamersPage.isInscriptionContainsFeaturedCategories());
    }

    @Then("user click on chairs category")
    public void userClickOnChairsCategory() {
        essentialsForGamersPage.clickChairsCategory();
    }

    @And("user starting add first {int} elements to cart and get back to{string}")
    public void userStartingAddFewElementsToCart(final int j,final String url) {int i=0;
        while (i!=j){
            essentialsForGamersPage.clickProductElement(i);
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

            essentialsForGamersPage.clickAddToCartButton();

            amazonBasicsPage=pageFactoryManager.getAmazonBasicsPage();
            amazonBasicsPage.waiterProductAddedToCartInscription();
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            essentialsForGamersPage.openChairsForGamersPage(url);
            essentialsForGamersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            i++;
        }
    }

    @Then("user check {string} of products in cart")
    public void userChekAmountOfProductsInCart(final String amount) {
        assertEquals(essentialsForGamersPage.getQuantityFromCartIconWith(),amount);
    }

    @And("User check visibility of product image")
    public void userChekVisibilityOfProductImage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.isVisibleProductImage();
    }

    @And("User check visibility of product price")
    public void userChekVisibilityOfProductPrice() {
        productPage.isVisibleProductBaseCurrentPrice();
       dataTransferString= productPage.getTextProductBaseCurrentPrice();
    }

    @And("User check does product price match to price in cart")
    public void userChekDoesProductPriceMatchToPriceInCart() {
        assertEquals(productPage.getTextCartCurrentPrice(),dataTransferString);
    }

    @And("User check in Stock Inscription")
    public void userChekInStockInscription() {
        productPage.isVisibleinStockInscription();
    }

    @Then("User check query generated {string}")
    public void userCheckQueryGenerated(final String query) {
        assertTrue( homePage.isQueryContainSearchKeyWords(query));

    }

    @When("User check help button visibility")
    public void userChekHelpButtonVisibility() {
        homePage.isVisibleHelpButtonOnBottomOfHomePage();
    }

    @Then("User click help button")
    public void userClickHelpButton() {
       homePage.clickHelpButton();
    }

    @And("User check Help Category Boxes visibility")
    public void userCheckHelpCategoryBoxesVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isVisibleHelpCategoryBox();

    }

    @Then("User click Returns&Refunds category")
    public void userClickReturnsRefundsCategory() {
        homePage.clickHelpCategoryBoxFirstElement();
    }

    @And("User check Sign in box visibility")
    public void userFindOutLoginPage() {
        loginRegistrationPage= pageFactoryManager.getLoginRegistrationPage();
       assertTrue(loginRegistrationPage.isVisibleSignInLabel2());
    }

    @When("User click language button")
    public void userClickLanguageButton() {
        homePage.clickLanguageButton();
        homePage.waiterForLanguageChangeBox();
    }


    @Then("User click Spanish language check box")
    public void userClickSpanishLanguageCheckBox() {
        homePage.clickEspanolLanguageCheckBox();
    }

    @And("User check inscription nearby")
    public void userChekInscriptionNearby() {
        assertTrue(homePage.doesInscriptionMatchLanguage());
    }

    @Then("User click Deutsch language check box")
    public void userClickDeutschLanguageCheckBox() {
        homePage.clickDeutschlLanguageCheckBox();
    }

    @And("User check inscription according to language")
    public void userCheckInscriptionAccordingToLanguage() {
        assertTrue(homePage.doesInscriptionMatchLanguageDeutsch());
    }

    @And("User returns to English language using check box")
    public void userReturnsToEnglishLanguageUsingCheckBox() {
        homePage.clickEnglishLanguageCheckBox();
    }

    @Then("User click Save Changes button")
    public void userClickConfirmButton() {
        homePage.clickSaveChangesForLanguageBox();
        
    }

    @And("User chek main page inscriptions for English language")
    public void userChekMainPageInscriptionsForEnglishLanguage() {

        assertTrue(homePage.doesLanguageButtonInscriptionEnglish());
    }

    @Then("User checks does cart empty")
    public void userChecksDoesCartEmpty() {
        essentialsForGamersPage=pageFactoryManager.getEssentialsForGamersPage();
        assertEquals( essentialsForGamersPage.getQuantityFromCartIconWith(),"0");
    }
}
