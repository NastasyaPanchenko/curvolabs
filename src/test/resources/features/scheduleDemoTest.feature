@scheduleDemoTest
  Feature: Fill out a Demo form

    Background:
      Given I open "Main" page

      @scheduleDemoTest
      Scenario: Verify Submit Schedule Demo form
      When I click on "Schedule Demo" link on Main menu
      Then I verify the title "Schedule a Demo of Our Healthcare Supply Chain Solution! – Curvo Labs"
      When I type "Maxi" in the First name field
      When I type "Mooner" in the Last name field
      And  I type "anastasia.panchenko@rocketmail.com" in the Email field
      When I type "347-987-8582" in the Phone number field
      When I type "House" in the Organization field
      And I click Submit Schedule Demo
      Then I verify the url contains "https://curvolabs.com/thank-you/"
      And I verify the title "Thank You – Curvo Labs"
      And I verify the message "Thank you!"
      And I verify the message "We’ll be in touch soon."





