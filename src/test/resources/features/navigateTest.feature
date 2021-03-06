@navigateTest
Feature: Verification links on Main page
  #first test
  Background:
    Given I open "Main" page

  @navigateMainMenuTest
  Scenario Outline: Verify Main Menu links
    When I click on <Link> link on Main menu
    Then I verify the url <Url>
    And I verify the title <Title>
    And I verify the title <Title2>

    Examples:
      | Link            | Url                                      | Title                                                                    |
      | "Products"      | "https://curvolabs.com/products/"        | "Products That Deliver Savings For Healthcare Supply Chain – Curvo Labs" |
      | "Blog"          | "https://curvolabs.com/blog/"            | "Supply Chain & Strategic Sourcing Insights & Blog – Curvo Labs"         |
      | "About"         | "https://curvolabs.com/about-curvo/"     | "Learn About Curvo & The Curvo Team – Curvo Labs"                        |
      | "Resources"     | "https://curvolabs.com/resources/"       | "Browse Resources, News, Case Studies – Curvo Labs"                      |
      | "Schedule Demo" | "https://curvolabs.com/schedule-a-demo/" | "Schedule a Demo of Our Healthcare Supply Chain Solution! – Curvo Labs"  |

  @navigateLoginTest
  Scenario: Verify Login link
    When I click on "Login" link on Main menu
    And I switch to active window
    Then I verify the url "https://app.curvolabs.com/auth/login"
    And I verify the title "Welcome to Curvo"