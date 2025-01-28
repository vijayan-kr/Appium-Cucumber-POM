package POM.android.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class AppBasePage {
    public AppiumDriver driver;

    public AppBasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void enter(By by, String value, String name, int timeInSec) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if (element != null) {
                element.click();
                element.clear();
                element.sendKeys(value);
                System.out.println(name + " field is entered with value \"" + value + "\"");
            } else {
                System.out.println(name + " is not found" );
                Assert.fail(name + " is not found");
            }
        } catch (Throwable e) {
            System.out.println(name + " field is entered with value \"" + value + "\"" + e);
            Assert.fail(name + " field is entered with value \"" + value + "\"" + e);
        }
    }

    public void enterUsingAction(By by, String value, String name, int timeInSec) {

        try {
            new Actions(driver).moveToElement(findElementByPresence(by, timeInSec)).sendKeys(value).build().perform();
            System.out.println(name + " field is entered with value \"" + value + "\"");
        } catch (Throwable e) {
            System.out.println(name + " field is entered with value \"" + value + "\"" + e);

        }
    }

    public WebElement findElementByVisibility(By by, int timeInSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable e) {
            return null;
        }
    }

    public WebElement findElementByClickable(By by, int timeInSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            return null;
        }
    }

    public List<WebElement> findMultipleElementsByVisibility(By by, int timeInSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Throwable e) {
            return null;
        }
    }

    public List<WebElement> findMultipleElementsByPresence(By by, int timeInSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Throwable e) {
            return null;
        }
    }

    public WebElement findElementByPresence(By by, int timeInSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            return null;
        }
    }

    public boolean isDisappear(By by, int timeInSec) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            result = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable ignored) {

        }
        return result;
    }

    public void click(By by, String name, int timeInSec) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if (element != null) {
                element.click();
                System.out.println(name + " is clicked");
            } else {
                System.out.println(name + " is not found" );
                Assert.fail(name + " is not found");
            }
        } catch (Throwable e) {
            Assert.fail(name + " is not clicked" + " " + e);
        }
    }

    public void clickByAction(By by, String name, int timeInSec) {
        try {
            new Actions(driver).moveToElement(findElementByPresence(by, timeInSec)).click().build().perform();
            System.out.println(name + " is clicked");

        } catch (Throwable e) {
            System.out.println(name + " is not clicked " + e);
            System.out.println("while clicking this By " + by + "and error is " + e);
            Assert.fail(name + " is not clicked" + " " + e);
        }
    }

    public String getAttribute(By by, String attribute, String name, int timeInSec) {
        String msg = "";
        try {
            WebElement element = findElementByPresence(by, timeInSec);
            if (element != null) {
                msg = element.getAttribute(attribute);
            }
        } catch (Throwable e) {
            System.out.println(by + " is not available " + e);
        }
        return msg;
    }

    public String currentDate(String patten) {
        return new SimpleDateFormat(patten).format(new Date());
    }

    public String NextDate(String patten) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(patten).format(cal.getTime());
    }

    public List<String> getMultipleElementAttribute(By by, String attribute, int timeInSec) {

        List<String> values = new ArrayList<>();
        try {
            List<WebElement> elements = (List<WebElement>) driver.findElements(by);
            for (WebElement element : elements) {
                values.add(element.getAttribute(attribute));
            }
        } catch (Throwable e) {
            System.out.println(by + "is not available " + e);
            Assert.fail(by + "is not available " + e);
        }
        return values;
    }

    public void scroll(String direction, int left, int top, int width, int height) {
        try {
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
                    "direction", direction,
                    "percent", 3.0
            ));
            System.out.println("Scrolled " + direction);
        } catch (Throwable e) {
            System.out.println("Failed to scrol " + direction);
            Assert.fail("Failed to scrol " + direction);
        }
    }

    public void scrollInIOS(String direction) {
        try {
            Map<String, Object> args = new HashMap<>();
            args.put("direction", direction);
            driver.executeScript("mobile: swipe", args);
            System.out.println("Scrolled " + direction);
        } catch (Throwable e) {
            System.out.println("Failed to scrol " + direction);
            Assert.fail("Failed to scrol " + direction);
        }
    }

    public void scroll(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger1, 1);
        sequence.addAction(finger1.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger1.createPointerMove(Duration.ofMillis(100),
                PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public void hideKeyBoardForAndroid() {
        ((AndroidDriver) driver).hideKeyboard();
    }

}
