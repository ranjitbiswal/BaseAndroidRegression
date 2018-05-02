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
static void verifyPreLoginEfficiencyTestCases() {
	'TC : TC_PLE_1 To verify that PreLogin Efficiency TestCases'
	String messageText = null

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Efficiency/PreLogin Efficiency Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	true) {
		'Clicking on PreLogin Efficiency'
		Mobile.tap(findTestObject('SCM Mobile/PreLogin Efficiency/PreLogin Efficiency Menu'), 5)

		'Delay of 5 seconds'
		Mobile.delay(5)

		'Check Module Name'
		messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

		if (messageText.equals('Efficiency')) {
			System.out.println('On Click on PreLogin Efficiency, User is routing to the Efficiency Module')
		} else {
			System.out.println('On Click on PreLogin Efficiency, user might route to the Efficiency Module or something issue with the Module Name. Expected Module Name is : Efficiency. Please check manually. ')
		}

		'Checking PreLogin Efficiency Page Objects'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Efficiency/Rebates Menu', 'Rebates Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Efficiency/Saving Tips Menu', 'Saving Tips Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Efficiency/Programs Menu', 'Programs Menu')

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Efficiency/Educational Tips Menu',
				'Educational Tips Menu')

		if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Efficiency/Rebates Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			System.out.println('Rebate Menu is displayed.')

			verifyPreLoginEfficiencyRebatesTestCases()
			verifyPreLoginEfficiencySavingTipsTestCases()
			verifyPreLoginEfficiencyEduTipsTestCases()

		} else {
			System.out.println('We are unable to verify the Rebates test cases, because Rebates Menu is not displayed.')
		}
	} else {
		System.out.println('We are unable to verify the PreLogin Efficiency test cases, because PreLogin Efficiency Menu is not displayed.')
	}
}

static void verifyPreLoginEfficiencyRebatesTestCases() {
	'TC : TC_MAS_13, TC_MAS_14, TC_MAS_17, TC_MAS_18 To verify that Configure Payment Tab, its page objects and Change Payment Type'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	'Clicking on Rebates '
	Mobile.tap(findTestObject('SCM Mobile/PreLogin Efficiency/Rebates Menu'), 3, FailureHandling.STOP_ON_FAILURE)

	Mobile.delay(3)

	'Checking the Module Name'
	messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText.equals('Rebates')) {
		System.out.println('On Click on Rebates from the PreLogin Efficiency Tab, User is routing to the Efficiency Tab')

		'Checking the Rebates Count'
		List<MobileElement> lRebatesCount = driver.findElementsById('com.sus.scm_mobile:id/tv_rebates_details')

		System.out.println('lRebatesCount :' + lRebatesCount.size())

		if (lRebatesCount.size() > 0) {
			for (int index = 0; index < lRebatesCount.size(); ) {

				'Clicking on the First Rebate Tip'
				lRebatesCount.get(index).click()

				'Checking the View Count'
				String sTipViewCountOnFirstCLick = driver.findElementById("com.sus.scm_mobile:id/tv_viewed_details").getText()
				'Checking the unclickable Like Button'
				if (Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Efficiency/btnPreLoginEfficiencyLike'),
				'clickable', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('false')) {
					System.out.println('Like Button is disabled at PreLogin as expected')
				}
				else
				{
					System.out.println('Like Button is enabled at PreLogin unexpectdly')
				}
				'Checking the Like Count'

				String sTipLikeCount = driver.findElementById("com.sus.scm_mobile:id/txtPreLikeCount")

				Mobile.pressBack()
			}
		}
		else{
			System.out.println('Rebates Tips Count is 0. ')

		}
	} else {
		System.out.println('On Click on Rebates from the PreLogin Efficiency Tab, user might route to the PreLogin Efficiency or something issue with the Module Name. Expected Module Name is : Rebates. Please check manually. ')
	}
}
static void verifyPreLoginEfficiencySavingTipsTestCases()
{
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblSavingsTipsMenuEfficiency'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Savings Tips')) {

		Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblSavingsTipsMenuEfficiency'), 15)
		'Delay of 50 seconds'
		Mobile.delay(5)
		'bhartt'
		ArrayList<MobileElement> lSavingTipssideMenu = driver.findElementsById('com.sus.scm_mobile:id/tv_rebates_details')

		println('Size of Billing Side Menu :' + lSavingTipssideMenu.size())

		'TC_EEC_016'
		for (int index2 = 0; index2 < lSavingTipssideMenu.size(); index2++) {
			lSavingTipssideMenu.get(index2).click()

			'verify likes, Enrolled Status, Viewed Details, Read More'
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/ViewedDtails',
					'SCM Mobile/Efficiency/Rebates/ViewedDtails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/SaveUptoDetails',
					'SCM Mobile/Efficiency/Rebates/SaveUptoDetails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/DescriptionDetails',
					'SCM Mobile/Efficiency/Rebates/DescriptionDetails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/AddedDetails',
					'SCM Mobile/Efficiency/Rebates/AddedDetails')

			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		}


		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)
	}
}
static void verifyPreLoginEfficiencyEduTipsTestCases()
{
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	String messageText

	if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblEducational TipsMenuEfficiency'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Educational Tips')) {

		Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblEducational TipsMenuEfficiency'), 15)

		'Delay of 50 seconds'
		Mobile.delay(5)
		'bhartt'
		ArrayList<MobileElement> lEduTipssideMenu = driver.findElementsById('com.sus.scm_mobile:id/tv_rebates_details')

		println('Size of Billing Side Menu :' + lEduTipssideMenu.size())

		'TC_EEC_020'
		for (int index2 = 0; index2 < lEduTipssideMenu.size(); index2++) {
			lEduTipssideMenu.get(index2).click()

			'verify likes, Enrolled Status, Viewed Details, Read More'
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/ViewedDtails',
					'SCM Mobile/Efficiency/Rebates/ViewedDtails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/SaveUptoDetails',
					'SCM Mobile/Efficiency/Rebates/SaveUptoDetails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/DescriptionDetails',
					'SCM Mobile/Efficiency/Rebates/DescriptionDetails')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/AddedDetails',
					'SCM Mobile/Efficiency/Rebates/AddedDetails')

			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		}

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)

	}
}
''
