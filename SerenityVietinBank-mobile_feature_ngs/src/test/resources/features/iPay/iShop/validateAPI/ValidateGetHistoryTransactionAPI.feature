@ValidateGetHistoryTransactionAPI
Feature: Validate Get History Transaction API

  @TC001
  Scenario Outline: Validate Get History TransactionAPI: <testCase>
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getHistoryTransaction.json"
    And cập nhật lại json "BODY_REQUEST"
      | <field> |
      | <value> |
    And gọi api "iShop.report.getHistoryTransaction" với phương thức "POST"
    Then response có trường errorCode "<errorCode>" và errorMessage "<errorMessage>"

    Examples:
      | testCase                | field     | value            | errorCode | errorMessage                                        |
      | RequestId_null          | requestId | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | RequestId_blank         | requestId | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | RequestId_remove        | requestId | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | SessionId_null          | sessionId | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | SessionId_blank         | sessionId | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | SessionId_overMaxLength | sessionId | RANDOM_STRING_33 | 70        | Phiên đăng nhập đã hết hiệu lực                     |
      | SessionId_remove        | sessionId | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | SessionId_wrong         | sessionId | 0000000000       | 70        | Phiên đăng nhập đã hết hiệu lực                     |
      | FromDate_null           | fromDate  | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | FromDate_blank          | fromDate  | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | FromDate_overMaxLength  | fromDate  | RANDOM_STRING_51 | 91        | AMT08: Allow for query date between T and T-3       |
      | FromDate_remove         | fromDate  | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | FromDate_wrong          | fromDate  | 0000000000       | 91        | AMT08: Allow for query date between T and T-3       |
      | ToDate_null             | toDate    | NULL             | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | ToDate_blank            | toDate    | BLANK            | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | ToDate_overMaxLength    | toDate    | RANDOM_STRING_51 | 91        | AMT07: End date must have great value than fromDate |
      | ToDate_remove           | toDate    | REMOVE           | 90        | Dữ liệu không hợp lệ. Xin vui lòng thử lại.         |
      | ToDate_wrong            | toDate    | 0000000000       | 91        | AMT07: End date must have great value than fromDate |
      | AccountNo_overMaxLength | accountNo | RANDOM_STRING_51 | 91        | Invalid history sales info inq Object               |
      | TseqStart_overMaxLength | tseqStart | RANDOM_STRING_11 | 500       | Internal Server Error                               |
      | TseqEnd_overMaxLength   | tseqEnd   | RANDOM_STRING_11 | 500       | Internal Server Error                               |
