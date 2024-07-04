@qrShop @validate @Mobile
Feature: Kiểm tra đóng đóng/ mở cửa hàng

  @QRS025
  Scenario: Dong/Mo cua hang: Dong cua hang
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "Shop 12"
    Then xác nhận trạng thái cửa hàng "Đang hoạt động"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn nút Dừng hoạt động
    Then hiển thị thông báo "Quý khách có chắc chắn muốn đóng cửa hàng này?"
    And nhấn vào "Xác nhận"
#    Then hiển thị thông báo "Cập nhật thành công"
    And nhấn vào "Đồng ý"
    Then hiển thị MH Quản lý cửa hàng
    And xác nhận trạng thái cửa hàng "Đóng cửa"
    And chọn tài khoản "Shop 12"
    Then xác nhận trạng thái cửa hàng "Đóng cửa"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn vào Mở lại cửa hàng
    Then hiển thị thông báo "Quý khách có chắc chắn muốn mở lại cửa hàng này?"
    And nhấn vào "Xác nhận"
#    Then hiển thị thông báo "Cập nhật thành công"
    And nhấn vào "Đồng ý"
    Then hiển thị MH Quản lý cửa hàng

  @QRS026
  Scenario: Dong/Mo cua hang: Mo lai cua hang
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "namhoang"
    Then xác nhận trạng thái cửa hàng "Đóng cửa"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn vào Mở lại cửa hàng
    Then hiển thị thông báo "Quý khách có chắc chắn muốn mở lại cửa hàng này?"
    And nhấn vào "Xác nhận"
#    Then hiển thị thông báo "Cập nhật thành công"
    And nhấn vào "Đồng ý"
    Then hiển thị MH Quản lý cửa hàng
    And xác nhận trạng thái cửa hàng "Đang hoạt động"
    And chọn tài khoản "namhoang"
    Then xác nhận trạng thái cửa hàng "Đang hoạt động"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn nút Dừng hoạt động
    Then hiển thị thông báo "Quý khách có chắc chắn muốn đóng cửa hàng này?"
    And nhấn vào "Xác nhận"
#    Then hiển thị thông báo "Cập nhật thành công"
    And nhấn vào "Đồng ý"
    Then hiển thị MH Quản lý cửa hàng

  @QRS023
  Scenario: Dong/Mo cua hang: Cho phep KH dong 10 cua hang/tai khoan
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "Free Test"
    Then xác nhận trạng thái cửa hàng "Đang hoạt động"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn vào Mở lại cửa hàng
    Then hiển thị thông báo "Quý khách có chắc chắn muốn đóng cửa hàng này?"
    And nhấn vào "Xác nhận"
    And hiển thị thông báo "Quý khách chỉ được đăng ký tối đa 10 cửa hàng đang đóng. Vui lòng kiểm tra lại."
    And nhấn vào "Đồng ý"
    Then popup Thông báo được đóng lại

  @QRS024
  Scenario:Dong/Mo cua hang: Cho phep KH mo 10 cua hang/tai khoan
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "Free Test"
    Then xác nhận trạng thái cửa hàng "Đóng cửa"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn vào Mở lại cửa hàng
    Then hiển thị thông báo "Quý khách có chắc chắn muốn mở lại cửa hàng này?"
    And nhấn vào "Xác nhận"
    And hiển thị thông báo "Quý khách chỉ được đăng ký tối đa 10 cửa hàng đang hoạt động. Vui lòng kiểm tra lại."
    And nhấn vào "Đồng ý"
    Then popup Thông báo được đóng lại