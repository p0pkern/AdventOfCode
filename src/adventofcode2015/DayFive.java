package adventofcode2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFive {
	
	public static boolean naughtyOrNice(String line) {
		int vowelTotal = 0;
		boolean pairs = false;
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowelTotal++;
			if(i >= 1) {
				if(line.charAt(i-1)== c) pairs = true;
				String pair = "" + line.charAt(i-1) + c;
				if(pair.equals("ab") || pair.equals("cd") || pair.equals("pq") || pair.equals("xy"))
					return false;

			}
		}
		return vowelTotal >= 3 && pairs;
		
	}
	
	public static boolean naughtyOrNiceRevised(String line) {
		int vowelTotal = 0;
		boolean pairs = false;
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowelTotal++;
			if(i >= 1) {
				if(line.charAt(i-1)== c) pairs = true;
				String pair = "" + line.charAt(i-1) + c;
				if(pair.equals("ab") || pair.equals("cd") || pair.equals("pq") || pair.equals("xy"))
					return false;

			}
		}
		return vowelTotal >= 3 && pairs;
		
	}

	public static void main(String[] args) {
		try(BufferedReader inFile = new BufferedReader(new FileReader(new File("./src/input.txt")))){
			String line = inFile.readLine();
			
			int count = 0;
			int count2 = 0;
			
			while(line != null) {
				if(naughtyOrNice(line)) count++;
				if(naughtyOrNiceRevised(line)) count2++;
				line = inFile.readLine();
			}
			
			System.out.println(count);
			System.out.println(count2);
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
