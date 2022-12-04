package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day4 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))) {
			
			String line = inFile.readLine();
			
			int completeOverlap = 0;
			int anyOverlap = 0;
			
			while(line != null) {
				String[] pairs = line.split(",");
				String[] firstElf = pairs[0].split("-");
				String[] secondElf = pairs[1].split("-");
				int fStart = Integer.parseInt(firstElf[0]);
				int sStart = Integer.parseInt(secondElf[0]);
				int fEnd = Integer.parseInt(firstElf[1]);
				int sEnd = Integer.parseInt(secondElf[1]);
				
				Arrays.stream(pairs).forEach(System.out::print);
				System.out.println();
				
				if(fStart >= sStart && fEnd <= sEnd) completeOverlap++;
				else if(sStart >= fStart && sEnd <= fEnd) completeOverlap++;
				
				if(fStart >= sStart && fStart <= sEnd) anyOverlap++;
				else if(fEnd <= sEnd && fEnd >= sStart) anyOverlap++;
				else if(sStart >= fStart && sStart <= fEnd) anyOverlap++;
				else if(sEnd <= fEnd && sEnd >= fStart) anyOverlap++;
				
				line = inFile.readLine();
			}
			
			System.out.println("Complete Overlap: " + completeOverlap);
			System.out.println("Any Overlap: " + anyOverlap);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
