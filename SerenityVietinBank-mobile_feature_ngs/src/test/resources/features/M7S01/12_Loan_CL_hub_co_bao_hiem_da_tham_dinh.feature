@flow1 @loan12
Feature: 12 - Vay tiêu dùng cá nhân - Hub giải ngân thành công - Có bảo hiểm

  Scenario Outline: Thực hiện tạo vay tiêu dùng có ưu đãi thông qua tính toán khoản vay thành công bằng tài khoản hub
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Vay tiêu dùng cá nhân
    And Công cụ tính lãi suất - Tính toán ngay
    And Vay "<number_of_money>" VND, thời hạn "<number_of_months>" tháng có ưu đãi đặc biệt, "<edit_type>"
    Then Lịch trả nợ - Lãi suất "<interest_rate>"
    * Lịch trả nợ - Số tiền phải trả hàng tháng "<monthly_charge_amount>"
    * Lịch trả nợ - Tổng lãi phải trả "<interest_payable_total>"
    * Lịch trả nợ - Tổng số tiền gốc và lãi phải trả "<principal_and_interest_payable_total>"
    When MH Vay - Bước 1
    Then MH Vay - Bước 1 - Lãi suất vay "<interest_rate>"
    * MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định "<monthly_charge_amount>"
    When MH Vay - Bước 1 - Xác nhận sử dụng bảo hiểm VietinBank
    When MH Vay - Bước 2
    And MH Vay - Bước 2 - Ngày trả nợ hàng tháng "<repayment_date>", mục đích vay "<loan_purpose>", email "<receive_email>", tỉnh "<province>", huyện "<district>"
    Then MH Vay - Bước 3 - Số tiền vay "<full_format_number_of_money>"
    And MH Vay - Bước 3 - Thời hạn vay "<full_format_number_of_months>"
    And MH Vay - Bước 3 - Lãi suất dự kiến là "<interest_rate>"
    And MH Vay - Bước 3 - Mục đích vay là "<loan_purpose>"
    And MH Vay - Bước 3 - Ngày trả nợ hàng tháng "<repayment_date>"
    And MH Vay - Bước 3 - họ và tên người vay "<borrow_full_name>"
    When Gửi yêu cầu vay
    Then Thông báo thành công: "Chúc mừng Quý khách đủ điều kiện vay vốn tại VietinBank, Số tiền: <full_format_number_of_money_02>, Thời hạn <full_format_number_of_months>, Xin hoàn thiện tiếp thủ tục vay vốn trước"
    When Nhấn Đồng ý trên Thành công popup
    Then Thẩm định hồ sơ thành công - Số tiền vay "<full_format_number_of_money>"
    And Thẩm định hồ sơ thành công - Lãi suất "5%/năm"
    And Thẩm định hồ sơ thành công - Thời hạn vay "<full_format_number_of_months>"
    When Thẩm định hồ sơ thành công - lựa chọn tài khoản
    And Xem nội dung hợp đồng vay
    And MH Hợp động vay - quay trở lại Thẩm định hồ sơ thành công
    And Đồng ý vay
    And Xác nhận hợp đồng - Nhập OTP "<otp_code>"
    Then Kết quả giao dịch - hiển thị "Quý khách đã xác nhận Hợp đồng vay vốn thành công. Số tiền vay sẽ được giải ngân vào tài khoản thanh toán Quý khách đã lựa chọn. Hợp đồng cho vay sẽ được gửi tới Quý khách qua email"
    And Quay về MH Home
    And Vào Danh sách tài khoản
    And MH Danh sách tài khoản - Xem các tài khoản vay
    Then MH Danh sách tài khoản - Hiển thị khoản vay mới nhất với số tiền "<full_format_number_of_money>"

    Examples:
      | user_name  | password | otp_code | number_of_money | number_of_months | edit_type | interest_rate | monthly_charge_amount          | interest_payable_total | principal_and_interest_payable_total | repayment_date | loan_purpose         | receive_email             | province      | district             | full_format_number_of_money | full_format_number_of_money_02 | full_format_number_of_months | borrow_full_name |
      | nhungauto4 | 12121212 | 888888   | 3000000         | 12               | EditText  | 13.9%/năm     | Từ 252,896 VND đến 284,750 VND | 225,876 VND            | 3,225,876 VND                        | 15             | Mua thiết bị di động | nhungauto4@mailinator.com | TINH AN GIANG | THANH PHO LONG XUYEN | 3,000,000 VND               | 3.000.000 VND                  | 12 tháng                     | CUSTOMER NAME    |