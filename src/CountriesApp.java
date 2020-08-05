import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class CountriesApp {
	
	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a command (list, add, quit): ");
			String command = scnr.nextLine();
			if (command.equals("quit")) {
				break;
			} else if (command.equals("list")) {
				List<Country> things = readFile();
				int i = 1; 
				for (Country thing : things) {
					System.out.println(thing.getname() + " (pop " + thing.getpopulation() + ") - Warm Climate? " + thing.warmClimate());
				}
			} else if (command.equals("add")) {
				Country Country = getCountryFromUser(scnr);
				System.out.println("Adding " + Country);
				appendLineToFile(Country);
			} else {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("Goodbye.");
		scnr.close();
	}
	
	private static Country getCountryFromUser(Scanner scnr) {
		// #1 adjust this for your class, not Country
		String name = Validator.getString(scnr, "Enter name: ");
		int population = Validator.getInt(scnr, "Enter population number: ");
		boolean warmClimate = Validator.getYesNo(scnr, "Is the Country a warm climate (yes/no)? ");
		return new Country(name, population, warmClimate);
	}

	public static List<Country> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> Country = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String name = parts[0];
				int population = Integer.parseInt(parts[1]);
				boolean warmClimate = Boolean.parseBoolean(parts[2]);
				Country.add(new Country(name, population, warmClimate));
			}
			
			return Country;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}

	public static void appendLineToFile(Country thing) {
		String line = thing.toString();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}

}