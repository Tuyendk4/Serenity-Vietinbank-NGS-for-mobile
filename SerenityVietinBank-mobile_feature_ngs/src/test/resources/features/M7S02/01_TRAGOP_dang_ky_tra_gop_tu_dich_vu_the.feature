@TGDKTGTDVT @TRAGOP

Feature:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình dịch vụ thẻ
    And mở Dịch vụ thẻ
    And Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    And Chọn tính năng Đăng ký trả góp
    And Chọn Trả góp ngay
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
    Then Nhận thông báo thành công
#    And Về trang chủ
    Examples:
      | soThe               | kyHan | otp    | soTien         |
      | 4572 7100 0000 6776 | 12    | 888888 | -5,000,000 VND |