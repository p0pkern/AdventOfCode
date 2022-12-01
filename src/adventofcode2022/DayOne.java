package adventofcode2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


public class DayOne {
	public static void main(String[] args) {
		// A max heap to keep the totals in highest to lowest order for part 2
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		
		try(BufferedReader inFile = new BufferedReader(new FileReader(args[0]));) {
			String line = inFile.readLine();
			int topThreeTotal = 0;
			int currCalories = 0;
			
			// Going line by line until a blank line is reached the numbers are
			// totaled. After a blank line the current calories are added to the 
			// max heap.
			while(line != null) {
				if(!line.equals(""))
					currCalories += Integer.parseInt(line);
				else {
					queue.offer(currCalories);
					currCalories = 0;
				}
				
				line = inFile.readLine();
			}
			
			// Look at the first value (highest) in the queue without removing it
			System.out.println("Highest Calories: " + queue.peek());
			
			// Remove and total the top three values
			for(int i = 0; i < 3; i++)
				topThreeTotal += queue.poll();
			
			System.out.println("Total of top three: " + topThreeTotal);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
