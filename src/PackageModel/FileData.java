package PackageModel;
import java.io.*;

import PackageController.ManagerAccount;


public class FileData {
	private FileWriter dataFile;
	
	public FileData() {
		
			try {
				dataFile = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\projectCharMoneys\\data.txt");
				BufferedWriter buffer = new BufferedWriter(dataFile);
				int fk = ManagerAccount.getForeignkey();
				buffer.write(Integer.toString(fk));
				buffer.close();
				System.out.println("write file success........");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}

