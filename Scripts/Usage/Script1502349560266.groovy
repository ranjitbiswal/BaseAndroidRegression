import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

import org.junit.After

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
applicationMethods.ReusableMethods.verifyValidLogin()

@com.kms.katalon.core.annotation.TearDown
static void verifyUsageTestCases() {
String messageText = null


Mobile.delay(10)

'Checking Usage Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
false) {
	System.out.println('Usage is not displayed in the Dashboard/Landing Page')

} else {
	'Clicking on Usage Menu from Dashboard/Landing Page'
	Mobile.tap(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 5)

	'Delay'
	Mobile.delay(10)

	'Usage Side Menu'
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Common/lblPowerMenuUsage'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Power')) {

		Mobile.tap(findTestObject('SCM Mobile/Usage/Common/lblPowerMenuUsage'), 15)
		'Delay of 50 seconds'
		Mobile.delay(5)
		''
		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Power kWh unit is displayed')

			'Clicking on kWh Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/kWh Unit'),15)
		}
		else
		{
			println ('Power kWh unit is not displayed')
		}

		'Delay'
		Mobile.delay(10)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Power/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Power Dollar unit is displayed')

			'Clicking on Dollar Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/Dollar Unit'),23)
		}
		else
		{
			println ('Power Dollar unit is not displayed')
		}
		'Delay'
		Mobile.delay(10)

		'TC_UP_170 Verify Monthly Usage and High Year Values'

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblMonthlyAverageUsagePower',
				'txtLblMonthlyAverageUsagePower')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblHighThisYearUsagePower',
				'txtLblHighThisYearUsagePower')

		'TC_UP_172 TC_UP_184 Test Case for Meter Number'
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultMeterTitleUsagePower'),
		'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('All')) {

			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/ddlMeterNumberUsagePower'),15)

			ArrayList<MobileElement> lMeterNumberMenu = driver.findElementsById('android:id/text1')

			println('Size of Meter Number Menu :' + lMeterNumberMenu.size())
			def a = new String[3]
			a = ["All", "E00001", "E00002"]
			for (int index2 = 0; index2 < lMeterNumberMenu.size(); index2++) {
				String sMeterName = lMeterNumberMenu.get(index2).getAttribute('text')

				if (a.contains(sMeterName)) {
					println "Expected value present"
				}
				else
				{
					println "Some other value present in DDL of Meter Number"
				}

			}
			lMeterNumberMenu.get(0).click()

		}
		else
		{
			println "Default Value is not All and somethimg else is visible, please check manually"
		}

		'TC_UP_175 TC_UP_177 Test Case for checking Time Periods'
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultPeriodTitleUsagePower'),
		'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Monthly')) {

			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultPeriodTitleUsagePower'),15)
			ArrayList<MobileElement> lPeriodMenu = driver.findElementsById('android:id/text1')
			println('Size of Period Menu :' + lPeriodMenu.size())
			def a1 = new String[2]
			def a2 = new String[5]
			a1=["Monthly", "Season'"]
			a2=["Monthly", "Season" , "Daily", "Hourly" , "15 Min"]
			for (int index2 = 0; index2 < lPeriodMenu.size(); index2++) {
				String sPeriod = lPeriodMenu.get(index2).getAttribute('text')

				if (a1.contains(sPeriod)) {
					println "Expected value present"
				}
				else
				{
					println "Some other value present in DDL of Period"
				}

			}
			lPeriodMenu.get(0).click()
		}
		else
		{
			println "Default Value is not Monthly and somethimg else is visible, please check manually"
		}

		'TC_UP_165 TC_UP_185 Test Case for High Alert Functionality'
		Mobile.tap(findTestObject('SCM Mobile/Usage/Power/btnSetUsageAlertPower'), 15)
		Mobile.tap(findTestObject('SCM Mobile/Usage/Power/btnSubmitUsageAlertSettingsUsagePower'), 15)

		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 30)

		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)
	}

	if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Common/lblWaterMenuUsage'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Water')) {

		Mobile.tap(findTestObject('SCM Mobile/Usage/Common/lblWaterMenuUsage'), 15)
		'Delay of 50 seconds'
		Mobile.delay(5)
		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Gal Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Water Gal unit is displayed')

			'Clicking on Gal Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Water/Gal Unit'),25)
		}
		else
		{
			println ('Water Gal unit is not displayed')
		}

		'Delay'
		Mobile.delay(10)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/Dollar Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Water Dollar unit is displayed')

			'Clicking on Dollar Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Water/Dollar Unit'),23)
		}
		else
		{
			println ('Water Dollar unit is not displayed')
		}

		'Delay'
		Mobile.delay(10)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Water/HCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Water HCF unit is displayed')

			'Clicking on HCF Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Water/HCF Unit'),23)

		}
		else
		{
			println ('Water HCF unit is not displayed')
		}
		'Delay'
		Mobile.delay(10)

		'TC_UW_128 Verify Monthly Usage and High Year Values'

		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblMonthlyAverageUsagePower',
				'txtLblMonthlyAverageUsagePower')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblHighThisYearUsagePower',
				'txtLblHighThisYearUsagePower')

		'TC_UW_130 Test Case for Meter Number'
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultMeterTitleUsagePower'),
		'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('All')) {

			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/ddlMeterNumberUsagePower'),15)

			ArrayList<MobileElement> lMeterNumberMenu = driver.findElementsById('android:id/text1')

			println('Size of Meter Number Menu :' + lMeterNumberMenu.size())
			def a = new String[3]
			a = ["All", "E00001", "E00002"]
			for (int index2 = 0; index2 < lMeterNumberMenu.size(); index2++) {
				String sMeterName = lMeterNumberMenu.get(index2).getAttribute('text')

				if (a.contains(sMeterName)) {
					println "Expected value present"
				}
				else
				{
					println "Some other value present in DDL of Meter Number"
				}

			}
			lMeterNumberMenu.get(0).click()

		}
		else
		{
			println "Default Value is not All and somethimg else is visible, please check manually"
		}


		'TC_UW_145 Test Case for High Alert Functionality'
		Mobile.tap(findTestObject('SCM Mobile/Usage/Power/btnSetUsageAlertPower'), 15)
		Mobile.tap(findTestObject('SCM Mobile/Usage/Power/btnSubmitUsageAlertSettingsUsagePower'), 15)

		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 30)

		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)

	}
	if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Common/lblSolarMenuUsage'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Solar')) {

		Mobile.tap(findTestObject('SCM Mobile/Usage/Common/lblSolarMenuUsage'), 15)
		'Delay of 50 seconds'
		Mobile.delay(5)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/Dollar Unit'), 15, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Solar Dollar unit is displayed')

			'Clicking on Dollar Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Solar/Dollar Unit'),23)

			'Delay'
			Mobile.delay(30)
		}
		else
		{
			println ('Solar Dollar unit is not displayed')
		}

		'Delay'
		Mobile.delay(10)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Solar/kWh Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Solar kWh unit is displayed')

			'Clicking on kWh Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Solar/kWh Unit'),23)

			'Delay'
			Mobile.delay(10)
		}
		else
		{
			println ('Solar kWh unit is not displayed')
		}
		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)
	}
	if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Common/lblGasMenuUsage'),
	'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Gas')) {

		Mobile.tap(findTestObject('SCM Mobile/Usage/Common/lblGasMenuUsage'), 15)
		'Delay of 50 seconds'
		Mobile.delay(5)


		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/Dollar Unit'), 10, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Gas Dollar unit is displayed')

			'Clicking on Dollar Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Gas/Dollar Unit'),23)
		}
		else
		{
			println ('Gas Dollar unit is not displayed')
		}

		'Delay'
		Mobile.delay(10)

		if(Mobile.verifyElementVisible(findTestObject('SCM Mobile/Usage/Gas/CCF Unit'), 3, FailureHandling.CONTINUE_ON_FAILURE) == true)
		{
			println ('Gas CCF unit is displayed')

			'Clicking on CCF Unit'
			Mobile.tap(findTestObject('SCM Mobile/Usage/Gas/CCF Unit'),23)
		}
		else
		{
			println ('Gas CCF unit is not displayed')
		}

		'TC_UG_120'
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblMonthlyAverageUsagePower',
				'txtLblMonthlyAverageUsagePower')
		applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Usage/Power/txtLblHighThisYearUsagePower',
				'txtLblHighThisYearUsagePower')

		'TC_UG_122 Test Case for Meter Number'
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultMeterTitleUsagePower'),
		'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('All')) {

			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/ddlMeterNumberUsagePower'),15)

			ArrayList<MobileElement> lMeterNumberMenu = driver.findElementsById('android:id/text1')

			println('Size of Meter Number Menu :' + lMeterNumberMenu.size())
			def a = new String[3]
			a = ["All", "E00001", "E00002"]
			for (int index2 = 0; index2 < lMeterNumberMenu.size(); index2++) {
				String sMeterName = lMeterNumberMenu.get(index2).getAttribute('text')

				if (a.contains(sMeterName)) {
					println "Expected value present"
				}
				else
				{
					println "Some other value present in DDL of Meter Number"
				}

			}
			lMeterNumberMenu.get(0).click()

		}
		else
		{
			println "Default Value is not All and somethimg else is visible, please check manually"
		}

		'TC_UG_125 TC_UG_127Test Case for checking Time Periods'
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultPeriodTitleUsagePower'),
		'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Monthly')) {

			Mobile.tap(findTestObject('SCM Mobile/Usage/Power/txtLblDefaultPeriodTitleUsagePower'),15)
			ArrayList<MobileElement> lPeriodMenu = driver.findElementsById('android:id/text1')
			println('Size of Period Menu :' + lPeriodMenu.size())
			def a1 = new String[2]
			def a2 = new String[5]
			a1=["Monthly", "Season'"]
			a2=["Monthly", "Season" , "Daily", "Hourly" , "15 Min"]
			for (int index2 = 0; index2 < lPeriodMenu.size(); index2++) {
				String sPeriod = lPeriodMenu.get(index2).getAttribute('text')

				if (a1.contains(sPeriod)) {
					println "Expected value present"
				}
				else
				{
					println "Some other value present in DDL of Period"
				}

			}
			lPeriodMenu.get(0).click()
		}
		else
		{
			println "Default Value is not Monthly and somethimg else is visible, please check manually"
		}

		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


		'Delay'
		Mobile.delay(10)
	}


	'Delay'
	Mobile.delay(10)

	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
}
}