Feature: Status code verification

  Scenario: Verification of the status code
    Given url 'https://coderbyte.com/api/challenges/json/rest-get-simple'
    When method get
    Then status 200
