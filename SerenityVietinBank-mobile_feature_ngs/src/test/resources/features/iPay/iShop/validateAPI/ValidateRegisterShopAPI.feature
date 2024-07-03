@ValidateRegisterShopAPI
Feature: Validate Register Shop API

  @TC001
  Scenario Outline: Validate Register Shop API 1: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase     | errorCode | errorMessage |
      | Call success | 200       | SUCCESS      |

  @TC002
  Scenario Outline: Validate Register Shop API 2: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                  | field       | value             | errorCode | errorMessage                                          |
      | RequestId_null            | requestId   | NULL              | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | RequestId_blank           | requestId   | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | RequestId_remove          | requestId   | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | SessionId_null            | sessionId   | NULL              | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | SessionId_blank           | sessionId   | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | SessionId_overMaxLength   | sessionId   | RANDOM_STRING_33  | 70        | Phiên đăng nhập đã hết hiệu lực                       |
      | SessionId_remove          | sessionId   | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | SessionId_wrong           | sessionId   | 0000000000        | 70        | Phiên đăng nhập đã hết hiệu lực                       |
      | ShopName_null             | shopName    | NULL              | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | ShopName_blank            | shopName    | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | ShopName_remove           | shopName    | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.           |
      | FromAccount_null          | fromAccount | NULL              | 04        | Thông tin quý khách nhập chưa đúng. Vui lòng thử lại. |
      | FromAccount_blank         | fromAccount | BLANK             | 04        | Thông tin quý khách nhập chưa đúng. Vui lòng thử lại. |
      | FromAccount_overMaxLength | fromAccount | RANDOM_STRING_101 | 04        | Thông tin quý khách nhập chưa đúng. Vui lòng thử lại. |
      | FromAccount_remove        | fromAccount | REMOVE            | 04        | Thông tin quý khách nhập chưa đúng. Vui lòng thử lại. |
      | FromAccount_wrong         | fromAccount | 0000000000        | 04        | Thông tin quý khách nhập chưa đúng. Vui lòng thử lại. |
      | Alias_null                | alias       | NULL              | 500       | Internal Server Error                                 |
      | Alias_blank               | alias       | BLANK             | 04        | Alias cửa hàng tối đa 8 kí tự.                        |
      | Alias_overMaxLength       | alias       | RANDOM_STRING_10  | 04        | Alias cửa hàng tối đa 8 kí tự.                        |
      | Alias_remove              | alias       | REMOVE            | 500       | Internal Server Error                                 |