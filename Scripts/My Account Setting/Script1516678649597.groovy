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
Mobile.delay(30)

'Clicking on the Hamburger Menu'
Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

@com.kms.katalon.core.annotation.TearDown
static void verifyMyAccountSettingsTestCases() {
    'TC : TC_MAS_1, TC_MAS_2, TC_MAS_31 To verify that Settings Tab, its page objects and Save the Setting'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

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
        
        'Checking Settings Objects'
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment Heading', 
            'Configure Payment Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Language Heading', 
            'Language Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Paperless Bill CheckBox', 
            'Paperless Bill CheckBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Paperless Bill Heading', 
            'Paperless Bill Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Save Button', 'Save Button')

        'TC --> TC_MAS_31'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Save Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        false) {
            System.out.println('Save Button is not Displayed in Settings Menu, So Save Button Test Cases cannot be verified')
        } else {
            System.out.println('Save Button is Displayed in Settings Menu')

            'Clicking on Save Button'
            Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Save Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, 
                FailureHandling.CONTINUE_ON_FAILURE)

            if (messageText.equals(GlobalVariable.sSettingsSaveMessageText)) {
                System.out.println('Configured settings have been changed successfully.')
            } else {
                System.out.println((('Something bad happened on the updating the Settings. Please check manually. Expected Popup message text is ' + 
                    GlobalVariable.sSettingsSaveMessageText) + 'but Actual Text is ') + messageText)
            }
            
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        'Verifying Configure Payment Test Cases'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment Heading'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Settings Configure Payment Heading is not Displayed in Settings Menu, So Settings Configure Payment Heading Test Cases cannot be verified')
        } else {
            System.out.println('Settings Configure Payment Heading is Displayed in Settings Menu')

            verifyMyAccountSettingsConfigurePaymentTestCases()
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Language Heading'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        false) {
            System.out.println('Settings Language Heading is not Displayed in Settings Menu, So Settings Language Heading Test Cases cannot be verified')
        } else {
            System.out.println('Settings Language Heading is Displayed in Settings Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill CheckBox'), 3, 
            FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Paperless Bill CheckBox is not Displayed in Settings Menu, So Paperless Bill CheckBox Test Cases cannot be verified')
        } else {
            System.out.println('Paperless Bill CheckBox is Displayed in Settings Menu')
        }
        
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill Heading'), 3, 
            FailureHandling.CONTINUE_ON_FAILURE) == false) {
            System.out.println('Paperless Bill Heading is not Displayed in Settings Menu, So Paperless Bill Heading Test Cases cannot be verified')
        } else {
            System.out.println('Paperless Bill Heading is Displayed in Settings Menu')
        }
    }
}

static void verifyMyAccountSettingsConfigurePaymentTestCases() {
    'TC : TC_MAS_13, TC_MAS_14, TC_MAS_17, TC_MAS_18 To verify that Configure Payment Tab, its page objects and Change Payment Type'
    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    String messageText

    'Clicking on Configure Payment '
    Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment Heading'), 3, FailureHandling.STOP_ON_FAILURE)

    'Checking the Popup Heading Name'
    messageText = driver.findElementById('com.sus.scm_mobile:id/text_view_configure_payment').getText()

    if (messageText.equals('Configure Payment')) {
        System.out.println('On Click on Configure Payment from the Setting Tab, User is routing to the Configure Payment')
    } else {
        System.out.println('On Click on Configure Payment from the Setting Tab, user might route to the Configure Payment or something issue with the Module Name. Expected Module Name is : Configure Payment. Please check manually. ')
    }
    
    'Checking Configure Payment Objects'
    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Popup Heading', 
        'Configure Payment Popup Heading')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Popup Close Button', 
        'Configure Payment Popup Close Button')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Select Payment Type Heading', 
        'Select Payment Type Heading')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Monthly Billing Radio Button', 
        'Payment Type Monthly Billing Radio Button')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Pay as you go Radio Button', 
        'Payment Type Pay as you go Radio Button')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/I Agree CheckBox', 
        'I Agree CheckBox')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/I Agree to Terms and Conditions Link', 
        'I Agree to Terms and Conditions Link')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Informational Text', 
        'Configure Payment Informational Text')

    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Save Button', 
        'Configure Payment Save Button')

    'TC_MAS_17, TC_MAS_18  --> Updating the Payment Method'
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

            '*****Checking the impact of Payment Type on Other Modules****'

            'Checking the impact of Payment Type on Setting Module'

            'Checking PaperLess Bill Option & CheckBox'
            if ((Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill CheckBox'), 
                3, FailureHandling.CONTINUE_ON_FAILURE) == false) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill Heading'), 
                3, FailureHandling.CONTINUE_ON_FAILURE) == false)) {
                System.out.println('Paperless Bill Heading & CheckBox is not Displayed in Settings Menu, which is as expected')
            } else {
                System.out.println('Paperless Bill Heading Or CheckBox  is Displayed in Settings Menu. Payment Type updation not having any impact. Please check manually.')
            }
            
            'Checking the impact of Payment Type on Billing Module'

            'Clicking on PressBack'
            Mobile.pressBack()
			
			'TC_BLG_129 To verify if user has selected the pay you, user should see the following submodule  in Billing'
            'Verifying Billing Module is Displayed or not'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('We are unable to verify the impact of Payment Type change on Billing Module, as Billing Module is not displayed on Dashboard Page')
            } else {
                'Clicking On Billing Tab'
                Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                if (((((Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Auto Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                false) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Budget My Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                false)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                false)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Level Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                false)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Rate Analysis Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                false)) {
                    System.out.println('Auto Pay Menu, Budget My Bill Menu, History Menu, Level Pay Menu, Rate Analysis Menu is not Displayed in Billing Module, which is as expected')
                } else {
                    System.out.println('Auto Pay Menu/Budget My Bill Menu/History Menu/Level Pay Menu/Rate Analysis Menu  is Displayed in Billing Module. Payment Type updation not having any impact. Please check manually.')
                }
                
                'Clicking on Utility Tab from Billing'
                Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking the Button name is Pay Now or Recharge'
             
				   String sButtonText = driver.findElementById('com.sus.scm_mobile:id//bt_paybill').getText()
				'TC_BLG_134 To verify if user has selected Pay as you option, System shall display the following Bill summary on dashboard'
                if (sButtonText.equals('Recharge')) {
                    System.out.println('Button text changes to Recharge is Utility Menu, which is as expected')
					
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/txtLblRechargeAmount',
						'Utility Button - Last Recharge Amount')
					applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Billing/Utility Bill/txtLblRemainingBalance',
						'Utility Bill - Remaining Balance')
					
					 } else {
                    System.out.println('Button text is not as Expected. Payment Type updation not having any impact. Please check manually. ')
                }
                
                Mobile.pressBack()
                Mobile.delay(3)
                Mobile.pressBack()
                Mobile.delay(3)
            }
            
            'Checking the impact of Payment Type on Notifications Module'

            'Verifying Notifications Module is Displayed or not'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('We are unable to verify the impact of Payment Type change on Notifications Module, as Notifications Module is not displayed on Dashboard Page')
            } else {
                'Clicking On Notifications Tab'
                Mobile.tap(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)
                Mobile.delay(3)

                'Clicking On Notifications Hamburger Menu'
                Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking Billing Module is displayed Or Not'
                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu - Billing Tab'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == false) {
                    System.out.println('Billing is not Displayed in Notifications Module, which is as expected')
                } else {
                    System.out.println('Billing is Displayed in the Notifications Module, which is against the requirement. Please check manually.')
                }
                
                Mobile.pressBack()
                Mobile.delay(3)
            }
        } else {
            System.out.println((('Something bad happened on the updating the Payment Type. Please check manually. Expected Popup message text is ' + 
                GlobalVariable.sPaymentTypeUpdateMessageFromMonthlyToPayAsYouGo) + ' but Actual text is ') + messageText)

            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
        }
    } else if (Mobile.getAttribute(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Pay as you go Radio Button'), 
        'checked', 1, FailureHandling.CONTINUE_ON_FAILURE).equals('true')) {
        System.out.println('Payment Type Pay as you go Radio Button is Selected')

        'Changing the Payment Type from Pay as you Go to Monthly Billing'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Payment Type Monthly Billing Radio Button'), 
            3, FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking on I Agree Checkbox'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/I Agree CheckBox'), 3, FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking on Save Buton'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Configure Payment/Configure Payment Save Button'), 
            3, FailureHandling.CONTINUE_ON_FAILURE)

        messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 1, FailureHandling.CONTINUE_ON_FAILURE)

        if (messageText.equals(GlobalVariable.sPaymentTypeUpdateMessageFromPayAsYouGoToMonthly)) {
            System.out.println('Payment Type Updated Successfully and Popup message text is as expected.')

            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking the impact of Payment Type on Other Modules'

            'Checking the impact of Payment Type on Setting Module'

            'Checking PaperLess Bill Option & CheckBox'
            if ((Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill CheckBox'), 
                3, FailureHandling.CONTINUE_ON_FAILURE) == true) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Hamburger Menu/Settings/Paperless Bill Heading'), 
                3, FailureHandling.CONTINUE_ON_FAILURE) == true)) {
                System.out.println('Paperless Bill Heading & CheckBox is Displayed in Settings Menu, which is as expected')
            } else {
                System.out.println('Paperless Bill Heading Or CheckBox is not Displayed in Settings Menu. Payment Type updation not having any impact. Please check manually.')
            }
            
            'Checking the impact of Payment Type on Billing Module'

            'Clicking on PressBack'
            Mobile.pressBack()
            Mobile.delay(2)

            'Verifying Billing Module is Displayed or not'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('We are unable to verify the impact of Payment Type change on Billing Module, as Billing Module is not displayed on Dashboard Page')
            } else {
                'Clicking On Billing Tab'
                Mobile.tap(findTestObject('SCM Mobile/LandingPage/Billing Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                if (((((Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Auto Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                true) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Budget My Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                true)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/History Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                true)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Level Pay Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                true)) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Billing/Rate Analysis Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
                true)) {
                    System.out.println('Auto Pay Menu, Budget My Bill Menu, History Menu, Level Pay Menu, Rate Analysis Menu is Displayed in Billing Module, which is as expected')
                } else {
                    System.out.println('Auto Pay Menu/Budget My Bill Menu/History Menu/Level Pay Menu/Rate Analysis Menu is not Displayed in Billing Module. Payment Type updation not having any impact. Please check manually.')
                }
                
                'Clicking on Utility Tab from Billing'
                Mobile.tap(findTestObject('SCM Mobile/Billing/Utility Bill Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking the Button name is Pay Now or Recharge'
                String sButtonText = driver.findElementById('com.sus.scm_mobile:id/bt_paybill').getText()

                if (sButtonText.equals('Pay Now')) {
                    System.out.println('Button text changes to Pay Now is Utility Menu, which is as expected')
                } else {
                    System.out.println('Button text is not as Expected. Payment Type updation not having any impact. Please check manually. ')
                }
                
                Mobile.pressBack()
                Mobile.delay(3)
                Mobile.pressBack()
                Mobile.delay(3)
            }
            
            'Checking the impact of Payment Type on Notifications Module'

            'Verifying Notifications Module is Displayed or not'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            false) {
                System.out.println('We are unable to verify the impact of Payment Type change on Notifications Module, as Notifications Module is not displayed on Dashboard Page')
            } else {
                'Clicking On Notifications Tab'
                Mobile.tap(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Clicking On Notifications Hamburger Menu'
                Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Checking Billing Module is displayed Or Not'
                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu - Billing Tab'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                    System.out.println('Billing is Displayed in Notifications Module, which is as expected')
                } else {
                    System.out.println('Billing is not Displayed in the Notifications Module, which is against the requirement. Please check manually.')
                }
                
                Mobile.pressBack()
                Mobile.delay(3)
                Mobile.pressBack()
                Mobile.delay(3)
            }
        } else {
            System.out.println((('Something bad happened on the updating the Payment Type. Please check manually. Expected Popup message text is ' + 
                GlobalVariable.sPaymentTypeUpdateMessageFromPayAsYouGoToMonthly) + ' but Actual text is ') + messageText)

            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        'Clicking on the Hamburger Menu'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Hamburger Menu'), 5)

        'Clicking on the Settings'
        Mobile.tap(findTestObject('SCM Mobile/Hamburger Menu/Settings/Settings Menu'), 5)
    } else {
        System.out.println('Payment Type is not Selected, Check Manually, Payment Type should be selected')

        Mobile.pressBack()

        Mobile.delay(3)
    }
}