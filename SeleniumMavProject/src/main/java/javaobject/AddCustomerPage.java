/**
 * 
 */
package javaobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.LoanAppHelper;

/**
 * @author Julie.Thute
 *
 */
public class AddCustomerPage {
	// this is a constructor
    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // LOCATORS


    // text field 'Username'
    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement firstName;

    // text field 'Password'
    @FindBy(how = How.NAME, using = "LastName")
    private WebElement lastName;

    // button 'Save'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    // button 'Cancel'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonCancel;

    // button 'OK' to close warning message //div[7]/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")
    private WebElement buttonOK;

    LoanAppHelper loanAppHelper = new LoanAppHelper();

    // METHODS

    public AddCustomerPage setFirstname (WebDriver driver, String firstname ) {
        // Enter username
        firstName.sendKeys(firstname);
        return this;
    }
    
    public AddCustomerPage setFirstname1 (WebDriver driver, String firstname) {
    	// Enter username
    	loanAppHelper.setText (driver, "FirstName", firstname);
    	return this;
    	}
    
    public AddCustomerPage setLastname (WebDriver driver, String lastname ) {
        // Enter password
        lastName.sendKeys(lastname);
        return this;
    }
    
    public AddCustomerPage setLastname1 (WebDriver driver, String lastname ) {
        // Enter password
    	loanAppHelper.setText (driver, "LastName", lastname);
        return this;
    }
    public AddCustomerPage clickSaveButton (WebDriver driver) {
        // click Save button
        buttonSave.click();
        return this;
    }
    public AddCustomerPage clickCancelButton (WebDriver driver) {
        // click Cancel button
        buttonCancel.click();
        return this;
    }
    public AddCustomerPage clickOKButton (WebDriver driver) {
        // click OK  button on warning message pop up
        buttonOK.click();
        return this;
    }
}