package session3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePractice {
	public static void main(String [] args) {
		try {
			File mf = new File("myFile.txt");
			FileWriter fw = new FileWriter(mf);
			BufferedWriter myWriter = new BufferedWriter(fw);
			
			myWriter.write("To be or not to be");
			
			myWriter.close();
			
			FileReader fr = new FileReader(mf);
			BufferedReader myReader = new BufferedReader(fr);
			
			String nextLine = "";
			while((nextLine = myReader.readLine()) != null)
				System.out.println(nextLine);
			
			myReader.close();
			
			fw = new FileWriter(mf, true);
			myWriter = new BufferedWriter(fw);
			
			myWriter.write("That is the question");;
			myWriter.close();
		
		}
		catch(FileNotFoundException e) {
		
		}
		catch(IOException e) {
			
		}
	}
}
