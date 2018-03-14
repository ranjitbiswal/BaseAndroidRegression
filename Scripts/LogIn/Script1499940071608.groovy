import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import org.testng.annotations.Test as Test
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
import com.sun.beans.decoder.FalseElementHandler as FalseElementHandler
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Method to check the Objects'

@com.kms.katalon.core.annotation.SetUp

public static def verifyValidLogin() {
    'Check Application is Already Installed on Device or Not'
    Mobile.startApplication(GlobalVariable.sApplicationPath, false)

    'Delay of 60 Sec'
    Mobile.delay(60)

    'Clearing the UserName Text Field'
    Mobile.clearText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), 3)

    'Entering UserName'
    Mobile.setText(findTestObject('SCM Mobile/LogIn/UserName TextBox'), GlobalVariable.sUserName, 3)

    'Hide KeyBoard'
    Mobile.hideKeyboard()

    'Clearing the Password Text Field'
    Mobile.clearText(findTestObject('SCM Mobile/LogIn/Password TextBox'), 3)

    'Entering Password'
    Mobile.setText(findTestObject('SCM Mobile/LogIn/Password TextBox'), GlobalVariable.sPassword, 3)

    'Hide KeyBoard'
    Mobile.hideKeyboard()

    'Clicking on SignIn Button'
    Mobile.tap(findTestObject('SCM Mobile/LogIn/SignIn Button'), 30)
}
