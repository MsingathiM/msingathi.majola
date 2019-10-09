# API test weather station
# Tags: optional

Feature: Test API for weather station

  Scenario: Test API for weather station

    Given Weather station URL is running
    When User makes a request without API key response code is 401
    When User register a station successfully response code is 201
    When User requests for station details correct response is provided
    When User deletes a station response code is 204
    When User requests a deleted station response code is 404




