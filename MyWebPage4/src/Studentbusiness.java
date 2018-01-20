import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Nithin Kumar Kotte G01035945
/* Following class is performs business logic for storing each survey records in files (i.e. Survey Form.txt) also it provides 
 * a method to calculate average and standard deviation of raffle numbers */

public class Studentbusiness implements StudentService {

	private ArrayList<String> list = new ArrayList<String>();
	public ArrayList<ArrayList<String>> Totallist = new ArrayList<ArrayList<String>>();

	public Studentbusiness() {

	}

	@Override
	public ArrayList<String> savefile(String Firstname, String Lastname, String StreetAddress, String City,
			String State, String Zip, String telephone, String email, String date, String startdate,
			ArrayList<String> check, String radio, String menu, String raffle, String comments) {
		// TODO Auto-generated method stub
		int count = Student.count++;

		// File file = new File("D:/Survey Form "+count+".txt");
		try {
			/*
			 * FileWriter fo = new FileWriter(file); if(!file.exists()){
			 * file.createNewFile(); }
			 */

			list.add(Firstname);
			list.add(Lastname);
			list.add(StreetAddress);
			list.add(City);
			list.add(State);
			list.add(Zip);
			list.add(telephone);
			list.add(email);
			list.add(date);
			list.add(startdate);

			for (String j : check) {
				list.add(j);
			}

			list.add(radio);
			list.add(menu);
			list.add(raffle);
			list.add(comments);

			Totallist.add(list);

			for (ArrayList<String> i : Totallist) {
				System.out.println(i.get(0));
			}

			/*
			 * for(String i:list){
			 * 
			 * // byte[] content = i.getBytes(); fo.write(i);
			 * fo.write(System.getProperty( "line.separator" ));
			 * 
			 * 
			 * 
			 * } fo.close();
			 */

		} catch (Exception e/* IOException e */) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public Double[] rafflewinner(String raffle) {

		WinningResult winningResult = new WinningResult();
		// TODO Auto-generated method stub
		int count = 0;
		int j = 0;
		int intnum = 0;
		double avg = 0.0;
		double stddev = 0.0;
		double addstddev = 0.0;
		String str;
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for (int i = 0; i < raffle.length(); i++) {
			char c = raffle.charAt(i);
			if (c == ',') {
				str = raffle.substring(j, i);
				numbers.add(Integer.parseInt(str));
				intnum += Integer.parseInt(str);

				j = i + 1;
				++count;
			}

		}
		numbers.add(Integer.parseInt(raffle.substring(raffle.lastIndexOf(',') + 1, raffle.length())));
		intnum += Integer.parseInt(raffle.substring(raffle.lastIndexOf(',') + 1, raffle.length()));
		int num = count + 1;
		avg = Math.rint(intnum / num);
		winningResult.setMean(avg);

		for (int i : numbers) {

			stddev = Math.pow((i - avg), 2);

			addstddev += stddev;

		}

		stddev = Math.sqrt(addstddev);
		winningResult.setStddeviation(stddev);

		Double[] retval = { winningResult.getMean(), winningResult.getStddeviation() };

		return retval;

	}

}
