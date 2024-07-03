@iPay @Mobile
Feature: iPay

  Background:
    Given mở ứng dụng "iPay"
    And đăng nhập với mật khẩu "FROM_CONF_FILE"

  @TC01
  Scenario Outline: Dat lich chuyen tien trong Vietinbank
    And đến Danh sách tài khoản
    And chuyển bằng "STKMacDinh" "<tai_khoan_chuyen>"
    And đến MH Chuyển trong & ngoài HT
    And đến MH Chuyển trong HT sau khi chọn người thụ hưởng "<nguoi_thu_huong>"
    Then hiển thị tên người nhận "<ten_nguoi_thu_huong>" trên MH Chuyển trong HT
    And nhập số tiền "<so_tien_gd>" chuyển trong HT
    And ẩn bàn phím trên MH Chuyển trong HT
    And chọn thời gian chuyển "<thoi_gian_chuyen>"
    And chọn tần suất "<tan_suat>"
    And nhấn Tiếp tục trên MH Chuyển trong HT sau khi nhập số tiền đến MH Xác nhận GD
    Then hiển thị tên người nhận "<ten_nguoi_thu_huong>" và số tiền "<so_tien_gd>" trên MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị popup thông báo tạo lịch chuyển tiền thành công
    And nhấn Đồng ý trên popup thông báo
    Then hiển thị MH Chuyển trong & ngoài HT

    Examples:
      | tai_khoan_chuyen   | nguoi_thu_huong | ten_nguoi_thu_huong | so_tien_gd | thoi_gian_chuyen | tan_suat   |
      | FROM_ACCOUNTS_FILE | BAC VTB         | DOAN DONG BAC       | 50000      | Chuyển sau       | Hàng Tháng |

  @TC04
  Scenario Outline: Chuyen khoan lien NH
    And đến Danh sách tài khoản
    And chuyển bằng "STKMacDinh" "<tai_khoan_chuyen>"
    And đến MH Chuyển trong & ngoài HT
    And nhập STK muốn chuyển tiền ngoài HT "<tai_khoan_nhan>"
    And chọn NH để chuyển ngoài HT "<ngan_hang_nhan>"
    And nhấn Tiếp tục đến MH Chuyển ngoài HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển ngoài HT
    And nhập số tiền để chuyển ngoài HT "<so_tien_gd>"
    And ẩn bàn phím trên MH Chuyển ngoài HT
    And nhấn Tiếp tục trên MH Chuyển ngoài HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"

    Examples:
      | tai_khoan_chuyen   | tai_khoan_nhan | ngan_hang_nhan | ten_nguoi_nhan  | so_tien_gd |
      | FROM_ACCOUNTS_FILE | 0201000616816  | VCB            | NGUYEN DINH TAI | 10000      |

  @TC05
  Scenario Outline: Chuyen khoan bang so the
    And đến Danh sách tài khoản
    And chuyển bằng "STKMacDinh" "<tai_khoan_chuyen>"
    And đến MH Chuyển trong & ngoài HT
    And chọn tab Tới số thẻ
    And nhập số thẻ "<the_nhan>"
    And chọn Xong trên bàn phím
    And nhấn Tiếp tục đến MH Chuyển ngoài HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển ngoài HT
    And nhập số tiền để chuyển ngoài HT "<so_tien_gd>"
    And ẩn bàn phím trên MH Chuyển ngoài HT
    And nhấn Tiếp tục trên MH Chuyển ngoài HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với số thẻ "<the_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"

    Examples:
      | tai_khoan_chuyen   | the_nhan         | ngan_hang_nhan | ten_nguoi_nhan  | so_tien_gd |
      | FROM_ACCOUNTS_FILE | 4524041891045703 | VCB            | NGUYEN DINH TAI | 10000      |

  @TC06
  Scenario Outline: Thanh toan
    And đến Quét mã QR
    And chọn ảnh thứ "1" trong album "Automation Test iPay" đến MH Chuyển ngoài HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển ngoài HT
    And nhập số tiền để chuyển ngoài HT "<so_tien_gd>"
    And ẩn bàn phím trên MH Chuyển ngoài HT
    And nhấn Tiếp tục trên MH Chuyển ngoài HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"

    Examples:
      | tai_khoan_nhan | ngan_hang_nhan | ten_nguoi_nhan  | so_tien_gd |
      | 0201000616816  | VCB            | NGUYEN DINH TAI | 10000      |

  @TC07
  Scenario Outline: Gui thiep mung den nhieu nguoi cung luc
    And chọn icon tìm kiếm đến MH Tìm kiếm
    And nhập tìm kiếm và đến MH "Gửi tiền mừng lễ, Tết"
    And thêm mới người nhận "<receiver1>"
#    And thêm mới người nhận "<receiver2>"
    And nhập số tiền muốn gửi cho từng người "<amount>"
    And nhập lời chúc muốn gửi "<wishes>"
    And nhấn Tiếp tục trên MH Gửi tiền mừng đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị thông báo gửi tiền mừng hoàn tất

    Examples:
      | receiver1    | receiver2  | amount | wishes          |
      | 107006615594 | 0964188897 | 10000  | Automation Test |

  @TC08
  Scenario Outline: Dat hoa chuc mung
    And đến Tặng hoa tươi
    And đến tab Giỏ hàng
    And tích ô Tất cả trên MH Giỏ hàng hoa tươi
    And xoá giỏ hàng
    And trở về MH Tặng hoa tươi
    And chọn nơi giao hoa "<city>"
    And chọn chủ đề "<topic>"
    And chọn mức giá "<price>"
    And chọn thương hiệu "<brand>"
    And nhấn Tìm kiếm đến MH Kết quả tìm hoa tươi
    And chọn bó hoa thứ "1"
    And "Thêm" số lượng "0" bó hoa
    And nhấn Thêm vào giỏ đến MH Giỏ hàng hoa tươi
    And tích ô Tất cả trên MH Giỏ hàng hoa tươi
    And nhấn Đặt mua hoa đến MH Đặt mua hoa
    And chọn ngày nhận hoa ngẫu nhiên
    And chọn vào Thêm người nhận
    And chọn Hoa gửi tặng cho "<relationship>"
    And nhập lời nhắn cho người nhận "Automation Test"
    And nhập ghi chú cho nhà cung cấp "Không"
    And chọn Giờ nhận hàng "<timeReceive>"
    And chọn người nhận thứ "1" trong danh sách
    And nhấn Thêm người nhận đến MH Đặt mua hoa
    And chọn "Có" giấu tên người gửi
    And chọn "Có" yêu cầu xuất hoá đơn
    And nhập họ tên người gửi "<senderName>"
    And nhập SĐT người gửi "<senderMobile>"
    And nhập email người gửi "<senderEmail>"
    And nhập Tên công ty nhận hoá đơn "Ngân hàng TMCP Công Thương Việt Nam"
    And nhập MST công ty nhận hoá đơn "0100111948"
    And nhập Địa chỉ công ty nhận hoá đơn "183 Nguyễn Lương Bằng, Đống Đa, Hà Nội"
    And nhập Email công ty nhận hoá đơn "contact@vietinbank.vn"
    And nhấn Nhập để trở lại MH
    And nhấn Đặt mua hoa đến MH Xác nhận thanh toán
#    And nhấn Xác nhận đến MH Thanh toán đặt hoa
#    And nhấn Tiếp tục thanh toán đến MH Xác nhận GD
#    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD

    Examples:
      | city      | topic         | price               | brand         | relationship | timeReceive   | senderName      | senderMobile | senderEmail          |
      | TP Hà Nội | Hoa chúc mừng | 500,000 – 1,000,000 | Hoa Việt Pháp | Bạn bè       | 13:00 - 19:00 | Nguyễn Đình Tài | 0353999397   | taind4@vietinbank.vn |