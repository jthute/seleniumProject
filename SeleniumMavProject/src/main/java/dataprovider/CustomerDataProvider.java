package dataprovider;
import org.testng.annotations.DataProvider;

/**
 * @author JulieT
 * Date: 8/14/2018
 */
public class CustomerDataProvider {
	
		@DataProvider (name = "createCustomer")
		public static Object[][] createCustomer()// there are 2 square brackets [] [] after word Object
		{

		return new Object[][]{
			{"Riverhead", "admin", "jthute0705","Larry", "Moe",""},
			{"Riverhead", "admin", "jthute0705", "","Loopezz",  "Mandatory field 'First Name' is empty"},
			{"Riverhead", "admin", "jthute0705", "Jennif", "", "Mandatory field 'Last Name' is empty"}
	    	};	
		}
}



