@CLHUBKBHFlow @flow1 @loan09
Feature: 09 - Vay tiêu dùng cá nhân - Hub - Không bảo hiểm

  Scenario Outline: Vay tiêu dùng không bảo hiểm bằng tài khoản hub
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    And Menu Dịch vụ vay và tín dụng
    And Vay tiêu dùng cá nhân
    And Công cụ tính lãi suất - Tính toán ngay
    And Vay "<number_of_money>" VND, thời hạn "<number_of_months>" tháng không có ưu đãi đặc biệt, "<edit_type>"
    Then Lịch trả nợ - Lãi suất "<interest_rate>"
    * Lịch trả nợ - Số tiền phải trả hàng tháng "<monthly_charge_amount>"
    * Lịch trả nợ - Tổng lãi phải trả "<interest_payable_total>"
    * Lịch trả nợ - Tổng số tiền gốc và lãi phải trả "<principal_and_interest_payable_total>"
    When MH Vay - Bước 1
    Then MH Vay - Bước 1 - Lãi suất vay "<interest_rate>"
    * MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định "<monthly_charge_amount>"
    When MH Vay - Bước 2
    And MH Vay - Bước 2 - Ngày trả nợ hàng tháng "<repayment_date>", mục đích vay "<loan_purpose>", email "<receive_email>", tỉnh "<province>", huyện "<district>"
    Then MH Vay - Bước 3 - Số tiền vay "<full_format_number_of_money>"
    And MH Vay - Bước 3 - Thời hạn vay "<full_format_number_of_months>"
    And MH Vay - Bước 3 - Lãi suất dự kiến là "<interest_rate>"
    And MH Vay - Bước 3 - Mục đích vay là "<loan_purpose>"
    And MH Vay - Bước 3 - Ngày trả nợ hàng tháng "<repayment_date>"
    And MH Vay - Bước 3 - họ và tên người vay "<borrow_full_name>"
    When Gửi yêu cầu vay
    Then Thông báo "VietinBank đang thực hiện thẩm định, Quý khách sẽ nhận được kết quả trong vòng 6h qua tin nhắn SMS/OTT."
    * Thông báo "Quý khách cần trợ giúp thêm xin liên hệ 1900558868"
    When Chọn Đồng ý trên Popup thông báo
    Then hiển thị số lượng tại Lịch sử vay
    When Vào MH Lịch sử vay
    Then Khoản vay "<loan_status>", số tiền "<full_format_number_of_money>"
    When Vào MH Vay tiêu dùng cá nhân
    And Mở Hồ sơ vay tiêu dùng cá nhân
    Then Hồ sơ vay tiêu dùng cá nhân - Số tiền vay "<full_format_number_of_money>"
    And Hồ sơ vay tiêu dùng cá nhân - Thời hạn vay "<full_format_number_of_months>"
    And Hồ sơ vay tiêu dùng cá nhân - Ngày trả nợ hàng tháng "<repayment_date>"
    And Hồ sơ vay tiêu dùng cá nhân - Mục đích vay "<loan_purpose_not_tone>"
    And Hồ sơ vay tiêu dùng cá nhân - Họ và tên ngươi vay "<borrow_full_name>"
    And Hồ sơ vay tiêu dùng cá nhân - Email nhận hợp đồng "<receive_email>"

    Examples:
      | user_name   | password | otp_code | number_of_money | number_of_months | edit_type | interest_rate | monthly_charge_amount          | interest_payable_total | principal_and_interest_payable_total | repayment_date | loan_purpose         | receive_email             | province      | district             | full_format_number_of_money | full_format_number_of_months | borrow_full_name | loan_status   | loan_purpose_not_tone |
      | tranthgiang | 12121212 | 888888   | 3000000         | 12               | EditText  | 15.9%/năm     | Từ 253,313 VND đến 289,750 VND | 258,378 VND            | 3,258,378 VND                        | 15             | Mua thiết bị di động | nhungauto4@mailinator.com | TINH AN GIANG | THANH PHO LONG XUYEN | 3,000,000 VND               | 12 tháng                     | CUSTOMER NAME    | Chờ thẩm định | Mua thiet bi di dong  |

  Scenario Outline: Xóa khoản vay tiêu dùng không bảo hiểm bằng tài khoản hub
    Given Mở VTB iPayApp
    When Đăng nhập user "<user_name>", password "<password>", otp "<otp_code>"
    * Menu Dịch vụ vay và tín dụng
    * Vào MH Lịch sử vay
    * Vào MH Vay tiêu dùng cá nhân của khoản vay "<loan_status>"
    * MH Vay tiêu dùng cá nhân - Hủy khoản vay
    Then MH Vay tiêu dùng cá nhân - Thông báo "Quý khách có chắc chắn muốn hủy hồ sơ vay?"
    When MH Vay tiêu dùng cá nhân - Xác nhận hủy
    Then MH Vay tiêu dùng cá nhân - Thông báo thành công: "Yêu cầu vay <full_format_number_of_money> để phục vụ mục đích Mua thiet bi di dong đã được hủy thành công. Xin vui lòng gửi lại yêu cầu vay mới phù hợp hơn với nhu cầu của Quý khách"

    Examples:
      | user_name   | password | otp_code | loan_status   | full_format_number_of_money |
      | tranthgiang | 12121212 | 888888   | Chờ thẩm định | 3,000,000.00 VND            |