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
static void verifyPreLoginOutagesTestCases() {
    'TC : TC_PLO_1, TC_PLO_2 To verify that PreLogin Outages Tab and page Objects'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/PreLogin Outages Menu'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        System.out.println('PreLogin Outgaes Menu is Displayed')

        'Clicking on PreLogin Outages'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/PreLogin Outages Menu'), 5)

        'Delay of 5 Sec'
        Mobile.delay(5)

        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        true) {
            'Clicking on Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PopUp Ok Button'), 10)

            'Delay'
            Mobile.delay(5)
        }
        
        'Check Module Name'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        if (messageText.equals('Outages')) {
            System.out.println('On Click on PreLogin Outages, User is routing to the Outages Module')
        } else {
            System.out.println('On Click on PreLogin Outages, user might route to the Outages Module or something issue with the Module Name. Expected Module Name is : Outages. Please check manually. ')
        }
        
        'Check Objects on the Outages Modules'
        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Report Outages Link', 'Report Outages Link')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Current Outages Tab', 'Current Outages Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Planned Outages Tab', 'Planned Outages Tab')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Refresh Icon', 'Refresh Icon')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Current Location Icon', 
            'Current Location Icon')

        applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Header Search Icon', 'Header Search Icon')

        verifyPreLoginCurrentOutagesTabTestCases()

        verifyPreLoginPlannedOutagesTabTestCases()

        verifyPreLoginReportOutagesTabTestCases()
    } else {
        System.out.println('PreLogin Outgaes Menu is not Displayed')
    }
}

static void verifyPreLoginCurrentOutagesTabTestCases() {
    'TC : TC_PLO_3 To verify that PreLogin Outages Current Tab Test Cases'
    String messageText = null

    String sOutageTitleOnListOutagesPage = null

    String sOutageTitleOnOutagesDetailsPage = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Current Outages Tab'), 10, FailureHandling.CONTINUE_ON_FAILURE) == 
    false) {
        System.out.println('Current Outages Tab is not displayed in the Outages')
    } else {
        System.out.println('Current Outages Tab is displayed in the Outages Menu')

        'Clicking on Current Outages Tab'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Current Outages Tab'), 15)

        'Delay of 10 seconds'
        Mobile.delay(10)

        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        false) {
		'Verifying Outages on the Outage Map View'
		
					'Getting Outages in the List'
					MobileElement Wb = driver.findElementByXPath('//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]')
		
					ArrayList<MobileElement> lOutagesCounts = Wb.findElementsByClassName('android.view.View')
		
					if (lOutagesCounts.size() > 0) {
						System.out.println('List of Available Current Outages are :' + lOutagesCounts.size())
		
						for (int index = 1; index < lOutagesCounts.size(); index++) {
							Wb.findElementsByClassName('android.view.View').get(index).click()
		
							'Delay '
							Mobile.delay(4)
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Title on Outage Map Page',
								'Outage Title on Outage Map Page')
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Customer Affected on Outage Map',
								'Outage Customer Affected on Outage Map')
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Date and Time on Outage Map',
								'Outage Date and Time on Outage Map')
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Community Affected on Outage Map',
								'Outage Community Affected on Outage Map')
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Report Info on Outage Map',
								'Outage Report Info on Outage Map')
		
							applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Restortion Time on Outage Map',
								'Outage Restortion Time on Outage Map')
		
							'Calling the Press Back Inbuilt funtion'
							Mobile.pressBack()
		
							'Delay'
							Mobile.delay(10)
		
							break
						}
					}
					
            'Clicking on Outages List View'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Outages List View'), 15)

            sOutageTitleOnListOutagesPage = null

            sOutageTitleOnOutagesDetailsPage = null

            sOutageTitleOnListOutagesPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on the Outage List View Page'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Clicking on the first Outages in the List View'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/First Outage in the Outage List View Page'), 5)

            'Delay'
            Mobile.delay(5)

            sOutageTitleOnOutagesDetailsPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on Outage Map Page'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            if (sOutageTitleOnListOutagesPage.equals(sOutageTitleOnOutagesDetailsPage)) {
                System.out.println('Outage Title mentioned in List View is matching with the Outage Details Title')
            } else {
                System.out.println((('Outage Title mentioned in List View is not matching with the Outage Details Title Expected Outage Title is ' + 
                    sOutageTitleOnListOutagesPage) + ' but Actual Outage Title is ') + sOutageTitleOnOutagesDetailsPage)
            }
            
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)

            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(10)
        } else {
            System.out.println('Current Outages count is 0')

            'Clicking on Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PopUp Ok Button'), 10)

            'Delay'
            Mobile.delay(5)
        }
    }
}

static void verifyPreLoginPlannedOutagesTabTestCases() {
    'TC : TC_PLO_8,TC_PLO_10 To verify that PreLogin Planned Outages Tab Test Cases'
    String messageText = null

    String sOutageTitleOnListOutagesPage = null

    String sOutageTitleOnOutagesDetailsPage = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Planned Outages Tab'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    false) {
        System.out.println('Planned Outages Tab is not displayed in the Outages')
    } else {
        System.out.println('Planned Outages Tab is displayed in the Outages Menu')

        'Clicking on Planned Outages Tab'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Planned Outages Tab'), 15)

        'Delay of 15 seconds'
        Mobile.delay(15)

        if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
        true) {
            System.out.println('Planned Outages count is 0')

            'Clicking on Ok Button'
            Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

            'Delay'
            Mobile.delay(5)
        } else {
            'Verifying Outages on the Outage Map View'

            'Getting Outages in the List'
            MobileElement Wb = driver.findElementByXPath('//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]')

            ArrayList<MobileElement> lOutagesCounts = Wb.findElementsByClassName('android.view.View')

            if (lOutagesCounts.size() > 0) {
                System.out.println('List of Available Planned Outages are :' + lOutagesCounts.size())

                for (int index = 1; index < lOutagesCounts.size(); index++) {
                    Wb.findElementsByClassName('android.view.View').get(index).click()

                    'Delay '
                    Mobile.delay(4)

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Title on Outage Map Page', 
                        'Outage Title on Outage Map Page')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Customer Affected on Outage Map', 
                        'Outage Customer Affected on Outage Map')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Date and Time on Outage Map', 
                        'Outage Date and Time on Outage Map')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Community Affected on Outage Map', 
                        'Outage Community Affected on Outage Map')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Report Info on Outage Map', 
                        'Outage Report Info on Outage Map')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Restortion Time on Outage Map', 
                        'Outage Restortion Time on Outage Map')

                    'Calling the Press Back Inbuilt funtion'
                    Mobile.pressBack()

                    'Delay'
                    Mobile.delay(10)

                    break
                }
            } 
            
            'Clicking on Outages List View'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Outages List View'), 35)

            'Delay'
            Mobile.delay(5)

            sOutageTitleOnListOutagesPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on the Outage List View Page'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            'Clicking on the first Outages in the List View'
            Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/First Outage in the Outage List View Page'), 5)

            'Delay'
            Mobile.delay(10)

            sOutageTitleOnOutagesDetailsPage = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin Outages/Outage Title on Outage Map Page'), 
                'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

            if (sOutageTitleOnListOutagesPage.equals(sOutageTitleOnOutagesDetailsPage)) {
                System.out.println('Outage Title mentioned in List View is matching with the Outage Details Title')
            } else {
                System.out.println(((' Outage Title mentioned in List View is not matching with the Outage Details Title Expected Outage Title is ' + 
                    sOutageTitleOnListOutagesPage) + ' but Actual Outage Title is ') + sOutageTitleOnOutagesDetailsPage)
            }
            
			'Checking Outage Component on the Outage Map view'
			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Title on Outage Map Page',
				'Outage Title on Outage Map Page')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Customer Affected on Outage Map',
				'Outage Customer Affected on Outage Map')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Date and Time on Outage Map',
				'Outage Date and Time on Outage Map')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Community Affected on Outage Map',
				'Outage Community Affected on Outage Map')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Report Info on Outage Map',
				'Outage Report Info on Outage Map')

			applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/PreLogin Outages/Outage Restortion Time on Outage Map',
				'Outage Restortion Time on Outage Map')
			
			
            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(2)

            'Calling the Press Back Inbuilt funtion'
            Mobile.pressBack()

            'Delay'
            Mobile.delay(2)
        }
    }
}

static void verifyPreLoginReportOutagesTabTestCases() {
    'TC : TC_PLO_3 To verify that PreLogin Outages Current Tab Test Cases'
    String messageText = null

    String sOutageTitleOnListOutagesPage = null

    String sOutageTitleOnOutagesDetailsPage = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/PreLogin Outages/Report Outages Link'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    false) {
        System.out.println('Report Outages Link is not displayed in the Outages')
    } else {
        System.out.println('Report Outage Link is displayed in the Outages Menu')

        'Clicking on Report Outage Link'
        Mobile.tap(findTestObject('SCM Mobile/PreLogin Outages/Report Outages Link'), 25)

        'Delay of 15 seconds'
        Mobile.delay(15)

        'Getting Message Text of the Module'
        messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

        'Verifying Report Outage Module'
        if (messageText.equals(null)) {
            System.out.println('Something went wrong with Report Outage Link')
        } else {
            if (messageText.equals('Connect Me')) {
                System.out.println('On Click on the Report Outage Link user is routing to the Connect Me Page')
            } else {
                System.out.println('On Click on the Report Outage Link user is routing to the Connect Me Page. Expected Text is : "Connect Me" but Actual Text is ' + 
                    messageText)
            }
        }
    }
    
    'Calling the Press Back Inbuilt funtion'
    Mobile.pressBack()

    'Delay'
    Mobile.delay(2)

    'Calling the Press Back Inbuilt funtion'
    Mobile.pressBack()

    'Delay'
    Mobile.delay(2)
}