Feature: validating the Place API

  Scenario: verify if place added successfully by using ADDPLACeAPI
    Given  add place payload
    When user call "addapi" with post http request
    Then the api call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"