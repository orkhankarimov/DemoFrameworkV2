package StepDefinitions;

import Pages.LandingPage;
import Utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static StepDefinitions.Hooks.driver;

public class LandingPageSteps {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    LandingPage landingPage = new LandingPage();

    @Given("user navigates to HUDL Landing Page")
    public void user_navigates_to_HUDL_Landing_Page() {
        String url = ConfigurationReader.getProperty("ui-config.properties", "url");
        driver.get(url);
    }

    @Given("user navigates to HUDL Login Page")
    public void user_navigates_to_HUDL_Login_Page() {
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.loginDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.hudlDropdownOption)).click();
    }
}
