@qrShop @Mobile
Feature: Tao cua hang

  @QRS001
  Scenario: Tao cua hang khi KH da co alias
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "Việt 019"
    And chọn lĩnh vực kinh doanh "Ăn uống"
    And chọn tài khoản nhận tiền "103867045974"
    And chọn tỉnh - thành phố "Hà Nội"
    And chọn quận huyện "QUẬN BẮC TỪ LIÊM"
    And chọn phường - xã "PHƯỜNG MINH KHAI"
    And nhập địa chỉ "124 Đường Bưởi"
    And nhấn nút Xác nhận
    Then tạo cửa hàng thành công

  @ID06
  Scenario: Tao cua hang với từ ngoài màn hình iPay shop
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Tạo cửa hàng mới"
    Then hiển thị MH Tạo cửa hàng

  @QRS003
  Scenario: Không cho phép đặt trùng tên/1 CIF, có thể đặt trùng tên nếu khác CIF
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "kieuvanhuan" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    Then hiển thị MH Quản lý cửa hàng
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "namhoang"
    Then hiển thị popup thông báo
    And hiển thị thông báo "Tên cửa hàng đã tồn tại. Quý khách vui lòng nhập tên khác!"
    And nhấn vào "Đồng ý"
    Then popup Thông báo được đóng lại

  @QRS002
  Scenario: Cho phép KH tạo tối đa 10 cửa hàng/tài khoản
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "Việt 09"
    And chọn lĩnh vực kinh doanh "Ăn uống"
    And chọn tài khoản nhận tiền "103867045974"
    And chọn tỉnh - thành phố "Hà Nội"
    And chọn quận huyện "QUẬN BẮC TỪ LIÊM"
    And chọn phường - xã "PHƯỜNG MINH KHAI"
    And nhập địa chỉ "124 Đường Bưởi"
    And nhấn nút Xác nhận
    Then hiển thị popup thông báo
    And hiển thị thông báo "Quý khách chỉ được đăng ký tối đa 10 cửa hàng đang hoạt động. Vui lòng kiểm tra lại."
    And nhấn vào "Đồng ý"
    Then popup Thông báo được đóng lại

  @QRS004 @QRS005 @QRS006
  Scenario Outline: Tạo mới cửa hàng - Kiểm tra dự liệu nhập vào trường Tên cửa hàng
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "<tenCuaHang>"
    Then kiểm tra tên cửa hàng hiển thị "<giaTri>"

    Examples:
      | tenCuaHang            | giaTri               |
      | có dấu                | có dấu               |
      | store name has max 19 | store name has max 1 |
      | store#$%^             | store                |

  @QRS007
  Scenario Outline: Tạo mới cửa hàng - Tên cửa hàng để trống
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "<tenCuaHang>"
    And nhấn nút Xác nhận
    And hiển thị thông báo "<message>"

    Examples:
      | tenCuaHang | message                          |
      | BLANK      | Tên cửa hàng không được để trống |

  @QRS008
  Scenario Outline: Tạo mới cửa hàng - không nhập giá trị vào trường: Lĩnh vực kinh doanh
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And chọn lĩnh vực kinh doanh "<lĩnh vực kinh doanh>"
    And nhập địa chỉ "124"
    And nhấn nút Xác nhận
    And hiển thị thông báo "<message>"

    Examples:
      | lĩnh vực kinh doanh | message                                 |
      | BLANK               | Lĩnh vực kinh doanh không được để trống |

  @QRS009
  Scenario Outline: Tạo mới cửa hàng -  không nhập giá trị vào trường: Tỉnh thành phố
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And chọn lĩnh vực kinh doanh "ăn uống"
    And chọn tỉnh - thành phố "<tỉnh thành phố>"
    And nhập địa chỉ "124"
    And nhấn nút Xác nhận
    Then hiển thị thông báo "<message>"

    Examples:
      | tỉnh thành phố | message                            |
      | BLANK          | Tỉnh/Thành phố không được để trống |

  @QRS010
  Scenario Outline: Tạo mới cửa hàng:  không nhập giá trị vào trường: quận huyện
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And chọn lĩnh vực kinh doanh "ăn uống"
    And chọn tỉnh - thành phố "Hà Nội"
    And chọn quận huyện "<quận huyện>"
    And nhập địa chỉ "124"
    And nhấn nút Xác nhận
    Then hiển thị thông báo "<message>"

    Examples:
      | quận huyện | message                        |
      | BLANK      | Quận/Huyện không được để trống |

  @QRS011
  Scenario Outline: Tạo mới cửa hàng:  không nhập giá trị vào trường: Phường xã
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And chọn lĩnh vực kinh doanh "ăn uống"
    And chọn tỉnh - thành phố "Hà Nội"
    And chọn quận huyện "QUẬN BẮC TỪ LIÊM"
    And chọn phường - xã "<phường xã>"
    And nhập địa chỉ "124"
    And nhấn nút Xác nhận
    Then hiển thị thông báo "<message>"

    Examples:
      | phường xã | message                       |
      | BLANK     | Phường/Xã không được để trống |

  @QRS012
  Scenario Outline: Tạo mới cửa hàng:  không nhập giá trị vào trường: địa chỉ cụ thể
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And chọn lĩnh vực kinh doanh "ăn uống"
    And chọn tỉnh - thành phố "Hà Nội"
    And chọn quận huyện "QUẬN BẮC TỪ LIÊM"
    And chọn phường - xã "PHƯỜNG MINH KHAI"
    And nhập địa chỉ "<địa chỉ>"
    And nhấn nút Xác nhận
    Then hiển thị thông báo "<message>"

    Examples:
      | địa chỉ | message                            |
      | BLANK   | Địa chỉ cụ thể không được để trống |

  @QRS013
  Scenario Outline: Tạo mới cửa hàng: Các trường cần tìm kiếm: lĩnh vực kinh doanh, quận huyện, tỉnh thành,  phường xã: có thể search như danh bạ điện thoại
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "No 02"
    And nhập địa chỉ "123"
    And chọn vào "<field 1>"
    And nhập nội dung tìm kiếm "<search 1>"
    Then kiểm tra dữ liệu đã hiển thị chứa "<expected 1>"
    And chọn dữ liệu đầu tiên chứa "<expected 1>"
    And chọn vào "<field 2>"
    And nhập nội dung tìm kiếm "<search 2>"
    Then kiểm tra dữ liệu đã hiển thị chứa "<expected 2>"
    And chọn dữ liệu đầu tiên chứa "<expected 2>"
    And chọn vào "<field 3>"
    And nhập nội dung tìm kiếm "<search 3>"
    Then kiểm tra dữ liệu đã hiển thị chứa "<expected 3>"
    And chọn dữ liệu đầu tiên chứa "<expected 3>"
    And chọn vào "<field 4>"
    And nhập nội dung tìm kiếm "<search 4>"
    Then kiểm tra dữ liệu đã hiển thị chứa "<expected 4>"
    And chọn dữ liệu đầu tiên chứa "<expected 4>"

    Examples:
      | field 1             | search 1 | expected 1 | field 2        | search 2 | expected 2 | field 3    | search 3 | expected 3 | field 4   | search 4 | expected 4 |
      | Lĩnh vực kinh doanh | khoe     | khỏe       | Tỉnh/Thành phố | noi      | nội        | Quận/Huyện | bac      | Bắc        | Phường/Xã | phuc     | Phúc       |

  @QRS014
  Scenario Outline: Tạo mới cửa hàng: không nhập giá trị vào tất cả các trường
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "samkh" và mật khẩu "12121212"
    And đến chức năng "Quản lý cửa hàng"
    And nhấn nút Tạo cửa hàng
    Then hiển thị MH Tạo cửa hàng
    And nhập tên cửa hàng "<tên của hàng>"
    And nhấn nút Xác nhận
    And hiển thị thông báo "<message>"

    Examples:
      | tên của hàng | message                          |
      | BLANK        | Tên cửa hàng không được để trống |

