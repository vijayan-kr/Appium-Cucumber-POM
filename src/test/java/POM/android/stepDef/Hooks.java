package POM.android.stepDef;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class Hooks {
    public static AppiumDriver driver;
    static String testClassName;
    private final static String FILE_NAME = System.getProperty("user.dir") + "/src/main/resources/testdata.properties";
    private static final Properties prop = new PropertiesLoader(FILE_NAME).load();
    static String platForm = prop.getProperty("platformName");

    @BeforeAll(order = 1)
    public static void setUp() {
        if (platForm.equalsIgnoreCase("android")) {
            androidDriver();
        } else if (platForm.equalsIgnoreCase("iOS")) {
            iosDriver();
        }
    }

    @Before
    public static void reportWrapUp(Scenario scenario) {
        String reportsPath = System.getProperty("user.dir") + "/reports";
        testClassName = scenario.getName();
        if (scenario.isFailed()) {
            String imageName = scenario.getName() + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String imagePath = reportsPath + "/" + imageName;
            File scrFile = driver.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
                System.out.println(imagePath + ".png");
                System.out.println("scenario - " + scenario.getName() + " failed , see the screenshot - " + imagePath + ".png");

            } catch (Throwable e) {
                System.err.println(e);
            }
        }

    }

    @AfterAll(order = 1)
    public static void quit() {
        try {
            driver.quit();
        } catch (Throwable e) {
            System.err.println("Driver is not quit " + e);
        }
    }

    public static void androidDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:platformVersion", prop.getProperty("androidVersion"));
        caps.setCapability("appium:deviceName", prop.getProperty("androidDeviceName"));
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Android driver created");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void iosDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:platformVersion", "16.4");
        caps.setCapability("appium:deviceName", "iPhone 14");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "com.saucelabs.SwagLabsMobileApp");
        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("IOS driver created");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
