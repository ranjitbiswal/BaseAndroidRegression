import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.ref.ReferenceQueue.Null as Null
import java.util.logging.Logger as Logger
import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF as ElseExpressionBNF
import org.junit.After as After
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

'Delay of 10 Sec'
Mobile.delay(10) 

@com.kms.katalon.core.annotation.TearDown
static void verifyRegistrationTestCases() {
    'TC : TC_RGN_1, TC_RRM_1 To verify the Registration TestCases'
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    if (Mobile.verifyElementVisible(findTestObject('SCM Mobile/Registration/Register Now Button'), 3, FailureHandling.CONTINUE_ON_FAILURE) == 
    true) {
        'Clicking on Register Now Button'
        Mobile.tap(findTestObject('SCM Mobile/Registration/Register Now Button'), 10)

        'Delay of 5 seconds'
        Mobile.delay(5)

        'Getting Account Type from the DataBase'
        String sCustomerTypeQuery = 'SELECT Top 1 (CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) AS CustomerType FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID=ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID=a.AddressID JOIN AccountMeterMapping AMM(NOLOCK) ON A.AccountNumber=AMM.AccountNumber LEFT JOIN ( SELECT DISTINCT IC.CustomerID        FROM Customer IC(NOLOCK)       JOIN CustomerAddress ICA(NOLOCK) ON IC.CustomerID=ICA.CustomerID       JOIN Account IA(NOLOCK) ON IA.AddressID=ICA.AddressID       JOIN UserAccount IUA(NOLOCK) ON IUA.AccountNumber=IA.AccountNumber)R ON C.CustomerID=R.CustomerID WHERE R.CustomerID IS NULL AND c.CustomerID NOT IN (1,-1) GROUP BY c.CustomerID,c.MobilePhone,C.customerNo,(CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) ,c.DrivingLicence,CA.ZipCode,CA.Address1,C.SSNNumber'

        String sCustomerType = database.DataBaseUtil.executeSQLQuery(sCustomerTypeQuery)

        System.out.println(sCustomerType)

        ArrayList<MobileElement> lRadioButtons = driver.findElementsByClassName('android.widget.RadioButton')

        println(lRadioButtons.size())

        for (int index1 = 0; index1 < lRadioButtons.size(); index1++) {
            if (sCustomerType.equals('Residential')) {
                'TC --> TC_RRM_1 ,TC_RRM_2, TC_RRM_3 -- Test Case to check the Page Navigation and its Objects'
                Mobile.tap(findTestObject('SCM Mobile/Registration/Residential Radio Button'), 10)

                'Delay of 5 seconds'
                Mobile.delay(5)

                'Clicking on Next Button'
                Mobile.tap(findTestObject('SCM Mobile/Registration/Next Button'), 10)

                'Delay of 5 seconds'
                Mobile.delay(5)

                'Check Module Name'
                messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

                if (messageText.equals('User Registration')) {
                    System.out.println('Verified that on Click on Register Now button, User is routing to the Registration tab')

                    'TC_RRM_2 -->User Registrtation Page Objects'
                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Account Number Heading', 
                        'Account Number Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Account Number TextBox', 
                        'Account Number TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Email Id Heading', 
                        'Email Id Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Email Id TextBox', 
                        'Email Id TextBox ')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password Heading', 
                        'Password Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password TextBox', 
                        'Password TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password Criteria Informational Button', 
                        'Password Criteria Informational Button')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Confirm Password Heading', 
                        'Confirm Password Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Confirm Password TextBox', 
                        'Confirm Password TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Zip Code Heading', 
                        'Zip Code Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Zip Code TextBox', 
                        'Zip Code TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 1 Heading', 
                        'Security Question 1 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 1 TextBox', 
                        'Security Question 1 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 1 Heading', 
                        'Security Answer 1 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 1 TextBox', 
                        'Security Answer 1 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 2 Heading', 
                        'Security Question 2 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 2 TextBox', 
                        'Security Question 2 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 2 Heading', 
                        'Security Answer 2 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 2 TextBox', 
                        'Security Answer 2 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/I Agree CheckBox', 
                        'I Agree CheckBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Terms and Conditions Link', 
                        'Terms and Conditions Link')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Register Button', 
                        'Register Button')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Back Button', 'Back Button')
                } else {
                    System.out.println('Verified that on Click on Register Now button, User might not route to the Registration tab, Please check manually.')
                }
            } else if (sCustomerType.equals('Commercial')) {
                'TC --> TC_RGN_1 ,TC_RGN_2, TC_RGN_3 -- Test Case to check the Page Navigation and its Objects'
                Mobile.tap(findTestObject('SCM Mobile/Registration/Business Radio Button'), 5)

                'Delay of 2 seconds'
                Mobile.delay(2)

                'Clicking on Next Button'
                Mobile.tap(findTestObject('SCM Mobile/Registration/Next Button'), 3)

                'Delay of 5 seconds'
                Mobile.delay(5)

                'Check Module Name'
                messageText = driver.findElementById('com.sus.scm_mobile:id/tv_modulename').getText()

                if (messageText.equals('User Registration')) {
                    System.out.println('Verified that on Click on Register Now button, User is routing to the Registration tab')

                    'TC_RGN_2 -->User Registrtation Page Objects'
                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Account Number Heading', 
                        'Account Number Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Account Number TextBox', 
                        'Account Number TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Email Id Heading', 
                        'Email Id Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Email Id TextBox', 
                        'Email Id TextBox ')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password Heading', 
                        'Password Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password TextBox', 
                        'Password TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Password Criteria Informational Button', 
                        'Password Criteria Informational Button')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Confirm Password Heading', 
                        'Confirm Password Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Confirm Password TextBox', 
                        'Confirm Password TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Zip Code Heading', 
                        'Zip Code Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Zip Code TextBox', 
                        'Zip Code TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 1 Heading', 
                        'Security Question 1 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 1 TextBox', 
                        'Security Question 1 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 1 Heading', 
                        'Security Answer 1 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 1 TextBox', 
                        'Security Answer 1 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 2 Heading', 
                        'Security Question 2 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Question 2 TextBox', 
                        'Security Question 2 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 2 Heading', 
                        'Security Answer 2 Heading')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Security Answer 2 TextBox', 
                        'Security Answer 2 TextBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/I Agree CheckBox', 
                        'I Agree CheckBox')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Terms and Conditions Link', 
                        'Terms and Conditions Link')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Register Button', 
                        'Register Button')

                    applicationMethods.ReusableMethods.isMobileElementDisplayed('SCM Mobile/Registration/Back Button', 'Back Button')
                } else {
                    System.out.println('Verified that on Click on Register Now button, User might not route to the Registration tab, Please check manually.')
                }
            } else {
                System.out.println('Invalid CustomerType, Please check manually. ')
            }
            
            break
        }
		'Test Case to Check the Already Used UserName for Registration'
		verifyAlreadyUsedUserNameRegistrationTestCases()
		
		'Test Case to Check the Already Used Account Number for Registration'
		verifyAlreadyUsedAccountNumberRegistrationTestCases()
		
        'Test Case to Check the Successful Registration'
        verifySuccessfulRegistrationTestCases()
    } else {
        System.out.println('Registration TestCases cannot be verified because Register Now Button is not displayed on PreLogin ')
    }
}

static void verifyAlreadyUsedUserNameRegistrationTestCases() {
	
	'TC --> TC_RGN_26 , TC_RRM_26 -->  Test case to verify AlreadyUsed UserName for Registration'
	String messageText = null

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Getting Account Number from the DataBase'
	String sAccountNumberQuery = 'SELECT Top 1 MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID=ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID=a.AddressID JOIN AccountMeterMapping AMM(NOLOCK) ON A.AccountNumber=AMM.AccountNumber LEFT JOIN (       SELECT DISTINCT IC.CustomerID       FROM Customer IC(NOLOCK)       JOIN CustomerAddress ICA(NOLOCK) ON IC.CustomerID=ICA.CustomerID       JOIN Account IA(NOLOCK) ON IA.AddressID=ICA.AddressID       JOIN UserAccount IUA(NOLOCK) ON IUA.AccountNumber=IA.AccountNumber)R ON C.CustomerID=R.CustomerID WHERE R.CustomerID IS NULL AND c.CustomerID NOT IN (1,-1) GROUP BY c.CustomerID,c.MobilePhone,C.customerNo,(CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) ,c.DrivingLicence,CA.ZipCode,CA.Address1,C.SSNNumber'

	String sNewAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery)

	System.out.println(sNewAccountNumber)
	'Entering the First Name'
	Mobile.setText(findTestObject('SCM Mobile/Registration/txtBoxFirstNameBasic'), 'Bharti', 4)
	//Mobile.setText(findTestObject('SCM Mobile/TestReg/android.widget.EditText0 - Optional'), 'Bharti', 0)
	'Entering the Account Number'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Account Number TextBox'), sNewAccountNumber, 4)
	

	'Entering the Last Name'
	Mobile.setText(findTestObject('SCM Mobile/Registration/txtBoxLastNameBasic'), 'LastN', 4)

	'Delay of 2 seconds'
	Mobile.delay(2)
	
	'Getting ZipCode from the DataBase'
	String sAccountZipCodeQuery = 'SELECT Top 1 CA.ZipCode FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID=ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID=a.AddressID JOIN AccountMeterMapping AMM(NOLOCK) ON A.AccountNumber=AMM.AccountNumber LEFT JOIN (       SELECT DISTINCT IC.CustomerID       FROM Customer IC(NOLOCK)       JOIN CustomerAddress ICA(NOLOCK) ON IC.CustomerID=ICA.CustomerID       JOIN Account IA(NOLOCK) ON IA.AddressID=ICA.AddressID       JOIN UserAccount IUA(NOLOCK) ON IUA.AccountNumber=IA.AccountNumber)R ON C.CustomerID=R.CustomerID WHERE R.CustomerID IS NULL AND c.CustomerID NOT IN (1,-1) GROUP BY c.CustomerID,c.MobilePhone,C.customerNo,(CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) ,c.DrivingLicence,CA.ZipCode,CA.Address1,C.SSNNumber'

	String sAccountZipCode = database.DataBaseUtil.executeSQLQuery(sAccountZipCodeQuery)

	System.out.println(sAccountZipCode)

	'Entering the ZipCode'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Zip Code TextBox'), sAccountZipCode, 4)

	'Getting Random Number'
	int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, 50000)

	'Entering the Email Address'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Email Id TextBox'), 'bharti.garg@smartusys.com' , 4)

	'Delay of 2 seconds'
	Mobile.delay(2)
	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	'Entering the UserName'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Username TextBox'), 'DemoD', 4)
	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	'Entering the Password'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Password TextBox'), 'Demo@123', 4)
	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	'Delay of 3 seconds'
	Mobile.delay(3)

	'Entering the Confirm Password'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Confirm Password TextBox'), 'Demo@123', 4)
	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	'Delay of 3 seconds'
	Mobile.delay(3)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Delay of 1 seconds'
	Mobile.delay(1)

	
	'Delay of 3 seconds'
	Mobile.delay(3)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Security Question1 DropDown'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 1 DropDown Button'), 2)

	'Delay of 2 seconds'
	Mobile.delay(2)

	ArrayList<MobileElement> lQuestionList = driver.findElementsByClassName('android.widget.CheckedTextView')

	println(lQuestionList.size())

	'Delay of 2 seconds'
	Mobile.delay(2)

	for (int index1 = 1; index1 < 2; index1++) {
		lQuestionList.get(index1).click()

		'Clicking on DropDown Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

		'Delay of 1 seconds'
		Mobile.delay(1)
	}
	
	'Entering the Security Answer1'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Security Question2 DropDown'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 2 DropDown Button'), 2)

	'Delay of 2 seconds'
	Mobile.delay(2)

	ArrayList<MobileElement> lQuestionList1 = driver.findElementsByClassName('android.widget.CheckedTextView')

	println(lQuestionList1.size())

	'Delay of 2 seconds'
	Mobile.delay(2)

	for (int index2 = 2; index2 < 3; index2++) {
		lQuestionList1.get(index2).click()

		'Clicking on DropDown Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

		'Delay of 1 seconds'
		Mobile.delay(1)
	}
	
	'Entering the Security Answer2'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on I Agree Checkbox'
	Mobile.checkElement(findTestObject('SCM Mobile/Registration/I Agree CheckBox'), 10)

	'Delay of 2 seconds'
	Mobile.delay(2)

	'Clicking on Register Button'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Register Button'), 10)

	'Delay of 20 seconds'
	Mobile.delay(20)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Duplicate UserName Registration Message Text is matching with the Expeced Text or Not'
	if (messageText.equals(GlobalVariable.sDuplicateUsernameRegistraionMessageText)) {
		System.out.println('Our records indicate that you have previously registered using this Account Number. If you have forgotten your Username/Password, please click on “Login Help”. If you need assistance, please contact Customer Service by email at support@smartusys.com or by phone at 8003451570.')
	} else {
		System.out.println((('Registration Unsuccessful. Message Text is not matching with the Expected Text, Expected Text is : ' +
			GlobalVariable.sDuplicateUsernameRegistraionMessageText) + ' but Actual Text is ') + messageText)
	}
	
	'Clicking on the PopUp Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

	'Delay of 5 seconds'
	Mobile.delay(5)

	
}

static void verifySuccessfulRegistrationTestCases() {
	
	'TC --> TC_RGN_22 , TC_RRM_22, TC_RGN_30, TC_RRM_30, TC_RGN_32, TC_RRM_32-->  Test case to verify the sucessful Registration and Account Activation'
	
    String messageText = null

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    'Getting Account Number from the DataBase'
    String sAccountNumberQuery = 'SELECT Top 1 MAX(CA.UtilityAccountNumber) AS UtilityAccountNumber FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID=ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID=a.AddressID JOIN AccountMeterMapping AMM(NOLOCK) ON A.AccountNumber=AMM.AccountNumber LEFT JOIN (       SELECT DISTINCT IC.CustomerID       FROM Customer IC(NOLOCK)       JOIN CustomerAddress ICA(NOLOCK) ON IC.CustomerID=ICA.CustomerID       JOIN Account IA(NOLOCK) ON IA.AddressID=ICA.AddressID       JOIN UserAccount IUA(NOLOCK) ON IUA.AccountNumber=IA.AccountNumber)R ON C.CustomerID=R.CustomerID WHERE R.CustomerID IS NULL AND c.CustomerID NOT IN (1,-1) GROUP BY c.CustomerID,c.MobilePhone,C.customerNo,(CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) ,c.DrivingLicence,CA.ZipCode,CA.Address1,C.SSNNumber'

    String sNewAccountNumber = database.DataBaseUtil.executeSQLQuery(sAccountNumberQuery)

    System.out.println(sNewAccountNumber)

    'Entering the Account Number'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Account Number TextBox11'), sNewAccountNumber, 4)

    'Delay of 2 seconds'
    Mobile.delay(2)

    'Getting Random Number'
    int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, 50000)

    'Entering the Email Address'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Email Id TextBox'), ('sahil.dheer' + randomnumber) + '@smartusys.com', 
        4)

    String sUserEmail = ('sahil.dheer' + randomnumber) + '@smartusys.com'

    'Delay of 2 seconds'
    Mobile.delay(2)

    'Entering the Password'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Password TextBox'), 'Demo@123', 4)

    'Delay of 3 seconds'
    Mobile.delay(3)

    'Entering the Confirm Password'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Confirm Password TextBox'), 'Demo@123', 4)

    'Delay of 3 seconds'
    Mobile.delay(3)

    Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

    'Delay of 1 seconds'
    Mobile.delay(1)

    'Getting ZipCode from the DataBase'
    String sAccountZipCodeQuery = 'SELECT Top 1 CA.ZipCode FROM Customer c(NOLOCK) JOIN CustomerAddress CA(NOLOCK) ON c.CustomerID=ca.CustomerID JOIN Account a(NOLOCK) ON ca.AddressID=a.AddressID JOIN AccountMeterMapping AMM(NOLOCK) ON A.AccountNumber=AMM.AccountNumber LEFT JOIN (       SELECT DISTINCT IC.CustomerID       FROM Customer IC(NOLOCK)       JOIN CustomerAddress ICA(NOLOCK) ON IC.CustomerID=ICA.CustomerID       JOIN Account IA(NOLOCK) ON IA.AddressID=ICA.AddressID       JOIN UserAccount IUA(NOLOCK) ON IUA.AccountNumber=IA.AccountNumber)R ON C.CustomerID=R.CustomerID WHERE R.CustomerID IS NULL AND c.CustomerID NOT IN (1,-1) GROUP BY c.CustomerID,c.MobilePhone,C.customerNo,(CASE WHEN CA.AddressType=1 THEN \'Residential\' ELSE \'Commercial\' END) ,c.DrivingLicence,CA.ZipCode,CA.Address1,C.SSNNumber'

    String sAccountZipCode = database.DataBaseUtil.executeSQLQuery(sAccountZipCodeQuery)

    System.out.println(sAccountZipCode)

    'Entering the ZipCode'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Zip Code TextBox'), sAccountZipCode, 4)

    'Delay of 3 seconds'
    Mobile.delay(3)

    Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
1
    'Clicking on Security Question1 DropDown'
    Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 1 DropDown Button'), 2)

    'Delay of 2 seconds'
    Mobile.delay(2)

    ArrayList<MobileElement> lQuestionList = driver.findElementsByClassName('android.widget.CheckedTextView')

    println(lQuestionList.size())

    'Delay of 2 seconds'
    Mobile.delay(2)

    for (int index1 = 1; index1 < 2; index1++) {
        lQuestionList.get(index1).click()

        'Clicking on DropDown Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    'Entering the Security Answer1'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

    Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

    'Clicking on Security Question2 DropDown'
    Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 2 DropDown Button'), 2)

    'Delay of 2 seconds'
    Mobile.delay(2)

    ArrayList<MobileElement> lQuestionList1 = driver.findElementsByClassName('android.widget.CheckedTextView')

    println(lQuestionList1.size())

    'Delay of 2 seconds'
    Mobile.delay(2)

    for (int index2 = 2; index2 < 3; index2++) {
        lQuestionList1.get(index2).click()

        'Clicking on DropDown Ok Button'
        Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

        'Delay of 1 seconds'
        Mobile.delay(1)
    }
    
    'Entering the Security Answer2'
    Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

    Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

    'Clicking on I Agree Checkbox'
    Mobile.checkElement(findTestObject('SCM Mobile/Registration/I Agree CheckBox'), 10)

    'Delay of 2 seconds'
    Mobile.delay(2)

    'Clicking on Register Button'
    Mobile.tap(findTestObject('SCM Mobile/Registration/Register Button'), 10)

    'Delay of 20 seconds'
    Mobile.delay(20)

    messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

    'Checking Successful Registration Message Text is matching with the Expeced Text or Not'
    if (messageText.equals(GlobalVariable.sRegistrationSuccessfulMessageText)) {
        System.out.println('New User Register Successfully')
    } else {
        System.out.println((('Registration Successful Message Text is not matching with the Expected Text, Expected Text is : ' + 
            GlobalVariable.sRegistrationSuccessfulMessageText) + ' but Actual Text is ') + messageText)
    }
    
    'Clicking on the PopUp Ok Button'
    Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

    'Delay of 5 seconds'
    Mobile.delay(5)

    String strUserIDFromQuery = ('SELECT UserID FROM UserAccount where RoleID=3 AND UtilityAccountNumber = \'' + sNewAccountNumber) + 
    '\''

    String sUserID = database.DataBaseUtil.executeSQLQuery(strUserIDFromQuery)

    int iUserID = Integer.parseInt(sUserID)

    int s1 = database.DataBaseUtil.callStoredProcedure(iUserID)

    System.out.println(s1)
}

static void verifyAlreadyUsedAccountNumberRegistrationTestCases() {
	String messageText = null

	AppiumDriver<?> driver = MobileDriverFactory.getDriver()

	'Entering the Account Number'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Account Number TextBox11'), GlobalVariable.sUtilityAccountNumber, 4)

	'Delay of 2 seconds'
	Mobile.delay(2)

	'Getting Random Number'
	int randomnumber = utility.RandomRange.nextRandomIntegerInRange(1, 50000)

	'Entering the Email Address'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Email Id TextBox'), ('sahil.dheer' + randomnumber) + '@smartusys.com',
		4)

	String sUserEmail = ('sahil.dheer' + randomnumber) + '@smartusys.com'

	'Delay of 2 seconds'
	Mobile.delay(2)

	'Entering the Password'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Password TextBox'), 'Demo@123', 4)

	'Delay of 3 seconds'
	Mobile.delay(3)

	'Entering the Confirm Password'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Confirm Password TextBox'), 'Demo@123', 4)

	'Delay of 3 seconds'
	Mobile.delay(3)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Delay of 1 seconds'
	Mobile.delay(1)

	'Entering the ZipCode'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Zip Code TextBox'), GlobalVariable.sUtilityZipCode, 4)

	'Delay of 3 seconds'
	Mobile.delay(3)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Security Question1 DropDown'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 1 DropDown Button'), 2)

	'Delay of 2 seconds'
	Mobile.delay(2)

	ArrayList<MobileElement> lQuestionList = driver.findElementsByClassName('android.widget.CheckedTextView')

	println(lQuestionList.size())

	'Delay of 2 seconds'
	Mobile.delay(2)

	for (int index1 = 1; index1 < 2; index1++) {
		lQuestionList.get(index1).click()

		'Clicking on DropDown Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

		'Delay of 1 seconds'
		Mobile.delay(1)
	}
	
	'Entering the Security Answer1'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on Security Question2 DropDown'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Security Questions 2 DropDown Button'), 2)

	'Delay of 2 seconds'
	Mobile.delay(2)

	ArrayList<MobileElement> lQuestionList1 = driver.findElementsByClassName('android.widget.CheckedTextView')

	println(lQuestionList1.size())

	'Delay of 2 seconds'
	Mobile.delay(2)

	for (int index2 = 2; index2 < 3; index2++) {
		lQuestionList1.get(index2).click()

		'Clicking on DropDown Ok Button'
		Mobile.tap(findTestObject('SCM Mobile/Registration/Security Question DropDown - Ok Button'), 2)

		'Delay of 1 seconds'
		Mobile.delay(1)
	}
	
	'Entering the Security Answer2'
	Mobile.setText(findTestObject('SCM Mobile/Registration/Security Answer 1 TextBox'), '1234', 4)

	Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

	'Clicking on I Agree Checkbox'
	Mobile.checkElement(findTestObject('SCM Mobile/Registration/I Agree CheckBox'), 10)

	'Delay of 2 seconds'
	Mobile.delay(2)

	'Clicking on Register Button'
	Mobile.tap(findTestObject('SCM Mobile/Registration/Register Button'), 10)

	'Delay of 20 seconds'
	Mobile.delay(20)

	messageText = Mobile.getAttribute(findTestObject('SCM Mobile/Common Elements/Popup Message Text'), 'text', 5, FailureHandling.CONTINUE_ON_FAILURE)

	'Checking Successful Registration Message Text is matching with the Expeced Text or Not'
	if (messageText.equals(GlobalVariable.sRegistrationSuccessfulMessageText)) {
		System.out.println('New User Register Successfully')
	} else {
		System.out.println((('Registration Successful Message Text is not matching with the Expected Text, Expected Text is : ' +
			GlobalVariable.sRegistrationSuccessfulMessageText) + ' but Actual Text is ') + messageText)
	}
	
	'Clicking on the PopUp Ok Button'
	Mobile.tap(findTestObject('SCM Mobile/Common Elements/Popup Ok Button'), 15)

	'Delay of 5 seconds'
	Mobile.delay(5)


}

