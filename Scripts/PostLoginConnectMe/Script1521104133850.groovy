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

'Delay of 30 Sec'
Mobile.delay(30)
//
@com.kms.katalon.core.annotation.TearDown
static void verifyConnectMeTestCases() {
    boolean bElementVisible = Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/ConnectMe Menu'), 2, FailureHandling.CONTINUE_ON_FAILURE)

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (bElementVisible.equals(true)) {
        Mobile.tap(findTestObject('SCM Mobile/LandingPage/ConnectMe Menu'), 2)

        'Check Module Name'
        String messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        'TC --> TC_COM_01 -->To verify Connect Me Objects'
        if (messageText.equals('Connect Me')) {
            System.out.println('On Click on Connect me from the My Account Tab, User is routing to the Connect me Module')

            'TC --> TC_COM_02 -->To verify Connect Me Objects'
		
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Connect Me Submit Button', 
                'Connect Me- Submint Button')
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Customer Name', 
                'Connect Me- customer name')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Service Account Number',
				'Connect Me- SAN')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Subject',
				'Connect Me- Subject')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Email Address',
				'Connect Me- Email Address')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Comments',
				'Connect Me- Comments')
			
			
			'TC --> TC_COM_03 -->To verify the correct Customer Name/Business Name(in case of commercial) is displayed for Customer Name/Business Name(in case of commercial) field which is same as User name.'
			
			applicationMethods.ReusableMethods.verifyAttribute('SCM Mobile/Connect Me/Customer Name', "text", "John  Doe")
			
        } else {
            System.out.println('On Click on Connect Me from the My Account Tab, user might route to the Connect Me Module or something issue with the Module Name. Expected Module Name is : Marketing Preferences. Please check manually. ')
        }
    } else {
        println('The webelement Connect me is missing')
    }
	
	//Added  by Bharti
}

