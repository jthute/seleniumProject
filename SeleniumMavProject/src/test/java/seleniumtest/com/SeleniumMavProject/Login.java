

/**
 * @author JulieT
 * Date: 8/10/2018
 */
package seleniumtest.com.SeleniumMavProject;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.Test;

import javaobject.LoginPage;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import static org.testng.AssertJUnit.*;

public class Login {

	
		public void LMSLogin(WebDriver driver,String branch, String branchAdmin, String branchPassword){
					// Create a new instance of the firefox driver
					//System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
					//WebDriver driver = new FirefoxDriver();
			
				//Create Objects required for this test
				LoginPage loginPage = new LoginPage(driver);
					
					// And now use this to visit LMS login page
					driver.get("http://test-hitekschool.com/lms/loans/2108");

					// Maximize window
					driver.manage().window().maximize();
			       // wait(1000);
					// Read the title of the page and put it into results
					System.out.println("Page title is: " + driver.getTitle());

//					// Find the text input element 'branch' by its name
//					//WebElement element = driver.findElement(By.name("j_branch"));
//					loginPage.setBranchName(driver,branch);
//					
//					// Enter username
//					element.sendKeys(branch);
//
//					// Find the text input element 'username' by its name
//					element = driver.findElement(By.name("j_username"));
//
//					// Enter username
//					element.sendKeys(branchAdmin);
//
//					// Find the text input element 'password' by its name
//					element = driver.findElement(By.name("j_password"));
//
//					// Enter password
//					element.sendKeys(branchPassword);
//					
//					// Find the button Login by its id
//					element = driver.findElement(By.id("ext-gen38"));
//
//					// Click Login button
//					element.click();

					// Enter branch name
					loginPage.setBranchName (driver, branch);

					// Enter branch admin username
					loginPage.setBranchAdminUsername(driver, branchAdmin);

					// Enter branch admin password
					loginPage.setBranchAdminPassword(driver, branchPassword);

					// Click Login button
					loginPage.clickLoginButton(driver);
					// Try to sleep (wait) for 5 sec (using exception handler)
					try {

					Thread.sleep(5000);

					} catch (InterruptedException e) {

					e.printStackTrace();

					}

					// Read the title of the page and output it into results - need it for debug purpose
					System.out.println("Page title is: " + driver.getTitle());

					// Verify the title of the page
					Assert.assertEquals(driver.getTitle(), "Loan Management System - "+"'"+ branch+"'"+" branch");
			        
					System.out.println("Login Successful");
					
					
					//Close the browser
				//	driver.close();
		}
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			System.out.println("Logging in to Loan Management System Page");
//			LMSLogin();
//	       
//	   	}
}


