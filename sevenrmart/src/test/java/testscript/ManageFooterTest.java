package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {

	@Test(description="To verify that an authorized user is able to successfully update the 'Manage Footer Text' information")
	public void verifyTheUserIsAbleToUpdateManageFooterTextInformation() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		String manageaddress = ExcelUtility.getStringData(1, 0, "managefooterpage");
		String manageemail = ExcelUtility.getStringData(1, 1, "managefooterpage");
		String managephoneno = ExcelUtility.getIntegerData(1, 2, "managefooterpage");

		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.moreInfoManageFooter();
		managefooterpage.actionButton();
		managefooterpage.addressFooterTextInfo(manageaddress);
		managefooterpage.emailFooterTextInfo(manageemail);
		managefooterpage.phonenumberFooterTextInfo(managephoneno);
		managefooterpage.updateFooterTextInfo();

		boolean alertmsg = managefooterpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(alertmsg,"Manage Footer information not updated as expected");
	}
}
