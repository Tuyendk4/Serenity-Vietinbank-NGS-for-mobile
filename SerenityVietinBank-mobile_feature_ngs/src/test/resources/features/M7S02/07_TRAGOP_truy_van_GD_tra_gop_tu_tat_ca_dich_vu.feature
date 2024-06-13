@TGTVGDTGTTCDV @TRAGOP

Feature:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Tra cứu giao dịch trả góp từ Tất cả dịch vụ

    And mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    And Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    And Nhấn Trả góp Online từ tất cả dịch vụ
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    And Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai   | soThe               |  | soTien  |
      | Đã hoàn tất | 4572 7100 0000 0798 |  | -94 USD |
