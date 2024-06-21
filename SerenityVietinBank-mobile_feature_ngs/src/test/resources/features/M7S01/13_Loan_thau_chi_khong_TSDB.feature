@TCKTSDBFlow @flow1 @loan13
Feature: 13 - Vay Thấu chi không tài sản đảm bảo

  Scenario Outline: Thực hiện khoản vay Thấu chi không tài sản đảm bảo
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Thấu chi không tài sản đảm bảo
    And Thực hiện vay thấu chi không tài sản đảm bảo với số tiền là "<number_of_money>", thời hạn vay là "<loan_duration>", ngày trả nợ hàng tháng là "<repayment_date>", mục đích vay "<loan_purpose>", không ưu đãi, email "<receive_email>", tỉnh "<province>", huyện "<district>"
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Chúc mừng quý Khách đã được cấp hạn mức thấu chi."
    Then Kết quả giao dịch - hiển thị "Quý khách có thể sử dụng hạn mức thấu chi trong tài khoản ngay sau khi nhận được thông báo qua số điện thoại & email"
    When Quay về MH Home
    And Logout VTB iPayApp

    Examples:
      | user_name | password | otp_code | number_of_money | loan_duration | repayment_date | loan_purpose                      | receive_email         | province         | district    |
      | tritu8284 | 12121212 | 888888   | 3000000         | 5 tháng       | 15             | Phục vụ nhu cầu đời sống gia đình | vitest@mailinator.com | Thành phố Hà Nội | QUAN TAY HO |