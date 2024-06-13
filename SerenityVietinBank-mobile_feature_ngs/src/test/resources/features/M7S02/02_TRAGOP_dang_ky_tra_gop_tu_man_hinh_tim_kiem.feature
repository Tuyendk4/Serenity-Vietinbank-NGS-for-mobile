@TGDKTGTMHTIK @TRAGOP
Feature: Trả góp thẻ tín dụng- Đăng ký trả góp

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình tìm kiếm
    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn Trả góp thẻ tín dụng bằng tìm kiếm
    And Chọn Trả góp ngay
    And Chọn số thẻ "<soThe>" trong danh sách thẻ trả góp
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    And Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    Then Về trang chủ
    Examples:
      | kyHan | otp    | tuTimKiem | soThe               | soTien         |
      | 6     | 888888 | tra gop   | 4572 7100 0000 6776 | -5,000,000 VND |