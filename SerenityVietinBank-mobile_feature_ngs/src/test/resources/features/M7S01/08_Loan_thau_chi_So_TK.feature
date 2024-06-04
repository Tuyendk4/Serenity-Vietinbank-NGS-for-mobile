@TCCTSDBFlow
Feature: Vay thấu chi có tài sản đảm bảo

  Scenario Outline: Thực hiện khoản vay Thấu chi có tài sản đảm bảo
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Thấu chi có tài sản đảm bảo
    And Thực hiện vay thấu chi online với số giấy tờ tùy thân "<identity_card>", email nhận hợp đồng "<email>", tài khoản được cấp thấu chi "<overdraft_account_number>", số tiết kiêm đảm bảo "<banking_saving_book_number>", số tiền vay "<loan_money>", mục đích vay "<loan_purpose>"
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Quý khách có thể sử dụng hạn mức thấu chi trong tài khoản ngay sau khi nhận được thông báo qua số điện thoại & email"

    Examples:
      | user_name | password | otp_code | identity_card | email                 | overdraft_account_number | banking_saving_book_number | loan_money | loan_purpose                      |
      | quannh2   | 12121212 | 888888   | 001093018302  | vitest@mailinator.com | 108004116397             | 246000045380               | 3000000    | Phục vụ nhu cầu đời sống gia đình |