Feature: test

  @Test
  Scenario: stainless work table search
    Given User goes to "Home Page"
    Then verify user landed on correct page
    When Search 'stainless work table'
    Then Check the search result ensuring every product has the word 'Table' in its title
    When Add the last of found items to Cart
    And Empty Cart
