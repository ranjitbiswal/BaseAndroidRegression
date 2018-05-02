import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import io.appium.java_client.TouchAction as TouchAction

int x = 0

int y = 0

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

Mobile.delay(10)

'Checking Mic icon is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Mic Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Mic icon is not displayed in the Dashboard/Landing Page')
} else {
	System.out.println('Mic icon is displayed in the Dashboard/Landing Page')
}

'Checking Weather info is Present or not.'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/weatherDateTimeLandingPage'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Weather for current day is not displayed in the Dashboard/Landing Page')
} else {
	System.out.println('Weather for current day is displayed in the Dashboard/Landing Page')
}

if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/weatherDetailsWeekLandingPage'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Weather for whole week is not displayed in the Dashboard/Landing Page')
} else {
	System.out.println('Weather for whole week is displayed in the Dashboard/Landing Page')
}

AppiumDriver<?> driver = MobileDriverFactory.getDriver()


ArrayList<MobileElement> lLandingPageMenu1 = driver.findElementsById('com.sus.scm_mobile:id/ll_griditemcontainer_home')

println('Size of Menus Available on Landing Page 1:' + lLandingPageMenu1.size())

'Printing Landing Page Menu List'
println('Below are the Tabs available on the Dashboard Page 1 : ')

for (int index = 0; index < lLandingPageMenu1.size(); index++) {
	if (index == 2) {
		String sFirstMenu = lLandingPageMenu1.get(index).getText()

		WebElement FirstMenu = lLandingPageMenu1.get(index)

		x = FirstMenu.getLocation().getX()

		y = FirstMenu.getLocation().getY()
	}

	println(lLandingPageMenu1.get(index).getText())
}

TouchAction action = new TouchAction(driver)

action.press(x, y).moveTo(x - 560, y).release().perform()


ArrayList<MobileElement> lLandingPageMenu2 = driver.findElementsById('com.sus.scm_mobile:id/ll_griditemcontainer_home')

println('Size of Menus Available on Landing Page 2:' + lLandingPageMenu2.size())

'Printing Landing Page Menu List'
println('Below are the Tabs available on the Dashboard Page 2 : ')

for (int index = 0; index < lLandingPageMenu2.size(); index++) {
	println(lLandingPageMenu2.get(index).getText())
}
