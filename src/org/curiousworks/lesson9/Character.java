package org.curiousworks.lesson9;

import java.util.List;

public class Character {

	private String name;
	private String allegiance;
	private String fileName;

	private List<String> messages;

	private static String[] positive = { "😄", "🙂", "😊", "😍" };
	private static String[] negative = { "😢", "😭", "😞", "👿" };
	private static String[] loving = { "😍", "😘" };

	public Character(String name, String allegiance, String fileName) {
		this.name = name;
		this.allegiance = allegiance;
		this.fileName = fileName;
		this.messages = FileHelper.loadMessages(fileName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.messages = FileHelper.loadMessages(fileName);
	}

	public List<String> getMessages() {
		return this.messages;
	}

	public void printMessages() {
		for (String message : this.messages) {
			System.out.println(message);
		}
		System.out.println();
	}

	public int calculateDisposition() {
		int disposition = 0;
		for (String message : this.messages) {
			if (message.contains(positive[0]) || message.contains(positive[1]) || message.contains(positive[2])
					|| message.contains(positive[3])) {
				disposition++;
//				System.out.println("positive: " + message);
			} else if (message.contains(negative[0]) || message.contains(negative[1]) || message.contains(negative[2])
					|| message.contains(negative[3])) {
				disposition--;
//				System.out.println("negative: " + message);
			}
		}
//		System.out.println("disposition: " + disposition);
		return disposition;
	}

	public void printDisposition() {
		int disposition = calculateDisposition();
		if (disposition > 0) {
			System.out.println(this.name + " has a positive dispositon.\n");
		} else if (disposition < 0) {
			System.out.println(this.name + " has a negative dispositon.\n");
		} else {
			System.out.println(this.name + " has a neutral dispositon.\n");
		}
	}

	public int calculateLove(Character person) {
		int love = 0;
		for (String message : this.messages) {
			if ((message.contains(loving[0]) || message.contains(loving[1])) && message.contains(person.getName())) {
				love++;
//				System.out.println("loving: " + message);
			}
		}
//		System.out.println("disposition: " + love);
		return love;
	}

}
