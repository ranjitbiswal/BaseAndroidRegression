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
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF as ElseExpressionBNF
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import io.appium.java_client.TouchAction as TouchAction

String messageText = null

boolean bResult = false

boolean bResult1 = false

'Starting the Application'
applicationMethods.ReusableMethods.startApplication()

'Delay of 30 Sec'
Mobile.delay(30)

//
//
//'***********************************************'
//
//
//'Again Clicking on MoreOptions Menu Icon'
//Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)
//
//'Delay of 5 Sec'
//Mobile.delay(5)
//
//'***********************************************'
//
//'Verifying Login Help Tab is Displayed in MoreOptionsMenu or Not'
//if ((bResult == true) && (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
//    3, FailureHandling.CONTINUE_ON_FAILURE) == true)) {
//    System.out.println('MoreOptionsMenu SCM Website Tab is Displayed')
//
//    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)
//
//    'Delay of 25 Sec'
//    Mobile.delay(25)
//
//    'Getting Login Help Tab Side Menu Elements in the List'
//    ArrayList<MobileElement> lMoreMenuLoginHelpSideMenu = driver.findElementsByClassName('XCUIElementTypeCell')
//
//    if (lMoreMenuLoginHelpSideMenu.size() > 0) {
//        'Getting Account Number from the DataBase'
//        String sAccountNumberQuery = 'SELECT Top 1 UA.UtilityAccountNumber FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'
//
//        String sAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery)
//
//        System.out.println(sAccountNumber)
//
//        'Getting Email from the DataBase'
//        String sEmailQuery = 'SELECT Top 1 U.EmailID FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'
//
//        String sEmail = database.DataBaseUtil.executeSQLQuery(sEmailQuery)
//
//        System.out.println(sEmail)
//
//        'Getting Password from the DataBase'
//        String sPasswordQuery = 'SELECT Top 1 U.Password FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'
//
//        String sCurrentPassword = database.DataBaseUtil.executeSQLQuery(sPasswordQuery)
//
//        System.out.println(sCurrentPassword)
//
//        for (int index = 0; index < lMoreMenuLoginHelpSideMenu.size(); index++) {
//            lMoreMenuLoginHelpSideMenu.get(index).findElementByClassName('XCUIElementTypeButton').click()
//
//            'Delay of 10 Sec'
//            Mobile.delay(10)
//
//            if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Forgot Username')) {
//                bResult1 = true
//
//                'Entering the Email Address'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'), 
//                    sEmail, 4)
//
//                'Entering the Account Number'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Account Number TextBox'), 
//                    sAccountNumber, 4)
//
//                'Clicking on the Keyboard Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)
//
//                'Clicking on the Submit Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Submit Button'), 
//                    3, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Delay of 10 Sec'
//                Mobile.delay(10)
//
//                'Getting the Forgot UserName Message Text in the String variable'
//                messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'), 
//                    'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Checking Forgot UserName Message Text is matching with the Expeced Text or Not'
//                if (messageText.equals(GlobalVariable.sForgotUserNameText)) {
//                    System.out.println('Forgot Username Email sent to the registered email :' + sEmail)
//                } else {
//                    System.out.println('Something went wrong with the Forgot Username functionality message Text is ' + 
//                        messageText)
//                }
//                
//                'Clicking on the Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'), 
//                    5)
//
//                'Delay of 5 Sec'
//                Mobile.delay(5)
//
//                'Again Clicking on MoreOptions Menu Icon'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)
//
//                'Delay of 5 Sec'
//                Mobile.delay(5)
//
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
//                    3, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Delay of 15 Sec'
//                Mobile.delay(15)
//            } else if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Forgot Password')) {
//                bResult1 = true
//
//                'Entering the Email Address'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'), 
//                    sEmail, 4)
//
//                'Entering the Account Number'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Account Number TextBox'), 
//                    sAccountNumber, 4)
//
//                'Clicking on the Keyboard Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)
//
//                'Clicking on the Submit Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Submit Button'), 
//                    3, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Delay of 10 Sec'
//                Mobile.delay(10)
//
//                'Getting the Forgot Password Message Text in the String variable'
//                messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'), 
//                    'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Checking Forgot Password Message Text is matching with the Expeced Text or Not'
//                if (messageText.equals(GlobalVariable.sForgotPasswordText)) {
//                    System.out.println('Password Reset Email sent to the registered email :' + sEmail)
//                } else {
//                    System.out.println('Something went wrong with the Forgot Password functionality message Text is ' + 
//                        messageText)
//                }
//                
//                'Clicking on the Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'), 
//                    5)
//
//                'Delay of 5 Sec'
//                Mobile.delay(5)
//
//                'Getting New Password from the DataBase'
//                String sNewPasswordQuery = 'SELECT Top 1 U.Password FROM [User] U(NOLOCK) JOIN UserAccount UA(NOLOCK) ON U.UserID=UA.UserID WHERE U.Status=1 and U.UserID IS NOT NULL AND U.EmailID IS NOT NULL AND U.Password IS NOT NULL AND UA.UtilityAccountNumber IS NOT NULL'
//
//                String sNewPassword = database.DataBaseUtil.executeSQLQuery(sNewPasswordQuery)
//
//                System.out.println(sNewPassword)
//
//                if (!(sNewPassword.equals(sCurrentPassword))) {
//                    System.out.println('Forgot Password Functionality is working as expected. Password has been updated and sent to the customer through email')
//                } else {
//                    System.out.println('Forgot Password Functionality is not working correctly. Password is not updated. Please check manually')
//                }
//                
//                'Again Clicking on MoreOptions Menu Icon'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)
//
//                'Delay of 5 Sec'
//                Mobile.delay(5)
//
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
//                    3, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Delay of 15 Sec'
//                Mobile.delay(15)
//            } else if (driver.findElementByClassName('XCUIElementTypeStaticText').getText().equals('Problems Signing In')) {
//                bResult1 = true
//
//                'Entering the Email Address'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Email Address TextBox'), 
//                    sEmail, 4)
//
//                'Entering the Comment'
//                Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Comment TextBox'), 
//                    'This is for Internal Testing', 4)
//
//                'Clicking on the Keyboard Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/Common Elements/KeyBoard Done Button'), 10)
//
//                'Clicking on the Submit Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Submit Button'), 
//                    3, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Getting the Problems Signing In Message Text in the String variable'
//                messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Popup Message Text'), 
//                    'text', 5, FailureHandling.CONTINUE_ON_FAILURE)
//
//                'Checking Forgot UserName Message Text is matching with the Expeced Text or Not'
//                if (messageText.equals(GlobalVariable.sProblemSignInText)) {
//                    System.out.println('Problems Sign In Popup Text is as expected. Text is : ' + messageText)
//                } else {
//                    System.out.println('Something went wrong with the Problems Sign In Popup. Message Text is ' + messageText)
//                }
//                
//                'Clicking on the Ok Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot UserName and Forgot Password/Message Popup Ok Button'), 
//                    5)
//
//                'Delay of 5 Sec'
//                Mobile.delay(5)
//            }
//            
//            if (bResult1 == false) {
//                'Calling the Press Back Inbuilt funtion'
//                Mobile.pressBack()
//
//                'Delay'
//                Mobile.delay(10)
//            }
//        }
//    } else {
//        System.out.println('Login Help Tab is available but Login Help Tab Side Menu Elements are not available. Please check manually')
//    }
//} else {
//    System.out.println('MoreOptionsMenu Login Help Tab is not Displayed')
//}
'***********************************************'

'TC : To verify that MoreOptionsMenu screen contain Objects'

'TC : To verify that MoreOptionsMenu Footer'

@com.kms.katalon.core.annotation.TearDown
static void verifyMoreMenuOptionTestCases() {
    'TC : TC_LO_3, TC_LO_30, TC_LO_31 To verify that MoreOptionsMenu screen contain Objects'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Verifying MoreOptionsMenu Icon is Displayed or Not'
    if (applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu') == 
    true) {
        System.out.println('MoreOptionsMenu Icon is Displayed')

        'Clicking on More Options Icon'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

        'Delay of 5 Sec'
        Mobile.delay(5)

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab', 
            'MoreOptionsMenu Login Help Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu SCM Website Tab', 
            'MoreOptionsMenu SCM Website Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Customer Support Tab', 
            'MoreOptionsMenu Customer Support Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Tab', 
            'MoreOptionsMenu FAQs Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Language Tab', 
            'MoreOptionsMenu Language Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Privacy Policy Tab', 
            'MoreOptionsMenu Privacy Policy Tab')

        'Verifying Login Help Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Login Help Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/MoreOptionsMenu Login Help Tab'), 
                3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 2 Sec'
            Mobile.delay(2)

            'Getting Module Name in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals('Login Help')) {
                System.out.println('On Click on Login Help, user is successfully routing to the : Login Help tab')

                applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot Username Menu', 
                    'Forgot Username Menu')

                applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Forgot Password Menu', 
                    'Forgot Password Menu')

                applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In Menu', 
                    'Problems Signing In Menu')

                'Verifying Problems Signing In Menu is Displayed in Login Help or Not'
                if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In Menu'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                    System.out.println('Problems Signing In Menu is Displayed')

                    verifyProblemSignInTestCases()
                } else {
                    System.out.println('We are unable to verify the Problems Signing In test cases because Problems Signing In Menu is Displayed')
                }
            } else {
                System.out.println(('On Click on Login Help, something went wrong. Expected Module text is : Login Help , but Actual is + ' + 
                    messageText) + '. Please check manually')
            }
            
            'Clicking the Press Back to Application'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(20)

            'Again Clicking on More Options Icon'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

            'Delay of 5 Sec'
            Mobile.delay(5)
        } else {
            System.out.println('MoreOptionsMenu Login Help Tab is not Displayed')
        }
        
        'Verifying SCM Website Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu SCM Website Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu SCM Website Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu SCM Website Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 15 Sec'
            Mobile.delay(15)

            'Getting MoreOptionsMenu SCM Website Tab URL in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals(GlobalVariable.sCompanyWebsiteName)) {
                System.out.println('On Click on SCM Website, user is successfully routing to the :' + GlobalVariable.sCompanyWebsiteName)
            } else {
                System.out.println(('On Click on SCM Website, user might route to the Website or something issue with the Website Url. Expected Website is :' + 
                    GlobalVariable.sCompanyWebsiteName) + ' .Please check manually')
            }
            
            'Clicking the Press Back to Application'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(20)

            'Again Clicking on More Options Icon'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

            'Delay of 5 Sec'
            Mobile.delay(5)
        } else {
            System.out.println('MoreOptionsMenu SCM Website Tab is not Displayed')
        }
        
        'Verifying Language Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Language Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Language Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Language Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 5 Sec'
            Mobile.delay(5)

            'Getting Languages in the List'
            ArrayList<MobileElement> lMoreMenuLanguages = driver.findElementsByClassName('android.widget.RelativeLayout')

            if (lMoreMenuLanguages.size() > 0) {
                System.out.println('List of Available Languages are :')

                System.out.println(lMoreMenuLanguages.size())

                for (int index = 1; index < lMoreMenuLanguages.size(); index++) {
                    System.out.println(lMoreMenuLanguages.get(index).findElementByClassName('android.widget.TextView').getText())
                }
                
                'Getting the Default Selected Language'
                for (int index = 1; index < lMoreMenuLanguages.size(); index++) {
                    if (lMoreMenuLanguages.get(index).findElementByClassName('android.widget.CheckedTextView').getAttribute(
                        'checked').equals('true')) {
                        System.out.println('Default Selected Language is : ')

                        String sLanguage = lMoreMenuLanguages.get(index).findElementByClassName('android.widget.TextView').getText()

                        if (sLanguage.equals('English')) {
                            System.out.println('Default Language Selected as English, which is as Expected')
                        } else {
                            System.out.println(('Default Language Selected as ' + sLanguage) + 'which is not expected.')
                        }
                        
                        break
                    }
                }
            } else {
                System.out.println('Language Tab is available but list of languages are not available. Please check manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)

            'Again Clicking on More Options Icon'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

            'Delay of 5 Sec'
            Mobile.delay(5)
        } else {
            System.out.println('MoreOptionsMenu Language Tab is not Displayed')
        }
        
        'Verifying MoreOptionsMenu Heading is Displayed on Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Heading'), 3, 
            FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Heading is Displayed')

            'Getting MoreOptionsMenu Heading in the String Variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Heading'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking MoreOptionsMenu Heading Text is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sMoreOptionsMenuHeadingText)) {
                System.out.println('MoreOptionsMenu Heading is matching with the Expected Text')
            } else {
                System.out.println((('MoreOptionsMenu Heading is not matching with the Expected Text, Expected Text is : ' + 
                    GlobalVariable.sMoreOptionsMenuHeadingText) + 'but Actual Text is ') + messageText)
            }
        } else {
            System.out.println('MoreOptionsMenu Heading is not Displayed')
        }
        
        '***********************************************'

        'Verifying Terms & Conditions Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Terms and Conditions Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Terms and Conditions Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Terms and Conditions Tab'), 3, 
                FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 25 Sec'
            Mobile.delay(25)

            'Getting Terms & Conditions Heading in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals(GlobalVariable.sTandCExpectedTitle)) {
                System.out.println('On Click on T&C Tab, user is routing to the T&C Tab and title of the tab is matching with the expected title')
            } else {
                System.out.println('T&C Tab is available but the title of the T&C module is not matching. Please check manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)
        } else {
            System.out.println('MoreOptionsMenu T&C Tab is not Displayed')
        }
        
        'Again Clicking on MoreOptions Menu Icon'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

        'Delay of 5 Sec'
        Mobile.delay(5)

        '***********************************************'

        'Verifying Privacy Policy Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Privacy Policy Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Privacy Policy Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Privacy Policy Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 25 Sec'
            Mobile.delay(25)

            'Getting Privacy Policy Heading in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals(GlobalVariable.sTandCExpectedTitle)) {
                System.out.println('On Click on Privacy Policy Tab, user is routing to the Privacy Policy Tab and title of the tab is matching with the expected title')
            } else {
                System.out.println('Privacy Policy Tab is available but the title of the Privacy Policy module is not matching. Please check manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)
        } else {
            System.out.println('MoreOptionsMenu Privacy Policy Tab is not Displayed')
        }
        
        'Again Clicking on MoreOptions Menu Icon'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

        'Delay of 5 Sec'
        Mobile.delay(5)

        '***********************************************'

        'Verifying FAQs Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu FAQs Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu FAQs Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 25 Sec'
            Mobile.delay(25)

            'Getting FAQs Heading in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals(GlobalVariable.sFAQsModuleExpectedTitle)) {
                System.out.println('On Click on FAQs Tab, user is routing to the FAQ Tab and title of the tab is matching with the expected title')
            } else {
                System.out.println('FAQs Tab is available but the title of the FAQs module is not matching. Please check manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)
        } else {
            System.out.println('MoreOptionsMenu FAQs Tab is not Displayed')
        }
        
        'Again Clicking on MoreOptions Menu Icon'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

        'Delay of 10 Sec'
        Mobile.delay(10)

        '***********************************************'

        'Verifying Customer Support Tab is Displayed in MoreOptionsMenu or Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Customer Support Tab'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('MoreOptionsMenu Customer Support Tab is Displayed')

            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Customer Support Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 25 Sec'
            Mobile.delay(25)

            'Getting Customer Support Number in the String Variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Customer Support Contact Number'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            if (messageText.equals(GlobalVariable.sCustomerSupportNumber)) {
                System.out.println('On Click on Customer Support user is routing to the Dial a Customer Support Number. Also Customer Support Number is as Expected')
            } else {
                System.out.println('Customer Support Tab is Available but something went wrong. Please check manually')
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)
        } else {
            System.out.println('MoreOptionsMenu Customer Support Tab is not Displayed')
        }
        
        '***********************************************'
    } else {
        System.out.println('MoreOptionsMenu is not Displayed')
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.pressBack()

    'Delay'
    Mobile.delay(10)
}

@com.kms.katalon.core.annotation.TearDown
static void verifyMoreMenuFooterTestCases() {
    'TC : TC_LO_29 To verify that MoreOptionsMenu screen contain Objects'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Verifying MoreOptionsMenu Icon is Displayed or Not'
    if (applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu') == 
    true) {
        'Clicking on More Options Icon'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu'), 3)

        'Delay of 5 Sec'
        Mobile.delay(5)

        'Verifying CopyRight is Displayed on Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application CopyRight Text'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('Application CopyRight is Displayed')

            'Getting CopyRight in the String Variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application CopyRight Text'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking CopyRight is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sCopyRight)) {
                System.out.println('Copyright © Text is matching with the Expected Text')
            } else {
                System.out.println((('Copyright © Text is not matching with the Expected Text, Expected Text is : ' + GlobalVariable.sCopyRight) + 
                    'but Actual Text is ') + messageText)
            }
        } else {
            System.out.println('Application CopyRight is not Displayed')
        }
        
        '***********************************************'

        'Verifying Application Version is Displayed on Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application Version'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('Application Version is Displayed')

            'Getting Application Version in the String Variable'
            messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Application Version'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Checking Application Version is matching with the Expeced Text or Not'
            if (messageText.equals(GlobalVariable.sApplicationVersion)) {
                System.out.println('Application Version is matching with the Expeced Text')
            } else {
                System.out.println((('Application Version Text is not matching with the Expected Text, Expected Text is :' + 
                    GlobalVariable.sApplicationVersion) + ' but Actual Text is ') + messageText)
            }
        } else {
            System.out.println('Application Version is not Displayed')
        }
        
        '***********************************************'

        'Verifying Company Logo is Displayed on Not'
        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Company Logo'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            System.out.println('Company Logo is Displayed')

            'Clicking on the Company Logo'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/MoreOptionsMenu Company Logo'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Delay of 15 Sec'
            Mobile.delay(15)

            'Getting MoreOptionsMenu Company Logo URL in the String Variable'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals(GlobalVariable.sCompanyLogoURLName)) {
                System.out.println('On Click on Company Logo, user is successfully routing to the :' + GlobalVariable.sCompanyLogoURLName)
            } else {
                System.out.println(('On Click on Company Logo, user might route to the Website or something issue with the Website Url. Expected Website is :' + 
                    GlobalVariable.sCompanyLogoURLName) + ' .Please check manually')
            }
        } else {
            System.out.println('Company Logo is not Displayed')
        }
    } else {
        System.out.println('MoreOptionsMenu Footer cannot be verified because MoreOptionsMenu is not Displayed')
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.pressBack()

    'Delay'
    Mobile.delay(10)
}

static void verifyProblemSignInTestCases() {
    'TC : TC_LGH_38, TC_LGH_43 To Verify the Problem Sign In Page Objects and Submit a Problem Sign In Request'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Clicking on Problem Sign In Tab'
    Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

    'Getting Module Name in the String Variable'
    messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

    if (messageText.equals('Problems Signing In')) {
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Email Address Heading', 
            'Email Address Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Email Address TextBox', 
            'Email Address TextBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Account Number Heading', 
            'Account Number Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Account Number TextBox', 
            'Account Number TextBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Comments Heading', 
            'Comments Heading')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Comments TextBox', 
            'Comments TextBox')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Informational Text - 500 Characters left', 
            'Informational Text - 500 Characters left')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Submit Button', 
            'Submit Button')

        'TC : --> TC_LGH_4 -- Test Case to raise the Problem Seigning In Request'

        'Entering the Email Address'
        Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Email Address TextBox'), 
            GlobalVariable.sEmail, 4)

        'Entering the Account Number'
        Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Account Number TextBox'), 
            GlobalVariable.sUtilityAccountNumber, 4)

        'Entering the Comments'
        Mobile.setText(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Comments TextBox'), 
            'This is for internal testing', 4)

        Mobile.hideKeyboard()

        'Clicking on the Submit Button'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin MoreOptionsMenu/Login Help/Problems Signing In/Submit Button'), 3, 
            FailureHandling.CONTINUE_ON_FAILURE)
		
		Mobile.delay(2)

        'Getting the Problems Signing In Message Text in the String variable'
        messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

        'Checking Problems Signing In Message Text is matching with the Expeced Text or Not'
        if (messageText.equals(GlobalVariable.sProblemSignInText)) {
            System.out.println('Problems Sign In Popup Text is as expected. Text is : ' + messageText)
        } else {
            System.out.println('Something went wrong with the Problems Sign In Popup. Message Text is ' + messageText)
        }
        
        'Clicking on Popup Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        System.out.println(('On Click on Problems Signing In, something went wrong. Expected Module text is : Problems Signing In , but Actual is + ' + 
            messageText) + '. Please check manually')
    }
}