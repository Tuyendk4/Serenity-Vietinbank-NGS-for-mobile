# language: vi
Tính năng: M7S01 - Vay tiêu dùng cá nhân

  Kịch bản: Thực hiện vay tiêu dùng bằng tài khoản chi nhánh
    Cho Mở VTB iPayApp
    Khi Đăng nhập user "nhungauto1", password "12121212"
    Và Menu Dịch vụ vay và tín dụng
    Và Vay tiêu dùng cá nhân
    Và Công cụ tính lãi suất - Tính toán ngay
    Và Vay "3000000" VND, thời hạn "12" tháng, "EditText"
    Thì Lịch trả nợ - Lãi suất "15.9%/năm"
    * Lịch trả nợ - Tổng tiền phải trả "Từ 253,313 VND đến 289,750 VND"
    * Lịch trả nợ - Tổng lãi phải trả "258,378 VND"
    * Lịch trả nợ - Tổng số tiền gốc và lãi phải trả "3,258,378 VND"
    Khi MH Vay - Bước 1
    Thì MH Vay - Bước 1 - Lãi suất vay "15.9%/năm"
    * MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định "Từ 253,313 VND đến 289,750 VND"
    Khi MH Vay - Bước 2
    Và MH Vay - Bước 2 - Ngày trả nợ hàng tháng "15", mục đích vay "Mua thiết bị di động", email "nhungauto1@mailinator.com", tỉnh "TINH AN GIANG", huyện "THANH PHO LONG XUYEN"
    Thì MH Vay - Bước 3 - Số tiền vay "3,000,000 VND"
    Và MH Vay - Bước 3 - Thời hạn vay "12 tháng"
    Và MH Vay - Bước 3 - Lãi suất dự kiến là "15.9%/năm"
    Và MH Vay - Bước 3 - Mục đích vay là "Mua thiết bị di động"
    Và MH Vay - Bước 3 - Ngày trả nợ hàng tháng "15"
    Và MH Vay - Bước 3 - họ và tên người vay "CUSTOMER NAME"
    Khi Gửi yêu cầu vay
    Thì Thông báo "VietinBank đang thực hiện thẩm định, Quý khách sẽ nhận được kết quả trong vòng 6h qua tin nhắn SMS/OTT."
    Thì Thông báo "Quý khách cần trợ giúp thêm xin liên hệ 1900558868"
    Khi Chọn Đồng ý trên Popup thông báo
    Thì hiển thị số lượng tại Lịch sử vay
    Khi Vào MH Lịch sử vay
    Thì Khoản vay "Chờ thẩm định", số tiền "3,000,000 VND"
    Khi Vào MH Vay tiêu dùng cá nhân
    Và  Mở Hồ sơ vay tiêu dùng cá nhân
    Thì Hồ sơ vay tiêu dùng cá nhân - Số tiền vay "3,000,000 VND"
    Và Hồ sơ vay tiêu dùng cá nhân - Thời hạn vay "12 tháng"
    Và Hồ sơ vay tiêu dùng cá nhân - Ngày trả nợ hàng tháng "15"
    Và Hồ sơ vay tiêu dùng cá nhân - Mục đích vay "Mua thiết bị di động"
    Và Hồ sơ vay tiêu dùng cá nhân - Họ và tên ngươi vay "CUSTOMER NAME"
    Và Hồ sơ vay tiêu dùng cá nhân - Email nhận hợp đồng "nhungauto1@mailinator.com"
