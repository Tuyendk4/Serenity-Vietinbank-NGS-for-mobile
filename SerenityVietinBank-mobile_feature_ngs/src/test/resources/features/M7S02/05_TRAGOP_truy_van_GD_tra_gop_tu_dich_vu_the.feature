@TGTVGDTGTDVT @TRAGOP

Feature:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Tra cứu giao dịch trả góp từ dịch vụ thẻ

    And mở Dịch vụ thẻ
    And Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    And Chọn tính năng Đăng ký trả góp
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai        | soThe               | soTien         |
      | Không thành công | 4572 7100 0000 3346 | -3,000,000 VND |
