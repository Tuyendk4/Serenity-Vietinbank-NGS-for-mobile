@TGTVGDTGTDSTK @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Tra cứu giao dịch trả góp từ danh sách tài khảon
    Và mở Danh sách tài khoản từ màn hình chính
    Và Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    Và Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    Và Chọn Trả góp ngay
    Và Chọn quản lý trả góp
    Thì Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    Và Hiển thị chi tiếp giao dịch
#    Và Về trang chủ
    Dữ liệu:
      | trangThai     |soTaiKhoanTheTD   | soTien        |
      | Đang trả góp  |                   | -5,000,000 VND|

