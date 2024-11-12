package airNavRadarBox

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Homepage {

	Verifications verify = new Verifications()

	@Keyword
	def navigateTourl() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.radarBoxURL, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def clickOnSubscripitonLinkAndVerifyTheURL() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/subScriptionLink'), 10)
		WebUI.click(findTestObject('Object Repository/subScriptionLink'))
		def url=WebUI.getUrl()
		WebUI.verifyEqual(GlobalVariable.subscripitonURL, url, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyTheLoginButton() {
		verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/loginButton'),"In the home page login button is not found" )
	}

	@Keyword
	def verifyHomePageHeaders() {

		List headers = [
			"Solutions",
			"Coverage",
			"Statistics",
			"History",
			"API",
			"Photos",
			"Social/Press",
			"About"
		]
		for(element in headers) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/AirNavRadarBoxHeaders/verifyHeader',['headers':element]),"In the Home page the "+element+" is not present")
		}
	}
}
