package Pages;

import Utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static StepDefinitions.Hooks.driver;

public class HomePage {
    String expectedUsernameHeader = ConfigurationReader.getProperty("ui-config.properties", "usernameHeader");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='hui-globaluseritem']//span")
    public WebElement usernameHeader;

    @FindBy(xpath = "//*[contains(@class,'hui-primarynav__item')]/span")
    public List<WebElement> allMainTabs;

    @FindBy(xpath = "//*[@class='explore-tab-text']/span")
    public List<WebElement> allSubTabs;

    public void validateUsernameHeader () {
        String actualUsernameHeader = usernameHeader.getText();
        Assert.assertEquals("Welcome username validation failed!!!" , expectedUsernameHeader, actualUsernameHeader);
    }
}
