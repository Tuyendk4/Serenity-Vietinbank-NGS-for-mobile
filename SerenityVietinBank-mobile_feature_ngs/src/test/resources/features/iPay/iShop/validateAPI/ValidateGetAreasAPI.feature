@ValidateGetAreasAPI
Feature: Validate Get Areas API

  @TC001
  Scenario Outline: Validate Get Areas API 1: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName      | accessCode |
      | TIMESTAMP_LOCAL_NOW | nguyenvth1987 | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "sessionId, requestId" từ "RESPONSE" với danh sách sessionVariableName "sessionIdResLogin, requestIdResLogin"
    And lấy "RESPONSE_EXPECTED" từ file json "iPay/login/loginResponse.json"
    And so sánh trường có jsonPath "error" của response thực tế với mong muốn
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field1> | <field2> |
      | <value1> | <value2> |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field1    | value1           | field2    | value2            | errorCode | errorMessage                                |
      | RequestId_null          | requestId | NULL             | sessionId | sessionIdResLogin | false     | SUCCESS                                     |
      | RequestId_blank         | requestId | BLANK            | sessionId | sessionIdResLogin | false     | SUCCESS                                     |
      | RequestId_remove        | requestId | REMOVE           | sessionId | sessionIdResLogin | false     | SUCCESS                                     |
      | SessionId_null          | sessionId | NULL             | requestId | requestIdResLogin | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_blank         | sessionId | BLANK            | requestId | requestIdResLogin | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_overMaxLength | sessionId | RANDOM_STRING_33 | requestId | requestIdResLogin | 70        | Phiên đăng nhập đã hết hiệu lực             |
      | SessionId_remove        | sessionId | REMOVE           | requestId | requestIdResLogin | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại. |
      | SessionId_wrong         | sessionId | 0000000000       | requestId | requestIdResLogin | 70        | Phiên đăng nhập đã hết hiệu lực             |

  @TC002
  Scenario Outline: Validate Get Areas API 2: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName      | accessCode |
      | TIMESTAMP_LOCAL_NOW | nguyenvth1987 | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "sessionId, requestId" từ "RESPONSE" với danh sách sessionVariableName "sessionIdResLogin, requestIdResLogin"
    And lấy "RESPONSE_EXPECTED" từ file json "iPay/login/loginResponse.json"
    And so sánh trường có jsonPath "error" của response thực tế với mong muốn
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> | requestId         | sessionId         |
      | <value> | requestIdResLogin | sessionIdResLogin |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                   | field        | value             | errorCode | errorMessage |
      | ProvinceCode_overMaxLength | provinceCode | RANDOM_STRING_6   | false     | SUCCESS      |
      | DistrictCode_overMaxLength | districtCode | RANDOM_STRING_6   | false     | SUCCESS      |
      | FormAction_overMaxLength   | formAction   | RANDOM_STRING_101 | false     | SUCCESS      |

  @TC003
  Scenario Outline: Validate Get Areas API 3: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName      | accessCode |
      | TIMESTAMP_LOCAL_NOW | nguyenvth1987 | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    And lấy "RESPONSE_EXPECTED" từ file json "iPay/login/loginResponse.json"
    And so sánh trường có jsonPath "error" của response thực tế với mong muốn
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field1> | <field2> | <field3> |
      | <value1> | <value2> | <value3> |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase               | field1     | value1   | field2       | value2 | field3       | value3 | errorCode | errorMessage |
      | FromAction_is_listDist | formAction | listDist | provinceCode | REMOVE | districtCode | REMOVE | false     | SUCCESS      |