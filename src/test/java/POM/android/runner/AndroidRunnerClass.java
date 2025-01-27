package POM.android.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/POM/android/feature/SauceLabProductAndroid.feature",
},
        publish = true,
        plugin = {"pretty", "html:reports/cucumber.html"},
        glue = {"POM.android.stepDef"}
)
public class AndroidRunnerClass {

}