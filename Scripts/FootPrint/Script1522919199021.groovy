import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import groovy.time.TimeCategory as TimeCategory
import java.util.logging.Logger as Logger
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF as ElseExpressionBNF
import org.junit.After as After
import org.openqa.selenium.WebElement as WebElement
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
import io.appium.java_client.MobileBy as MobileBy
import io.appium.java_client.MobileElement as MobileElement

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

@com.kms.katalon.core.annotation.TearDown
static void verifFootPrintTestCases() {

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)

'TC_FP_1'
'Checking FootPrint Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/FootPrint Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Foootprint is not displayed in the Dashboard/Landing Page')
} else {
    'Clicking on Foootprint Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/FootPrint Menu'), 10)

	'Delay of 20 seconds'
	Mobile.delay(20)
	
	'Check Module Name'
	String messageText1 = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
	if (messageText1.equals('Footprint')) {
		System.out.println('On Click on Footprint from the EV Tab, User is routing to the Footprint Module')
		'TC_FP_3'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/FootPrint/MapTypeIconFootPrint',
			'MapTypeIconFootPrint')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/FootPrint/refreshIconFoorPrint',
			'refreshIconFoorPrint')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/FootPrint/currentLocationFootPrint',
			'currentLocationFootPrint')
		
		Mobile.tap(findTestObject('SCM Mobile/FootPrint/lstViewFootPrint'), 15)
		'TC_FP_5'
		Mobile.tap(findTestObject('SCM Mobile/FootPrint/searchIconFootPrint'), 15)
		'Entering Pincode/City for search'
		Mobile.setText(findTestObject('SCM Mobile/FootPrint/searchBoxFootPrint'), GlobalVariable.sSearchTextFootprint, 3)
		
		'Hide KeyBoard'
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('SCM Mobile/FootPrint/btnGoSearchFootPrint'), 15)
		ArrayList<MobileElement> lSearchedFPMenu = driver.findElementsById('com.sus.scm_mobile:id/tv_footprint_subaddress_detail')
		
			for (int index = 0; index < lSearchedFPMenu.size(); index++) {
			String s=lSearchedFPMenu.get(index).getText()
			if (s.contains(GlobalVariable.sSearchTextFootprint)) {
				println "Only Searched Pincode Footprints are visible."
		
			}
			else
			{
				println "Other than searched Footprints are also shown on the Screen"
				}
			}
			
			Mobile.pressBack()
	}
}
}