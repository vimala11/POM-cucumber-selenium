package definitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CarDetailsPage;
import pages.HomePage;
import utils.CarDetails;
import utils.FileProcessor;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class HomeSteps {

    public static boolean result;

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private List<CarDetails> expectedData;

    public HomeSteps() {
        driver = Hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver, wait);
    }

    @Given("I am on a Car Valuation webpage")
    public void amOnACarValuationWebpage() {
        homePage.openUrl(driver);
    }

    @When("I validate car details for each registration against {string}")
    public void validateCarDetailsForEachRegistrationAgainst(String outFilePath) throws FileNotFoundException {
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver, wait);
        FileProcessor processor = new FileProcessor();
        expectedData = processor.readExpectedOutput("src/test/resources/testData/" + outFilePath);
        List<String> registrationsList = CarDetails.getRegistrations();
        registrationsList.forEach(reg -> {
            try {
                String buttonText = homePage.getTextOnButton();
                if (buttonText.equalsIgnoreCase("Value your car")) {
                    homePage.enterRegNumber(driver, wait, reg);
                }
                if(buttonText.equalsIgnoreCase("Check again")) {
                    homePage.refreshPage(driver);
                    homePage.enterRegNumber(driver, wait, reg);
                }
                homePage.clickYourCarButton();
                if(carDetailsPage.isCarDetailsDisplayed()) {
                    result = carDetailsPage.assertCarDetails(carDetailsPage.getCarDetails(reg), reg, expectedData);
                    System.out.println("Validation passed for " + reg);
                    carDetailsPage.clickNotYourCarLink();
                    Assert.assertTrue("Home page is not displayed", homePage.isDisplayed());
                }
            } catch (Exception e) {
                System.out.println("Validation failed for " + reg + "\n" + ExceptionUtils.getStackTrace(e));
            }
        });
    }

    @Then("all results should match expected values")
    public void allResultsShouldMatchExpectedValues() {
        Assert.assertTrue("Registrations do not match information in output file", result);

    }
}
