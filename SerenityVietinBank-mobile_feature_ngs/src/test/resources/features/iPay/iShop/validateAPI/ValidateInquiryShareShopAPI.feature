@ValidateInquiryShareShopAPI
Feature: Validate Inquiry Share Shop API

  Scenario Outline: Validate Inquiry Share Shop API: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/inquiryShareShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shareShop.shareShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field      | value            | errorCode | errorMessage                                |
      | RequestId_null          | requestId  | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RequestId_blank         | requestId  | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RequestId_remove        | requestId  | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_null          | sessionId  | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_blank         | sessionId  | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_overMaxLength | sessionId  | RANDOM_STRING_33 | 70        | Phiên đăng nhập đã hết hiệu lực             |
      | SessionId_remove        | sessionId  | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_wrong         | sessionId  | 0000000000       | 70        | Phiên đăng nhập đã hết hiệu lực             |
      | FormAction_null         | formAction | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | FormAction_blank        | formAction | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | FormAction_remove       | formAction | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
