@TGGKTGTDSTK @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Trả góp thẻ tín dụng online từ danh sách tài khoản

    Và mở Danh sách tài khoản từ màn hình chính
    Và Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    Và Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    Và Chọn Trả góp ngay
    Và Chọn giao dịch trả góp theo số tiền "<soTien>"
    Thì Chọn kỳ hạn "<kyHan>" tháng
    Và Chọn Đồng ý Điều khoản và điều kiện
    Và Chọn Tiếp tục
    Và Nhập OTP "<otp>"
    Thì Nhận thông báo thành công
#    Và Về trang chủ
    Dữ liệu:
      | kyHan | otp    | soTaiKhoanTheTD | soTien         |
      | 6     | 888888 | 257110000375898 | -5,000,000 VND |
