package lab17;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesApp {

	private static Path filePath = Paths.get("countries.txt");
	
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		int userChoice;
		// Country c = new Country(name, population);
		
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		
		do {
			
			userChoice = Validator.getInt(scnr, "Please enter a number from the list below \n 1 - see list of countries \n 2 - Add a country \n 3 - Exit", 1, 3);
		
		
			if (userChoice == 1) {
				try {
					CountriesTextFile.checkForFile(filePath);
					for (Country c : CountriesTextFile.readFile()) {
						System.out.println(c);
					}
					CountriesTextFile.readFile();
					} catch (IndexOutOfBoundsException e) {
					
				}
			
				
			}
		
			else if (userChoice == 2) {
				System.out.println("Please enter country: ");
				String name = scnr.nextLine();
				System.out.println("Please enter population: ");
				int population = scnr.nextInt();
				Country c1 = new Country(name, population);
				CountriesTextFile.appendToFile(c1);
		
			} else if (userChoice == 3) {
			
				System.out.println("Goodbye");
			
			} else {
			
				System.out.println("You entered an invalid choice. Please enter 1, 2, or 3");
			}
		
		} while (userChoice != 3);
		
		scnr.close();

	}

}
