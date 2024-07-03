@SmartPOS @Mobile
Feature: SmartPOS VietQR

  @TC001 @Logged @SmartPOSVietQR
  Scenario Outline: SmartPOS VietQR khi da dang nhap tai khoan
#    call api gen qr
    Given tạo headers request QRSmartPOS
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/GenRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId   | clientDt   | providerId   | merchantId   | data.amount  | data.purposeOfTrans   |
      | <requestId> | <clientDt> | <providerId> | <merchantId> | <so_tien_gd> | <data.purposeOfTrans> |
    * lưu giá trị của các jsonPath "requestId" từ "BODY_REQUEST" với danh sách sessionVariableName "requestIdReq"
    And gọi api "vtbApi.development.gen" với phương thức "POST"
    Then httpCode phải là 200
#    decode base64
    And lấy data với jsonPath "data.base64QRCode" và lưu vào serenity variable "base64QRCode"
    And giải mã base64 "base64QRCode" và lưu với tên biến "base64Decoded"
#    tạo ảnh qr code
    Given mở ứng dụng "QRCodeGenerator"
    And đến tab tạo QR
    And chọn "Text"
    And nhập nội dung đã decode base64 "base64Decoded"
    And nhấn Generate QR Code
    And tải ảnh xuống
    And tắt ứng dụng
#    thanh toán
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And đăng nhập với mật khẩu "FROM_CONF_FILE"
    And đến Quét mã QR
    And chọn ảnh thứ "1" trong album mặc định đến MH Chuyển trong HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển trong HT
    And nhấn Tiếp tục trên MH Chuyển trong HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"
#    gọi api truy vấn
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/StatusinqRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId    | date       | providerId   | merchantId   | amt          |
      | requestIdReq | <clientDt> | <providerId> | <merchantId> | <so_tien_gd> |
    And gọi api "vtbApi.development.statusinq" với phương thức "POST"
    Then httpCode phải là 200
    And lấy "RESPONSE_EXPECTED" từ file json "qrSmartPOS/StatusinqResponse.json"
    And cập nhật lại json "RESPONSE_EXPECTED"
      | status.code |
      | 00          |
    And so sánh trường có jsonPath "status.code" của response thực tế với mong muốn
    And so sánh trường có jsonPath "transStatus" của response thực tế với mong muốn

    Examples:
      | tai_khoan_nhan   | ngan_hang_nhan | ten_nguoi_nhan      | so_tien_gd | requestId           | clientDt     | providerId        | merchantId        | data.purposeOfTrans |
      | 2UNQ119000172742 | CTG            | CONG TY CO PHAN ABC | 10000      | TIMESTAMP_LOCAL_NOW | LOCAL_TIME_1 | FROM_COMMAND_LINE | FROM_COMMAND_LINE | TIMESTAMP_LOCAL_NOW |

  @TC002 @NotLoggedIn @SmartPOSVietQR
  Scenario Outline: SmartPOS VietQR khi chua dang nhap tai khoan
#    call api gen qr
    Given tạo headers request QRSmartPOS
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/GenRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId   | clientDt   | providerId   | merchantId   | data.amount  | data.purposeOfTrans   |
      | <requestId> | <clientDt> | <providerId> | <merchantId> | <so_tien_gd> | <data.purposeOfTrans> |
    * lưu giá trị của các jsonPath "requestId" từ "BODY_REQUEST" với danh sách sessionVariableName "requestIdReq"
    And gọi api "vtbApi.development.gen" với phương thức "POST"
    Then httpCode phải là 200
#    decode base64
    And lấy data với jsonPath "data.base64QRCode" và lưu vào serenity variable "base64QRCode"
    And giải mã base64 "base64QRCode" và lưu với tên biến "base64Decoded"
#    tạo ảnh qr code
    Given mở ứng dụng "QRCodeGenerator"
    And đến tab tạo QR
    And chọn "Text"
    And nhập nội dung đã decode base64 "base64Decoded"
    And nhấn Generate QR Code
    And tải ảnh xuống
    And tắt ứng dụng
#    thanh toán
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "FROM_CONF_FILE" và mật khẩu "FROM_ACCOUNTS_FILE"
    And đến Quét mã QR
    And chọn ảnh thứ "1" trong album mặc định đến MH Chuyển trong HT
    And bỏ chọn Tham gia bảo hiểm an ninh mạng trên MH Chuyển trong HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển trong HT
    And nhấn Tiếp tục trên MH Chuyển trong HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"
    And quay lại home từ MH Kết quả GD
    And vào tab user
    And nhấn Đăng xuất
    And nhấn Đăng nhập trên MH Home
    And nhấn Đăng nhập bằng tài khoản khác
#    gọi api truy vấn
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/StatusinqRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId    | date       | providerId   | merchantId   | amt          |
      | requestIdReq | <clientDt> | <providerId> | <merchantId> | <so_tien_gd> |
    And gọi api "vtbApi.development.statusinq" với phương thức "POST"
    Then httpCode phải là 200
    And lấy "RESPONSE_EXPECTED" từ file json "qrSmartPOS/StatusinqResponse.json"
    And cập nhật lại json "RESPONSE_EXPECTED"
      | status.code |
      | 00          |
    And so sánh trường có jsonPath "status.code" của response thực tế với mong muốn
    And so sánh trường có jsonPath "transStatus" của response thực tế với mong muốn

    Examples:
      | tai_khoan_nhan   | ngan_hang_nhan | ten_nguoi_nhan      | so_tien_gd | requestId           | clientDt     | providerId        | merchantId        | data.purposeOfTrans |
      | 2UNQ119000172742 | CTG            | CONG TY CO PHAN ABC | 10000      | TIMESTAMP_LOCAL_NOW | LOCAL_TIME_1 | FROM_COMMAND_LINE | FROM_COMMAND_LINE | TIMESTAMP_LOCAL_NOW |

  @TC003 @Logged @SmartPOSVNPAYQR
  Scenario Outline: SmartPOS VNPAYQR khi da dang nhap tai khoan
#    call api gen qr
    Given tạo headers request QRSmartPOS
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/QRGeneratorRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId   | orderId   | amount       | transactionDate   | remark   | transTime   |
      | <requestId> | <orderId> | <so_tien_gd> | <transactionDate> | <remark> | <transTime> |
    * lưu giá trị của các jsonPath "requestId" từ "BODY_REQUEST" với danh sách sessionVariableName "requestIdReq"
    And gọi api "vtbApi.development.qrGenerator" với phương thức "POST"
    Then httpCode phải là 200
#    lưu qrData
    And lấy data với jsonPath "qrData" và lưu vào serenity variable "qrData"
#    tạo ảnh qr code
    Given mở ứng dụng "QRCodeGenerator"
    And đến tab tạo QR
    And chọn "Text"
    And nhập nội dung qrData "qrData"
    And nhấn Generate QR Code
    And tải ảnh xuống
    And tắt ứng dụng
#    thanh toán
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với mật khẩu "FROM_CONF_FILE"
    And đến Quét mã QR
    And chọn ảnh thứ "1" trong album mặc định đến MH Chuyển trong HT
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển trong HT
    And nhấn Tiếp tục trên MH Chuyển trong HT sau khi nhập số tiền đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"
#    gọi api truy vấn
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/qrTransInqSmartPosRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId    | txnId   | beginDate   | endDate   |
      | requestIdReq | <txnId> | <beginDate> | <endDate> |
    And gọi api "vtbApi.development.qrTransInqSmartPos" với phương thức "POST"
    Then httpCode phải là 200
    And lấy "RESPONSE_EXPECTED" từ file json "qrSmartPOS/qrTransInqSmartPosResponse.json"
    And cập nhật lại json "RESPONSE_EXPECTED"
      | status.code |
      | 00          |
    And so sánh trường có jsonPath "status.code" của response thực tế với mong muốn

    Examples:
      | tai_khoan_nhan   | ngan_hang_nhan | ten_nguoi_nhan      | so_tien_gd | requestId           | orderId         | transactionDate   | remark              | transTime           | txnId               | beginDate    | endDate      |
      | 2UNQ119000172742 | CTG            | CONG TY CO PHAN ABC | 10000      | TIMESTAMP_LOCAL_NOW | RANDOM_NUMBER_6 | FROM_COMMAND_LINE | TIMESTAMP_LOCAL_NOW | TIMESTAMP_LOCAL_NOW | TIMESTAMP_LOCAL_NOW | LOCAL_DATE_1 | LOCAL_DATE_1 |

  @TC004 @NotLoggedIn @SmartPOSVietQR
  Scenario Outline: SmartPOS VNPAYQR khi chua dang nhap tai khoan
#    call api gen qr
    Given tạo headers request QRSmartPOS
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/QRGeneratorRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId   | orderId   | amount       | transactionDate   | remark   | transTime   |
      | <requestId> | <orderId> | <so_tien_gd> | <transactionDate> | <remark> | <transTime> |
    * lưu giá trị của các jsonPath "requestId" từ "BODY_REQUEST" với danh sách sessionVariableName "requestIdReq"
    And gọi api "vtbApi.development.qrGenerator" với phương thức "POST"
    Then httpCode phải là 200
#    lưu qrData
    And lấy data với jsonPath "qrData" và lưu vào serenity variable "qrData"
#    tạo ảnh qr code
    Given mở ứng dụng "QRCodeGenerator"
    And đến tab tạo QR
    And chọn "Text"
    And nhập nội dung đã decode base64 "qrData"
    And nhấn Generate QR Code
    And tải ảnh xuống
    And tắt ứng dụng
#    thanh toán
    Given mở ứng dụng "iPay"
    And nhấn Đăng nhập trên MH Home
    And kiểm tra xem đã đăng nhập chưa
    And đăng nhập với tên đăng nhập "FROM_CONF_FILE" và mật khẩu "FROM_ACCOUNTS_FILE"
    And đến Quét mã QR
    And chọn ảnh thứ "1" trong album mặc định đến MH Thanh toán QR
    Then hiển thị tên người nhận "<ten_nguoi_nhan>" trên MH Chuyển trong HT
    And nhấn Tiếp tục trên MH Thanh toán QR đến MH Xác nhận GD
    And nhấn Xác nhận & hoàn tất trên MH Xác nhận GD
    Then hiển thị Chuyển tiền thành công với STK "<tai_khoan_nhan>" NH "<ngan_hang_nhan>" số tiền "<so_tien_gd>"
    And quay lại home từ MH Kết quả GD
    And vào tab user
    And nhấn Đăng xuất
    And nhấn Đăng nhập trên MH Home
    And nhấn Đăng nhập bằng tài khoản khác
#    gọi api truy vấn
    When lấy "BODY_REQUEST" từ file json "qrSmartPOS/qrTransInqSmartPosRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId    | txnId   | beginDate   | endDate   |
      | requestIdReq | <txnId> | <beginDate> | <endDate> |
    And gọi api "vtbApi.development.qrTransInqSmartPos" với phương thức "POST"
    Then httpCode phải là 200
    And lấy "RESPONSE_EXPECTED" từ file json "qrSmartPOS/qrTransInqSmartPosResponse.json"
    And cập nhật lại json "RESPONSE_EXPECTED"
      | status.code |
      | 00          |
    And so sánh trường có jsonPath "status.code" của response thực tế với mong muốn

    Examples:
      | tai_khoan_nhan   | ngan_hang_nhan | ten_nguoi_nhan      | so_tien_gd | requestId           | orderId         | transactionDate   | remark              | transTime           | txnId               | beginDate    | endDate      |
      | 2UNQ119000172742 | CTG            | CONG TY CO PHAN ABC | 10000      | TIMESTAMP_LOCAL_NOW | RANDOM_NUMBER_6 | FROM_COMMAND_LINE | TIMESTAMP_LOCAL_NOW | TIMESTAMP_LOCAL_NOW | TIMESTAMP_LOCAL_NOW | LOCAL_DATE_1 | LOCAL_DATE_1 |