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
static void verifyNotificationPreferencesTestCases() {
	
	'TC : TC_MANP_1, TC_MANP_2 To verify that Notification Preferences Tab and page objects'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Checking Notification Preferences is Displayed on Hamburger Menu or Not'
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Menu'), 
        3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
        System.out.println('Notification Preferences is not Displayed in Hamburger Menu, So Notification Preferences Test Cases cannot be verified')
    } else {
        System.out.println('Notification Preferences is Displayed in Hamburger Menu')

        'Clicking on the Notification Preferences'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Menu'), 5)

        'Checking Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        if (messageText.equals('Notification Preferences')) {
            System.out.println('On Click on Notification Preferences from the Hamburger Menu, User is routing to the Notification Preferences Module')
        } else {
            System.out.println('On Click on Notification Preferences from the Hamburger Menu, user might route to the Notification Preferences Module or something issue with the Module Name. Expected Module Name is : Notification Preferences. Please check manually. ')
        }
        
        'Checking Notification Preferences Objects'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Billing Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Billing Menu is not Displayed in Hamburger Menu, So Notification Preferences Billing Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Billing Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Budget Limit Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Budget Limit Menu is not Displayed in Hamburger Menu, So Notification Preferences Budget Limit Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Budget Limit Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Budget Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Budget Menu is not Displayed in Hamburger Menu, So Notification Preferences Budget Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Budget Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Connect Me Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Connect Me Menu is not Displayed in Hamburger Menu, So Notification Preferences Connect Me Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Connect Me Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences High Usage Alert Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences High Usage Alert Menu is not Displayed in Hamburger Menu, So Notification Preferences High Usage Alert Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences High Usage Alert Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Leak Alert Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Leak Alert Menu is not Displayed in Hamburger Menu, So Notification Preferences Leak Alert Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Leak Alert Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Outage Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Outage Menu is not Displayed in Hamburger Menu, So Notification Preferences Outage Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Outage Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Services Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Services Menu is not Displayed in Hamburger Menu, So Notification Preferences Services Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Services Menu is Displayed in Notification Preferences Menu')
        }
        
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Notification Preferences Save Button', 
            'Notification Preferences Save Button')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Notification Preferences Quiet Hours CheckBox', 
            'Notification Preferences Quiet Hours CheckBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Notification Preferences Quiet Hours Heading', 
            'Notification Preferences Quiet Hours Heading')
    }
}