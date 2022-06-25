Feature: Validate place API's

  Scenario: Verify if place is added using AddPlace API
    Given Add Place payload
    When  user call "addPlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
#    And I set value of "baseURI" as "nirmal.com"