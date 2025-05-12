package definitions;

import io.cucumber.java.en.Given;
import utils.CarDetails;
import utils.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class FileProcessSteps {
//    private List<CarDetails> expectedData;
   // private FileProcessor processor;
//    private final ExtentTest test;

//    public FileProcessSteps() {
////        this.processor = FileProcessorFactory.getProcessor("text");;
////        this.test = ExtentReportManager.createTest("Car Valuation");
//    }


    @Given("I read vehicle registrations from {string}")
    public void readVehicleRegistrationsFromFile(String fileName) throws FileNotFoundException {
        FileProcessor processor = new FileProcessor();
        List<String> registrations = processor.readInput("src/test/resources/testData/" + fileName);
        CarDetails.setRegistrations(registrations);
//        test.info("Read " + registrations.size() + " registrations");
    }

}
