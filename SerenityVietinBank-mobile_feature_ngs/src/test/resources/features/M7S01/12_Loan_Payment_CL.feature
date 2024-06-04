@TNDKVTDFlow
Feature: M7S01 - Vay tiêu dùng cá nhân - Trả nợ định kỳ vay tiêu dùng

  Scenario Outline: Trả nợ định kỳ khoản vay tiêu dùng
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Vào MH Trả nợ & tất toán vay
    And Thực hiện "<repayment_type>", chọn tài khoản vay "<loan_account_number>" từ address book, số tiền phải trả "<repayment_money>"
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Trả nợ/tất toán khoản vay thành công!"

    Examples:
      | user_name    | password | otp_code | repayment_type | loan_account_number | repayment_money |
      | 711A57165998 | 12121212 | 888888   | Trả nợ định kỳ | 552000985707        | 1000000         |