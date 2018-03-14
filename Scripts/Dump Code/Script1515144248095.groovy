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


//Code to Check the Android Version
String sDeviceVersion = Mobile.getDeviceOSVersion()

String[] s2 = sDeviceVersion.split('\\.')

String s3 = s2[0]

int iAndroidVersion = Integer.parseInt(s3)

'Getting Device Width'
Mobile.getDeviceWidth(FailureHandling.CONTINUE_ON_FAILURE)

'Checking Permissions are displayed or Not?'
if (iAndroidVersion > 5) {
	'Getting Permission Text 1'
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin/Permission Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Permission Text 1 is matching with the Expeced Text or Not'
	if (messageText.equals('Allow SCM to access this device\'s location?')) {
		System.out.println('Permission Text 1 is matching with the Expected Text')
	} else {
		System.out.println('Permission Text 1 is not matching with the Expected Text, Expected Text is : Allow SCM to access this devices location but Actual Text is ' +
			messageText)
	}
	
	'Clicking on Allow Button'
	Mobile.tap(findTestObject('SCM Mobile/PreLogin/Permission Allow Button'), 5)

	'Getting Permission Text 2'
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin/Permission Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Permission Text 2 is matching with the Expeced Text or Not'
	if (messageText.equals('Allow SCM to access photos, media and files on your device?')) {
		System.out.println('Permission Text 2 is matching with the Expected Text')
	} else {
		System.out.println('Permission Text 2 is not matching with the Expected Text, Expected Text is : Allow SCM to access photos, media and files on your device? but Actual Text is ' +
			messageText)
	}
	
	'Clicking on Allow Button'
	Mobile.tap(findTestObject('SCM Mobile/PreLogin/Permission Allow Button'), 5)

	'Getting Permission Text 3'
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin/Permission Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Permission Text 3 is matching with the Expeced Text or Not'
	if (messageText.equals('Allow SCM to make and manage phone calls?')) {
		System.out.println('Permission Text 3 is matching with the Expected Text')
	} else {
		System.out.println('Permission Text 3 is not matching with the Expected Text, Expected Text is : Allow SCM to make and manage phone calls? but Actual Text is ' +
			messageText)
	}
	
	'Clicking on Allow Button'
	Mobile.tap(findTestObject('SCM Mobile/PreLogin/Permission Allow Button'), 5)

	'Getting Permission Text 4'
	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/PreLogin/Permission Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Permission Text 4 is matching with the Expeced Text or Not'
	if (messageText.equals('Allow SCM to take pictures and record video?')) {
		System.out.println('Permission Text 4 is matching with the Expected Text')
	} else {
		System.out.println('Permission Text 4 is not matching with the Expected Text, Expected Text is : Allow SCM to take pictures and record video? but Actual Text is ' +
			messageText)
	}
	
	'Clicking on Allow Button'
	Mobile.tap(findTestObject('SCM Mobile/PreLogin/Permission Allow Button'), 5)
} else {
	System.out.println('Device Version less than 5.0, so no permissions displayed')
}


'Delay of 5 Sec'
Mobile.delay(5)