@TGTVGDTGTDVT @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Tra cứu giao dịch trả góp từ dịch vụ thẻ

    Và mở Dịch vụ thẻ
    Và Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    Và Chọn tính năng Đăng ký trả góp
    Và Chọn Trả góp ngay
    Và Chọn quản lý trả góp
    Thì Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    Và Hiển thị chi tiếp giao dịch

#    Và Về trang chủ
    Dữ liệu:
      | trangThai     | soThe | soTien         |
      | Không thành công | 4572 7100 0000 3346      | -3,000,000 VND |
