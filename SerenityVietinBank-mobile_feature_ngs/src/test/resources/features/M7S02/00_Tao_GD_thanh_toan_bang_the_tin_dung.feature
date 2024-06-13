@TGTGDM @TRAGOP

Feature:  Tạo giao dịch thanh toán bằng thẻ tín dụng
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Scenario Outline: Tạo giao dịch trả góp
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"
    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn mua e-Voucher tìm kiếm
    And Đồng ý đặt mua Voucher
    And Chọn loại voucher và số lượng
    And Nhập thông tin người nhận "<nguoiNhan>" và email "<email>"
    And Xác nhận thanh toán
    Examples:
      | tuTimKiem | nguoiNhan   | email              |
      | Mua e     | Thanh Phong | phongakg@gmail.com |