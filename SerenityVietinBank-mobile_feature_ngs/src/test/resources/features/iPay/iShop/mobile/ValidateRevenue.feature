@qrShop @revenue @Mobile
Feature: Validate revenue

  @QRS027
  Scenario: Doanh thu: Doanh thu chi tiet cua hang trang thai dang hoat dong
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "Shop 12"
    Then xác nhận trạng thái cửa hàng "Đang hoạt động"
    And hiển thị text Tab "Ngày"
    And hiển thị text Tab "Tuần"
    And hiển thị text Tab "Tháng"
    And hiển thị text Tab "Xem mã QR"
    And hiển thị text Tab "Chia sẻ cửa hàng"
    And hiển thị text Tab "Hôm nay"
    And hiển thị text Tab "3 ngày gần nhất"
    And hiển thị text Tab "Tìm kiếm"
    And chọn tab "Chia sẻ cửa hàng"
    Then hiển thị MH Chia sẻ cửa hàng
    Then hiển thị text "Chia sẻ tiền vào cửa hàng"

  @QRS028
  Scenario: Xem doanh thu chi tiet
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "nga.vth" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And chọn tài khoản "109004491514"
    Then xác nhận trạng thái cửa hàng "Đang hoạt động"
    And nhấn nút tìm kiếm
    Then hiển thị MH Tra cứu lịch sử giao dịch
    And chọn tìm kiếm theo khoảng thời gian
    And chọn tháng tìm kiếm "Tháng 5"
    And tìm kiếm từ ngày "29"
    And tìm kiếm đến ngày "31"
    And nhấn nút Chọn ngày
    And nhấn nút Tìm kiếm lịch sử giao dịch
    Then hiển thị mã QR
    And hiển thị thông tin giao dịch gần đây