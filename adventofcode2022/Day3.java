package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
	
	private static int evaluateLetter(Character c) {
		if(Character.isUpperCase(c))
			return c - 'A' + 26;
		else
			return c - 'a';
	}
	
	public static int partOne(String line) {
		int[] prioritiesLeft = new int[52];
		int[] prioritiesRight = new int[52];
		int mid = (int) Math.floor(line.length()/2);
		int priority = 0;
		
		for(int i = 0; i < mid; i++) {
			prioritiesLeft[evaluateLetter(line.charAt(i))]++;
		}
		
		for(int i = mid; i < line.length(); i++) {
			prioritiesRight[evaluateLetter(line.charAt(i))]++;
		}
		
		for(int i = 0; i < 52; i++) {
			if(prioritiesLeft[i] > 0 && prioritiesRight[i] > 0) {
				priority += i + 1;
			}
		}
		
		return priority;
		
	}
	
	public static int partTwo(String first, String second, String third) {
		int[] prioritiesFirst = new int[52];
		int[] prioritiesSecond = new int[52];
		int[] prioritiesThird = new int[52];
		
		for(Character c: first.toCharArray()) {
			prioritiesFirst[evaluateLetter(c)]++;
		}
		
		for(Character c: second.toCharArray()) {
			prioritiesSecond[evaluateLetter(c)]++;
		}
		
		for(Character c: third.toCharArray()) {
			prioritiesThird[evaluateLetter(c)]++;
		}
		
		for(int i = 0; i < 52; i++) {
			if(prioritiesFirst[i] > 0 && prioritiesSecond[i] > 0 && prioritiesThird[i] > 0)
				return i + 1;
		}
		
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try (BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))) {

			String line = inFile.readLine();
			int totalPartOne = 0;
			int totalPartTwo = 0;
			int count = 0;
			
			String firstElf = "";
			String secondElf = "";
			String thirdElf = "";
			
			while (line != null) {
				totalPartOne += partOne(line);
				
				if(count == 0) {
					firstElf = line;
					count++;
				} else if(count == 1) {
					secondElf = line;
					count++;
				}
				else {
					thirdElf = line;
					count = 0;
					totalPartTwo += partTwo(firstElf, secondElf, thirdElf);
				}
				
				line = inFile.readLine();
			}
			
			System.out.println("Total for Part One: " + totalPartOne);
			System.out.println("Total for Part Two: " + totalPartTwo);
			
		}

	}

}
