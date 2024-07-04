@ValidateShareShopAPI
Feature: Validate Share Shop API

  @TC001
  Scenario Outline: Validate Share Shop API 1: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/shareShop.json"
    And gọi api "iShop.shareShop.shareShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase     | errorCode | errorMessage |
      | Call success | 200       | SUCCESS      |

  @TC002
  Scenario Outline: Validate Share Shop API 2: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/shareShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.shareShop.shareShop" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                       | field                          | value             | errorCode | errorMessage                                                           |
      | RequestId_blank                | requestId                      | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | RequestId_remove               | requestId                      | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_null                 | sessionId                      | NULL              | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_blank                | sessionId                      | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_overMaxLength        | sessionId                      | RANDOM_STRING_33  | 70        | Phiên đăng nhập đã hết hiệu lực                                        |
      | SessionId_remove               | sessionId                      | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | SessionId_wrong                | sessionId                      | 0000000000        | 70        | Phiên đăng nhập đã hết hiệu lực                                        |
      | FormAction_null                | formAction                     | NULL              | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | FormAction_blank               | formAction                     | BLANK             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | FormAction_remove              | formAction                     | REMOVE            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.                            |
      | ShopId_null                    | shopId                         | NULL              | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | ShopId_blank                   | shopId                         | BLANK             | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | ShopId_overMaxLength           | shopId                         | RANDOM_STRING_21  | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | ShopId_remove                  | shopId                         | REMOVE            | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | ShopId_wrong                   | shopId                         | 0000000000        | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | AcctNo_null                    | acctNo                         | NULL              | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | AcctNo_blank                   | acctNo                         | BLANK             | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | AcctNo_overMaxLength           | acctNo                         | RANDOM_STRING_21  | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | AcctNo_remove                  | acctNo                         | REMOVE            | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | AcctNo_wrong                   | acctNo                         | 0000000000        | 01        | Cửa hàng Qúy khách lựa chọn không hợp lệ. Vui lòng chọn cửa hàng khác. |
      | SharedInfo_null                | sharedInfo                     | NULL              | 500       | Internal Server Error                                                  |
      | SharedInfo_blank               | sharedInfo                     | []                | 400       | Bad Request                                                            |
      | SharedInfo_notList             | sharedInfo                     | BLANK             | 400       | Bad Request                                                            |
      | SharedInfo_remove              | sharedInfo                     | REMOVE            | 500       | Internal Server Error                                                  |
      | SharedCif_null                 | sharedInfo[0].sharedCif        | NULL              | 500       | Internal Server Error                                                  |
      | SharedCif_blank                | sharedInfo[0].sharedCif        | BLANK             | 400       | Bad Request                                                            |
      | SharedCif_overMaxLength        | sharedInfo[0].sharedCif        | RANDOM_STRING_51  | 400       | Bad Request                                                            |
      | SharedCif_remove               | sharedInfo[0].sharedCif        | REMOVE            | 500       | Internal Server Error                                                  |
      | SharedCif_wrong                | sharedInfo[0].sharedCif        | 0000000000        | 400       | Bad Request                                                            |
      | ShareRoleId_null               | sharedInfo[0].shareRoleId      | NULL              | 500       | Internal Server Error                                                  |
      | ShareRoleId_blank              | sharedInfo[0].shareRoleId      | BLANK             | 400       | Bad Request                                                            |
      | ShareRoleId_overMaxLength      | sharedInfo[0].shareRoleId      | RANDOM_STRING_51  | 400       | Bad Request                                                            |
      | ShareRoleId_remove             | sharedInfo[0].shareRoleId      | REMOVE            | 500       | Internal Server Error                                                  |
      | ShareRoleId_wrong              | sharedInfo[0].shareRoleId      | 0000000000        | 400       | Bad Request                                                            |
      | SharedCusName_null             | sharedInfo[0].sharedCusName    | NULL              | 500       | Internal Server Error                                                  |
      | SharedCusName_blank            | sharedInfo[0].sharedCusName    | BLANK             | 400       | Bad Request                                                            |
      | SharedCusName_overMaxLength    | sharedInfo[0].sharedCusName    | RANDOM_STRING_401 | 400       | Bad Request                                                            |
      | SharedCusName_remove           | sharedInfo[0].sharedCusName    | REMOVE            | 500       | Internal Server Error                                                  |
      | SharedCusName_wrong            | sharedInfo[0].sharedCusName    | 0000000000        | 400       | Bad Request                                                            |
      | SharedInfo_null                | sharedInfo[0].sharedPhoneNo    | NULL              | 500       | Internal Server Error                                                  |
      | SharedInfo_blank               | sharedInfo[0].sharedPhoneNo    | BLANK             | 400       | Bad Request                                                            |
      | SharedInfo_overMaxLength       | sharedInfo[0].sharedPhoneNo    | RANDOM_STRING_401 | 400       | Bad Request                                                            |
      | SharedInfo_remove              | sharedInfo[0].sharedPhoneNo    | REMOVE            | 500       | Internal Server Error                                                  |
      | SharedInfo_wrong               | sharedInfo[0].sharedPhoneNo    | 0000000000        | 400       | Bad Request                                                            |
      | SharedVirtualAcc_null          | sharedInfo[0].sharedVirtualAcc | NULL              | 500       | Internal Server Error                                                  |
      | SharedVirtualAcc_blank         | sharedInfo[0].sharedVirtualAcc | BLANK             | 400       | Bad Request                                                            |
      | SharedVirtualAcc_overMaxLength | sharedInfo[0].sharedVirtualAcc | RANDOM_STRING_401 | 400       | Bad Request                                                            |
      | SharedVirtualAcc_remove        | sharedInfo[0].sharedVirtualAcc | REMOVE            | 500       | Internal Server Error                                                  |
      | SharedVirtualAcc_wrong         | sharedInfo[0].sharedVirtualAcc | 0000000000        | 400       | Bad Request                                                            |