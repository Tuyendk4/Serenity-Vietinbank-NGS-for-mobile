@TGTGDM @TRAGOP
# language: vi
Tính năng:  Tạo giao dịch thanh toán bằng thẻ tín dụng
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Khung tình huống: Tạo giao dịch trả góp
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"
    Và Mở ô tìm kiếm
    Và Nhập từ "<tuTimKiem>" cần tìm kiếm
    Và Chọn mua e-Voucher tìm kiếm
    Và Đồng ý đặt mua Voucher
    Và Chọn loại voucher và số lượng
    Và Nhập thông tin người nhận "<nguoiNhan>" và email "<email>"
    Và Xác nhận thanh toán
    Dữ liệu:
      |tuTimKiem    |nguoiNhan|email|
      |Mua e        | Thanh Phong|phongakg@gmail.com|