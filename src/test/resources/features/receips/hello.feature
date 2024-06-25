Feature: Greetings

  The different types of greetings we can receive

  Scenario: Hello How Are You
    When I am greeted
    Then I should hear "Hello How Are You?"