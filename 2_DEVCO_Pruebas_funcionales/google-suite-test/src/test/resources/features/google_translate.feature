Feature: Google Translate
  As a web user
  I want to use Google Translate
  to translate words between different languages

  Scenario: Translate from croata to italiano
    Given that Susan wants to translate a word
    When she translates the word krumpir from croata to italiano
    Then she should see the word patata in the screen

  Scenario: Translate from italiano to croata
    Given that Susan wants to translate a word
    When she translates the word riso from italiano to croata
    Then she should see the word riža shake in the screen

  Scenario: Translate from italiano to corso
    Given that Susan wants to translate a word
    When she translates the word riso from italiano to corso
    Then she should see the word risu in the screen
