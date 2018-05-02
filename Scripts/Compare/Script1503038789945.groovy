import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

//'Installing/Launching the Application on the Device'
//Mobile.startApplication('E:\\app-debug.apk', false)

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 50 seconds'
Mobile.delay(20)
@com.kms.katalon.core.annotation.TearDown
static void verifyCompareSpendingTestCases() {

	'Scrolling  the Screen till Compare Button'
	//Mobile.swipe(800, 1615, 400, 0, FailureHandling.STOP_ON_FAILURE)

	'Checking CompareMenu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Compare Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('Compare is not displayed in the Dashboard/Landing Page') //   Mobile.pressBack()

	} else {
		'Clicking on Compare Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/Compare Menu'), 5)

		'Delay'
		Mobile.delay(10)

		'Compare Side Menu'
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()

		'TC_CMP_4'
		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Power Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			'Veryfing Compare - Power'
			'Clicking on Power from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Power/Power Menu'), 45)

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power kWh unit is displayed')

				'Clicking on kWh Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Power/kWh Unit'),45)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Power - kWh - HighChart is displayed')
				}
				else
				{
					println ('Compare - Power - kWh - HighChart is not displayed')
				}
			}
			else
			{
				println ('Power kWh unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power Dollar unit is displayed')

				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Power/Dollar Unit'),23)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Power - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Power - Dollar - HighChart is not displayed')
				}

			}
			else
			{
				println ('Power Dollar unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)


			''
			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
		}

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Water Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			'Veryfing Compare - Water'

			'Clicking on Water from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Water Menu'), 25)

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Gal Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Gal unit is displayed')

				'Clicking on Gal Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Gal Unit'),25)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - Gal - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - Gal - HighChart is not displayed')
				}
			}
			else
			{
				println ('Water Gal unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water Dollar unit is displayed')

				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/Dollar Unit'),23)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - Dollar - HighChart is not displayed')
				}

			}
			else
			{
				println ('Water Dollar unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/HCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Water HCF unit is displayed')

				'Clicking on HCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Water/HCF Unit'),23)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Water/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Water - HCF - HighChart is displayed')
				}
				else
				{
					println ('Compare - Water - HCF - HighChart is not displayed')
				}

			}
			else
			{
				println ('Water HCF unit is not displayed')
			}
			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)

		}

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Gas Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{	'Veryfing Compare - Gas'

			'Clicking on Gas from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/Gas Menu'), 78)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Dollar Unit'), 10, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas Dollar unit is displayed')

				'Clicking on Dollar Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/Dollar Unit'),23)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Gas - Dollar - HighChart is displayed')
				}
				else
				{
					println ('Compare - Gas - Dollar - HighChart is not displayed')
				}

			}
			else
			{
				println ('Gas Dollar unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/CCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Gas CCF unit is displayed')

				'Clicking on CCF Unit'
				Mobile.tap(findTestObject('SCM Mobile/Compare/Gas/CCF Unit'),23)

				if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Gas/Compare HighChart'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
				{
					println ('Compare - Gas - CCF - HighChart is displayed')
				}
				else
				{
					println ('Compare - Gas - CCF - HighChart is not displayed')
				}

			}
			else
			{
				println ('Gas CCF unit is not displayed')
			}

			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
		}
		//}
		' TC_CMP_81 BHarrti'

		//AppiumDriver<?> driver = MobileDriverFactory.getDriver()

		String messageText

		'Clicking on the Hamburger Menu'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

		'Checking Settings is Displayed on Hamburger Menu or Not'
		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Settings Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		false) {
			System.out.println('Settings is not Displayed in Hamburger Menu, So Settings Test Cases cannot be verified')
		} else {
			System.out.println('Settings is Displayed in Hamburger Menu')

			'Clicking on the Settings'
			Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Settings Menu'), 5)

			'Checking Module Name'
			messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

			if (messageText.equals('Settings')) {
				System.out.println('On Click on Settings from the Hamburger Menu, User is routing to the Settings Module')
			} else {
				System.out.println('On Click on Settings from the Hamburger Menu, user might route to the Settings Module or something issue with the Module Name. Expected Module Name is : Settings. Please check manually. ')
			}

			'Clicking on Configure Payment '
			Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment Heading'), 3, FailureHandling.STOP_ON_FAILURE)
			'Checking the Popup Heading Name'
			messageText = driver.findElementById('com.sus.scm_mobile:id/text_view_configure_payment').getText()

			if (messageText.equals('Configure Payment')) {
				System.out.println('On Click on Configure Payment from the Setting Tab, User is routing to the Configure Payment')
			} else {
				System.out.println('On Click on Configure Payment from the Setting Tab, user might route to the Configure Payment or something issue with the Module Name. Expected Module Name is : Configure Payment. Please check manually. ')
			}

			if (Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Monthly Billing Radio Button'),
			'checked', 1, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
				System.out.println('Payment Type Monthly Billing Radio Button is Selected')

				'Changing the Payment Type from Monthly Billing to Pay as you Go'
				Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Pay as you go Radio Button'),
						3, FailureHandling.CONTINUE_ON_FAILURE)

				'Clicking on I Agree Checkbox'
				Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/I Agree CheckBox'), 3, FailureHandling.CONTINUE_ON_FAILURE)

				'Clicking on Save Buton'
				Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Save Button'),
						3, FailureHandling.CONTINUE_ON_FAILURE)

				messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

				if (messageText.equals(GlobalVariable.sPaymentTypeUpdateMessageFromMonthlyToPayAsYouGo)) {
					System.out.println('Payment Type Updated Successfully and Popup message text is as expected.')

					Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
				}

				'Calling the Press Back Inbuilt funtion'
				Mobile.pressBack()
			}
		}
		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Power Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			'Veryfing Compare - Power'
			'Clicking on Power from Compare Menu'
			Mobile.tap(findTestObject('SCM Mobile/Compare/Power/Power Menu'), 45)

			'Delay'
			Mobile.delay(10)

			if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Compare/Power/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
			{
				println ('Power Dollar unit is displayed and it is unexpected')

			}
			else
			{
				println ('Power Dollar unit is not displayed as expected')
			}
			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.pressBack()

			'Delay'
			Mobile.delay(30)
		}

		'Bhartii'


		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.pressBack()
	}
}
