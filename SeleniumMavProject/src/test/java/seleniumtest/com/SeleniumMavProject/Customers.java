package seleniumtest.com.SeleniumMavProject;

/**
 * @author Julie.Thute
 * Date: 8/14/2018
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import common.LoanAppHelper;
import dataprovider.CustomerDataProvider;
import javaobject.AddCustomerPage;
import javaobject.CustomersPage;
import javaobject.HomePage;


public class Customers {
	@Test(dataProvider="createCustomer",dataProviderClass=CustomerDataProvider.class)
	//@Parameters(value = {"branch", "branchAdmin","branchPassword","firstname", "lastname"})
	
	public void AddCustomer(String branch, String branchAdmin, String branchPassword,String firstname, String lastname, String warning) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		// Create a new instance of Firefox driver
		WebDriver driver = new FirefoxDriver();
		int numberOFMilliseconds=5000;
		
		// Create instance of class Login to use its LMSLogin method in our Add User scenario
		Login login = new Login();
		
		//Using Page Objects
		HomePage homePage = new HomePage(driver);
		CustomersPage customersPage = new CustomersPage(driver);
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		
		// Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
		login.LMSLogin(driver,branch,branchAdmin,branchPassword);

		// try to sleep (wait) for 5 sec (using exception handler)
		sleep(numberOFMilliseconds);

		// Click button 'Customers'
		homePage.clickCustomersButton(driver);

		// Click button 'Actions'
		customersPage.clickActionsButton(driver);

		// try to sleep (wait) for 5 sec (using exception handler)
		sleep(numberOFMilliseconds);

		// Click menu item 'Add Customer'
		customersPage.clickAddCustomerLink(driver);
	
		// Enter firstname
		addCustomerPage.setFirstname1(driver, firstname);

		// Enter lastname
		addCustomerPage.setLastname1(driver, lastname);

		// Click button 'Save'
		addCustomerPage.clickSaveButton(driver);

		// try to sleep (wait) for 5 sec (using exception handler)
		sleep(numberOFMilliseconds);
		
		if (warning != "") {

			doesTextExistOnPage(warning, driver);

			// find button ok by xpath and click it to close pop up
			addCustomerPage.clickOKButton(driver);

			// Click button 'Cancel'
			addCustomerPage.clickCancelButton(driver);

			} else {

			doesTextExistOnPage(firstname, driver);

			}
		
		// Click button 'Logout'
		customersPage.clickLogoutButton(driver);

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
	public void AddCustomer1 (String branch, String branchAdmin, String branchPassword,String firstname,String lastname, String warning){
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		// Create a new instance of Firefox driver
		WebDriver driver = new FirefoxDriver();
		int numberOFMilliseconds=5000;
		// Create instance of class Login to use its LMSLogin method in our Add User scenario
		Login login = new Login();
		
		//Using Helper Class
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

		// Click menu item 'Add Customer'
		//usersPage.clickAddUserLink(driver);
		loanAppHelper.clickElementByLinkName(driver, "Add User");
		
		// Enter firstname
		//addUserPage.setUsername(driver, user);
		loanAppHelper.setText(driver, "Firstname", firstname);

		// Enter Lastname
		//addUserPage.setPassword(driver, password);
		loanAppHelper.setText(driver, "Lastname", lastname);
		
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
				loanAppHelper.doesTextExistOnPage(driver, firstname);

			}
		
		// Click button 'Logout'
		loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

		// try to sleep (wait) for 5 sec (using exception handler)
		loanAppHelper.sleep(numberOFMilliseconds);

		// close the browser
		driver.close();

		}



	}
