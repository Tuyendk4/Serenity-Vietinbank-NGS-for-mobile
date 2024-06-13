@TGTVGDTGTMHTK @TRAGOP

Feature:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Tra cứu giao dịch trả góp từ màn hình tìm kiếm

    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn Trả góp thẻ tín dụng bằng tìm kiếm
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    And Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai    | soThe               | tuTimKiem | soTien         |
      | Đang trả góp | 4572 7100 0000 6776 | tra gop   | -5,000,000 VND |
