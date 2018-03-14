import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By.ByClassName as ByClassName
import org.openqa.selenium.By.ByCssSelector as ByCssSelector
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
applicationMethods.ReusableMethods.startApplication()

'Delay of 30 Sec'
Mobile.delay(30) 

@com.kms.katalon.core.annotation.TearDown
static void verifyPreLoginPaymentLocationsTestCases() {
    'TC : TC_PLPL_10, TC_PLPL_15, TC_PLPL_11, TC_PLPL_14 To verify that PreLogin Payment Locations'
    String messageText = null

    String sZipCode = null

    String sCityName = null

    String sFirstPaymentLocationTitleFromList = null

    String sFirstPaymentLocationTitleFromMap = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin ContactUs/PreLogin ContactUs Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        'Clicking on PreLogin Contact Us Menu'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin ContactUs/PreLogin ContactUs Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Payment Locations/PreLogin Payment Locations Menu'), 
            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
            'Clicking on PreLogin Payment Locations'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/PreLogin Payment Locations Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE)

            'Check Module Name'
            messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

            if (messageText.equals('Payment Locations')) {
                System.out.println('On Click on PreLogin Payment Locations, User is routing to the Payment Locations Module')
            } else {
                System.out.println('On Click on PreLogin Payment Locations, user might route to the Payment Locations Module or something issue with the Module Name. Expected Module Name is : Payment Locations. Please check manually. ')
            }
            
            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Search Button', 
                'Payment Location Search Button')

            applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Map View Button', 
                'Payment Location Map View Button')

	            'Counting the Payment Locations'
	            List<MobileElement> lPaymentLocationsCount = driver.findElementsById('com.sus.scm_mobile:id/tv_locationtitle')
	
	            List<MobileElement> lPaymentLocationsCity = driver.findElementsById('com.sus.scm_mobile:id/tv_city_name')
	
	            System.out.println('lPaymentLocationsCount :' + lPaymentLocationsCount.size())
	
	            if (lPaymentLocationsCount.size() > 0) {
	                for (int index = 0; index < lPaymentLocationsCount.size(); ) {
                    'Adding the First Payment Location in the String'
                    sFirstPaymentLocationTitleFromList = lPaymentLocationsCount.get(index).getText()

                    'Getting City Name & ZipCode in the String'
                    String sCityNameString = lPaymentLocationsCity.get(index).getText()

                    String[] parts = sCityNameString.split(',')

                    sCityName = (parts[0])

                    String sZipCodeString = parts[1]

                    String[] parts1 = sZipCodeString.split('\\s+')

                    sZipCode = (parts1[1])

                    'Clicking on First Payment Location'
                    lPaymentLocationsCount.get(index).click()

                    sFirstPaymentLocationTitleFromMap = driver.findElementById('com.sus.scm_mobile:id/tv_detail_header').getText()

                    'Checking Payment Location Name from Map and the List'
                    if (sFirstPaymentLocationTitleFromList.equals(sFirstPaymentLocationTitleFromMap)) {
                        System.out.println('Verified that on Click on the First Payment Location from the List, Clicked Payment Location displayed on the Map')

                        'Checkings Objects of the Payment Details Screen'
                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Locations Title On Map', 
                            'Payment Locations Title On Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Address on Map', 
                            'Payment Location Address on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location City on Map', 
                            'Payment Location City on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Contact Number on Map', 
                            'Payment Location Contact Number on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Email on Map', 
                            'Payment Location Email on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Payment Location Payment Hours on Map', 
                            'Payment Location Payment Hours on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Call Icon on Map', 
                            'Call Icon on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Call Heading on Map', 
                            'Call Heading on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Directions Icon on Map', 
                            'Directions Icon on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Directions Heading on Map', 
                            'Directions Heading on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Website Icon on Map', 
                            'Website Icon on Map')

                        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Payment Locations/Website Heading on Map', 
                            'Website Heading on Map')

                        'TC : TC_PLPL_11 --> Test Case to check the Call Icon'

                        'Clicking on call icon'
                        Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Call Heading on Map'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                        messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 
                            'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

                        if (messageText.equals('Your device doesn\'t support phone calls. Customer Service Number:1877777777')) {
                            System.out.println('Call Button is Active and below message is displayed : Your device doesn\'t support phone calls. Customer Service Number:1877777777')

                            'Clicking on Popup Ok Button'
                            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                            Mobile.pressBack()
                        } else {
                            System.out.println('Something went wrong on click on Call Button. Please check manually.')

                            'Clicking on Popup Ok Button'
                            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                            Mobile.pressBack()
                        }
                        
                        'TC : TC_PLPL_14 --> To verify that user is able to switch between List view  or MAP view'

                        'Clicking on Payment Location Map View'
                        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Map View Button'), 
                            3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                            Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Map View Button'), 
                                3, FailureHandling.CONTINUE_ON_FAILURE)

                            if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location List View Button'), 
                                3, FailureHandling.CONTINUE_ON_FAILURE) == true) {
                                System.out.println('Verified that user is able to switch between payment location List view  or MAP view.')

                                'Clicking on the Payment Location List view Button'
                                Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location List View Button'), 
                                    3, FailureHandling.CONTINUE_ON_FAILURE)
                            } else {
                                System.out.println('Test Case to verify the user is able to switch between payment location List view  or MAP view is not executed, because Payment Location List View icon is not displayed')
                            }
                        } else {
                            System.out.println('Test Case to verify the user is able to switch between payment location List view  or MAP view is not executed, because Payment Location Map View icon is not displayed')
                        }
                        
                        break
                    } else {
                        System.out.println('Something bad happened On Click on the first payment location from the List, Check Manually.')
                    }
                }
                
                'TC : TC_PLPL_16 To search the Payment Location by ZipCode'
				'Clicking on Search Button'
				Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Entering the ZipCode of Payment Location to Search'
                Mobile.setText(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search TextBox'), 
                    sZipCode, 3)

                List<MobileElement> lPaymentLocationsCountAfterZipCodeSearch = driver.findElementsById('com.sus.scm_mobile:id/tv_locationtitle')

                if (lPaymentLocationsCountAfterZipCodeSearch.size() > 0) {
                    System.out.println(('We verified that Searched ZipCode have ' + lPaymentLocationsCountAfterZipCodeSearch.size()) + 
                        ' payment locations')

                    Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Close Button'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                } else {
                    System.out.println(('We verified that Searched ZipCode have ' + lPaymentLocationsCountAfterZipCodeSearch.size()) + 
                        ' payment locations')

                    Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Close Button'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                }
                
//                'Clicking on Search Button'
//                Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Button'), 3, FailureHandling.CONTINUE_ON_FAILURE)

                'Entering the City of Payment Location to Search'
                Mobile.setText(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search TextBox'), 
                    sCityName, 3)

                List<MobileElement> lPaymentLocationsCountAfterCitySearch = driver.findElementsById('com.sus.scm_mobile:id/tv_locationtitle')

                if (lPaymentLocationsCountAfterCitySearch.size() > 0) {
                    System.out.println(('We verified that Searched City have ' + lPaymentLocationsCountAfterCitySearch.size()) + 
                        ' payment locations')

                    Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Close Button'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                } else {
                    System.out.println(('We verified that Searched ZipCode have ' + lPaymentLocationsCountAfterZipCodeSearch.size()) + 
                        ' payment locations')

                    Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Close Button'), 
                        3, FailureHandling.CONTINUE_ON_FAILURE)
                }
            } else {
                System.out.println('We are unable to verify the Payment Locations test cases, because there is no Payment Locations exists in the PreLogin Payment Locations Menu')

                Mobile.tap(findTestObject('SCM Mobile/PreLogin Payment Locations/Payment Location Search Close Button'), 
                    3, FailureHandling.CONTINUE_ON_FAILURE)
            }
        } else {
            System.out.println('We are unable to verify the Payment Locations test cases, because Payment Locations tab is not displayed.')
        }
    } else {
        System.out.println('We are unable to verify the Payment Locations test cases, because ContactUs Menu is not displayed, Prelogin Payment Locations is Sub Menu of ContactUs Menu')
    }
}