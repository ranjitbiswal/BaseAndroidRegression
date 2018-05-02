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

@com.kms.katalon.core.annotation.TearDown
static void verifyMyAccountTestCases() {
	'TC : TC_MMP_1, TC_MMP_2, TC_MAP_2 To verify that My Acccount Tab'

	'Checking My Account Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('My Account is not displayed in the Dashboard/Landing Page')
	} else {
		System.out.println('My Account is displayed on the Dashboard/Landing Page')

		'Clicking on My Account Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 10)

		'TC --> TC_MAP_2 -->To verify My Account Objects'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/My Account - Profile Menu',
				'My Account - Profile Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/My Account - Guest User Menu',
				'My Account - Guest User Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/My Account - About My Business Menu',
				'My Account - About My Business Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Payment Information Menu',
				'Payment Information Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/My Account - Marketing Preferences Menu',
				'My Account - Marketing Preferences Menu')

		'Checking for My Account Profile Tab'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		false) {
			System.out.println('My Account -My Account - Profile Menu is not displayed in the My Account Tab, So My Account - Profile Test cases cannot be verified.')
		} else {
			System.out.println('My Account - Profile Menu is displayed on the My Account Tab.')

			'Verifying My Account - Profile Test Cases'
			verifyMyAccountProfileTestCases()
		}

		'Checking for My Account Marketing Preferences Tab'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Marketing Preferences/My Account - Marketing Preferences Menu'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
			System.out.println('My Account - Marketing Preferences Menu is not displayed in the My Account Tab, So Marketing Preferences Test cases cannot be verified.')
		} else {
			System.out.println('My Account - Marketing Preferences Menu is displayed on the My Account Tab.')

			'Verifying Marketing Preferences Test Cases'
			'verifyMyAccountMarketingPreferencesTestCases()'
		}

		'Checking for My Account Payment Information Tab'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Payment Information/Payment Information Menu'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
			System.out.println('My Account - Payment Information Menu is not displayed in the My Account Tab, So Payment Information Test cases cannot be verified.')
		} else {
			System.out.println('My Account - Payment Information Menu is displayed on the My Account Tab.')

			'Verifying Payment Information Test Cases'
			verifyMyAccountPaymentInformationTestCases()
		}

		verifyMyAccountGuestUserTestCases()
	}
}

static void verifyMyAccountMarketingPreferencesTestCases() {
	'TC : TC_MMP_1, TC_MMP_2, TC_MMP_4 To verify that My Acccount Marketing Preferences Tab and page objects'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	Boolean bResult

	Boolean bResult1

	'Clicking on Marketing Preferences from My Account Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Marketing Preferences/My Account - Marketing Preferences Menu'), 3,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Check Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('Marketing Preferences')) {
		System.out.println('On Click on Marketing Preferences from the My Account Tab, User is routing to the Marketing Preferences Module')
	} else {
		System.out.println('On Click on Marketing Preferences from the My Account Tab, user might route to the Marketing Preferences Module or something issue with the Module Name. Expected Module Name is : Marketing Preferences. Please check manually. ')
	}

	'Check Objects on the Marketing Preferences Modules'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Marketing Preferences Message Text',
			'Marketing Preferences Message Text')

	'Check for Marketing Preferences List'

	'Checking for the Community Benefit Programs Marketing Preferences'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Community Benefit Programs Marketing Preferences',
			'Community Benefit Programs Marketing Preferences')

	'Checking for the Community Benefit Programs Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Community Benefit Programs Marketing Preferences',
			'Community Benefit Programs Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/Community Benefit Programs Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Community Benefit Programs Marketing Preferences is selected')
	} else {
		System.out.println('Community Benefit Programs Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Cool Tips Brochures Marketing Preferences',
			'Cool Tips Brochures Marketing Preferences')

	'Checking for the Cool Tips Brochures Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Cool Tips Brochures Marketing Preferences',
			'Cool Tips Brochures Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/Cool Tips Brochures Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Cool Tips Brochures Marketing Preferences is selected')
	} else {
		System.out.println('Cool Tips Brochures Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Energy Savings Toolkits Marketing Preferences',
			'Energy Savings Toolkits Marketing Preferences')

	'Checking for the Energy Savings Toolkits Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Energy Savings Toolkits Marketing Preferences',
			'Energy Savings Toolkits Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/Energy Savings Toolkits Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Energy Savings Toolkits Marketing Preferences is selected')
	} else {
		System.out.println('Energy Savings Toolkits Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/News Releases Marketing Preferences',
			'News Releases Marketing Preferences')

	'Checking for the News Releases Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/News Releases Marketing Preferences',
			'News Releases Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/News Releases Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('News Releases Marketing Preferences is selected')
	} else {
		System.out.println('News Releases Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Newsletters Marketing Preferences',
			'Newsletters Marketing Preferences')

	'Checking for the Newsletters Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Newsletters Marketing Preferences',
			'Newsletters Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/Newsletters Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Newsletters Marketing Preferences is selected')
	} else {
		System.out.println('Newsletters Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Service Offerings Marketing Preferences',
			'Service Offerings Marketing Preferences')

	'Checking for the Service Offerings Marketing Preferences CheckBox'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Service Offerings Marketing Preferences',
			'Service Offerings Marketing Preferences CompoundButton')

	if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Marketing Preferences/Service Offerings Marketing Preferences CompoundButton'),
	'checked', 15, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Service Offerings Marketing Preferences is selected')
	} else {
		System.out.println('Service Offerings Marketing Preferences is not selected')
	}

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Marketing Preferences/Marketing Preferences Submit Button',
			'Marketing Preferences Submit Button')

	'Clicking on the Back Button'
	Mobile.pressBack()

	'Delay'
	Mobile.delay(10)
}

static void verifyMyAccountPaymentInformationTestCases() {
	'TC : TC_MAPI_11 To verify that My Acccount Payment Information Tab'
	String messageText

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Clicking on Payment Information from My Account Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Payment Information Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(3)

	'Check Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('Payment Information')) {
		System.out.println('On Click on Payment Information from the My Account Tab, User is routing to the Payment Information Module')
	} else {
		System.out.println('On Click on Payment Information from the My Account Tab, user might route to the Payment Information Module or something issue with the Module Name. Expected Module Name is : Payment Information. Please check manually. ')
	}

	'Clicking on Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Add Payment Method Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Checking for Credit Card Tab'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Heading'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Credit Card option is not displayed in the Add Payment Mode Tab, So Credit Card Test cases cannot be verified.')
	} else {
		System.out.println('Credit Card option is displayed in the Add Payment Mode Tab.')

		'Verifying Credit Card Test Cases'
		verifyMyAccountPaymentInformationCreditCardTestCases()
	}

	'Checking for Bank Account Tab'
	'Clicking on Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Add Payment Method Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHeading'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Bank Account option is not displayed in the Add Payment Mode Tab, So Bank Account Test cases cannot be verified.')
	} else {
		System.out.println('Bank Account option is displayed in the Add Payment Mode Tab.')

		'Verifying Bank Account Test Cases'
		verifyMyAccountPaymentInformationBankAccountTestCases()
	}
}

static void verifyMyAccountPaymentInformationBankAccountTestCases() {
	'TC : TC_MAPI_12, TC_MAPI_20, TC_MAPI_37 To verify that Payment Information Bank Account Tab & its page objects , Add Bank Account, Delete Bank Account, Update Bank Account'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Bank Acccount Tab'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHeading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Verifying Bank Account Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHeading',
			'BankAccount Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Heading',
			'Credit Card Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountAddButton',
			'BankAccount Add Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHolderNameLabel',
			'BankAccountHolderName Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHolderNameTextBox',
			'BankAccountHolderName TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountNumberLabel',
			'BankAccountNumber Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountNumberTextBox',
			'BankAccountNumber TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountRoutingNumberLabel',
			'BankAccount RoutingNumber Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountRoutingNumberTextBox',
			'BankAccount RoutingNumber TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountRoutingNumberValidationButton',
			'BankAccount RoutingNumber Validation Button')

	'Adding a Bank Account'

	'Entering the Bank Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHolderNameTextBox'),
			GlobalVariable.sCardHolderName, 4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Routing Number'
	MobileElement meRoutingNumber = driver.findElementById('com.sus.scm_mobile:id/et_routingnumber')

	meRoutingNumber.sendKeys(GlobalVariable.sRoutingNumber)

	'Clicking on BankAccount RoutingNumber Validation Button'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountRoutingNumberValidationButton'),
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Account Number'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountNumberTextBox'), GlobalVariable.sBankAccountNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)
	'Click on Back to Hide Keyboard'
	Mobile.pressBack()
	'Clicking on Add Bank Account Button'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountAddButton'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	'Clicking on Popup Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.pressBack()
	Mobile.delay(1)


	'Update Bank Account'
	List<MobileElement> meCreditCardRadio = driver.findElementsByClassName('android.widget.RadioButton')

	if (meCreditCardRadio.size > 0) {
		'Clicking on the first Bank from the list'

		Mobile.tapAndHold(findTestObject('SCM Mobile/My Account/Payment Information/expDateDetailsCreditCardList'), 0, 0,
				FailureHandling.CONTINUE_ON_FAILURE)

		'Clicking on Popup Update button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Popup Update Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)
		'Clicking on the Update Button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Update Card Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

		if (messageText.equals(GlobalVariable.sCreditCardUpdateMessageText)) {
			System.out.println('Credit Card Updated Successfully and Popup message text is as expected.')

			'Clicking on Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.pressBack()
			Mobile.delay(1)
		} else {
			System.out.println((('Something bad happened on the updating the Credit Card. Please check manually. Expected Popup message text is ' +
					GlobalVariable.sCreditCardUpdateMessageText) + ' but Actual text is ') + messageText)

			'Clicking on Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

			Mobile.pressBack()
			Mobile.delay(1)

		}
	}
	''
	'TC_MAPI_43 Delete the Bank Account'
	Mobile.tapAndHold(findTestObject('SCM Mobile/My Account/Payment Information/routingNumDetailsBankAccList'), 0, 0)

	'Clicking on Popup Delete button'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/btnDltCreditCardPaymentInfo'),
			3, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/btnYesPopUpDltCreditCardPaymentInfo'),
			3, FailureHandling.CONTINUE_ON_FAILURE)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sLblTxtNonDltEnrolledCreditCard)) {
		System.out.println(GlobalVariable.sLblTxtNonDltEnrolledCreditCard)
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	} else {
		System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sLblTxtNonDltEnrolledCreditCard) + 'but Actual Text is ') + messageText)
	}

}

static void verifyMyAccountPaymentInformationCreditCardTestCases() {
	'TC : TC_MAPI_28, TC_MAPI_29 To verify that Payment Information Credit Card Tab & its page objects , Add Credit Card, Delete Credit Card, Update Credit Card'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	//TouchAction action = new TouchAction(driver)

	String messageText

	'Clicking on Credit Card Tab'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Verifying Credit Card Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/VisaCardImage',
			'Visa Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/MasterCardImage',
			'Master Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/AmercianExpressCardImage',
			'Amercian Express Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/DiscoverCardImage',
			'Discover Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Bank Account/BankAccountHeading',
			'BankAccount Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Card Holder Name Label',
			'Card Holder Name Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Card Holder Name',
			'Card Holder Name')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Number Label',
			'Credit Card Number Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Number',
			'Credit Card Number')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Card Expiry Date Label',
			'Card Expiry Date Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Card Security Code Label',
			'Card Security Code Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Card Security Code',
			'Card Security Code')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/CreditCardAddButton',
			'Credit Card Add Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/CreditCardScannerButton',
			'Credit Card Scanner Button')

	'Checking the Default Month and Year on the Credit Card Expiry Date Calendar'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Calendar Icon'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == true) {



		'Checking the Default Month and Date on the System Calendar'
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault())

		int iYear = calendar.get(Calendar.YEAR)

		System.out.println(('Today Int: ' + iYear) + '\n')

		String sYear = iYear.toString()

		int iMonth = calendar.get(Calendar.MONTH)

		System.out.println(('Today Int: ' + iMonth) + '\n')

		String sMonth = null

		if (iMonth == 0) {
			sMonth = 'Jan'
		} else if (iMonth == 1) {
			sMonth = 'Feb'
		} else if (iMonth == 1) {
			sMonth = 'Feb'
		} else if (iMonth == 2) {
			sMonth = 'Mar'
		} else if (iMonth == 3) {
			sMonth = 'Apr'
		} else if (iMonth == 4) {
			sMonth = 'May'
		} else if (iMonth == 5) {
			sMonth = 'Jun'
		} else if (iMonth == 6) {
			sMonth = 'Jul'
		} else if (iMonth == 7) {
			sMonth = 'Aug'
		} else if (iMonth == 8) {
			sMonth = 'Sep'
		} else if (iMonth == 9) {
			sMonth = 'Oct'
		} else if (iMonth == 10) {
			sMonth = 'Nov'
		} else if (iMonth == 11) {
			sMonth = 'Dec'
		} else {
			System.out.println('Some Issue with the Current Month, please verify manually')
		}

		'Clicking on Calendar'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking the Default Month and Year on the Credit Card Expiry Date Calendar'
		String sMonthFromCreditCardCalendar = driver.findElementByXPath('//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.EditText[1]').getText()

		String sYearFromCreditCardCalendar = driver.findElementByXPath('//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]/android.widget.EditText[1]').getText()

		if (sMonth.equals(sMonthFromCreditCardCalendar)) {
			System.out.println('On Credit Card Calendar By Default Selected Month is current Month')
		} else {
			System.out.println('On Credit Card Calendar By Default Selected Month is not current Month . Please check manually')
		}

		if (sYear.equals(sYearFromCreditCardCalendar)) {
			System.out.println('On Credit Card Calendar By Default Selected Year is current Year ')
		} else {
			System.out.println('On Credit Card Calendar By Default Selected year is not current year. Please check manually')
		}

		'Clicking on Calendar Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Calendar Date Selection Ok Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println('Credit Card Expiry Date Calendar is not displayed so we are unable to check the Calendar test cases.')
	}

	'Adding New Credit Card'

	'Entering the Credit Card Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Card Holder Name'), GlobalVariable.sCardHolderName,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Credit Card  Number'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Credit Card Number'), GlobalVariable.sCardNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Calendar Date Selection Ok Button'),
			3, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the card security code'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Card Security Code'), '123', 4,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Click on Back to Hide Keyboard'
	Mobile.pressBack()

	'Clicking on Add Credit Card Button'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/CreditCardAddButton'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sCreditCardAddMessageText)) {
		System.out.println('Credit Card Added Successfully and Popup message text is as expected.')

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println((('Something bad happened on the adding the Credit Card. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sCreditCardAddMessageText) + ' but Actual text is ') + messageText)

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack()

		Mobile.delay(1)
	}

	'TC : TC_MAPI_40 : Editing a Credit Card'
	List<MobileElement> meCreditCardRadio = driver.findElementsByClassName('android.widget.RadioButton')

	if (meCreditCardRadio.size > 0) {
		'Clicking on the first card from the list'


		Mobile.tapAndHold(findTestObject('SCM Mobile/My Account/Payment Information/expDateDetailsCreditCardList'), 0, 0,
				FailureHandling.CONTINUE_ON_FAILURE)

		'Clicking on Popup Update button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Popup Update Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Card Holder Name'),
		'enabled', 0).equals('true')) {
			System.out.println('Card Holder Name is editable')

			messageText = Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Card Holder Name'),
					'text', 0)

			if (messageText.equals('Null')) {
				System.out.println('Card Holder Name is not PrePopulated, Please raise the issue for that')
			} else {
				System.out.println('Card Holder Name is PrePopulated, which is as expected')
			}
		} else {
			System.out.println('Card Holder Name should be editable')
		}

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Card Number TextBox'),
		'enabled', 0).equals('false')) {
			System.out.println('Card Number is in read only mode, which is as expected')
		} else {
			System.out.println('Card Number is editable, which is against the requirement')
		}

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Card Number TextBox'),
		'enabled', 0).equals('false')) {
			System.out.println('Card Number is in readonly mode, which is as expected')
		} else {
			System.out.println('Card Number is editable, which is against the requirement')
		}

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Security Code TextBox'),
		'enabled', 0).equals('false')) {
			System.out.println('Security Code TextBox is in readonly mode, which is as expected')
		} else {
			System.out.println('Security Code TextBox is editable, which is against the requirement')
		}

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Calendar'),
		'enabled', 0).equals('false')) {
			System.out.println('Calendar is in readonly mode, which is as expected')
		} else {
			System.out.println('Calendar is editable, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Update Card Button',
				'Update Card Button')

		'TC : TC_MAPI_42 : Updating the Credit Card'

		'Entering the new Card Holder Name'
		Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Card Holder Name'),
				'John Doe New', 4, FailureHandling.CONTINUE_ON_FAILURE)

		'Entering the card security code'
		Mobile.setText(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Card Security Code'), '123', 4,
				FailureHandling.CONTINUE_ON_FAILURE)

		'Clicking on the Update Button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/Edit Credit Card/Update Card Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

		if (messageText.equals(GlobalVariable.sCreditCardUpdateMessageText)) {
			System.out.println('Credit Card Updated Successfully and Popup message text is as expected.')

			'Clicking on Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.pressBack()
			Mobile.delay(1)
		} else {
			System.out.println((('Something bad happened on the updating the Credit Card. Please check manually. Expected Popup message text is ' +
					GlobalVariable.sCreditCardUpdateMessageText) + ' but Actual text is ') + messageText)

			'Clicking on Popup Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

			Mobile.pressBack()
			Mobile.delay(1)

		}

		'TC_MAPI_43 Delete the Credit Card'
		Mobile.tapAndHold(findTestObject('SCM Mobile/My Account/Payment Information/expDateDetailsCreditCardList'), 0, 0)

		'Clicking on Popup Delete button'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/btnDltCreditCardPaymentInfo'),
				3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.tap(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/btnYesPopUpDltCreditCardPaymentInfo'),
				3, FailureHandling.CONTINUE_ON_FAILURE)

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

		if (messageText.equals(GlobalVariable.sLblTxtNConfirmDltEnrolledCreditCard)) {
			System.out.println(GlobalVariable.sLblTxtNConfirmDltEnrolledCreditCard)
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)



		} else {
			System.out.println((('Something bad happened on the Deleting the Settings. Please check manually. Expected Popup message text is ' +
					GlobalVariable.sLblTxtNConfirmDltEnrolledCreditCard) + 'but Actual Text is ') + messageText)
		}
	} else {
		System.out.println('Edit Credit Card test cases cannot be verified because no card is displayed in the list')
	}


}

static void verifyMyAccountProfileTestCases() {
	'TC : TC_MAP_1 To verify that My Acccount Profile Tab'
	String messageText

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Clicking on Profile from My Account Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/My Account - Profile Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(3)

	'Check Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('Profile')) {
		System.out.println('On Click on Profile from the My Account Tab, User is routing to the Profile Module')
	} else {
		System.out.println('On Click on Profile from the My Account Tab, user might route to the Profile Module or something issue with the Module Name. Expected Module Name is : Profile. Please check manually. ')
	}

	'TC_MAP_140 TC_MAP_141 Checking contact types in'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/ddlPrimaryContactType'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryLandlineType',
			'rbtnPrimarySecondaryLandlineType')
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryMobileType',
			'rbtnPrimarySecondaryMobileType')
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryMobileType'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/ddlSecondaryContactType'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryLandlineType',
			'rbtnPrimarySecondaryLandlineType')
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryMobileType',
			'rbtnPrimarySecondaryMobileType')
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/rbtnPrimarySecondaryMobileType'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'TC_MAP_121'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/btnSaveMyAccountProfile'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	String messageText1 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
			5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Text is matching with the Expeced Text or Not'
	if (messageText1.equals(GlobalVariable.sSuccessSaveProfilePopupMessageText)) {
		System.out.println('Updated Successfully')
	} else {
		System.out.println((('Text is not matching with the Expected Text, Expected Text is : ' +
				GlobalVariable.sSuccessSaveProfilePopupMessageText) + ' but Actual Text is ') + messageText1)
	}

	'Clicking on the PopUp Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

	'Delay of 5 seconds'
	Mobile.delay(5)

	' Checking Mailing Address is Displayed or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Mailing Address Heading'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Mailing Address is not displayed in the My Account - Profile Tab, So Mailing Address Test cases cannot be verified.')
	} else {
		System.out.println('Mailing Address is displayed on the My Account - Profile Tab.')

		'Verifying MyAccount Profile Mailing Address Test Cases'
		verifyMyAccountProfileMailingAddressTestCases()
	}

	'TC_MAP_79 TC_MAP_80 checking Property Address Displayed or not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Mailing Address Heading'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Property Address is not displayed in the My Account - Profile Tab, So Mailing Address Test cases cannot be verified.')
	} else {
		System.out.println('Property Address is displayed on the My Account - Profile Tab.')

		'Verifying MyAccount Profile Property Address Test Cases'
		verifyMyAccountProfilePropertyAddressTestCases()
	}
}
static verifyMyAccountProfilePropertyAddressTestCases(){
	String messageText

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Clicking on Property Address from My Account - Profile Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Property Address/btnEditPropertyAddMyAcc'), 6, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(3)

	'Check Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('My Account')) {
		System.out.println('On Click on Property Address from the My Account - Profile Tab, User is routing to the My Account Module')
	} else {
		System.out.println('On Click on Property Address from the My Account - Profile Tab, user might route to the My Account  Module or something issue with the Module Name. Expected Module Name is :Edit Mailing Address. Please check manually. ')
	}

	'Checking Link Account Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Property Address/btnLinkAccount',
			'btnLinkAccount')
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Property Address/btnLinkAccount'), 6, FailureHandling.CONTINUE_ON_FAILURE)
	''
	'Entering First Name'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Property Address/txtFirstNameLinkAccount'), 'BHarti', 4,
			FailureHandling.CONTINUE_ON_FAILURE)
	'Hide KeyBoard'
	Mobile.hideKeyboard()

	'Entering Account Number'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Property Address/txtAccountNumLinkAccount'), 'C002002003', 4,
			FailureHandling.CONTINUE_ON_FAILURE)
	'Hide KeyBoard'
	Mobile.hideKeyboard()

	'Entering Last Name'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Property Address/txtLastNameLinkAccount'), 'LastN', 4,
			FailureHandling.CONTINUE_ON_FAILURE)
	'Hide KeyBoard'
	Mobile.hideKeyboard()

	'Entering Zip COde'
	Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Property Address/txtZipCodeLinkAccount'), '92602', 4,
			FailureHandling.CONTINUE_ON_FAILURE)
	'Hide KeyBoard'
	Mobile.hideKeyboard()
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Property Address/btnSubmitLinkAccount'), 6, FailureHandling.CONTINUE_ON_FAILURE)
	String messageText4 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
			5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Text is matching with the Expeced Text or Not'
	if (messageText4.equals(GlobalVariable.sAlreadyRegisteredAccPopupMessageText)) {
		System.out.println('Correct Message')
	} else {
		System.out.println((('Text is not matching with the Expected Text, Expected Text is : ' +
				GlobalVariable.sAlreadyRegisteredAccPopupMessageText) + ' but Actual Text is ') + messageText4)
	}

	'Clicking on the PopUp Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

	'Delay of 5 seconds'
	Mobile.delay(5)
	''
}
static void verifyMyAccountProfileMailingAddressTestCases() {
	'TC : TC_MAP_100,TC_MAP_101 To verify that MailingAddress Test Cases from My Acccount - Profile Tab'
	String messageText

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Clicking on MailingAddress from My Account - Profile Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Mailing Address Edit Button'), 6, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(3)

	'Check Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/title').getText()

	if (messageText.equals('Edit Mailing Address')) {
		System.out.println('On Click on Mailing Address from the My Account - Profile Tab, User is routing to the Mailing Address Module')
	} else {
		System.out.println('On Click on Mailing Address from the My Account - Profile Tab, user might route to the Mailing Address Module or something issue with the Module Name. Expected Module Name is :Edit Mailing Address. Please check manually. ')
	}

	'Checking Mailing Address Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 1 Heading',
			'Street Address Line 1 Heading')

	Mobile.hideKeyboard()

	'Checking Street Address Test Cases'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Radio Button'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Street Address Radio Button is not displayed, so we are unable to verify the Street Address Test Cases')
	} else {
		System.out.println('Street Address Radio Button is displayed.')

		Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Radio Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 1 TextBox'),
		'enabled', 1, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
			System.out.println('Street Address Line 1 TextBox is editable, which is as expected')
		} else {
			System.out.println('Street Address Line 1 TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 2 Heading',
				'Street Address Line 2 Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 2 TextBox'),
		'enabled', 1).equals('true')) {
			System.out.println('Street Address Line 2 TextBox is editable, which is as expected')
		} else {
			System.out.println('Street Address Line 2 TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Street City Heading',
				'Street City Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street City TextBox'), 'enabled',
		1).equals('true')) {
			System.out.println('Street City TextBox is editable, which is as expected')
		} else {
			System.out.println('Street City TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Street State Heading',
				'Street State Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street State TextBox'), 'enabled',
		0).equals('true')) {
			System.out.println('Street State TextBox is editable, which is as expected')
		} else {
			System.out.println('Street State TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Street ZipCode Heading',
				'Street ZipCode Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street ZipCode TextBox'),
		'enabled', 1).equals('true')) {
			System.out.println('Street ZipCode TextBox is editable, which is as expected')
		} else {
			System.out.println('Street ZipCode TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Update Button',
				'Update Button')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Validate Button',
				'Validate Button')

		'TC_MAP_114 TC_MAP_116 Updating the Street Address'
		'Entering Address 1'
		Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 1 TextBox'), 'Address 1', 4,
				FailureHandling.CONTINUE_ON_FAILURE)
		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Entering Address 2'
		Mobile.setText(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Street Address Line 2 TextBox'), 'Address 2', 4,
				FailureHandling.CONTINUE_ON_FAILURE)
		'Hide KeyBoard'
		Mobile.hideKeyboard()

		'Validate'
		Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Validate Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		String messageText2 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
				5, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking Text is matching with the Expeced Text or Not'
		if (messageText2.equals(GlobalVariable.sMessageIsValidPopupMessageText)) {
			System.out.println('Address is Valid')
			'Clicking on the PopUp Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
			'Update Button'
			Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/Update Button'), 15)

			'Verify Update Success Message'
			String messageText4 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
					5, FailureHandling.CONTINUE_ON_FAILURE)
			if (messageText4.equals(GlobalVariable.sMessageSuccessUpdatePopupMessageText)) {
				System.out.println('Address is Valid')
				'Clicking on the PopUp Ok Button'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
			}
			else
			{
				println "Some other message is on"
				'Clicking on the PopUp Ok Button'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
			}

		} else {
			System.out.println('Address is Invalid')
			'Clicking on the PopUp Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

		}



	}

	'Checking P.O Box Test Cases'

	'TC : TC_MAP_109 To verify that MailingAddress Test Cases from My Acccount - Profile Tab'

	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O. Box Radio Button'),
	3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('P.O. Box Radio Button is not displayed, so we are unable to verify the Street Address Test Cases')
	} else {
		System.out.println('P.O. Box Radio Button is displayed.')

		Mobile.tap(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O. Box Radio Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box Heading',
				'P.O.Box Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box TextBox'),
		'enabled', 1, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
			System.out.println('P.O.Box TextBox is editable, which is as expected')
		} else {
			System.out.println('P.O.Box TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box ZipCode Heading',
				'P.O.Box ZipCode Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box ZipCode TextBox'),
		'enabled', 1).equals('true')) {
			System.out.println('P.O.Box ZipCode TextBox is editable, which is as expected')
		} else {
			System.out.println('P.O.Box ZipCode TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box State Heading',
				'P.O.Box State Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box State TextBox'), 'enabled',
		1).equals('true')) {
			System.out.println('P.O.Box State TextBox is editable, which is as expected')
		} else {
			System.out.println('P.O.Box State TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box City Heading',
				'P.O.Box City Heading')

		if (Mobile.getAttribute(findTestObject('SCM Mobile/My Account/Profile/Mailing Address/P.O.Box City TextBox'), 'enabled',
		0).equals('true')) {
			System.out.println('P.O.Box City TextBox is editable, which is as expected')
		} else {
			System.out.println('P.O.Box City TextBox is readonly mode, which is against the requirement')
		}

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Update Button',
				'Update Button')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/Profile/Mailing Address/Validate Button',
				'Validate Button')
	}
}

static void verifyMyAccountGuestUserTestCases()
{
	'TC : '
	String messageText

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Clicking on Guest User from My Account Menu'
	Mobile.tap(findTestObject('SCM Mobile/My Account/My Account - Guest User Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(3)
	'Check Module Name'
	//	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
	//
	//	if (messageText.equals('Guest USer')) {
	//		System.out.println('On Click on Guest USer from the My Account Tab, User is routing to the Guest USer Module')
	//	} else {
	//		System.out.println('On Click on Guest USer from the My Account Tab, user might route to the PGuest USer Module or something issue with the Module Name. Expected Module Name is : Payment Information. Please check manually. ')
	//	}

	'Getting Guest users in the List'
	ArrayList<MobileElement> lGuestusersList = driver.findElementsById('com.sus.scm_mobile:id/guest_name')

	println(('Number of Guest Users :' + lGuestusersList.size()) - 1)

	'Printing Guest Users List'
	println('Guest Users List Contains :')

	if (lGuestusersList.size() > 1) {

		println(lGuestusersList.get(1).getText())
		lGuestusersList.get(1).click()

		'Delay of 1 seconds'
		Mobile.delay(1)
		'TC_GA_1 TC_PM_1 Verify Objects Displayed for Invited Guest User'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingAccountNumber',
				'lblHeadingAccountNumber')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/txtLblAccountNumber',
				'txtLblAccountNumber')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingInvitedName',
				'lblHeadingInvitedName')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/txtLblInvitedname',
				'txtLblInvitedname')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingEmailAddress',
				'lblHeadingEmailAddress')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/txtLblEmailAddress',
				'txtLblEmailAddress')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingRole',
				'lblHeadingRole')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/txtLblRole',
				'txtLblRole')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingAccountNumber',
				'lblHeadingStatus')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingStatus',
				'lblHeadingStatus')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingRole',
				'lblHeadingInvitationDate')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/txtLblRole',
				'txtLblInvitationdate')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingAccountNumber',
				'lblheadingAccessPeriod')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/lblHeadingStatus',
				'txtLblAccessPeriod')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/btnDeleteInvitation',
				'btnDeleteInvitation')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/My Account/GuestUser/btnInviteUpdateGU',
				'btnInviteUpdateGU')


		'TC_PM_16 TC_PM_17 Update already Invited User'
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnInviteUpdateGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)


		' TC_GA_21 TC_PM_18 TC_PM_31 Revoke Access of Invitee'
		lGuestusersList.get(1).click()
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnDeleteInvitation'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

		'TC_GA_2 TC_PM_7 New Invite User Page Objects Validation'

		'Clicking on New Invite Guest User from My Account Menu'
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnAddGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		'Account Number'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccountNumberNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccountNumberNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/lblOption1AccountNumberNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		'Invitee name'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.setText(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
					'John Doe', 4, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.hideKeyboard()
		}
		'Invitee Email Address'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/txtEmailNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.setText(findTestObject('SCM Mobile/My Account/GuestUser/txtEmailNewGuestUser'),
					'bhafsdfrti.garg@smartenergywater.in', 4, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.hideKeyboard()
		}
		'GU Role'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlRoleNewGuestuser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlRoleNewGuestuser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/lblGuestAccessRoleNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		'Access Period'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccessPeriodNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccessPeriodNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnOkAccessPeriodNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		'TC_GA_10'
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnInviteNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		'Delay'
		Mobile.delay(15)
		String messageText1 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'),
				'text', 15, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking Account Update Message Text is matching with the Expeced Text or Not'
		if (messageText1.equals(GlobalVariable.sSuccessMessageGuestUserAdded)) {
			System.out.println('Valid Successful')
		} else {
			System.out.println('Unsuccessful Invite ' +
					messageText)
		}

		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
		'Delay'
		Mobile.delay(25)

		' TC_GA_26 TC_PM_34 Validate Message of Mnadstory Details to b filled'
		'Clicking on New Invite Guest User from My Account Menu'
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnAddGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnInviteNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		String messageText2 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
				5, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking Text is matching with the Expeced Text or Not'
		if (messageText2.equals(GlobalVariable.sMandatoryFieldPopupMessageText)) {
			System.out.println('Marketing Preferences Updated Successfully')
		} else {
			System.out.println((('Text is not matching with the Expected Text, Expected Text is : ' +
					GlobalVariable.sMandatoryFieldPopupMessageText) + ' but Actual Text is ') + messageText)
		}

		'Clicking on the PopUp Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

		'Delay of 5 seconds'
		Mobile.delay(5)
		'  Validate Message of Mandatory Details to be filled for property Manager'

		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccountNumberNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccountNumberNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/lblOption1AccountNumberNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		//							'Invitee name'
		//							if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
		//								3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
		//							  Mobile.setText(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
		//								  'John Doe', 4, FailureHandling.CONTINUE_ON_FAILURE)
		//							  Mobile.hideKeyboard()
		//							}
		'Invitee Email Address'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/txtEmailNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.setText(findTestObject('SCM Mobile/My Account/GuestUser/txtEmailNewGuestUser'),
					'bhatretrti.garg@smartenergywater.in', 4, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.hideKeyboard()
		}
		'GU Role'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlRoleNewGuestuser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlRoleNewGuestuser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/lblPropertymanagerNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		'Access Period'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccessPeriodNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/ddlAccessPeriodNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnOkAccessPeriodNewGuestUser'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		}
		'TC_PM_35'
		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnInviteNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text',
				5, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking Text is matching with the Expeced Text or Not'
		if (messageText.equals(GlobalVariable.sMandatoryFieldPopupMessageText)) {
			System.out.println('Marketing Preferences Updated Successfully')
		} else {
			System.out.println((('Text is not matching with the Expected Text, Expected Text is : ' +
					GlobalVariable.sMandatoryFieldPopupMessageText) + ' but Actual Text is ') + messageText)
		}

		'Clicking on the PopUp Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

		'Invitee name'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
		3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
			Mobile.setText(findTestObject('SCM Mobile/My Account/GuestUser/txtNameNewGuestUser'),
					'John Doe', 4, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.hideKeyboard()
		}

		Mobile.tap(findTestObject('SCM Mobile/My Account/GuestUser/btnInviteNewGU'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		messageText = Mobile.getAttribute(('SCM Mobile/My Account/GuestUser/txtMessageSuccessfulInvitedGU'),
				'text', 15, FailureHandling.CONTINUE_ON_FAILURE)

		'Checking Account Update Message Text is matching with the Expeced Text or Not'
		if (messageText.equals(GlobalVariable.sSuccessMessageGuestUserAdded)) {
			System.out.println('Valid Successful')
		} else {
			System.out.println('Unsuccessful Invite ' +
					messageText)
		}
		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

	}

}