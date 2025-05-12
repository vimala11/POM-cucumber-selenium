package definitions;

import io.cucumber.java.en.Given;
import utils.CarDetails;
import utils.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class FileProcessSteps {
<<<<<<< HEAD
=======
//    private List<CarDetails> expectedData;
   // private FileProcessor processor;
//    private final ExtentTest test;

//    public FileProcessSteps() {
////        this.processor = FileProcessorFactory.getProcessor("text");;
////        this.test = ExtentReportManager.createTest("Car Valuation");
//    }

>>>>>>> f84d914 (Initial draft)

    @Given("I read vehicle registrations from {string}")
    public void readVehicleRegistrationsFromFile(String fileName) throws FileNotFoundException {
        FileProcessor processor = new FileProcessor();
        List<String> registrations = processor.readInput("src/test/resources/testData/" + fileName);
        CarDetails.setRegistrations(registrations);
<<<<<<< HEAD
=======
//        test.info("Read " + registrations.size() + " registrations");
>>>>>>> f84d914 (Initial draft)
    }

}
