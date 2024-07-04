@ValidateUpdateShopAPI
Feature: Validate Update Shop API

  @TC001
  Scenario Outline: Validate Update Shop API 1: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field        | value            | errorCode | errorMessage                                                           |
      | RequestId_null          | requestId    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | RequestId_blank         | requestId    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | RequestId_remove        | requestId    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_null          | sessionId    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_blank         | sessionId    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_overMaxLength | sessionId    | RANDOM_STRING_33 | 70        | Phiên đăng nhập đã hết hiệu lực                                        |
      | SessionId_remove        | sessionId    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_wrong         | sessionId    | 0000000000       | 70        | Phiên đăng nhập đã hết hiệu lực                                        |
      | ShopId_null             | shopId       | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ShopId_blank            | shopId       | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ShopId_overMaxLength    | shopId       | RANDOM_STRING_11 | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | ShopId_remove           | shopId       | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ShopId_wrong            | shopId       | ab               | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | FormAction_null         | formAction   | NULL             | 500       | Internal Server Error                                                  |
      | CateId_null             | cateId       | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | CateId_blank            | cateId       | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | CateId_overMaxLength    | cateId       | RANDOM_STRING_6  | 500       | Internal Server Error                                                  |
      | CateId_remove           | cateId       | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | CateId_wrong            | cateId       | 0000000000       | 500       | Internal Server Error                                                  |
      | Address_null            | address      | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | Address_blank           | address      | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | Address_remove          | address      | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ProvinceInfo_null       | provinceInfo | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ProvinceInfo_blank      | provinceInfo | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ProvinceInfo_remove     | provinceInfo | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | DistrictInfo_null       | districtInfo | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | DistrictInfo_blank      | districtInfo | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | DistrictInfo_remove     | districtInfo | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | AreaInfo_null           | areaInfo     | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | AreaInfo_blank          | areaInfo     | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | AreaInfo_remove         | areaInfo     | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |

  @TC002
  Scenario Outline: Validate Update Shop API 2: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | formAction       | <field> |
      | changeStatusShop | <value> |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field     | value            | errorCode | errorMessage                                |
      | Status_null             | status    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | Status_blank            | status    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | Status_overMaxLength    | status    | RANDOM_STRING_11 | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | Status_remove           | status    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | Status_wrong            | status    | ab               | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | AccountNo_null          | accountNo | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | AccountNo_blank         | accountNo | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | AccountNo_overMaxLength | accountNo | RANDOM_STRING_33 | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | AccountNo_remove        | accountNo | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | AccountNo_wrong         | accountNo | ab               | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |