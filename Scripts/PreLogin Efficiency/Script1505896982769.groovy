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

//AppiumDriver<?> driver = MobileDriverFactory.getDriver()
//
//ArrayList<MobileElement> ls = driver.findElementsByClassName('XCUIElementTypeStaticText')
//
//println(ls.size())
//
//'Delay of 20 seconds'
//Mobile.delay(20)
//
//for (int index = 0; index < ls.size(); index++) {
//    if (ls.get(index).getText().equals('Rebates')) {
//        ls.get(index).click()
//
//        'Delay of 15 seconds'
//        Mobile.delay(15)
//
//        ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
//
//        println('Rebates Tip Count ' + lTipsCount.size())
//
//        for (int index1 = 0; index1 < 1; index1++) {
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountBeforeClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountBeforeClick)
//
//            String[] s2 = sViewCountBeforeClick.split('\\s')
//
//            println(s2)
//
//            String s3 = s2[1]
//
//            int iViewCountBeforeClick = Integer.parseInt(s3)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountAfterClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountAfterClick)
//
//            String[] s4 = sViewCountAfterClick.split('\\s')
//
//            println(s4)
//
//            String s5 = s4[1]
//
//            int iViewCountAfterClick = Integer.parseInt(s5)
//
//            if (iViewCountAfterClick == (iViewCountBeforeClick + 1)) {
//                println('On Click on the Tip, Count Increased by 1 ')
//            } else {
//                println('On Click on the Tip, Count mismatched please check manually ')
//            }
//        }
//        
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//    } else if (ls.get(index).getText().equals('Programs')) {
//        ls.get(index).click()
//
//        'Delay of 15 seconds'
//        Mobile.delay(15)
//
//        ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
//
//        println('Rebates Tip Count ' + lTipsCount.size())
//
//        for (int index1 = 0; index1 < 1; index1++) {
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountBeforeClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountBeforeClick)
//
//            String[] s2 = sViewCountBeforeClick.split('\\s')
//
//            println(s2)
//
//            String s3 = s2[1]
//
//            int iViewCountBeforeClick = Integer.parseInt(s3)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountAfterClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountAfterClick)
//
//            String[] s4 = sViewCountAfterClick.split('\\s')
//
//            println(s4)
//
//            String s5 = s4[1]
//
//            int iViewCountAfterClick = Integer.parseInt(s5)
//
//            if (iViewCountAfterClick == (iViewCountBeforeClick + 1)) {
//                println('On Click on the Tip, Count Increased by 1 ')
//            } else {
//                println('On Click on the Tip, Count mismatched please check manually ')
//            }
//        }
//        
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//    } else if (ls.get(index).getText().equals('Saving Tips')) {
//        ls.get(index).click()
//
//        'Delay of 15 seconds'
//        Mobile.delay(15)
//
//        ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
//
//        println('Saving Tip Count ' + lTipsCount.size())
//
//        for (int index1 = 0; index1 < 1; index1++) {
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountBeforeClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountBeforeClick)
//
//            String[] s2 = sViewCountBeforeClick.split('\\s')
//
//            println(s2)
//
//            String s3 = s2[1]
//
//            int iViewCountBeforeClick = Integer.parseInt(s3)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountAfterClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountAfterClick)
//
//            String[] s4 = sViewCountAfterClick.split('\\s')
//
//            println(s4)
//
//            String s5 = s4[1]
//
//            int iViewCountAfterClick = Integer.parseInt(s5)
//
//            if (iViewCountAfterClick == (iViewCountBeforeClick + 1)) {
//                println('On Click on the Tip, Count Increased by 1 ')
//            } else {
//                println('On Click on the Tip, Count mismatched please check manually ')
//            }
//        }
//        
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//    } else if (ls.get(index).getText().equals('Educational Tips')) {
//        ls.get(index).click()
//
//        'Delay of 15 seconds'
//        Mobile.delay(15)
//
//        ArrayList<MobileElement> lTipsCount = driver.findElementsByClassName('XCUIElementTypeCell')
//
//        println('Educational Tip Count ' + lTipsCount.size())
//
//        for (int index1 = 0; index1 < 1; index1++) {
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountBeforeClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountBeforeClick)
//
//            String[] s2 = sViewCountBeforeClick.split('\\s')
//
//            println(s2)
//
//            String s3 = s2[1]
//
//            int iViewCountBeforeClick = Integer.parseInt(s3)
//
//            'Calling the Press Back Inbuilt funtion'
//            Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//            'Delay'
//            Mobile.delay(10)
//
//            lTipsCount.get(index1).click()
//
//            'Delay of 20 seconds'
//            Mobile.delay(20)
//
//            String sViewCountAfterClick = driver.findElementByXPath('//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]').getText()
//
//            println(sViewCountAfterClick)
//
//            String[] s4 = sViewCountAfterClick.split('\\s')
//
//            println(s4)
//
//            String s5 = s4[1]
//
//            int iViewCountAfterClick = Integer.parseInt(s5)
//
//            if (iViewCountAfterClick == (iViewCountBeforeClick + 1)) {
//                println('On Click on the Tip, Count Increased by 1 ')
//            } else {
//                println('On Click on the Tip, Count mismatched please check manually ')
//            }
//        }
//        
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//
//        'Calling the Press Back Inbuilt funtion'
//        Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//        'Delay'
//        Mobile.delay(10)
//    }
//	
//}
//
//'Calling the Press Back Inbuilt funtion'
//Mobile.tap(findTestObject('SCM Mobile/Common Elements/PressBack'), 15)
//
//'Delay'
//Mobile.delay(10)