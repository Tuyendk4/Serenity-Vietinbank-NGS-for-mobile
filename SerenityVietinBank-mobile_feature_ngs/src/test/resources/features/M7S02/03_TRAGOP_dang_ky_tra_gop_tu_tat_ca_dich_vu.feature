@TGDKTGTTCDV @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"


  Khung tình huống: Trả góp thẻ tín dụng online từ màn hình tất cả dịch vụ
    Và mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    Và Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    Và Nhấn Trả góp Online từ tất cả dịch vụ
  # Mở màn hình Intro
    Và Chọn Trả góp ngay
    Và Chọn số thẻ "<soThe>" trong danh sách thẻ trả góp
    Và Chọn giao dịch trả góp theo số tiền "<soTien>"
    Thì Chọn kỳ hạn "<kyHan>" tháng
    Và Chọn Đồng ý Điều khoản và điều kiện
    Và Chọn Tiếp tục
    Và Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    Và Về trang chủ
    Dữ liệu:
      | kyHan  | otp     |soThe                    |soTien        |
      | 12     | 888888  |4572 7100 0000 6776      |-5,000,000 VND|
