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
import org.openqa.selenium.interactions.TouchScreen as TouchScreen
import org.openqa.selenium.interactions.touch.TouchActions as TouchActions
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
import io.appium.java_client.TouchAction as TouchAction

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 30 Sec'
Mobile.delay(30)

'Clicking on the Hamburger Menu'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

@com.kms.katalon.core.annotation.TearDown
static void verifyChangeUsernameTestCases() {
    'TC : TC_DBD_117, TC_DBD_118 To verify that Change Username Tab, its page objects and Save the Setting'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Checking Change Username is Displayed on Hamburger Menu or Not'
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Change Username Menu'), 3, 
        FailureHandling.CONTINUE_ON_FAILURE) == false) {
        System.out.println('Change Username is not Displayed in Hamburger Menu, So Change Username Test Cases cannot be verified')
    } else {
        System.out.println('Change Username is Displayed in Hamburger Menu')

        'Clicking on the Change Username'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Change Username Menu'), 5)

        'Checking Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_dialog_title').getText()

        if (messageText.equals('Change Username')) {
            System.out.println('On Click on Change Username from the Hamburger Menu, User is routing to the Change Username Module')

            'Verifying Change Username Page Objects'
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/Existing Username Heading', 
                'Existing Username Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/Existing Username TextBox', 
                'Existing Username TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/New Username Heading', 
                'New Username Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/New Username TextBox', 
                'New Username TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/UserName Criteria Informational Icon', 
                'UserName Criteria Informational Icon')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/Change Username Popup Close Button', 
                'Change Username Popup Close Button')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Username/Submit Button', 
                'Submit Button')

            'TC : --> TC to check the mandatory field message '

            'Clicking on the Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Submit Button'), 3)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            if (messageText.equals(GlobalVariable.sMandatoryFieldPopupMessageText)) {
                System.out.println('Without entering the mandatory fields, application is not allowing to move further.')
            } else {
                System.out.println((('Something went wrong on submitting the change Username. Please check manually. Expected Popup message text is ' + 
                    GlobalVariable.sMandatoryFieldPopupMessageText) + 'but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'TC : TC_DBD_120--> TC to check the Invalid Existing User ID '

            'Entering the Existing Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Existing Username TextBox'), 'WERWDWD', 
                4)

            'Entering the New Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/New Username TextBox'), GlobalVariable.sNewUsername, 
                4)

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Existing Username donot match Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sExistingUsernameNotMatchPopupMessageText)) {
                System.out.println('Your Existing Username does not match our records, please verify and re-enter.')
            } else {
                System.out.println((('Existing Username Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sExistingUsernameNotMatchPopupMessageText) + ' but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'TC : TC_DBD_120--> TC to check the Duplicate User ID '

            'Clicking on the Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

            'Clicking on the Change Username'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Change Username Menu'), 5)

            'Entering the Existing Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Existing Username TextBox'), GlobalVariable.sUserName, 
                4)

            'Entering the New Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/New Username TextBox'), GlobalVariable.sUserNameAlreadyExists, 
                4)

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Duplicate Username donot match Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sDuplicateUsernameNotMatchPopupMessageText)) {
                System.out.println('Username is already in use. Please register with a new Username or contact Customer Service by email at support@smartusys.com or by phone at (800) 345-1570.')
            } else {
                System.out.println((('Duplicate Username Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sDuplicateUsernameNotMatchPopupMessageText) + ' but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'TC : TC_DBD_139--> TC to update the User ID '

            'Clicking on the Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

            'Clicking on the Change Username'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Change Username Menu'), 5)

            'Entering the Existing Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Existing Username TextBox'), GlobalVariable.sUserName, 
                4)

            'Entering the New Username'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/New Username TextBox'), GlobalVariable.sNewUsername, 
                4)

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Update Username Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sUsernameUpdationMessageText)) {
                System.out.println('Your Username has been changed successfully.')
            } else {
                System.out.println((('Username update text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sUsernameUpdationMessageText) + ' but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			
			Mobile.delay(2)
			
			'Reverting the Username'
			
			'ReLogin'
			applicationMethods.ReusableMethods.verifyValidLogin(GlobalVariable.sNewUsername,GlobalVariable.sPassword)
			
			'Clicking on the Hamburger Menu'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

			'Clicking on the Change Username'
			Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Change Username Menu'), 5)

			'Entering the Existing Username'
			Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Existing Username TextBox'), GlobalVariable.sNewUsername,
				4)

			'Entering the New Username'
			Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Username/New Username TextBox'), GlobalVariable.sUserName,
				4)

			'Clicking on Submit Button'
			Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Username/Submit Button'), 4)

			messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1,
				FailureHandling.CONTINUE_ON_FAILURE)

			'Checking Update Username Text is matching with the Expected Text or Not'
			if (messageText.equals(GlobalVariable.sUsernameUpdationMessageText)) {
				System.out.println('Your Username has been changed successfully.')
			} else {
				System.out.println((('Username update text is not matching with the Expected Text, Expected Text is : ' +
					GlobalVariable.sUsernameUpdationMessageText) + ' but Actual Text is ') + messageText)
			}
			
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			
			
			
        } else {
            System.out.println('On Click on Change Username from the Hamburger Menu, user might route to the Change Username Module or something issue with the Module Name. Expected Module Name is : Change Username. Please check manually. ')
        }
    }
}