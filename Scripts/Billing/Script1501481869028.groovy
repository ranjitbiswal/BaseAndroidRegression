import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import org.junit.After as After
import org.openqa.selenium.Dimension as Dimension
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
import io.appium.java_client.TouchAction as TouchAction

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 15 Sec'
Mobile.delay(20)

@com.kms.katalon.core.annotation.TearDown
static void verifyBillingTestCases() {
	'TC : TC_BLG_1, TC_BLG_2, TC_BLG_3 and TC_BLG_11 To verify the Billing Tab'

	'Checking Billing Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('Billing is not displayed in the Dashboard/Landing Page')
	} else {
		System.out.println('Billing is displayed on the Dashboard/Landing Page')

		'Clicking on Billing Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 10)

		'TC --> TC_BLG_1 -->To verify Billing Page Objects'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill Menu', 'Utility Bill Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay Menu', 'Auto Pay Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill Menu', 'Budget My Bill Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/History Menu', 'History Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Level Pay Menu', 'Level Pay Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Rate Analysis Menu', 'Rate Analysis Menu')

		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Auto Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		false) {
			System.out.println('Auto Pay Menu is not displayed in the Billing Menu, So we are unable to verify the Billing Module Payment Test Case')
		} else {
			System.out.println('Auto Pay Menu is displayed in the Billing Menu')

			'Verify Auto Pay Test Cases'
			verifyAutoPayTestCases()
		}
			'Verify Biling History Test Cases'
			verifyBillingHistoryTestCases()
			
			'Verify Budget My Bill Test Cases'
			verifyBudgetMyBillTestCases()
			
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		false) {
			System.out.println('Utility Bill is not displayed in the Billing Menu')
		} else {
			System.out.println('Utility Bill is displayed in the Billing Menu')

			'Clicking on Billing Menu from Dashboard/Landing Page'
			Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill Menu'), 10)

			'TC --> TC_BLG_2, TC_BLG_3, TC_BLG_11 -->To verify Utility Menu Page Objects'

			'Utility Billing Page Objects'
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab',
					'Utility Bill - All Tab')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - Water Tab',
					'Utility Bill - Water Tab')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - Solid Tab',
					'Utility Bill - Solid Tab')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Amount',
					'Utility Bill - All Tab - Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Payment Due Date',
					'Utility Bill - All Tab - Payment Due Date')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Billing Period Heading',
					'Utility Bill - All Tab - Billing Period Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Billing Period Date',
					'Utility Bill - All Tab - Billing Period Date')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Total Bill This Period Heading',
					'Utility Bill - All Tab - Total Bill This Period Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Total Bill This Period Amount',
					'Utility Bill - All Tab - Total Bill This Period Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Previous Balance Due Heading',
					'Utility Bill - All Tab - Previous Balance Due Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Previous Balance Due Amount',
					'Utility Bill - All Tab - Previous Balance Due Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab -  Late PaymentPenalty Charges Heading',
					'Utility Bill - All Tab -  Late PaymentPenalty Charges Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Late PaymentPenalty Charges Amount',
					'Utility Bill - All Tab - Late PaymentPenalty Charges Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Total Amount Due',
					'Utility Bill - All Tab - Total Amount Due')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Amount',
					'Utility Bill - All Tab - Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Amount Paid This Period Heading',
					'Utility Bill - All Tab - Amount Paid This Period Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Amount Paid This Period Amount',
					'Utility Bill - All Tab - Amount Paid This Period Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Pay Now Button',
					'Pay Now Button')

			'Scroll to View Bill'
			Mobile.scrollToText('View Bill', FailureHandling.CONTINUE_ON_FAILURE)

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Remaining balance Heading',
					'Utility Bill - All Tab - Remaining balance Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Remaining balance Amount',
					'Utility Bill - All Tab - Remaining balance Amount')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Due Date Heading',
					'Utility Bill - All Tab - Due Date Heading')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Due Date',
					'Utility Bill - All Tab - Due Date')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Request Payment Extension Link',
					'Utility Bill - All Tab - Request Payment Extension Link')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - View Bill Pdf Image',
					'Utility Bill - All Tab - View Bill Pdf Image')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - View Bill Text',
					'Utility Bill - All Tab - View Bill Text')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Utility Bill - All Tab - Informational Text',
					'Utility Bill - All Tab - Informational Text')

			if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill/Pay Now Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
			false) {
				System.out.println('Pay Now Button is not displayed in the Billing Menu, So we are unable to verify the Billing Module Payment Test Case')
			} else {
				System.out.println('Pay Now Button is displayed in the Billing Menu')

				'Verify the Pay Bill Method'
				verifyBillingPayBillTestCases()
			}
		}

		'Verify Add Credit Card/ Bank Account Test Cases'
		verifyAddCreditCardBankAccountTestCases()
	}
}

static void verifyBillingPayBillTestCases() {
	'TC : TC_BLG_20, TC_BLG_21, TC_BLG_23, TC_BLG_41, TC_BLG_42, TC_BLG_45'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Pay Now Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Pay Now Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'TC : TC_BLG_20 -->Verifying the Billing Enter Payment Amount Screen Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page Step 1 Heading',
			'Enter Payment Amount Page Step 1 Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Billing Period Heading',
			'Enter Payment Amount Page - Billing Period Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Billing Period Date',
			'Enter Payment Amount Page - Billing Period Date')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Due Date Heading',
			'Enter Payment Amount Page - Due Date Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Due Date',
			'Enter Payment Amount Page - Due Date')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Amount to Pay Heading',
			'Enter Payment Amount Page - Amount to Pay Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Current Outstanding Radio Button',
			'Enter Payment Amount Page - Current Outstanding Radio Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Other Amount Radio Button',
			'Enter Payment Amount Page - Other Amount Radio Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Enter Amount TextBox',
			'Enter Payment Amount Page - Enter Amount TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Select Payment Method Link',
			'Enter Payment Amount Page - Select Payment Method Link')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Next Button',
			'Enter Payment Amount Page - Next Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Cancel Button',
			'Enter Payment Amount Page - Cancel Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Disclaimer Heading',
			'Enter Payment Amount Page - Disclaimer Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Disclaimer Text',
			'Enter Payment Amount Page - Disclaimer Text')

	'TC --> TC_BLG_21 --> Test Case to check which payment amount option radio button is selected'
	if (Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Current Outstanding Radio Button'),
	'checked', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Enter Payment Amount Page - Current Outstanding Radio Button is selected')

		'Selection Other Option Radio Button'
		Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Other Amount Radio Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println('Enter Payment Amount Page - Current Outstanding Radio Button is not selected')
	}

	if (Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Other Amount Radio Button'),
	'checked', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
		System.out.println('Enter Payment Amount Page - Other Amount Radio Button is selected')

		'Selection Current Outstanding Option Radio Button'
		Mobile.tap(findTestObject('SCM Mobile/BillingUtility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Current Outstanding Radio Button'),
				3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println('Enter Payment Amount Page - Other Amount Radio Button is not selected')
	}

	'TC --> TC_BLG_22, TC_BLG_23 --> Select Payment Option from the list'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Select Payment Method Link'),
			3, FailureHandling.CONTINUE_ON_FAILURE)

	List<MobileElement> lPaymentOptionsCount = driver.findElementsByClassName('android.widget.RadioButton')

	System.out.println('lPaymentOptionsCount :' + lPaymentOptionsCount.size())

	'Getting Random Number'
	int randomnumber = utility.RandomRange.nextRandomIntegerInRange(0, lPaymentOptionsCount.size() - 1)

	if (lPaymentOptionsCount.size() > 0) {
		System.out.println('Hence Payment options are already there with the account, hence selecting randomly payment method')

		for (int index2 = randomnumber; index2 <= lPaymentOptionsCount.size(); ) {
			lPaymentOptionsCount.get(index2).click()

			'Clicking on the PopUp Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3)

			Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

			break
		}
	} else {
		System.out.println('Unable to verify TC_BLG_22, TC_BLG_23 because there is no Bank Account and Credit Card is not in the List')
	}
}

static void verifyAddCreditCardBankAccountTestCases() {
	'TC : TC_BLG_24'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking On Select Payment Method Link'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Enter Payment Amount Page - Select Payment Method Link'),
			3, FailureHandling.CONTINUE_ON_FAILURE)

	'Payment Option Count Before Add New Credit Card'
	List<MobileElement> lPaymentOptionsCountBeforeAddCreditCard = driver.findElementsByClassName('android.widget.RadioButton')

	System.out.println('lPaymentOptionsCount :' + lPaymentOptionsCountBeforeAddCreditCard.size())

	'Clicking On Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Add Payment Method Button'), 3,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Checking for Credit Card Tab'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Heading'), 3,
	FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Credit Card option is not displayed in the Add Payment Mode Tab, So Credit Card Test cases cannot be verified.')
	} else {
		System.out.println('Credit Card option is displayed in the Add Payment Mode Tab.')

		'Verifying Credit Card Test Cases'
		verifyMyAccountPaymentInformationCreditCardTestCases()

		'Adding Duplicate Credit Card Test Case'
		verifyAddDuplicateCreditCardTestCase()

		'Successful Payment Using Credit Card'
		verifySuccessfulPaymentUsingCreditCardTestCase()
	}

	'Clicking On Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Add Payment Method Button'), 3,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Checking for Bank Account Tab'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHeading'), 3,
	FailureHandling.CONTINUE_ON_FAILURE) == false) {
		System.out.println('Bank Account option is not displayed in the Add Payment Mode Tab, So Bank Account Test cases cannot be verified.')
	} else {
		System.out.println('Bank Account option is displayed in the Add Payment Mode Tab.')

		'Verifying Bank Account Test Cases'
		verifyMyAccountPaymentInformationBankAccountTestCases()

		'Adding Duplicate Bank Account Test Case'
		verifyAddDuplicateBankAccountTestCase()
	}
}

static void verifyMyAccountPaymentInformationBankAccountTestCases() {
	'TC : TC_BLG_32, TC_BLG_38, TC_BLG_39 To verify that Payment Information Bank Account Tab & its page objects , Add Bank Account, Delete Bank Account, Update Bank Account'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Bank Acccount Tab'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHeading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Verifying Bank Account Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHeading',
			'BankAccount Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Heading',
			'Credit Card Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountAddButton',
			'BankAccount Add Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHolderNameLabel',
			'BankAccountHolderName Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHolderNameTextBox',
			'BankAccountHolderName TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountNumberLabel',
			'BankAccountNumber Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountNumberTextBox',
			'BankAccountNumber TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountRoutingNumberLabel',
			'BankAccount RoutingNumber Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountRoutingNumberTextBox',
			'BankAccount RoutingNumber TextBox')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountRoutingNumberValidationButton',
			'BankAccount RoutingNumber Validation Button')

	'Adding a Bank Account'

	'Entering the Bank Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHolderNameTextBox'), GlobalVariable.sCardHolderName,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Routing Number'
	MobileElement meRoutingNumber = driver.findElementById('com.sus.scm_mobile:id/et_routingnumber')

	meRoutingNumber.sendKeys(GlobalVariable.sRoutingNumber)

	'Clicking on BankAccount RoutingNumber Validation Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountRoutingNumberValidationButton'),
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Account Number'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountNumberTextBox'), GlobalVariable.sBankAccountNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Click on Back to Hide Keyboard'
	Mobile.pressBack()

	'Clicking on Add Bank Account Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountAddButton'), 4, FailureHandling.CONTINUE_ON_FAILURE)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sBankAccountAddMessageText)) {
		System.out.println('Bank Account Added Successfully and Popup message text is as expected.')

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack()

		Mobile.delay(1)
	} else {
		System.out.println((('Something bad happened on the adding the Bank Account. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sBankAccountAddMessageText) + ' but Actual text is ') + messageText)

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack()

		Mobile.delay(1)
	}
}

static void verifyMyAccountPaymentInformationCreditCardTestCases() {
	'TC : TC_BLG_25, TC_BLG_30 To verify that Payment Information Credit Card Tab & its page objects , Add Credit Card, Delete Credit Card, Update Credit Card'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Credit Card Tab'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Verifying Credit Card Page Objects'
	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/VisaCardImage',
			'Visa Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/MasterCardImage',
			'Master Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/AmercianExpressCardImage',
			'Amercian Express Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/DiscoverCardImage',
			'Discover Card Image')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHeading',
			'BankAccount Heading')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Card Holder Name Label',
			'Card Holder Name Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Card Holder Name',
			'Card Holder Name')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Number Label',
			'Credit Card Number Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Number',
			'Credit Card Number')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Card Expiry Date Label',
			'Card Expiry Date Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Card Security Code Label',
			'Card Security Code Label')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/Card Security Code',
			'Card Security Code')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/CreditCardAddButton',
			'Credit Card Add Button')

	applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/Credit Card/CreditCardScannerButton',
			'Credit Card Scanner Button')

	'Checking the Default Month and Year on the Credit Card Expiry Date Calendar'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
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
		Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

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
		Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Date Selection Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println('Credit Card Expiry Date Calendar is not displayed so we are unable to check the Calendar test cases.')
	}

	'Adding New Credit Card'

	'Entering the Credit Card Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Card Holder Name'), GlobalVariable.sCardHolderName,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Credit Card  Number'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Number'), GlobalVariable.sCardNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Date Selection Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the card security code'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Card Security Code'), '123', 4, FailureHandling.CONTINUE_ON_FAILURE)

	'Click on Back to Hide Keyboard'
	Mobile.pressBack()

	'Clicking on Add Credit Card Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/CreditCardAddButton'), 3, FailureHandling.CONTINUE_ON_FAILURE)

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
}

static void verifyAddDuplicateBankAccountTestCase() {
	'TC : TC_BLG_39 To verify that Payment Information Add Duplicate Bank Account'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking On Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Add Payment Method Button'), 3,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Bank Acccount Tab'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHeading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Adding a Duplicate Bank Account'

	'Entering the Bank Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountHolderNameTextBox'), GlobalVariable.sCardHolderName,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Routing Number'
	MobileElement meRoutingNumber = driver.findElementById('com.sus.scm_mobile:id/et_routingnumber')

	meRoutingNumber.sendKeys(GlobalVariable.sRoutingNumber)

	'Clicking on BankAccount RoutingNumber Validation Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountRoutingNumberValidationButton'),
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Bank Account Number'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountNumberTextBox'), GlobalVariable.sBankAccountNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Click on Back to Hide Keyboard'
	Mobile.pressBack()

	'Clicking on Add Bank Account Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Bank Account/BankAccountAddButton'), 4, FailureHandling.CONTINUE_ON_FAILURE)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sBankAccountDuplicateCardMessageText)) {
		System.out.println('Duplicate Bank Account cannot be added and Popup message text is as expected.')

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println((('Something bad happened on the adding the duplicate Bank Account. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sBankAccountDuplicateCardMessageText) + ' but Actual text is ') + messageText)

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack()

		Mobile.delay(1)
	}
}

static void verifyAddDuplicateCreditCardTestCase() {
	'TC : TC_BLG_31 To verify that Payment Information Add Duplicate Credit Card'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking On Add Payment Method'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Enter Payment Amount Page/Add Payment Method Button'), 3,
			FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Credit Card Tab'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Delay'
	Mobile.delay(10)

	'Checking the Default Month and Year on the Credit Card Expiry Date Calendar'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
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
		Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

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
		Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Date Selection Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println('Credit Card Expiry Date Calendar is not displayed so we are unable to check the Calendar test cases.')
	}

	'Adding Duplicate Credit Card'

	'Entering the Credit Card Holder Name'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Card Holder Name'), GlobalVariable.sCardHolderName,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the Credit Card  Number'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Credit Card Number'), GlobalVariable.sDuplicateCreditCardNumber,
			4, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Icon'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Calendar Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Calendar Date Selection Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'Entering the card security code'
	Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/Card Security Code'), '123', 4, FailureHandling.CONTINUE_ON_FAILURE)

	'Click on Back to Hide Keyboard'
	Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Add Credit Card Button'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Credit Card/CreditCardAddButton'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	if (messageText.equals(GlobalVariable.sCreditCardDuplicateCardMessageText)) {
		System.out.println('Duplicate Credit Card and Popup message text is as expected.')

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		System.out.println((('Something bad happened on the adding the duplicate Credit Card. Please check manually. Expected Popup message text is ' +
				GlobalVariable.sCreditCardDuplicateCardMessageText) + ' but Actual text is ') + messageText)

		'Clicking on Popup Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.delay(1)
	}
}

static void verifySuccessfulPaymentUsingCreditCardTestCase() {
	'TC : TC_BLG_45 To verify that Successful through Credit Card'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	List<MobileElement> lPaymentOptionsCount = driver.findElementsByClassName('android.widget.RadioButton')

	System.out.println('lPaymentOptionsCount :' + lPaymentOptionsCount.size())

	'Getting Random Number'
	int randomnumber = utility.RandomRange.nextRandomIntegerInRange(0, lPaymentOptionsCount.size() - 1)

	if (lPaymentOptionsCount.size() > 0) {
		System.out.println('Hence Payment options are already there with the account, hence selecting randomly payment method')

		for (int index2 = randomnumber; index2 <= lPaymentOptionsCount.size(); ) {
			lPaymentOptionsCount.get(index2).click()

			'Clicking on the PopUp Ok Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3)

			Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

			Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/'), '1', 1, FailureHandling.STOP_ON_FAILURE)

			Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Next Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

			break
		}
	}
}

static void verifyAutoPayTestCases() {
	'TC : TC_BLG_64'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Auto Pay Menu from Billing Menu'
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	'This test cases is for unenroll'
	if (applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/btnUnenrollAutoPay')) {
	//unenrollAlreadyEnrolledAutoPayButton()
	}
	'TC --> TC_BLG_64 -->To verify Auto Pay Menu Page Objects'
	//verifyAutoPayObjects()
	
	'TC --> TC_BLG_66_69_70_To verify if user should not be able to enroll for auto pay without choosing Payment method ' 
	'TC --> TC_BLG_65_To verify if choose auto pay and Enroll for it after fill all the mandatory information.'
	//enrollExistingCreditCardAutoPay()

	'TC --> TC_BLG_81_Verify that System shall not allow user to delete Credit/Debit card or Bank account if it has been assigned for Auto Pay'
	//verifyUneditEnrolleMethods()
	
	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
}

'Veryfing Billing - History'
static void verifyBillingHistoryTestCases() {
	
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText
	Mobile.tap(findTestObject('SCM Mobile/Billing/History Menu'), 15)
	
	'TC : TC_BLG_86'
	//verifyBillingHistoryObjects()
		
	'Calling the Press Back Inbuilt funtion'
	 Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
}

'Veryfing Billing - Budget My Bill'
static void verifyBudgetMyBillTestCases() {
	
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText
	
	Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill Menu'), 15)
	
	'TC : TC_BLG_95_96 To verify the Budget My bil hyperlink and its amodule '

		'Check Module Name'
	 messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('Budget My Bill')) {
		System.out.println('On Click on Connect me from the My Account Tab, User is on to the Payment History Module')
		
	}
	
	'TC : TC_BLG_98 Verify that clicking on "Budget My Bill" link, page redirects on  compare his Cost of Units Consume with his Usage, budget and zip average though a graph page'
            'Delay of 50 seconds'
            Mobile.delay(50)

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/Graph_BudgetMyBill')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/MyBudget_BudgetMyBill')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/MyUsage_BudgetMyBill')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/ZipAverage_BudgetMyBill')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/Set Budget Button')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Budget My Bill/Monthly Budget TextBox')
			
            'Updating the Budget My Bill'
			'TC : TC_BLG_104 Verify the user is able to save the monthly budget setting by clicking on Budget Set button'
            
			'Clicking on Monthly Budget TextBox'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill/Monthly Budget TextBox'), 5)

            'Entering the Monthly Budget'
            Mobile.setText(findTestObject('SCM Mobile/Billing/Budget My Bill/Monthly Budget TextBox'), GlobalVariable.sMonthlyBudget,
                4)

            'Clicking on the Keyboard Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)

            'Clicking on Set Budget Button'
            Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill/Set Budget Button'), 5)

            'Delay of 15 sec'
            Mobile.delay(15)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value',
                5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Budget My Bill Updation Message Text is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sBudgetMyBillMessageText)) {
                System.out.println('Budget My Bill Updated Successfully')
            } else {
                System.out.println((('Budget My Bill Text is not matching with the Expected Text, Expected Text is : ' +
                    GlobalVariable.sBudgetMyBillMessageText) + ' but Actual Text is ') + messageText)
            }

            'Clicking on the PopUp Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Delay of 5 seconds'
            Mobile.delay(5)

            'Checking Notify Over Budget Switch'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Budget My Bill/Notify Over Budget Switch'),
                10, FailureHandling.CONTINUE_ON_FAILURE) == false) {
                System.out.println('Notify Over Budget Switch is not displayed in the Budget My Bill')
            } else {
                System.out.println('Notify Over Budget Switch is displayed in the Budget My Bill Menu')

                String sSwitchSelection = driver.findElementByClassName('XCUIElementTypeSwitch').getAttribute('value').toString()

                println(sSwitchSelection)

                if (sSwitchSelection.equals('true')) {
                    System.out.println('Notify Over Budget Switch is enabled')
                } else {
                    System.out.println('Notify Over Budget Switch is disabled')
                }
            }
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

}
'test reusable functions'

static void verifyBillingHistoryObjects() {
'TC : TC_BLG_86 To verify that the system shall billing history with the following details in two tabs '
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Bill Statement tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
			   false) {
					System.out.println('Bill Statement Tab is not displayed in the Billing History')
				} else {
					System.out.println('Bill Statement Tab is displayed in the Billing History Menu')
	
					'Clicking on Bill Statement Tab'
					Mobile.tap(findTestObject('SCM Mobile/Billing/History/Bill Statement tab'), 15)
	
					'Delay of 35 seconds'
					Mobile.delay(35)
					ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('android.widget.RelativeLayout')
									println('History Row Count :' + lHistoryRow.size())
					
								   if (lHistoryRow.size() > 0) {
										System.out.println('Bill Statement Tab have history rows count : ' + lHistoryRow.size())
										
										'TC : TC_BLG_92 Verify that clicking on the History (Billing/Payment) link, page redirects to the last payment history section on the same billing page.'
										'Delay of 35 seconds'
										Mobile.delay(35)
										lHistoryRow.get(0).click()
										
										'Delay of 35 seconds'
										Mobile.delay(35)
										'Check Module Name'
										String messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
									
										if (messageText.equals('Payment History')) {
											System.out.println('On Click on Connect me from the My Account Tab, User is on to the Payment History Module')
											
										}
										'Calling the Press Back Inbuilt funtion'
										Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
										
									} else {
										System.out.println('Bill Statement Tab dont have history')
									}
					
				}
				if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Payments tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
								false) {
									System.out.println('Payments Tab is not displayed in the Billing History')
								} else {
									System.out.println('Payments Tab is displayed in the Billing History Menu')
					
									'Clicking on Bill Payments Tab'
									Mobile.tap(findTestObject('SCM Mobile/Billing/History/Payments tab'), 15)
					
									'Delay of 35 seconds'
									Mobile.delay(35)
					
									ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('android.widget.RelativeLayout')
							
									println('History Row Count :' + lHistoryRow.size())
					
									if (lHistoryRow.size() > 0) {
										System.out.println('Payments Tab have history rows count : ' + lHistoryRow.size())
									} else {
										System.out.println('Payments Tab dont have history')
									}
				  }
					
								if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History/Bill Filter Button'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
								false) {
									System.out.println('Bill Filter Button is not displayed in the Billing History')
								} else {
									System.out.println('Bill Filter Button is displayed in the Billing History Menu')
							   }
							   'Delay'
								Mobile.delay(10)
}
static void enrollExistingCreditCardAutoPay() {
	String messageText
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Credit Card Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.scrollToText('Select Credit Card', FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/AutoPay Calendar Icon'), 5)
	
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Calendar Select Button1'), 2)
	
	Mobile.scrollToText('I Agree To Terms & Conditions', FailureHandling.CONTINUE_ON_FAILURE)
	
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/I Agree To Terms and Conditions CheckBox'), 2)
	
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/btnEnroll'), 2)
	
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)
	
	if (messageText.equals(GlobalVariable.slblTxtSelectPaymentMethodAutoPay)) {
		System.out.println('Your Auto Pay details have been saved successfully.')
	} else {
		System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
				GlobalVariable.slblTxtSelectPaymentMethodAutoPay) + 'but Actual Text is ') + messageText)
	}

	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	Mobile.scrollToText('Select Credit Card', FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Select Credit Card Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE)

	if (applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/rdoBtnCreditCardOne')) {
		Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/rdoBtnCreditCardOne'), 2)

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Select Credit Card Heading')

		Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/btnEnroll'), 2)

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

		if (messageText.equals(GlobalVariable.sEnrollAutoPayText)) {
			System.out.println('Your Auto Pay details have been saved successfully.')
		} else {
			System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
					GlobalVariable.sEnrollAutoPayText) + 'but Actual Text is ') + messageText)
		}

		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		
		'TC_BLG_66_TC_BLG_68_TC_BLG_70 To verify that Button text Changes to Already Enrolled when user is successfully enrolled for Auto Pay.'
		verifyAlreadyEnrolledAutoPayButton()
	}
	
	 else {
		println('Enrollment is not happened yet')
	}
}


static void verifyAlreadyEnrolledAutoPayButton() {
	
	String messageText
applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/btnUnenrollAutoPay')

applicationMethods.ReusableMethods.verifyAttribute('SCM Mobile/Billing/Auto Pay/lblTxtYouAreEnrolledAutoPay', 'text',
		GlobalVariable.sLblTxtYouAreEnrolledAutoPay)

messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Auto Pay/btnUnenrollAutoPay'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

			if (messageText.equals(GlobalVariable.sLblTxtButtonUnenrollAutoPay)) {
				System.out.println(GlobalVariable.sLblTxtButtonUnenrollAutoPay)

			
			} else {
				System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
						GlobalVariable.sLblTxtButtonUnenrollAutoPay) + 'but Actual Text is ') + messageText)
			}
}

static void unenrollAlreadyEnrolledAutoPayButton() {
	String messageText

	Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/btnUnenrollAutoPay'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/btnDeleteAutoPay')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/btnEditAutoPay')

		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

		if (messageText.equals(GlobalVariable.sLblTxtDeleteAutoPay)) {
			System.out.println(GlobalVariable.sLblTxtDeleteAutoPay)
			Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/btnDeleteAutoPay'), 3, FailureHandling.CONTINUE_ON_FAILURE)

			messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

			if (messageText.equals(GlobalVariable.sLblTxtYouAreUnEnrolledAutoPay)) {
				System.out.println(GlobalVariable.sLblTxtYouAreUnEnrolledAutoPay)

				Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			} else {
				System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
						GlobalVariable.sLblTxtYouAreUnEnrolledAutoPay) + 'but Actual Text is ') + messageText)
			}
		} else {
			System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' +
					GlobalVariable.sLblTxtDeleteAutoPay) + 'but Actual Text is ') + messageText)
		}
	}
static void verifyAutoPayObjects() {
	String messageText
'Chcking Auto Pay Page Objects'
applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Credit Card Tab', 'Credit Card Tab')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Bank Account Tab', 'Bank Account Tab')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Informational Text 1', 'Informational Text 1')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Select Credit Card Heading',
		'Select Credit Card Heading')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Make Payment Heading', 'Make Payment Heading')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Auto Pay Calendar Icon', 'Auto Pay Calendar Icon')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Informational Text 2', 'Informational Text 2')

Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Bank Account Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Select Bank Account Heading',
		'Select Bank Account Heading')

'Scroll to View Bill'
Mobile.scrollToText('I Agree To Terms & Conditions', FailureHandling.CONTINUE_ON_FAILURE)

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/I Agree To Terms and Conditions CheckBox',
		'I Agree To Terms and Conditions CheckBox ')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Select Bank Account Heading',
		'Select Bank Account Heading')

applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/Enroll Button', 'Enroll Button')
}

static void verifyUneditEnrolleMethods() {
	String messageText
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	'TC_BLG_81-Verify that System shall not allow user to delete Credit/Debit card or Bank account if it has been assigned for Auto Pay'
	if (applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Auto Pay/btnUnenrollAutoPay')) {
		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
			false) {
				System.out.println('My Account is not displayed in the Dashboard/Landing Page')
			} else {
				System.out.println('My Account is displayed on the Dashboard/Landing Page')
		
				'Clicking on My Account Menu from Dashboard/Landing Page'
				Mobile.tap(findTestObject('SCM Mobile/LandingPage/My Account Menu'), 10)
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
				
				
			
				Mobile.tapAndHold(findTestObject('SCM Mobile/My Account/Payment Information/Credit Card/rdBtnCreditCardPaymentInfo'), 0, 0)
	
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
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
			
			'Checking Billing Menu is Displayed on Dashboard or Not'
			if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
			false) {
				System.out.println('Billing is not displayed in the Dashboard/Landing Page')
			} else {
				System.out.println('Billing is displayed on the Dashboard/Landing Page')
				
				'Clicking on Billing Menu from Dashboard/Landing Page'
				Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 10)
				
				'Clicking on Auto Pay Menu from Billing Menu'
				Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)
			
			}
			
	}
		

}
//'Checking Billing Menu is Displayed on Dashboard or Not'
//if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
//false) {
//    System.out.println('Billing is not displayed in the Dashboard/Landing Page' //   Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//        //			driver.scrollToExact(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay Enrollment Button'))
//        //
//        //			Mobile.checkElement(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay I Agree CheckBox '), 5)
//        //
//        //			'Scrolling  the Screen Downwards till Enroll Button'
//        ) //			Mobile.scrollToText("Enroll", FailureHandling.CONTINUE_ON_FAILURE)
//    //
//    //			'Delay'
//    //			Mobile.delay(10)
//    //
//    //			'Selecting the T&C CheckBox'
//    //	Mobile.tap
//    //	 MobileElement cCheckBox = driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeButton[1]")
//    //	 cCheckBox.click()
//    //	Mobile.checkElement(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay T and C CheckBox'), 5)
//    //			TouchAction action = new TouchAction(driver)
//    //			action.pre
//    //			Mobile.scrollToText(findTestObject('XCUIElementTypeStaticText - I Agree To'))
//    //
//} else {
//    'Clicking on Billing Menu from Dashboard/Landing Page'
//    Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 5)
//
//    'Delay'
//    Mobile.delay(10)
//
//    AppiumDriver<?> driver = MobileDriverFactory.getDriver()
//
//    ArrayList<MobileElement> lBillingSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')
//
//    println('Size of Billing Side Menu :' + lBillingSideMenu.size())
//
//    'Printing Billing Side Menu List'
//    println('Billing Side Menu List Contains :')
//
//    for (int index = 0; index < lBillingSideMenu.size(); index++) {
//        println(lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText())
//
//        'Delay of 1 seconds'
//        Mobile.delay(1)
//    }
//
//    for (int index = 0; index < lBillingSideMenu.size(); index++) {
//        if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Utility Bill11')) {
//            'Veryfing Billing - Utility Bill'
//
//            'Clicking on Utility Bill from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 50 seconds'
//            Mobile.delay(50)
//
//            'Clicking on Pay Now Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Pay Now Button'), 15)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Entering the Bill Amount'
//            Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/Bill Amount TextBox'), '2', 4)
//
//            'Hiding the Keyboard'
//            Mobile.hideKeyboard()
//
//            'Clicking on Next Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Next Button'), 15)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Entering the CVV Number'
//            Mobile.setText(findTestObject('SCM Mobile/Billing/Utility Bill/CVV Code TextBox'), '123', 4)
//
//            'Hiding the Keyboard'
//            Mobile.hideKeyboard()
//
//            'Clicking on the Submit Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Submit Button'), 35)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Getting Payment Successful Text'
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Payment Successful Text'),
//                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Getting Payment Transaction Id'
//            transactionId = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Utility Bill/Transaction Id Text'), 'text',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Verifying Bill Payment is Successfully Done or Not'
//            if (messageText.equals(null)) {
//                System.out.println('Something went wrong with Bill Payment, Please check manually')
//            } else {
//                if (messageText.equals('Payment Successful!')) {
//                    System.out.println('Bill Payment Successful, Transaction Id is : ' + transactionId)
//                } else {
//                    System.out.println((('Bill Time Payment Successful, Transaction Id is : ' + transactionId) + 'Expected Text, Expected Text is : "Payment Successful!" but Actual Text is ') +
//                        messageText)
//                }
//            }
//
//            'Clicking on the Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill/Ok Button'), 75)
//
//            'Delay of 45 seconds'
//            Mobile.delay(45)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(30)
//        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('History1')) {
//            'Veryfing Billing - History'
//
//            'Clicking on History from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 50 seconds'
//            Mobile.delay(50)
//
//            if (Mobile.verifyElementVisible(findTestObject('null'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
//            false) {
//                System.out.println('Bill Statement Tab is not displayed in the Billing History')
//            } else {
//                System.out.println('Bill Statement Tab is displayed in the Billing History Menu')
//
//                'Clicking on Bill Statement Tab'
//                Mobile.tap(findTestObject('null'), 15)
//
//                'Delay of 35 seconds'
//                Mobile.delay(35)
//
//                ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('XCUIElementTypeCell')
//
//                println('History Row Count :' + lHistoryRow.size())
//
//                if (lHistoryRow.size() > 0) {
//                    System.out.println('Bill Statement Tab have history rows count : ' + lHistoryRow.size())
//                } else {
//                    System.out.println('Bill Statement Tab dont have history')
//                }
//            }
//
//            if (Mobile.verifyElementVisible(findTestObject('null'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
//            false) {
//                System.out.println('Payments Tab is not displayed in the Billing History')
//            } else {
//                System.out.println('Payments Tab is displayed in the Billing History Menu')
//
//                'Clicking on Bill Payments Tab'
//                Mobile.tap(findTestObject('null'), 15)
//
//                'Delay of 35 seconds'
//                Mobile.delay(35)
//
//                ArrayList<MobileElement> lHistoryRow = driver.findElementsByClassName('XCUIElementTypeCell')
//
//                println('History Row Count :' + lHistoryRow.size())
//
//                if (lHistoryRow.size() > 0) {
//                    System.out.println('Payments Tab have history rows count : ' + lHistoryRow.size())
//                } else {
//                    System.out.println('Payments Tab dont have history')
//                }
//            }
//
//            if (Mobile.verifyElementVisible(findTestObject('null'), 10, FailureHandling.CONTINUE_ON_FAILURE) ==
//            false) {
//                System.out.println('Bill Filter Button is not displayed in the Billing History')
//            } else {
//                System.out.println('Bill Filter Button is displayed in the Billing History Menu')
//            }
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Budget My Bill1')) {
//            'Veryfing Billing - Budget My Bill'
//
//            'Clicking on Budget My Bill from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 50 seconds'
//            Mobile.delay(50)
//
//            'Updating the Budget My Bill'
//
//            'Clicking on Monthly Budget TextBox'
//            Mobile.tap(findTestObject('null'), 5)
//
//            'Entering the Monthly Budget'
//            Mobile.setText(findTestObject('null'), GlobalVariable.sMonthlyBudget,
//                4)
//
//            'Clicking on the Keyboard Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 15)
//
//            'Clicking on Set Budget Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Budget My Bill/Set Budget Button'), 5)
//
//            'Delay of 15 sec'
//            Mobile.delay(15)
//
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Checking Budget My Bill Updation Message Text is matching with the Expeced Text or Not'
//            if (messageText.equals(GlobalVariable.sBudgetMyBillMessageText)) {
//                System.out.println('Budget My Bill Updated Successfully')
//            } else {
//                System.out.println((('Budget My Bill Text is not matching with the Expected Text, Expected Text is : ' +
//                    GlobalVariable.sBudgetMyBillMessageText) + ' but Actual Text is ') + messageText)
//            }
//
//            'Clicking on the PopUp Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
//
//            'Delay of 5 seconds'
//            Mobile.delay(5)
//
//            'Checking Notify Over Budget Switch'
//            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Budget My Bill/Notify Over Budget Switch'),
//                10, FailureHandling.CONTINUE_ON_FAILURE) == false) {
//                System.out.println('Notify Over Budget Switch is not displayed in the Budget My Bill')
//            } else {
//                System.out.println('Notify Over Budget Switch is displayed in the Budget My Bill Menu')
//
//                String sSwitchSelection = driver.findElementByClassName('XCUIElementTypeSwitch').getAttribute('value').toString()
//
//                println(sSwitchSelection)
//
//                if (sSwitchSelection.equals('true')) {
//                    System.out.println('Notify Over Budget Switch is enabled')
//                } else {
//                    System.out.println('Notify Over Budget Switch is disabled')
//                }
//            }
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Auto Pay')) {
//            'Veryfing Billing - Auto Pay'
//
//            'Clicking on Auto Pay from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            'Clicking on Select Credit Card'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Select Credit Card from DropDown'), 18)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Clicking on Select Credit Card'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Select the Credit Card'), 18)
//
//            'Delay of 25 seconds'
//            Mobile.delay(25)
//
//            MobileElement bCalendar = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeButton[1]')
//
//            bCalendar.click()
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Selecting the Auto Pay Date'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Calendar Select Button1'), 5)
//
//            'Delay of 10 seconds'
//            Mobile.delay(10)
//
//			Dimension dimensions = driver.manage().window().getSize();
//			Double screenHeightStart = dimensions.getHeight() * 1;
//			int scrollStart = screenHeightStart.intValue();
//			System.out.println("s="+scrollStart);
//			Double screenHeightEnd = dimensions.getHeight() * 0.2;
//			int scrollEnd = screenHeightEnd.intValue();
//			driver.swipe(0,scrollEnd,0,scrollStart,4000);
//			sleep(1000);
//
//			driver.findElementByXPath("//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeButton[1]").click()
//
//
////            'Selecting the I Agree Checkbox'
////            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/I Agree CheckBox'), 5)
//
//            'Delay of 10 seconds'
//            Mobile.delay(10)
//
//            'Clicking on Enroll Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay Enrollment Button'), 18)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Getting Auto Pay Enrollment Text'
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay Enrollment Text'), 'text',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Verifying Auto Pay Enrollment is Successfully Done or Not'
//            if (messageText.equals(null)) {
//                System.out.println('Something went wrong with Auto Pay Enrollment, Please check manually')
//            } else {
//                if (messageText.equals('Your Auto Pay details have been saved successfully.')) {
//                    System.out.println('Your Auto Pay details have been saved successfully.')
//                } else {
//                    System.out.println('Auto Pay Enrollment Successful, Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' +
//                        messageText)
//                }
//            }
//
//            'Clicking on the Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Ok Button'), 25)
//
//            'Delay of 15 seconds'
//            Mobile.delay(15)
//
//            'Unerolling From Auto Pay'
//            Mobile.tapAndHold(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay Enrolled Account Selection'), 6, 8)
//
//            'Clicking on the Delete Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Delete Button'), 6)
//
//            'Getting Auto Pay Enrollment Text'
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Billing/Auto Pay/Auto Pay Unerollment Text'), 'text',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Verifying Auto Pay UnEnrollment is Successfully Done or Not'
//            if (messageText.equals(null)) {
//                System.out.println('Something went wrong with Auto Pay UnEnrollment, Please check manually')
//            } else {
//                if (messageText.equals('You have been successfully unenrolled from Auto Pay.')) {
//                    System.out.println('You have been successfully unenrolled from Auto Pay.')
//                } else {
//                    System.out.println('Auto Pay UnEnrollment Successful, Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' +
//                        messageText)
//                }
//            }
//
//            'Clicking on the Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Auto Pay/Ok Button'), 25)
//
//            'Delay of 45 seconds'
//            Mobile.delay(45)
//
//            'Delay'
//            Mobile.delay(10)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(20)
//        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Rate Analysis')) {
//            'Veryfing Billing - Rate Analysis'
//
//            'Clicking on Rate Analysis from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 50 seconds'
//            Mobile.delay(50)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//        } else if (lBillingSideMenu.get(index).findElementByClassName('XCUIElementTypeStaticText').getText().equals('Level Pay')) {
//            'Veryfing Billing - Level Pay'
//
//            'Clicking on Level Pay from Billing Menu'
//            lBillingSideMenu.get(index).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            'Enrolling in the Level Pay'
//
//            'Selecting the Agree CheckBox'
//            Mobile.checkElement(findTestObject('SCM Mobile/Billing/Level Pay/I Agree CheckBox'), 3)
//
//            'Delay of 2 seconds'
//            Mobile.delay(2)
//
//            'Clicking on Enroll Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Level Pay/Enroll Button'), 3)
//
//            'Delay of 8 seconds'
//            Mobile.delay(8)
//
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Checking Level Pay Enrollment Text is matching with the Expeced Text or Not'
//            if (messageText.equals(GlobalVariable.sLevelEnrollmentMessageText)) {
//                System.out.println('User Sucessfully Enrolled for Level Pay')
//            } else {
//                System.out.println((('Level Pay Enrollment Text is not matching with the Expected Text, Expected Text is : ' +
//                    GlobalVariable.sLevelEnrollmentMessageText) + ' but Actual Text is ') + messageText)
//            }
//
//            'Clicking on the PopUp Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
//
//            'Delay of 5 seconds'
//            Mobile.delay(5)
//
//            'DisEnrolling from Level Pay'
//
//            'Clicking on DisEnroll Button'
//            Mobile.tap(findTestObject('SCM Mobile/Billing/Level Pay/DisEnroll Button'), 3)
//
//            'Delay of 6 seconds'
//            Mobile.delay(6)
//
//            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value',
//                5, FailureHandling.CONTINUE_ON_FAILURE)
//
//            'Checking Level Pay Enrollment Text is matching with the Expeced Text or Not'
//            if (messageText.equals(GlobalVariable.sLevelDisEnrollmentMessageText)) {
//                System.out.println('User Sucessfully DisEnrolled for Level Pay')
//            } else {
//                System.out.println((('Level Pay DisEnrollment Text is not matching with the Expected Text, Expected Text is : ' +
//                    GlobalVariable.sLevelDisEnrollmentMessageText) + ' but Actual Text is ') + messageText)
//            }
//
//            'Clicking on the PopUp Ok Button'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
//
//            'Delay of 5 seconds'
//            Mobile.delay(5)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//        }
//    }
//    'Calling the Press Back Inbuilt funtion'
//    Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//    'Delay'
//    Mobile.delay(20)
//}
