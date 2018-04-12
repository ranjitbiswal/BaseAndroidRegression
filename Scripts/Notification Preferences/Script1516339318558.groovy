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
import org.openqa.selenium.interactions.TouchScreen as TouchScreen
import org.openqa.selenium.interactions.touch.TouchActions as TouchActions
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
import io.appium.java_client.TouchAction as TouchAction

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 30 Sec'
Mobile.delay(10)

'Clicking on the Hamburger Menu'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

@com.kms.katalon.core.annotation.TearDown
static void verifyNotificationPreferencesTestCases() {
	
	'TC : TC_MANP_1, TC_MANP_2 To verify that Notification Preferences Tab and page objects'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Checking Notification Preferences is Displayed on Hamburger Menu or Not'
    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Menu'), 
        3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
        System.out.println('Notification Preferences is not Displayed in Hamburger Menu, So Notification Preferences Test Cases cannot be verified')
    } else {
        System.out.println('Notification Preferences is Displayed in Hamburger Menu')

        'Clicking on the Notification Preferences'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Menu'), 5)

        'Checking Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        if (messageText.equals('Notification Preferences')) {
            System.out.println('On Click on Notification Preferences from the Hamburger Menu, User is routing to the Notification Preferences Module')
        } else {
            System.out.println('On Click on Notification Preferences from the Hamburger Menu, user might route to the Notification Preferences Module or something issue with the Module Name. Expected Module Name is : Notification Preferences. Please check manually. ')
        }
        
        'Checking Notification Preferences Objects'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Billing Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Billing Menu is not Displayed in Hamburger Menu, So Notification Preferences Billing Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Billing Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Budget Limit Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Budget Limit Menu is not Displayed in Hamburger Menu, So Notification Preferences Budget Limit Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Budget Limit Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Budget Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Budget Menu is not Displayed in Hamburger Menu, So Notification Preferences Budget Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Budget Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Connect Me Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Connect Me Menu is not Displayed in Hamburger Menu, So Notification Preferences Connect Me Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Connect Me Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences High Usage Alert Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences High Usage Alert Menu is not Displayed in Hamburger Menu, So Notification Preferences High Usage Alert Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences High Usage Alert Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Leak Alert Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Leak Alert Menu is not Displayed in Hamburger Menu, So Notification Preferences Leak Alert Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Leak Alert Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Outage Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Outage Menu is not Displayed in Hamburger Menu, So Notification Preferences Outage Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Outage Menu is Displayed in Notification Preferences Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Services Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Notification Preferences Services Menu is not Displayed in Hamburger Menu, So Notification Preferences Services Menu Test Cases cannot be verified')
        } else {
            System.out.println('Notification Preferences Services Menu is Displayed in Notification Preferences Menu')
        }
        'Need to check'
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Save Button', 
            'Notification Preferences Save Button')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Quiet Hours CheckBox', 
            'Notification Preferences Quiet Hours CheckBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Quiet Hours Heading', 
            'Notification Preferences Quiet Hours Heading')
		'BHarti'
	//	AppiumDriver<?> driver1 = MobileDriverFactory.getDriver()
		ArrayList<MobileElement> lNotificationPreferences = driver.findElementsByClassName('android.widget.TextView')
		
			'Getting Random Number'
			int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, lNotificationPreferences.size() - 1)
		
			for (int index1 = randomnumber; index1 < lNotificationPreferences.size(); ) {
				String sNotificationPrefModuleName = lNotificationPreferences.get(index1).getText()
		
				'Clicking on Notification Preferences Side Menu'
				lNotificationPreferences.get(index1).click()
		
				'Delay of 1 seconds'
				Mobile.delay(1)
		
				ArrayList<MobileElement> lNotificationMedium = driver.findElementsByClassName('android.widget.TextView')
		
				'Getting Random Number'
				int randomnumber1 = utility.RandomRange.nextRandomIntegerInRange(1, lNotificationMedium.size())
		
				for (int index2 = randomnumber1; index2 < lNotificationMedium.size(); ) {
					if (lNotificationMedium.get(index2).getText().equals('Text')) {
						println('Updating the Notification Medium Text')
						''
						messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/CheckBoxTextField'), 'checked', 1, FailureHandling.CONTINUE_ON_FAILURE)
						
								if (messageText.equals("false")){
									println('Notification Text Medium is not selected, so we are selecting this medium')
									
									'Clicking on Check Box'
									Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/CheckBoxTextField'),
										3, FailureHandling.CONTINUE_ON_FAILURE)
									}
						
//						if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/TextFieldTextBox'),
//							3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
//							println('Notification Text Medium is not selected, so we are selecting this medium')
//		
//							'Clicking on Text Field Text Box'
//							Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/TextFieldTextBox'),
//								3, FailureHandling.CONTINUE_ON_FAILURE)
//						} 
							else {
							println('Notification Text Medium is already selected, so we are continuing this medium')
		
							'Clicking on Text Field Text Box'
							lNotificationMedium.get(index2).click()
		
							'Clearing the Text Field'
							Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/TextFieldTextBox'),
								0, FailureHandling.CONTINUE_ON_FAILURE)
		
							'Entering the Phone Number in Text Field'
							Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/TextFieldTextBox'),
								GlobalVariable.sAlternateNumber, 4)
							'Hide KeyBoard'
							Mobile.hideKeyboard()
						
						}
					} else if (lNotificationMedium.get(index2).getText().equals(
						'Email Address')) {
						println('Updating the Notification Medium Email')
		
						if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/EmailAddressTextBox'),
							3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
							println('Notification Email Address Medium is already selected, so we are unselecting this medium')
		
							'Clicking on Email Address Field Text Box'
							Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/EmailAddressTextBox'),
								3, FailureHandling.CONTINUE_ON_FAILURE)
						} else {
							println('Notification Email Address Medium is already selected, so we are unselecting this medium')
		
							'Clicking on Email Address Field Text Box'
							lNotificationMedium.get(index2).click()
		
							'Clearing Email Address Text Field'
							Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/EmailAddressTextBox'),
								0, FailureHandling.CONTINUE_ON_FAILURE)
		
							'Entering the Email Address in Text Field'
							Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/EmailAddressTextBox'),
								GlobalVariable.sEmailAddress, 4)
							'Hide KeyBoard'
							Mobile.hideKeyboard()
						
						}
					} else if (lNotificationMedium.get(index2).getText().equals(
						'Voice Call')) {
						println('Updating the Notification Medium IVR')
		
						if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/VoiceCallTextBox'),
							3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
							println('Notification IVR Medium is already selected, so we are unselecting this medium')
		
							'Clicking on IVR Field Text Box'
							Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/VoiceCallTextBox'), 3, FailureHandling.CONTINUE_ON_FAILURE)
						} else {
							println('Notification IVR Medium is already selected, so we are unselecting this medium')
		
							'Clicking on IVR Field Text Box'
							lNotificationMedium.get(index2).click()
		
							'Clearing the IVR Field'
							Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/VoiceCallTextBox'), 0,
								FailureHandling.CONTINUE_ON_FAILURE)
		
							'Entering the Phone Number in IVR Field'
							Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/VoiceCallTextBox'), GlobalVariable.sAlternateNumber,
								4)
							'Hide KeyBoard'
							Mobile.hideKeyboard()
						
						}
					}
					
					break
				}
				
				'Clicking on Done Button'
				Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Done Button'), 5)
		
				'Clicking on Submit Button'
				Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/btnSaveNP'), 5)
		
				if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/btnIAgreeNP'),
					3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
		
					'Clicking on I Agree Button'
					Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/btnIAgreeNP'),
						3, FailureHandling.CONTINUE_ON_FAILURE)
				}
					
					'Delay of 1 seconds'
					Mobile.delay(30)
			
				'Getting configuration update text in the String Variable'
				String messageText1 = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'value',
					5, FailureHandling.CONTINUE_ON_FAILURE)
		
				'Checking Configuration Updation Message Text is matching with the Expeced Text or Not'
				if (messageText1.equals(GlobalVariable.sNotificationPreferencesUpdationMessageText)) {
					System.out.println('Notification Preferences Updated Successfully')
				} else {
					System.out.println((('Notification Preferences Updated Text is not matching with the Expected Text, Expected Text is : ' +
						GlobalVariable.sNotificationPreferencesUpdationMessageText) + ' but Actual Text is ') + messageText)
				}
				
				'Clicking on the PopUp Ok Button'
				Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)
		
				'Delay of 5 seconds'
				Mobile.delay(5)
		
				break
			}
			
			'Clicking on the Back Button'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
		
			'Delay'
			Mobile.delay(10)
		
			'Clicking on Hamburger Menu from Dashboard/Landing Page'
			Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)
			
			'Clicking on the Notification Preferences'
			Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Menu'), 5)
	
		
		'Bharti'
		'TC_SD_20'
		'Quiet Hours'
		Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/btnQuietHoursNP'), 5)
		
		Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Save Button'), 5)
		Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
  
		'TC_SD_21'
		'Budget Limit'
		'Clicking on the Notification Preferences'
	  Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/Notification Preferences Budget Limit Menu'), 5)
	  
	  
		  'Clearing the Budget Limit Text Field'
		  Mobile.clearText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/txtEditBudgetlimitNP'), 3)
	  
		  'Entering Limit'
		  Mobile.setText(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/txtEditBudgetlimitNP'), "40", 3)
	  
		  'Hide KeyBoard'
		  Mobile.hideKeyboard()
	  
	  Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Notification Preferences/btnSubmitBudgetlimitNP'), 5)
	
	      }
}