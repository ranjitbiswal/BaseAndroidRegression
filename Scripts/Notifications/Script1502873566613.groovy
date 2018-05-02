
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By.ByClassName as ByClassName
import org.openqa.selenium.By.ByCssSelector as ByCssSelector
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
import io.appium.java_client.MobileElement as MobileElement

'Starting the Application'
applicationMethods.ReusableMethods.verifyValidLogin()

'Delay of 30 Sec'
Mobile.delay(30)

@com.kms.katalon.core.annotation.TearDown
static void verifyNotificationsTestCases() {
    'TC : TC_NOT_1, TC_NOT_4, TC_NOT_5, TC_NOT_6 To verify that Notifications Tab and page Objects'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        System.out.println('Notifications Menu is Displayed')

        'Clicking on Notifications'
        Mobile.tap(findTestObject('SCM Mobile/LandingPage/Notifications Menu'), 5)

        'Delay of 5 Sec'
        Mobile.delay(5)

        'Check Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

        if (messageText.equals('Inbox')) {
            System.out.println('On Click on Notifications, User is routing to the Notifications - Inbox tab')

            'Clicking on Notifications Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 15)

            'Below are the tabs displayed in the Notification Hamburger Menu'
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notices Heading', 'Notices Heading')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Inbox Tab', 'Inbox Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Outages Tab', 'Outages Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Billing Tab', 'Billing Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Services Tab', 'Services Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Connect me Tab', 'Connect Me Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Leak Alert Tab', 'Leak Alert Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/All Mail Tab', 'All Mail Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Sent Tab', 'Sent Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Saved Tab', 'Saved Tab')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Trash Tab', 'Trash Tab')

            'Checking Outages Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Outages Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Outages Tab is Displayed')

                verifyNotificationOutagesTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Outages Tab TestCases because Notifications - Outages Tab is not Displayed')
            }
            
            'Checking Billing Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Billing Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Billing Tab is Displayed')

                verifyNotificationBillingTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Billing Tab TestCases because Notifications - Billing Tab is not Displayed')
            }
            
            'Checking Services Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Services Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Services Tab is Displayed')

                verifyNotificationServicesTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Services Tab TestCases because Notifications - Services Tab is not Displayed')
            }
            
            'Checking Connect Me Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Connect me Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Connect me Tab is Displayed')

                verifyNotificationConnectmeTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Connect me Tab TestCases because Notifications - Connect me Tab is not Displayed')
            }
            
            'Checking Leak Alert Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Leak Alert Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Leak Alert Tab is Displayed')

                verifyNotificationLeakAlertTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Leak Alert Tab TestCases because Notifications - Leak Alert Tab is not Displayed')
            }
            
            'Checking Sent Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/Sent Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - Sent Tab is Displayed')

                verifyNotificationSentTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - Sent Tab TestCases because Notifications - Sent Tab is not Displayed')
            }
            
            'Checking All Mail Tab in the Notification Hamburger Menu'
            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
            true) {
                System.out.println('Notifications - All Mail Tab is Displayed')

                verifyNotificationAllMailTabTestCases()
            } else {
                System.out.println('We are unable to verify the Notifications - All Mail Tab TestCases because Notifications - All Mail Tab is not Displayed')
            }
            
            'Deleting a Notification'
            verifyNotificationDeleteTestCase()

            'Deleting a Notification Permanently'
            verifyNotificationPermanentDeleteTestCase()

            'Replying a Notification'
            verifyNotificationReplyTestCase()
        } else {
            System.out.println('On Click on Notifications, user might route to the Notifications Module or something issue with the Module Name. Expected Module Name is : Inbox. Please check manually. ')
        }
    } else {
        System.out.println('We are unable to verify the Notifications Module TestCases because Notifications Menu is not Displayed')
    }
}

static void verifyNotificationOutagesTabTestCases() {
    'TC : TC_NOT_8 To verify that Notification - Outages Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Outages Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Outages Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Outage Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Outages Tab')
    } else {
        if (messageText.equals('Outages')) {
            System.out.println('On Click on the Notification - Outages Tab user is routing to the Notification - Outages Page')
        } else {
            System.out.println('On Click on the Notification - Outages Tab user may not route to Notification - Outages Tab. Expected Text is : "Outages" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationBillingTabTestCases() {
    'TC : TC_NOT_10 To verify that Notification - Billing Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Billing Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Billing Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Billing Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Outages Tab')
    } else {
        if (messageText.equals('Billing')) {
            System.out.println('On Click on the Notification - Billing Tab user is routing to the Notification - Billing Page')
        } else {
            System.out.println('On Click on the Notification - Billing Tab user may not route to Notification - Billing Tab. Expected Text is : "Billing" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationServicesTabTestCases() {
    'TC : TC_NOT_12 To verify that Notification - Services Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Services Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Services Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Services Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Services Tab')
    } else {
        if (messageText.equals('Services')) {
            System.out.println('On Click on the Notification - Services Tab user is routing to the Notification - Services Page')
        } else {
            System.out.println('On Click on the Notification - Services Tab user may not route to Notification - Services Tab. Expected Text is : "Services" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationConnectmeTabTestCases() {
    'TC : TC_NOT_14 TC_COM_16 To verify that Notification - Connect Me Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Connect me Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Connect me Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Connect me Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Connect me Tab')
    } else {
        if (messageText.equals('Connect Me')) {
            System.out.println('On Click on the Notification - Connect me Tab user is routing to the Notification - Connect me Page')
        } else {
            System.out.println('On Click on the Notification - Connect me Tab user may not route to Notification - Connect me Tab. Expected Text is : "Connect Me" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationLeakAlertTabTestCases() {
    'TC : TC_NOT_16 To verify that Notification - Leak Alert Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Leak Alert Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Leak Alert Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Leak Alert Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Leak Alert Tab')
    } else {
        if (messageText.equals('Leak Alert')) {
            System.out.println('On Click on the Notification - Leak Alert Tab user is routing to the Notification - LeakAlert Page')
        } else {
            System.out.println('On Click on the Notification - Leak Alert Tab user may not route to Notification - Leak Alert Tab. Expected Text is : "Leak Alert" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationSentTabTestCases() {
    'TC : TC_NOT_21 To verify that Notification - Sent Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Sent Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Sent Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying Sent Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - Sent Tab')
    } else {
        if (messageText.equals('Sent')) {
            System.out.println('On Click on the Notification - Sent Tab user is routing to the Notification - Sent Page')
        } else {
            System.out.println('On Click on the Notification - Sent Tab user may not route to Notification - Sent Tab. Expected Text is : "Sent" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationAllMailTabTestCases() {
    'TC : TC_NOT_31 To verify that Notification - All Mail Tab Test Cases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - All Mail Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Getting Message Text of the Module'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_notificationname').getText()

    'Verifying All Mail Module'
    if (messageText.equals(null)) {
        System.out.println('Something went wrong with Notification - All Mail Tab')
    } else {
        if (messageText.equals('All Mail')) {
            System.out.println('On Click on the Notification - All Mail Tab user is routing to the Notification - All Mail Page')
        } else {
            System.out.println('On Click on the Notification - All Mail Tab user may not route to Notification - All Mail Tab. Expected Text is : "All Mail" but Actual Text is ' + 
                messageText)
        }
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}

static void verifyNotificationDeleteTestCase() {
    'TC : TC_NOT_20, TC_NOT_32, TC_NOT_43 Test Case to Delete the Notification and Notification Object'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - All Mail Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Total Number of Notifications in the All Mail Tab'
    ArrayList<MobileElement> lNotificationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_notificationsfrom')

    println('All Mail Tab Notifications Count :' + lNotificationsCount.size())

    for (int index = 0; index < lNotificationsCount.size(); index++) {
        'Clicking on First Notification'
        lNotificationsCount.get(index).click()

        'Delay of 1 seconds'
        Mobile.delay(1)

        'TC -->  TC_NOT_43 -> Notification Objects'
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - From Heading', 
            'Notification - From Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - From TextBox', 
            'Notification - From TextBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - Subject Heading', 
            'Notification - Subject Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - Subject TextBox', 
            'Notification - Subject TextBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - Date Heading', 
            'Notification - Date Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Notification - Date Calendar', 
            'Notification - Date Calendar')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Message Text Field', 'Message Text Field')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Attachment Icon', 'Attachment Icon')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Reply Icon', 'Reply Icon')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Notifications/Trash Icon', 'Trash Icon')

        String sSubjectFirstNoificationAllMailTab = driver.findElementById('com.sus.scm_mobile:id/tv_subject_details').getText()

        'Clicking on Trash Icon'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Icon'), 3)

        'Clicking on Popup Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Yes Button'), 3)

        'Clicking on Delete Confirmation Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Ok Button'), 3)

        'Clicking on Notifications Hamburger Menu'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)

        'Clicking On Trash Tab'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Tab'), 3)

        ArrayList<MobileElement> lTrashNotificationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_notificationsfrom')

        println('Trash Tab Notifications Count :' + lTrashNotificationsCount.size())

        for (int index1 = 0; index1 < lTrashNotificationsCount.size(); index1++) {
            'Clicking on First Notification of Trash Tab'
            lTrashNotificationsCount.get(index).click()

            'Delay of 1 seconds'
            Mobile.delay(1)

            String sSubjectFirstNoificationTrashTab = driver.findElementById('com.sus.scm_mobile:id/tv_subject_details').getText()

            if (sSubjectFirstNoificationAllMailTab.equals(sSubjectFirstNoificationTrashTab)) {
                System.out.println('Verified that on deleting the Notification from the All mail tab, notification moved to the Trash Tab')
            } else {
                System.out.println('Verified that on deleting the Notification from the All mail tab, notification is not moved to the Trash Tab. Please check manually')
            }
            
            Mobile.pressBack()

            'Clicking on Notifications Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)

            break
        }
        
        break
    }
}

static void verifyNotificationPermanentDeleteTestCase() {
    'TC : TC_NOT_29 Test Case to Delete the Notification from the Trash'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - Trash Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Total Number of Notifications in the Trash Tab'
    ArrayList<MobileElement> lNotificationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_notificationsfrom')

    println('Trash Tab Notifications Count :' + lNotificationsCount.size())

    for (int index = 0; index < lNotificationsCount.size(); index++) {
        'Clicking on First Notification'
        lNotificationsCount.get(index).click()

        'Delay of 1 seconds'
        Mobile.delay(1)

        String sFirstTrashNotificationSubject = driver.findElementById('com.sus.scm_mobile:id/tv_subject_details').getText()

        'Clicking on Trash Icon'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Trash Icon'), 3)

        'Clicking on Popup Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Yes Button'), 3)

        'Clicking on Delete Confirmation Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Delete Confirmation Ok Button'), 3)

        ArrayList<MobileElement> lUpdateTrashNotificationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_notificationsfrom')

        println('Trash Tab Notifications Count :' + lUpdateTrashNotificationsCount.size())

        for (int index1 = 0; index1 < lUpdateTrashNotificationsCount.size(); index1++) {
            'Clicking on First Notification of Trash Tab'
            lUpdateTrashNotificationsCount.get(index).click()

            'Delay of 1 seconds'
            Mobile.delay(1)

            String sUpdatedFirstTrashNotificationSubject = driver.findElementById('com.sus.scm_mobile:id/tv_subject_details').getText()

            if (sFirstTrashNotificationSubject.equals(sUpdatedFirstTrashNotificationSubject)) {
                System.out.println('Verified that on deleting the Notification from the Trash Tab Something Went wrong, Please check Manually')
            } else {
                System.out.println('Verified that on deleting the Notification from the Trash Tab, Notification deleted from the Trash Deleted Successfully.')
            }
            
            Mobile.pressBack(FailureHandling.CONTINUE_ON_FAILURE)

            'Clicking on Notifications Hamburger Menu'
            Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)

            break
        }
        
        break
    }
}

static void verifyNotificationReplyTestCase() {
    'TC : TC_NOT_38 Test Case to Reply the Notification'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Notification - All Mail Tab'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/All Mail Tab'), 5)

    'Delay of 5 seconds'
    Mobile.delay(5)

    'Total Number of Notifications in the All Mail Tab'
    ArrayList<MobileElement> lNotificationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_notificationsfrom')

    println('All Mail Tab Notifications Count :' + lNotificationsCount.size())

    for (int index = 0; index < lNotificationsCount.size(); index++) {
        'Clicking on First Notification'
        lNotificationsCount.get(index).click()

        'Delay of 1 seconds'
        Mobile.delay(1)

        String sSubjectFirstNoificationAllMailTab = driver.findElementById('com.sus.scm_mobile:id/tv_subject_details').getText()

        'Clicking on Reply Icon'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Reply Icon'), 3)

        'Entering the Subject in the Message TextBox'
        Mobile.setText(findTestObject('SCM Mobile/Notifications/Message Text Field'), 'This is for Internal Testing', 3)

        Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

        'Clicking on Send Button'
        Mobile.tap(findTestObject('SCM Mobile/Notifications/Send Button'), 3)

        messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        if (messageText.equals('Message sent successfully.')) {
            System.out.println('Message sent successfully and Popup message text is as expected.')

            'Clicking on Popup Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            System.out.println('Something bad happened on replying the message. Please check manually. Expected Popup message text is Message sent successfully but Actual text is ' + 
                messageText)

            'Clicking on Popup Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        Mobile.pressBack()

        Mobile.delay(1)

        break
    }
    
    'Clicking on Notifications Hamburger Menu'
    Mobile.tap(findTestObject('SCM Mobile/Notifications/Notifications Hamburger Menu'), 3)
}