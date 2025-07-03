package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

@Test
public class ManageCategoryTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class,description="Verify that an authorized user can successfully add a new category via the category management module.")
	public void verifyTheUserIsAbleToAddCategoryInformations() throws IOException, AWTException {

		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();

		// String catgry=ExcelUtility.getStringData(1, 0,"managecategorypage");

		ManageCategoryPage managecategory = new ManageCategoryPage(driver);

		managecategory.moreInfoManageCategory();
		managecategory.newButton();

		FakerUtility fakerutility = new FakerUtility();
		String catgry = fakerutility.creatARandomFirstName();

		managecategory.categoryInformation(catgry);
		managecategory.selectGroup();
		managecategory.imageUpload();
		managecategory.saveCategoryInformations();

		boolean alertmsg = managecategory.isAlertMessageIsDisplayed();
		Assert.assertTrue(alertmsg,"Failed to add category: 'New Category' not found in the list after addition");
	}
}
