@TGDKTGTDVT @TRAGOP
# language: vi
Tính năng:  Trả góp thẻ tín dụng- Đăng ký trả góp
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"

  Khung tình huống: Trả góp thẻ tín dụng online từ màn hình dịch vụ thẻ
    Và mở Dịch vụ thẻ
    Và Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    Và Chọn tính năng Đăng ký trả góp
    Và Chọn Trả góp ngay
    Và Chọn giao dịch trả góp theo số tiền "<soTien>"
    Thì Chọn kỳ hạn "<kyHan>" tháng
    Và Chọn Đồng ý Điều khoản và điều kiện
    Và Chọn Tiếp tục
    Và Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    Và Về trang chủ
    Dữ liệu:
      | soThe               | kyHan | otp    | soTien         |
      | 4572 7100 0000 6776 | 12     | 888888 | -5,000,000 VND |