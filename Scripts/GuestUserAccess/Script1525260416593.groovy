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

import java.lang.reflect.Array

import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
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



'Method to check the Objects'

@com.kms.katalon.core.annotation.SetUp
static def verifyValidLoginasGuestUser() {

	'Check Application is Already Installed on Device or Not'
	Mobile.startApplication(GlobalVariable.sApplicationPath, false)

	'Delay of 60 Sec'
	Mobile.delay(20)

	'Clearing the UserName Text Field'
	Mobile.clearText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), 3)

	'Entering UserName'
	Mobile.setText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), 'danishmd', 3)

	'Hide KeyBoard'
	Mobile.hideKeyboard()

	'Clearing the Password Text Field'
	Mobile.clearText(findTestObject('SCM Mobile/LogIn/Password TextBox'), 3)

	'Entering Password'
	Mobile.setText(findTestObject('SCM Mobile/LogIn/Password TextBox'), 'Sdge@123', 3)

	'Hide KeyBoard'
	Mobile.hideKeyboard()

	'Clicking on SignIn Button'
	Mobile.tap(findTestObject('SCM Mobile/LogIn/SignIn Button'), 30)
	Mobile.verifyElementAttributeValue(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 'text', 'My Account', 2)

	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Outages Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
		System.out.println('Outgaes Menu is Displayed')
	}

	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/ConnectMe Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
		System.out.println('Connect Me Menu is Displayed')
	}
	
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/FootPrint Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
		System.out.println('FootPrint Menu is Displayed')
	}
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Compare Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
		System.out.println('Compare Menu is Displayed')
	}

	'CheckingService Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Service Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('Compare is not displayed in the Dashboard/Landing Page') //   Mobile.pressBack()

	} else {

		'Clicking on Service Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/Service Menu'), 5)

		'Delay'
		Mobile.delay(10)
		Mobile.tap(findTestObject('SCM Mobile/Services/ddlReasonServiceRequest'), 5)

		AppiumDriver<?> driver = MobileDriverFactory.getDriver()

		ArrayList<MobileElement> lReasons = driver.findElementsById('com.sus.scm_mobile:id/tv_topic_details')

		println('Size of Billing Side Menu :' + lReasons.size())
		for (int index2 = 0; index2 < lReasons.size(); index2++) {
			String s= lReasons.get(index2).getAttribute('text')
			if (s.equals('Move In')) {
				println 'It should not be present'
			}
			else {
				println 'It is expected not to be present in GU Account'
			}
			if (s.equals('Move Out')) {
				println 'It should not be present'
			}
			else {
				println 'It is expected not to be present in GU Account'
			}
			if (s.equals('Service Transfer')) {
				println 'It should not be present'
			}
			else {
				println 'It is expected not to be present in GU Account'
			}

			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
	
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
	
		}
	}

}