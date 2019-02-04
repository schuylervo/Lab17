package lab17;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CountriesApp {

	
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		int userChoice;
		
		
		CountriesTextFile.createNewFile("countries.txt");
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		
		do {
			
			userChoice = Validator.getInt(scnr, "\nPlease enter a number from the list below \n 1 - see list of countries \n 2 - Add a country \n 3 - Exit \n", 1, 3);
		
		
			if (userChoice == 1) {
				try {
					
					// create new countries.txt file if one does not already exist
					CountriesTextFile.createNewFile("countries.txt");
					System.out.println("Country, Population");
					for (Country c : CountriesTextFile.readFile()) {
						System.out.println(c);
					}
					CountriesTextFile.readFile();
					} catch (InputMismatchException e) {
				System.out.println("Please input a number.");	
				}
			
				
			}
		
			else if (userChoice == 2) {
				
				String name= Validator.getString(scnr, "Please enter country: ");
				int population= Validator.getInt(scnr, "Please enter population: ");
				Country c = new Country(name, population);
				CountriesTextFile.appendToFile(c);
		
			} else if (userChoice == 3) {
			
				System.out.println("Goodbye");
			
			} else {
			
				System.out.println("You entered an invalid choice. Please enter 1, 2, or 3");
			}
		
		} while (userChoice != 3);
		
		scnr.close();

	}

}
