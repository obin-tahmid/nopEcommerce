package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BaseTest;
import UtilityFunctions.DataProviderExcel;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Cart_Test extends BaseTest {

	@Test(priority = 1, groups = "Cart", description = "Verify Customer add products in his shopping cart")
	public void TCM_001() {

		getUtil().print("Executing TCM_001");

		getUtil().click(getPageObject().getPopupAcceptAndAgreeButton());

		boolean homepageTopCarouselElementFound = getUtil().isElementVisible(getPageObject().getHomePageTopCarousel());

		getExtentTest().info("Verifying on home page after opening nopCart mobile app");
		getUtil().print("Verifying on home page after opening nopCart mobile app");

		// 1st validation
		if (homepageTopCarouselElementFound == true) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---1st Validation PASSED");
			getUtil().print("homepageTopCarouselElementFound = " + homepageTopCarouselElementFound);
			getUtil().print("expected = true");
			getUtil().print("--------------------------");

			getUtil().logTest(true, getUtil().combineStringDifferentLine_ExReport("---1st Validation PASSED",
					"homepageTopCarouselElementFound = " + homepageTopCarouselElementFound, "expected = true"));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---1st Validation FAILED");
			getUtil().printR("homepageTopCarouselElementFound = " + homepageTopCarouselElementFound);
			getUtil().printR("expected = true");
			getUtil().printR("--------------------------");

			getUtil().logTest(false, getUtil().combineStringDifferentLine_ExReport("---1st Validation FAILED",
					"homepageTopCarouselElementFound = " + homepageTopCarouselElementFound, "expected = true"));

		}

		// Swiping right on the our categories slider
		getExtentTest().info("Swiping right on the our categories slider");
		getUtil().print("Swiping right on the our categories slider");

		getUtil().scrollRightOfElement(getPageObject().getHomepageOurCategoriesSliderFoodAndGrocery());

		getUtil().click(getPageObject().getHomepageOurCategoriesElectronics());

		String expected_pageTitle = "Electronics";
		String actual_pageTitle = getUtil().getTextFromWebElement(getPageObject().getPLPPageTitle());

		getExtentTest().info("Click 'electronics' from 'OUR CATEGORIES' list from home page");
		getUtil().print("Click 'electronics' from 'OUR CATEGORIES' list from home page");

		// 2nd validation
		if (actual_pageTitle.equals(expected_pageTitle)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---2nd Validation PASSED");
			getUtil().print("actual_pageTitle = " + actual_pageTitle);
			getUtil().print("expected_pageTitle = " + expected_pageTitle);
			getUtil().print("--------------------------");

			getUtil().logTest(true, getUtil().combineStringDifferentLine_ExReport("---2nd Validation PASSED",
					"actual_pageTitle = " + actual_pageTitle, "expected_pageTitle = " + expected_pageTitle));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---2nd Validation FAILED");
			getUtil().printR("actual_pageTitle = " + actual_pageTitle);
			getUtil().printR("expected_pageTitle = " + expected_pageTitle);
			getUtil().printR("--------------------------");

			getUtil().logTest(false, getUtil().combineStringDifferentLine_ExReport("---2nd Validation FAILED",
					"actual_pageTitle = " + actual_pageTitle, "expected_pageTitle = " + expected_pageTitle));

		}

		getUtil().scrollDownToElement(getPageObject().getPLPElectronicsSpecificProductMattressBedroom());

		getUtil().click(getPageObject().getPLPElectronicsSpecificProductMattressBedroom());

		String expected_productName = "Mattress Bedroom";
		String actual_productName = getUtil().getTextFromWebElement(getPageObject().getPDPProductName());

		getExtentTest().info("Click to \"Mattress Bedroom\" product details page");
		getUtil().print("Click to \"Mattress Bedroom\" product details page");

		// 3rd validation
		if (actual_productName.equals(expected_productName)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---3rd Validation PASSED");
			getUtil().print("actual_productName = " + actual_productName);
			getUtil().print("expected_productName = " + expected_productName);
			getUtil().print("--------------------------");

			getUtil().logTest(true, getUtil().combineStringDifferentLine_ExReport("---3rd Validation PASSED",
					"actual_productName = " + actual_productName, "expected_productName = " + expected_productName));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---3rd Validation FAILED");
			getUtil().printR("actual_productName = " + actual_productName);
			getUtil().printR("expected_productName = " + expected_productName);
			getUtil().printR("--------------------------");

			getUtil().logTest(false, getUtil().combineStringDifferentLine_ExReport("---3rd Validation FAILED",
					"actual_productName = " + actual_productName, "expected_productName = " + expected_productName));

		}

		// Verifying click plus button to increase Qty by "2"
		getExtentTest().info("Verifying click plus button to increase Qty by '2'");
		getUtil().print("Verifying click plus button to increase Qty by '2'");

		getUtil().scrollDownToElement(getPageObject().getPDPProductQuantityIncreasePlusButton());

		getUtil().click(getPageObject().getPDPProductQuantityIncreasePlusButton());

		getUtil().threadSleep(3000);

		String expected_productQuantity = "2";
		String actual_productQuantity = getUtil()
				.getTextFromWebElement(getPageObject().getPDPProductQuantityInputField());

		// 4th validation
		if (actual_productQuantity.equals(expected_productQuantity)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---4th Validation PASSED");
			getUtil().print("actual_productQuantity = " + actual_productQuantity);
			getUtil().print("expected_productQuantity = " + expected_productQuantity);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---4th Validation PASSED",
							"actual_productQuantity = " + actual_productQuantity,
							"expected_productQuantity = " + expected_productQuantity));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---4th Validation FAILED");
			getUtil().printR("actual_productQuantity = " + actual_productQuantity);
			getUtil().printR("expected_productQuantity = " + expected_productQuantity);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---4th Validation FAILED",
							"actual_productQuantity = " + actual_productQuantity,
							"expected_productQuantity = " + expected_productQuantity));

		}

		// Verifying click add to cart button to add the product in his cart
		getExtentTest().info("Verifying click add to cart button to add the product in his cart");
		getUtil().print("Verifying click add to cart button to add the product in his cart");

		getUtil().click(getPageObject().getPDPAddToCartCTA());

//		getUtil().threadSleep(3000);
		getUtil().goToCart();

		String expected_productQuantity_cart = "2 item(s)";
		String actual_productQuantity_cart = getUtil().getTextFromWebElement(getPageObject().getCartTotalItemCount());

		// 5th validation
		if (actual_productQuantity_cart.equals(expected_productQuantity_cart)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---5th Validation PASSED");
			getUtil().print("actual_productQuantity_cart = " + actual_productQuantity_cart);
			getUtil().print("expected_productQuantity_cart = " + expected_productQuantity_cart);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---5th Validation PASSED",
							"actual_productQuantity_cart = " + actual_productQuantity_cart,
							"expected_productQuantity_cart = " + expected_productQuantity_cart));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---5th Validation FAILED");
			getUtil().printR("actual_productQuantity_cart = " + actual_productQuantity_cart);
			getUtil().printR("expected_productQuantity_cart = " + expected_productQuantity_cart);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---5th Validation FAILED",
							"actual_productQuantity_cart = " + actual_productQuantity_cart,
							"expected_productQuantity_cart = " + expected_productQuantity_cart));

		}

		// Verifying Product Name in cart
		getExtentTest().info("Verifying Product Name in cart");
		getUtil().print("Verifying Product Name in cart");

		String actual_productName_cart = getUtil()
				.getTextFromWebElement(getPageObject().getCartProductNameFirstProduct());

		// 6th validation
		if (actual_productName_cart.equals(expected_productName)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---6th Validation PASSED");
			getUtil().print("actual_productName_cart = " + actual_productName_cart);
			getUtil().print("expected_productName = " + expected_productName);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---6th Validation PASSED",
							"actual_productName_cart = " + actual_productName_cart,
							"expected_productName = " + expected_productName));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---6th Validation FAILED");
			getUtil().printR("actual_productName_cart = " + actual_productName_cart);
			getUtil().printR("expected_productName = " + expected_productName);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---6th Validation FAILED",
							"actual_productName_cart = " + actual_productName_cart,
							"expected_productName = " + expected_productName));

		}

		// final validation
		getUtil().finalValidation(getUtil().getTestValidations(), "TCM_001");
		Assert.assertEquals(getUtil().verifyAll(getUtil().getTestValidations()), true,
				"Failed in : " + getUtil().findFailedTestStep(getUtil().getTestValidations()));

	}

	@Test(dataProviderClass = UtilityFunctions.DataProviderExcel.class, dataProvider = "billingInfo", priority = 0, groups = "Cart", description = "Verify Customer successfully place order as a guest user")
	public void TCM_002(String firstName, String lastName, String email, String company, String city,
			String streetAddress, String postcode, String phoneNumber, String fax) {

		/*
		 * dataProvider = "billingInfo",
		 * 
		 * String firstName, String lastName, String email, String company, String city,
		 * String streetAddress, String postcode, String phoneNumber, String fax
		 */
		getUtil().print("Executing TCM_002 for following dataset:");

		System.out.println("data added to 2 dimensional array = " + new DataProviderExcel().testData());

		/////////////
		customPrintForTCM_002(firstName, lastName, email, company, city, streetAddress, postcode, phoneNumber, fax);
		////////////

		getUtil().click(getPageObject().getPopupAcceptAndAgreeButton());

		// calling re-usable function
		getUtil().addRandomProductAndGoToCart();

		String productName_cart = getUtil().getTextFromWebElement(getPageObject().getCartProductNameFirstProduct());

		// Verifying Successful navigation to non-empty Shopping cart
		getExtentTest().info("Verifying Successful navigation to non-empty Shopping cart");
		getUtil().print("Verifying Successful navigation to non-empty Shopping cart");

		String expected_pageTitle = "Shopping Cart";
		String actual_pageTitle = getUtil().getTextFromWebElement(getPageObject().getCartPageTitle());

		// 1st validation
		if (actual_pageTitle.equals(expected_pageTitle)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---1st Validation PASSED");
			getUtil().print("actual_pageTitle = " + actual_pageTitle);
			getUtil().print("expected_pageTitle = " + expected_pageTitle);
			getUtil().print("--------------------------");

			getUtil().logTest(true, getUtil().combineStringDifferentLine_ExReport("---1st Validation PASSED",
					"actual_pageTitle = " + actual_pageTitle, "expected_pageTitle = " + expected_pageTitle));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---1st Validation FAILED");
			getUtil().printR("actual_pageTitle = " + actual_pageTitle);
			getUtil().printR("expected_pageTitle = " + expected_pageTitle);
			getUtil().printR("--------------------------");

			getUtil().logTest(false, getUtil().combineStringDifferentLine_ExReport("---1st Validation FAILED",
					"actual_pageTitle = " + actual_pageTitle, "expected_pageTitle = " + expected_pageTitle));

		}

		// Verifying Successful click checkout button from shopping cart page
		getExtentTest().info("Verifying Successful click checkout button from shopping cart page");
		getUtil().print("Verifying Successful click checkout button from shopping cart page");

		// Clicking Checkout CTA in Cart
		getUtil().click(getPageObject().getCartCheckoutCTA());

		String expected_checkoutpopupModalTitle = "Checkout as a guest or register";
		String actual_checkoutpopupModalTitle = getUtil()
				.getTextFromWebElement(getPageObject().getCartCheckoutAsGuestOrRegisterPopupModalTitle());

		// 2nd validation
		if (actual_checkoutpopupModalTitle.equals(expected_checkoutpopupModalTitle)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---2nd Validation PASSED");
			getUtil().print("actual_checkoutpopupModalTitle = " + actual_checkoutpopupModalTitle);
			getUtil().print("expected_checkoutpopupModalTitle = " + expected_checkoutpopupModalTitle);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---2nd Validation PASSED",
							"actual_checkoutpopupModalTitle = " + actual_checkoutpopupModalTitle,
							"expected_checkoutpopupModalTitle = " + expected_checkoutpopupModalTitle));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---2nd Validation FAILED");
			getUtil().printR("actual_checkoutpopupModalTitle = " + actual_checkoutpopupModalTitle);
			getUtil().printR("expected_checkoutpopupModalTitle = " + expected_checkoutpopupModalTitle);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---2nd Validation FAILED",
							"actual_checkoutpopupModalTitle = " + actual_checkoutpopupModalTitle,
							"expected_checkoutpopupModalTitle = " + expected_checkoutpopupModalTitle));

		}

		/*
		 * Verifying User successfully selected checkout as guest from shopping cart
		 * page
		 */
		getExtentTest().info("Verifying User successfully selected checkout as guest from shopping cart page");
		getUtil().print("Verifying User successfully selected checkout as guest from shopping cart page");

		// Clicking Checkout as Guest
		getUtil().click(getPageObject().getCartCheckoutAsGuestOrRegisterPopupModalCheckoutAsGuestButton());

		String expected_billingAddressTabTitle = "Billing address";
		String actual_billingAddressTabTitle = getUtil()
				.getTextFromWebElement(getPageObject().getGuestCheckoutBillingAddressTabTitle());

		// 3rd validation
		if (actual_billingAddressTabTitle.equals(expected_billingAddressTabTitle)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---3rd Validation PASSED");
			getUtil().print("actual_billingAddressTabTitle = " + actual_billingAddressTabTitle);
			getUtil().print("expected_billingAddressTabTitle = " + expected_billingAddressTabTitle);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---3rd Validation PASSED",
							"actual_billingAddressTabTitle = " + actual_billingAddressTabTitle,
							"expected_billingAddressTabTitle = " + expected_billingAddressTabTitle));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---3rd Validation FAILED");
			getUtil().printR("actual_billingAddressTabTitle = " + actual_billingAddressTabTitle);
			getUtil().printR("expected_billingAddressTabTitle = " + expected_billingAddressTabTitle);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---3rd Validation FAILED",
							"actual_billingAddressTabTitle = " + actual_billingAddressTabTitle,
							"expected_billingAddressTabTitle = " + expected_billingAddressTabTitle));

		}

		/*
		 * Verifying User input all the details in checkout billing details page and
		 * click continue
		 */
		getExtentTest()
				.info("Verifying User input all the details in checkout billing details page and click continue");
		getUtil().print("Verifying User input all the details in checkout billing details page and click continue");

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressFirstName(), firstName);
		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressLastName(), lastName);
		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressEmail(), email);

		getUtil().click(getPageObject().getGuestCheckoutBillingAddressCountrySelector());

		getUtil().click(getPageObject().getGuestCheckoutBillingAddressCountrySpecificCountry(2));

		getUtil().threadSleep(1000);
		getUtil().scrollDownToElement(getPageObject().getGuestCheckoutBillingAddressStateSelector());

		getUtil().click(getPageObject().getGuestCheckoutBillingAddressStateSelector());

		getUtil().click(getPageObject().getGuestCheckoutBillingAddressStateSpecificState("Alabama"));

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressCompany(), company);

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressCity(), city);

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressStreetAddress(), streetAddress);

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressZIPPostalCode(), postcode);

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressPhoneNumber(), phoneNumber);

		getUtil().sendkeys(getPageObject().getGuestCheckoutBillingAddressFax(), fax);

		getUtil().click(getPageObject().getGuestCheckoutBillingAddressContinueCTA());

		/*
		 * Verifying Next Day Air delivery method is visible
		 */
		getExtentTest().info("Verifying Next Day Air delivery method is visible");
		getUtil().print("Verifying Next Day Air delivery method is visible");

		String expected_deliveryMethodName = "Next Day Air";
		String actual_deliveryMethodName = getUtil()
				.getTextFromWebElement(getPageObject().getGuestCheckoutShippingDeliveryMethodNameSpecificMethod(4));

		// 4th validation
		if (actual_deliveryMethodName.equals(expected_deliveryMethodName)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---4th Validation PASSED");
			getUtil().print("actual_deliveryMethodName = " + actual_deliveryMethodName);
			getUtil().print("expected_deliveryMethodName = " + expected_deliveryMethodName);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---4th Validation PASSED",
							"actual_deliveryMethodName = " + actual_deliveryMethodName,
							"expected_deliveryMethodName = " + expected_deliveryMethodName));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---4th Validation FAILED");
			getUtil().printR("actual_deliveryMethodName = " + actual_deliveryMethodName);
			getUtil().printR("expected_deliveryMethodName = " + expected_deliveryMethodName);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---4th Validation FAILED",
							"actual_deliveryMethodName = " + actual_deliveryMethodName,
							"expected_deliveryMethodName = " + expected_deliveryMethodName));

		}

		/*
		 * Verifying user able to select "Next Day Air" as shipping method and click
		 * continue
		 */
		getExtentTest().info("Verifying user able to select \"Next Day Air\" as shipping method and click continue");
		getUtil().print("Verifying user able to select \"Next Day Air\" as shipping method and click continue");

		getUtil().click(getPageObject().getGuestCheckoutShippingDeliveryMethodNameSpecificMethod(4));

		getUtil().click(getPageObject().getGuestCheckoutShippingContinueCTA());

		String expected_paymentMethodName = "Check / Money Order";
		String actual_paymentMethodName = getUtil().getTextFromWebElement(
				getPageObject().getGuestCheckoutPaymentMethodTitleSpecificTitle(expected_paymentMethodName));

		// 5th validation
		if (actual_paymentMethodName.equals(expected_paymentMethodName)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---5th Validation PASSED");
			getUtil().print("actual_paymentMethodName = " + actual_paymentMethodName);
			getUtil().print("expected_paymentMethodName = " + expected_paymentMethodName);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---5th Validation PASSED",
							"actual_paymentMethodName = " + actual_paymentMethodName,
							"expected_paymentMethodName = " + expected_paymentMethodName));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---5th Validation FAILED");
			getUtil().printR("actual_paymentMethodName = " + actual_paymentMethodName);
			getUtil().printR("expected_paymentMethodName = " + expected_paymentMethodName);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---5th Validation FAILED",
							"actual_paymentMethodName = " + actual_paymentMethodName,
							"expected_paymentMethodName = " + expected_paymentMethodName));

		}

		/*
		 * Verifying user able to select "Check/Money Order" as payment method and click
		 * continue
		 */
		getExtentTest()
				.info("Verifying user able to select \"Check/Money Order\" as payment method and click continue");
		getUtil().print("Verifying user able to select \"Check/Money Order\" as payment method and click continue");

		getUtil().click(getPageObject().getGuestCheckoutPaymentMethodTitleSpecificTitle(expected_paymentMethodName));

		getUtil().click(getPageObject().getGuestCheckoutShippingContinueCTA());

		getUtil().click(getPageObject().getGuestCheckoutPaymentInformationConfirmationPageNextCTA());

		getUtil().click(getPageObject().getGuestCheckoutOrderConfirmCTA());

		String expected_orderSuccessmessage = "Your order has been successfully processed!";

		String actual_orderSuccessmessage = getUtil()
				.getTextFromWebElement(getPageObject().getGuestCheckoutOrderConfirmationPopupSuccessMessage());

		// 6th validation
		if (actual_orderSuccessmessage.contains(expected_orderSuccessmessage)) {

			getUtil().getTestValidations().add(true);

			// tbd
			getUtil().print("---6th Validation PASSED");
			getUtil().print("actual_orderSuccessmessage = " + actual_orderSuccessmessage);
			getUtil().print("expected_orderSuccessmessage = " + expected_orderSuccessmessage);
			getUtil().print("--------------------------");

			getUtil().logTest(true,
					getUtil().combineStringDifferentLine_ExReport("---6th Validation PASSED",
							"actual_orderSuccessmessage = " + actual_orderSuccessmessage,
							"expected_orderSuccessmessage = " + expected_orderSuccessmessage));

		} else {

			getUtil().getTestValidations().add(false);

			// tbd
			getUtil().printR("---6th Validation FAILED");
			getUtil().printR("actual_orderSuccessmessage = " + actual_orderSuccessmessage);
			getUtil().printR("expected_orderSuccessmessage = " + expected_orderSuccessmessage);
			getUtil().printR("--------------------------");

			getUtil().logTest(false,
					getUtil().combineStringDifferentLine_ExReport("---6th Validation FAILED",
							"actual_orderSuccessmessage = " + actual_orderSuccessmessage,
							"expected_orderSuccessmessage = " + expected_orderSuccessmessage));

		}

		// final validation
		getUtil().finalValidation(getUtil().getTestValidations(), "TCM_002");
		Assert.assertEquals(getUtil().verifyAll(getUtil().getTestValidations()), true,
				"Failed in : " + getUtil().findFailedTestStep(getUtil().getTestValidations()));

	}

	private void customPrintForTCM_002(String firstName, String lastName, String email, String company, String city,
			String streetAddress, String postcode, String phoneNumber, String fax) {

		getUtil().print("firstName = " + firstName);
		getUtil().print("lastName = " + lastName);
		getUtil().print("email = " + email);
		getUtil().print("company = " + company);
		getUtil().print("city = " + city);
		getUtil().print("streetAddress = " + streetAddress);
		getUtil().print("postcode = " + postcode);
		getUtil().print("phoneNumber = " + phoneNumber);
		getUtil().print("fax = " + fax);

		getExtentTest().info("firstName = " + firstName);
		getExtentTest().info("lastName = " + lastName);
		getExtentTest().info("email = " + email);
		getExtentTest().info("company = " + company);
		getExtentTest().info("city = " + city);
		getExtentTest().info("streetAddress = " + streetAddress);
		getExtentTest().info("postcode = " + postcode);
		getExtentTest().info("phoneNumber = " + phoneNumber);
		getExtentTest().info("fax = " + fax);

	}

}
