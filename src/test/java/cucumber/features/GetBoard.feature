Feature:
  In order to use the Get functionality
  As a tester
  I want to be sure that the Get functionality works correctly on the website

  @API
  Scenario: Get board with some ID
    Given the trello API with BOARD endpoint
    When request has following parameters
    |Key | Value                    |
    | id | 5df751a0c0ecd04fad4b823e |
    And method GET
    Then response status code has 200


