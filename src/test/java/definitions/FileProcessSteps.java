package definitions;

import io.cucumber.java.en.Given;
import utils.CarDetails;
import utils.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class FileProcessSteps {
    @Given("I read vehicle registrations from {string}")
    public void readVehicleRegistrationsFromFile(String fileName) throws FileNotFoundException {
        FileProcessor processor = new FileProcessor();
        List<String> registrations = processor.readInput("src/test/resources/testData/" + fileName);
        CarDetails.setRegistrations(registrations);
    }

}
