@TGTVGDTGTMHTK @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- truy vấn giao dịch trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Tra cứu giao dịch trả góp từ màn hình tìm kiếm

    Và Mở ô tìm kiếm
    Và Nhập từ "<tuTimKiem>" cần tìm kiếm
    Và Chọn Trả góp thẻ tín dụng bằng tìm kiếm
    Và Chọn Trả góp ngay
    Và Chọn quản lý trả góp
    Và Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Thì Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    Và Hiển thị chi tiếp giao dịch

#    Và Về trang chủ
    Dữ liệu:
      | trangThai    | soThe               | tuTimKiem | soTien         |
      | Đang trả góp | 4572 7100 0000 6776 | tra gop   | -5,000,000 VND |
