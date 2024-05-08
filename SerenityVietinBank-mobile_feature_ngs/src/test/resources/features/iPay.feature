@iPay
Feature: iPay

  Scenario: iPay
    Given open Vietinbank app
    And login Vietinbank app with username "cachua" and password "12121212"
    And move to Loan And Credit Services
    And move to Personal Instalment Loan
    And make loan with "3000000" VND "Edit" in period "12" tháng with "Edit"
    Then show interest rate in reference repayment schedule as "5,2%/năm"
    And show monthly charge amount in reference payment schedule as "Từ 252,003 đến 263,000 VND"
    And show interest payable total in reference payment schedule as "84,500 VND"
    And show principal and interest payable total in reference payment schedule as "3,084,500 VND"