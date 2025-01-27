package POM.android.page;

import POM.android.utils.AppBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ProductPage extends AppBasePage {
    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    public void EnterUserName(String userName) {
        enter(AppiumBy.accessibilityId("test-Username"), userName, "Username", 10);
    }

    public void EnterPassword(String password) {
        enter(AppiumBy.accessibilityId("test-Password"), password, "Password", 10);
    }

    public void clickLogIn() {
        click(AppiumBy.accessibilityId("test-LOGIN"), "LogIn", 10);
    }

    public void clickMenuButton() {
        click(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView"), "Menu button", 10);
    }

    public void clickAllItems() {
        click(AppiumBy.accessibilityId("test-ALL ITEMS"), "ALL ITEMS", 10);

    }

    public void clickAddToCardFromProducts(String item) {
        click(AppiumBy.xpath("//android.widget.TextView[@text='" + item + "']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']"), item + " Add To Card button", 10);
    }

    public void clickCardIcon() {
        click(AppiumBy.accessibilityId("test-Cart"), "Card icon", 10);
    }

    public void verifySelectedProductInCardPage(String item) {
        String selectedItem = getAttribute(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]"), "text", " Selected product", 30);
        if (selectedItem.equalsIgnoreCase(item.trim())) {
            System.out.println(selectedItem + " is display in the card page");
        } else {
            System.out.println(selectedItem + " is not display in the card page");
        }
    }

    public void clickCheckOut() {
        click(AppiumBy.accessibilityId("test-CHECKOUT"), "Checkout", 10);
    }

    public void enterFirstName(String firstName) {
        enter(AppiumBy.accessibilityId("test-First Name"), firstName, "First name", 10);
    }

    public void enterLastName(String lastName) {
        enter(AppiumBy.accessibilityId("test-Last Name"), lastName, "Last name", 10);
    }

    public void enterPostalCode(String postalCode) {
        enter(AppiumBy.accessibilityId("test-Zip/Postal Code"), postalCode, "Postal code", 10);
    }

    public void clickContinueButton() {
        hideKeyBoardForAndroid();
        click(AppiumBy.accessibilityId("test-CONTINUE"), "Continue", 10);
    }

    public void verifySelectedProductInOverViewPage(String item) {
        if (findElementByVisibility(AppiumBy.xpath("//android.widget.ScrollView[contains(@content-desc,'OVERVIEW')]//android.widget.TextView[@text='" + item + "']"), 10) != null) {
            System.out.println(item + " is displayed in the overview page");
        } else {
            System.out.println(item + " is not displayed in the overview page");
        }
    }

    public void scrollDown() {
        //   scroll("down",451, 1677, 451, 662);
        scroll(281, 1025, 312, 489);

    }

    public void clickFinishButton() {
        click(AppiumBy.accessibilityId("test-FINISH"), "Finish button", 10);
    }

    public void verifyOrderCompletePage() {
        String tqMsg = getAttribute(AppiumBy.xpath("//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.TextView[1]"), "text", "Message", 10);
        if (tqMsg.equalsIgnoreCase("THANK YOU FOR YOU ORDER")) {
            System.out.println("The order completed message is display");
        } else {
            System.out.println("The order completed message is not  display");
        }
    }

    public void clickBackHome() {
        click(AppiumBy.accessibilityId("test-BACK HOME"), "Back home", 10);
    }

    public void verifyBackToHomeButtonFunctionality() {
        if (findElementByVisibility(AppiumBy.accessibilityId("test-Modal Selector Button"), 10) != null) {
            System.out.println("Complete page is redirected to Home page after clicked on back to home button");
        } else {
            System.out.println("Complete page is not redirected to Home page after clicked on back to home button");
        }
    }

    public void clickRemoveButtonInYourCardPage() {
        click(AppiumBy.accessibilityId("test-REMOVE"), "Remove", 10);
    }

    public void verifySelectedProductReMoved(String item) {
        if (isDisappear(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[@text='" + item + "']"), 10)) {
            System.out.println("Selected product is removed from your card page");
        } else {
            System.out.println("Selected product is not removed from your card page");

        }
    }

    public void clickContinueShopping() {
        click(AppiumBy.accessibilityId("test-CONTINUE SHOPPING"), "Continue Shopping button", 10);
    }

    public void verifyContinueShoppingFunctionality() {
        if (findElementByVisibility(AppiumBy.accessibilityId("test-Modal Selector Button"), 10) != null) {
            System.out.println("home is display after clicked the continue shopping button");
        } else {
            System.out.println("home is not display after clicked the continue shopping button");
        }
    }


}
