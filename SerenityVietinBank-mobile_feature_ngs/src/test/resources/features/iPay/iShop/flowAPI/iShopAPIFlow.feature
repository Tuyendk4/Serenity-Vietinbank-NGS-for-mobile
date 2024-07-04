@iShopAPI
Feature: Flow iShop API

  @iShopAPIFlow01
  Scenario Outline: Mo shop moi va thuc hien dong shop
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction   | provinceCode | districtCode |
      | requestIdResLogin | sessionIdResLogin | listProvince | REMOVE       | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "provinceIdRes" có tên "<province>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode |
      | requestIdResLogin | sessionIdResLogin | listDist   | provinceIdRes | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "districtIdRes" có tên "<district>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode  |
      | requestIdResLogin | sessionIdResLogin | listWard   | provinceIdRes | districtIdRes |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "wardIdRes" có tên "<ward>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getIndustries.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iShop.shop.getIndustries" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "industryIdRes" có tên "<industry>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | districtInfo      | provinceInfo      | areaInfo      | businessId    | shopName        | alias           | fromAccount      |
      | requestIdResLogin | sessionIdResLogin | districtIdResINFO | provinceIdResINFO | wardIdResINFO | industryIdRes | RANDOM_STRING_8 | RANDOM_STRING_8 | accountNumberRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "authenticationActionCode" từ "RESPONSE" với danh sách sessionVariableName "authenticationActionCodeRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/confirmRegisterShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | authenticationActionCode    |
      | requestIdResLogin | sessionIdResLogin | authenticationActionCodeRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "shopId, virtualAccount" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes, virtualAccountRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateStatusShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | status | accountNo        |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | C      | accountNumberRes |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"

    Examples:
      | user          | province | district    | ward            | industry |
      | nguyenvth1987 | Hà Nội   | QUẬN TÂY HỒ | PHƯỜNG QUẢNG AN | Digital  |

  @iShopAPIFlow02
  Scenario Outline: Cap nhat thong tin va trang thai cua shop
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/myShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | accountNo        | status |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes | A      |
    And gọi api "iShop.shop.myShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "data[0].id, data[0].shopColor" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes, shopColorRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateStatusShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | status | accountNo        |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | C      | accountNumberRes |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"
    * lưu giá trị của các jsonPath "data.logo" từ "RESPONSE" với danh sách sessionVariableName "logoRes"
    Then kiểm tra trạng thái cửa hàng "C"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateStatusShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | status | accountNo        |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | C      | accountNumberRes |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateInfoShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | cateId | logo    | provinceInfo | districtInfo     | areaInfo              | address         | shopName         |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | <cate> | logoRes | 1###Hà Nội   | 10###QUẬN TÂY HỒ | 218###PHƯỜNG QUẢNG AN | So 1 Hung Vuong | RANDOMG_STRING_7 |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"

    Examples:
      | user          | cate |
      | nguyenvth1987 | 3    |

  @iShopAPIFlow03
  Scenario Outline: Chia se shop cho user khac
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/myShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | accountNo        | status |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes | A      |
    And gọi api "iShop.shop.myShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "data[0].id, data[0].shopColor" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes, shopColorRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/shareShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | acctNo           | sharedInfo[0].sharedCif | sharedInfo[0].shareRoleId | sharedInfo[0].sharedVirtualAcc | sharedInfo[0].sharedPhoneNo |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | accountNumberRes | <sharedCif>             | <shareRole>               | ???                            | <sharedMobile>              |
    And gọi api "iShop.shareShop.shareShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "authenticationActionCode" từ "RESPONSE" với danh sách sessionVariableName "authenticationActionCodeRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/confirmShareShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | authenticationActionCode    |
      | requestIdResLogin | sessionIdResLogin | authenticationActionCodeRes |
    And gọi api "iShop.shareShop.shareShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "statusLst[0].shareId" từ "RESPONSE" với danh sách sessionVariableName "shareIdRes"
#  .mergeJson("sharedInfo[0].sharedVirtualAcc", iShopInfo.getVirtualAcct())
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName     | accessCode |
      | TIMESTAMP_LOCAL_NOW | <sharedUser> | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getSharedShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId | acctNo | shareRoleId | sharedVirtualAcc |
      | requestIdResLogin | sessionIdResLogin |        |        |             |                  |
    And gọi api "iShop.shareShop.getSharedShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "sharedShopLst[0].shopId, sharedShopLst[0].shareId, sharedShopLst[0].roleId" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes, shareIdRes, roleIdRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateSharedShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | shareStatus | shareId    | shareRoleId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | A           | shareIdRes | shareRoleIdRes |
    And gọi api "iShop.shareShop.updateSharedShop" với phương thức "POST"
    Then response có trường errorCode "false" và errorMessage "SUCCESS"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getSharedShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId | acctNo | shareRoleId | sharedVirtualAcc |
      | requestIdResLogin | sessionIdResLogin |        |        |             |                  |
    And gọi api "iShop.shareShop.getSharedShop" với phương thức "POST"
    Then kiểm tra trạng thái cửa hàng "A"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateSharedShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | shareStatus | shareId    | shareRoleId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | S           | shareIdRes | shareRoleIdRes |
    And gọi api "iShop.shareShop.updateSharedShop" với phương thức "POST"
    Then response có trường errorCode "false" và errorMessage "SUCCESS"
    Examples:
      | user          | sharedUser | sharedCif | shareRole | sharedMobile |
      | nguyenvth1987 | 0981109042 | 100000011 | S03       | 0981109042   |
      | nguyenvth1987 | 0981109042 | 100000011 | S02       | 0981109042   |

  @iShopAPIFlow04
  Scenario Outline: Mo shop bi trung ten
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction   | provinceCode | districtCode |
      | requestIdResLogin | sessionIdResLogin | listProvince | REMOVE       | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "provinceIdRes" có tên "<province>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode |
      | requestIdResLogin | sessionIdResLogin | listDist   | provinceIdRes | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "districtIdRes" có tên "<district>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode  |
      | requestIdResLogin | sessionIdResLogin | listWard   | provinceIdRes | districtIdRes |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "wardIdRes" có tên "<ward>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getIndustries.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iShop.shop.getIndustries" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "industryIdRes" có tên "<industry>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | districtInfo      | provinceInfo      | areaInfo      | businessId    | shopName        | alias           | fromAccount      |
      | requestIdResLogin | sessionIdResLogin | districtIdResINFO | provinceIdResINFO | wardIdResINFO | industryIdRes | RANDOM_STRING_8 | RANDOM_STRING_8 | accountNumberRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "industryIdRes" có tên "<industry>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | districtInfo      | provinceInfo      | areaInfo      | businessId    | shopName | alias           | fromAccount      |
      | requestIdResLogin | sessionIdResLogin | districtIdResINFO | provinceIdResINFO | wardIdResINFO | industryIdRes | <name>   | RANDOM_STRING_8 | accountNumberRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    Then response có trường errorCode "99" và errorMessage "Tên cửa hàng đã tồn tại. Quý khách vui lòng nhập tên khác"

    Examples:
      | user          | province  | district     | ward               | industry | name        |
      | nguyenvth1987 | TP HA NOI | Quan Dong Da | Phuong Thinh Quang | Digital  | autoShopcLh |


  @iShopAPIFlow05
  Scenario Outline: Mở shop khi đã đạt tối đa số cửa hàng
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction   | provinceCode | districtCode |
      | requestIdResLogin | sessionIdResLogin | listProvince | REMOVE       | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "provinceIdRes" có tên "<province>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode |
      | requestIdResLogin | sessionIdResLogin | listDist   | provinceIdRes | REMOVE       |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "districtIdRes" có tên "<district>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getAreas.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | formAction | provinceCode  | districtCode  |
      | requestIdResLogin | sessionIdResLogin | listWard   | provinceIdRes | districtIdRes |
    And gọi api "iShop.shop.getAreas" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "wardIdRes" có tên "<ward>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getIndustries.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iShop.shop.getIndustries" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "industryIdRes" có tên "<industry>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | districtInfo      | provinceInfo      | areaInfo      | businessId    | shopName        | alias           | fromAccount      |
      | requestIdResLogin | sessionIdResLogin | districtIdResINFO | provinceIdResINFO | wardIdResINFO | industryIdRes | RANDOM_STRING_8 | RANDOM_STRING_8 | accountNumberRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    And lấy từ "RESPONSE" và lưu "industryIdRes" có tên "<industry>" thành biến Serenity Session Variable
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/registerShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | districtInfo      | provinceInfo      | areaInfo      | businessId    | shopName | alias           | fromAccount      |
      | requestIdResLogin | sessionIdResLogin | districtIdResINFO | provinceIdResINFO | wardIdResINFO | industryIdRes | <name>   | RANDOM_STRING_8 | accountNumberRes |
    And gọi api "iShop.shop.registerShop" với phương thức "POST"
    Then response có trường errorCode "99" và errorMessage "Quý khách chỉ được đăng ký tối đa 10 cửa hàng đang hoạt động. Vui lòng kiểm tra lại."

    Examples:
      | user  | province  | district     | ward               | industry | account | name        |
      | le.dq | TP HA NOI | Quan Dong Da | Phuong Thinh Quang | Digital  | DEFAULT | autoShopcLh |

  @iShopAPIFlow06
  Scenario Outline: Đóng cửa hàng khi đã đạt tối đa shop bị đóng
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/myShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | accountNo        | status |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes | A      |
    And gọi api "iShop.shop.myShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "data[0].id, data[0].shopColor" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes, shopColorRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/updateStatusShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    | status |
      | requestIdResLogin | sessionIdResLogin | shopIdRes | C      |
    And gọi api "iShop.shop.updateShop" với phương thức "POST"
    Then response có trường errorCode "99" và errorMessage "Quý khách không th? ?óng quá 20 c?a hàng. Vui lòng ki?m tra l?i."

    Examples:
      | user  |
      | le.dq |

  @iShopAPIFlow07
  Scenario Outline: Lấy doanh thu của shop đang hoạt động
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/myShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | accountNo        | status |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes | A      |
    And gọi api "iShop.shop.myShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "data[0].shopId" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"

    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getIncome.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | listAcct[0].accountNbr | listAcct[0].virtualAccountVar |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes       | ???                           |
    And gọi api "iShop.report.getIncome" với phương thức "POST"
    Then response có trường errorCode "false" và errorMessage "SUCCESS"

    Examples:
      | user          |
      | nguyenvth1987 |

  @iShopAPIFlow08
  Scenario Outline: Lấy doanh thu của shop đã đóng
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/myShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | accountNo        | status |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes | C      |
    And gọi api "iShop.shop.myShop" với phương thức "POST"
    * lưu giá trị của các jsonPath "data[0].shopId" từ "RESPONSE" với danh sách sessionVariableName "shopIdRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getShopDetails.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId    |
      | requestIdResLogin | sessionIdResLogin | shopIdRes |
    And gọi api "iShop.shop.getShopDetails" với phương thức "POST"

    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getIncome.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | listAcct[0].accountNbr | listAcct[0].virtualAccountVar |
      | requestIdResLogin | sessionIdResLogin | accountNumberRes       | ???                           |
    And gọi api "iShop.report.getIncome" với phương thức "POST"
    Then response có trường errorCode "false" và errorMessage "SUCCESS"

    Examples:
      | user          |
      | nguyenvth1987 |

  @iShopAPIFlow09
  Scenario Outline: Cập nhật thông tin shop được chia sẻ
    Given tạo headers request mặc định
    When lấy "BODY_REQUEST" từ file json "iPay/login/loginRequest.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId           | userName | accessCode |
      | TIMESTAMP_LOCAL_NOW | <user>   | 12121212   |
    And gọi api "iPay.ma.signIn" với phương thức "POST"
    * lưu giá trị của các jsonPath "requestId, sessionId" từ "RESPONSE" với danh sách sessionVariableName "requestIdResLogin, sessionIdResLogin"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getDdaAccount.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         |
      | requestIdResLogin | sessionIdResLogin |
    And gọi api "iPay.ma.getDdaAccounts" với phương thức "POST"
    * lưu giá trị của các jsonPath "accounts[0].number" từ "RESPONSE" với danh sách sessionVariableName "accountNumberRes"
    When lấy "BODY_REQUEST" từ file json "iPay/iShop/getSharedShop.json"
    And cập nhật lại json "BODY_REQUEST"
      | requestId         | sessionId         | shopId | acctNo | shareRoleId | sharedVirtualAcc |
      | requestIdResLogin | sessionIdResLogin |        |        |             |                  |
    And gọi api "iShop.shareShop.getSharedShop" với phương thức "POST"

    Examples:
      | user       |
      | 0981109042 |