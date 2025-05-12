Feature: Car details Validation

  Scenario Outline: Validate car details from <inputFile> against <outputFile>
    Given I read vehicle registrations from "<inputFile>"
    And I am on a Car Valuation webpage
    When I validate car details for each registration against "<outputFile>"
    Then all results should match expected values

    Examples:
      | inputFile      | outputFile      |
      | car_input.txt  | car_output.txt  |
