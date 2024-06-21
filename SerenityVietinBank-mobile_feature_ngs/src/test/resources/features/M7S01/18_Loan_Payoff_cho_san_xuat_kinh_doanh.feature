@TNDKVTDFlow @flow1 @loan18
Feature: 18 - Vay sản xuất kinh doanh - Tất toán khoản vay

  Scenario Outline: Tất toán khoản vay sản xuất kinh doanh
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Vào MH Trả nợ & tất toán vay
    And Thực hiện "<repayment_type>", tài khoản vay "<loan_account_number>"
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Trả nợ/tất toán khoản vay thành công!"

    Examples:
      | user_name     | password | otp_code | repayment_type            | loan_account_number |
      | nguyenthithao | 12121212 | 888888   | Tất toán - đóng khoản vay | 866004357816        |