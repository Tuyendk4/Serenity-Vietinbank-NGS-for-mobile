@TGDKTGTTCDV @TRAGOP

Feature:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"


  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình tất cả dịch vụ
    And mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    And Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    And Nhấn Trả góp Online từ tất cả dịch vụ
  # Mở màn hình Intro
    And Chọn Trả góp ngay
    And Chọn số thẻ "<soThe>" trong danh sách thẻ trả góp
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    And Về trang chủ
    Examples:
      | kyHan | otp    | soThe               | soTien         |
      | 12    | 888888 | 4572 7100 0000 6776 | -5,000,000 VND |
