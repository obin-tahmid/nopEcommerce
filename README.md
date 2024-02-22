# nopEcommerce

Test automation framework with sample tests for 2 scenarios.

**Scenarios**
Scenario: 01 Customer add products in his shopping cart
Scenario: 02 Customer successfully place order as a guest user

**Recording**
Find the Recording (Recording_test execution.mkv) in the project root folder.
Also, added a text file (Recording of Test Execution.txt) with a link to similar execution recording

**Highlights:**
Supports Android Mobile devices (Emulator + Real) 
Test listeners (TestNG ITestListener)
Retry attempt for failed test methods maximum of 3 times
Page Object pattern (UtilityFunctions.PageObject)
Extent Report with screenshot on point of test failure

**Technology stack:**
TestNG (test runner)
Appium (mobile testing)
Extent Report (reporting)

**How to run**
Ensure appium server is running on "http://127.0.0.1:4723" otherwise configure from BaseTest.initializeDriver()
Ensure correct device UDID is set in the capability (BaseTest.initializeDriver()). Default is emulator-5554 for Android emulator
Right click on the testng.xml file located in the project root folder and select Run As > TestNG suite 