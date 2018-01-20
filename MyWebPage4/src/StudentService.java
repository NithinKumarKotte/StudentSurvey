import java.util.ArrayList;

//Nithin Kumar Kotte G01035945
/* Following class is is an interface which gives abstact methods for saving survey forms and calculating average and standard deviation.
 * this interface is implemented by "StudentBusiness" class. */

public interface StudentService {
	public ArrayList<String> savefile(String Firstname, String Lastname, String StreetAddress, String City,
			String State, String Zip, String telephone, String email, String date, String startdate,
			ArrayList<String> check, String radio, String menu, String raffle, String comments);

	public Double[] rafflewinner(String raffle);

}
