package POM.android.stepDef;

import POM.android.page.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.PropertiesLoader;

import java.util.Properties;

import static POM.android.stepDef.Hooks.driver;

public class ProductStepDef {
    private final static String FILE_NAME = System.getProperty("user.dir") + "/src/main/resources/testdata.properties";
    private static final Properties prop = new PropertiesLoader(FILE_NAME).load();
    ProductPage productsPage;
    String product = prop.getProperty("productName");

    public ProductStepDef() {
        productsPage = new ProductPage(driver);
    }

    @Then("add a product to cart")
    public void addProductToCart() {
        productsPage.clickMenuButton();
        productsPage.clickAllItems();
        productsPage.clickAddToCardFromProducts(product);
    }

    @And("verify the product is added to cart page")
    public void verifyProductIsAddedToCartPage() {
        productsPage.clickCardIcon();
        productsPage.verifySelectedProductInCardPage(product);
    }

    @Then("checkout the added product")
    public void checkoutTheAddedProduct() {
        productsPage.clickCheckOut();
    }

    @And("fill out the details")
    public void fillOutTheDetails() {
        productsPage.enterFirstName(prop.getProperty("firstName"));
        productsPage.enterLastName(prop.getProperty("lastName"));
        productsPage.enterPostalCode(prop.getProperty("zipCode"));
    }

    @Then("click continue button")
    public void clickContinueButton() {
        productsPage.clickContinueButton();
    }

    @Then("verify product in overview page")
    public void verifyProductInOverviewPage() {
        productsPage.verifySelectedProductInOverViewPage(product);
    }

    @And("click finish btn and verify complete page is displayed")
    public void clickFinishAndVerifyCompletePageIsDisplayed() {
        productsPage.scrollDown();
        productsPage.clickFinishButton();
        productsPage.verifyOrderCompletePage();
    }

    @Then("click back to home btn and verify home page is displayed")
    public void backToHomeAndVerifyHomePage() {
        productsPage.clickBackHome();
        productsPage.verifyBackToHomeButtonFunctionality();

    }

    @And("remove the added product from cart")
    public void removeProductFromCart() {
        productsPage.clickRemoveButtonInYourCardPage();
    }

    @Then("verify selected product is removed from cart")
    public void verifySelectedProductIsRemovedFromCart() {
        productsPage.verifySelectedProductReMoved(product);
    }

    @And("click continue shopping button")
    public void clickContinueShoppingButton() {
        productsPage.clickContinueShopping();
    }

    @And("verify it's navigated to the home page")
    public void verifyItSNavigatedToHomePage() {
        productsPage.verifyContinueShoppingFunctionality();
    }

    @And("click finish button")
    public void clickFinishButton() {
        productsPage.scrollDown();
        productsPage.clickFinishButton();
    }


    @Given("Login with username {string} and password {string}")
    public void loginWithUsernameAndPassword(String userName, String passWord) {
        productsPage.EnterUserName(userName);
        productsPage.EnterPassword(passWord);
        productsPage.clickLogIn();
    }

    @Then("add {string} product to cart")
    public void addProductToCart(String product) {
        productsPage.clickMenuButton();
        productsPage.clickAllItems();
        productsPage.clickAddToCardFromProducts(product);
    }

    @And("verify {string} product is added to cart page")
    public void verifyProductAddedToCartPage(String product) {
        productsPage.clickCardIcon();
        productsPage.verifySelectedProductInCardPage(product);
    }

    @And("fill out the first name {string}")
    public void fillOutTheFirstName(String firstName) {
        productsPage.enterFirstName(firstName);

    }

    @And("fill out the last name {string}")
    public void fillOutTheLastName(String lastName) {
        productsPage.enterLastName(lastName);
    }

    @And("fill out the postal code {string}")
    public void fillOutThePostalCode(String postalCode) {
        productsPage.enterPostalCode(postalCode);

    }

    @Then("verify {string} product in overview page")
    public void verifyProductInOverviewPage(String productName) {
        productsPage.verifySelectedProductInOverViewPage(productName);
    }
}
