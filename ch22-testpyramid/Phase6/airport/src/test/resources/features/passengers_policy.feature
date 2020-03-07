Feature: Passengers Policy
  The company follows a policy of adding and removing passengers, depending on the passenger type

  Scenario Outline: Flight with regular passengers
    Given there is a flight having number "<flightNumber>" and <seats> seats with passengers defined into "<file>"
    When we have regular passengers
    Then you can remove them from the flight
    And add them to another flight

    Examples:
      |flightNumber  | seats  | file                       |
      |  AA1234      | 50     | flights_information.csv    |
      |  AA1235      | 50     | flights_information2.csv   |
      |  AA1236      | 50     | flights_information3.csv   |

  Scenario Outline: Flight with VIP passengers
    Given there is a flight having number "<flightNumber>" and <seats> seats with passengers defined into "<file>"
    When we have VIP passengers
    Then you cannot remove them from the flight

    Examples:
      |flightNumber  | seats  | file                       |
      |  AA1234      | 50     | flights_information.csv    |
      |  AA1235      | 50     | flights_information2.csv   |
      |  AA1236      | 50     | flights_information3.csv   |
