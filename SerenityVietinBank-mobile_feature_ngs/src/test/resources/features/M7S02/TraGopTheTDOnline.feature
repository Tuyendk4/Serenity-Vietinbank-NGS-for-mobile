Feature:  Trả góp thẻ tín dụng online Ipay
#  mvn clean verify -Denvironment='iphone12mini' -Dtags='TC_204'

  Background:
    Given Mở VTB iPayApp
    When Đăng nhập với password "12121212"


  @TC_099 @TGONL
  Scenario Outline: Tạo giao dịch trả góp
    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn mua e-Voucher tìm kiếm
    And Đồng ý đặt mua Voucher
    And Chọn loại voucher And số lượng
    And Nhập thông tin người nhận "<nguoiNhan>" và email "<email>"
    And Xác nhận thanh toán
    Examples:
      | tuTimKiem | nguoiNhan   | email              |
      | Mua e     | Thanh Phong | phongakg@gmail.com |


  @TC_199 @TGONL
  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình tất cả dịch vụ

    And mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    And Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    And Nhấn Trả góp Online từ tất cả dịch vụ
  # Mở màn hình Intro
    And Chọn Trả góp ngay
    And Chọn số thẻ "<soThe>" trong danh sách thẻ trả góp
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    And Về trang chủ
    Examples:
      | kyHan | otp    | soThe               | soTien         |
      | 12    | 888888 | 4572 7100 0000 6776 | -5,000,000 VND |


  @TC_200 @TGONL
  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình dịch vụ thẻ

    And mở Dịch vụ thẻ
    And Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    And Chọn tính năng Đăng ký trả góp
    And Chọn Trả góp ngay
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    And Về trang chủ
    Examples:
      | soThe               | kyHan | otp    | soTien         |
      | 4572 7100 0000 6776 | 12    | 888888 | -5,000,000 VND |


  @TC_201
  Scenario Outline: Trả góp thẻ tín dụng online từ màn hình tìm kiếm

    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn Trả góp thẻ tín dụng bằng tìm kiếm
    And Chọn Trả góp ngay
    And Chọn số thẻ "<soThe>" trong danh sách thẻ trả góp
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
#    Thì Nhận thông báo thành công
    And Về trang chủ
    Examples:
      | kyHan | otp    | tuTimKiem | soThe               | soTien |
      | 6     | 888888 | tra gop   | 4572 7100 0000 6776 |        |

  @TC_202
  Scenario Outline: Trả góp thẻ tín dụng online từ danh sách tài khoản

    And mở Danh sách tài khoản từ màn hình chính
    And Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    And Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    And Chọn Trả góp ngay
    And Chọn giao dịch trả góp theo số tiền "<soTien>"
    Then Chọn kỳ hạn "<kyHan>" tháng
    And Chọn Đồng ý Điều khoản và điều kiện
    And Chọn Tiếp tục
    And Nhập OTP "<otp>"
    Then Nhận thông báo thành công
#    And Về trang chủ
    Examples:
      | kyHan | otp    | soTaiKhoanTheTD | soTien         |
      | 6     | 888888 | 257110000375898 | -5,000,000 VND |


  @TC_203
  Scenario Outline: Tra cứu giao dịch trả góp từ màn hình tìm kiếm

    And Mở ô tìm kiếm
    And Nhập từ "<tuTimKiem>" cần tìm kiếm
    And Chọn Trả góp thẻ tín dụng bằng tìm kiếm
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    And Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai    | soThe               | tuTimKiem | soTien         |
      | Đang trả góp | 4572 7100 0000 6776 | tra gop   | -5,000,000 VND |


  @TC_204
  Scenario Outline: Tra cứu giao dịch trả góp từ Tất cả dịch vụ

    And mở Tất cả dịch vụ
  # mở màn hình tất cả dịch vụ
    And Đi tới màn hình Trả góp online từ Tất cả dịch vụ
  # mở màn hình hiển thị trả góp Online
    And Nhấn Trả góp Online từ tất cả dịch vụ
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    And Chọn số thẻ "<soThe>" trong danh sách quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai   | soThe               |  | soTien  |
      | Đã hoàn tất | 4572 7100 0000 0798 |  | -94 USD |

  @TC_205
  Scenario Outline: Tra cứu giao dịch trả góp từ dịch vụ thẻ

    And mở Dịch vụ thẻ
    And Chọn thẻ dựa trên số thẻ đầy đủ "<soThe>"
    And Chọn tính năng Đăng ký trả góp
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch

#    And Về trang chủ
    Examples:
      | trangThai    | soThe | soTien         |
      | Đang trả góp |       | -5,000,000 VND |

  @TC_206
  Scenario Outline: Tra cứu giao dịch trả góp từ danh sách tài khảon

    And mở Danh sách tài khoản từ màn hình chính
    And Chọn Tài khoản thẻ tín dung "<soTaiKhoanTheTD>"
    And Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng
    And Chọn Trả góp ngay
    And Chọn quản lý trả góp
    Then Chọn giao dịch trả góp theo trạng thái "<trangThai>" và số tiền "<soTien>"
    And Hiển thị chi tiếp giao dịch
#    Và Về trang chủ
    Examples:
      | trangThai    | soTaiKhoanTheTD | soTien         |
      | Đang trả góp |                 | -5,000,000 VND |

