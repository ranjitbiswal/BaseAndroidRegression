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

String messageText = null

'Starting the Application'
applicationMethods.ReusableMethods.startApplication()

'Getting Device Current Orientation'
Mobile.getCurrentOrientation(FailureHandling.CONTINUE_ON_FAILURE)

'Getting Device Height'
Mobile.getDeviceHeight(FailureHandling.CONTINUE_ON_FAILURE)

'Getting Device OS'
Mobile.getDeviceOS(FailureHandling.CONTINUE_ON_FAILURE)

'Getting Device OS Version'
Mobile.getDeviceOSVersion(FailureHandling.CONTINUE_ON_FAILURE)

'Delay of 30 Sec'
Mobile.delay(10)

'TC  --> To verify that SCM-Mobile app Landing screen contain Objects'

@com.kms.katalon.core.annotation.TearDown
static void verifyLoginPageObjects() {
    'TC :TC_LO_2,TC_LO_37 --> verifyLoginPageObjects initiated'
    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/CompanyLogo', 'Client Logo')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/ContactUs Icon', 'ContactUs Icon')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/ContactUs Text', 'ContactUs Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Efficiency Icon', 'Efficiency Icon')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Efficiency Text', 'Efficiency Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/FaceBook Icon', 'FaceBook Icon')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/FaceBook Text', 'FaceBook Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Or Text Label', 'Or Text Label')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Outages Icon', 'Outages Icon')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Outages Text', 'Outages Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/PayBill Icon', 'PayBill Icon')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Pay Bill Text', 'Pay Bill Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Register Now Button', 'Register Now Button')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Remember Me CheckBox', 'Remember Me CheckBox')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Remember Me Label', 'Remember Me Label')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin/Sign In Text', 'Sign In Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Login/UserName TextBox', 'UserName TextBox')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Login/Password TextBox', 'Password TextBox')
}


'TC : TC_LO_8, TC_LO_9, TC_LO_10, TC_LO_11 --> To Verify the Negative Test Cases'
@com.kms.katalon.core.annotation.TearDown
static void verifyLoginPageNegativeTestCases() {
    'TC : verifyLoginPageNegativeTestCases initiated'

    'TC : TC_LO_8 --> To verify that User is try to Login without UserName and Password'
    applicationMethods.ReusableMethods.verifyValidLogin('', '')

    'TC : TC_LO_9 --> To verify that User is try to Login with Blank UserName'
    applicationMethods.ReusableMethods.verifyValidLogin('', 'Demo@123')

    'TC : TC_LO_10 --> To verify that User is try to Login with Blank Password'
    applicationMethods.ReusableMethods.verifyValidLogin('demo', '')

    'TC : TC_LO_11 --> To verify that User is try to Login with invalid credentials'
    applicationMethods.ReusableMethods.verifyValidLogin('demo', 'Demo@112143')
}