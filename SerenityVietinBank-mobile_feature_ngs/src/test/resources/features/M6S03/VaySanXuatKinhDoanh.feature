@M6S03_TC001
Feature: M6S03 - Vay san xuat kinh doanh

  @TC001
  Scenario Outline: Thực hiện vay san xuat kinh doanh
    Given Mở VTB iPayApp
    When Nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Chọn Dịch vụ vay và tín dụng
    And Chọn Vay sản xuất kinh doanh
    Then Hiển thị danh sách hợp đồng
    And Chọn tạo yêu cầu giải ngân
    Then Hiển thị thông tin nhu cầu vay
    And Chọn mục đích giải ngân "<disbursement purposes>"
    And Chọn tài khoản trả nợ gốc và lãi mặc định
    And Chọn thời hạn trả nợ gốc "<principal RepaymentPeriod>"
    And Chọn ngày trả nợ tự động định kỳ "<regular Automatic Repayment Date>"
    And Chọn tiếp tục tạo yêu cầu giải ngân
    Then Hiển thị thông tin giải ngân
    And Nhập tài khoản thụ hưởng "<account Number>"
    And Nhập ngân hàng thụ hưởng "<beneficiary Bank>"
    And Nhập số tiền thụ hưởng "<beneficiary Amount>"
    And Nhập Nội dung "<Content>"
    And Chọn Đính kèm hoá đơn, hợp đồng
    Then Hiển thị tải lên hoá đơn chứng từ
    And Nhập Nhập mã số hóa đơn, hợp đồng "<invoice And Contract Codes>"
    And Nhập số tiền trên hóa đơn, hợp đồng "<invoice And Contract Amount>"
    And Chọn ngày trên hóa đơn hợp đồng
    And Chọn đính kèm tài liệu
    And Chọn Lưu
    Then Hiển thị thông tin giải ngân
    And Chọn xác nhận và đồng ý giải ngân
    And Nhập thông tin OTP "<otp_code>" xác nhận giao dich
    And Chọn xác nhận và hoàn tất
    Then Thông báo giao dich thành công

    Examples:
      | user_name | password | otp_code | disbursement purposes                          | principal RepaymentPeriod | regular Automatic Repayment Date | account Number | beneficiary Bank | beneficiary Amount | Content  | invoice And Contract Codes | invoice And Contract Amount |
      | vtb12     | 12121212 | 888888   | Thanh toán chi phí khác phục vụ hoạt động SXKD | 5 tháng                   | 15                               | 106004176150   | VietinBank       | 100000             | Vay SXKD | ABC12345                   | 100000                      |

