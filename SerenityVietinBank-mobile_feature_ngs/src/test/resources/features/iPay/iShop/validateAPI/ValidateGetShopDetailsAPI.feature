@ValidateGetShopDetailsAPI
Feature: Validate Get Shop Details API

  @TC001
  Scenario Outline: Validate Get Shop Details API: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"
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
      | ShopId_null             | shopId    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | ShopId_blank            | shopId    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | ShopId_overMaxLength    | shopId    | RANDOM_STRING_31 | 99        | is Empty.                                   |
      | ShopId_remove           | shopId    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | ShopId_wrong            | shopId    | 0000000000       | 99        | is Empty.                                   |
      | RoleId_null             | roleId    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RoleId_blank            | roleId    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RoleId_overMaxLength    | roleId    | RANDOM_STRING_11 | 99        | is Empty.                                   |
      | RoleId_remove           | roleId    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | RoleId_wrong            | roleId    | 0000000000       | 99        | is Empty.                                   |
