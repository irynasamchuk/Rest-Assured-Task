Feature:
  In order to use the Get functionality
  As a tester
  I want to be sure that the Get functionality works correctly on the website

  Scenario: Can Get board with some ID
    Given the trello API with 'BOARD' endpoint
    When request has folowing paramethers
    |Key| Value|
    | id | 5df751a0c0ecd04fad4b823e |
    And method POST
    Then response status code has 200

