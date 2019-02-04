package lab17;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {
	
	
	private static Path filePath = Paths.get("countries.txt");
	
	
	public static void createNewFile(String pathName) {
		Path path = Paths.get(pathName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File created at " + path.toAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void checkForFile (Path filePath) throws IOException {
		try {
			filePath = Paths.get("countries.txt");
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
			}
		}catch (IOException e) {
				// e.printStackTrace();
				System.out.println("Something went wrong");
			
		}
	}
	

	
	public static List<Country> readFile() throws IOException {
		List<String> lines = Files.readAllLines(filePath);
		List<Country> countries = new ArrayList<>();
		for (String line: lines) {
			String [] parts = line.split(",");
			Country c = new Country(parts[0], Integer.parseInt(parts[1]));
			countries.add(c);
		}
		return countries;
	} 
	
	public static void appendToFile(Country country) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		String country1 = country.getName() + "," + country.getPopulation();
		List<String> countryList = Arrays.asList(country1);
		Files.write(filePath, countryList, StandardOpenOption.APPEND);
	}
	
}