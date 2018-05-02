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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.DesiredCapabilities

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.android.AndroidDriver

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Dimension
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
import org.openqa.selenium.Dimension

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

@com.kms.katalon.core.annotation.TearDown
static void verifyEfficiencytTestCases() {

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//WebElement UsageMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Usage Menu'), 20)
//WebElement NofMenu = MobileElementCommonHelper.findElement(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 20)
//
////int x,y
//int x = UsageMenu.getLocation().getX()
//int y = UsageMenu.getLocation().getY()
//int x1 = NofMenu.getLocation().getX()
//int y1 = NofMenu.getLocation().getY()
//int s2=x1-x
//int s1=y1-y
//TouchAction action = new TouchAction(driver)
//action.press(935,1535).moveTo(751, 0).release().perform()
//action.press(x, y).moveTo(-300, y).release().perform()

//Mobile.swipe(935,1535,184,1535, FailureHandling.STOP_ON_FAILURE)
//Mobile.swipe(935,1535,751,0, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(30)

'Checking Efficiency Menu is Displayed on Dashboard or Not'
if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Efficiency Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
false) {
    System.out.println('Efficiency is not displayed in the Dashboard/Landing Page')
} else {
    'Clicking on Efficiency Menu from Dashboard/Landing Page'
    Mobile.tap(findTestObject('SCM Mobile/LandingPage/Efficiency Menu'), 10)

	'Delay of 20 seconds'
	Mobile.delay(5)
	
	'Check Module Name'
	String messageText1 = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

	if (messageText1.equals('Efficiency')) {
		
	ArrayList<MobileElement> lEfficiencySideMenu = driver.findElementsByClassName('android.widget.TextView')

    println('Size of Billing Side Menu :' + lEfficiencySideMenu.size())

	'TC_EEC_001'

		if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblRebatesMenuEfficiency'),
			'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Rebates')) {

			Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblRebatesMenuEfficiency'), 15)
			'Delay of 50 seconds'
			Mobile.delay(5)
			
			'bhartt'
			ArrayList<MobileElement> lRebatesideMenu = driver.findElementsById('com.sus.scm_mobile:id/tv_rebates_details')
			
				println('Size of Billing Side Menu :' + lRebatesideMenu.size())
			
				'Printing Billing Side Menu List'
				println('Billing Side Menu List Contains :')
				'TC_EEC_007'
				for (int index2 = 0; index2 < lRebatesideMenu.size(); index2++) {
					lRebatesideMenu.get(index2).click()
					
					'verify likes, Enrolled Status, Viewed Details, Read More'
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/ViewedDtails',
						'SCM Mobile/Efficiency/Rebates/ViewedDtails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/SaveUptoDetails',
						'SCM Mobile/Efficiency/Rebates/SaveUptoDetails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/DescriptionDetails',
						'SCM Mobile/Efficiency/Rebates/DescriptionDetails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/AddedDetails',
						'SCM Mobile/Efficiency/Rebates/AddedDetails')
					
					
					'verify Objects on Enroll into Rebates'
					if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Efficiency/Rebates/btnEnrollEfficiency'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
						false) {
							System.out.println('EnrollButton is not displayed in the Efficiency Page, already enrolled')
						} else {
							System.out.println('Enroll Button is displayed on the Efficinecy Page')
							Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/btnEnrollEfficiency'), 15)
							'TC --> TC_EEC_012'
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
					
					'TC_EEC_010'
					
					'Entering Email Address'
					Mobile.setText(findTestObject('SCM Mobile/Connect Me/Email Address'), GlobalVariable.sEnrollEmailEfficiency, 3)
					'Entering Subject'
				//	Mobile.setText(findTestObject('SCM Mobile/Connect Me/Subject'), GlobalVariable.sEnrollSubjectEfficiency, 3)
					'Hide KeyBoard'
					Mobile.hideKeyboard()
					'Entering Comments'
					Mobile.setText(findTestObject('SCM Mobile/Connect Me/Comments'), GlobalVariable.sEnrollCommenctsEfficiency, 3)
					'Hide KeyBoard'
					Mobile.hideKeyboard()
						'Submit Enrollment Form'
					Mobile.tap(findTestObject('SCM Mobile/Connect Me/Connect Me Submit Button'), 15)
					
					'Clicking on the PopUp Ok Button'
					Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3)
					
					String messageText2 = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
					
						if (messageText2.equals('Efficiency')) {
							println "Successfully Enrolled"
						}
						}

						String s= driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
					if (s.equals('Efficiency'))  {
						Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblRebatesMenuEfficiency'), 15)
					}
					else
					{
					'Calling the Press Back Inbuilt funtion'
					Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
		
					'Delay'
					Mobile.delay(4)
					}
				}
				
			'bhartt'
			'bharti'
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
        }
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblProgramsMenuEfficiency'),
			'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Programs')) {
		
			Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblProgramsMenuEfficiency'), 15)
			
			'Delay of 50 seconds'
			Mobile.delay(5)
			'bhartt'
			ArrayList<MobileElement> lProgramsideMenu = driver.findElementsById('com.sus.scm_mobile:id/tv_rebates_details')
			
				println('Size of Billing Side Menu :' + lProgramsideMenu.size())
			
				'TC_EEC_001'
				for (int index2 = 0; index2 < lProgramsideMenu.size(); index2++) {
					lProgramsideMenu.get(index2).click()
					
					'verify likes, Enrolled Status, Viewed Details, Read More'
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/ViewedDtails',
						'SCM Mobile/Efficiency/Rebates/ViewedDtails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/SaveUptoDetails',
						'SCM Mobile/Efficiency/Rebates/SaveUptoDetails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/DescriptionDetails',
						'SCM Mobile/Efficiency/Rebates/DescriptionDetails')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Efficiency/Rebates/AddedDetails',
						'SCM Mobile/Efficiency/Rebates/AddedDetails')
					
					'verify Objects on Enroll into Rebates'
					if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Efficiency/Rebates/btnEnrollEfficiency'), 3, FailureHandling.CONTINUE_ON_FAILURE) ==
						false) {
							System.out.println('EnrollButton is not displayed in the Efficiency Page, already enrolled')
						} else {
							System.out.println('Enroll Button is displayed on the Efficinecy Page')
							Mobile.tap(findTestObject('SCM Mobile/Efficiency/Rebates/btnEnrollEfficiency'), 15)
							'TC --> TC_EEC_012'
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
					
					'TC_EEC_010'
					
					'Entering Email Address'
					Mobile.setText(findTestObject('SCM Mobile/Connect Me/Email Address'), GlobalVariable.sEnrollEmailEfficiency, 3)
					'Entering Subject'
				//	Mobile.setText(findTestObject('SCM Mobile/Connect Me/Subject'), GlobalVariable.sEnrollSubjectEfficiency, 3)
					'Hide KeyBoard'
					Mobile.hideKeyboard()
					'Entering Comments'
					Mobile.setText(findTestObject('SCM Mobile/Connect Me/Comments'), GlobalVariable.sEnrollCommenctsEfficiency, 3)
					'Hide KeyBoard'
					Mobile.hideKeyboard()
						'Submit Enrollment Form'
					Mobile.tap(findTestObject('SCM Mobile/Connect Me/Connect Me Submit Button'), 15)
					
					'Clicking on the PopUp Ok Button'
					Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3)
					
					String messageText2 = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
					
						if (messageText2.equals('Efficiency')) {
							println "Successfully Enrolled"
						}
						}

			String s= driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()
					if (s.equals('Efficiency'))  {
						Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblProgramsMenuEfficiency'), 15)
					}
					else
					{
					'Calling the Press Back Inbuilt funtion'
					Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
		
					'Delay'
					Mobile.delay(4)
					}
				}
				
			'bhartt'
			'bharti'
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
        }
			
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
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblEnrollmentStatusMenuEfficiency'),
			'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Enrollment Status')) {
		//	lEfficiencySideMenu.get(index).click()
			Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblEnrollmentStatusMenuEfficiency'), 15)
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblGoalRankMenuEfficiency'),
			'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Goal/Rank')) {
		
			Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblGoalRankMenuEfficiency'), 15)
			
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
		if (Mobile.getAttribute(findTestObject('SCM Mobile/Efficiency/lblEnergyAssistanceMenuEfficiency'),
			'text', 5, FailureHandling.CONTINUE_ON_FAILURE).equals('Energy Assistance')) {
		//	lEfficiencySideMenu.get(index).click()
			Mobile.tap(findTestObject('SCM Mobile/Efficiency/lblEnergyAssistanceMenuEfficiency'), 15)
			
			
			'Delay of 50 seconds'
			Mobile.delay(50)
			
			
			'Calling the Press Back Inbuilt funtion'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)


			'Delay'
			Mobile.delay(10)

		}
   // }
}
}
}