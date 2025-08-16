Feature: validating the Place API

  Scenario Outline: verify if place added successfully by using ADDPLACeAPI
    Given  add place payload with "<Name>" "<Language>" "<Address>"
    When user call "addapi" with "post" http request
    Then the api call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_id is map to "<Name>" by using "getapi"

    Examples:
      | Name      | Language  | Address                   |
      | Frontline | French-IN | 29, side layout, cohen 09 |
    #  | BB        | English   | sea acress                |