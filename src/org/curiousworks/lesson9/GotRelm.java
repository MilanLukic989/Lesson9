package org.curiousworks.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GotRelm {
	private ArrayList<Character> characters;

	public GotRelm() {
		characters = new ArrayList<Character>();
	}

	public void createCharacters() {
		String metadata = FileHelper.loadMetaData();

		List<String> items = Arrays.asList(metadata.split(", |" + System.getProperty("line.separator")));

		for (int i = 3; i < items.size(); i += 3) {
			characters.add(new Character(items.get(i), items.get(i + 1), items.get(i + 2)));
		}
	}

	// in case we want to add more characters
	public void add(Character character) {
		characters.add(character);
	}

	public Character findCharacter(String name) throws NullPointerException {
		for (Character characterObj : characters) {
			if (characterObj.getName().equals(name)) {
				return characterObj;
			}
		}
		return null;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void printMostPositiveAndNegative() {
		int mostPositive = Integer.MIN_VALUE;
		String mostPositiveName = "";

		int mostNegative = Integer.MAX_VALUE;
		String mostNegativeName = "";

		int disp;
		for (Character person : characters) {
			disp = person.calculateDisposition();

			if (disp > mostPositive) {
				mostPositiveName = person.getName();
				mostPositive = disp;
			}
			if (disp < mostNegative) {
				mostNegativeName = person.getName();
				mostNegative = disp;
			}
		}
		System.out.println("Most positive character is: " + mostPositiveName + " with disposition: " + mostPositive);
		System.out.println("Most negative character is: " + mostNegativeName + " with disposition: " + mostNegative);
		System.out.println();
	}

	public static void calculateRelationship(Character person1, Character person2) {
		int person1love = person1.calculateLove(person2);
		int person2love = person2.calculateLove(person1);

		if (person1love > person2love) {
			System.out.println(person1.getName() + " loves " + person2.getName() + " more than opposite.");
		} else if (person1love < person2love) {
			System.out.println(person2.getName() + " loves " + person1.getName() + " more than opposite.");
		} else {
			System.out.println(person1.getName() + " and  " + person2.getName() + " love each other equally.");
		}
	}

}
