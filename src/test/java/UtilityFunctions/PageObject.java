package UtilityFunctions;

import org.openqa.selenium.By;

import BaseTest.BaseTest;
import io.appium.java_client.AppiumBy;

public class PageObject extends BaseTest {

	public By getPopupAcceptAndAgreeButton() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept");
	}

	public By getHomePageTopCarousel() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/iv_auto_image_slider");
	}

	public By getHomepageOurCategoriesElectronics() {

		return AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Electronics\"]");
//		return AppiumBy.accessibilityId("00000000-0000-04f9-ffff-ffff000002d0");
	}

	public By getPLPPageTitle() {

		return AppiumBy.xpath("(//android.widget.TextView[@text=\"Electronics\"])[1]");
	}

	public By getPLPElectronicsSpecificProductMattressBedroom() {

		return AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]");
	}

	public By getPDPProductName() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/tvProductName");
	}

	public By getPDPProductQuantityIncreasePlusButton() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnPlus");
	}

	public By getPDPProductQuantityInputField() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/tvQuantity");
	}

	public By getPDPAddToCartCTA() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart");
	}

	public By getHeaderCartButton() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/counterIcon");
	}

	public By getCartTotalItemCount() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/tvTotalItem");
	}

	public By getCartProductNameFirstProduct() {

//		return AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\"])[9]");
//		return AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Electronics\"]");
		return AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]");
	}

	public By getHomepageOurCategoriesSliderParent() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories");
	}

	public By getHomepageOurCategoriesSliderFoodAndGrocery() {

		return AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Placeholder\"])[4]");
	}

	public By getBottomNavigationCategory() {

		return AppiumBy.accessibilityId("Category");
	}

	public By getBottomNavigationCategoryElectronics() {

		return AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvName\" and @text=\"Electronics\"]");
	}

	public By getCartPageTitle() {

		return AppiumBy.xpath("//android.widget.TextView[@text=\"Shopping Cart\"]");
	}

	public By getCartCheckoutCTA() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut");
	}

	public By getCartCheckoutAsGuestOrRegisterPopupModalTitle() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/checkoutAsGuestOrRegisterTitle");
	}

	public By getCartCheckoutAsGuestOrRegisterPopupModalCheckoutAsGuestButton() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout");
	}

	public By getGuestCheckoutBillingAddressTab() {

		return AppiumBy.id("Billing address");
	}

	public By getGuestCheckoutBillingAddressTabTitle() {

		return AppiumBy.xpath("//android.widget.TextView[@text=\"Billing address\"]");
	}

	public By getGuestCheckoutBillingAddressFirstName() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName");
	}

	public By getGuestCheckoutBillingAddressLastName() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName");
	}

	public By getGuestCheckoutBillingAddressEmail() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail");
	}

	public By getGuestCheckoutBillingAddressCountrySelector() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/countrySpinner");
	}

	public By getGuestCheckoutBillingAddressCompany() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName");
	}

	public By getGuestCheckoutBillingAddressCity() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etCity");
	}

	public By getGuestCheckoutBillingAddressStreetAddress() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress");
	}

	public By getGuestCheckoutBillingAddressStreetAddress2() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2");
	}

	public By getGuestCheckoutBillingAddressZIPPostalCode() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode");
	}

	public By getGuestCheckoutBillingAddressPhoneNumber() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone");
	}

	public By getGuestCheckoutBillingAddressFax() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/etFax");
	}

	public By getGuestCheckoutBillingAddressContinueCTA() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");
	}

	public By getGuestCheckoutBillingAddressCountrySpecificCountry(int countryIndex) {

		return AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"android:id/text1\"])[" + countryIndex + "]");

	}

	public By getGuestCheckoutBillingAddressStateSelector() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/stateSpinner");

	}

	public By getGuestCheckoutBillingAddressStateSpecificState(String stateName) {

		stateName = stateName.toLowerCase();
		stateName = getUtil().capitalizeFirstCharacter(stateName);

		return AppiumBy
				.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"" + stateName + "\"]");

	}

	public By getGuestCheckoutShippingDeliveryMethodNameSpecificMethod(int deliveryMethodIndex) {

		return AppiumBy.xpath(
				"(//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvShippingMethodName\"])["
						+ deliveryMethodIndex + "]");

	}

	public By getGuestCheckoutShippingDeliveryMethodSpecificMethod(int deliveryMethodIndex) {

		return AppiumBy.xpath(
				"//com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/radioGridGroup\"]/android.widget.RelativeLayout["
						+ deliveryMethodIndex + "]");

	}

	public By getGuestCheckoutShippingContinueCTA() {

		return AppiumBy.xpath(
				"(//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnContinue\"])[2]");

	}

	public By getGuestCheckoutPaymentMethodTitleSpecificTitle(String paymentMethodTitle) {

		return AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvPaymentMethodName\" and @text=\""
						+ paymentMethodTitle + "\"]");

	}

	public By getGuestCheckoutPaymentMethodSpecificMethod(int paymentMethodIndex) {

		return AppiumBy.xpath(
				"//com.bs.ecommerce.customViews.RadioGridGroupforReyMaterial[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/radioGridGroup\"]/android.widget.RelativeLayout["
						+ paymentMethodIndex + "]");

	}

	public By getGuestCheckoutPaymentTabContinueCTA() {

		return AppiumBy.xpath(
				"(//android.widget.Button[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/btnContinue\"])[2]");

	}

	public By getGuestCheckoutPaymentInformationConfirmationPageNextCTA() {

		return AppiumBy.xpath("//android.widget.Button[@text=\"Next\"]");

	}

	public By getGuestCheckoutOrderConfirmCTA() {

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue");

	}

	public By getGuestCheckoutOrderConfirmationPopupSuccessMessage() {

		getUtil().threadSleep(3000);

		return AppiumBy.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message");

	}

}