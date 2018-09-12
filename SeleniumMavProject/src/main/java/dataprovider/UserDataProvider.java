package dataprovider;
import org.testng.annotations.DataProvider;

/**
 * @author JulieT
 * Date: 8/10/2018
 */

public class UserDataProvider {
	@DataProvider (name = "createUser")
	public static Object[][] createUser()// there are 2 square brackets [] [] after word Object
	{

	return new Object[][]{
		{"Riverhead", "admin", "jthute0705", "Nunn1", "password12",""},
		{"Riverhead", "admin", "jthute0705", "","password",  "Mandatory field 'Username' is empty"},
		{"Riverhead", "admin", "jthute0705", "samplename", "", "Mandatory field 'Password' is empty"}
    	};	
	}
}
