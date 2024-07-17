import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static HashMap<String, String> yoruba = new HashMap<>();
    public static String word, filePath, line;
    public static void main(String[] args) {
        System.out.println("---------------Yoruba Translator---------------");


        System.out.print("Input a word: ");
        Scanner translateS = new Scanner(System.in);
        String sentence = translateS.nextLine();
        word = sentence.toLowerCase();
        translator();


    }

    public static void translator() {
        // Path to the dictionary file
        filePath = "C:\\Users\\Covenant\\IdeaProjects\\Yoruba Translator\\src\\yoruba.txt";

        // Read the file and populate the HashMap
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // Split each line into key and value
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    yoruba.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Find and print the key for the given word
        String key = findKeyByValue(yoruba, word);
        if (key != null) {
            System.out.println("The translation for the word " + word + " is " + key);
        } else {
            System.out.println("The word " + word + " is not found.");
        }
    }

    // Method to find the key for a given value
    public static String findKeyByValue(HashMap<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // Return null if the value is not found
    }


}