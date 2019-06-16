package org.curiousworks.lesson9;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		GotRelm gotRelm = new GotRelm();
		gotRelm.createCharacters();

		// Task 2.

		String name = "Daenerys Stormborn";
		Character daenerysTmp = gotRelm.findCharacter(name);
		if (daenerysTmp != null) {
			daenerysTmp.printMessages();
		} else {
			System.out.println("Character with name " + name + " does not exist.");
		}

		// Task 3.
		for (Character person : gotRelm.getCharacters()) {
			JOptionPane.showMessageDialog(null,
					person.getName() + " number of messages: " + (person.getMessages().size() - 1));
		}

		// Task 4.1

		try {
			gotRelm.findCharacter("Tyrion Lannister").printDisposition();
		} catch (NullPointerException ex) {
			System.out.println("Character with that name does not exist.");
		}

		// Task 4.2
		gotRelm.printMostPositiveAndNegative();

		// Task 4.3.

		try {
			GotRelm.calculateRelationship(gotRelm.findCharacter("Daenerys Stormborn"),
					gotRelm.findCharacter("Jon Snow"));
		} catch (NullPointerException ex) {
			System.out.println("Character with that name does not exist.");
		}

	}

}
