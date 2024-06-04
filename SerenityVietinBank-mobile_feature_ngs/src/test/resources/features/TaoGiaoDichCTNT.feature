# language: vi
@transfer
Tính năng: M2S02 - Chuyển tiền ngoại tệ

  @test_case_2
  Kịch bản: KH tạo giao dịch CTNT với mục đích: sinh hoạt phí
    Cho Mở VTB iPayApp
    Khi Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu "12121212"
    Và Di chuyển vào Chuyển tiền
    Và Chọn Mua Chuyển ngoại tệ
    Và Chọn mục đích chuyển tiền là "Chuyển tiền trả các loại phí, lệ phí cho nước ngoài"
    Và Chon người nhận
    Và Nhập số ngoại tệ cần chuyển đi là "1"
    Và Chọn hồ sơ cung cấp
    Thì Xác nhận giao dịch
    Thì Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_3
  Kịch bản: KH tạo giao dịch CTNT với mục đích: Trợ cấp cho thân nhân ở nước ngoài
    Cho Mở VTB iPayApp
    Khi Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu "12121212"
    Và Di chuyển vào Chuyển tiền
    Và Chọn Mua Chuyển ngoại tệ
    Và Chọn mục đích chuyển tiền là "Trợ cấp cho thân nhân ở nước ngoài"
    Và Chon người nhận
    Và Nhập số ngoại tệ cần chuyển đi là "1"
    Và Chọn hồ sơ cung cấp
    Thì Xác nhận giao dịch
    Thì Kiểm tra lịch sử chuyển tiền ngoại tệ
