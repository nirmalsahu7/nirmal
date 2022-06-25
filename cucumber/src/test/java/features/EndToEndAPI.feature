Feature: Validate place API's

  @AddPlace
  Scenario Outline: Verify end to end API
    Given Add Place payload with "<name>" "<language>" "<address>"
    When  user call "addPlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And  Verify place_id created map to "<name>" using "getPlaceAPI"

#    Given deletePlace payload
#    When  user call "deletePlaceAPI" with "post" http request
#    Then The API call got success with status code 200
#    And "status" in response body is "OK"

  Examples:
      |name  |   |language|    |address      |
      |Nirmal|   |36 gari   |    |Jila Raigarh |
    #  |Suchi|   |Odiya   |    |Angul |

  @DeletePlace
  Scenario: Delete API validation
    Given deletePlace payload
    When  user call "deletePlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"

