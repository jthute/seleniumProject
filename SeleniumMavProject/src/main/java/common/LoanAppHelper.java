/**
 * 
 */
package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Julie.Thute
 *
 */
public class LoanAppHelper {
	 /**
     * Search the whole page for a text string.
     *
     * @param textToLookFor
     * @return true if found, false if not
     */
    public boolean doesTextExistOnPage(WebDriver driver, String textToLookFor) {
        WebElement body = driver.findElement(By.tagName("body"));
        return body.getText().contains(textToLookFor);
    }


    /**
     * Sleep for specified number of milliseconds
     *  @param numberOfMilliseconds
     */
    public void sleep(int numberOfMilliseconds) {
        try {
            Thread.sleep(numberOfMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



     /**
     * Click an element by XPath
     *
     * @param Xapth
     */
    public void clickElementByXPath(WebDriver driver, String xpath) {
        // find element
        WebElement element = driver.findElement(By.xpath(xpath));

        // click element
        element.click();
    }


    /**
     * Click a link by link name
     *
     * @param name link text
     */
    public void clickElementByLinkName(WebDriver driver, String name) {
        // find element
        WebElement element = driver.findElement(By.linkText(name));

        // click element
        element.click();
    }

    
     /**
     * Click an element by id
     *
     * @param ID
     */

    public void clickElementByID(WebDriver driver, String id) {
        // find element
        WebElement element = driver.findElement(By.id(id));

        // click element
        element.click();
    }


    
    /**
     * Type text into edit.text field identified by name
     *
     * @param name, text
     */
    public void setText (WebDriver driver, String name, String text ) {
        // find element
        WebElement element = driver.findElement(By.name(name));

        // Type text
        element.sendKeys(text);
    }


    /**
     * Select item from list box identified by id
     *
     * @param name, id, item
     */
    public void selectItem (WebDriver driver, String id, String item){
        // find element
        WebElement element = driver.findElement(By.id(id));

        // Create select object
        Select select = new Select(element);

        // Select item
        select.selectByVisibleText(item);

    }


}

