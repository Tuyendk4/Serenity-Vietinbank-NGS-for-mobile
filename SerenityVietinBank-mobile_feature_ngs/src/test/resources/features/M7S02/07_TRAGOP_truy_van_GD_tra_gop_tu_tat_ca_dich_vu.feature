@TGTVGDTGTTCDV @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Tra cứu giao dịch trả góp từ Tất cả dịch vụ

    Và mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    Và Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    Và Nhấn Trả góp Online từ tất cả dịch vụ
    Và Chọn Trả góp ngay
    Và Chọn quản lý trả góp
    Và Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Thì Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    Và Hiển thị chi tiếp giao dịch

#    Và Về trang chủ
    Dữ liệu:
      | trangThai    | soThe               |  | soTien         |
      | Đã hoàn tất | 4572 7100 0000 0798 |  | -94 USD |
