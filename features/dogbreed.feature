Feature: Retrieve dog information

  Scenario: Fetching all information related to a dog breed

    Given I open the dog api endpoint
    When I search for a non-existing dog breed an error must be returned
    And I verify that a bulldog exist from the list of all dogs
    Then I retrieve all sub-breeds for bulldogs and their respective images