package adventofcode2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {

	public static void turnOnLights(boolean[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {

		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				lights[i][j] = true;
			}
		}

	}

	public static void brightenLights(int[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				lights[i][j]++;
			}
		}
	}

	public static void toggleLights(boolean[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				lights[i][j] = !lights[i][j];
			}
		}
	}

	public static void toggleBrightLights(int[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				lights[i][j] += 2;
			}
		}
	}

	public static void turnOffLights(boolean[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {

		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				lights[i][j] = false;
			}
		}
	}

	public static void dimLights(int[][] lights, int rowStart, int rowEnd, int colStart, int colEnd) {
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				if(lights[i][j] > 0)
					lights[i][j]--;
			}
		}
	}

	public static int calculateTotalLightsOn(boolean[][] lights) {
		int total = 0;

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (lights[i][j])
					total++;
			}
		}

		return total;
	}

	public static int calculateTotalBrightness(int[][] lights) {
		int total = 0;

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				total+=lights[i][j];
			}
		}

		return total;
	}

	public static void main(String[] args) {
		boolean[][] lights = new boolean[1000][1000];
		int[][] brightLights = new int[1000][1000];

		try (BufferedReader inFile = new BufferedReader(new FileReader(new File("./src/input.txt")))) {
			String line = inFile.readLine();

			while (line != null) {
				String[] input = line.split(" ");

				if (input[0].equals("toggle")) {
					String[] start = input[1].split(",");
					String[] end = input[3].split(",");
					toggleLights(lights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
							Integer.parseInt(start[1]), Integer.parseInt(end[1]));
					toggleBrightLights(brightLights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
							Integer.parseInt(start[1]), Integer.parseInt(end[1]));
				} else {
					String[] start = input[2].split(",");
					String[] end = input[4].split(",");
					if (input[1].equals("on")) {
						turnOnLights(lights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
								Integer.parseInt(start[1]), Integer.parseInt(end[1]));
						brightenLights(brightLights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
								Integer.parseInt(start[1]), Integer.parseInt(end[1]));
					} else {
						turnOffLights(lights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
								Integer.parseInt(start[1]), Integer.parseInt(end[1]));
						dimLights(brightLights, Integer.parseInt(start[0]), Integer.parseInt(end[0]),
								Integer.parseInt(start[1]), Integer.parseInt(end[1]));
					}
				}

				line = inFile.readLine();
			}

			System.out.println("Total lights: " + calculateTotalLightsOn(lights));
			System.out.println("Total Brightness: " + calculateTotalBrightness(brightLights));

		} catch (IOException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
