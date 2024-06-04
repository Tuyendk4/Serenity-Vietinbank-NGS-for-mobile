@TTTCKTSDBFlow
Feature: M7S01 - Thấu chi không có tài sản đảm bảo - Tất toán khoản vay

  Scenario Outline: Tất toán khoản vay thấu chi không có tài sản đảm bảo
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Vào Danh sách tài khoản
    And MH Danh sách tài khoản - Xem các tài khoản vay
    And MH Danh sách tài khoản - Lấy tài khoản vay mới nhất
    And MH Home
    And Menu Dịch vụ vay và tín dụng
    And Vào MH Trả nợ & tất toán vay
    And Thực hiện "<repayment_type>", tài khoản nguồn trả nợ "<source_account_number>"
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Trả nợ/tất toán khoản vay thành công!"

    Examples:
      | user_name | password | otp_code | repayment_type            | source_account_number |
      | tritu8284 | 12121212 | 888888   | Tất toán - đóng khoản vay | 105004103990108       |