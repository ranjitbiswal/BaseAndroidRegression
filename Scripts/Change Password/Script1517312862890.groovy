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
static void verifyChangePasswordTestCases() {
    'TC : TC_DBD_94, TC_DBD_95, TC_DBD_96 To verify that Change Password Tab, its page objects and Save the Setting'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Checking Change Password is Displayed on Hamburger Menu or Not'
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Change Password Menu'), 3, 
        FailureHandling.CONTINUE_ON_FAILURE) == false) {
        System.out.println('Change Password is not Displayed in Hamburger Menu, So Change Password Test Cases cannot be verified')
    } else {
        System.out.println('Change Password is Displayed in Hamburger Menu')

        'Clicking on the Change Password'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Change Password Menu'), 5)

        'Checking Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        if (messageText.equals('Change Password')) {
            System.out.println('On Click on Change Password from the Hamburger Menu, User is routing to the Change Password Module')

            'Verifying Change Password Page Objects'
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Confirm Password Heading', 
                'Confirm Password Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox', 
                'Existing Password TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/New Password Heading', 
                'New Password Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox', 
                'New Password TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Password Criteria Informational Icon', 
                'Password Criteria Informational Icon')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Confirm Password Heading', 
                'Confirm Password Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox', 
                'Confirm Password TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Change Password/Submit Button', 
                'Submit Button')

            'TC : TC_DBD_95 --> TC to check the mandatory field message '

            'Clicking on the Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 3)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            if (messageText.equals(GlobalVariable.sMandatoryFieldPopupMessageText)) {
                System.out.println('Without entering the mandatory fields, application is not allowing to move further.')
            } else {
                System.out.println((('Something went wrong on submitting the change password. Please check manually. Expected Popup message text is ' + 
                    GlobalVariable.sMandatoryFieldPopupMessageText) + 'but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'TC : TC_DBD_105 --> Different New and Confirm Password '

            'Entering the Existing Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sPassword, 
                4)

            'Entering the New Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            'Entering the Confirm Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), 'Demo@123456', 
                4)

            Mobile.pressBack()

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking New & Confirm Password Doesnot mactch Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sNewandConfirmPasswordNotMatchPopupMessageText)) {
                System.out.println('New Password and Confirm Password do not match. Please enter the same password is displayed when new password and confirm password do not match.')
            } else {
                System.out.println((('New Password and Confirm Password do not match Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sNewandConfirmPasswordNotMatchPopupMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'TC : TC_DBD_109 --> Invalid Existing Password '

            'Clearing the Existing Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the New Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the Confirm Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Entering the Existing Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), 'Demo@1212231', 
                4)

            'Entering the New Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            'Entering the Confirm Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            Mobile.pressBack()

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Existing Password donot match Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sExistingPasswordNotMatchPopupMessageText)) {
                System.out.println('Your Existing Password does not match our records, please verify and re-enter.')
            } else {
                System.out.println((('Existing Password do not match Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sExistingPasswordNotMatchPopupMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'TC : TC_DBD_111 --> Successfully Password change '

            'Clearing the Existing Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the New Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the Confirm Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Entering the Existing Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sPassword, 
                4)

            'Entering the New Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            'Entering the Confirm Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            Mobile.pressBack()

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Password Change Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sPasswordUpdationMessageText)) {
                System.out.println('Password Updated Successfully')
            } else {
                System.out.println((('Password Updated Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sPasswordUpdationMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Reverting the Password'

            'Clicking on the Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

            'Clicking on the Change Password'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Change Password Menu'), 5)

            'Clearing the Existing Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the New Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Clearing the Confirm Password'
            Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), 2, FailureHandling.STOP_ON_FAILURE)

            'Entering the Existing Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Existing Password TextBox'), GlobalVariable.sNewPassword, 
                4)

            'Entering the New Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/New Password TextBox'), GlobalVariable.sPassword, 
                4)

            'Entering the Confirm Password'
            Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Confirm Password TextBox'), GlobalVariable.sPassword, 
                4)

            Mobile.pressBack()

            'Clicking on Submit Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Change Password/Submit Button'), 4)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Password Change Message Text is matching with the Expected Text or Not'
            if (messageText.equals(GlobalVariable.sPasswordUpdationMessageText)) {
                System.out.println('Password Updated Successfully')
            } else {
                System.out.println((('Password Updated Text is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sPasswordUpdationMessageText) + ' but Actual Text is ') + messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
        } else {
            System.out.println('On Click on Change Password from the Hamburger Menu, user might route to the Change Password Module or something issue with the Module Name. Expected Module Name is : Change Password. Please check manually. ')
        }
    }
}