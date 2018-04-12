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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter.DateTime
'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 10 Sec'
Mobile.delay(10)
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
		
				'TC==> TC_COM_05'
			
			messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Connect Me/Service Account Number'), 'text',
				                5, FailureHandling.CONTINUE_ON_FAILURE)
				
				            'Checking SAN is matching with the EDefault SAN'
				            if (messageText.equals(GlobalVariable.sDefaultSAN)) {
				                System.out.println('SAN Matching Successfully')
				            } 
							else {
				                System.out.println((('SAN is not matching with the Expected Text, Expected Text is : ' +
				                    GlobalVariable.sDefaultSAN) + ' but Actual Text is ') + messageText)
				            }
			
			'TC --> TC_COM_03 -->To verify the correct Customer Name is displayed in the CN field which is same as User name.'
			
			applicationMethods.ReusableMethods.verifyAttribute('SCM Mobile/Connect Me/Customer Name', "text", "John  Doe")
			'Succesful Submit of Connect Me Request'
			'TC_COM_15'
			'Entering Email Address'
			Mobile.setText(findTestObject('SCM Mobile/Connect Me/Email Address'), GlobalVariable.sEnrollEmailEfficiency, 3)
			'Entering Subject'
			Mobile.setText(findTestObject('SCM Mobile/Connect Me/Subject'), GlobalVariable.sEnrollSubjectEfficiency, 3)
			'Hide KeyBoard'
			Mobile.hideKeyboard()
			'Entering Comments'
			Mobile.setText(findTestObject('SCM Mobile/Connect Me/Comments'), GlobalVariable.sEnrollCommenctsEfficiency, 3)
			'Hide KeyBoard'
			Mobile.hideKeyboard()
				'Submit Enrollment Form'
			Mobile.tap(findTestObject('SCM Mobile/Connect Me/Connect Me Submit Button'), 15)
			
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sProblemSignInText)) {
		System.out.println('Connect Me Request submit successfully.')

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println((('Something bad happened on the sending Request. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sProblemSignInText) + ' but Actual text is ') + messageText)

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack()

		Mobile.delay(1)
	}
		
	'TC_COM_06'	
	'Clicking on Topic Connect Me '
	Mobile.tap(findTestObject('SCM Mobile/Connect Me/TopicSelectionDropDown'), 3, FailureHandling.STOP_ON_FAILURE)

	Mobile.tap(findTestObject('SCM Mobile/Connect Me/BillingTopicConnectMe'),
		3, FailureHandling.CONTINUE_ON_FAILURE)
	
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Connect Me/Date',
		'Connect Me- Date')
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Connect Me/Date'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
//	String mydate = new Date()
//	String formattedDate = mydate.format(“MM/dd/yyyy”)
	// Create object of SimpleDateFormat class and decide the format
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	
	//get current date time with Date()
	Date date = new Date();
	
	// Now format the date
	String date1= dateFormat.format(date);
	
	// Print the Date
	System.out.println(date1);

		if (messageText.equals(date1)) {
			System.out.println('Date is Current Date')
		}

        } 
		else 
		{
            System.out.println('Date is not as current and Expected. Please check manually. ')
        }
		
    } 
	//End of Module Connect Me
	else
 		{
        println('The webelement Connect me is missing')
		 }
	
}
