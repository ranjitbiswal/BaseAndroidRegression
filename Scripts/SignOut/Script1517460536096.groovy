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
Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5, FailureHandling.CONTINUE_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDown
static void verifySignOutTestCases() {
    'TC : TC_DBD_152 To verify that SignOut TestCases'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Checking SignOut is Displayed on Hamburger Menu or Not'
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/SignOut/SignOut Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    false) {
        System.out.println('SignOut is not Displayed in Hamburger Menu, So SignOut Test Cases cannot be verified')
    } else {
        System.out.println('SignOut is Displayed in Hamburger Menu')

        'Clicking on the SignOut Menu'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/SignOut/SignOut Menu'), 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking On Yes Button'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/SignOut/SignOut Yes Button'), 5, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.delay(2)
		
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin/Register Now Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        true) {
            System.out.println('Register Now Button is displayed that means user is signout from the application')
        } else {
            System.out.println('Register Now Button is not displayed, something went wrong please check manually.')
        }
    }
}