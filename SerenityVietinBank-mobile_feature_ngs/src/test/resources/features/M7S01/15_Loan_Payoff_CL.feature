@TTCLFlow @flow1 @loan15
Feature: 15 - Vay tiêu dùng cá nhân - Tất toán khoản vay

  Scenario Outline: Tất toán khoản vay - Nội bộ - giải ngân thành công - không bảo hiểm
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
      | user_name    | password | otp_code | repayment_type            | source_account_number |
      | 711A57165998 | 12121212 | 888888   | Tất toán - đóng khoản vay | 100006067396          |

#  Scenario Outline: Tất toán khoản vay - Chi nhánh - giải ngân thành công - không bảo hiểm
#    Given Mở VTB iPayApp
#    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
#    And Vào Danh sách tài khoản
#    And MH Danh sách tài khoản - Xem các tài khoản vay
#    And MH Danh sách tài khoản - Lấy tài khoản vay mới nhất
#    And MH Home
#    And Menu Dịch vụ vay và tín dụng
#    And Vào MH Trả nợ & tất toán vay
#    And Thực hiện "<repayment_type>"
#    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
#    Then Kết quả giao dịch - hiển thị "Trả nợ/tất toán khoản vay thành công!"
#
#    Examples:
#      | user_name  | password | otp_code | repayment_type            | source_account_number |
#      | nhungauto1 | 12121212 | 888888   | Tất toán - đóng khoản vay | 103004467380          |

#  Scenario Outline: Tất toán khoản vay - Hub - giải ngân thành công - không bảo hiểm
#    Given Mở VTB iPayApp
#    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
#    And Vào Danh sách tài khoản
#    And MH Danh sách tài khoản - Xem các tài khoản vay
#    And MH Danh sách tài khoản - Lấy tài khoản vay mới nhất
#    And MH Home
#    And Menu Dịch vụ vay và tín dụng
#    And Vào MH Trả nợ & tất toán vay
#    And Thực hiện "<repayment_type>", tài khoản nguồn trả nợ "<source_account_number>"
#    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
#    Then Kết quả giao dịch - hiển thị "Trả nợ/tất toán khoản vay thành công!"
#
#    Examples:
#      | user_name  | password | otp_code | repayment_type            | source_account_number |
#      | nhungauto4 | 12121212 | 888888   | Tất toán - đóng khoản vay | 103004357597          |