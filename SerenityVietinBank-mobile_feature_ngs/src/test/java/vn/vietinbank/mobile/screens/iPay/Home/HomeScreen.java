package vn.vietinbank.mobile.screens.iPay.Home;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.common.ScrollDirection;
import vn.vietinbank.mobile.screens.iPay.Accounts.ListAccountsScreen;
import vn.vietinbank.mobile.screens.iPay.Loan.popups.common.AdvertisingPopup;
import vn.vietinbank.mobile.screens.iPay.Loan.popups.common.FavoriteServices;
import vn.vietinbank.mobile.screens.iPay.Loan.popups.common.NavigationBar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomeScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
    @AndroidFindBy(xpath = "")
    private WebElement iconClose;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconHomeSearch\"]")
    @AndroidFindBy(xpath = "")
    private WebElement iconSearchFeature;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]")
    @AndroidFindBy(xpath = "")
    private WebElement loginBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Qr Shop\" AND label == \"Qr Shop\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "")
    private WebElement qrShopBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Dịch vụ iShop hộ kinh doanh\"")
    @AndroidFindBy(xpath = "")
    private WebElement dichVuIShopHoKinhDoanhTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Danh sách tài khoản\"]//parent::XCUIElementTypeOther/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Danh sách tài khoản\"]")
    private WebElement listAccountsTxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Danh sách thẻ\"]//parent::XCUIElementTypeOther/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "")
    private WebElement listCardsTxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Toàn bộ ưu đãi\"]")
    @AndroidFindBy(xpath = "")
    private WebElement allOffersTxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "")
    private WebElement homeTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "")
    private WebElement notificationTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]")
    @AndroidFindBy(xpath = "")
    private WebElement storeTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]")
    @AndroidFindBy(xpath = "")
    private WebElement investmentTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]")
    @AndroidFindBy(xpath = "")
    private WebElement userProfileTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tất cả dịch vụ\"]")
    @AndroidFindBy(xpath = "")
    private WebElement allServicesTxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển & nhận tiền\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement transferAndReceiveMoney;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thanh toán hoá đơn\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement payBills;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quét mã QR\" or @name=\"Thanh toán QRPay\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement scanQR;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement loanAndCreditServices;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ tiết kiệm\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement savingsService;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nạp tiền điện thoại\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement phoneRecharge;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua data 3G/4G\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement buyTelecommunicationData;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua gói cước Vinaphone\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement buyVinaphonePackage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua mã thẻ\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement buyMobilePhoneRechargeCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt chỗ tiêm vaccine\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement bookVaccinations;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua bảo hiểm\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement buyInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bác sĩ gia đình\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement familyDoctor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền liên ngân hàng\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement interbankMoneyTransfer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement personalSpendBorrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mở tài khoản số đẹp\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement openLuckyAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền trong VietinBank\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement insideMoneyTransfer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mở thẻ mới\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement openNewCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Gửi tiết kiệm có kỳ hạn\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement termSavingsDeposit;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VNPAY Taxi\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement VNPAYTaxi;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mã QR của tôi\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement myQRCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt vé máy bay\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement ticketPlaneBooking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mã giảm giá QRPay\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement QRPAYDiscountCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đổi điểm thưởng Loyalty\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement loyaltyRedeem;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Ưu đãi & khuyến mại\"]/parent::XCUIElementTypeOther)[2]")
    @AndroidFindBy(xpath = "")
    private WebElement offersAndPromotions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua vé xem phim\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement cinemaTicket;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt chỗ sân Golf\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement golfCourseReservations;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua eVoucher\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement eVoucher;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mua sắm VnShop\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement VnShop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tặng hoa tươi\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement giveFreshFlowers;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt vé bóng đá,  sự kiện, vui chơi\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement eventTickets;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Hotline hỗ trợ khách hàng\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement customerSupportHotline;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chat với Vietinbank\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement chatWithVietinbank;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tra soát giao dịch thẻ tín dụng/ghi nợ\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement checkCardTransactions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tra soát giao dịch tài khoản\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement checkAccountTransactions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mạng lưới CN/PGD/ATM\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement networkBranchOfficeATM;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Địa điểm quanh đây\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement locationsAroundHere;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Giới thiệu iPay Mobile nhận quà\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement introducingIPayMobileToReceiveGifts;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Xem câu hỏi thường gặp\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement seeTheFrequentlyAskedQuestions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cảnh báo & Khuyến nghị\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement warningsAndRecommendations;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt vé tàu\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement ticketTrainBooking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt vé xe\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement ticketCarBooking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Giao hàng\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement shipping;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Đặt phòng khách sạn\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement bookingHotel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Bạn đang muốn tìm gì?\"]")
    @AndroidFindBy(xpath = "")
    private WebElement searchInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText/parent::XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement searchFeatureResult;

    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public void closeAdsPopup() {
        if (waitForElementVisible(iconClose, 1)) {
            iconClose.click();
        }
    }

    public void clickIconSearchFeature() {
        click(iconSearchFeature);
    }

    public void clickQrShopButton(String text) {
        String element = "//XCUIElementTypeStaticText[@name=\"%s\"]/preceding-sibling::XCUIElementTypeButton";
        click(getDynamicXpath(element, text));
        click(getDynamicXpath(element, text));
    }

    public void verifyIPayServiceForBusinessHouseholdsAreDisplayed() {
        assertThat("Dịch vụ iShop hộ kinh doanh không hiển thị", dichVuIShopHoKinhDoanhTab.isDisplayed(), is(true));
    }

    public void clickListAccountsTxt() {
        click(listAccountsTxt);
    }

    public void clickListCardsTxt() {
        click(listCardsTxt);
    }

    public void clickAllOffersTxt() {
        click(allOffersTxt);
    }

    public void clickHomeTab() {
        click(homeTab);
    }

    public void clickNotificationTab() {
        click(notificationTab);
    }

    public void clickStoreTab() {
        click(storeTab);
    }

    public void clickInvestmentTab() {
        click(investmentTab);
    }

    public void clickUserProfileTab() {
        click(userProfileTab);
    }

    public void clickAllServicesTxt() {
        click(allServicesTxt);
    }

    public void clickTransferAndReceiveMoney() {
        click(transferAndReceiveMoney);
    }

    public void clickPayBills() {
        click(payBills);
    }

    public void clickScanQR() {
        click(scanQR);
    }

    public void clickLoanAndCreditServices() {
        click(loanAndCreditServices);
    }

    public void clickSavingsService() {
        click(savingsService);
    }

    public void clickPhoneRecharge() {
        click(phoneRecharge);
    }

    public void clickBuyTelecommunicationData() {
        click(buyTelecommunicationData);
    }

    public void clickBuyVinaphonePackage() {
        click(buyVinaphonePackage);
    }

    public void clickBuyMobilePhoneRechargeCode() {
        click(buyMobilePhoneRechargeCode);
    }

    public void clickBookVaccinations() {
        click(bookVaccinations);
    }

    public void clickBuyInsurance() {
        click(buyInsurance);
    }

    public void clickInterbankMoneyTransfer() {
        click(interbankMoneyTransfer);
    }

    public void clickPersonalSpendBorrow() {
        click(personalSpendBorrow);
    }

    public void clickOpenLuckyAccount() {
        click(openLuckyAccount);
    }

    public void clickInsideMoneyTransfer() {
        click(insideMoneyTransfer);
    }

    public void clickOpenNewCard() {
        click(openNewCard);
    }

    public void clickTermSavingsDeposit() {
        click(termSavingsDeposit);
    }

    public void clickQRPAYDiscountCode() {
        click(QRPAYDiscountCode);
    }

    public void clickLoyaltyRedeem() {
        click(QRPAYDiscountCode);
    }

    public void clickOffersAndPromotions() {
        click(QRPAYDiscountCode);
    }

    public void clickListAccount() {
        click(cinemaTicket);
    }

    public void clickGolfCourseReservations() {
        click(golfCourseReservations);
    }

    public void clickEVoucher() {
        click(eVoucher);
    }

    public void clickVnShop() {
        click(VnShop);
    }

    public void clickGiveFreshFlowers() {
        scrollToElement(giveFreshFlowers, ScrollDirection.DOWN, 1);
        click(giveFreshFlowers);
        if (waitForElementVisible(giveFreshFlowers, 3)) {
            click(giveFreshFlowers);
        }
    }

    public void clickEventTickets() {
        click(eventTickets);
    }

    public void clickCustomerSupportHotline() {
        click(customerSupportHotline);
    }

    public void clickChatWithVietinbank() {
        click(chatWithVietinbank);
    }

    public void clickCheckCardTransactions() {
        click(checkCardTransactions);
    }

    public void clickCheckAccountTransactions() {
        click(checkAccountTransactions);
    }

    public void clickNetworkBranchOfficeATM() {
        click(networkBranchOfficeATM);
    }

    public void clickLocationsAroundHere() {
        click(locationsAroundHere);
    }

    public void clickIntroducingIPayMobileToReceiveGifts() {
        click(introducingIPayMobileToReceiveGifts);
    }

    public void clickSeeTheFrequentlyAskedQuestions() {
        click(seeTheFrequentlyAskedQuestions);
    }

    public void clickWarningsAndRecommendations() {
        click(warningsAndRecommendations);
    }

    public void clickTicketPlaneBooking() {
        click(ticketPlaneBooking);
    }

    public void clickVNPAYTaxi() {
        click(VNPAYTaxi);
    }

    public void clickTicketTrainBooking() {
        click(ticketTrainBooking);
    }

    public void clickTicketCarBooking() {
        click(ticketCarBooking);
    }

    public void clickShipping() {
        click(shipping);
    }

    private void inputSearchInput(String searchText) {
        sendKeys(searchInput, searchText);
    }

    public void goToSendCongratulatoryMoneyScreen(String searchText) {
        inputSearchInput(searchText);
        click(searchFeatureResult);
    }

    public FavoriteServices favoriteServices() {
        return new FavoriteServices(appiumDriver);
    }

    public AdvertisingPopup advertisingPopup() {
        return new AdvertisingPopup(appiumDriver);
    }

    public ListAccountsScreen move_to_AccountNumberList() {
        tap(listAccountsTxt);
        delay(3000);
        return new ListAccountsScreen(appiumDriver);
    }

    public NavigationBar navigationBar() {
        return new NavigationBar(appiumDriver);
    }

}
