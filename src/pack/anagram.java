package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class anagram {

	public static void main(String[] args) throws IOException {
		String word = anagram.getWord();
		if(!anagram.getAnagrams(word).isEmpty()) {
			System.out.println("The anagrams of " + word + " are: ");
			for(int i = 0; i < anagram.getAnagrams(word).size(); i++) {
				System.out.println(anagram.getAnagrams(word).get(i) + ",");
			}
		} else {
			System.out.println(word + " has no anagrams ;-(");
		}
	}

	public static ArrayList<String> getAnagrams(String word) throws IOException{
		File words = new File("words.txt");
		FileReader fr = new FileReader(words);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> anagrams = new ArrayList<String>();
		String line = "";
		while((line = br.readLine()) != null) {
			if(line.length() == word.length()) {
				int check = 0;
				for(int i = 0; i < word.length(); i++) {
					if(line.contains(word.substring(i, i+1))) {
						check++;
					} 
				} 
				
				if(check == word.length()) {
					if(!word.equals(line)) {
						anagrams.add(line);
					}
				}
			}
		}
		return anagrams;
	}

	public static String getWord() {
		String input = JOptionPane.showInputDialog("What word do you want the anagrams of?");
		return input;
	}
}
