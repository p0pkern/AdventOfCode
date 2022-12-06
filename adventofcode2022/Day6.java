package adventofcode2022;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Day6 {
	
	public static int dayOne() throws FileNotFoundException, IOException {
		try(FileReader inFile = new FileReader("./src/input.txt")) {
			int data = inFile.read();
			Deque<Character> code = new ArrayDeque<>();
			int marker = 0;
			char letter = ' ';
			while(data != -1) {
				letter =  (char) data;
				if(code.size() == 0)
					code.offer(letter);
				else {
					while(code.contains(letter)) {
						code.poll();
					}
					while(code.size() > 4) {
						code.poll();
					}
					if(code.size() == 4) break;
					code.offer(letter);
				}
				marker++;
				data = inFile.read();
			}
			
			return marker;
		}
	}
	
	public static int dayTwo() throws FileNotFoundException, IOException {
		try(BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))) {
			Deque<Character> code = new ArrayDeque<>();
			int marker = 0;
			int data = inFile.read();
			
			while(data != -1) {
				char letter = (char) data;
				
				if(code.isEmpty())
					code.add(letter);
				else {
					while(code.contains(letter))
						code.poll();
					
					code.add(letter);
				}
				marker++;
				if(code.size() == 14) break;
				data = inFile.read();
			}
			
			
			return marker;
		}
			
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("Part One: " + dayOne());
		System.out.println("Part Two: " + dayTwo());
	}

}
