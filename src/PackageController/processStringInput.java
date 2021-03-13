package PackageController;

import java.util.regex.Pattern;
import PackageView.*;

public class processStringInput {
	static void ValidDay(String dates) throws customException {
		boolean checkStringInput = Pattern.compile("^[1-9]|[1-9][0-9]\\/([1-9]|[1-9][1-2])\\/\\d{4,}$").matcher(dates).matches();
		if(checkStringInput==false) {
			new popUpFailInput();
			throw new customException("input not valid");
		}
	}
	
//	public static void main(String[] args) {
//		boolean checkStringInput = Pattern.compile("^([1-9]|[1-3][0-9])\\/([1-9]|[1-9][1-2])\\/\\d{4,}$").matcher("1/12/2002").matches();
//		System.out.println(checkStringInput);
//	}
}
