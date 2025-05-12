package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CarDetails;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsPage extends BasePage {

    public CarDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1[data-cy=\"vehicleMakeAndModel\"]")
    private WebElement carTitle;

    @FindBy( css = ".HeroVehicle__details-XpAI li")
    private List<WebElement> carDetailsList;

    @FindBy(css = "a[data-testid=\"notYourCar\"]")
    private WebElement notYourCarLink;


    public void clickNotYourCarLink() {
        waitUntilElementVisible(carTitle);
        notYourCarLink.click();
    }

    public boolean isCarDetailsDisplayed(){
        waitUntilElementVisible(notYourCarLink);
        return carDetailsList.get(0).isDisplayed();
    }

    public List<String> getCarDetails(String reg) {
        waitUntilElementVisible(carDetailsList.get(0));
        List<String> actualCarDetails = new ArrayList<>();

        actualCarDetails.add(reg);
        actualCarDetails.add(carTitle.getText());
        actualCarDetails.add(carDetailsList.get(0).getText());
        return actualCarDetails;
    }

    public boolean assertCarDetails(List<String> actualCarDetails, String reg, List<CarDetails> expectedData) {
        boolean result = false;
        if (!reg.contains(" ")){
            reg = reg.substring(0,4) + " " + reg.substring(4);
        }
        for (CarDetails carDetails : expectedData) {
            if ( reg.equals(carDetails.getRegNo()) ){
                result = actualCarDetails.get(1)
                        .equalsIgnoreCase(carDetails.getMakeModel()) &&
                        actualCarDetails.get(2).equals(carDetails.getYear());
                if(result){
                    break;
                }
            }
        }
        if(!result) {
            System.out.println("Missing expected data for " + reg);
        }
        return result;
    }

}
