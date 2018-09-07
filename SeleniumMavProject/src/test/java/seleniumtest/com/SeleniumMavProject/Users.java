package seleniumtest.com.SeleniumMavProject;

/**
 * @author Julie.Thute
 * Date: 8/10/2018
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.LoanAppHelper;
import dataprovider.UserDataProvider;
import javaobject.AddUserPage;
import javaobject.HomePage;
import javaobject.UsersPage;


public class Users {
	
	
	@Test(dataProvider="createUser",dataProviderClass=UserDataProvider.class)
	//@Parameters(value = {"branch", "branchAdmin","branchPassword","user", "password"})
	
	public void AddUser (String branch, String branchAdmin, String branchPassword,String user,String password,String warning){
	
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	// Create a new instance of Firefox driver
	WebDriver driver = new FirefoxDriver();
	int numberOFMilliseconds = 5000;
	
	// Create instance of class Login to use its LMSLogin method in our Add User scenario
	Login login = new Login();
	HomePage homePage = new HomePage(driver);
	UsersPage usersPage = new UsersPage(driver);
	AddUserPage addUserPage = new AddUserPage(driver);

	// Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
	login.LMSLogin(driver,branch,branchAdmin,branchPassword);

	// try to sleep (wait) for 5 sec (using exception handler)
	sleep(numberOFMilliseconds);

	// Click button 'Users'
	homePage.clickUsersButton(driver);

	// Click button 'Actions'
	usersPage.clickActionsButton(driver);
	
	// try to sleep (wait) for 5 sec (using exception handler)
	sleep(numberOFMilliseconds);

	// Click menu item 'Add User'
	usersPage.clickAddUserLink(driver);
	
	// Enter username
	addUserPage.setUsername1(driver, user);

	// Enter password
	addUserPage.setPassword1(driver, password);
	
	// Click button 'Save'
	addUserPage.clickSaveButton(driver);

	// try to sleep (wait) for 5 sec (using exception handler)
	sleep(numberOFMilliseconds);
	
	if (warning != "") {

		doesTextExistOnPage(warning, driver);

		// find buton ok by xpath and click it to close pop up
		addUserPage.clickOKButton(driver);
		
		// Click button 'Cancel'
		addUserPage.clickCancelButton(driver);


		} else {

		doesTextExistOnPage(user, driver);

		}
	
	// Click button 'Logout'
	usersPage.clickLogoutButton(driver);

	// try to sleep (wait) for 5 sec (using exception handler)
	sleep(numberOFMilliseconds);

	// close the browser
	driver.close();

	}


	private void doesTextExistOnPage(String textToLookFor, WebDriver driver) {
		WebElement body = driver.findElement(By.tagName("body"));
		boolean ret = body.getText().contains(textToLookFor);
		System.out.println(ret);
	}


	private void sleep(int numberOFMilliseconds) {
		try {
		Thread.sleep(numberOFMilliseconds);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}


	public void AddUser1 (String branch, String branchAdmin, String branchPassword,String user,String password,String warning){
	
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	// Create a new instance of Firefox driver
	WebDriver driver = new FirefoxDriver();
	int numberOFMilliseconds=5000;
	// Create instance of class Login to use its LMSLogin method in our Add User scenario
	Login login = new Login();
	//HomePage homePage = new HomePage(driver);
	//UsersPage usersPage = new UsersPage(driver);
	//AddUserPage addUserPage = new AddUserPage(driver);
	LoanAppHelper loanAppHelper = new LoanAppHelper();



	// Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
	login.LMSLogin(driver,branch,branchAdmin,branchPassword);

	// try to sleep (wait) for 5 sec (using exception handler)
	loanAppHelper.sleep(numberOFMilliseconds);;

	// Click button 'Users'
	//homePage.clickUsersButton(driver);
	loanAppHelper.clickElementByID(driver,"ext-gen185");
	
	// try to sleep (wait) for 5 sec (using exception handler)
	loanAppHelper.sleep(numberOFMilliseconds);
	
	// Click button 'Actions'
	//usersPage.clickActionsButton(driver);
	loanAppHelper.clickElementByXPath(driver, "//td[1]/table/tbody/tr/td[2]/em/button");
	
	// try to sleep (wait) for 5 sec (using exception handler)
	loanAppHelper.sleep(numberOFMilliseconds);

	// Click menu item 'Add User'
	//usersPage.clickAddUserLink(driver);
	loanAppHelper.clickElementByLinkName(driver, "Add User");
	
	// Enter username
	//addUserPage.setUsername(driver, user);
	loanAppHelper.setText(driver, "Username", user);

	// Enter password
	//addUserPage.setPassword(driver, password);
	loanAppHelper.setText(driver, "Password", password);
	
	// Click button 'Save'
	//addUserPage.clickSaveButton(driver);
	loanAppHelper.clickElementByXPath(driver,"//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button");

	// try to sleep (wait) for 5 sec (using exception handler)
	loanAppHelper.sleep(numberOFMilliseconds);
	
	if (warning != "") {
	
		//verify warning message text
		loanAppHelper.doesTextExistOnPage(driver, warning);
		
		// find buton ok by xpath and click it to close pop up
		loanAppHelper.clickElementByXPath(driver,"//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");
		
		// Click button 'Cancel'
		loanAppHelper.clickElementByXPath(driver,"//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");

		} else {

		// verify the results by parsing html page and making sure it contain just created username
			loanAppHelper.doesTextExistOnPage(driver, user);

		}
	
	// Click button 'Logout'
	loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

	// try to sleep (wait) for 5 sec (using exception handler)
	loanAppHelper.sleep(numberOFMilliseconds);

	// close the browser
	driver.close();

	}



}
