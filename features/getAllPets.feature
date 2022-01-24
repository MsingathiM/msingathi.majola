Feature: Retrieve all pets

  Scenario: Fetching all pets and confirm name and id from list and create a new pet to search
    Given I open the swagger endpoint
    When I search for all pets available with a name and id
    And I add a pet with auto generated name and make it available on list
    Then I should get results of my pet when I search with id

