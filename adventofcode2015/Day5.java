package adventofcode2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
	
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
		boolean pairs = false;
		boolean repeat = false;
		
		int pairIndex = 0;
		
		for(int i = 0; i < line.length()-2; i++) {
			String pair1 = line.substring(i, i+2);
			pairIndex = i + 2;
			
			while(pairIndex < line.length() - 1) {
				String pair2 = line.substring(pairIndex, pairIndex+2);
				if(pair1.equals(pair2)) {
					System.out.println(pair1 + " " + pair2);
					pairs = true;
					break;
				}
				pairIndex++;
			}
			
			if(pairs)
				break;
		}
		
		for(int i = 1; i < line.length() - 1; i++) {
			if(line.charAt(i-1) == line.charAt(i+1)) {
				repeat = true;
				break;
			}
		}
		
		return pairs && repeat;
		
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
