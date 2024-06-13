@TGTVGDTGTDSTK @TRAGOP

Feature:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"

  Scenario Outline: Tra cứu giao dịch trả góp từ danh sách tài khảon
    And mở Danh sách tài khoản từ màn hình chính
    And Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    And Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch
#    And Về trang chủ
    Examples:
      | trangThai    | soTaiKhoanTheTD | soTien         |
      | Đang trả góp | 57110000375898  | -5,000,000 VND |

