package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Day5 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Deque<Character> one = new ArrayDeque<>();
		one.addAll(Arrays.asList('P', 'Z', 'M', 'T', 'R', 'C', 'N'));
		Deque<Character> two = new ArrayDeque<>();
		two.addAll(Arrays.asList('Z', 'B', 'S', 'T', 'N', 'D'));
		Deque<Character> three = new ArrayDeque<>();
		three.addAll(Arrays.asList('G', 'T', 'C', 'F', 'R', 'Q', 'H', 'M'));
		Deque<Character> four = new ArrayDeque<>();
		four.addAll(Arrays.asList('Z', 'R', 'G'));
		Deque<Character> five = new ArrayDeque<>();
		five.addAll(Arrays.asList('H', 'R', 'N', 'Z'));
		Deque<Character> six = new ArrayDeque<>();
		six.addAll(Arrays.asList('D', 'L', 'Z', 'P', 'W', 'S', 'H', 'F'));
		Deque<Character> seven = new ArrayDeque<>();
		seven.addAll(Arrays.asList('M', 'G', 'C', 'R', 'Z', 'D', 'W'));
		Deque<Character> eight = new ArrayDeque<>();
		eight.addAll(Arrays.asList('Q', 'Z', 'W', 'H', 'L', 'F', 'J', 'S'));
		Deque<Character> nine = new ArrayDeque<>();
		nine.addAll(Arrays.asList('N', 'W', 'P', 'Q', 'S'));
		
		List<Deque<Character>> list = new ArrayList<>();
		list.addAll(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
		
		
		try (BufferedReader inFile = new BufferedReader(new FileReader("./src/input.txt"))) {
			String line = inFile.readLine();
			
			while(line != null) {
				String[] data = line.split(" ");
				int amount = Integer.parseInt(data[1]);
				int from = Integer.parseInt(data[3])-1;
				int to = Integer.parseInt(data[5])-1;
				
				Deque<Character> tempStack = new ArrayDeque<>();
				
				while(amount > 0) {
					tempStack.push(list.get(from).pop());
					//list.get(to).push(list.get(from).pop());
					amount--;
				}
				
				while(!tempStack.isEmpty())
					list.get(to).push(tempStack.pop());
				
				line = inFile.readLine();
			}
			
			System.out.println("Answer");
			list.stream().forEach(d -> System.out.print(d.peek()));
			System.out.println();
		}

	}

}
