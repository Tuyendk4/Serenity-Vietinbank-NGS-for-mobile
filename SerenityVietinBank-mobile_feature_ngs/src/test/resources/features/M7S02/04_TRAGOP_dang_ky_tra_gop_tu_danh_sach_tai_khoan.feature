@TGGKTGTDSTK @TRAGOP

Feature:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Trả góp thẻ tín dụng online từ danh sách tài khoản

    And mở Danh sách tài khoản từ màn hình chính
    And Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    And Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    And Chọn Trả góp ngay
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
    Then Nhận thông báo thành công
#    And Về trang chủ
    Examples:
      | kyHan | otp    | soTaiKhoanTheTD | soTien         |
      | 6     | 888888 | 257110000375898 | -5,000,000 VND |
