package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2 {
	public static int partOne(String[] round) {
		// Rock - A/X
		// Paper - B/Y
		// Scissors - C/Z
		int currRound = 0;
		
		System.out.println(round[0] + " " + round[1]);
		
		if(round[1].equals("X")) {
			currRound++;
			if(round[0].equals("A"))
				currRound+=3;
			else if(round[0].equals("C"))
				currRound+=6;
		} else if(round[1].equals("Y")) {
			currRound+=2;
			if(round[0].equals("B"))
				currRound+=3;
			else if(round[0].equals("A"))
				currRound+=6;
		} else {
			currRound+=3;
			if(round[0].equals("C"))
				currRound+=3;
			else if(round[0].equals("B"))
				currRound+=6;
		}
		System.out.println(currRound);
		return currRound;
	}
	
	public static int partTwo(String[] round) {
		// Rock - A
		// Paper - B
		// Scissors - C
		int currRound = 0;
		
		// Lose - X
		if(round[1].equals("X")) {
			// Rock - Lose with Scissors
			if(round[0].equals("A"))
				currRound+=3;
			// Paper - Lose with Rock
			else if(round[0].equals("B"))
				currRound++;
			// Scissors - Lose with Paper
			else
				currRound+=2;
		
		// Draw - Y
		} else if(round[1].equals("Y")) {
			// 3 Points for a draw
			currRound+=3;
			// Rock - Draw with Rock
			if(round[0].equals("A"))
				currRound++;
			// Paper - Draw with Paper
			else if(round[0].equals("B"))
				currRound+=2;
			// Scissors - Draw with Scissors
			else
				currRound+=3;
		// Win - Z
		} else {
			// Win 6 points
			currRound+=6;
			// Rock - Win with Paper
			if(round[0].equals("A"))
				currRound+=2;
			// Paper - Win with Scissors
			else if(round[0].equals("B"))
				currRound+=3;
			// Scissors - Win with Rock
			else
				currRound++;
		}
		
		return currRound;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))){
			
			String line = inFile.readLine();
			int partOneTotal = 0;
			int partTwoTotal = 0;
			
			while(line != null) {
				
				String[] round = line.split(" ");
				partOneTotal += partOne(round);
				partTwoTotal += partTwo(round);
				line = inFile.readLine();
				
			}
			
			System.out.println("Part One: " + partOneTotal);
			System.out.println("Part Two: " + partTwoTotal);
			
		}

	}

}
