import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import io.appium.java_client.TouchAction as TouchAction
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

@com.kms.katalon.core.annotation.TearDown
static void verifyElectricVehicleTestCases() {
	'Delay of 15 Sec'
	Mobile.delay(10)
	String messageText = null

	Boolean bResult = false

	Boolean bResult1 = true

	Integer iBeforeCarCount = 0

	Integer iAfterCarCount = 0

	String sCar = null

	'Checking EV Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/EV Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('EV is not displayed in the Dashboard/Landing Page')
	} else {
		'Clicking on EV Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/EV Menu'), 5)

		'Delay'
		Mobile.delay(10)
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		ArrayList<MobileElement> ls = driver.findElementsByClassName('android.widget.Button')

		ls.get(1).click()
		'Delay'
		Mobile.delay(10)

		'TC_EV_1 TC_EV_4'
		'Click on Select Car Link > on Car selection'

		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/SelectCarBeforeEVUpdate'), 15)

		'Car List Before EV Update'
		ArrayList<MobileElement> lCarListBeforeEVUpdate = driver.findElementsByClassName('android.widget.CheckedTextView')

		'Car Count Before EV Update'
		iBeforeCarCount = lCarListBeforeEVUpdate.size()

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Clicking on Add Button'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/btnAddEV'), 6)

		'Selecting/Unselecting the Car from the Car List'
		ArrayList<MobileElement> lCarList = driver.findElementsByClassName('android.widget.CheckedTextView')

		println(lCarList.size())

		for (int index2 = 0; index2 < 1; index2++) {

			sCar = lCarList.get(index2).getText()
			lCarList.get(index2).click()
		}

		'Clicking on Save Button'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/btnSaveAddedEV'), 6)

		'Delay'
		Mobile.delay(20)

		'Getting Message Text after click on Save'
		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Electric Vehicle/EV/txtLblSettingSavePopUp'), 'text',
				5, FailureHandling.CONTINUE_ON_FAILURE)

		'Verifying EV Setting is Successfully Saved or Not'
		if (messageText.equals(null)) {
			System.out.println('Something went wrong with EV page Updation, Please check manually')
		} else {
			if (messageText.equals('Your settings have been saved successfully.')) {
				System.out.println('Your EV settings have been saved successfully.')
			} else {
				System.out.println('Your EV settings have been saved successfully. Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' +
						messageText)
			}
		}

		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 30)

		'Delay'
		Mobile.delay(20)

		'Checking Selected/UnSelected Car in the Car List DropDown'


		'Click on Select Car Link'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/SelectCarBeforeEVUpdate'), 15)
		'Car List After EV Update'
		ArrayList<MobileElement> lCarListAfterEVUpdate = driver.findElementsByClassName('android.widget.CheckedTextView')

		'Car Count After EV Update'
		iAfterCarCount = lCarListAfterEVUpdate.size()

		if(iBeforeCarCount > iAfterCarCount)
		{
			for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
				if (lCarListAfterEVUpdate.get(index4).getText().equals(sCar)) {
					bResult1 = false
				}
				else
				{
					bResult1 = true
				}
			}
		}
		else if(iBeforeCarCount < iAfterCarCount)
		{
			for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
				if (lCarListAfterEVUpdate.get(index4).getText().equals(sCar)) {
					bResult1 = true
					break
				}
			}
		}
		else
		{
			println('SomeThing is wrong, Please check EV car Add functionality manually')

		}

		if (bResult1 == true) {
			println('Car Selected from the Add Menu is displayed in the Car List DropDown OR Car UnSelected from the Add Menu is not displayed in the Car List DropDown')
		} else {
			println('SomeThing is wrong, Please check EV car Add functionality manually')
		}

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Delay'
		Mobile.delay(10)
		//   }
	}


	'Delay'
	Mobile.delay(10)

	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
	verifyChargingStationTestCase()

}

static void verifyElecticVehicleTestCase() {

	WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)
	'Delay of 15 Sec'
	Mobile.delay(10)
	String messageText = null

	Boolean bResult = false

	Boolean bResult1 = true

	Integer iBeforeCarCount = 0

	Integer iAfterCarCount = 0

	String sCar = null

	String
	int x = UsageMenu.getLocation().getX()

	int y = UsageMenu.getLocation().getY()

	'Checking EV Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/EV Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('EV is not displayed in the Dashboard/Landing Page')
	} else {
		'Clicking on EV Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/EV Menu'), 5)

		'Delay'
		Mobile.delay(10)
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		ArrayList<MobileElement> ls = driver.findElementsByClassName('android.widget.Button')

		ls.get(1).click()
		'Delay'
		Mobile.delay(10)

		'Click on Select Car Link > on Car selection'

		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/SelectCarBeforeEVUpdate'), 15)

		'Car List Before EV Update'
		ArrayList<MobileElement> lCarListBeforeEVUpdate = driver.findElementsByClassName('android.widget.CheckedTextView')

		'Car Count Before EV Update'
		iBeforeCarCount = lCarListBeforeEVUpdate.size()

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		'TC_EV_8 To verify that Upon Clicking on Add button application will open Popup which will have EV list with respective name checkbox'
		'Clicking on Add Button'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/btnAddEV'), 6)

		'Selecting/Unselecting the Car from the Car List'
		ArrayList<MobileElement> lCarList = driver.findElementsByClassName('android.widget.CheckedTextView')

		println(lCarList.size())

		for (int index2 = 0; index2 < 1; index2++) {

			sCar = lCarList.get(index2).getText()
			lCarList.get(index2).click()
		}

		'Clicking on Save Button'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/btnSaveAddedEV'), 6)

		'Delay'
		Mobile.delay(20)

		'Getting Message Text after click on Save'
		messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Electric Vehicle/EV/txtLblSettingSavePopUp'), 'text',
				5, FailureHandling.CONTINUE_ON_FAILURE)
		'TC_EV_10 TC_EV_9'
		'Verifying EV Setting is Successfully Saved or Not'
		if (messageText.equals(null)) {
			System.out.println('Something went wrong with EV page Updation, Please check manually')
		} else {
			if (messageText.equals('Your settings have been saved successfully.')) {
				System.out.println('Your EV settings have been saved successfully.')
			} else {
				System.out.println('Your EV settings have been saved successfully. Expected Text is : "Your Auto Pay details have been saved successfully." but Actual Text is ' +
						messageText)
			}
		}

		'Clicking on the Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 30)

		'Delay'
		Mobile.delay(20)

		'Checking Selected/UnSelected Car in the Car List DropDown'


		'Click on Select Car Link'
		Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/EV/SelectCarBeforeEVUpdate'), 15)
		'Car List After EV Update'
		ArrayList<MobileElement> lCarListAfterEVUpdate = driver.findElementsByClassName('android.widget.CheckedTextView')

		'Car Count After EV Update'
		iAfterCarCount = lCarListAfterEVUpdate.size()

		if(iBeforeCarCount > iAfterCarCount)
		{
			for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
				if (lCarListAfterEVUpdate.get(index4).getText().equals(sCar)) {
					bResult1 = false
				}
				else
				{
					bResult1 = true
				}
			}
		}
		else if(iBeforeCarCount < iAfterCarCount)
		{
			for (int index4 = 0; index4 < lCarListAfterEVUpdate.size(); index4++) {
				if (lCarListAfterEVUpdate.get(index4).getText().equals(sCar)) {
					bResult1 = true
					break
				}
			}
		}
		else
		{
			println('SomeThing is wrong, Please check EV car Add functionality manually')

		}

		if (bResult1 == true) {
			println('Car Selected from the Add Menu is displayed in the Car List DropDown OR Car UnSelected from the Add Menu is not displayed in the Car List DropDown')
		} else {
			println('SomeThing is wrong, Please check EV car Add functionality manually')
		}

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Delay'
		Mobile.delay(10)

		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		'Delay'
		Mobile.delay(10)
		//   }
	}


	'Delay'
	Mobile.delay(10)

	'Calling the Press Back Inbuilt funtion'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
}
''
static void verifyChargingStationTestCase() {
	'Delay of 15 Sec'


	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//	WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)

	'Checking EV Menu is Displayed on Dashboard or Not'
	if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/EV Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
	false) {
		System.out.println('EV is not displayed in the Dashboard/Landing Page')
	} else {
		'Clicking on EV Menu from Dashboard/Landing Page'
		Mobile.tap(findTestObject('SCM Mobile/LandingPage/EV Menu'), 5)

		'Delay'
		Mobile.delay(10)

		ArrayList<MobileElement> ls = driver.findElementsByClassName('android.widget.Button')

		ls.get(3).click()
		'TC_EV_18 Check Module Name'
		String messageText1 = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

		if (messageText1.equals('Charging Stations')) {
			System.out.println('On Click on Charging Stations from the EV Tab, User is routing to the Charging Stationn Module')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/btnCurrentLocationChargingStation',
					'btnCurrentLocationChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/btnListViewIconChargingStation',
					'btnListViewIconChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/btnRefreshChargingStation',
					'btnRefreshChargingStation')



			Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/Charging Station/btnListViewIconChargingStation'), 15)

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/btnDistancetabChargingStation',
					'btnDistancetabChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/btnRateTabChargingStation',
					'btnRateTabChargingStation')
			ArrayList<MobileElement> ls1 = driver.findElementsById('com.sus.scm_mobile:id/iv_evcar')
			'TC_EV_21 TC_EV_31 Test Case to check Sorting for Rate vice Charging Stations'
			'Bharti'
			Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/Charging Station/btnRateTabChargingStation'), 15)

			ArrayList<MobileElement> lsRate = driver.findElementsById('com.sus.scm_mobile:id/tv_ratedetail')
			System.out.println('lsRate :' + lsRate.size())
			if (lsRate.size() > 0) {
				System.out.println('Hence Payment options are already there with the account, hence selecting randomly payment method')
				def testArray = new Double[lsRate.size()]
				for (int index2 = 0; index2 <= lsRate.size()-1; index2++) {
					String Rate = lsRate.get(index2).getText()
					Rate = Rate.substring(6,9)
					double intRate = Double.parseDouble(Rate)


					testArray[index2] = intRate
					println testArray[index2]

				}
				println testArray

				for (int i = 0; i < testArray.length - 1; i++) {
					if (testArray[i] > testArray[i + 1]) {
						println "Rates are not in ascendimg or descending order"; // It is proven that the array is not sorted.
					}
					else
						println "Rates are sorted"; // If this part has been reached, the array must be sorted.
				}

			}
			'Bharti'
			'TC_EV_20 Test Case to check Sorting for Distance vice Charging Stations'
			'Bharti'
			Mobile.tap(findTestObject('SCM Mobile/Electric Vehicle/Charging Station/btnDistanceTabChargingStation'), 15)

			ArrayList<MobileElement> lsDistance = driver.findElementsById('com.sus.scm_mobile:id/tv_distance_detail')
			System.out.println('lsDistance :' + lsDistance.size())
			if (lsDistance.size() > 0) {
				System.out.println('Hence Payment options are already there with the account, hence selecting randomly payment method')
				def testArray = new Double[lsDistance.size()]
				for (int index2 = 0; index2 <= lsDistance.size()-1; index2++) {
					String Rate = lsDistance.get(index2).getText()
					Rate = Rate.substring(6,9)
					//int intRate = (int)Double.parseDouble(Rate);
					double intRate = Double.parseDouble(Rate)
					testArray[index2] = intRate
					println testArray[index2]

				}
				println testArray
				for (int i = 0; i < testArray.length - 1; i++) {
					if (testArray[i] > testArray[i + 1]) {
						println "Distance values are not sorted"; // It is proven that the array is not sorted.
					}
					else
						println "Distance values are Sorted"; // If this part has been reached, the array must be sorted.
				}
			}
			'Bharti'
			'TC_EV_33 TC_EV_37 To verify  there should be fields on pinned popup displayed on map '
			ls1.get(1).click()
			'Delay'
			Mobile.delay(10)

			'verify Details of selected Charging Station'
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/stationNameChargingStation',
					'stationNameChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/rateDetailsChargingStation',
					'rateDetailsChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/distanceDetailsChargingStation',
					'distanceDetailsChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/directionsDeiailsChargingStation',
					'directionsDeiailsChargingStation')
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Electric Vehicle/Charging Station/addressDetailsChargingStation',
					'addressDetailsChargingStation')


			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
			'Delay'
			Mobile.delay(10)

			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)

		}
		else
		{
			System.out.println('something issue with the Module Name. Expected Module Name is : Charging Stations Please check manually. ')
		}


		'Calling the Press Back Inbuilt funtion'
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		'Delay'
		Mobile.delay(10)
	}
}

//'Installing the Application on the Device'
//Mobile.closeApplication()
