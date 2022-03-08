Feature: Data Tables and Button States

  Scenario: Verify the main page header title
    When user reads the main page header title
    Then user validate the main page header title should be "Data, Tables & Button States"

  Scenario: verify the total number of tables in main page
    When user reads the total number of tables count
    Then user validate the total number tables count should be "3"

  Scenario: verify the table one details
    When user reads the table one details
    Then user validate the contents of the table one with the following values
      | Firstname | Lastname | Age |
      | John      | Smith    |  45 |
      | Jemma     | Jackson  |  94 |
      | Michael   | Doe      |  20 |

  Scenario: verify the table two details
    When user reads the table two details
    Then user validate the contents of the table two with the following values
      | Firstname | Lastname | Age |
      | Jason     | Jones    |  27 |
      | Sarah     | Jackson  |  56 |
      | Bob       | Woods    |  80 |

  Scenario: verify the first and last name input fields
    When user enters the first name "siri" and last name "somu"
    Then user validate the input fields

  Scenario: verify the input text field
    When user enters the input text as "hello, how are you?"
    Then user validate the input text field

  Scenario: verify the breadcrumb links
    When user checks the breadcrumb links count should be "3"
    Then user validate the home and about links are enabled and contact us not enabled

  Scenario: verify the pagination links
    When user checks pagination links
    Then user validate all pages href value is same

  Scenario: verify the table three details
    When user checks the table three details
    Then user validate the table three rows count should be four

  Scenario: verify the buttons state
    When user checks the state of buttons
    Then user validate the warning button is not enabled
