# language: vi
@flow1
Tính năng: M7S01 - Vay tiêu dùng cá nhân - Nội bộ

  Kịch bản: Thực hiện tạo vay tiêu dùng không ưu đãi thông qua tính toán khoản vay bằng tài khoản nội bộ
    Cho Mở VTB iPayApp
    Khi Đăng nhập user "711A57165998", password "12121212"
    Và Menu Dịch vụ vay và tín dụng
    Và Vay tiêu dùng cá nhân
    Và Công cụ tính lãi suất - Tính toán ngay
    Và Vay "3000000" VND, thời hạn "12" tháng không có ưu đãi đặc biệt, "EditText"
    Thì Lịch trả nợ - Lãi suất "5.2%/năm"
    * Lịch trả nợ - Số tiền phải trả hàng tháng "Từ 251,083 đến 263,000 VND"
    * Lịch trả nợ - Tổng lãi phải trả "84,500 VND"
    * Lịch trả nợ - Tổng số tiền gốc và lãi phải trả "3,084,500 VND"
    Khi MH Vay - Bước 1
    Thì MH Vay - Bước 1 - Lãi suất vay "5.2%/năm"
    * MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định "Từ 251,083 VND đến 263,000 VND"
    Khi MH Vay - Bước 2
    Và MH Vay - Bước 2 - Ngày trả nợ hàng tháng "15", mục đích vay "Mua thiết bị di động", email "nhungauto1@mailinator.com", tỉnh "TINH AN GIANG", huyện "THANH PHO LONG XUYEN"
    Thì MH Vay - Bước 3 - Số tiền vay "3,000,000 VND"
    Và MH Vay - Bước 3 - Thời hạn vay "12 tháng"
    Và MH Vay - Bước 3 - Lãi suất dự kiến là "5.2%/năm"
    Và MH Vay - Bước 3 - Mục đích vay là "Mua thiết bị di động"
    Và MH Vay - Bước 3 - Ngày trả nợ hàng tháng "15"
    Và MH Vay - Bước 3 - họ và tên người vay "CUSTOMER NAME"
    Khi Gửi yêu cầu vay
    Thì Thông báo thành công: "Chúc mừng Quý khách đủ điều kiện vay vốn tại VietinBank, Số tiền: 3.000.000 VNĐ, Thời hạn 12 tháng, Xin hoàn thiện tiếp thủ tục vay vốn trước"
    Khi Nhấn Đồng ý trên Thành công popup
    Thì Thẩm định hồ sơ thành công - Số tiền vay "3,000,000 VND"
    Và Thẩm định hồ sơ thành công - Lãi suất "5%/năm"
    Và Thẩm định hồ sơ thành công - Thời hạn vay "12 tháng"
    Khi Thẩm định hồ sơ thành công - lựa chọn tài khoản
    Và Xem nội dung hợp đồng vay
    Và MH Hợp động vay - quay trở lại Thẩm định hồ sơ thành công
    Và Đồng ý vay
    Và Xác nhận hợp đồng - Nhập OTP "888888"
    Thì Kết quả giao dịch - hiển thị "Quý khách đã xác nhận Hợp đồng vay vốn thành công. Số tiền vay sẽ được giải ngân vào tài khoản thanh toán Quý khách đã lựa chọn. Hợp đồng cho vay sẽ được gửi tới Quý khách qua email"

#  Kịch bản: Thực hiện tạo vay tiêu dùng có ưu đãi thông qua tính toán khoản vay bằng tài khoản nội bộ
#    Cho Mở VTB iPayApp
#    Khi Đăng nhập user "711A57165998", password "12121212"
#    Và Menu Dịch vụ vay và tín dụng
#    Và Vay tiêu dùng cá nhân
#    Và Công cụ tính lãi suất - Tính toán ngay
#    Và Vay "3000000" VND, thời hạn "12" tháng có ưu đãi đặc biệt, "EditText"
#    Thì Lịch trả nợ - Lãi suất "5.2%/năm"
#    * Lịch trả nợ - Tổng tiền phải trả "Từ 251,083 đến 263,000 VND"
#    * Lịch trả nợ - Tổng lãi phải trả "84,500 VND"
#    * Lịch trả nợ - Tổng số tiền gốc và lãi phải trả "3,084,500 VND"
#    Khi MH Vay - Bước 1
#    Thì MH Vay - Bước 1 - Lãi suất vay "5.2%/năm"
#    * MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định "Từ 251,083 VND đến 263,000 VND"
#    Khi MH Vay - Bước 1 - Xác nhận sử dụng bảo hiểm VietinBank
#    Khi MH Vay - Bước 2
#    Và MH Vay - Bước 2 - Ngày trả nợ hàng tháng "15", mục đích vay "Mua thiết bị di động", email "nhungauto1@mailinator.com", tỉnh "TINH AN GIANG", huyện "THANH PHO LONG XUYEN"
#    Thì MH Vay - Bước 3 - Số tiền vay "3,000,000 VND"
#    Và MH Vay - Bước 3 - Thời hạn vay "12 tháng"
#    Và MH Vay - Bước 3 - Lãi suất dự kiến là "5.2%/năm"
#    Và MH Vay - Bước 3 - Chương trình ưu đãi là "VietinCare"
#    Và MH Vay - Bước 3 - Mục đích vay là "Mua thiết bị di động"
#    Và MH Vay - Bước 3 - Ngày trả nợ hàng tháng "15"
#    Và MH Vay - Bước 3 - họ và tên người vay "CUSTOMER NAME"
#    Khi Gửi yêu cầu vay
#    Thì Thông báo thành công: "Chúc mừng Quý khách đủ điều kiện vay vốn tại VietinBank, Số tiền: 3.000.000 VNĐ, Thời hạn 12 tháng, Xin hoàn thiện tiếp thủ tục vay vốn trước"
#    Khi Nhấn Đồng ý trên Thành công popup
#    Thì Thẩm định hồ sơ thành công - Số tiền vay "3,000,000 VND"
#    Và Thẩm định hồ sơ thành công - Lãi suất "5%/năm"
#    Và Thẩm định hồ sơ thành công - Thời hạn vay "12 tháng"
#    Khi Thẩm định hồ sơ thành công - lựa chọn tài khoản
#    Và Xem nội dung hợp đồng vay
#    Và MH Hợp động vay - quay trở lại Thẩm định hồ sơ thành công
#    Và Xem nội dung hợp đồng bảo hiểm
#    Và MH Hợp đồng bảo hiểm - quay trở lại Thẩm định hồ sơ thành công
#    Và Đồng ý vay và mua bảo hiểm
#    Và Xác nhận hợp đồng - Nhập OTP "888888"
#    Thì Kết quả giao dịch - hiển thị "Quý khách đã xác nhận Hợp đồng vay vốn thành công. Số tiền vay sẽ được giải ngân vào tài khoản thanh toán Quý khách đã lựa chọn. Hợp đồng cho vay sẽ được gửi tới Quý khách qua email"
