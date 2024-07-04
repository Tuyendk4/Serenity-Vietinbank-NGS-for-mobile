@qrShop @Mobile
Feature: Quản lý cửa hàng

  @QRS015
  Scenario: Quan ly cua hang: co the scroll man hinh quan ly cua hang
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And hiển thị biểu đồ doanh thu cửa hàng
    And scroll lên để xem biểu đồ doanh thu cửa hàng
    Then không hiển thị biểu đồ doanh thu cửa hàng
    And scroll xuống để xem biểu đồ doanh thu cửa hàng
    Then hiển thị biểu đồ doanh thu cửa hàng

  @QRS016 @QRS017 @QRS018 @QRS019
  Scenario: Quan ly cua hang: kiem tra nut back hoat dong
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhấn quay lại MH Quản lý cửa hàng
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "namhoang"
    And nhấn vào Thông tin cửa hàng
    Then hiển thị MH Thông tin cửa hàng
    And nhấn nút quay lại trong MH Thông tin cửa hàng
    Then hiển thị MH Quản lý cửa hàng
    And nhấn nút quay lại trong MH Quản lý cửa hàng
    And nhấn nút quay lại trong MH Quản lý cửa hàng
    Then hiển thị dịch vụ iShop hộ kinh hoanh

  @QRS020
  Scenario: Quan ly cua hang: co the click sang tab: Dong so huu/ nhan vien
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tab "Đồng sở hữu/nhân viên"
    Then hiển thị text "Quý khách chưa là Đồng sở hữu/nhân viên của cửa hàng"