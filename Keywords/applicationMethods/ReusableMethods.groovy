package applicationMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.logging.Logger

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import org.openqa.selenium.By
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import groovy.util.logging.Log4j

public class ReusableMethods {

	def static messageText =null
	public static void verifyValidLogin() {
		'Check Application is Already Installed on Device or Not'
		Mobile.startApplication(GlobalVariable.sApplicationPath, false,FailureHandling.STOP_ON_FAILURE)

		'Delay of 60 Sec'
		Mobile.delay(60)

		'Clearing the UserName Text Field'
		Mobile.clearText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), 3)

		'Entering UserName'
		Mobile.setText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), GlobalVariable.sUserName, 3)

		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Clearing the Password Text Field'
		Mobile.clearText(findTestObject('SCM Mobile/LogIn/Password TextBox'), 3)

		'Entering Password'
		Mobile.setText(findTestObject('SCM Mobile/LogIn/Password TextBox'), GlobalVariable.sPassword, 3)

		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Clicking on SignIn Button'
		Mobile.tap(findTestObject('SCM Mobile/LogIn/SignIn Button'), 30)
		
		'Delay of 20 Sec'
		Mobile.delay(20)
	}


	public static void startApplication() {

	//	'Unlock screen'
	//	Mobile.unlockScreen()
		
		'Installing the Application on the Device'
		Mobile.startApplication(GlobalVariable.sApplicationPath, false, FailureHandling.STOP_ON_FAILURE)

		'Delay of 30 Sec'
		Mobile.delay(30)
	}



	public static void isMobileElementDisplayed(String locator, String elementName) {
		if (Mobile.verifyElementExist(findTestObject(locator), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			System.out.print(elementName + " is displayed on the Page");
		} else {
			System.out.print(elementName + " is not displayed on the Page");
		}
	}
	
	public static boolean  isMobileElementDisplayed(String locator) {
		if (Mobile.verifyElementExist(findTestObject(locator), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			System.out.print(locator + " is displayed on the Page");
			return true
		} else {
			System.out.print(locator + " is not displayed on the Page");
			return false
		}
	}

	public static void verifyValidLogin(String sUserName, String sPassword) {
		//		'Check Application is Already Installed on Device or Not'
		//		Mobile.startApplication(GlobalVariable.sApplicationPath, false)
		//
		//		'Delay of 60 Sec'
		//		Mobile.delay(60)
		//
		'Clearing the UserName Text Field'
		Mobile.clearText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), 3)

		'Entering UserName'
		Mobile.setText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), sUserName, 3)

		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Clearing the Password Text Field'
		Mobile.clearText(findTestObject('SCM Mobile/LogIn/Password TextBox'), 3)

		'Entering Password'
		Mobile.setText(findTestObject('SCM Mobile/LogIn/Password TextBox'), sPassword, 3)

		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Clicking on SignIn Button'
		Mobile.tap(findTestObject('SCM Mobile/LogIn/SignIn Button'), 30)

		'Delay of 5 Sec'
		Mobile.delay(5)

		'Checking User is able to Login Or Not'
		if(Mobile.verifyElementExist(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'),
					'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
			System.out.print("User is unable to Login, Below Message Displayed :" + messageText)
			
			'Delay of 1 Sec'
			Mobile.delay(1)
			
			'Clicking On Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

			'Delay of 1 Sec'
			Mobile.delay(1)
		}

		else {
			System.out.print("User successfully Logged In to the Application")
		}
	}
}
