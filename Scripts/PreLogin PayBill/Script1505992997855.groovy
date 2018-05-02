import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import java.util.logging.Logger as Logger
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

'Starting the Application'
applicationMethods.ReusableMethods.startApplication()

'Delay of 30 Sec'
Mobile.delay(30)

@com.kms.katalon.core.annotation.TearDown
static void verifyPreLoginPayBillTestCases() {
    'TC : TC_PB_1, TC_PB_2, TC_PB_4, TC_PB_5 To verify that PreLogin PayBill TestCases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin PayBill/Pay Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        'Clicking on PreLogin PayBill'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Pay Bill Menu'), 5)

        'Delay of 5 seconds'
        Mobile.delay(5)

        'Check Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        if (messageText.equals('Pay Bill')) {
            System.out.println('On Click on PreLogin Pay Bill, User is routing to the PayBill Module')

            'Checking Pay Bill Page Objects'
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/OTP Welcome Header', 
                'OTP Welcome Header')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/OTP Informational Text 1', 
                'OTP Informational Text 1')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Account Number Heading', 
                'Account Number Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Account Number TextBox', 
                'Account Number TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Primary Contact Number Heading', 
                'Primary Contact Number Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Primary Contact Number TextBox', 
                'Primary Contact Number TextBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Visa Card Image', 'Visa Card Image')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Discover Card Image', 
                'Discover Card Image')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Master Card Image', 
                'Master Card Image')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/American Express Card Image', 
                'American Express Card Image')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/OTP Informational Text 2', 
                'OTP Informational Text 2')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/I Agree CheckBox', 
                'I Agree CheckBox')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/I Agree Text', 'I Agree Text')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin PayBill/Next Button', 'Next Button')

            'TC :TC_PB_1 :On entering correct pair of Customer A/C number and Primary Contact Number’, user should select the T&C to move to Next Screen'

            'Entering the Account Number'
            Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Account Number TextBox'), GlobalVariable.sCustomerAccountNumber, 
                4)

            'Entering the Mobile Number'
            Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Primary Contact Number TextBox'), GlobalVariable.sCustomerMobileNumber, 
                4)

            Mobile.hideKeyboard()

            'Clicking on Next Button without accepting Terms and Conditions'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Next Button'), 5)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Checkin T&C Message Text is matching with the Expeced Text or Not'
            if (messageText.equals('Please accept Terms & Conditions.')) {
                System.out.println('User should have to select the T&C to make the payment')
            } else {
                System.out.println('T&C Message Text is not matching with the Expected Text, Expected Text is : Please accept Terms & Conditions. but Actual Text is ' + 
                    messageText)
            }
            
            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3)

            'Now Accept the T&C CheckBox'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/I Agree CheckBox'), 2)

            'Clicking on Next Button after accepting Terms and Conditions'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Next Button'), 5)
				
        } else {
            System.out.println('On Click on PreLogin Pay Bill, user might route to the PayBill Module or something issue with the Module Name. Expected Module Name is : PayBill. Please check manually. ')
        }
		
		verifyOneTimePaymentCreditCardTestCases()
		verifyOneTimePaymentBankAccountTestCases()
    } else {
        System.out.println('One Time Payment TestCases cannot be verified because Pay Bill is not displayed on PreLogin ')
    }
}

'TC_PB_8 TC_PB_15 TC_PB_32 One Time Payment'
static void verifyOneTimePaymentCreditCardTestCases()
{

'Delay of 5 seconds'
Mobile.delay(5)
 
'Clicking on Make Payment Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Make Payment Button'), 3)
 
'Delay of 5 seconds'
Mobile.delay(5)
 
'Entering Bill Amount'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Enter Amount TextBox'), '1', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Entering Card Holder Name'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Name On Credit Card TextBox'), 'Test Card Holder', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Entering Card Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Number'), '5454545454545454', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Clicking on Card Expiry Date Calendar'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Expiry Calendar'), 3)
 
'Clicking Card Expiry Year Ok Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Calendar Ok Button'), 3)
 
'Entering Credit Card Security Code'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Credit Card Security Code TextBox'), '123', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()
 
'Clicking on PayBill Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/PayBill Button'), 10)
 
'Delay of 40 Sec'
Mobile.delay(20)
 
'Getting Payment Successful Text'
String messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Payment Successful Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Getting Payment Transaction Id'
String transactionId = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Transaction Id Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Verifying One Time Payment is Successfully Done or Not'
if (messageText.equals(null)) {
	System.out.println('Something went wrong with One Time Payment, Please check manually')
} else {
	if (messageText.equals('Payment Successful!')) {
		System.out.println('One Time Payment Successful, Transaction Id is : ' + transactionId)
	} else {
		System.out.println((('One Time Payment Successful, Transaction Id is : ' + transactionId) + 'Expected Text, Expected Text is : "Payment Successful!" but Actual Text is ') +
			messageText)
	}
}
 
'Clicking on Ok'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Ok Button'), 5)
}
'TC_PB_9 TC_PB_10 TC_PB_14 TC_PB_33'
static void verifyOneTimePaymentBankAccountTestCases()
{
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

'Clicking on Pay Bill Menu'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/PayBillMenu'), 5)

'Delay of 5 seconds'
Mobile.delay(5)

'Entering Customer Account Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Customer Account Number TextBox'), GlobalVariable.sUtilityAccountNumber, 3)

'Delay of 5 seconds'
Mobile.delay(5)

'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Delay of 2 seconds'
Mobile.delay(2)

 'Entering Customer Mobile Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Customer Mobile Number TextBox'), GlobalVariable.sCustomerMobileNumber, 3)

'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Delay of 2 seconds'
Mobile.delay(2)

'Selecting the Agree CheckBox'
Mobile.checkElement(findTestObject('SCM Mobile/PreLogin PayBill/Agree CheckBox'), 3)

'Delay of 2 seconds'
Mobile.delay(2)

'Clicking on Next Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Next Button'), 3)

'Delay of 5 seconds'
Mobile.delay(5)
 
'Clicking on Make Payment Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Make Payment Button'), 3)
 
'Delay of 5 seconds'
Mobile.delay(5)
 
'Entering Bill Amount'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/Enter Amount TextBox'), '1', 3)
 
'Clicking on the Keyboard Ok Button'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 5)
Mobile.pressBack()

'Bharti'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/btnBankAccountOptionOTP'), 3)

'Entering CBank Account Holder Name'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/txtBoxAccountHolderName'), 'John', 3)
Mobile.pressBack()
'Delay of 5 seconds'
Mobile.delay(5)
'Entering Routing Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/txtBoxRoutingNumber'), '999999999', 3)
Mobile.pressBack()
'Delay of 5 seconds'
Mobile.delay(5)
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/btnRoutingValidate'), 3)
'Delay of 5 seconds'
Mobile.delay(5)
'Entering Account Number'
Mobile.setText(findTestObject('SCM Mobile/PreLogin PayBill/txtBoxBankAccountNumber'), '999999999', 3)
Mobile.pressBack()

'Clicking on PayBill Button'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/btnPayBill'), 10)
 
'Delay of 40 Sec'
Mobile.delay(20)
 
'Getting Payment Successful Text'
String messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Payment Successful Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Getting Payment Transaction Id'
String transactionId = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin PayBill/Transaction Id Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
 
'Verifying One Time Payment is SuccesverifyOneTimePaymentCreditCardTestCasessfully Done or Not'
if (messageText.equals(null)) {
	System.out.println('Something went wrong with One Time Payment, Please check manually')
} else {
	if (messageText.equals('Payment Successful!')) {
		System.out.println('One Time Payment Successful, Transaction Id is : ' + transactionId)
	} else {
		System.out.println((('One Time Payment Successful, Transaction Id is : ' + transactionId) + 'Expected Text, Expected Text is : "Payment Successful!" but Actual Text is ') +
			messageText)
	}
}
 
'Clicking on Ok'
Mobile.tap(findTestObject('SCM Mobile/PreLogin PayBill/Ok Button'), 5)
}