@transfer
Feature: : M2S02 - Chuyển tiền ngoại tệ

  Background: :
    Given Mở VTB iPayApp
    When Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu "12121212"

  @test_case_2
  Scenario: : KH tạo giao dịch CTNT với mục đích: sinh hoạt phí
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Chuyển tiền trả các loại phí, lệ phí cho nước ngoài"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_3
  Scenario: KH tạo giao dịch CTNT với mục đích: Trợ cấp cho thân nhân ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là Trợ cấp cho thân nhân ở nước ngoài
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_4
  Scenario: KH tạo giao dịch CTNT với mục đích: Đặt cọc tiền khám chữa bệnh ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Đặt cọc tiền khám chữa bệnh ở nước ngoài"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    And Xác nhận giao dịch
    And Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_5
  Scenario: KH tạo giao dịch CTNT với mục đích: Viện phí khám chữa bệnh ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Viện phí khám chữa bệnh ở nước ngoài"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_6
  Scenario: KH tạo giao dịch CTNT với mục đích: Sinh hoạt phí khám chữa bệnh ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Sinh hoạt phí khám chữa bệnh ở nước ngoài"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_7
  Scenario: KH tạo giao dịch CTNT với mục đích: Sinh hoạt phí khám chữa bệnh ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Đặt cọc du học"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    And Xác nhận giao dịch
    And Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_8
  Scenario: KH tạo giao dịch CTNT với mục đích: Sinh hoạt phí khám chữa bệnh ở nước ngoài
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Học phí du học"
    And Chon người nhận với nội dung "Test"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ

  @test_case_11
  Scenario Outline: KH tạo giao dịch CTNT với mục đích:bất kỳ, nhưng chọn mã SWIFT ngân hàng nhận, loại tiền JPY
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn mục đích chuyển tiền là "Học phí du học"
    And Điền thông tin người nhận
    And Điền thông tin ngân hàng nhận "<SWIFT>"
    And Nhập số ngoại tệ cần chuyển đi là "1"
    And Chọn hồ sơ cung cấp
    Then Xác nhận giao dịch
    Then Kiểm tra lịch sử chuyển tiền ngoại tệ
    Examples:
      | SWIFT       |
#      | JPPSJPJT    |
      | JPPSJPJ1    |
      | JPPSJPJK    |
      | JPPSJPJJIRS |
      | SVVNJPJJ    |

  @test_case_13
  Scenario: KH tạo giao dịch tra soát trên ipay với trạng thái thành công
    And Di chuyển vào Chuyển tiền
    And Chọn Mua Chuyển ngoại tệ
    And Chọn xem lịch sử
    And Chọn giao dịch thành công
    And Tạo điện tra soát
