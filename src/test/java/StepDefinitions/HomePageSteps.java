package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

import static StepDefinitions.Hooks.driver;

public class HomePageSteps {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    HomePage homePage = new HomePage();

    @Then("user should be able to verify account name on HUDL Homepage")
    public void user_should_be_able_to_verify_account_name_on_HUDL_Homepage() {
        homePage.validateUsernameHeader();
    }

    @Then("user should be able to verify all main tabs on HUDL Homepage")
    public void user_should_be_able_to_verify_all_main_tabs_on_HUDL_Homepage(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        int i = 0;

        for (Map<String, String> map : maps) {
            String expectedTab = map.get("tabname");
            String actualTab = homePage.allMainTabs.get(i).getText();
            Assert.assertEquals("Main Tab verification failed!", expectedTab, actualTab);
            i++;
        }
    }

    @Then("user should be able to verify all sub-tabs on HUDL Homepage")
    public void user_should_be_able_to_verify_all_sub_tabs_on_HUDL_Homepage(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        int i = 0;

        for (Map<String, String> map : maps) {
            String expectedTab = map.get("subtabname");
            String actualTab = homePage.allSubTabs.get(i).getText();
            Assert.assertEquals("Sub-Tab verification failed!", expectedTab, actualTab);
            i++;
        }
    }

}
