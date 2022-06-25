Feature: Validate place API's

  Scenario Outline: Verify if place is added using AddPlace using scenario outline
    Given Add Place payload with "<name>" "<language>" "<address>"
    When  user call "addPlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    When  user call "getPlaceAPI" with "get" http request



  Examples:
      |name  |   |language|    |address      |
      |Nirmal|   |36 gari   |    |Jila Raigarh |
      |Suchi|   |Odiya   |    |Angul |
