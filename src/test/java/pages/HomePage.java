package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	@FindBy(xpath = "//h1[contains(.,'Sell my car')]")
	private WebElement homepageHeader;

	@FindBy(id = "vrm-input")
	private WebElement registrationField;

	@FindBy(css = "button[data-cy=\"valueButton\"]")
	private WebElement valueYourCarButton;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void openUrl(WebDriver driver) {
		driver.get("https://motorway.co.uk/");
	}

	public void clickYourCarButton() {
		valueYourCarButton.click();
	}

	public void clearRegistrationField(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", registrationField);
	}

	public void enterRegNumber( WebDriver driver, WebDriverWait wait, String regNumber) {;
		waitForPageToLoad(driver, wait);
		clearRegistrationField(driver);
		registrationField.sendKeys(regNumber);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public String getTextOnButton() {
		waitUntilElementVisible(valueYourCarButton);
		return valueYourCarButton.getText();
	}

	public boolean isDisplayed() {
		waitUntilElementVisible(homepageHeader);
		return homepageHeader.isDisplayed();
	}
}
