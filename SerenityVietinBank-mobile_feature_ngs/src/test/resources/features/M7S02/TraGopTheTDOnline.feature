
# language: vi
Tính năng:  Trả góp thẻ tín dụng online Ipay
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Bối cảnh:
    Cho Mở VTB iPayApp
    Khi Đăng nhập với password "12121212"


  @TC_099 @TGONL
    Khung tình huống: Tạo giao dịch trả góp
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



  @TC_199 @TGONL
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


  @TC_200 @TGONL
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


  @TC_201
  Khung tình huống: Trả góp thẻ tín dụng online từ màn hình tìm kiếm

    Và Mở ô tìm kiếm
    Và Nhập từ "<tuTimKiem>" cần tìm kiếm
    Và Chọn Trả góp thẻ tín dụng bằng tìm kiếm
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
      | kyHan | otp    | tuTimKiem |soThe              |soTien|
      | 6     | 888888 | tra gop   |4572 7100 0000 6776|      |

  @TC_202
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


  @TC_203
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


  @TC_204
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

  @TC_205
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
      | Đang trả góp  |       | -5,000,000 VND |

  @TC_206
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

