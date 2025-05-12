This is a Demo project set up to demonstrate an Automation test framework in Selenium Java, 
using Cucumber framework for BDD and Page Object Model

****Test Summary****

- Test is to validate car details of registration numbers read from input file(car_input.txt) on 
    a public website(motorway.co.uk) by comparing the details with an output file(car_output.txt)
- Reading Input file and Output file is performed in FileProcessor Class under /utils
- The FileProcessor Class reads input/output file stored under /src/test/resources/testData
- The registration numbers of vehicles that matches the regex pattern are store as a List<String>
- The expected car details read from output file are stored as List<CarDetails>, 
    where CarDetails class stores attributes like registration number, make/model and year of the car
    along with methods that access the attributes.
- The details of registration number in input file is searched on the public website and the details
    displayed are validated against the ones in output file
- When the details match, the registration is logged as passed validation and continues with other inputs
- If the registration number in input file is not found in the public website, then the registration is
    marked as validation failed

****Page Objects****

----BasePage----
- This is a page object class for commonly used methods that could be shared among different pages

----HomePage----
- This is a page object class for the home page of the public website that takes registration number as input

----CarDetailsPage----
- This is a page object class that stores all locators and corresponding method for the details displayed on the website

****TO RUN THE TEST*****
- Run command mvn clean verify to run the test in terminal and view reports generated under /target/cucumber-html-report
- Or simply, run the TestRunner.Java Class -- found under /testRunner