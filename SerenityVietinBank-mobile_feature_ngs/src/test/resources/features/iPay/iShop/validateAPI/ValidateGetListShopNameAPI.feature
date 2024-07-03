@ValidateGetListShopNameAPI
Feature: Validate Get List Shop Name API

  @TC001
  Scenario Outline: Validate Get List Shop Name API: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getListShopName.json"
    And gọi api "iShop.shop.getListShopName" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase     | errorCode | errorMessage |
      | Call success | 200       | SUCCESS      |

  @TC002
  Scenario Outline: Validate Get List Shop Name API: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getListShopName.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shop.getListShopName" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field     | value            | errorCode | errorMessage                                |
      | RequestId_null          | requestId | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RequestId_blank         | requestId | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RequestId_remove        | requestId | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_null          | sessionId | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_blank         | sessionId | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_overMaxLength | sessionId | RANDOM_STRING_33 | 70        | Phiên đăng nhập đã hết hiệu lực             |
      | SessionId_remove        | sessionId | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_wrong         | sessionId | 0000000000       | 70        | Phiên đăng nhập đã hết hiệu lực             |
